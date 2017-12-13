package Modèle;

/**
 *
 * @author NRMV4488
 */
public class Wall extends AbstractWall{
    
    
    public Wall(Coord coord){
        super(coord);
    }

    //Vérifie si la barrière peut être placée sur ces cases
    @Override
    public boolean isPlaceOk(int xLeftOrUp, int yLeftOrUp) {
        return ((this.getX()%2==1 && this.getY()%2==1) || (this.getX()%2==0 && this.getY()%2==0)
                && ((this.getX()>=0 || this.getY()>=0 )) && ((this.getX()<18 || this.getY()<18 )));
    }
}
