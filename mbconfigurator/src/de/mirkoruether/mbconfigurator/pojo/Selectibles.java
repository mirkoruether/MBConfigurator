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
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import de.mirkoruether.mbconfigurator.api.GsonUtils;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.List;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Selectibles implements Serializable
{

    @SerializedName("vehicleComponents")
    @Expose
    private List<VehicleComponent> vehicleComponents;
    @SerializedName("componentCategories")
    @Expose
    private List<ComponentCategory> componentCategories = null;
    @SerializedName("_links")
    @Expose
    private Links links;
    private final static long serialVersionUID = 6543315045753687795L;

    /**
     * No args constructor for use in serialization
     *
     */
    public Selectibles()
    {
    }

    /**
     *
     * @param componentCategories
     * @param links
     * @param vehicleComponents
     */
    public Selectibles(List<VehicleComponent> vehicleComponents, List<ComponentCategory> componentCategories, Links links)
    {
        super();
        this.vehicleComponents = vehicleComponents;
        this.componentCategories = componentCategories;
        this.links = links;
    }

    public List<VehicleComponent> getVehicleComponents()
    {
        return vehicleComponents;
    }

    public void setVehicleComponents(List<VehicleComponent> vehicleComponents)
    {
        this.vehicleComponents = vehicleComponents;
    }

    public Selectibles withVehicleComponents(List<VehicleComponent> vehicleComponents)
    {
        this.vehicleComponents = vehicleComponents;
        return this;
    }

    public List<ComponentCategory> getComponentCategories()
    {
        return componentCategories;
    }

    public void setComponentCategories(List<ComponentCategory> componentCategories)
    {
        this.componentCategories = componentCategories;
    }

    public Selectibles withComponentCategories(List<ComponentCategory> componentCategories)
    {
        this.componentCategories = componentCategories;
        return this;
    }

    public Links getLinks()
    {
        return links;
    }

    public void setLinks(Links links)
    {
        this.links = links;
    }

    public Selectibles withLinks(Links links)
    {
        this.links = links;
        return this;
    }

    @Override
    public int hashCode()
    {
        return new HashCodeBuilder().append(componentCategories).append(links).append(vehicleComponents).toHashCode();
    }

    @Override
    public boolean equals(Object other)
    {
        if(other == this)
        {
            return true;
        }
        if((other instanceof Selectibles) == false)
        {
            return false;
        }
        Selectibles rhs = ((Selectibles)other);
        return new EqualsBuilder().append(componentCategories, rhs.componentCategories).append(links, rhs.links).append(vehicleComponents, rhs.vehicleComponents).isEquals();
    }

    public static class Deserializer implements com.google.gson.JsonDeserializer<Selectibles>
    {
        @Override
        public Selectibles deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException
        {
            Selectibles result = new Selectibles();
            JsonObject obj = json.getAsJsonObject();

            result.setComponentCategories(GsonUtils.getListFromArray(obj.get("componentCategories"), context, ComponentCategory.class));
            result.setVehicleComponents(GsonUtils.getListFromObjectList(obj.get("vehicleComponents"), context, VehicleComponent.class));

            result.setLinks(context.deserialize(obj.get("_links"), Links.class));

            return result;
        }
    }
}
