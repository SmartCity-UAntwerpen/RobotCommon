package be.uantwerpen.rc.tools.pathplanning;

import be.uantwerpen.rc.models.map.Path;
import be.uantwerpen.rc.tools.Edge;
import be.uantwerpen.rc.tools.Vertex;

import java.util.*;

/**
 * Calculates Dijkstra Path for Robot
 */
public class Dijkstra
{
    /**
     * Computes Dijkstra path based on Source Vertex and list of possible Vertices to visit
     * @param sourceId Source ID of Vertex
     * @param vertexes Map Vertices
     */
    public void computePaths(Long sourceId, List<Vertex> vertexes)
    {
        Vertex source=getVertexByID(vertexes, sourceId);
        source.setMinDistance(0);
        Queue<Vertex> vertexQueue = new LinkedList<>();
        vertexQueue.add(source);
        while (!vertexQueue.isEmpty()) {
            Vertex u = vertexQueue.poll();
            Vertex v = new Vertex(1L);
            // Visit each edge exiting u
            for (Edge e : u.getAdjacencies())
            {
                for (Vertex w : vertexes){
                    if(Objects.equals(w.getId(), e.getTarget())){
                        v =w;
                        break;
                    }
                }

                double distanceThroughU = u.getMinDistance() + e.getWeight();
                if (distanceThroughU < v.getMinDistance()) {
                    vertexQueue.remove(v);

                    v.setMinDistance(distanceThroughU) ;
                    v.setPrevious(u);
                    vertexQueue.add(v);
                }
            }
        }
    }

    /**
     * Calculates shortest path between given Vertex and list of available Vertices
     * Better alternative to arraylist possible?
     * @param targetId End ID of Vertex
     * @param vertexes List of available Vertices
     * @return
     */
    public Path getShortestPathTo(Long targetId, List<Vertex> vertexes)
    {
        Vertex target=getVertexByID(vertexes, targetId);
        List<Vertex> path = new ArrayList<>();
        for (Vertex vertex = target; vertex != null;  vertex = vertex.getPrevious())
            path.add(vertex);
        Collections.reverse(path);
        return new Path(path);
    }

    private Vertex getVertexByID(List<Vertex> list, Long target){
        for(Vertex v : list){
            if(v.getId()==target)
                return v;
        }
        return null;
    }

}
