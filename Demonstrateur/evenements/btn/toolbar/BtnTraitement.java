package evenements.btn.toolbar;

import eltGraphique.eltModelisation.Traitement;
import evenements.Btn;
import ihm.FenetreDemo;
import ihm.fenetreInterdiction.FenetreInterdiction;
import ihm.fenetreInterdiction.FenetreInterdictionAjoutElement;
import java.awt.event.MouseEvent;
import util.Position;


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
                "Mon traitement",  null, new Position(20,20), true);
        if(this.fenetre.getPanneauGraph().getDiagramme().eltAutorise(traitement)){
            traitement.creer();
        } else {
            FenetreInterdiction fenetreInterdiction = new FenetreInterdictionAjoutElement(this.fenetre);
            fenetreInterdiction.afficherInterdiction();
        }    }

}
