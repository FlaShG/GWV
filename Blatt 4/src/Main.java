
public class Main
{
    public static final boolean debug = false;

    public static void main(String[] args)
    {
        Labyrinth labyrinth = new Labyrinth(LabyrinthDataLoader.load("data_teleport.txt"));
        
        System.out.println(new LabyrinthPathfinderAStar(labyrinth).findPath() != null);
        System.out.println(labyrinth);
    }
}
