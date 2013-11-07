
public class LabyrinthPoint
{
    private char _c;
    
    public LabyrinthPoint north;
    public LabyrinthPoint south;
    public LabyrinthPoint west;
    public LabyrinthPoint east;
    
    public boolean visited = false;
    public final Vector2 position;
    
    public float cost = 0;
    public float h = 1;
    
    
    public LabyrinthPoint(char c, Vector2 position)
    {
        _c = c;
        this.position = position;
    }
    
    public char display()
    {
        return visited && !isBlocking() ? '+' : _c;
    }

    public boolean isBlocking()
    {
        return _c == 'x';
    }
    
    public boolean isGoal()
    {
        return _c == 'g';
    }

    public boolean isStart()
    {
        return _c == 's';
    }
    
    public int manhattanDistanceTo(LabyrinthPoint other)
    {
        return Vector2.manhattanDistance(position, other.position);
    }
    
    public float eulerDistanceTo(LabyrinthPoint other)
    {
        return Vector2.eulerDistance(position, other.position);
    }
    
    public float value()
    {
        return cost + h;
    }
}
