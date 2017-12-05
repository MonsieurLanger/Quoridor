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
    
    
   public Board(){
       this.plateau = new Cell[289];
    }
    
   public static void init_Board(Board board){
       int k=0;
        for(int i=0;i<17;i++){
           for(int j=0;j<17;j++){
               Coord coord = new Coord(i,j);
               if(coord.x%2!=0 && coord.y%2!=0){
                   Cell cell = new Cell(coord,"Inutilisable");
                   board.plateau[k]=cell;
                   cell.indice=k;
                   k++;
               }if((coord.x%2!=0 && coord.y%2==0)||(coord.x%2==0 && coord.y%2!=0)){
                   Cell cell = new Cell(coord,"Barriere");
                   board.plateau[k]=cell;
                   cell.indice=k;
                   k++;
               }if(coord.x%2==0 && coord.y%2==0){
                   if((coord.x==8 && coord.y==0)||(coord.x==8 && coord.y==16)){
                     Cell cell = new Cell(coord,"Joueur");
                     cell.empty=false;
                     board.plateau[k]=cell;
                     cell.indice=k;
                     k++;
                   }else{
                        Cell cell = new Cell(coord,"Vide");
                        board.plateau[k]=cell;
                        cell.indice=k;
                        k++;
                   }
               }               
           }
        }
    }
    
    public static boolean isPieceHere(Cell cell){
        boolean ret=false;
        if(cell.isEmpty()==true){
            ret=true;
        }
        return ret;
    }
    
    public void placeWall(Cell cell){
        if ("Barriere".equals(cell.type)){
            if(cell.isEmpty()==true){
                cell.type="Barriere";
                cell.empty=false;
            }
        }else{
            System.out.println("Pose de barrière impossible.");
        }
    }
    
    public boolean movePiece(){//reste à gérer type ancienne case et nouvelle case
        boolean ret=false;
        return ret;
        
    }
    
    /*public void switchPlayer(){
        if(ActualPlayer==Player[0]){
            ActualPlayer=Player[1];
        }else{
            ActualPlayer=Player[0];
        }
    }
        }*///A TESTER//

    public boolean isEnd(){
        return false;
    }
    
    public static void main(String[] args){
        int cptr=0;
        Board board_test = new Board();
        init_Board(board_test);
        for (int i=0;i<board_test.plateau.length;i++){
            //System.out.println(i+". Case:" + board_test.plateau[i]);
            if(board_test.plateau[i].empty==false){
                    cptr++;
                    System.out.println("Coordonnées du joueur "+cptr+" : "+board_test.plateau[i].coord+ "["+i+"]");
            }
        }
       System.out.println("Piece vide? "+isPieceHere(board_test.plateau[152]));
    }
    
    
}
