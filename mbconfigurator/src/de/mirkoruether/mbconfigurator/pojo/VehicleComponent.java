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

public class VehicleComponent implements Serializable, Comparable<VehicleComponent>, HasLinks
{
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("componentSortId")
    @Expose
    private int componentSortId;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("codeType")
    @Expose
    private String codeType;
    @SerializedName("componentType")
    @Expose
    private String componentType;
    @SerializedName("priceInformation")
    @Expose
    private PriceInformation priceInformation;
    @SerializedName("standard")
    @Expose
    private boolean standard;
    @SerializedName("selected")
    @Expose
    private boolean selected;
    @SerializedName("fixed")
    @Expose
    private boolean fixed;
    @SerializedName("hidden")
    @Expose
    private boolean hidden;
    @SerializedName("pseudoCode")
    @Expose
    private boolean pseudoCode;
    @SerializedName("includedComponents")
    @Expose
    private IncludedComponents includedComponents;
    @SerializedName("_links")
    @Expose
    private Links links;
    //Not from API
    @SerializedName("category")
    @Expose
    private ComponentCategory category;

    private final static long serialVersionUID = -5612570182374988247L;

    /**
     * No args constructor for use in serialization
     *
     */
    public VehicleComponent()
    {
    }

    /**
     *
     * @param standard
     * @param code
     * @param codeType
     * @param fixed
     * @param componentType
     * @param includedComponents
     * @param id
     * @param priceInformation
     * @param selected
     * @param pseudoCode
     * @param componentSortId
     * @param description
     * @param hidden
     * @param name
     */
    public VehicleComponent(String id, int componentSortId, String name, String description, String code, String codeType, String componentType, PriceInformation priceInformation, boolean standard, boolean selected, boolean fixed, boolean hidden, boolean pseudoCode, IncludedComponents includedComponents)
    {
        super();
        this.id = id;
        this.componentSortId = componentSortId;
        this.name = name;
        this.description = description;
        this.code = code;
        this.codeType = codeType;
        this.componentType = componentType;
        this.priceInformation = priceInformation;
        this.standard = standard;
        this.selected = selected;
        this.fixed = fixed;
        this.hidden = hidden;
        this.pseudoCode = pseudoCode;
        this.includedComponents = includedComponents;
    }

    @Override
    public int compareTo(VehicleComponent o)
    {
        if(o.category == null || category == null || category.equals(o.category))
        {
            return componentSortId - o.componentSortId;
        }
        return category.getCategoryId().compareTo(o.category.getCategoryId());
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public VehicleComponent withId(String id)
    {
        this.id = id;
        return this;
    }

    public int getComponentSortId()
    {
        return componentSortId;
    }

    public void setComponentSortId(int componentSortId)
    {
        this.componentSortId = componentSortId;
    }

    public VehicleComponent withComponentSortId(int componentSortId)
    {
        this.componentSortId = componentSortId;
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

    public VehicleComponent withName(String name)
    {
        this.name = name;
        return this;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public VehicleComponent withDescription(String description)
    {
        this.description = description;
        return this;
    }

    public String getCode()
    {
        return code;
    }

    public void setCode(String code)
    {
        this.code = code;
    }

    public VehicleComponent withCode(String code)
    {
        this.code = code;
        return this;
    }

    public String getCodeType()
    {
        return codeType;
    }

    public void setCodeType(String codeType)
    {
        this.codeType = codeType;
    }

    public VehicleComponent withCodeType(String codeType)
    {
        this.codeType = codeType;
        return this;
    }

    public String getComponentType()
    {
        return componentType;
    }

    public void setComponentType(String componentType)
    {
        this.componentType = componentType;
    }

    public VehicleComponent withComponentType(String componentType)
    {
        this.componentType = componentType;
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

    public VehicleComponent withPriceInformation(PriceInformation priceInformation)
    {
        this.priceInformation = priceInformation;
        return this;
    }

    public boolean isStandard()
    {
        return standard;
    }

    public void setStandard(boolean standard)
    {
        this.standard = standard;
    }

    public VehicleComponent withStandard(boolean standard)
    {
        this.standard = standard;
        return this;
    }

    public boolean isSelected()
    {
        return selected;
    }

    public void setSelected(boolean selected)
    {
        this.selected = selected;
    }

    public VehicleComponent withSelected(boolean selected)
    {
        this.selected = selected;
        return this;
    }

    public boolean isFixed()
    {
        return fixed;
    }

    public void setFixed(boolean fixed)
    {
        this.fixed = fixed;
    }

    public VehicleComponent withFixed(boolean fixed)
    {
        this.fixed = fixed;
        return this;
    }

    public boolean isHidden()
    {
        return hidden;
    }

    public void setHidden(boolean hidden)
    {
        this.hidden = hidden;
    }

    public VehicleComponent withHidden(boolean hidden)
    {
        this.hidden = hidden;
        return this;
    }

    public boolean isPseudoCode()
    {
        return pseudoCode;
    }

    public void setPseudoCode(boolean pseudoCode)
    {
        this.pseudoCode = pseudoCode;
    }

    public VehicleComponent withPseudoCode(boolean pseudoCode)
    {
        this.pseudoCode = pseudoCode;
        return this;
    }

    public IncludedComponents getIncludedComponents()
    {
        return includedComponents;
    }

    public void setIncludedComponents(IncludedComponents includedComponents)
    {
        this.includedComponents = includedComponents;
    }

    public VehicleComponent withIncludedComponents(IncludedComponents includedComponents)
    {
        this.includedComponents = includedComponents;
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

    public VehicleComponent withLinks(Links links)
    {
        this.links = links;
        return this;
    }

    public ComponentCategory getCategory()
    {
        return category;
    }

    public void setCategory(ComponentCategory category)
    {
        this.category = category;
    }

    public VehicleComponent withCategory(ComponentCategory category)
    {
        this.category = category;
        return this;
    }

    @Override
    public int hashCode()
    {
        return new HashCodeBuilder()
                .append(standard)
                .append(codeType)
                .append(code).append(fixed)
                .append(componentType)
                .append(includedComponents)
                .append(id).append(selected)
                .append(priceInformation)
                .append(pseudoCode)
                .append(hidden)
                .append(description)
                .append(componentSortId)
                .append(name)
                .toHashCode();
    }

    @Override
    public boolean equals(Object other)
    {
        if(other == this)
        {
            return true;
        }
        if((other instanceof VehicleComponent) == false)
        {
            return false;
        }
        VehicleComponent rhs = ((VehicleComponent)other);
        return new EqualsBuilder()
                .append(standard, rhs.standard)
                .append(codeType, rhs.codeType)
                .append(code, rhs.code)
                .append(fixed, rhs.fixed)
                .append(componentType, rhs.componentType)
                .append(includedComponents, rhs.includedComponents)
                .append(id, rhs.id).append(selected, rhs.selected)
                .append(priceInformation, rhs.priceInformation)
                .append(pseudoCode, rhs.pseudoCode)
                .append(hidden, rhs.hidden)
                .append(description, rhs.description)
                .append(componentSortId, rhs.componentSortId)
                .append(name, rhs.name)
                .isEquals();
    }
}
