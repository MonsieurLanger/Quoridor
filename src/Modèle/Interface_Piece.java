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
public interface Interface_Piece {

    public Color getColor();
    
    public String getName();

    public int getX();

    public int getY();

    public boolean isMoveOk(int xFinal, int yFinal);

    public boolean Move(int xFinal, int yFinal);
    
}
