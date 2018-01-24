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

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GsonUtils
{
    private GsonUtils()
    {
    }

    public static <T> List<T> getListFromObjectList(JsonElement objectListElement, JsonDeserializationContext context, Type tType)
    {
        Set<Map.Entry<String, JsonElement>> set = objectListElement.getAsJsonObject().entrySet();
        List<T> list = new ArrayList<>();
        for(Map.Entry<String, JsonElement> e : set)
        {
            list.add(context.deserialize(e.getValue(), tType));
        }
        return list;
    }

    public static <T> List<T> getListFromArray(JsonElement arrayElement, JsonDeserializationContext context, Type tType)
    {
        JsonArray array = arrayElement.getAsJsonArray();
        List<T> list = new ArrayList<>();
        for(JsonElement e : array)
        {
            list.add(context.deserialize(e, tType));
        }
        return list;
    }
}
