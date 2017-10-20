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
    Coord coord;
    Color color;
    
    //Constructeur
    public Piece(Coord coord, Color color){
        this.coord = coord;
        this.color = color;
    }
    
    public void Move(Coord coord){
        if(IsMoveOk(coord)){
          //  this.Coord.getX()= coord.x;
           // this.coord.y=coord.y;  
        }
        else{
            System.out.append("Impossible pelo!!");
        }
        
    }
    
    //Vérifie si le déplacement se trouve sur le plateau
    private boolean IsMoveOk(Coord coord){
        return false;
//        return !(coord.x<10 && coord.x>0 && (coord.y<10 && coord.y>0));
    }
    
    //testgit
}
