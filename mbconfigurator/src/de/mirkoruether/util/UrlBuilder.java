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
package de.mirkoruether.util;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;

public class UrlBuilder
{
    private String path;
    private final LinqList<String> query;

    public UrlBuilder(String path, Map<String, String> queryMap)
    {
        this.path = path;
        this.query = new LinqList<>(queryMap.entrySet())
                .select(x -> x.getKey() + "=" + x.getValue());
    }

    public UrlBuilder(String path, String[] query)
    {
        this.path = path;
        this.query = new LinqList<>(query);
    }

    public UrlBuilder(String path, Collection<String> query)
    {
        this.path = path;
        this.query = new LinqList<>(query);
    }

    public UrlBuilder(String url)
    {
        this.path = url.contains("?") ? url.substring(0, url.indexOf('?')) : url;
        this.query = new LinqList<>(url.substring(url.indexOf('?') + 1, url.length()).split("&"));
    }

    public void removeQueryArgs(String key)
    {
        String keyuc = key.toUpperCase() + "=";
        query.filter(x -> !x.toUpperCase().startsWith(keyuc));
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

    public LinqList<String> getQuery()
    {
        return query;
    }

    public void sortQuery(Comparator<String> c)
    {
        query.sort(c);
    }

    @Override
    public String toString()
    {
        String result = path;
        while(result.endsWith("/"))
        {
            result = result.substring(0, result.length() - 1);
        }

        for(int i = 0; i < query.size(); i++)
        {
            result += i == 0 ? "?" : "&";
            result += query.get(i);
        }
        return result;
    }
}
