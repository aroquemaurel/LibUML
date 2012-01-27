package ihm.fenetreInterdiction;

import ihm.FenetreDemo;

/**
 * Fenetre interdisant l'ajout d'un élément
 */
public class FenetreInterdictionAjoutElement extends FenetreInterdiction {
    
    /**
     * Construit une fenetre d'interdiction d'ajout d'élément
     * @param p_fenetre La fenetre dans laquelle s'affiche l'interdiction
     */
    public FenetreInterdictionAjoutElement(FenetreDemo p_fenetre){
        super(p_fenetre, "Ajout de cet élément interdit");
    }
    
}
