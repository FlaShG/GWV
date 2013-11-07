import java.util.LinkedList;
import java.util.List;


public class LabyrinthPath
{
    private List<LabyrinthPoint> _points;
    
    public LabyrinthPath()
    {
        _points = new LinkedList<>();
    }
    
    public void addPoint(LabyrinthPoint point)
    {
        _points.add(point);
    }
    
    public void removePoint()
    {
        _points.remove(_points.size()-1);
    }
}
