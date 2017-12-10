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
    //Player ActualPlayer; pour implémentation de Game.java
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
         
    
    public boolean isMoveOk(Piece piece, Cell cell_finale){
        boolean ret=false;
        if(piece.isMoveOk(cell_finale.coord)){
            if(!"Joueur".equals(cell_finale.type)){//vérif s'il y a un joueur
                //récup si déplacement +/-1 en x/y --> voir si x==finale.x etc
                //avec findCell si cell.type == barriere ret false
                Coord coord_temp = new Coord();
                //if(){//vérif s'il y a un mur
                    
                //}
            }
            return true;
        }
        return ret;
    }
    
    public boolean isPlayerHere(Cell cell){
        boolean ret=false;
        if(cell.isEmpty()==ret){
            if("Joueur".equals(cell.type)){
               ret=true;
            }
        }
        return ret;
    }
    
    //faire fonction de recherche de cellule en fonction de ooordonnées
    // --> creer une Cell, lire Cell du tableau
    public Cell findCell(Coord coord, Board board){
        Coord coord_temp;
        coord_temp = new Coord(0,0);
        Cell cell = new Cell(coord,null);
        for(int i=0;i<board.plateau.length;i++){
            if(board.plateau[i].coord==coord){
                return cell;
            }
        }
        return cell;
    }
    
    
    /*public void switchPlayer(){ //à voir --> à gérer dans classe GAME
        if(ActualPlayer==Player[0]){
            ActualPlayer=Player[1];
        }else{
            ActualPlayer=Player[0];
        }
    }*/

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
