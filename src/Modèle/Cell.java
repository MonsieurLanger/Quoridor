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
public class Cell {
    boolean empty;
    Coord coord = new Coord();
    
    
    //Constructeur, par défault la case est vide
    public Cell(){
        this.empty = true;
    }
    
    boolean isEmpty(){
        return this.empty;
    }
    
    Coord getPiece(){
        if (this.isEmpty()== false){
            return this.coord;
        }
        else{
            return null;
        }
    }
    
    
    
}
