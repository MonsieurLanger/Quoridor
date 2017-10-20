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

    public static boolean coord_valides(int x, int y){
            return ( (x<=7) && (x>=0) && (y<=7) && (y>=0));
    }
    
    @Override
    public String toString() {
            return "[x=" + x + ", y=" + y + "]";
    }
}
