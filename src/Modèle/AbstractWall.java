/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modèle;

/**
 *
 * @author cbl.ho
 */
public abstract class AbstractWall implements Interface_Wall{
    Coord coord;
    private final Color color;

    AbstractWall(Color color, Coord coord) {
        this.color = color;
        this.coord = coord;
    }

    @Override
    public Color getColor() {
        return color;
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
    public boolean Place(int xFinal, int yFinal) {
        coord.x = xFinal;
        coord.y = yFinal;
        return true;
    }

    @Override
    public abstract boolean isPlaceOk(int xFinal,
                                     int yFinal);
}
