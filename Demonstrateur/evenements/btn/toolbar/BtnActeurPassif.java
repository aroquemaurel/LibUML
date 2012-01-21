package evenements.btn.toolbar;

import eltGraphique.eltModelisation.ActeurPassif;
import evenements.Btn;
import ihm.FenetreDemo;
import ihm.fenetreInterdiction.FenetreInterdiction;
import ihm.fenetreInterdiction.FenetreInterdictionAjoutElement;
import java.awt.event.MouseEvent;
import util.Position;

/**
* Cette classe permet de gérer un click sur le bouton Acteur actif
*/
public class BtnActeurPassif extends Btn {
    
    /**
    * Constructeur d'un bouton acteur Passif
    * @param p_string image du bouton
    * @param p_fenetre fenêtre dans laquel se trouve le bouton
    */
    public BtnActeurPassif(String p_string, FenetreDemo p_fenetre){
        super(p_string, p_fenetre);
    }
    
    /**
    * Cette méthode permet de gérer l'action de clic avec la souris sur un bouton Acteur Passif.
    * @param event évènement en cours
    */
    @Override
    public void mouseClicked(MouseEvent event) {
        ActeurPassif acteur = new ActeurPassif(super.fenetre.getPanneauGraph().getGraph(),
            fenetre.getPanneauGraph().getDiagramme(), "Mon acteur Passif", new Position(20,20));
        
        if(this.fenetre.getPanneauGraph().getDiagramme().eltAutorise(acteur)){
            acteur.creer();
            acteur.afficherLigneDeVie(false);
        } else {
            FenetreInterdiction fenetreInterdiction = new FenetreInterdictionAjoutElement(this.fenetre);
            fenetreInterdiction.afficherInterdiction();
        }
    }
}
