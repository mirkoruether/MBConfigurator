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

public class FuelEconomy implements Serializable
{

    @SerializedName("fuelConsumptionCityMin")
    @Expose
    private PhysicalSize fuelConsumptionCityMin;
    @SerializedName("fuelConsumptionCityMax")
    @Expose
    private PhysicalSize fuelConsumptionCityMax;
    @SerializedName("fuelConsumptionOverlandMin")
    @Expose
    private PhysicalSize fuelConsumptionOverlandMin;
    @SerializedName("fuelConsumptionOverlandMax")
    @Expose
    private PhysicalSize fuelConsumptionOverlandMax;
    @SerializedName("fuelConsumptionCombinedMin")
    @Expose
    private PhysicalSize fuelConsumptionCombinedMin;
    @SerializedName("fuelConsumptionCombinedMax")
    @Expose
    private PhysicalSize fuelConsumptionCombinedMax;
    @SerializedName("fuelConsumptionElectricity")
    @Expose
    private PhysicalSize fuelConsumptionElectricity;
    @SerializedName("consumptionOfElectricityMin")
    @Expose
    private PhysicalSize consumptionOfElectricityMin;
    @SerializedName("consumptionOfElectricityMax")
    @Expose
    private PhysicalSize consumptionOfElectricityMax;
    @SerializedName("emissionCO2Min")
    @Expose
    private PhysicalSize emissionCO2Min;
    @SerializedName("emissionCO2Max")
    @Expose
    private PhysicalSize emissionCO2Max;
    private final static long serialVersionUID = 2577709601392224793L;

    /**
     * No args constructor for use in serialization
     *
     */
    public FuelEconomy()
    {
    }

    /**
     *
     * @param emissionCO2Min
     * @param fuelConsumptionOverlandMin
     * @param fuelConsumptionOverlandMax
     * @param fuelConsumptionCityMin
     * @param emissionCO2Max
     * @param fuelConsumptionCombinedMin
     * @param fuelConsumptionElectricity
     * @param consumptionOfElectricityMin
     * @param consumptionOfElectricityMax
     * @param fuelConsumptionCombinedMax
     * @param fuelConsumptionCityMax
     */
    public FuelEconomy(PhysicalSize fuelConsumptionCityMin, PhysicalSize fuelConsumptionCityMax, PhysicalSize fuelConsumptionOverlandMin, PhysicalSize fuelConsumptionOverlandMax, PhysicalSize fuelConsumptionCombinedMin, PhysicalSize fuelConsumptionCombinedMax, PhysicalSize fuelConsumptionElectricity, PhysicalSize consumptionOfElectricityMin, PhysicalSize consumptionOfElectricityMax, PhysicalSize emissionCO2Min, PhysicalSize emissionCO2Max)
    {
        this.fuelConsumptionCityMin = fuelConsumptionCityMin;
        this.fuelConsumptionCityMax = fuelConsumptionCityMax;
        this.fuelConsumptionOverlandMin = fuelConsumptionOverlandMin;
        this.fuelConsumptionOverlandMax = fuelConsumptionOverlandMax;
        this.fuelConsumptionCombinedMin = fuelConsumptionCombinedMin;
        this.fuelConsumptionCombinedMax = fuelConsumptionCombinedMax;
        this.fuelConsumptionElectricity = fuelConsumptionElectricity;
        this.consumptionOfElectricityMin = consumptionOfElectricityMin;
        this.consumptionOfElectricityMax = consumptionOfElectricityMax;
        this.emissionCO2Min = emissionCO2Min;
        this.emissionCO2Max = emissionCO2Max;
    }

    public PhysicalSize getFuelConsumptionCityMin()
    {
        return fuelConsumptionCityMin;
    }

    public void setFuelConsumptionCityMin(PhysicalSize fuelConsumptionCityMin)
    {
        this.fuelConsumptionCityMin = fuelConsumptionCityMin;
    }

    public FuelEconomy withFuelConsumptionCityMin(PhysicalSize fuelConsumptionCityMin)
    {
        this.fuelConsumptionCityMin = fuelConsumptionCityMin;
        return this;
    }

    public PhysicalSize getFuelConsumptionCityMax()
    {
        return fuelConsumptionCityMax;
    }

    public void setFuelConsumptionCityMax(PhysicalSize fuelConsumptionCityMax)
    {
        this.fuelConsumptionCityMax = fuelConsumptionCityMax;
    }

    public FuelEconomy withFuelConsumptionCityMax(PhysicalSize fuelConsumptionCityMax)
    {
        this.fuelConsumptionCityMax = fuelConsumptionCityMax;
        return this;
    }

    public PhysicalSize getFuelConsumptionOverlandMin()
    {
        return fuelConsumptionOverlandMin;
    }

    public void setFuelConsumptionOverlandMin(PhysicalSize fuelConsumptionOverlandMin)
    {
        this.fuelConsumptionOverlandMin = fuelConsumptionOverlandMin;
    }

    public FuelEconomy withFuelConsumptionOverlandMin(PhysicalSize fuelConsumptionOverlandMin)
    {
        this.fuelConsumptionOverlandMin = fuelConsumptionOverlandMin;
        return this;
    }

    public PhysicalSize getFuelConsumptionOverlandMax()
    {
        return fuelConsumptionOverlandMax;
    }

    public void setFuelConsumptionOverlandMax(PhysicalSize fuelConsumptionOverlandMax)
    {
        this.fuelConsumptionOverlandMax = fuelConsumptionOverlandMax;
    }

