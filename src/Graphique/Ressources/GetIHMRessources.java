package Graphique.Ressources;

import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;

/**
 * Outil de chargement d'images sous la forme d'ImageIcon
 * @author MOREL Charles <charles.morel@cpe.fr>
 */
public abstract class GetIHMRessources {

    
    private GetIHMRessources() {

    }

    public static ImageIcon getIconFromRessources(String ressourceName) {
        // Récupération de l'image en fonction de son nom
        File g = new File("");
        String imgPath = g.getAbsolutePath() + "/src/Graphique/Ressources/" + ressourceName;
        return new ImageIcon(imgPath); 
    }
    public static ImageIcon getScaledIconFromRessources(String ressourceName, int width, int height) {
        // Récupération d'une image à la taille donnée
        // On s'assue que la taille est sup. à zéro
        if(width <= 0)
        {
            width = 1;
        }
        if(height <= 0)
        {
            height = 1;
        }
        // On charge l'imageIcon
        ImageIcon imageIcon = GetIHMRessources.getIconFromRessources(ressourceName);
        // On la transforme en Image
        Image image = imageIcon.getImage();
        // On la resize
        Image newimg = image.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH); 
        // On renvoie l'imageIcon
        return new ImageIcon(newimg);  // transform it back
    }
}
