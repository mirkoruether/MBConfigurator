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

public class TechnicalInformation implements Serializable
{

    @SerializedName("engine")
    @Expose
    private Engine engine;
    @SerializedName("energyEfficiencyClass")
    @Expose
    private String energyEfficiencyClass;
    @SerializedName("transmission")
    @Expose
    private Transmission transmission;
    @SerializedName("acceleration")
    @Expose
    private PhysicalSize acceleration;
    @SerializedName("topSpeed")
    @Expose
    private PhysicalSize topSpeed;
    @SerializedName("doors")
    @Expose
    private int doors;
    @SerializedName("seats")
    @Expose
    private int seats;
    private final static long serialVersionUID = -1699390174506713143L;

    /**
     * No args constructor for use in serialization
     *
     */
    public TechnicalInformation()
    {
    }

    /**
     *
     * @param doors
     * @param engine
     * @param acceleration
     * @param energyEfficiencyClass
     * @param seats
     * @param transmission
     * @param topSpeed
     */
    public TechnicalInformation(Engine engine, String energyEfficiencyClass, Transmission transmission, PhysicalSize acceleration, PhysicalSize topSpeed, int doors, int seats)
    {
        super();
        this.engine = engine;
        this.energyEfficiencyClass = energyEfficiencyClass;
        this.transmission = transmission;
        this.acceleration = acceleration;
        this.topSpeed = topSpeed;
        this.doors = doors;
        this.seats = seats;
    }

    public Engine getEngine()
    {
        return engine;
    }

    public void setEngine(Engine engine)
    {
        this.engine = engine;
    }

    public TechnicalInformation withEngine(Engine engine)
    {
        this.engine = engine;
        return this;
    }

    public String getEnergyEfficiencyClass()
    {
        return energyEfficiencyClass;
    }

    public void setEnergyEfficiencyClass(String energyEfficiencyClass)
    {
        this.energyEfficiencyClass = energyEfficiencyClass;
    }

    public TechnicalInformation withEnergyEfficiencyClass(String energyEfficiencyClass)
    {
        this.energyEfficiencyClass = energyEfficiencyClass;
        return this;
    }

    public Transmission getTransmission()
    {
        return transmission;
    }

    public void setTransmission(Transmission transmission)
    {
        this.transmission = transmission;
    }

    public TechnicalInformation withTransmission(Transmission transmission)
    {
        this.transmission = transmission;
        return this;
    }

    public PhysicalSize getAcceleration()
    {
        return acceleration;
    }

    public void setAcceleration(PhysicalSize acceleration)
    {
        this.acceleration = acceleration;
    }

    public TechnicalInformation withAcceleration(PhysicalSize acceleration)
    {
        this.acceleration = acceleration;
        return this;
    }

    public PhysicalSize getTopSpeed()
    {
        return topSpeed;
    }

    public void setTopSpeed(PhysicalSize topSpeed)
    {
        this.topSpeed = topSpeed;
    }

    public TechnicalInformation withTopSpeed(PhysicalSize topSpeed)
    {
        this.topSpeed = topSpeed;
        return this;
    }

    public int getDoors()
    {
        return doors;
    }

    public void setDoors(int doors)
    {
        this.doors = doors;
    }

    public TechnicalInformation withDoors(int doors)
    {
        this.doors = doors;
        return this;
    }

    public int getSeats()
    {
        return seats;
    }

    public void setSeats(int seats)
    {
        this.seats = seats;
    }

    public TechnicalInformation withSeats(int seats)
    {
        this.seats = seats;
        return this;
    }

    @Override
    public int hashCode()
    {
        return new HashCodeBuilder().append(doors).append(engine).append(acceleration).append(energyEfficiencyClass).append(seats).append(transmission).append(topSpeed).toHashCode();
    }

    @Override
    public boolean equals(Object other)
    {
        if(other == this)
        {
            return true;
        }
        if((other instanceof TechnicalInformation) == false)
        {
            return false;
        }
        TechnicalInformation rhs = ((TechnicalInformation)other);
        return new EqualsBuilder().append(doors, rhs.doors).append(engine, rhs.engine).append(acceleration, rhs.acceleration).append(energyEfficiencyClass, rhs.energyEfficiencyClass).append(seats, rhs.seats).append(transmission, rhs.transmission).append(topSpeed, rhs.topSpeed).isEquals();
    }

}
