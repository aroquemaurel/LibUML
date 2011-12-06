/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ihm.Menu;

import ihm.FenetreDemo;
import java.awt.Dimension;
import javax.swing.JPanel;

/**
 *
 * @author satenske
 */
public abstract class Menu extends JPanel {
    private final int largeurPanneau;
    private final int longueurPanneau;
    protected final FenetreDemo fenetre;
    
    public Menu(int p_largeurPanneau, int p_longueurPanneau, FenetreDemo p_fenetre){
        this.largeurPanneau = p_largeurPanneau;
        this.longueurPanneau = p_longueurPanneau;
        this.fenetre = p_fenetre;
        
        parametrerPanneau();
    }
    
    public JPanel getPanneau(){
        return (this);
    }
    
    private void parametrerPanneau(){
        this.setPreferredSize(new Dimension(this.largeurPanneau,this.longueurPanneau));
    }
    abstract public void ajouterObjetsGraphiques();
}
