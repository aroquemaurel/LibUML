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
    
    private void parametrerPanneau(){
        this.setPreferredSize(new Dimension(this.largeurPanneau,this.longueurPanneau));
    }
    
    public Menu(int p_largeurPanneau, int p_longueurPanneau, FenetreDemo p_fenetre){
        this.largeurPanneau = p_largeurPanneau;
        this.longueurPanneau = p_longueurPanneau;
        this.fenetre = p_fenetre;
        
        parametrerPanneau();
    }
    
    public JPanel getPanneau(){
        return (this);
    }

    abstract public void ajouterObjetsGraphiques();
}
