
public class Main
{
    public static final boolean debug = true;

    public static void main(String[] args)
    {
        Labyrinth labyrinth = new Labyrinth(LabyrinthDataLoader.load("data.txt"));
        
        System.out.println(new LabyrinthPathfinderAStar(labyrinth).findPath() != null);
        System.out.println(labyrinth);
    }
}
