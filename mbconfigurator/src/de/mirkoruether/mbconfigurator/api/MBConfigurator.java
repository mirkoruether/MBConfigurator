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

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;
import de.mirkoruether.mbconfigurator.pojo.Configuration;
import de.mirkoruether.mbconfigurator.pojo.IncludedComponents;
import de.mirkoruether.mbconfigurator.pojo.Links;
import de.mirkoruether.mbconfigurator.pojo.Market;
import de.mirkoruether.mbconfigurator.pojo.Model;
import de.mirkoruether.mbconfigurator.pojo.Selectables;
import de.mirkoruether.mbconfigurator.pojo.VehicleBody;
import de.mirkoruether.mbconfigurator.pojo.VehicleClass;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;

public class MBConfigurator
{
    public static final String BASE_URL = "https://api.mercedes-benz.com/configurator/v1";
    public static final String APIKEY;
    public static final Gson GSON;

    static
    {
        try
        {
            APIKEY = Files.readAllLines(Paths.get("APIKEY")).get(0);

            GSON = new GsonBuilder()
                    .registerTypeAdapter(IncludedComponents.class, new IncludedComponents.Deserializer())
                    .registerTypeAdapter(Selectables.class, new Selectables.Deserializer())
                    .registerTypeAdapter(Links.class, new Links.Deserializer())
                    .registerTypeAdapter(Links.class, new Links.Serializer())
                    .setPrettyPrinting()
                    .setLenient()
                    .create();
        }
        catch(IOException ex)
        {
            throw new ExceptionInInitializerError(ex);
        }
    }

    private MBConfigurator()
    {
    }

    public static Market[] getMarkets(String language)
    {
        String response = request("markets", "language", language);
        return fromJson(response, Market[].class);
    }

    public static VehicleBody[] getVehicleBodies(String market, String productGroups, String classId)
    {
        String response = request("markets/" + market + "/bodies",
                                  "productGroups", productGroups,
                                  "classId", classId);
        return fromJson(response, VehicleBody[].class);
    }

    public static VehicleClass[] getVehicleClasses(String market, String productGroups, String bodyId)
    {
        String response = request("markets/" + market + "/classes",
                                  "productGroups", productGroups,
                                  "bodyId", bodyId);
        return fromJson(response, VehicleClass[].class);
    }

    public static Model[] getModels(String market, String productGroups, String classId, String bodyId)
    {
        String response = request("markets/" + market + "/models",
                                  "productGroups", productGroups,
                                  "classId", classId,
                                  "bodyId", bodyId);
        return fromJson(response, Model[].class);
    }

    public static Configuration getInitialConfiguration(String market, String modelId)
    {
        String response = request("markets/" + market + "/models/" + modelId + "/configurations/initial");
        return fromJson(response, Configuration.class);
    }

    public static Selectables getSelectibles(String market, String modelId, String configurationId)
    {
        String response = request("markets/" + market + "/models/" + modelId + "/configurations/" + configurationId + "/selectables");
        return fromJson(response, Selectables.class);
    }

    public static <T> T fromLink(Links links, String linkKey, Class<T> clazz)
    {
        String response = getResponse(links.getLink(linkKey));
        return fromJson(response, clazz);
    }

    public static <T> T fromLink(String link, Class<T> clazz)
    {
        String response = getResponse(link);
        return fromJson(response, clazz);
    }

    @SuppressWarnings("unchecked")
    public static <T> T fromJson(String response, Class<T> clazz)
    {
        if(clazz.isArray())
        {
            T result = GSON.fromJson(response, clazz);
            return result == null ? (T)Array.newInstance(clazz.getComponentType(), 0) : result;
        }
        else
        {
            return GSON.fromJson(response, clazz);
        }
    }

    public static String request(String path, String... parameters)
    {
        if(parameters.length % 2 != 0)
        {
            throw new IllegalArgumentException("Illegal parameter length");
        }

        Map<String, String> p = new HashMap<>(parameters.length / 2);
        for(int i = 0; i < parameters.length; i += 2)
        {
            String key = parameters[i];
            String value = parameters[i + 1];
            if(key != null && value != null)
                p.put(key, value);
        }

        return request(path, p);
    }

    public static String request(String path, Map<String, String> parameters)
    {
        String response = getResponse(path, parameters);
        try
        {
            Fault f = GSON.fromJson(response, Fault.class);
            if(f != null && f.getFaultstring() != null)
                throw new ApiFaultException(f.getFaultstring());
        }
        catch(JsonParseException ex)
        {
        }

        return response;
    }

    private static String getResponse(String path, Map<String, String> parameters)
    {
        String url = BASE_URL;
        if(!path.startsWith("/"))
            url += "/";
        url += path;

        url += "?";
        if(parameters != null && !parameters.isEmpty())
        {
            for(Map.Entry<String, String> e : parameters.entrySet())
            {
                url += e.getKey() + "=" + e.getValue() + "&";
            }
        }
        url += "apikey=" + APIKEY;

        return getResponse(url);
    }

    private static String getResponse(String urlString)
    {
        try
        {
            HttpsURLConnection con = openAndPrepareConnection(urlString);
            BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
            StringBuilder result = new StringBuilder();

            String line = reader.readLine();
            while(line != null)
            {
                result.append(line);
                result.append("\n");
                line = reader.readLine();
            }

            return result.toString();
        }
        catch(IOException ex)
        {
            throw new RuntimeException("IOException occured", ex);
        }
    }

    private static HttpsURLConnection openAndPrepareConnection(String urlString) throws IOException
    {
        URL url = new URL(urlString);
        HttpsURLConnection con = (HttpsURLConnection)url.openConnection();
        con.setRequestMethod("GET");

        return con;
    }
}
