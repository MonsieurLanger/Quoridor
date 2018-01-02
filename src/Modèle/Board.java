/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modèle;

import java.util.Arrays;

/**
 *
 * @author nrmv4488
 */
public class Board {
    //Player ActualPlayer; pour implémentation de Game.java
    private Cell plateau[];

    public Cell[] getPlateau() {
        return plateau;
    }

    public void setPlateau(Cell[] plateau) {
        this.plateau = plateau;
    }
    
   public Board(){
       this.plateau = new Cell[289];
    }
    
   public void init_Board(){
       int k=0;
        for(int i=0;i<17;i++){
           for(int j=0;j<17;j++){
               Coord coord = new Coord(i,j);
               if(coord.x%2!=0 && coord.y%2!=0){
                   Cell cell = new Cell(coord,"Inutilisable");
                   this.plateau[k]=cell;
                   cell.indice=k;
                   k++;
               }if((coord.x%2!=0 && coord.y%2==0)||(coord.x%2==0 && coord.y%2!=0)){
                   Cell cell = new Cell(coord,"Barriere");
                   this.plateau[k]=cell;
                   cell.indice=k;
                   k++;
               }if(coord.x%2==0 && coord.y%2==0){
                   if((coord.x==8 && coord.y==0)||(coord.x==8 && coord.y==16)){
                     Cell cell = new Cell(coord,"Joueur");
                     cell.empty=false;
                     this.plateau[k]=cell;
                     cell.indice=k;
                     k++;
                   }else{
                        Cell cell = new Cell(coord,"Vide");
                        this.plateau[k]=cell;
                        cell.indice=k;
                        k++;
                   }
               }               
           }
        }
    }
    
    public  boolean isPieceHere(Cell cell){
        boolean ret=false;
        if(cell.isEmpty()==true){
            ret=true;
        }
        return ret;
    }
    
    //---> voir plus tard, gestion au niveau d'un tableau de Wall du joueur etc
    //ajout modif dans le board?
    public  boolean placeWall(Wall wall, Cell cell_finale){ 
        boolean ret=false;
        Coord coord_finales = new Coord(cell_finale.coord.x,cell_finale.coord.y);
        if (Wall.isMoveOk(coord_finales,this)){
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
    
    public  boolean movePiece(Piece piece,Cell cell_finale){
        boolean ret=false;
        Coord coord_temp=new Coord(piece.coord.x,piece.coord.y);
        if(piece.isMoveOk(cell_finale.coord,this)==true){
            //maj coordonnées du joueur
            piece.coord=cell_finale.coord;
            //maj attribut de la case d'arrivée
            cell_finale.empty=false;
            cell_finale.type="Joueur";
            //maj attribut de la case de départ
            findCell(coord_temp, this).empty=true;
            findCell(coord_temp, this).type="Vide";
            ret = true;
        }
        return ret;
        
    }
         
    public  boolean isPlayerHere(Cell cell){
        boolean ret=false;
        if(cell.isEmpty()==ret){
            if("Joueur".equals(cell.type)){
               ret=true;
            }
        }
        return ret;
    }


     //Fonction qui retour tableau de joueur (afin de récup leur coord etc..
    public  Coord[] coord_Player(){
        int cptr=0;
        Coord[] coord= new Coord[2];
        Coord coord_j2= new Coord();
        for (int i=0;i<this.plateau.length;i++){
            if(isPlayerHere(this.plateau[i])==true){
                    coord[cptr]=this.plateau[i].coord;
                    cptr++;
                    System.out.println("Coordonnées du joueur "+cptr+" : "+this.plateau[i].coord+ "["+i+"]");
            }
        }
        return coord;
    }
    
        public  boolean isWallHere(Cell cell){
        boolean ret=false;
        if(cell.isEmpty()==ret){
            if("Barriere".equals(cell.type)){
               ret=true;
            }
        }
        return ret;
    }

             //Fonction qui retour tableau de murs (afin de récup leur coord etc..
    public  Coord[] coord_Wall(){
        int cptr=0;
        Coord[] coord= new Coord[2];
        Coord coord_j2= new Coord();
        for (int i=0;i<this.plateau.length;i++){
            if(isWallHere(this.plateau[i])==true){
                    coord[cptr]=this.plateau[i].coord;
                    cptr++;
            }
        }
        return coord;
    }
    
    //Fonction de recherche de cellule en fonction de cooordonnées
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
    
    public void affiche(){
        int cptr=0;
        Coord coord_test = new Coord(8,0);
        Coord coord_finales_test = new Coord(8,2);
        Coord coord_wall= new Coord(0,1);
        Coord coord_wall_finales= new Coord();

        this.init_Board();
        Piece piece_test = new Piece(Color.BLEU, coord_test);
        /*for (int i=0;i<board_test.plateau.length;i++){
            System.out.println(i+". Case:" + board_test.plateau[i]);
            if(isPlayerHere(board_test.plateau[i])==true){
                    cptr++;
                    System.out.println("Coordonnées du joueur "+cptr+" : "+board_test.plateau[i].coord+ "["+i+"]");
            }
        }*/
        System.out.println("Test");
       System.out.println("Piece vide? "+isPieceHere(this.plateau[152]));
       System.out.println("findCell: "+findCell(coord_test,this));
       System.out.println(movePiece(piece_test,findCell(coord_finales_test,this)));
       System.out.println("Nouvelles coordonnées de la pièce: "+piece_test.coord+".");
       System.out.println("Coordonnées des joueurs avec coord_Player : "+Arrays.toString(coord_Player()));
       Wall wall_test = new Wall();
        System.out.println(this.plateau[1].isEmpty());
        System.out.println("test place_wall : "+placeWall(wall_test,this.plateau[1]));
        System.out.println(this.plateau[1].isEmpty());
    }
}



//--> tester la création de Wall et pose de Wall 
