package be.uantwerpen.rc.models;

/**
 * Location
 * Current location of a robot
 * TODO 0 usage
 */
public class Location {

    /**
     *
     */
    private long startID;
    private long stopID;
    private long percentage;
    private long vehicleID;

    public Location(){

    }

    public Long getStartID()
    {
        return startID;
    }

    public void setStartID(Long w)
    {
        this.startID = w;
    }

    public Long getStopID()
    {
        return stopID;
    }

    public void setStopID(Long w)
    {
        this.stopID = w;
    }

    public Long getPercentage()
    {
        return percentage;
    }

    public void setPercentage(Long w)
    {
        this.percentage = w;
    }

    public Long getVehicleID()
    {
        return vehicleID;
    }

    public void setVehicleID(Long v)
    {
        this.vehicleID = v;
    }

}
