package Modèle;

/**
 *
 * @author NRMV4488
 */
public class Wall extends AbstractWall{

    public Wall() {
    }
    
    public static boolean isMoveOk(Coord coord_finales, Board board){
        boolean ret=false;
        int xFinal = coord_finales.x;
        int yFinal = coord_finales.y;
        if((xFinal%2!=0 && yFinal%2==0)||(xFinal%2==0 && yFinal%2!=0)){
            if(Board.findCell(coord_finales, board).empty == true){
                ret=true;
            }
        }
        return ret;
    }
}
