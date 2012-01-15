package evenements.btn;

import eltGraphique.ligne.TypeLien;
import evenements.Btn;
import evenements.EvenementsLienElementGraphique;
import ihm.FenetreDemo;
import java.awt.event.MouseEvent;

/**
* Cette classe permet de gérer un click sur le bouton Association
*/
public class BtnAssociation extends Btn {
    
    /**
    * Constructeur d'un bouton acteur Association
    * @param p_string message
    * @param p_fenetre fenêtre dans laquel se trouve le bouton
    */
    public BtnAssociation(String p_string, FenetreDemo p_fenetre){
        super(p_string, p_fenetre);
    }

    /**
    * Cette classe permet de gérer l'action de click avec la souris sur un bouton Association.
    * @param event évènement en cours
    */
    @Override
    public void mouseClicked(MouseEvent event) {
            EvenementsLienElementGraphique evenement =
                    new EvenementsLienElementGraphique(this.fenetre.getPanneauGraph(),
                                    this.fenetre.getPanneauGraph().getDiagramme(), TypeLien.ASSOCIATION);
            this.fenetre.getPanneauGraph().getGraphControl().addMouseListener(evenement);
    }
}
