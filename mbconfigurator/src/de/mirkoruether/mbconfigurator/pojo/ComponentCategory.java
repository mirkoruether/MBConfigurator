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

public class ComponentCategory implements Serializable
{
    @SerializedName("categoryId")
    @Expose
    private String categoryId;
    @SerializedName("categorySortId")
    @Expose
    private int categorySortId;
    @SerializedName("categoryName")
    @Expose
    private String categoryName;
    @SerializedName("cardinality")
    @Expose
    private String cardinality;
    @SerializedName("subcategories")
    @Expose
    private List<String> subcategories = null;
    @SerializedName("componentIds")
    @Expose
    private List<String> componentIds = null;
    private final static long serialVersionUID = 5089197330354956067L;

    /**
     * No args constructor for use in serialization
     *
     */
    public ComponentCategory()
    {
    }

    /**
     *
     * @param categoryName
     * @param categorySortId
     * @param categoryId
     * @param componentIds
     * @param subcategories
     * @param cardinality
     */
    public ComponentCategory(String categoryId, int categorySortId, String categoryName, String cardinality, List<String> subcategories, List<String> componentIds)
    {
        super();
        this.categoryId = categoryId;
        this.categorySortId = categorySortId;
        this.categoryName = categoryName;
        this.cardinality = cardinality;
        this.subcategories = subcategories;
        this.componentIds = componentIds;
    }

    public String getCategoryId()
    {
        return categoryId;
    }

    public void setCategoryId(String categoryId)
    {
        this.categoryId = categoryId;
    }

    public ComponentCategory withCategoryId(String categoryId)
    {
        this.categoryId = categoryId;
        return this;
    }

    public int getCategorySortId()
    {
        return categorySortId;
    }

    public void setCategorySortId(int categorySortId)
    {
        this.categorySortId = categorySortId;
    }

    public ComponentCategory withCategorySortId(int categorySortId)
    {
        this.categorySortId = categorySortId;
        return this;
    }

    public String getCategoryName()
    {
        return categoryName;
    }

    public void setCategoryName(String categoryName)
    {
        this.categoryName = categoryName;
    }

    public ComponentCategory withCategoryName(String categoryName)
    {
        this.categoryName = categoryName;
        return this;
    }

    public String getCardinality()
    {
        return cardinality;
    }

    public void setCardinality(String cardinality)
    {
        this.cardinality = cardinality;
    }

    public ComponentCategory withCardinality(String cardinality)
    {
        this.cardinality = cardinality;
        return this;
    }

    public List<String> getSubcategories()
    {
        return subcategories;
    }

    public void setSubcategories(List<String> subcategories)
    {
        this.subcategories = subcategories;
    }

    public ComponentCategory withSubcategories(List<String> subcategories)
    {
        this.subcategories = subcategories;
        return this;
    }

    public List<String> getComponentIds()
    {
        return componentIds;
    }

    public void setComponentIds(List<String> componentIds)
    {
        this.componentIds = componentIds;
    }

    public ComponentCategory withComponentIds(List<String> componentIds)
    {
        this.componentIds = componentIds;
        return this;
    }

    @Override
    public int hashCode()
    {
        return new HashCodeBuilder()
                .append(categoryName)
                .append(categorySortId)
                .append(categoryId)
                .append(componentIds)
                .append(subcategories)
                .append(cardinality)
                .toHashCode();
    }

    @Override
    public boolean equals(Object other)
    {
        if(other == this)
        {
            return true;
        }
        if((other instanceof ComponentCategory) == false)
        {
            return false;
        }
        ComponentCategory rhs = ((ComponentCategory)other);
        return new EqualsBuilder()
                .append(categoryName, rhs.categoryName)
                .append(categorySortId, rhs.categorySortId)
                .append(categoryId, rhs.categoryId)
                .append(componentIds, rhs.componentIds)
                .append(subcategories, rhs.subcategories)
                .append(cardinality, rhs.cardinality)
                .isEquals();
    }
}
