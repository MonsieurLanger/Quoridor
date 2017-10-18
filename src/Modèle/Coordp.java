/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modèle;

/**
 *
 * @author hariri
 */
public class Coordp {
    public int x;
    public int y;
    
    //Constructeur
    public Coordp(int x,int y){
            this.x=x;
            this.y=y;
    }

    public static boolean coord_valides(int x, int y){
            return ( (x<=7) && (x>=0) && (y<=7) && (y>=0));
    }
    
    
}
