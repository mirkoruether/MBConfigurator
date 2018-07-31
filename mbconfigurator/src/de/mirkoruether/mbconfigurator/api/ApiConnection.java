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

import de.mirkoruether.util.http.InternetUtil;
import de.mirkoruether.util.http.UrlBuilder;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Map;
import java.util.logging.Logger;

public class ApiConnection
{
    public static final String BASE_URL = "https://api.mercedes-benz.com/configurator/v1";

    private static final Logger logger = Logger.getLogger(ApiConnection.class.getName());
    private final String apikey;

    private final FolderCache cache;

    public ApiConnection(String apikey, File cacheFolder)
    {
        this.apikey = apikey;
        this.cache = new FolderCache(cacheFolder);
    }

    public void clearCache()
    {
        cache.clearFolder();
    }

    public String getResponse(String path, Map<String, String> query)
    {
        String urlStart = BASE_URL;
        if(!path.startsWith("/"))
            urlStart += "/";
        urlStart += path;

        return getResponse(new UrlBuilder(urlStart, query));
    }

    public String getResponse(String url)
    {
        return getResponse(new UrlBuilder(url));
    }

    public String getResponse(UrlBuilder req)
    {
        req.removeQueryArgs("apikey");
        req.sortQuery(null);

        String cacheKey = req.toString();

        String c = cache.getResponse(cacheKey);
        if(c != null)
            return c;

        req.getQuery().add("apikey=" + apikey);

        String response = InternetUtil.httpsGET(req.toUrl());
        cache.putResponse(cacheKey, response);
        return response;
    }

    public BufferedImage getImage(String url)
    {
        BufferedImage c = cache.getImage(url);
        if(c != null)
            return c;

        BufferedImage result = InternetUtil.downloadImage(url);
        cache.putImage(url, result);
        return result;
    }
}
