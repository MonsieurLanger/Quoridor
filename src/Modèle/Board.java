/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modèle;

/**
 *
 * @author nrmv4488
 */
public class Board {
    String type;
    Player ActualPlayer;
    Cell plateau[][];
    
   // public Cell[][] {
    
//}
    
    public boolean isPieceHere(){
        boolean ret=false;
        return ret;
    }
    
    public boolean placeWall(){
        boolean ret=false;
        return ret;
    }
    
    public boolean movePiece(){
        boolean ret=false;
        return ret;
        
    }
    
    /*public void switchPlayer(){
        if(ActualPlayer==Player[0]){
            ActualPlayer=Player[1];
        }else{
            ActualPlayer=Player[0];
        }
    }*/
    
    public boolean isEnd(){
        return false;
    }
    
    
    
}
