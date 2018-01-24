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

public class VehicleBody implements Serializable
{
    @SerializedName("bodyId")
    @Expose
    private String bodyId;
    @SerializedName("bodyName")
    @Expose
    private String bodyName;
    @SerializedName("_links")
    @Expose
    private Links links;
    private final static long serialVersionUID = -2413577605082031090L;

    /**
     * No args constructor for use in serialization
     *
     */
    public VehicleBody()
    {
    }

    /**
     *
     * @param bodyName
     * @param links
     * @param bodyId
     */
    public VehicleBody(String bodyId, String bodyName, Links links)
    {
        super();
        this.bodyId = bodyId;
        this.bodyName = bodyName;
        this.links = links;
    }

    public String getBodyId()
    {
        return bodyId;
    }

    public void setBodyId(String bodyId)
    {
        this.bodyId = bodyId;
    }

    public VehicleBody withBodyId(String bodyId)
    {
        this.bodyId = bodyId;
        return this;
    }

    public String getBodyName()
    {
        return bodyName;
    }

    public void setBodyName(String bodyName)
    {
        this.bodyName = bodyName;
    }

    public VehicleBody withBodyName(String bodyName)
    {
        this.bodyName = bodyName;
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

    public VehicleBody withLinks(Links links)
    {
        this.links = links;
        return this;
    }

    @Override
    public int hashCode()
    {
        return new HashCodeBuilder()
                .append(bodyName)
                .append(links)
                .append(bodyId)
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
        VehicleBody rhs = ((VehicleBody)other);
        return new EqualsBuilder()
                .append(bodyName, rhs.bodyName)
                .append(links, rhs.links)
                .append(bodyId, rhs.bodyId)
                .isEquals();
    }
}
