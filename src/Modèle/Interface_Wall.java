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
public interface Interface_Wall {
    public Color getColor();
    public int getX();
    public int getY();
    public boolean Place(int xfinal,int yFinal);
    public boolean isPlaceOK(int x,int y);
    
}
