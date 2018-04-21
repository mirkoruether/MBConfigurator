/*
MIT License

Copyright (c) 2018 Mirko RÃ¼ther

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
 */
package de.mirkoruether.mbconfigurator.api;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import org.apache.commons.io.FileUtils;
import static java.nio.charset.StandardCharsets.UTF_8;

public class FolderCache
{
    private final static Logger logger = Logger.getLogger(FolderCache.class.getName());

    private final HashMap<String, String> responses;
    private final HashMap<String, String> images;

    private final File folder;

    public FolderCache(File folder)
    {
        responses = new HashMap<>();
        images = new HashMap<>();
        this.folder = folder;

        loadMaps();
    }

    public void clear()
    {
        responses.clear();
        images.clear();
    }

    public void clearFolder()
    {
        clear();
        deleteFolder(folder);
    }

    private static void deleteFolder(File folder)
    {
        File[] files = folder.listFiles();
        if(files != null)
        { //some JVMs return null for empty dirs
            for(File f : files)
            {
                if(f.isDirectory())
                {
                    deleteFolder(f);
                }
                else
                {
                    f.delete();
                }
            }
        }
        folder.delete();
    }

    public void loadMaps()
    {
        clear();
        try
        {
            File resp = new File(folder, "__responses__");
            loadAndPut(resp, responses);
        }
        catch(Exception ex)
        {
            logger.log(Level.WARNING, "Failed to load response cache!", ex);
        }

        try
        {
            File im = new File(folder, "__images__");
            loadAndPut(im, images);
        }
        catch(Exception ex)
        {
            logger.log(Level.WARNING, "Failed to load image cache!", ex);
        }
    }

    private void loadAndPut(File file, HashMap<String, String> map) throws IOException
    {
        if(file.exists())
        {
            for(String line : FileUtils.readFileToString(file, UTF_8).split("\n"))
            {
                String[] parts = line.trim().split(":", 2);
                if(parts.length != 2)
                    continue;
                map.put(parts[1], parts[0]);
            }
        }
    }

    public void saveMaps()
    {
        try
        {
            File resp = new File(folder, "__responses__");
            save(resp, responses);
        }
        catch(Exception ex)
        {
            logger.log(Level.WARNING, "Failed to save response cache index!", ex);
        }

        try
        {
            File im = new File(folder, "__images__");
            save(im, images);
        }
        catch(Exception ex)
        {
            logger.log(Level.WARNING, "Failed to save image cache index!", ex);
        }
    }

    private void save(File file, HashMap<String, String> map) throws IOException
    {
        file.getParentFile().mkdirs();
        try(PrintWriter pw = new PrintWriter(file, UTF_8.name()))
        {
            for(Map.Entry<String, String> e : map.entrySet())
            {
                pw.print(e.getValue().trim());
                pw.print(":");
                pw.print(e.getKey().trim());
                pw.println();
            }
        }
    }

    public BufferedImage getImage(String url)
    {
        if(!images.containsKey(url))
            return null;

        try
        {
            return ImageIO.read(new File(folder, images.get(url)));
        }
        catch(IOException ex)
        {
            logger.log(Level.WARNING, "Failed to load cached image for url " + url, ex);
            return null;
        }
    }

    public void putImage(String url, BufferedImage image)
    {
        try
        {
            String fileName = UUID.randomUUID().toString() + ".png";
            ImageIO.write(image, "png", new File(folder, fileName));
            images.put(url, fileName);
        }
        catch(IOException ex)
        {
            logger.log(Level.WARNING, "Failed to cache image for url " + url, ex);
        }
    }

    public String getResponse(String url)
    {
        if(!responses.containsKey(url))
            return null;

        try
        {
            return FileUtils.readFileToString(new File(folder, responses.get(url)), UTF_8);
        }
        catch(IOException ex)
        {
            logger.log(Level.WARNING, "Failed to load cached image for url " + url, ex);
            return null;
        }
    }

    public void putResponse(String url, String json)
    {
        try
        {
            String fileName = UUID.randomUUID().toString() + ".json";
            FileUtils.writeStringToFile(new File(folder, fileName), json, UTF_8);
            responses.put(url, fileName);
        }
        catch(IOException ex)
        {
            logger.log(Level.WARNING, "Failed to cache response for url " + url, ex);
        }
    }
}
