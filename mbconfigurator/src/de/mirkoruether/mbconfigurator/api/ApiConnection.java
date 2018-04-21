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

import de.mirkoruether.util.LinqList;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.HttpsURLConnection;

public class ApiConnection
{
    public static final String BASE_URL = "https://api.mercedes-benz.com/configurator/v1";

    private static final Logger logger = Logger.getLogger(ApiConnection.class.getName());
    private final ArrayList<String> apikeys;

    private final FolderCache cache;

    public ApiConnection()
    {
        this(new ArrayList<>());
    }

    public ApiConnection(ArrayList<String> apikeys)
    {
        this.apikeys = apikeys;
        this.cache = new FolderCache(new File(System.getProperty("java.io.tmpdir"), "MBConfigurator"));
    }

    private String getResponse(String path, Map<String, String> query)
    {
        String url = BASE_URL;
        if(!path.startsWith("/"))
            url += "/";
        url += path;

        if(query != null && !query.isEmpty())
        {
            url += "?";
            for(Map.Entry<String, String> e : query.entrySet())
            {
                url += e.getKey() + "=" + e.getValue() + "&";
            }
            url = url.substring(0, url.length() - 1);
        }

        return getResponse0(url);
    }

    private String getResponse0(String urlStringWithoutApikey)
    {
        String c = cache.getResponse(urlStringWithoutApikey);
        if(c != null)
            return c;

        throw new UnsupportedOperationException();
    }

    private String getResponseFromServer(String completeUrl)
    {
        try
        {
            URL url = new URL(completeUrl);
            HttpsURLConnection con = (HttpsURLConnection)url.openConnection();
            con.setRequestMethod("GET");
            BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
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
        catch(IOException ex)
        {
            logger.log(Level.WARNING, ex, () -> "Exception during communication with server");
            throw new RuntimeException(ex);
        }
    }

    private String removeApiKeyAndSortQuery(String urlString)
    {
        String query = urlString.substring(urlString.indexOf('?') + 1,
                                           urlString.contains("#")
                                           ? urlString.indexOf('#')
                                           : urlString.length());

        LinqList<String> queryParts = new LinqList<>(query.split("&"))
                .where(x -> !x.toLowerCase().startsWith("apikey="))
                .sortInline(null);

        String result = urlString.substring(0, urlString.indexOf('?'));

        for(int i = 0; i < queryParts.size(); i++)
        {
            result += i == 0 ? "?" : "&";
            result += queryParts.get(i);
        }

        return result;
    }
}
