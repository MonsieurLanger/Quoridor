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
    Player ActualPlayer;
    Cell plateau[];
    
    
   public Board(Cell plateau[]){
       this.plateau = new Cell[324];
    }
    
   public void init(Board board){
       int k=0;
        for(int i=0;i<16;i++){
           for(int j=0;j<16;j++){
               Coord coord = new Coord(i,j);
               if(coord.x%2!=0 && coord.y%2!=0){
                   Cell cell = new Cell(coord,"Inutilisable");
                   board.plateau[k]=cell;
                   k++;
               }if((coord.x%2!=0 && coord.y%2==0)||(coord.x%2==0 && coord.y%2!=0)){
                   Cell cell = new Cell(coord,"Barriere");
                   board.plateau[k]=cell;
                   k++;
               }if(coord.x%2==0 && coord.y%2==0){
                   if((coord.x==8 && coord.y==0)||(coord.x==16 && coord.y==0)){
                     Cell cell = new Cell(coord,"Joueur");
                     board.plateau[k]=cell;
                     k++;
                   }else{
                        Cell cell = new Cell(coord,"Vide");
                        board.plateau[k]=cell;
                        k++;
                   }
               }               
           }
        }
    }
    
    public boolean isPieceHere(Cell cell){
        boolean ret=false;
        if(cell.isEmpty()==true){
            ret=true;
        }
        return ret;
    }
    
    public void placeWall(Cell cell, Board board){
        if ("Barriere".equals(cell.type)){
            if(cell.isEmpty()==true){
                cell.type="Barriere";
                cell.empty=false;
            }
        }else{
            System.out.println("Pose de barrière impossible.");
        }
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
