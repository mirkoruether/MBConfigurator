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

public class VehicleComponent implements Serializable
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
    @SerializedName("_links")
    @Expose
    private Links links;
    private final static long serialVersionUID = 1396339971632000948L;

    /**
     * No args constructor for use in serialization
     *
     */
    public VehicleComponent()
    {
    }

    /**
     *
     * @param id
     * @param selected
     * @param priceInformation
     * @param standard
     * @param pseudoCode
     * @param hidden
     * @param componentSortId
     * @param name
     * @param links
     * @param codeType
     * @param code
     * @param fixed
     * @param componentType
     */
    public VehicleComponent(String id, int componentSortId, String name, String code, String codeType, String componentType, PriceInformation priceInformation, boolean standard, boolean selected, boolean fixed, boolean hidden, boolean pseudoCode, Links links)
    {
        super();
        this.id = id;
        this.componentSortId = componentSortId;
        this.name = name;
        this.code = code;
        this.codeType = codeType;
        this.componentType = componentType;
        this.priceInformation = priceInformation;
        this.standard = standard;
        this.selected = selected;
        this.fixed = fixed;
        this.hidden = hidden;
        this.pseudoCode = pseudoCode;
        this.links = links;
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

    @Override
    public int hashCode()
    {
        return new HashCodeBuilder()
                .append(standard)
                .append(links)
                .append(codeType)
                .append(code)
                .append(fixed)
                .append(componentType)
                .append(id)
                .append(selected)
                .append(priceInformation)
                .append(pseudoCode)
                .append(hidden)
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
                .append(links, rhs.links)
                .append(codeType, rhs.codeType)
                .append(code, rhs.code)
                .append(fixed, rhs.fixed)
                .append(componentType, rhs.componentType)
                .append(id, rhs.id)
                .append(selected, rhs.selected)
                .append(priceInformation, rhs.priceInformation)
                .append(pseudoCode, rhs.pseudoCode)
                .append(hidden, rhs.hidden)
                .append(componentSortId, rhs.componentSortId)
                .append(name, rhs.name)
                .isEquals();
    }

    public static class Links implements Serializable
    {

        @SerializedName("image")
        @Expose
        private String image;
        private final static long serialVersionUID = -958189651559036877L;

        /**
         * No args constructor for use in serialization
         *
         */
        public Links()
        {
        }

        /**
         *
         * @param image
         */
        public Links(String image)
        {
            super();
            this.image = image;
        }

        public String getImage()
        {
            return image;
        }

        public void setImage(String image)
        {
            this.image = image;
        }

        public Links withImage(String image)
        {
            this.image = image;
            return this;
        }

        @Override
        public int hashCode()
        {
            return new HashCodeBuilder()
                    .append(image)
                    .toHashCode();
        }

        @Override
        public boolean equals(Object other)
        {
            if(other == this)
            {
                return true;
            }
            if((other instanceof Links) == false)
            {
                return false;
            }
            Links rhs = ((Links)other);
            return new EqualsBuilder()
                    .append(image, rhs.image)
                    .isEquals();
        }
    }
}
