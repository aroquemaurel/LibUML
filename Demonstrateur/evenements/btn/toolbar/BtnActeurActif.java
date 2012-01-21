package evenements.btn.toolbar;

import eltGraphique.eltModelisation.Acteur;
import eltGraphique.eltModelisation.ActeurActif;
import evenements.Btn;
import ihm.FenetreDemo;
import ihm.fenetreInterdiction.FenetreInterdiction;
import ihm.fenetreInterdiction.FenetreInterdictionAjoutElement;
import java.awt.event.MouseEvent;
import util.Position;

/**
* Cette classe permet de gérer un clic sur le bouton Acteur actif
*/
public class BtnActeurActif extends Btn {
    
    /**
    * Constructeur d'un bouton acteur Actif
    * @param p_string image du bouton
    * @param p_fenetre fenêtre dans laquel se trouve le bouton
    */
    public BtnActeurActif(String p_string, FenetreDemo p_fenetre){
        super(p_string, p_fenetre);
    }

    /**
    * Cette méthode permet de gérer l'action de clic avec la souris sur un bouton Acteur Actif.
    * @param event évènement en cours
    */
    @Override
    public void mouseClicked(MouseEvent event) {

        Acteur acteur = new ActeurActif(super.fenetre.getPanneauGraph().getGraph(),
            this.fenetre.getPanneauGraph().getDiagramme(),
            "Mon acteur Actif", new Position(20,20));
        
        if(this.fenetre.getPanneauGraph().getDiagramme().eltAutorise(acteur)){
            acteur.creer();
            acteur.afficherLigneDeVie(false);
        } else {
            FenetreInterdiction fenetreInterdiction = new FenetreInterdictionAjoutElement(this.fenetre);
            fenetreInterdiction.afficherInterdiction();
        }
        
        
    }
}
