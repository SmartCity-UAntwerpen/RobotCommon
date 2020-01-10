package be.uantwerpen.rc.tools.pathplanning;

import be.uantwerpen.rc.models.map.Link;
import be.uantwerpen.rc.models.map.Path;
import be.uantwerpen.rc.models.map.Point;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * Calculates Dijkstra Path for Robot
 */
public class Dijkstra
{

    private Logger logger = LoggerFactory.getLogger(Dijkstra.class);

    /**
     * Computes Dijkstra path based on Source point and list of possible Points to visit
     * @param sourceId Source ID of Vertex
     * @param allMapVertices Map Vertices
     */
    public void computePaths(Long sourceId, List<Point> allMapVertices)
    {
        Point source = getVertexByID(allMapVertices, sourceId);
        if(source != null)
        {
            source.setMinDistance(0.0);
            Queue<Point> unVisitedVerticesQueue = new LinkedList<>();
            unVisitedVerticesQueue.add(source);
            while (!unVisitedVerticesQueue.isEmpty()) {
                Point u = unVisitedVerticesQueue.poll();
                // Visit each link exiting u
                for (Link linkOfU : u.getNeighbours()) {
                    Point targetVertexOfLink = new Point(linkOfU.getEndPoint());
                    for (Point w : allMapVertices) {
                        if (targetVertexOfLink.getId().equals(w.getId())) { // every point should have a unique id
                            targetVertexOfLink = w;
                            break;
                        }
                    }

                    double distanceThroughU = u.getMinDistance() + linkOfU.getCost().getWeight();
                    if (distanceThroughU < targetVertexOfLink.getMinDistance()) {
                        unVisitedVerticesQueue.remove(u);

                        targetVertexOfLink.setMinDistance(distanceThroughU);
                        targetVertexOfLink.setPrevious(u);
                        unVisitedVerticesQueue.add(targetVertexOfLink);
                    }
                }
            }
        }
        else
        {
            System.err.println("Error calculating path using Dijkstra");
            logger.error("Error calculating path using Dijkstra");
        }
    }

    /**
     * Calculates shortest path between given Vertex and list of available Vertices
     * Better alternative to arraylist possible?
     * @param targetId End ID of Vertex
     * @param vertexes List of available Vertices
     * @return
     */
    public Path getShortestPathTo(Long targetId, List<Point> vertexes)
    {
        Point target=getVertexByID(vertexes, targetId);
        List<Point> path = new ArrayList<>();
        for (Point vertex = target; vertex != null;  vertex = vertex.getPrevious())
            path.add(vertex);
        Collections.reverse(path);
        return new Path(path);
    }

    private Point getVertexByID(List<Point> list, Long target){
        for(Point v : list){
            if(v.getId().equals(target))
                return v;
        }
        return null;
    }

}
