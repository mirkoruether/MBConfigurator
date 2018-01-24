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

public class Engine implements Serializable
{
    @SerializedName("fuelType")
    @Expose
    private String fuelType;
    @SerializedName("alternativeFuelType")
    @Expose
    private String alternativeFuelType;
    @SerializedName("engineConcept")
    @Expose
    private String engineConcept;
    @SerializedName("driveConcept")
    @Expose
    private String driveConcept;
    @SerializedName("fuelEconomy")
    @Expose
    private FuelEconomy fuelEconomy;
    @SerializedName("powerHp")
    @Expose
    private PhysicalSize powerHp;
    @SerializedName("powerKw")
    @Expose
    private PhysicalSize powerKw;
    @SerializedName("powerHybridExtensionHp")
    @Expose
    private PhysicalSize powerHybridExtensionHp;
    @SerializedName("powerHybridExtensionKw")
    @Expose
    private PhysicalSize powerHybridExtensionKw;
    @SerializedName("cylinder")
    @Expose
    private String cylinder;
    @SerializedName("capacity")
    @Expose
    private PhysicalSize capacity;
    @SerializedName("emissionStandard")
    @Expose
    private String emissionStandard;
    private final static long serialVersionUID = -6684871853600908162L;

    /**
     * No args constructor for use in serialization
     *
     */
    public Engine()
    {
    }

    /**
     *
     * @param fuelEconomy
     * @param emissionStandard
     * @param fuelType
     * @param driveConcept
     * @param engineConcept
     * @param alternativeFuelType
     * @param cylinder
     * @param powerHybridExtensionHp
     * @param powerHybridExtensionKw
     * @param capacity
     * @param powerHp
     * @param powerKw
     */
    public Engine(String fuelType, String alternativeFuelType, String engineConcept, String driveConcept, FuelEconomy fuelEconomy, PhysicalSize powerHp, PhysicalSize powerKw, PhysicalSize powerHybridExtensionHp, PhysicalSize powerHybridExtensionKw, String cylinder, PhysicalSize capacity, String emissionStandard)
    {
        this.fuelType = fuelType;
        this.alternativeFuelType = alternativeFuelType;
        this.engineConcept = engineConcept;
        this.driveConcept = driveConcept;
        this.fuelEconomy = fuelEconomy;
        this.powerHp = powerHp;
        this.powerKw = powerKw;
        this.powerHybridExtensionHp = powerHybridExtensionHp;
        this.powerHybridExtensionKw = powerHybridExtensionKw;
        this.cylinder = cylinder;
        this.capacity = capacity;
        this.emissionStandard = emissionStandard;
    }

    public String getFuelType()
    {
        return fuelType;
    }

    public void setFuelType(String fuelType)
    {
        this.fuelType = fuelType;
    }

    public Engine withFuelType(String fuelType)
    {
        this.fuelType = fuelType;
        return this;
    }

    public String getAlternativeFuelType()
    {
        return alternativeFuelType;
    }

    public void setAlternativeFuelType(String alternativeFuelType)
    {
        this.alternativeFuelType = alternativeFuelType;
    }

    public Engine withAlternativeFuelType(String alternativeFuelType)
    {
        this.alternativeFuelType = alternativeFuelType;
        return this;
    }

    public String getEngineConcept()
    {
        return engineConcept;
    }

    public void setEngineConcept(String engineConcept)
    {
        this.engineConcept = engineConcept;
    }

    public Engine withEngineConcept(String engineConcept)
    {
        this.engineConcept = engineConcept;
        return this;
    }

    public String getDriveConcept()
    {
        return driveConcept;
    }

    public void setDriveConcept(String driveConcept)
    {
        this.driveConcept = driveConcept;
    }

    public Engine withDriveConcept(String driveConcept)
    {
        this.driveConcept = driveConcept;
        return this;
    }

    public FuelEconomy getFuelEconomy()
    {
        return fuelEconomy;
    }

    public void setFuelEconomy(FuelEconomy fuelEconomy)
    {
        this.fuelEconomy = fuelEconomy;
    }

