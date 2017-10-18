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
public class Piece {
    private Coord coord;
    Color color;
    
    //Constructeur
    public Piece(Coord coord, Color color){
        this.coord = coord;
        this.color = color;
    }
    
    public void Move(Coord coord){
        if(IsMoveOk(coord)){
            this.coord.setX(coord.getX());
            this.coord.setY(coord.getY());  
        }
        else{
            System.out.append("Impossible pelo!!");
        }
        
    }
    
    //Vérifie si le déplacement se trouve sur le plateau
    private boolean IsMoveOk(Coord coord){
        return !(coord.getX()<10 && coord.getX()>0 && (coord.getY()<10 && coord.getY()>0));
    }
    
  
}
