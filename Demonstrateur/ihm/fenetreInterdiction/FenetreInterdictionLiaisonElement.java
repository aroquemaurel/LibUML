package ihm.fenetreInterdiction;

import ihm.FenetreDemo;

/**
 * Fenetre interdisant les liaison entre des éléments
 */
public class FenetreInterdictionLiaisonElement extends FenetreInterdiction {
    /**
     * Construit une fenetre d'interdiction de liaison d'éléments
     * @param p_fenetre La fenetre dans laquelle s'affiche l'interdiction
     */
    public FenetreInterdictionLiaisonElement(FenetreDemo p_fenetre){
        super(p_fenetre, "Liaison de ces deux éléments interdite");
    }
    
}
