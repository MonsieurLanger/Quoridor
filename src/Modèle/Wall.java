package Modèle;

/**
 *
 * @author NRMV4488
 */
public class Wall extends AbstractWall{
    
    
    public Wall( Color color, Coord coord){
        super(color, coord);
    }

    //Vérifie si la barrière peut être placée sur ces cases
    //On peut additionner les deux coordonnées pour x et les deux pour y (respect de la parité)
    @Override
    public boolean isPlaceOk(int xFinal, int yFinal) {
        return ((this.getX()%2==1 && this.getY()%2==1) || (this.getX()%2==0 && this.getY()%2==0));
    }
}