    public FuelEconomy withFuelConsumptionOverlandMax(PhysicalSize fuelConsumptionOverlandMax)
    {
        this.fuelConsumptionOverlandMax = fuelConsumptionOverlandMax;
        return this;
    }

    public PhysicalSize getFuelConsumptionCombinedMin()
    {
        return fuelConsumptionCombinedMin;
    }

    public void setFuelConsumptionCombinedMin(PhysicalSize fuelConsumptionCombinedMin)
    {
        this.fuelConsumptionCombinedMin = fuelConsumptionCombinedMin;
    }

    public FuelEconomy withFuelConsumptionCombinedMin(PhysicalSize fuelConsumptionCombinedMin)
    {
        this.fuelConsumptionCombinedMin = fuelConsumptionCombinedMin;
        return this;
    }

    public PhysicalSize getFuelConsumptionCombinedMax()
    {
        return fuelConsumptionCombinedMax;
    }

    public void setFuelConsumptionCombinedMax(PhysicalSize fuelConsumptionCombinedMax)
    {
        this.fuelConsumptionCombinedMax = fuelConsumptionCombinedMax;
    }

    public FuelEconomy withFuelConsumptionCombinedMax(PhysicalSize fuelConsumptionCombinedMax)
    {
        this.fuelConsumptionCombinedMax = fuelConsumptionCombinedMax;
        return this;
    }

    public PhysicalSize getFuelConsumptionElectricity()
    {
        return fuelConsumptionElectricity;
    }

    public void setFuelConsumptionElectricity(PhysicalSize fuelConsumptionElectricity)
    {
        this.fuelConsumptionElectricity = fuelConsumptionElectricity;
    }

    public FuelEconomy withFuelConsumptionElectricity(PhysicalSize fuelConsumptionElectricity)
    {
        this.fuelConsumptionElectricity = fuelConsumptionElectricity;
        return this;
    }

    public PhysicalSize getConsumptionOfElectricityMin()
    {
        return consumptionOfElectricityMin;
    }

    public void setConsumptionOfElectricityMin(PhysicalSize consumptionOfElectricityMin)
    {
        this.consumptionOfElectricityMin = consumptionOfElectricityMin;
    }

    public FuelEconomy withConsumptionOfElectricityMin(PhysicalSize consumptionOfElectricityMin)
    {
        this.consumptionOfElectricityMin = consumptionOfElectricityMin;
        return this;
    }

    public PhysicalSize getConsumptionOfElectricityMax()
    {
        return consumptionOfElectricityMax;
    }

    public void setConsumptionOfElectricityMax(PhysicalSize consumptionOfElectricityMax)
    {
        this.consumptionOfElectricityMax = consumptionOfElectricityMax;
    }

    public FuelEconomy withConsumptionOfElectricityMax(PhysicalSize consumptionOfElectricityMax)
    {
        this.consumptionOfElectricityMax = consumptionOfElectricityMax;
        return this;
    }

    public PhysicalSize getEmissionCO2Min()
    {
        return emissionCO2Min;
    }

    public void setEmissionCO2Min(PhysicalSize emissionCO2Min)
    {
        this.emissionCO2Min = emissionCO2Min;
    }

    public FuelEconomy withEmissionCO2Min(PhysicalSize emissionCO2Min)
    {
        this.emissionCO2Min = emissionCO2Min;
        return this;
    }

    public PhysicalSize getEmissionCO2Max()
    {
        return emissionCO2Max;
    }

    public void setEmissionCO2Max(PhysicalSize emissionCO2Max)
    {
        this.emissionCO2Max = emissionCO2Max;
    }

    public FuelEconomy withEmissionCO2Max(PhysicalSize emissionCO2Max)
    {
        this.emissionCO2Max = emissionCO2Max;
        return this;
    }

    @Override
    public int hashCode()
    {
        return new HashCodeBuilder()
                .append(fuelConsumptionElectricity)
                .append(emissionCO2Min)
                .append(fuelConsumptionOverlandMin)
                .append(consumptionOfElectricityMax)
                .append(fuelConsumptionOverlandMax)
                .append(fuelConsumptionCityMin)
                .append(emissionCO2Max)
                .append(fuelConsumptionCombinedMin)
                .append(fuelConsumptionCombinedMax)
                .append(fuelConsumptionCityMax)
                .append(consumptionOfElectricityMin)
                .toHashCode();
    }

    @Override
    public boolean equals(Object other)
    {
        if(other == this)
        {
            return true;
        }
        if((other instanceof FuelEconomy) == false)
        {
            return false;
        }
        FuelEconomy rhs = ((FuelEconomy)other);
        return new EqualsBuilder()
                .append(fuelConsumptionElectricity, rhs.fuelConsumptionElectricity)
                .append(emissionCO2Min, rhs.emissionCO2Min)
                .append(fuelConsumptionOverlandMin, rhs.fuelConsumptionOverlandMin)
                .append(consumptionOfElectricityMax, rhs.consumptionOfElectricityMax)
                .append(fuelConsumptionOverlandMax, rhs.fuelConsumptionOverlandMax)
                .append(fuelConsumptionCityMin, rhs.fuelConsumptionCityMin)
                .append(emissionCO2Max, rhs.emissionCO2Max)
                .append(fuelConsumptionCombinedMin, rhs.fuelConsumptionCombinedMin)
                .append(fuelConsumptionCombinedMax, rhs.fuelConsumptionCombinedMax)
                .append(fuelConsumptionCityMax, rhs.fuelConsumptionCityMax)
                .append(consumptionOfElectricityMin, rhs.consumptionOfElectricityMin)
                .isEquals();
    }
}
