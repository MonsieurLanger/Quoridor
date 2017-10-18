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
    Coordp coordp;
    Color color;
    
    //Constructeur
    public Piece(Coordp coordp, Color color){
        this.coordp = coordp;
        this.color = color;
    }
    
    public void Move(Coordp coordp){
        if(IsMoveOk(coordp)){
            this.coordp.x=coordp.x;
            this.coordp.y=coordp.y;  
        }
        else{
            System.out.append("Impossible pelo!!");
        }
        
    }
    
    private boolean IsMoveOk(Coordp coordp){
        if((coordp.x<10 && coordp.x>0))
    }
}
