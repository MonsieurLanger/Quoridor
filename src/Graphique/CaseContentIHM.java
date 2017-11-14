package Graphique;

import Graphique.Ressources.GetIHMRessources;
import java.awt.Dimension;
import javax.swing.JLabel;

/**
 *
 * @author MOREL Charles <charles.morel@cpe.fr>
 */
public class CaseContentIHM extends JLabel
{
    String image;

    public CaseContentIHM(String image) {
        this.image = image;
    }
    
    private void loadScaledImage()
    {
        this.setIcon(GetIHMRessources.getScaledIconFromRessources(this.image,this.getParent().getSize().width, this.getParent().getSize().height));
    }
    
    @Override
    public Dimension getPreferredSize() {
        this.loadScaledImage();
        return new Dimension(this.getParent().getSize().width, this.getParent().getSize().height);
    }

    @Override
    public Dimension getMaximumSize() {
        this.loadScaledImage();
        return new Dimension(this.getParent().getSize().width, this.getParent().getSize().height);
    }

    @Override
    public Dimension getMinimumSize() {
        this.loadScaledImage();
        return new Dimension(this.getParent().getSize().width, this.getParent().getSize().height);
    }    
}
