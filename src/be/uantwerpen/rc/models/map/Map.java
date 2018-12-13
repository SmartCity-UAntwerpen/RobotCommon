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
    private List<Node> nodeList;

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
        nodeList = new ArrayList<>();
        botEntities = new ArrayList<>();
    }

    /**
     * Adds Node to map
     * @param node node to map
     */
    public void addNode(Node node){
        nodeList.add(node);
    }

    /**
     * Sets List of map nodes
     * @param nodeList list of nodes to set
     */
    public void setNodeList(List<Node> nodeList) {
        this.nodeList = nodeList;
    }

    /**
     * Gets list of map nodes
     * @return list of nodes
     */
    public List<Node> getNodeList()
    {
        return nodeList;
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
                "nodeList=" + nodeList +
                ", botEntities=" + botEntities +
                ", trafficlightEntity=" + trafficlightEntity +
                '}';
    }
}

