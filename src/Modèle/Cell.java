/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modèle;

/**
 *
 *  Represent a single square on the quoridor grid.
 * @author nrmv4488
 */

public class Cell {
    boolean empty;
    Coord coord;
  
    
    //Constructeur, par défault la case est vide
    public Cell(Coord coord){
        this.coord = coord;
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
    
  /*public static void main(String [] args){
       int x= 0;
        int y= 0;
        Coord coord[];
        coord = new Coord[5];
        for(int i=0; i<5; i++){
            if (coord_valides(x,y)){
            coord[i]=new Coord(x,y);
            x++;
            y++;
            }
            else{
                System.out.println("Erreur de coordonnées.");
            }
        }       
      Cell tab[];
        tab = new Cell[5];
      for(int j=0; j<5; j++){
          tab[j] = new Cell(coord[j]);
          System.out.printf("tab[j]= "+tab[j].coord+"\n");
      }
  }*/  
    
    
}
