/**
 *Ermittelt im momentan verwendeten Labyrinth die Positionen des Starts, des Ziels, sowie der Teleporter
 *zur weiteren Verwendung.
 */
public class Labyrinth
{
    private LabyrinthPoint[][] _points;
    private LabyrinthPoint _start;
    private LabyrinthPoint _goal;
    
    
    public Labyrinth(char[][] data)
    {
        LabyrinthPoint[] teleportBuddies = new LabyrinthPoint[10];
        
        _points = new LabyrinthPoint[data.length][data[0].length];
        for(int y = 0; y < data.length; ++y)
        {
            for(int x = 0; x < data[y].length; ++x)
            {
                LabyrinthPoint point = new LabyrinthPoint(data[y][x], new Vector2(x,y));
                _points[y][x] = point;
                
                if(point.isStart())
                {
                    _start = point;
                    _start.cost = 0;
                }
                if(point.isGoal())
                {
                    _goal = point;
                }
                if(point.isTeleporter())
                {
                    if(teleportBuddies[point.getTeleporterNumber()] == null)
                    {
                        teleportBuddies[point.getTeleporterNumber()] = point;
                    }
                    else
                    {
                        teleportBuddies[point.getTeleporterNumber()].teleportTarget = point;
                        point.teleportTarget = teleportBuddies[point.getTeleporterNumber()];
                    }
                }
            }
        }
        
        for(int y = 0; y < data.length-1; ++y)
        {
            for(int x = 0; x < data[y].length-1; ++x)
            {
                _points[y][x].east = _points[y][x+1];
                _points[y][x+1].west= _points[y][x];
                _points[y][x].south = _points[y+1][x];
                _points[y+1][x].north = _points[y][x];
            }
        }
    }
    
    public int getWidth()
    {
        return _points[0].length;
    }
    
    public int getHeight()
    {
        return _points.length;
    }
    /**
     * Bestimmt die Position des aktuellen Punktes
     */
    public LabyrinthPoint getPoint(int x, int y) throws Exception
    {
        if(x < 0 || x >= getWidth()
        || y < 0 || y >= getHeight()) throw new Exception("Invalid position.");
        
        return _points[y][x];
    }
    
    public LabyrinthPoint getPoint(Vector2 position) throws Exception
    {
        return getPoint(position.x, position.y);
    }
    
    public LabyrinthPoint getStart()
    {
        return _start;
    }
    
    @Override
    public String toString()
    {
        StringBuilder result = new StringBuilder();
        
        for(int y = 0; y < _points.length; ++y)
        {
            for(int x = 0; x < _points[y].length; ++x)
            {
                result.append(_points[y][x].display());
            }
            result.append("\r\n");
        }
        
        return result.toString();
    }

    public LabyrinthPoint getGoal()
    {
        return _goal;
    }
}
