/*
 * Klasse zur Berechnung des Restabstandes zum Ziel.
 * Es besteht die Möglichkeit, die Eulersche Distanz oder die Manhattan-Distanz zu berechnen.
 */
public class Vector2
{
    public int x;
    public int y;
    
    public Vector2(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    
    @Override
    public Vector2 clone()
    {
        return new Vector2(x,y);
    }
    
    public static int manhattanDistance(Vector2 a, Vector2 b)
    {
        return abs(a.x - b.x) + abs(a.y - b.y); 
    }
    
    public static float eulerDistance(Vector2 a, Vector2 b)
    {
        return (float)Math.sqrt(Math.pow(a.x-b.x, 2) + Math.pow(a.y-b.y, 2));
    }
    
    private static int abs(int i)
    {
        return i < 0 ? -i : i;
    }
}
