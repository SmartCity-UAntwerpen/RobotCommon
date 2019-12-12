package be.uantwerpen.rc.models.map;


import be.uantwerpen.rc.models.Bot;
import be.uantwerpen.rc.models.Cost;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "links", catalog = "\"robotDB_new\"")
public class Link {

    @Id
    private Long id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="start")
    private Point startPoint;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="end")
    private Point endPoint;

    private Cost cost;
    private double angle;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="linkLockId")
    private LinkLock lock;

    public Link()
    {
        this.id = 0L;
        this.startPoint = new Point();
        this.endPoint = new Point();
        this.cost = new Cost();
        this.angle = 0.0;
        this.lock = new LinkLock();
    }

    public Link(Long targetId, Double weight)
    {
        this.id = targetId;
        this.startPoint = new Point();
        this.endPoint = new Point();
        this.cost = new Cost();
        this.cost.setWeight(weight);
        this.angle = 0.0;
        this.lock = new LinkLock();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    @OneToOne
    @JoinColumn(name = "\"start\"")
    public Point getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(Point startPoint) {
        this.startPoint = startPoint;
    }

    @OneToOne
    @JoinColumn(name = "\"end\"")
    public Point getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(Point endPoint) {
        this.endPoint = endPoint;
    }

    public Cost getCost() {
        return cost;
    }

    public void setCost(Cost cost) {
        this.cost = cost;
    }

    public double getAngle() {
        return angle;
    }

    public void setAngle(int angle) {
        this.angle = angle;
    }

    public LinkLock getLock() {
        return lock;
    }

    public void setLock(LinkLock lock) {
        this.lock = lock;
    }

    public void lockLink(Boolean status, Bot lockedBy){
        this.lock.setStatus(status);
        this.lock.setLockedBy(lockedBy);
    }

    public Boolean getLockStatus(){
        return lock.getStatus();
    }

    @Override
    public boolean equals(Object o)
    {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;

        Link that = (Link) o;

        if(!Objects.equals(id, that.id)) return false;

        return true;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }

    public Long getTarget() {
        return this.endPoint.getId();
    }

    public void setTarget(Long target) {
        this.endPoint.setId(target);
    }
}
