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
    
    @Override
    public String toString(){
        return name;
    }
    
   /*public static void main(String [] args){
        Color color[];
        String tab[]= {"BLEU","ROSE","JAUNE","VERT","ORANGE"};
        for (int i=0; i<5;i++){
            color[i](tab[i]);
            System.out.println("color"+i+"= "+color[i]);
        }
    }
*/}
