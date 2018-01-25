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

public class PhysicalQuantity implements Serializable
{
    @SerializedName("value")
    @Expose
    private double value;
    @SerializedName("unit")
    @Expose
    private String unit;
    private final static long serialVersionUID = 1646136113862352600L;

    /**
     * No args constructor for use in serialization
     *
     */
    public PhysicalQuantity()
    {
    }

    /**
     *
     * @param unit
     * @param value
     */
    public PhysicalQuantity(double value, String unit)
    {
        super();
        this.value = value;
        this.unit = unit;
    }

    public double getValue()
    {
        return value;
    }

    public void setValue(double value)
    {
        this.value = value;
    }

    public PhysicalQuantity withValue(double value)
    {
        this.value = value;
        return this;
    }

    public String getUnit()
    {
        return unit;
    }

    public void setUnit(String unit)
    {
        this.unit = unit;
    }

    public PhysicalQuantity withUnit(String unit)
    {
        this.unit = unit;
        return this;
    }

    @Override
    public int hashCode()
    {
        return new HashCodeBuilder()
                .append(unit)
                .append(value)
                .toHashCode();
    }

    @Override
    public boolean equals(Object other)
    {
        if(other == this)
        {
            return true;
        }
        if((other instanceof PhysicalQuantity) == false)
        {
            return false;
        }
        PhysicalQuantity rhs = ((PhysicalQuantity)other);
        return new EqualsBuilder()
                .append(unit, rhs.unit)
                .append(value, rhs.value)
                .isEquals();
    }
}
