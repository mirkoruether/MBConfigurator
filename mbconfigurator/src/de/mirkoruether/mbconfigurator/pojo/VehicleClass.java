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

public class VehicleClass implements Serializable
{
    @SerializedName("classId")
    @Expose
    private String classId;
    @SerializedName("className")
    @Expose
    private String className;
    @SerializedName("_links")
    @Expose
    private Links links;
    private final static long serialVersionUID = 3867732713396545118L;

    /**
     * No args constructor for use in serialization
     *
     */
    public VehicleClass()
    {
    }

    /**
     *
     * @param classId
     * @param links
     * @param className
     */
    public VehicleClass(String classId, String className, Links links)
    {
        super();
        this.classId = classId;
        this.className = className;
        this.links = links;
    }

    public String getClassId()
    {
        return classId;
    }

    public void setClassId(String classId)
    {
        this.classId = classId;
    }

    public VehicleClass withClassId(String classId)
    {
        this.classId = classId;
        return this;
    }

    public String getClassName()
    {
        return className;
    }

    public void setClassName(String className)
    {
        this.className = className;
    }

    public VehicleClass withClassName(String className)
    {
        this.className = className;
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

    public VehicleClass withLinks(Links links)
    {
        this.links = links;
        return this;
    }

    @Override
    public int hashCode()
    {
        return new HashCodeBuilder()
                .append(classId)
                .append(links)
                .append(className)
                .toHashCode();
    }

    @Override
    public boolean equals(Object other)
    {
        if(other == this)
        {
            return true;
        }
        if((other instanceof VehicleClass) == false)
        {
            return false;
        }
        VehicleClass rhs = ((VehicleClass)other);
        return new EqualsBuilder()
                .append(classId, rhs.classId)
                .append(links, rhs.links)
                .append(className, rhs.className)
                .isEquals();
    }

    public static class Links implements Serializable
    {
        @SerializedName("self")
        @Expose
        private String self;
        @SerializedName("models")
        @Expose
        private String models;
        private final static long serialVersionUID = -6056109217657527984L;

        /**
         * No args constructor for use in serialization
         *
         */
        public Links()
        {
        }

        /**
         *
         * @param models
         * @param self
         */
        public Links(String self, String models)
        {
            super();
            this.self = self;
            this.models = models;
        }

        public String getSelf()
        {
            return self;
        }

        public void setSelf(String self)
        {
            this.self = self;
        }

        public Links withSelf(String self)
        {
            this.self = self;
            return this;
        }

        public String getModels()
        {
            return models;
        }

        public void setModels(String models)
        {
            this.models = models;
        }

        public Links withModels(String models)
        {
            this.models = models;
            return this;
        }

        @Override
        public int hashCode()
        {
            return new HashCodeBuilder()
                    .append(models)
                    .append(self)
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
                    .append(models, rhs.models)
                    .append(self, rhs.self)
                    .isEquals();
        }
    }
}
