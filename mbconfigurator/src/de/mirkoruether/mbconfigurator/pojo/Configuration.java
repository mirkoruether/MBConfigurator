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

public class Configuration implements Serializable
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
    @SerializedName("initialPrice")
    @Expose
    private PriceInformation initialPrice;
    @SerializedName("configurationPrice")
    @Expose
    private PriceInformation configurationPrice;
    @SerializedName("modelYear")
    @Expose
    private String modelYear;
    @SerializedName("changeYear")
    @Expose
    private String changeYear;
    @SerializedName("vehicleComponents")
    @Expose
    private List<VehicleComponent> vehicleComponents = null;
    @SerializedName("technicalInformation")
    @Expose
    private TechnicalInformation technicalInformation;
    @SerializedName("wltpConfiguration")
    @Expose
    private boolean wltpConfiguration;
    @SerializedName("_links")
    @Expose
    private Links links;
    private final static long serialVersionUID = -3525876298626917822L;

    /**
     * No args constructor for use in serialization
     *
     */
    public Configuration()
    {
    }

    /**
     *
     * @param modelId
     * @param marketId
     * @param initialPrice
     * @param modelYear
     * @param links
     * @param changeYear
     * @param wltpConfiguration
     * @param configurationId
     * @param technicalInformation
     * @param vehicleComponents
     * @param configurationPrice
     */
    public Configuration(String marketId, String modelId, String configurationId, PriceInformation initialPrice, PriceInformation configurationPrice, String modelYear, String changeYear, List<VehicleComponent> vehicleComponents, TechnicalInformation technicalInformation, boolean wltpConfiguration, Links links)
    {
        super();
        this.marketId = marketId;
        this.modelId = modelId;
        this.configurationId = configurationId;
        this.initialPrice = initialPrice;
        this.configurationPrice = configurationPrice;
        this.modelYear = modelYear;
        this.changeYear = changeYear;
        this.vehicleComponents = vehicleComponents;
        this.technicalInformation = technicalInformation;
        this.wltpConfiguration = wltpConfiguration;
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

    public Configuration withMarketId(String marketId)
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

    public Configuration withModelId(String modelId)
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

    public Configuration withConfigurationId(String configurationId)
    {
        this.configurationId = configurationId;
        return this;
    }

    public PriceInformation getInitialPrice()
    {
        return initialPrice;
    }

    public void setInitialPrice(PriceInformation initialPrice)
    {
        this.initialPrice = initialPrice;
    }

    public Configuration withInitialPrice(PriceInformation initialPrice)
    {
        this.initialPrice = initialPrice;
        return this;
    }

    public PriceInformation getConfigurationPrice()
    {
        return configurationPrice;
    }

    public void setConfigurationPrice(PriceInformation configurationPrice)
    {
        this.configurationPrice = configurationPrice;
    }

    public Configuration withConfigurationPrice(PriceInformation configurationPrice)
    {
        this.configurationPrice = configurationPrice;
        return this;
    }

    public String getModelYear()
    {
        return modelYear;
    }

    public void setModelYear(String modelYear)
    {
        this.modelYear = modelYear;
    }

    public Configuration withModelYear(String modelYear)
    {
        this.modelYear = modelYear;
        return this;
    }

    public String getChangeYear()
    {
        return changeYear;
    }

    public void setChangeYear(String changeYear)
    {
        this.changeYear = changeYear;
    }

    public Configuration withChangeYear(String changeYear)
    {
        this.changeYear = changeYear;
        return this;
    }

    public List<VehicleComponent> getVehicleComponents()
    {
        return vehicleComponents;
    }

    public void setVehicleComponents(List<VehicleComponent> vehicleComponents)
    {
        this.vehicleComponents = vehicleComponents;
    }

    public Configuration withVehicleComponents(List<VehicleComponent> vehicleComponents)
    {
        this.vehicleComponents = vehicleComponents;
        return this;
    }

    public TechnicalInformation getTechnicalInformation()
    {
        return technicalInformation;
    }

    public void setTechnicalInformation(TechnicalInformation technicalInformation)
    {
        this.technicalInformation = technicalInformation;
    }

    public Configuration withTechnicalInformation(TechnicalInformation technicalInformation)
    {
        this.technicalInformation = technicalInformation;
        return this;
    }

    public boolean isWltpConfiguration()
    {
        return wltpConfiguration;
    }

    public void setWltpConfiguration(boolean wltpConfiguration)
    {
        this.wltpConfiguration = wltpConfiguration;
    }

    public Configuration withWltpConfiguration(boolean wltpConfiguration)
    {
        this.wltpConfiguration = wltpConfiguration;
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

    public Configuration withLinks(Links links)
    {
        this.links = links;
        return this;
    }

    @Override
    public int hashCode()
    {
        return new HashCodeBuilder().append(modelId).append(marketId).append(initialPrice).append(modelYear).append(links).append(changeYear).append(wltpConfiguration).append(configurationId).append(technicalInformation).append(vehicleComponents).append(configurationPrice).toHashCode();
    }

    @Override
    public boolean equals(Object other)
    {
        if(other == this)
        {
            return true;
        }
        if((other instanceof Configuration) == false)
        {
            return false;
        }
        Configuration rhs = ((Configuration)other);
        return new EqualsBuilder().append(modelId, rhs.modelId).append(marketId, rhs.marketId).append(initialPrice, rhs.initialPrice).append(modelYear, rhs.modelYear).append(links, rhs.links).append(changeYear, rhs.changeYear).append(wltpConfiguration, rhs.wltpConfiguration).append(configurationId, rhs.configurationId).append(technicalInformation, rhs.technicalInformation).append(vehicleComponents, rhs.vehicleComponents).append(configurationPrice, rhs.configurationPrice).isEquals();
    }

}
