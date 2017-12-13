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
public interface Interface_Wall {
    
    public Color getColor();

    public int getX();

    public int getY();

    public boolean isPlaceOk(int xFinal, int yFinal);

    public boolean Place(int xFinal, int yFinal);
    
}
