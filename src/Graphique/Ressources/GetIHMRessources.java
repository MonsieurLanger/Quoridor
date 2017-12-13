package Graphique.Ressources;

import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;

/**
 *
 * @author MOREL Charles <charles.morel@cpe.fr>
 */
public abstract class GetIHMRessources {

    private GetIHMRessources() {

    }

    public static ImageIcon getIconFromRessources(String ressourceName) {
        File g = new File("");
        String imgPath = g.getAbsolutePath() + "/src/Graphique/Ressources/" + ressourceName;
        return new ImageIcon(imgPath); 
    }
    public static ImageIcon getScaledIconFromRessources(String ressourceName, int width, int height) {
        if(width == 0)
        {
            width = 1;
        }
        if(height == 0)
        {
            height = 1;
        }
        ImageIcon imageIcon = GetIHMRessources.getIconFromRessources(ressourceName); // load the image to a imageIcon
        Image image = imageIcon.getImage(); // transform it 
        Image newimg = image.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        return new ImageIcon(newimg);  // transform it back
    }
}
