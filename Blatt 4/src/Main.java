
public class Main
{
    public static final boolean debug = false;

    public static void main(String[] args)
    {
        pathfindingOn("data.txt");
        pathfindingOn("data_blocked.txt");
        pathfindingOn("data_teleport.txt");
        pathfindingOn("data_wtf.txt");
    }
    
    private static void pathfindingOn(String filename)
    {
        Labyrinth labyrinth = new Labyrinth(LabyrinthDataLoader.load(filename));
        
        long startTime = System.currentTimeMillis();
        
        System.out.println(new LabyrinthPathfinderAStar(labyrinth).findPath() != null);
        
        
        long delta = System.currentTimeMillis() - startTime;
        System.out.println(labyrinth);
        System.out.println("...and I needed "+(delta / 1000f)+" Seconds for that!");
    }
}
