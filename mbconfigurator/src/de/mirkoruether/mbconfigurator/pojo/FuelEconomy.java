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
    private PhysicalQuantity fuelConsumptionCityMin;
    @SerializedName("fuelConsumptionCityMax")
    @Expose
    private PhysicalQuantity fuelConsumptionCityMax;
    @SerializedName("fuelConsumptionOverlandMin")
    @Expose
    private PhysicalQuantity fuelConsumptionOverlandMin;
    @SerializedName("fuelConsumptionOverlandMax")
    @Expose
    private PhysicalQuantity fuelConsumptionOverlandMax;
    @SerializedName("fuelConsumptionCombinedMin")
    @Expose
    private PhysicalQuantity fuelConsumptionCombinedMin;
    @SerializedName("fuelConsumptionCombinedMax")
    @Expose
    private PhysicalQuantity fuelConsumptionCombinedMax;
    @SerializedName("fuelConsumptionElectricity")
    @Expose
    private PhysicalQuantity fuelConsumptionElectricity;
    @SerializedName("consumptionOfElectricityMin")
    @Expose
    private PhysicalQuantity consumptionOfElectricityMin;
    @SerializedName("consumptionOfElectricityMax")
    @Expose
    private PhysicalQuantity consumptionOfElectricityMax;
    @SerializedName("emissionCO2Min")
    @Expose
    private PhysicalQuantity emissionCO2Min;
    @SerializedName("emissionCO2Max")
    @Expose
    private PhysicalQuantity emissionCO2Max;
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
    public FuelEconomy(PhysicalQuantity fuelConsumptionCityMin, PhysicalQuantity fuelConsumptionCityMax, PhysicalQuantity fuelConsumptionOverlandMin, PhysicalQuantity fuelConsumptionOverlandMax, PhysicalQuantity fuelConsumptionCombinedMin, PhysicalQuantity fuelConsumptionCombinedMax, PhysicalQuantity fuelConsumptionElectricity, PhysicalQuantity consumptionOfElectricityMin, PhysicalQuantity consumptionOfElectricityMax, PhysicalQuantity emissionCO2Min, PhysicalQuantity emissionCO2Max)
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

    public PhysicalQuantity getFuelConsumptionCityMin()
    {
        return fuelConsumptionCityMin;
    }

    public void setFuelConsumptionCityMin(PhysicalQuantity fuelConsumptionCityMin)
    {
        this.fuelConsumptionCityMin = fuelConsumptionCityMin;
    }

    public FuelEconomy withFuelConsumptionCityMin(PhysicalQuantity fuelConsumptionCityMin)
    {
        this.fuelConsumptionCityMin = fuelConsumptionCityMin;
        return this;
    }

    public PhysicalQuantity getFuelConsumptionCityMax()
    {
        return fuelConsumptionCityMax;
    }

    public void setFuelConsumptionCityMax(PhysicalQuantity fuelConsumptionCityMax)
    {
        this.fuelConsumptionCityMax = fuelConsumptionCityMax;
    }

    public FuelEconomy withFuelConsumptionCityMax(PhysicalQuantity fuelConsumptionCityMax)
    {
        this.fuelConsumptionCityMax = fuelConsumptionCityMax;
        return this;
    }

    public PhysicalQuantity getFuelConsumptionOverlandMin()
    {
        return fuelConsumptionOverlandMin;
    }

    public void setFuelConsumptionOverlandMin(PhysicalQuantity fuelConsumptionOverlandMin)
    {
        this.fuelConsumptionOverlandMin = fuelConsumptionOverlandMin;
    }

    public FuelEconomy withFuelConsumptionOverlandMin(PhysicalQuantity fuelConsumptionOverlandMin)
    {
        this.fuelConsumptionOverlandMin = fuelConsumptionOverlandMin;
        return this;
    }

    public PhysicalQuantity getFuelConsumptionOverlandMax()
    {
        return fuelConsumptionOverlandMax;
    }

    public void setFuelConsumptionOverlandMax(PhysicalQuantity fuelConsumptionOverlandMax)
    {
        this.fuelConsumptionOverlandMax = fuelConsumptionOverlandMax;
    }

    public FuelEconomy withFuelConsumptionOverlandMax(PhysicalQuantity fuelConsumptionOverlandMax)
    {
        this.fuelConsumptionOverlandMax = fuelConsumptionOverlandMax;
        return this;
    }

    public PhysicalQuantity getFuelConsumptionCombinedMin()
    {
        return fuelConsumptionCombinedMin;
    }

    public void setFuelConsumptionCombinedMin(PhysicalQuantity fuelConsumptionCombinedMin)
    {
        this.fuelConsumptionCombinedMin = fuelConsumptionCombinedMin;
    }

    public FuelEconomy withFuelConsumptionCombinedMin(PhysicalQuantity fuelConsumptionCombinedMin)
    {
        this.fuelConsumptionCombinedMin = fuelConsumptionCombinedMin;
        return this;
    }

    public PhysicalQuantity getFuelConsumptionCombinedMax()
    {
        return fuelConsumptionCombinedMax;
    }

    public void setFuelConsumptionCombinedMax(PhysicalQuantity fuelConsumptionCombinedMax)
    {
        this.fuelConsumptionCombinedMax = fuelConsumptionCombinedMax;
    }

    public FuelEconomy withFuelConsumptionCombinedMax(PhysicalQuantity fuelConsumptionCombinedMax)
    {
        this.fuelConsumptionCombinedMax = fuelConsumptionCombinedMax;
        return this;
    }

    public PhysicalQuantity getFuelConsumptionElectricity()
    {
        return fuelConsumptionElectricity;
    }

    public void setFuelConsumptionElectricity(PhysicalQuantity fuelConsumptionElectricity)
    {
        this.fuelConsumptionElectricity = fuelConsumptionElectricity;
    }

    public FuelEconomy withFuelConsumptionElectricity(PhysicalQuantity fuelConsumptionElectricity)
    {
        this.fuelConsumptionElectricity = fuelConsumptionElectricity;
        return this;
    }

    public PhysicalQuantity getConsumptionOfElectricityMin()
    {
        return consumptionOfElectricityMin;
    }

    public void setConsumptionOfElectricityMin(PhysicalQuantity consumptionOfElectricityMin)
    {
        this.consumptionOfElectricityMin = consumptionOfElectricityMin;
    }

    public FuelEconomy withConsumptionOfElectricityMin(PhysicalQuantity consumptionOfElectricityMin)
    {
        this.consumptionOfElectricityMin = consumptionOfElectricityMin;
        return this;
    }

    public PhysicalQuantity getConsumptionOfElectricityMax()
    {
        return consumptionOfElectricityMax;
    }

    public void setConsumptionOfElectricityMax(PhysicalQuantity consumptionOfElectricityMax)
    {
        this.consumptionOfElectricityMax = consumptionOfElectricityMax;
    }

    public FuelEconomy withConsumptionOfElectricityMax(PhysicalQuantity consumptionOfElectricityMax)
    {
        this.consumptionOfElectricityMax = consumptionOfElectricityMax;
        return this;
    }

    public PhysicalQuantity getEmissionCO2Min()
    {
        return emissionCO2Min;
    }

    public void setEmissionCO2Min(PhysicalQuantity emissionCO2Min)
    {
        this.emissionCO2Min = emissionCO2Min;
    }

    public FuelEconomy withEmissionCO2Min(PhysicalQuantity emissionCO2Min)
    {
        this.emissionCO2Min = emissionCO2Min;
        return this;
    }

    public PhysicalQuantity getEmissionCO2Max()
    {
        return emissionCO2Max;
    }

    public void setEmissionCO2Max(PhysicalQuantity emissionCO2Max)
    {
        this.emissionCO2Max = emissionCO2Max;
    }

    public FuelEconomy withEmissionCO2Max(PhysicalQuantity emissionCO2Max)
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
