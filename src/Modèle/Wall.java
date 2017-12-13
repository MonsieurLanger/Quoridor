package Modèle;

/**
 *
 * @author NRMV4488
 */
public class Wall extends AbstractWall{
    
    public Wall(Coord coordwall, Color colorwall) {
        super(coordwall, colorwall);
    }
    public boolean isMoveOk(int xFinal, int yFinal) {
        return !(this.getX()<9 && this.getX()>0 && (this.getY()<9 && this.getY()>0));
    }
}
