package be.uantwerpen.rc.models;

import be.uantwerpen.rc.models.map.Point;

import javax.persistence.*;

/**
 * Location
 * Current location of a robot
 * TODO 0 usage
 */
@Entity
@Table(name="location", catalog = "\"robotDB_new\"")
public class Location {

    /**
     *  Location id
     */
    @Id
    private long id;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="start")
    private Point startID;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="stop")
    private Point stopID;
    private long percentage;
    private long vehicleID;

    public Location(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Point getStartID() {
        return startID;
    }

    public void setStartID(Point startID) {
        this.startID = startID;
    }

    public Point getStopID() {
        return stopID;
    }

    public void setStopID(Point stopID) {
        this.stopID = stopID;
    }

    public long getPercentage() {
        return percentage;
    }

    public void setPercentage(long percentage) {
        this.percentage = percentage;
    }

    public long getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(long vehicleID) {
        this.vehicleID = vehicleID;
    }
}
