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
public class AbstractWall implements Interface_Wall{
    Coord coordwall;
    Color colorwall;

    public AbstractWall(Coord coordwall, Color colorwall) {
        this.coordwall = coordwall;
        this.colorwall = colorwall;
    }

    @Override
    public Color getColor() {
       return colorwall;
    }

    @Override
    public int getX() {
        return coordwall.x;
    }

    @Override
    public int getY() {
        return coordwall.y;
    }

    @Override
    public boolean Place(int xfinal, int yFinal) {
        boolean bool=false;
        return bool;
    }

    @Override
    public boolean isPlaceOK(int x, int y) {
        boolean bool=false;
        return bool; 
    }
    
    
}
