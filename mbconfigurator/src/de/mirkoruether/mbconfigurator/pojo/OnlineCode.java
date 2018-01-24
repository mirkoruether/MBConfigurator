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

public class OnlineCode implements Serializable
{
    @SerializedName("onlineCode")
    @Expose
    private String onlineCode;
    private final static long serialVersionUID = 4514457881717717892L;

    /**
     * No args constructor for use in serialization
     *
     */
    public OnlineCode()
    {
    }

    /**
     *
     * @param onlineCode
     */
    public OnlineCode(String onlineCode)
    {
        super();
        this.onlineCode = onlineCode;
    }

    public String getOnlineCode()
    {
        return onlineCode;
    }

    public void setOnlineCode(String onlineCode)
    {
        this.onlineCode = onlineCode;
    }

    public OnlineCode withOnlineCode(String onlineCode)
    {
        this.onlineCode = onlineCode;
        return this;
    }

    @Override
    public int hashCode()
    {
        return new HashCodeBuilder()
                .append(onlineCode)
                .toHashCode();
    }

    @Override
    public boolean equals(Object other)
    {
        if(other == this)
        {
            return true;
        }
        if((other instanceof OnlineCode) == false)
        {
            return false;
        }
        OnlineCode rhs = ((OnlineCode)other);
        return new EqualsBuilder()
                .append(onlineCode, rhs.onlineCode)
                .isEquals();
    }
}
