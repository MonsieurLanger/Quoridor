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
public enum Color {
    BLEU ("Bleu"),
    ROUGE ("Rouge"),
    ROSE ("Rose"),
    JAUNE ("Jaune"),
    VIOLET ("Violet"),
    VERT ("Vert"),
    ORANGE ("Orange");
    
    private String name = "";
    
    //Constructeur
    Color(String name){
        this.name=name;
    }
    
    public String toString(){
        return name;
    }
}
