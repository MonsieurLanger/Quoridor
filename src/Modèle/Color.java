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
public enum Color {
    BLEU("Bleu", "blue"),
    ROUGE("Rouge", "red"),
    NOIR("Noir", "noir"),
    JAUNE("Jaune", "yellow"),
    VIOLET("Violet", "violet"),
    VERT("Vert", "green"),
    ORANGE("Orange", "orange");

    private String name = "";
    private String imgName = "";
    private boolean taken = false;

    //Constructeur
    Color(String name, String imgName) {
        this.name = name;
        this.imgName = imgName;
    }

    @Override
    public String toString() {
        return name;
    }

    public String getImgName() {
        return this.imgName;
    }

    /*public static void main(String [] args){
        Color color[];
        String tab[]= {"BLEU","ROSE","JAUNE","VERT","ORANGE"};
        for (int i=0; i<5;i++){
            color[i](tab[i]);
            System.out.println("color"+i+"= "+color[i]);
        }
    }
     */
    public boolean getTaken() {
        return taken;
    }

    public void setTaken(boolean taken) {
        this.taken = taken;
    }
}
