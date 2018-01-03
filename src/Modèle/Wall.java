package Modèle;

/**
 *
 * @author NRMV4488
 */
public class Wall extends AbstractWall {

    Coord coord2;

    public Wall() {
    }

    public Wall(Coord coord, Coord coord2) {
        this.coord = coord;
        this.coord2 = coord2;
    }

    public static boolean isMoveOk(Coord coord_finales1, Coord coord_finales2, Board board) {
        boolean ccord1Ok = false;
        int xFinal = coord_finales1.x;
        int yFinal = coord_finales1.y;
        if ((xFinal % 2 != 0 && yFinal % 2 == 0) || (xFinal % 2 == 0 && yFinal % 2 != 0)) {
            if (Board.findCell(coord_finales1, board).empty == true) {
                ccord1Ok = true;
            }
        }
        boolean ccord2Ok = false;
        xFinal = coord_finales2.x;
        yFinal = coord_finales2.y;
        if ((xFinal % 2 != 0 && yFinal % 2 == 0) || (xFinal % 2 == 0 && yFinal % 2 != 0)) {
            if (Board.findCell(coord_finales2, board).empty == true) {
                ccord2Ok = true;
            }
        }
        if (ccord1Ok && ccord2Ok) {
            return true;
        } else {
            board.setLastMoveErrorMsg("Il est impossible de placer une barrière sur une autre!");
            return false;
        }
    }
}
