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
    int size;

    public CaseContentIHM(String image) {
        this.image = image;
        this.size = 0;
    }
    
    private void loadScaledImage()
    {
        this.size = this.getParent().getParent().getSize().height / 20;
        this.setIcon(GetIHMRessources.getScaledIconFromRessources(this.image,this.size, this.size));
    }
    
    @Override
    public Dimension getPreferredSize() {
        this.loadScaledImage();
        return new Dimension(this.size,this.size);
    }

    @Override
    public Dimension getMaximumSize() {
        return this.getPreferredSize();
    }

    @Override
    public Dimension getMinimumSize() {
        return this.getPreferredSize();
    }    
}
