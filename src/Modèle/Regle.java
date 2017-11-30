/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modèle;

/**
 *
 * @author Eddine Langer
 */
public class Regle {
    private int numRule;
    private String recap;
    private String describeRule;
    private boolean active;

    public Regle(int numRule, String recap, String describeRule) {
        this.numRule = numRule;
        this.recap = recap;
        this.describeRule = describeRule;
        this.active=false;
    }

    public String getRecap() {
        return recap;
    }

    

    public int getNumRule() {
        return numRule;
    }

   

    public String getDescribeRule() {
        return describeRule;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isActive() {
        return active;
    }


    
}
