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
package de.mirkoruether.util.http;

import de.mirkoruether.util.LinqList;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import org.apache.commons.lang3.builder.CompareToBuilder;

public class UrlBuilder
{
    private String path;
    private final LinqList<QueryEntry> query;

    public UrlBuilder(String path, Map<String, String> queryMap)
    {
        this.path = path;
        this.query = new LinqList<>(queryMap.entrySet())
                .select(x -> new QueryEntry(x.getKey(), x.getValue()));
    }

    public UrlBuilder(String path, String[] query)
    {
        this(path, new LinqList<>(query));
    }

    public UrlBuilder(String path, Collection<String> query)
    {
        this.path = path;
        this.query = new LinqList<>(query).select(s -> generateEntry(s));
    }

    public UrlBuilder(String url)
    {
        this.path = url.contains("?") ? url.substring(0, url.indexOf('?')) : url;
        this.query = new LinqList<>(url.substring(url.indexOf('?') + 1, url.length()).split("&"))
                .select(s -> generateEntry(s));
    }

    public void removeQueryArgs(String key)
    {
        query.filter(x -> !x.getKey().toUpperCase().equals(key.toUpperCase()));
    }

    public URL toUrl()
    {
        try
        {
            String url = toString();
            return new URL(url);
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

    public LinqList<QueryEntry> getQuery()
    {
        return query;
    }

    public void sortQuery(Comparator<QueryEntry> c)
    {
        query.sort(c);
    }

    @Override
    public String toString()
    {
        String result = escapeCharsExceptFirstPart(path);
        while(result.endsWith("/"))
        {
            result = result.substring(0, result.length() - 1);
        }

        for(int i = 0; i < query.size(); i++)
        {
            result += i == 0 ? "?" : "&";
            result += query.get(i).toString();
        }
        return result;
    }

    private static String escapeChars(String s)
    {
        return escapeCharsExceptFirstPart(s)
                .replaceAll("\\:", "%3A")
                .replaceAll("/", "%2F");
    }

    private static String escapeCharsExceptFirstPart(String s)
    {
        return s
                .replaceAll(" ", "%20")
                .replaceAll("\\<", "%3C")
                .replaceAll("\\>", "%3E")
                .replaceAll("\\#", "%23")
                .replaceAll("\\%", "%25")
                .replaceAll("\\{", "%7B")
                .replaceAll("\\}", "%7D")
                .replaceAll("\\|", "%7C")
                .replaceAll("\\\\", "%5C")
                .replaceAll("\\^", "%5E")
                .replaceAll("\\~", "%7E")
                .replaceAll("\\[", "%5B")
                .replaceAll("\\]", "%5D")
                .replaceAll("\\`", "%60")
                .replaceAll("\\;", "%3B")
                .replaceAll("\\?", "%3F")
                .replaceAll("\\@", "%40")
                .replaceAll("\\=", "%3D")
                .replaceAll("\\&", "%26")
                .replaceAll("\\$", "%24");
    }

    private static QueryEntry generateEntry(String queryPart)
    {
        String[] parts = queryPart.split("=", 2);
        return new QueryEntry(parts[0], parts[1]);
    }

    public static class QueryEntry implements Comparable<QueryEntry>
    {
        private String key;
        private String value;

        public QueryEntry(String key, String value)
        {
            this.key = key;
            this.value = value;
        }

        @Override
        public int compareTo(QueryEntry o)
        {
            return new CompareToBuilder()
                    .append(key, o == null ? null : o.getKey())
                    .append(value, o == null ? null : o.getValue())
                    .build();
        }

        public String getKey()
        {
            return key;
        }

        public void setKey(String key)
        {
            this.key = key;
        }

        public String getValue()
        {
            return value;
        }

        public void setValue(String value)
        {
            this.value = value;
        }

        @Override
        public String toString()
        {
            return escapeChars(key) + "=" + escapeChars(value);
        }
    }
}
