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
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Model implements Serializable
{
    @SerializedName("modelId")
    @Expose
    private String modelId;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("shortName")
    @Expose
    private String shortName;
    @SerializedName("baumuster")
    @Expose
    private String baumuster;
    @SerializedName("nationalSalesType")
    @Expose
    private String nationalSalesType;
    @SerializedName("vehicleClass")
    @Expose
    private VehicleClass vehicleClass;
    @SerializedName("vehicleBody")
    @Expose
    private VehicleBody vehicleBody;
    @SerializedName("productGroup")
    @Expose
    private String productGroup;
    @SerializedName("priceInformation")
    @Expose
    private PriceInformation priceInformation;
    @SerializedName("_links")
    @Expose
    private Links links;
    private final static long serialVersionUID = 3808358757629704073L;

    /**
     * No args constructor for use in serialization
     *
     */
    public Model()
    {
    }

    /**
     *
     * @param productGroup
     * @param modelId
     * @param priceInformation
     * @param nationalSalesType
     * @param name
     * @param vehicleClass
     * @param links
     * @param vehicleBody
     * @param shortName
     * @param baumuster
     */
    public Model(String modelId, String name, String shortName, String baumuster, String nationalSalesType, VehicleClass vehicleClass, VehicleBody vehicleBody, String productGroup, PriceInformation priceInformation, Links links)
    {
        super();
        this.modelId = modelId;
        this.name = name;
        this.shortName = shortName;
        this.baumuster = baumuster;
        this.nationalSalesType = nationalSalesType;
        this.vehicleClass = vehicleClass;
        this.vehicleBody = vehicleBody;
        this.productGroup = productGroup;
        this.priceInformation = priceInformation;
        this.links = links;
    }

    public String getModelId()
    {
        return modelId;
    }

    public void setModelId(String modelId)
    {
        this.modelId = modelId;
    }

    public Model withModelId(String modelId)
    {
        this.modelId = modelId;
        return this;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Model withName(String name)
    {
        this.name = name;
        return this;
    }

    public String getShortName()
    {
        return shortName;
    }

    public void setShortName(String shortName)
    {
        this.shortName = shortName;
    }

    public Model withShortName(String shortName)
    {
        this.shortName = shortName;
        return this;
    }

    public String getBaumuster()
    {
        return baumuster;
    }

    public void setBaumuster(String baumuster)
    {
        this.baumuster = baumuster;
    }

    public Model withBaumuster(String baumuster)
    {
        this.baumuster = baumuster;
        return this;
    }

    public String getNationalSalesType()
    {
        return nationalSalesType;
    }

    public void setNationalSalesType(String nationalSalesType)
    {
        this.nationalSalesType = nationalSalesType;
    }

    public Model withNationalSalesType(String nationalSalesType)
    {
        this.nationalSalesType = nationalSalesType;
        return this;
    }

    public VehicleClass getVehicleClass()
    {
        return vehicleClass;
    }

    public void setVehicleClass(VehicleClass vehicleClass)
    {
        this.vehicleClass = vehicleClass;
    }

    public Model withVehicleClass(VehicleClass vehicleClass)
    {
        this.vehicleClass = vehicleClass;
        return this;
    }

    public VehicleBody getVehicleBody()
    {
        return vehicleBody;
    }

    public void setVehicleBody(VehicleBody vehicleBody)
    {
        this.vehicleBody = vehicleBody;
    }

    public Model withVehicleBody(VehicleBody vehicleBody)
    {
        this.vehicleBody = vehicleBody;
        return this;
    }

    public String getProductGroup()
    {
        return productGroup;
    }

    public void setProductGroup(String productGroup)
    {
        this.productGroup = productGroup;
    }

    public Model withProductGroup(String productGroup)
    {
        this.productGroup = productGroup;
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

    public Model withPriceInformation(PriceInformation priceInformation)
    {
        this.priceInformation = priceInformation;
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

    public Model withLinks(Links links)
    {
        this.links = links;
        return this;
    }

    @Override
    public int hashCode()
    {
        return new HashCodeBuilder()
                .append(productGroup)
                .append(modelId)
                .append(priceInformation)
                .append(nationalSalesType)
                .append(name)
                .append(vehicleClass)
                .append(links)
                .append(vehicleBody)
                .append(shortName)
                .append(baumuster)
                .toHashCode();
    }

    @Override
    public boolean equals(Object other)
    {
        if(other == this)
        {
            return true;
        }
        if((other instanceof Model) == false)
        {
            return false;
        }
        Model rhs = ((Model)other);
        return new EqualsBuilder()
                .append(productGroup, rhs.productGroup)
                .append(modelId, rhs.modelId)
                .append(priceInformation, rhs.priceInformation)
                .append(nationalSalesType, rhs.nationalSalesType)
                .append(name, rhs.name)
                .append(vehicleClass, rhs.vehicleClass)
                .append(links, rhs.links)
                .append(vehicleBody, rhs.vehicleBody)
                .append(shortName, rhs.shortName)
                .append(baumuster, rhs.baumuster)
                .isEquals();
    }
}
