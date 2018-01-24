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

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class IncludedComponents implements Serializable
{
    private final static long serialVersionUID = 5805894384937018412L;

    @SerializedName("vehicleComponents")
    @Expose
    private List<VehicleComponent> vehicleComponents;
    @SerializedName("componentCategories")
    @Expose
    private List<ComponentCategory> componentCategories;

    /**
     * No args constructor for use in serialization
     *
     */
    public IncludedComponents()
    {
    }

    public IncludedComponents(List<VehicleComponent> vehicleComponents, List<ComponentCategory> componentCategories)
    {
        this.vehicleComponents = vehicleComponents;
        this.componentCategories = componentCategories;
    }

    public List<VehicleComponent> getVehicleComponents()
    {
        return vehicleComponents;
    }

    public void setVehicleComponents(List<VehicleComponent> vehicleComponents)
    {
        this.vehicleComponents = vehicleComponents;
    }

    public IncludedComponents withVehicleComponents(List<VehicleComponent> vehicleComponents)
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

    public IncludedComponents withComponentCategories(List<ComponentCategory> componentCategories)
    {
        this.componentCategories = componentCategories;
        return this;
    }

    @Override
    public int hashCode()
    {
        return new HashCodeBuilder()
                .append(componentCategories)
                .append(vehicleComponents)
                .toHashCode();
    }

    @Override
    public boolean equals(Object other)
    {
        if(other == this)
        {
            return true;
        }
        if((other instanceof IncludedComponents) == false)
        {
            return false;
        }
        IncludedComponents rhs = ((IncludedComponents)other);
        return new EqualsBuilder()
                .append(componentCategories, rhs.componentCategories)
                .append(vehicleComponents, rhs.vehicleComponents)
                .isEquals();
    }

    public static class Deserializer implements com.google.gson.JsonDeserializer<IncludedComponents>
    {
        @Override
        public IncludedComponents deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException
        {
            IncludedComponents result = new IncludedComponents();
            JsonObject inclComp = json.getAsJsonObject();

            JsonArray compCats = inclComp.get("componentCategories").getAsJsonArray();
            List<ComponentCategory> cats = new ArrayList<>();
            for(JsonElement e : compCats)
            {
                cats.add(context.deserialize(e, ComponentCategory.class));
            }
            result.setComponentCategories(cats);

            Set<Map.Entry<String, JsonElement>> vehicleComps = inclComp.get("vehicleComponents").getAsJsonObject().entrySet();
            List<VehicleComponent> comps = new ArrayList<>();
            for(Map.Entry<String, JsonElement> e : vehicleComps)
            {
                comps.add(context.deserialize(e.getValue(), VehicleComponent.class));
            }
            result.setVehicleComponents(comps);

            return result;
        }
    }
}
