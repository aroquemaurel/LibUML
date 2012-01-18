package evenements.btn;

import eltModelisation.Traitement;
import evenements.Btn;
import ihm.FenetreDemo;
import java.awt.event.MouseEvent;


/**
* Cette classe permet de gérer un click sur le bouton de Traitement.
*/
public class BtnTraitement extends Btn {

    /**
    * Constructeur d'un bouton de Traitement
    * @param p_string message
    * @param p_fenetre fenêtre dans laquel se trouve le bouton
    */
    public BtnTraitement (String p_string, FenetreDemo p_fenetre){
        super(p_string, p_fenetre);
    }

    /**
    * Cette méthode permet de gérer l'action de clic avec la souris sur un bouton de Traitement.
    * @param event évènement en cours
    */
    @Override
    public void mouseClicked(MouseEvent event) {
        Traitement traitement = new Traitement (super.fenetre.getPanneauGraph().getGraph(),
            fenetre.getPanneauGraph().getDiagramme(),
                "Mon traitement", null, true);
        traitement.creer();
    }

}
