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
public class Piece extends AbstractPiece{
    
    public Piece(Color color, Coord coord){
        super(color, coord);
    }

    //Vérifie si le déplacement se trouve sur le plateau
    @Override
    public boolean isMoveOk(int xFinal, int yFinal) {
        return !(this.getX()<10 && this.getX()>0 && (this.getY()<10 && this.getY()>0));
    }
    
  
}
