import java.util.ArrayList;
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
    
    public void reverse()
    {
        List<LabyrinthPoint> buffer = new ArrayList<>();
        for(LabyrinthPoint point : _points)
        {
            buffer.add(point);
        }
        _points = new LinkedList<>();
        for(LabyrinthPoint point : _points)
        {
            _points.add(0, point);
        }
    }
}
