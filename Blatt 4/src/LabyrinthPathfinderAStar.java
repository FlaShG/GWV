public class LabyrinthPathfinderAStar extends LabyrinthPathfinder
{
    public LabyrinthPathfinderAStar(Labyrinth labyrinth)
    {
        super(labyrinth);
    }

    @Override
    public LabyrinthPath findPath()
    {
        LabyrinthPath path = null;

        LabyrinthPriorityQueue pq = new LabyrinthPriorityQueue();

        pq.add(_labyrinth.getStart());
        _labyrinth.getStart().visited = true;

        while(!pq.isEmpty())
        {
            LabyrinthPoint point = pq.poll();

            //if(point.visited) continue;
            //point.visited = true;
            
            if(Main.debug) System.out.println(_labyrinth);

            if(point.isGoal())
            {
                path = new LabyrinthPath();
                break;
            }

            //if(point.isBlocking()) continue;

            if(point.isTeleporter() && !point.teleportTarget.visited && !point.teleportTarget.isBlocking())
            {
                point.teleportTarget.cost = point.cost + 1;
                point.teleportTarget.visited = true; 
                setHFor(point.teleportTarget);
                pq.add(point.teleportTarget);
            }
            
            if(!point.north.visited && !point.north.isBlocking())
            {
                point.north.cost = point.cost + 1;
                point.north.visited = true; 
                setHFor(point.north);
                pq.add(point.north);
            }

            if(!point.south.visited && !point.south.isBlocking())
            {
                point.south.cost = point.cost + 1;
                point.south.visited = true; 
                setHFor(point.south);
                pq.add(point.south);
            }

            if(!point.west.visited && !point.west.isBlocking())
            {
                point.west.cost = point.cost + 1;
                point.west.visited = true; 
                setHFor(point.west);
                pq.add(point.west);
            }

            if(!point.east.visited && !point.east.isBlocking())
            {
                point.east.cost = point.cost + 1;
                point.east.visited = true; 
                setHFor(point.east);
                pq.add(point.east);
            }
        }

        //if(true) return path;
        
        if(path != null)
        {
            LabyrinthPoint current = _labyrinth.getGoal();

            path.addPoint(current);

            boolean startFound = false;
            while(!startFound)
            {
                current = getPointWithLowestCostThatIsNotOnPath(current.west, current.east, current.north, current.south, current.teleportTarget);
                path.addPoint(current);
                current.onPath = true;
                if(Main.debug) System.out.println(_labyrinth);
                startFound = current.isStart();
            }

            path.reverse();
        }

        return path;
    }

    private LabyrinthPoint getPointWithLowestCostThatIsNotOnPath(LabyrinthPoint... points)
    {
        LabyrinthPoint result = null;
        float bestCost = Float.MAX_VALUE;
        
        for(int i = 0; i < points.length; ++i)
        {
            if(points[i] != null && !points[i].onPath && points[i].cost < bestCost)
            {
                result = points[i];
                bestCost = result.cost;
            }
        }

        return result;
    }

    protected void setHFor(LabyrinthPoint point)
    {
        point.h = point.manhattanDistanceTo(_labyrinth.getGoal());
        // point.h = point.eulerDistanceTo(_labyrinth.getGoal());
    }
}