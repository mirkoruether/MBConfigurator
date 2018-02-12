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
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import de.mirkoruether.mbconfigurator.pojo.Configuration;
import de.mirkoruether.mbconfigurator.pojo.ConfigurationAlternative;
import de.mirkoruether.mbconfigurator.pojo.IncludedComponents;
import de.mirkoruether.mbconfigurator.pojo.Links;
import de.mirkoruether.mbconfigurator.pojo.Market;
import de.mirkoruether.mbconfigurator.pojo.Model;
import de.mirkoruether.mbconfigurator.pojo.Selectables;
import de.mirkoruether.mbconfigurator.pojo.VehicleBody;
import de.mirkoruether.mbconfigurator.pojo.VehicleClass;
import de.mirkoruether.mbconfigurator.pojo.VehicleComponent;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;
import javax.net.ssl.HttpsURLConnection;
import org.apache.commons.io.FileUtils;

public class MBConfigurator
{
    public static final String BASE_URL = "https://api.mercedes-benz.com/configurator/v1";
    public static final String APIKEY;
    public static final Gson GSON;
    private static FolderCache cache;

    static
    {
        try
        {
            APIKEY = FileUtils.readFileToString(new File("APIKEY"), StandardCharsets.UTF_8).trim();

            GSON = new GsonBuilder()
                    .registerTypeAdapter(IncludedComponents.class, new IncludedComponents.Deserializer())
                    .registerTypeAdapter(Selectables.class, new Selectables.Deserializer())
                    .registerTypeAdapter(Links.class, new Links.Deserializer())
                    .registerTypeAdapter(Links.class, new Links.Serializer())
                    .setPrettyPrinting()
                    .setLenient()
                    .create();

            cache = new FolderCache(new File(System.getProperty("java.io.tmpdir"), "MBConfigurator"));

            String certificateRessourcePath = "/res/cert";
            CertificateManager certificateManager = new CertificateManager("./sslkeystore.jks", "changeit");
            certificateManager.addCustomCertificate(certificateRessourcePath, "europestarconnect-ceidaimlercom");
            CustomTrustManager.getInstance().register(certificateManager);
        }
        catch(Exception ex)
        {
            throw new ExceptionInInitializerError(ex);
        }
    }

    private MBConfigurator()
    {
    }

    public static FolderCache getCache()
    {
        return cache;
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
        String response = request("markets/" + market
                                  + "/models/" + modelId
                                  + "/configurations/initial");
        return fromJson(response, Configuration.class);
    }

    public static Configuration getConfiguration(String market, String modelId, String configurationId)
    {
        String response = request("markets/" + market
                                  + "/models/" + modelId
                                  + "/configurations/" + configurationId);
        return fromJson(response, Configuration.class);
    }

    public static Selectables getSelectibles(String market, String modelId, String configurationId)
    {
        String response = request("markets/" + market
                                  + "/models/" + modelId
                                  + "/configurations/" + configurationId
                                  + "/selectables");
        return fromJson(response, Selectables.class);
    }

    public static Map<String, String> getVehicleImageLinks(String market, String modelId, String configurationId)
    {
        String response = request("markets/" + market + "/models/" + modelId
                                  + "/configurations/" + configurationId
                                  + "/images/vehicle");

        return getImageLinks(response);
    }

    public static ConfigurationAlternative[] getAlternatives(String market, String modelId, String configurationId, String changeSet)
    {
        String response = request("markets/" + market
                                  + "/models/" + modelId
                                  + "/configurations/" + configurationId
                                  + "/alternatives/" + changeSet);
        return fromJson(response, ConfigurationAlternative[].class);
    }

    public static Map<String, String> getComponentImageLinks(String market, String modelId, String configurationId, VehicleComponent comp)
    {
        String response = request("markets/" + market + "/models/" + modelId
                                  + "/configurations/" + configurationId
                                  + "/images/components/equipments/" + comp.getCode());

        return getImageLinks(response);
    }

    private static Map<String, String> getImageLinks(String response)
    {
        JsonObject obj = GSON.fromJson(response, JsonObject.class);
        HashMap<String, String> result = new HashMap<>();
        if(obj != null)
        {
            searchForElement("url", "", obj, result);
        }

        return result;
    }

    private static void searchForElement(String searchFor, String currentName, JsonElement element, Map<String, String> addTo)
    {
        if(element.isJsonObject())
        {
            JsonObject obj = element.getAsJsonObject();
            for(Map.Entry<String, JsonElement> e : obj.entrySet())
            {
                if(e.getValue().isJsonPrimitive())
                {
                    if(searchFor.equals(e.getKey()))
                    {
                        addTo.put(currentName, e.getValue().getAsString());
                    }
                }
                else
                {
                    searchForElement(searchFor, currentName + "/" + e.getKey(), e.getValue(), addTo);
                }
            }
        }
        else if(element.isJsonArray())
        {
            JsonArray arr = element.getAsJsonArray();
            for(int i = 0; i < arr.size(); i++)
            {
                if(!arr.get(i).isJsonPrimitive())
                {
                    searchForElement(searchFor, currentName + "/" + i, arr.get(i), addTo);
                }
            }
        }
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

    public static BufferedImage downloadImage(String url)
    {
        try
        {
            BufferedImage c = cache.getImage(url);
            if(c != null)
                return c;

            BufferedImage result = ImageIO.read(new URL(url));
            cache.putImage(url, result);
            return result;
        }
        catch(IOException ex)
        {
            return null;
        }
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
            String c = cache.getResponse(urlString);
            if(c != null)
                return c;

            HttpsURLConnection con = openAndPrepareConnection(urlString);
            BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
            StringBuilder sb = new StringBuilder();

            String line = reader.readLine();
            while(line != null)
            {
                sb.append(line);
                sb.append("\n");
                line = reader.readLine();
            }

            String result = sb.toString();
            cache.putResponse(urlString, result);
            return result;
        }
        catch(IOException ex)
        {
            throw new RuntimeException(ex);
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
