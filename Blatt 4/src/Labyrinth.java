
public class Labyrinth
{
    private LabyrinthPoint[][] _points;
    private LabyrinthPoint _start;
    private LabyrinthPoint _goal;
    
    
    public Labyrinth(char[][] data)
    {
        _points = new LabyrinthPoint[data.length][data[0].length];
        for(int y = 0; y < data.length; ++y)
        {
            for(int x = 0; x < data[y].length; ++x)
            {
                _points[y][x] = new LabyrinthPoint(data[y][x], new Vector2(x,y));
                if(_points[y][x].isStart())
                {
                    _start = _points[y][x];
                }
                if(_points[y][x].isGoal())
                {
                    _goal = _points[y][x];
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
