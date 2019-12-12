package be.uantwerpen.rc.models;

import javax.persistence.Embeddable;
import javax.persistence.Transient;

/**
 * Cost Data Class
 * TODO: implement class
 */
@Embeddable
public class Cost {

    @Transient
    private boolean status;
    private double weightToStart;
    private double weight;
    private double length;
    @Transient
    private long idVehicle;

    public Cost()
    {
        this.status = false;
        this.weightToStart = 0.0;
        this.weight = 0.0;
        this.length = 0.0;
        this.idVehicle = 0;

    }

    public boolean getStatus()
    {
        return status;
    }

    public void setStatus(boolean st)
    {
        this.status = st;
    }

    public double getWeightToStart()
    {
        return weightToStart;
    }

    public void setWeightToStart(double w)
    {
        this.weightToStart = w;
    }

    public double getWeight()
    {
        return weight;
    }

    public void setWeight(double w)
    {
        this.weight = w;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public Long getIdVehicle()
    {
        return idVehicle;
    }

    public void setIdVehicle(Long id)
    {
        this.idVehicle = id;
    }

    public Long getTotalCost()
    {
        return null;
    }
}
