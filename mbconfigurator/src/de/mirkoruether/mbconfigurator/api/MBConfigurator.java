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
import de.mirkoruether.mbconfigurator.pojo.HasLinks;
import de.mirkoruether.mbconfigurator.pojo.IncludedComponents;
import de.mirkoruether.mbconfigurator.pojo.Links;
import de.mirkoruether.mbconfigurator.pojo.Market;
import de.mirkoruether.mbconfigurator.pojo.Model;
import de.mirkoruether.mbconfigurator.pojo.Selectables;
import de.mirkoruether.mbconfigurator.pojo.VehicleBody;
import de.mirkoruether.mbconfigurator.pojo.VehicleClass;
import java.awt.image.BufferedImage;
import java.io.File;
import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;
import java.util.logging.Logger;
import org.apache.commons.io.FileUtils;

public class MBConfigurator
{
    private static final Logger logger = Logger.getLogger(MBConfigurator.class.getName());

    public static final String BASE_URL = "https://api.mercedes-benz.com/configurator/v1";
    public static final String APIKEY;
    public static final Gson GSON;
    private static final ApiConnection CONNECTION;

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

            CONNECTION = new ApiConnection(APIKEY, new File(System.getProperty("java.io.tmpdir"), "MBConfigurator"));

            String certificateRessourcePath = "/res/cert";
            CertificateManager certificateManager = new CertificateManager("./sslkeystore.jks", "changeit");
            certificateManager.addCustomCertificate(certificateRessourcePath, "europestarconnect-ceidaimlercom");
            CustomTrustManager.getInstance().register(certificateManager);

            Runtime.getRuntime().addShutdownHook(new Thread(() -> CONNECTION.clearCache()));
        }
        catch(Exception ex)
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

    public static Configuration getInitialConfiguration(Model model, String market)
    {
        return fromLinkIfPresent(model, "configurations", Configuration.class, ()
                                 -> getInitialConfigurationManually(market, model.getModelId()));
    }

    public static Configuration getInitialConfigurationManually(String market, String modelId)
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

    public static Selectables getSelectibles(Configuration config)
    {
        return fromLinkIfPresent(config, "selectables", Selectables.class, ()
                                 -> getSelectiblesManually(config.getMarketId(), config.getModelId(), config.getConfigurationId()));
    }

    public static Selectables getSelectiblesManually(String market, String modelId, String configurationId)
    {
        String response = request("markets/" + market
                                  + "/models/" + modelId
                                  + "/configurations/" + configurationId
                                  + "/selectables");
        return fromJson(response, Selectables.class);
    }

    public static Map<String, String> getVehicleImageLinks(Configuration config)
    {
        final String linkKey = "image";
        if(isLinkPresent(config, linkKey))
        {
            return getImageLinks(requestDirect(config.getLinks().getLink(linkKey)));
        }
        return getVehicleImageLinksManually(config.getMarketId(), config.getModelId(), config.getConfigurationId());
    }

    public static Map<String, String> getVehicleImageLinksManually(String market, String modelId, String configurationId)
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

    public static Map<String, String> getComponentImageLinks(String market, String modelId, String configurationId, String compCode)
    {
        String response = request("markets/" + market + "/models/" + modelId
                                  + "/configurations/" + configurationId
                                  + "/images/components/equipments/" + compCode);

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

    public static boolean isLinkPresent(HasLinks obj, String linkKey)
    {
        return obj != null && obj.getLinks() != null && obj.getLinks().hasLink(linkKey);
    }

    public static <T> T fromLinkIfPresent(HasLinks obj, String linkKey, Class<T> clazz, Supplier<T> backup)
    {
        if(isLinkPresent(obj, linkKey))
        {
            return fromLink(obj, linkKey, clazz);
        }
        return backup.get();
    }

    public static <T> T fromLink(HasLinks obj, String linkKey, Class<T> clazz)
    {
        return fromLink(obj.getLinks(), linkKey, clazz);
    }

    public static <T> T fromLink(Links links, String linkKey, Class<T> clazz)
    {
        return fromLink(links.getLink(linkKey), clazz);
    }

    public static <T> T fromLink(String link, Class<T> clazz)
    {
        String response = requestDirect(link);
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

    public static String requestDirect(String url)
    {
        return returnRequestResult(CONNECTION.getResponse(url));
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
            return CONNECTION.getImage(url);
        }
        catch(Exception ex)
        {
            return null;
        }
    }

    public static String request(String path, Map<String, String> parameters)
    {
        return returnRequestResult(CONNECTION.getResponse(path, parameters));
    }

    private static String returnRequestResult(String response)
    {
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
}
