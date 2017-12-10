/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modèle;

/**
 *
 * @author NRMV4488
 */
public abstract class AbstractPiece implements Interface_Piece{
    Coord coord;
    final Color color;

    AbstractPiece(Color color, Coord coord) {
        this.color = color;
        this.coord = coord;
    }

    @Override
    public String toString(){
        return this.getName()+" "+this.coord.toString();
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public String getName() {
        return getClass().getSimpleName();
    }

    @Override
    public int getX() {
        return coord.x;
    }

    @Override
    public int getY() {
        return coord.y;
    }

    @Override
    public boolean Move(Coord coord_finales) {
        if(isMoveOk(coord_finales)){
        coord.x = coord_finales.x;
        coord.y = coord_finales.y;
        }
        return true;
    }

    @Override
    public abstract boolean isMoveOk(Coord coord_finale);
}
