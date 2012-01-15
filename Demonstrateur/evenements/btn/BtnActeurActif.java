package evenements.btn;

import eltGraphique.Acteur;
import eltGraphique.ActeurActif;
import evenements.Btn;
import ihm.FenetreDemo;
import java.awt.event.MouseEvent;

/**
* Cette classe permet de gérer un click sur le bouton Acteur actif
*/
public class BtnActeurActif extends Btn {
    
    /**
    * Constructeur d'un bouton acteur Actif
    * @param p_string message
    * @param p_fenetre fenêtre dans laquel se trouve le bouton
    */
    public BtnActeurActif(String p_string, FenetreDemo p_fenetre){
        super(p_string, p_fenetre);
    }

    /**
    * Cette classe permet de gérer l'action de click avec la souris sur un bouton Acteur Actif.
    * @param event évènement en cours
    */
    @Override
    public void mouseClicked(MouseEvent event) {
        Acteur acteur = new ActeurActif(super.fenetre.getPanneauGraph().getGraph(),
            this.fenetre.getPanneauGraph().getDiagramme(),
            "Mon acteur Actif");
        acteur.creer();
		acteur.afficherLigneDeVie(false);
    }
}
