
public abstract class LabyrinthPathfinder
{
    protected Labyrinth _labyrinth;
    
    public LabyrinthPathfinder(Labyrinth labyrinth)
    {
        _labyrinth = labyrinth;
    }
    
    public abstract LabyrinthPath findPath() throws Exception;
}
