import java.util.LinkedList;
import java.util.List;


public class LabyrinthPriorityQueue
{
    List<LabyrinthPoint> _points;
    
    public LabyrinthPriorityQueue()
    {
        _points = new LinkedList<LabyrinthPoint>();
    }
    
    public void add(LabyrinthPoint point)
    {
        int i = 0;
        
        for(LabyrinthPoint p : _points)
        {
            if(point.value() < p.value()) break;
            ++i;
        }
        
        _points.add(i, point);
    }
    
    public LabyrinthPoint poll()
    {
        LabyrinthPoint result = _points.get(0);
        _points.remove(0);
        
        return result;
    }

    public boolean isEmpty()
    {
        return _points.isEmpty();
    }
}
