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
    
    //---> voir plus tard, gestion au niveau d'un tableau de Wall du joueur etc
    public boolean placeWall(Wall wall, Cell cell_finale){ 
        boolean ret=false;
        if ("Barriere".equals(cell_finale.type)){
            if(cell_finale.isEmpty()==true){
                cell_finale.type="Barriere";
                cell_finale.empty=false;
                ret=true;
            }
        }else{
            System.out.println("Pose de barrière impossible.");
            ret=false;
        }
        return ret;
    }
    
    public boolean movePiece(Piece piece,Cell cell_finale, Board board){
        boolean ret=false;
        Coord coord_temp=new Coord(piece.coord.x,piece.coord.y);
        if(piece.isMoveOk(cell_finale.coord,board)==true){
            //maj coordonnées du joueur
            piece.coord=cell_finale.coord;
            //maj attribut de la case d'arrivée
            cell_finale.empty=false;
            cell_finale.type="Joueur";
            //maj attribut de la case de départ
            findCell(coord_temp, board).empty=true;
            findCell(coord_temp, board).type="Vide";
            ret = true;
        }
        return ret;
        
    }
         
    public static boolean isPlayerHere(Cell cell){
        boolean ret=false;
        if(cell.isEmpty()==ret){
            if("Joueur".equals(cell.type)){
               ret=true;
            }
        }
        return ret;
    }
    
    //faire fonction de recherche de cellule en fonction de cooordonnées
    public static Cell findCell(Coord coord, Board board){
        Cell cell = new Cell(coord,null);
        for(int i=0;i<board.plateau.length;i++){
            if((board.plateau[i].coord.x == coord.x) && (board.plateau[i].coord.y == coord.y)){
                return board.plateau[i];
            }
        }
        return cell;
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
    
    public static void main(String[] args){
        int cptr=0;
        Coord coord_test = new Coord(1,1);
        Board board_test = new Board();
        init_Board(board_test);
        for (int i=0;i<board_test.plateau.length;i++){
            //System.out.println(i+". Case:" + board_test.plateau[i]);
            if(isPlayerHere(board_test.plateau[i])==true){
                    cptr++;
                    System.out.println("Coordonnées du joueur "+cptr+" : "+board_test.plateau[i].coord+ "["+i+"]");
            }
        }
       System.out.println("Piece vide? "+isPieceHere(board_test.plateau[152]));
        System.out.println("findCell: "+findCell(coord_test,board_test));
    }
    
    
}
