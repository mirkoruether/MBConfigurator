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
package de.mirkoruether.mbconfigurator.api;
//http://www.jsonschema2pojo.org/

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Fault implements Serializable
{
    private final static long serialVersionUID = -708060751181905366L;

    @SerializedName("faultstring")
    @Expose
    private String faultstring;

    @SerializedName("detail")
    @Expose
    private Object detail;

    public Fault()
    {
    }

    public Fault(String faultstring, Object detail)
    {
        this.faultstring = faultstring;
        this.detail = detail;
    }

    public String getFaultstring()
    {
        return faultstring;
    }

    public void setFaultstring(String faultstring)
    {
        this.faultstring = faultstring;
    }

    public Fault withFaultstring(String faultstring)
    {
        this.faultstring = faultstring;
        return this;
    }

    public Object getDetail()
    {
        return detail;
    }

    public void setDetail(Object detail)
    {
        this.detail = detail;
    }

    public Fault withDetail(Object detail)
    {
        this.detail = detail;
        return this;
    }

    @Override
    public int hashCode()
    {
        return new HashCodeBuilder().append(detail).append(faultstring).toHashCode();
    }

    @Override
    public boolean equals(Object other)
    {
        if(other == this)
        {
            return true;
        }
        if((other instanceof Fault) == false)
        {
            return false;
        }
        Fault rhs = ((Fault)other);
        return new EqualsBuilder()
                .append(detail, rhs.detail)
                .append(faultstring, rhs.faultstring)
                .isEquals();
    }
}
