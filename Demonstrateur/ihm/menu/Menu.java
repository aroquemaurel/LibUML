package ihm.menu;

import ihm.FenetreDemo;
import java.awt.Dimension;
import javax.swing.JPanel;

/**
 * superClasse Menu
 */
public abstract class Menu extends JPanel {
    
    private final Dimension dimension; //Dimensions du panneau
    protected final FenetreDemo fenetre; //Fenêtre dans lequel apparait le menu

    /* Paramètres du Panneau contenant le menu */
    private void parametrerPanneau(){
        this.setPreferredSize(this.dimension);
    }

    /* Construit le menu */
    public Menu(Dimension p_dimension, FenetreDemo p_fenetre){
        this.dimension= p_dimension;
        this.fenetre = p_fenetre;

        this.parametrerPanneau();
    }

    abstract public void ajouterObjetsGraphiques();
    
    public FenetreDemo getFenetre(){
        return (this.fenetre);
    }
}
