package be.uantwerpen.rc.tools.pathplanning;

import be.uantwerpen.rc.models.map.Map;
import be.uantwerpen.rc.models.map.Path;

/**
 * Path Planning interface TODO
 */
public interface IPathplanning
{
    Path CalculatePath(int start, int stop);
    double CalculatePathWeight(int start, int stop);
    Path nextRandomPath(Map map, int start);

}
