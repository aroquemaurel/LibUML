/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ihm.Menu;

import java.awt.Dimension;
import javax.swing.JPanel;

/**
 *
 * @author satenske
 */
public abstract class Menu extends JPanel {
    private int largeurPanneau;
    private int longueurPanneau;
    
    public Menu(int p_largeurPanneau, int p_longueurPanneau){
        this.largeurPanneau = p_largeurPanneau;
        this.longueurPanneau = p_longueurPanneau;
        
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
