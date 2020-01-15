package be.uantwerpen.rc.models.map;

import be.uantwerpen.rc.models.Bot;

import javax.persistence.*;
import java.util.List;

@Entity(name = "Points")
@Table(name = "points", catalog = "\"robotDB_new\"")
public class Point {

    @Id
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="tileId")
    private Tile tile;

    /**
     * List of neighbouring Links (from which this point is a start/end point) (currently not in db)
     */
    @Transient
    private List<Link> neighbours;

    //@Column(columnDefinition = "double default = 100000.0")
    private double minDistance = 1000000.0;
    //private double minDistance = Double.POSITIVE_INFINITY;

    @OneToOne
    @JoinColumn(name="previousPoint")
    private Point previous;

    public Point(){}

    public Point(Long id)
    {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTile(Tile tile) {
        this.tile = tile;
    }

    public Tile getTile() {
        return this.tile;
    }

    public void setTileLock(boolean status, Bot botId){
        tile.setLocked(status);
        tile.setLockedBy(botId);
    }

    public boolean getTileLock(){
        return tile.getLocked();
    }

    public List<Link> getNeighbours() {
        return neighbours;
    }

    public void setNeighbours(List<Link> neighbours) {
        this.neighbours = neighbours;
    }

    public double getMinDistance() {
        return minDistance;
    }

    public void setMinDistance(double minDistance) {
        this.minDistance = minDistance;
    }

    public Point getPrevious() {
        return previous;
    }

    public void setPrevious(Point previous) {
        this.previous = previous;
    }

    @Override
    public String toString() {
        return "Node{" +
                "nodeId=" + this.id +
                ", neighbours=" + neighbours +
                '}';
    }
}
