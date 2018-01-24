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
//http://www.jsonschema2pojo.org/

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Market implements Serializable
{
    private final static long serialVersionUID = -6297208339222734688L;

    @SerializedName("marketId")
    @Expose
    private String marketId;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("language")
    @Expose
    private String language;
    @SerializedName("_links")
    @Expose
    private Links links;

    /**
     * No args constructor for use in serialization
     *
     */
    public Market()
    {
    }

    /**
     *
     * @param marketId
     * @param links
     * @param language
     * @param country
     */
    public Market(String marketId, String country, String language, Links links)
    {
        super();
        this.marketId = marketId;
        this.country = country;
        this.language = language;
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

    public Market withMarketId(String marketId)
    {
        this.marketId = marketId;
        return this;
    }

    public String getCountry()
    {
        return country;
    }

    public void setCountry(String country)
    {
        this.country = country;
    }

    public Market withCountry(String country)
    {
        this.country = country;
        return this;
    }

    public String getLanguage()
    {
        return language;
    }

    public void setLanguage(String language)
    {
        this.language = language;
    }

    public Market withLanguage(String language)
    {
        this.language = language;
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

    public Market withLinks(Links links)
    {
        this.links = links;
        return this;
    }

    @Override
    public int hashCode()
    {
        return new HashCodeBuilder().append(marketId).append(links).append(language).append(country).toHashCode();
    }

    @Override
    public boolean equals(Object other)
    {
        if(other == this)
        {
            return true;
        }
        if((other instanceof Market) == false)
        {
            return false;
        }
        Market rhs = ((Market)other);
        return new EqualsBuilder().append(marketId, rhs.marketId).append(links, rhs.links).append(language, rhs.language).append(country, rhs.country).isEquals();
    }

    public static class Links implements Serializable
    {
        private final static long serialVersionUID = -3970313836964234028L;

        @SerializedName("self")
        @Expose
        private String self;
        @SerializedName("classes")
        @Expose
        private String classes;
        @SerializedName("bodies")
        @Expose
        private String bodies;
        @SerializedName("models")
        @Expose
        private String models;
        @SerializedName("productgroups")
        @Expose
        private String productgroups;

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
         * @param classes
         * @param productgroups
         * @param self
         * @param bodies
         */
        public Links(String self, String classes, String bodies, String models, String productgroups)
        {
            super();
            this.self = self;
            this.classes = classes;
            this.bodies = bodies;
            this.models = models;
            this.productgroups = productgroups;
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

        public String getClasses()
        {
            return classes;
        }

        public void setClasses(String classes)
        {
            this.classes = classes;
        }

        public Links withClasses(String classes)
        {
            this.classes = classes;
            return this;
        }

        public String getBodies()
        {
            return bodies;
        }

        public void setBodies(String bodies)
        {
            this.bodies = bodies;
        }

        public Links withBodies(String bodies)
        {
            this.bodies = bodies;
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

        public String getProductgroups()
        {
            return productgroups;
        }

        public void setProductgroups(String productgroups)
        {
            this.productgroups = productgroups;
        }

        public Links withProductgroups(String productgroups)
        {
            this.productgroups = productgroups;
            return this;
        }

        @Override
        public int hashCode()
        {
            return new HashCodeBuilder().append(models).append(classes).append(productgroups).append(self).append(bodies).toHashCode();
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
            return new EqualsBuilder().append(models, rhs.models).append(classes, rhs.classes).append(productgroups, rhs.productgroups).append(self, rhs.self).append(bodies, rhs.bodies).isEquals();
        }
    }
}