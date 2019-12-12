package be.uantwerpen.rc.models.map;

import be.uantwerpen.rc.models.Bot;
import be.uantwerpen.rc.models.TrafficLight;

import java.util.ArrayList;
import java.util.List;

/**
 * Map of the area
 * Data class
 */
public class Map
{
    /**
     * List of nodes on map
     */
    private List<Point> pointList;

    /**
     * List of bots on map
     */
    private List<Bot> botEntities;

    /**
     * List of traffic lights on map
     */
    private List<TrafficLight> trafficlightEntity;

    /**
     * Default Constructor
     */
    public Map(){
        pointList = new ArrayList<>();
        botEntities = new ArrayList<>();
    }

    /**
     * Adds Point to map
     * @param point point to map
     */
    public void addPoint(Point point){
        pointList.add(point);
    }

    /**
     * Sets List of map points
     * @param pointList list of points to set
     */
    public void setPointList(List<Point> pointList) {
        this.pointList = pointList;
    }

    /**
     * Gets list of map points
     * @return list of points
     */
    public List<Point> getPointList()
    {
        return pointList;
    }

    public Point getPointById(Long id) {
        for(Point point: pointList) {
            if(point.getId().equals(id)) {
                return point;
            }
        }
        return null;
    }

    public Long getLocationByRFID (String rfid) {
        rfid = rfid.trim().replace(" ","").toUpperCase();
        Long pointID = -1L;
        for(Point point: pointList) {
            if(point.getTile().getRfid().trim().replace(" ","").toUpperCase().equals(rfid)){
                pointID = point.getId();
            }
        }
        return pointID;
    }

    /**
     * Sets List of map Bots
     * @param botEntities
     */
    public void setBotEntities(List<Bot> botEntities) {
        this.botEntities = botEntities;
    }

    /**
     * Gets list of map bots
     * @return list of map bots
     */
    public List<Bot> getBotEntities() {
        return botEntities;
    }

    /**
     * Sets List of Map Traffic Lights
     * @param trafficlightEntity List of Map TrafficLights
     */
    public void setTrafficlightEntity(List<TrafficLight> trafficlightEntity) {
        this.trafficlightEntity = trafficlightEntity;
    }

    /**
     * Gets List of Map TrafficLights
     * @return List of Map TrafficLights
     */
    public List<TrafficLight> getTrafficlightEntity() {
        return trafficlightEntity;
    }

    @Override
    public String toString() {
        return "AbstractMap{" +
                "pointList=" + pointList +
                ", botEntities=" + botEntities +
                ", trafficlightEntity=" + trafficlightEntity +
                '}';
    }
}

