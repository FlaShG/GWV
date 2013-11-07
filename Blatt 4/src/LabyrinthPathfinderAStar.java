
public class LabyrinthPathfinderAStar extends LabyrinthPathfinder
{
    public LabyrinthPathfinderAStar(Labyrinth labyrinth)
    {
        super(labyrinth);
    }
    
    @Override
    public LabyrinthPath findPath()
    {
        LabyrinthPath path = new LabyrinthPath();
        
        LabyrinthPriorityQueue pq = new LabyrinthPriorityQueue();
        
        pq.add(_labyrinth.getStart());

        while(!pq.isEmpty())
        {
            System.out.println(_labyrinth);
            LabyrinthPoint point = pq.poll();
            
            if(point == null) break;
            
            if(point.visited) continue;
            point.visited = true;
            
            if(point.isGoal()) return path;

            if(point.isBlocking()) continue;
            
            pq.add(point.north);
            point.north.cost = point.cost+1;
            setHFor(point.north);
            
            pq.add(point.south);
            point.south.cost = point.cost+1;
            setHFor(point.south);
            
            pq.add(point.west);
            point.west.cost = point.cost+1;
            setHFor(point.west);
            
            pq.add(point.east);
            point.east.cost = point.cost+1;
            setHFor(point.east);
        }
            
        
        return null;
    }
    
    protected void setHFor(LabyrinthPoint point)
    {
        //point.h = point.manhattanDistanceTo(_labyrinth.getGoal());
        point.h = point.eulerDistanceTo(_labyrinth.getGoal());
    }
}