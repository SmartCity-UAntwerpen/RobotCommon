package be.uantwerpen.rc.models;


import be.uantwerpen.rc.models.map.Link;
import be.uantwerpen.rc.models.map.Point;

import javax.persistence.*;
import java.util.Objects;

/**
 * Traffic Light
 */
@Entity
@Table(name = "tlights", catalog = "\"robotDB_new\"")
public class TrafficLight
{
    /**
     * Traffic Light ID
     */
    @Id
    private Long id;
    private Long localId; //Traffic light id for the local Raspberry Pi controller
    private String state;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="pointId")
    private Point point;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="linkId")
    private Link link;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getState()
    {
        return state;
    }

    public void setState(String state)
    {
        this.state = state;
    }

    @Override
    public boolean equals(Object o)
    {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;

        TrafficLight that = (TrafficLight) o;

        if(!Objects.equals(id, that.id)) return false;
        if(state != null ? !state.equals(that.state) : that.state != null) return false;

        return true;
    }

    public Link getLink()
    {
        return link;
    }

    public void setLink(Link link)
    {
        this.link = link;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public Long getLocalId() {
        return localId;
    }

    public void setLocalId(Long localId) {
        this.localId = localId;
    }
}
