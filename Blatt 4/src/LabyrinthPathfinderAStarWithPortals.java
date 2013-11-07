
public class LabyrinthPathfinderAStarWithPortals extends LabyrinthPathfinderAStar
{
    public LabyrinthPathfinderAStarWithPortals(Labyrinth labyrinth)
    {
        super(labyrinth);
    }
    
    @Override
    protected void setHFor(LabyrinthPoint point)
    {
        LabyrinthPoint p = point.isTeleporter() ? point.teleportTarget : point;
        point.h = p.manhattanDistanceTo(_labyrinth.getGoal());
    }
}
