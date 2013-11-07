import java.util.Stack;

public class LabyrinthPathfinderDepthFirst extends LabyrinthPathfinder
{
    public LabyrinthPathfinderDepthFirst(Labyrinth labyrinth)
    {
        super(labyrinth);
    }

    /**
     * Gibt null zurück, wenn kein Pfad existiert, nicht null wenn doch.
     */
    @Override
    public LabyrinthPath findPath()
    {
        LabyrinthPath path = new LabyrinthPath();
        
        Stack<LabyrinthPoint> stack = new Stack<LabyrinthPoint>();
        stack.add(_labyrinth.getStart());

        while(!stack.isEmpty())
        {
            LabyrinthPoint point = stack.pop();
            
            if(point == null) break;
            
            if(point.visited) continue;
            
            point.visited = true;
            
            if(point.isGoal()) return path;
            if(point.isBlocking()) continue;
            
            stack.add(point.north);
            stack.add(point.south);
            stack.add(point.west);
            stack.add(point.east);
        }
            
        
        return null;
    }
}
