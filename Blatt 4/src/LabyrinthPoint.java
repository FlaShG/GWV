
public class LabyrinthPoint
{
    private final char _c;
    
    public LabyrinthPoint north;
    public LabyrinthPoint south;
    public LabyrinthPoint west;
    public LabyrinthPoint east;
    public LabyrinthPoint teleportTarget;
    
    public boolean visited = false;
    public boolean onPath = false;
    public final Vector2 position;
    
    public float cost = Float.MAX_VALUE;
    public float h = 1;
    
    
    public LabyrinthPoint(char c, Vector2 position)
    {
        _c = c;
        this.position = position;
    }
    /**
     * Zeigt uns den kürzsten Weg vom Start- zum Zielpunkt.
     */
    public char display()
    {
        return onPath ? 'o' : (visited && !isBlocking() ? '+' : _c);
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
    /*
     * Stellt fest, ob der aktuelle Punkt ein Teleporter ist.
     */
    public boolean isTeleporter()
    {
        return _c >= 48 && _c < 48+10;
    }
    /*
     * Stellt fest, um welchen Teleporter es sich handelt.
     */
    public int getTeleporterNumber()
    {
        return _c - 48;
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
        return isGoal() ? -100 : (cost + h);
    }
}
