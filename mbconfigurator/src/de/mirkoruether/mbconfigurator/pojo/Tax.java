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

public class Tax implements Serializable
{
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("amount")
    @Expose
    private double amount;
    @SerializedName("baseAmount")
    @Expose
    private int baseAmount;
    @SerializedName("charge")
    @Expose
    private int charge;
    @SerializedName("rate")
    @Expose
    private int rate;
    private final static long serialVersionUID = -588297074510833818L;

    /**
     * No args constructor for use in serialization
     *
     */
    public Tax()
    {
    }

    /**
     *
     * @param amount
     * @param id
     * @param baseAmount
     * @param rate
     * @param charge
     */
    public Tax(String id, double amount, int baseAmount, int charge, int rate)
    {
        super();
        this.id = id;
        this.amount = amount;
        this.baseAmount = baseAmount;
        this.charge = charge;
        this.rate = rate;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public Tax withId(String id)
    {
        this.id = id;
        return this;
    }

    public double getAmount()
    {
        return amount;
    }

    public void setAmount(double amount)
    {
        this.amount = amount;
    }

    public Tax withAmount(double amount)
    {
        this.amount = amount;
        return this;
    }

    public int getBaseAmount()
    {
        return baseAmount;
    }

    public void setBaseAmount(int baseAmount)
    {
        this.baseAmount = baseAmount;
    }

    public Tax withBaseAmount(int baseAmount)
    {
        this.baseAmount = baseAmount;
        return this;
    }

    public int getCharge()
    {
        return charge;
    }

    public void setCharge(int charge)
    {
        this.charge = charge;
    }

    public Tax withCharge(int charge)
    {
        this.charge = charge;
        return this;
    }

    public int getRate()
    {
        return rate;
    }

    public void setRate(int rate)
    {
        this.rate = rate;
    }

    public Tax withRate(int rate)
    {
        this.rate = rate;
        return this;
    }

    @Override
    public int hashCode()
    {
        return new HashCodeBuilder()
                .append(amount)
                .append(id)
                .append(baseAmount)
                .append(rate)
                .append(charge)
                .toHashCode();
    }

    @Override
    public boolean equals(Object other)
    {
        if(other == this)
        {
            return true;
        }
        if((other instanceof Tax) == false)
        {
            return false;
        }
        Tax rhs = ((Tax)other);
        return new EqualsBuilder()
                .append(amount, rhs.amount)
                .append(id, rhs.id)
                .append(baseAmount, rhs.baseAmount)
                .append(rate, rhs.rate)
                .append(charge, rhs.charge)
                .isEquals();
    }
}
