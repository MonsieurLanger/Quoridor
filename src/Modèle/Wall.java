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
public class Wall extends AbstractWall{
    
    public Wall(Coord coordwall, Color colorwall) {
        super(coordwall, colorwall);
    }
    public boolean isMoveOk(int xFinal, int yFinal) {
        return !(this.getX()<9 && this.getX()>0 && (this.getY()<9 && this.getY()>0));
    }
}
