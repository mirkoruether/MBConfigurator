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

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class ConfigurationAlternative implements Serializable, HasLinks
{
    @SerializedName("marketId")
    @Expose
    private String marketId;
    @SerializedName("modelId")
    @Expose
    private String modelId;
    @SerializedName("configurationId")
    @Expose
    private String configurationId;
    @SerializedName("addedComponents")
    @Expose
    private List<VehicleComponent> addedComponents = null;
    @SerializedName("removedComponents")
    @Expose
    private List<VehicleComponent> removedComponents = null;
    @SerializedName("updatedComponents")
    @Expose
    private List<VehicleComponent> updatedComponents = null;
    @SerializedName("priceInformation")
    @Expose
    private PriceInformation priceInformation;
    @SerializedName("_links")
    @Expose
    private Links links;
    private final static long serialVersionUID = -2868049315417878857L;

    /**
     * No args constructor for use in serialization
     *
     */
    public ConfigurationAlternative()
    {
    }

    /**
     *
     * @param modelId
     * @param marketId
     * @param priceInformation
     * @param links
     * @param addedComponents
     * @param updatedComponents
     * @param removedComponents
     * @param configurationId
     */
    public ConfigurationAlternative(String marketId, String modelId, String configurationId,
                                    List<VehicleComponent> addedComponents, List<VehicleComponent> removedComponents,
                                    List<VehicleComponent> updatedComponents, PriceInformation priceInformation, Links links)
    {
        super();
        this.marketId = marketId;
        this.modelId = modelId;
        this.configurationId = configurationId;
        this.addedComponents = addedComponents;
        this.removedComponents = removedComponents;
        this.updatedComponents = updatedComponents;
        this.priceInformation = priceInformation;
        this.links = links;
    }

    public String getMarketId()
    {
        return marketId;
    }

    public void setMarketId(String marketId)
    {
        this.marketId = marketId;
    }

    public ConfigurationAlternative withMarketId(String marketId)
    {
        this.marketId = marketId;
        return this;
    }

    public String getModelId()
    {
        return modelId;
    }

    public void setModelId(String modelId)
    {
        this.modelId = modelId;
    }

    public ConfigurationAlternative withModelId(String modelId)
    {
        this.modelId = modelId;
        return this;
    }

    public String getConfigurationId()
    {
        return configurationId;
    }

    public void setConfigurationId(String configurationId)
    {
        this.configurationId = configurationId;
    }

    public ConfigurationAlternative withConfigurationId(String configurationId)
    {
        this.configurationId = configurationId;
        return this;
    }

    public List<VehicleComponent> getAddedComponents()
    {
        return addedComponents;
    }

    public void setAddedComponents(List<VehicleComponent> addedComponents)
    {
        this.addedComponents = addedComponents;
    }

    public ConfigurationAlternative withAddedComponents(List<VehicleComponent> addedComponents)
    {
        this.addedComponents = addedComponents;
        return this;
    }

    public List<VehicleComponent> getRemovedComponents()
    {
        return removedComponents;
    }

    public void setRemovedComponents(List<VehicleComponent> removedComponents)
    {
        this.removedComponents = removedComponents;
    }

    public ConfigurationAlternative withRemovedComponents(List<VehicleComponent> removedComponents)
    {
        this.removedComponents = removedComponents;
        return this;
    }

    public List<VehicleComponent> getUpdatedComponents()
    {
        return updatedComponents;
    }

    public void setUpdatedComponents(List<VehicleComponent> updatedComponents)
    {
        this.updatedComponents = updatedComponents;
    }

    public ConfigurationAlternative withUpdatedComponents(List<VehicleComponent> updatedComponents)
    {
        this.updatedComponents = updatedComponents;
        return this;
    }

    public PriceInformation getPriceInformation()
    {
        return priceInformation;
    }

    public void setPriceInformation(PriceInformation priceInformation)
    {
        this.priceInformation = priceInformation;
    }

    public ConfigurationAlternative withPriceInformation(PriceInformation priceInformation)
    {
        this.priceInformation = priceInformation;
        return this;
    }

    @Override
    public Links getLinks()
    {
        return links;
    }

    public void setLinks(Links links)
    {
        this.links = links;
    }

    public ConfigurationAlternative withLinks(Links links)
    {
        this.links = links;
        return this;
    }

    @Override
    public int hashCode()
    {
        return new HashCodeBuilder()
                .append(modelId)
                .append(marketId)
                .append(priceInformation)
                .append(links)
                .append(addedComponents)
                .append(updatedComponents)
                .append(removedComponents)
                .append(configurationId)
                .toHashCode();
    }

    @Override
    public boolean equals(Object other)
    {
        if(other == this)
        {
            return true;
        }
        if((other instanceof ConfigurationAlternative) == false)
        {
            return false;
        }
        ConfigurationAlternative rhs = ((ConfigurationAlternative)other);
        return new EqualsBuilder()
                .append(modelId, rhs.modelId)
                .append(marketId, rhs.marketId)
                .append(priceInformation, rhs.priceInformation)
                .append(links, rhs.links)
                .append(addedComponents, rhs.addedComponents)
                .append(updatedComponents, rhs.updatedComponents)
                .append(removedComponents, rhs.removedComponents)
                .append(configurationId, rhs.configurationId)
                .isEquals();
    }
}
