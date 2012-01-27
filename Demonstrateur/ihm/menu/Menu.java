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

    /**
     * Paramètres du Panneau contenant le menu 
     */
    private void parametrerPanneau(){
        this.setPreferredSize(this.dimension);
    }

    /**
     * Construit le menu 
     */
    public Menu(Dimension p_dimension, FenetreDemo p_fenetre){
        this.dimension= p_dimension;
        this.fenetre = p_fenetre;

        this.parametrerPanneau();
    }
    
    /**
     * Retourne la fenêtre
     * @return La fenêtre dans laquelle est le menu
     */
    protected FenetreDemo getFenetre(){
        return (this.fenetre);
    }
    
    /**
     * Méthode redéfinis dans les classes filles permettant d'ajouter les objets graphiques
     */
    abstract public void ajouterObjetsGraphiques();
}
