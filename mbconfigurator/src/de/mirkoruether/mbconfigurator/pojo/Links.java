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
package de.mirkoruether.mbconfigurator.pojo;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Links implements Serializable
{
    private static final long serialVersionUID = 4375645848329330998L;
    private Map<String, String> links;

    public Links()
    {
    }

    public Links(Map<String, String> links)
    {
        this.links = links;
    }

    public String getLink(String key)
    {
        return (links == null || !links.containsKey(key)) ? null : links.get(key);
    }

    public Map<String, String> getLinks()
    {
        return links;
    }

    public void setLinks(Map<String, String> links)
    {
        this.links = links;
    }

    public Links withLinks(Map<String, String> links)
    {
        this.links = links;
        return this;
    }

    @Override
    public int hashCode()
    {
        return new HashCodeBuilder()
                .append(links)
                .toHashCode();
    }

    @Override
    public boolean equals(Object other)
    {
        if(other == this)
        {
            return true;
        }
        if((other instanceof Links) == false)
        {
            return false;
        }
        Links rhs = ((Links)other);
        return new EqualsBuilder()
                .append(links, rhs.links)
                .isEquals();
    }

    public static class Deserializer implements JsonDeserializer<Links>
    {
        @Override
        public Links deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException
        {
            JsonObject obj = json.getAsJsonObject();
            Map<String, String> map = new HashMap<>();
            for(Map.Entry<String, JsonElement> e : obj.entrySet())
            {
                map.put(e.getKey(), e.getValue().getAsString());
            }
            return new Links(map);
        }
    }

    public static class Serializer implements JsonSerializer<Links>
    {
        @Override
        public JsonElement serialize(Links src, Type typeOfSrc, JsonSerializationContext context)
        {
            if(src == null)
                return null;
            JsonObject obj = new JsonObject();

            if(src.getLinks() != null)
            {
                for(Map.Entry<String, String> e : src.getLinks().entrySet())
                {
                    obj.add(e.getKey(), new JsonPrimitive(e.getValue()));
                }
            }

            return obj;
        }
    }
}
