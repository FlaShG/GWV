/**
 * 
 * @author Sascha Gräf & Felix Templin
 * GWV Blatt 04
 *
 */

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
    /**
     * Durchsucht die aktuelle Datei und gibt den kürzesten Zielpfad sowie die benötigte Zeit aus.
     * 
     */
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
