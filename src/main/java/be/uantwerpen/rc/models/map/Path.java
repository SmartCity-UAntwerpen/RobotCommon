package be.uantwerpen.rc.models.map;


import java.util.ArrayList;
import java.util.List;

/**
 * Path Data Class
 * The path the robot will follow
 */
public class Path {

    private List<Point> path;

    public Path(List<Point> path) {
        this.path = path;
    }

    public Path() {
        this.path =new ArrayList<>();
    }

    public double getWeight(){
        return path.get(path.size()-1).getMinDistance();
    }
    public void addVertex(Point vertex){this.path.add(vertex);}
    public List<Point> getPath() {
        return path;
    }
}