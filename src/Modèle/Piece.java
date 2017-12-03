/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modèle;

/**
 *
 * @author NRMV4488
 */
public class Piece extends AbstractPiece{
    
    public Piece(Color color, Coord coord){
        super(color, coord);
    }

    @Override
    public boolean isMoveOk(Coord coord_finales) {
        boolean ret=false;
        //vérif coord sur le plateau
        if(Coord.coord_valides(coord_finales)){
        //vérif coord déplacement +2 et non diagonal (car +1 == case barriere   
            int xFinal= coord_finales.x;
            int yFinal= coord_finales.y;
            if(Math.abs(xFinal - this.coord.x)== 0 && Math.abs(yFinal - this.coord.y)== 2
            || Math.abs(xFinal - this.coord.x)== 2 && Math.abs(yFinal - this.coord.y)== 0){
                //vérif non impaire/impaire 
                if(!(xFinal%2!=0 && yFinal%2!=0)){
                    ret = true;
                }
                else{
                    System.out.println("Mouvement impossible");
                }
            }
         }
        //vérif s'il y a un joueur
        //vérif s'il y a un mur
        return ret;
    }
    
    @Override
        public String toString() {
            return "[Cordonnées =" + this.coord+ "] Couleur= "+ this.color;
    }
        
    public static void main(String[] args){
        int x= 0;
        int y= 0;
        Coord coord[];
        coord = new Coord[5];
        for(int i=0; i<5; i++){
            coord[i]=new Coord(x,y);
            x++;
            y++;
        }
        Coord test_coord = new Coord(0,1);
               
        Cell tab[];
        tab = new Cell[5];
        for(int j=0; j<5; j++){
            //a revoir  tab[j] = new Cell(coord[j]);
            System.out.printf("tab[j]= "+tab[j].coord+"\n");
        }
      
        //Cell test = new Cell(test_coord);
        
        Piece piece[];
        piece = new Piece[2];
        piece[0] = new Piece(Color.ROSE, coord[0]);
        System.out.println("piece[k]= "+ piece[0]);
        //piece[1] = new Piece(Color.BLEU, coord[1]);
        //System.out.println("piece[k]= "+ piece[1]);
        
        piece[0].Move(test_coord);
        System.out.println("piece[k]= "+ piece[0]);
        piece[0].Move(coord[1]);
        System.out.println("piece[k]= "+ piece[0]);
    }
}

