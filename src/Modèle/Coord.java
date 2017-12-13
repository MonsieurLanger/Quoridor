/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modèle;

// test commit ayoub
/**
 *
 * @author NRMV4488
 */
public class Coord {
    public int x;
    public int y;
    
    //Constructeur par défaut
    public Coord(){
        this.x=0;
        this.y=0;
    }
    
    //Constructeur
    public Coord(int x,int y){
            this.x=x;
            this.y=y;
    }

    public static boolean coord_valides(Coord coord){
            return ( ((coord.x)<=16) && ((coord.x)>=0) && ((coord.y)<=16) && ((coord.y)>=0));
    }
    
    @Override
    public String toString() {
            return "[x=" + x + ", y=" + y + "]";
    }
    
    /*public static void main (String[] args){
        int x= 4;
        int y= 4;
        Coord coord[];
        coord = new Coord[5];
        for(int i=0; i<5; i++){
            if (coord_valides(x,y)){
            coord[i]=new Coord(x,y);
            x++;
            y++;
            System.out.println("print + "+i+" "+coord[i]);
            }
            else{
                System.out.println("Erreur de coordonnées.");
            }
        }
    }*/
}
