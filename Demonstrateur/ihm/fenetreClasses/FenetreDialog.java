package ihm.fenetreClasses;

import ihm.FenetreDemo;
import javax.swing.JDialog;

/**
 * Superclasse permettant d'afficher une fenetre d'ajout d'attribut ou de méthodes
 */
abstract public class FenetreDialog extends JDialog {
    
    /** 
     * Construit la JDialog 
     * @param p_fenetre La fenetre principale
     * @param p_titre Le titre de la fenetre à créer
     */
    public FenetreDialog(FenetreDemo p_fenetre, String p_titre) {
        super(p_fenetre, p_titre);
    }
    
    /**
     * Affiche la fenetre 
     */
    public void afficherFenetre(){
        this.setVisible(true);
    }
    /**
     * Paramètre la fenetre
     */
    abstract protected void parametrerBoiteDialogue();
    
    /**
     * Ajout les éléments dans la fenetre
     */
    abstract protected void ajouterElements() ;  
}
