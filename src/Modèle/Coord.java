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
    private int x;
    private int y;
    
    //Constructeur
    public Coord(int x,int y){
            this.x=x;
            this.y=y;
    }

    public static boolean coord_valides(int x, int y){
            return ( (x<=7) && (x>=0) && (y<=7) && (y>=0));
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    
    
    
}