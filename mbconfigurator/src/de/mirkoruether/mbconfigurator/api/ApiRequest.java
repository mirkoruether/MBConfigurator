/*
MIT License

Copyright (c) 2018 Mirko Rüther

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
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public class ApiRequest
{
    private String path;
    private String[] query;

    public ApiRequest(String path, Map<String, String> queryMap)
    {
        this.path = path;
        this.query = new LinqList<>(queryMap.entrySet())
                .select(x -> x.getKey() + "=" + x.getValue())
                .toArray(String.class);
    }

    public ApiRequest(String path, String[] query)
    {
        this.path = path;
        this.query = query;
    }

    public ApiRequest(String url)
    {
        this.path = url.substring(0, url.indexOf('?'));
        this.query = url.substring(url.indexOf('?') + 1, url.length())
                .split("&");
    }

    public void removeQueryArgs(String key)
    {
        String keyuc = key.toUpperCase() + "=";
        query = new LinqList<>(query)
                .where(x -> !x.toUpperCase().startsWith(keyuc))
                .toArray(String.class);
    }

    public URL toUrl()
    {
        try
        {
            return new URL(toString());
        }
        catch(MalformedURLException ex)
        {
            throw new RuntimeException(ex);
        }
    }

    public String getPath()
    {
        return path;
    }

    public void setPath(String path)
    {
        this.path = path;
    }

    public String[] getQuery()
    {
        return query;
    }

    public void setQuery(String[] query)
    {
        this.query = query;
    }

    @Override
    public String toString()
    {
        String queryString = "";
        for(int i = 0; i < query.length; i++)
        {
            queryString += i == 0 ? "?" : "&";
            queryString += query[i];
        }
        return queryString;
    }

}