    public Engine withFuelEconomy(FuelEconomy fuelEconomy)
    {
        this.fuelEconomy = fuelEconomy;
        return this;
    }

    public PhysicalSize getPowerHp()
    {
        return powerHp;
    }

    public void setPowerHp(PhysicalSize powerHp)
    {
        this.powerHp = powerHp;
    }

    public Engine withPowerHp(PhysicalSize powerHp)
    {
        this.powerHp = powerHp;
        return this;
    }

    public PhysicalSize getPowerKw()
    {
        return powerKw;
    }

    public void setPowerKw(PhysicalSize powerKw)
    {
        this.powerKw = powerKw;
    }

    public Engine withPowerKw(PhysicalSize powerKw)
    {
        this.powerKw = powerKw;
        return this;
    }

    public PhysicalSize getPowerHybridExtensionHp()
    {
        return powerHybridExtensionHp;
    }

    public void setPowerHybridExtensionHp(PhysicalSize powerHybridExtensionHp)
    {
        this.powerHybridExtensionHp = powerHybridExtensionHp;
    }

    public Engine withPowerHybridExtensionHp(PhysicalSize powerHybridExtensionHp)
    {
        this.powerHybridExtensionHp = powerHybridExtensionHp;
        return this;
    }

    public PhysicalSize getPowerHybridExtensionKw()
    {
        return powerHybridExtensionKw;
    }

    public void setPowerHybridExtensionKw(PhysicalSize powerHybridExtensionKw)
    {
        this.powerHybridExtensionKw = powerHybridExtensionKw;
    }

    public Engine withPowerHybridExtensionKw(PhysicalSize powerHybridExtensionKw)
    {
        this.powerHybridExtensionKw = powerHybridExtensionKw;
        return this;
    }

    public String getCylinder()
    {
        return cylinder;
    }

    public void setCylinder(String cylinder)
    {
        this.cylinder = cylinder;
    }

    public Engine withCylinder(String cylinder)
    {
        this.cylinder = cylinder;
        return this;
    }

    public PhysicalSize getCapacity()
    {
        return capacity;
    }

    public void setCapacity(PhysicalSize capacity)
    {
        this.capacity = capacity;
    }

    public Engine withCapacity(PhysicalSize capacity)
    {
        this.capacity = capacity;
        return this;
    }

    public String getEmissionStandard()
    {
        return emissionStandard;
    }

    public void setEmissionStandard(String emissionStandard)
    {
        this.emissionStandard = emissionStandard;
    }

    public Engine withEmissionStandard(String emissionStandard)
    {
        this.emissionStandard = emissionStandard;
        return this;
    }

    @Override
    public int hashCode()
    {
        return new HashCodeBuilder()
                .append(fuelEconomy)
                .append(emissionStandard)
                .append(fuelType)
                .append(driveConcept)
                .append(engineConcept)
                .append(alternativeFuelType)
                .append(cylinder)
                .append(capacity)
                .append(powerHp)
                .append(powerKw)
                .append(powerHybridExtensionHp)
                .append(powerHybridExtensionKw)
                .toHashCode();
    }

    @Override
    public boolean equals(Object other)
    {
        if(other == this)
        {
            return true;
        }
        if((other instanceof Engine) == false)
        {
            return false;
        }
        Engine rhs = ((Engine)other);
        return new EqualsBuilder()
                .append(fuelEconomy, rhs.fuelEconomy)
                .append(emissionStandard, rhs.emissionStandard)
                .append(fuelType, rhs.fuelType)
                .append(driveConcept, rhs.driveConcept)
                .append(engineConcept, rhs.engineConcept)
                .append(alternativeFuelType, rhs.alternativeFuelType)
                .append(cylinder, rhs.cylinder)
                .append(capacity, rhs.capacity)
                .append(powerHp, rhs.powerHp)
                .append(powerKw, rhs.powerKw)
                .append(powerHybridExtensionHp, rhs.powerHybridExtensionHp)
                .append(powerHybridExtensionKw, rhs.powerHybridExtensionKw)
                .isEquals();
    }

}
