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

public class PriceInformation implements Serializable
{

    @SerializedName("price")
    @Expose
    private double price;
    @SerializedName("netPrice")
    @Expose
    private int netPrice;
    @SerializedName("currency")
    @Expose
    private String currency;
    @SerializedName("taxes")
    @Expose
    private List<Tax> taxes = null;
    private final static long serialVersionUID = -2088516464029809183L;

    /**
     * No args constructor for use in serialization
     *
     */
    public PriceInformation()
    {
    }

    /**
     *
     * @param price
     * @param netPrice
     * @param taxes
     * @param currency
     */
    public PriceInformation(double price, int netPrice, String currency, List<Tax> taxes)
    {
        super();
        this.price = price;
        this.netPrice = netPrice;
        this.currency = currency;
        this.taxes = taxes;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    public PriceInformation withPrice(double price)
    {
        this.price = price;
        return this;
    }

    public int getNetPrice()
    {
        return netPrice;
    }

    public void setNetPrice(int netPrice)
    {
        this.netPrice = netPrice;
    }

    public PriceInformation withNetPrice(int netPrice)
    {
        this.netPrice = netPrice;
        return this;
    }

    public String getCurrency()
    {
        return currency;
    }

    public void setCurrency(String currency)
    {
        this.currency = currency;
    }

    public PriceInformation withCurrency(String currency)
    {
        this.currency = currency;
        return this;
    }

    public List<Tax> getTaxes()
    {
        return taxes;
    }

    public void setTaxes(List<Tax> taxes)
    {
        this.taxes = taxes;
    }

    public PriceInformation withTaxes(List<Tax> taxes)
    {
        this.taxes = taxes;
        return this;
    }

    @Override
    public int hashCode()
    {
        return new HashCodeBuilder()
                .append(price)
                .append(netPrice)
                .append(taxes)
                .append(currency)
                .toHashCode();
    }

    @Override
    public boolean equals(Object other)
    {
        if(other == this)
        {
            return true;
        }
        if((other instanceof PriceInformation) == false)
        {
            return false;
        }
        PriceInformation rhs = ((PriceInformation)other);
        return new EqualsBuilder()
                .append(price, rhs.price)
                .append(netPrice, rhs.netPrice)
                .append(taxes, rhs.taxes)
                .append(currency, rhs.currency)
                .isEquals();
    }
}
