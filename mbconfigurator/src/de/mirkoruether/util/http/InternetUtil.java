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
package de.mirkoruether.util.http;

import de.mirkoruether.util.http.HTTPCodeException;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.net.ssl.HttpsURLConnection;

public class InternetUtil
{
    public static BufferedImage downloadImage(String url)
    {
        try
        {
            return ImageIO.read(new URL(url));
        }
        catch(IOException ex)
        {
            throw HTTPCodeException.buildException(ex);
        }
    }

    public static String httpsGET(URL url)
    {
        try
        {
            HttpsURLConnection con = (HttpsURLConnection)url.openConnection();
            con.setRequestMethod("GET");
            return readStream(con.getInputStream());
        }
        catch(IOException ex)
        {
            throw HTTPCodeException.buildException(ex);
        }
    }

    private static String readStream(InputStream is) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();

        String line = reader.readLine();
        while(line != null)
        {
            sb.append(line);
            sb.append("\n");
            line = reader.readLine();
        }

        return sb.toString();
    }

    private InternetUtil()
    {
    }
}
