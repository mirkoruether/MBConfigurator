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
package de.mirkoruether.mbconfigurator.logic;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AppConfig
{
    @SerializedName("ignoredCodeTypes")
    @Expose
    private List<String> ignoredCodeTypes;

    private AppConfig()
    {
        ignoredCodeTypes = new ArrayList<>();
    }

    public List<String> getIgnoredCodeTypes()
    {
        return ignoredCodeTypes;
    }

    public void setIgnoredCodeTypes(List<String> ignoredCodeTypes)
    {
        this.ignoredCodeTypes = ignoredCodeTypes;
    }

    public static void save(AppConfig cfg, File f)
    {
        try
        {
            try(FileWriter fw = new FileWriter(f);)
            {
                new Gson().toJson(cfg, AppConfig.class, fw);
                fw.flush();
            }
        }
        catch(IOException ex)
        {
            throw new RuntimeException(ex);
        }
    }

    public static AppConfig load(File f)
    {
        try
        {
            try(FileReader fr = new FileReader(f))
            {
                AppConfig cfg = new Gson().fromJson(fr, AppConfig.class);
                if(cfg == null)
                {
                    return getDefault();
                }
                return cfg;
            }
        }
        catch(IOException ex)
        {
            throw new RuntimeException(ex);
        }
    }

    public static AppConfig getDefault()
    {
        AppConfig cfg = new AppConfig();
        cfg.getIgnoredCodeTypes().add("C");
        return cfg;
    }

    public static AppConfig loadOrCreate(File f)
    {
        if(!f.exists())
        {
            save(getDefault(), f);
        }

        return load(f);
    }
}
