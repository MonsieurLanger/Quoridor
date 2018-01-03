/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modèle;

/**
 *
 * @author hariri
 */
public class AbstractWall implements Interface_Wall {

    Coord coord;

    public AbstractWall() {
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
    public boolean Move(int xfinal, int yFinal) {
        boolean bool = false;
        return bool;
    }

    @Override
    public boolean isMoveOK(int x, int y) {
        boolean bool = false;
        return bool;
    }

}
