package evenements.btn.toolbar;

import eltGraphique.ligne.TypeLien;
import evenements.Btn;
import evenements.EvenementsLienElementGraphique;
import ihm.FenetreDemo;
import java.awt.event.MouseEvent;

/**
* Cette classe permet de gérer un click sur le bouton de Generalisation.
*/
public class BtnSpecialisation extends Btn {
    
    /**
    * Constructeur d'un bouton de generalisation
    * @param p_string image du bouton
    * @param p_fenetre fenêtre dans laquel se trouve le bouton
    */
    public BtnSpecialisation(String p_string, FenetreDemo p_fenetre){
        super(p_string, p_fenetre);
    }
	
    /**
    * Cette méthode permet de gérer l'action de clic avec la souris sur un bouton de Generalisation.
    * @param event évènement en cours
    */
    @Override
    public void mouseClicked(MouseEvent event) {
            EvenementsLienElementGraphique evenement =
                    new EvenementsLienElementGraphique(this.fenetre,
                                    this.fenetre.getPanneauGraph().getDiagramme(), TypeLien.SPECIALISATION);
            this.fenetre.getPanneauGraph().getGraphControl().addMouseListener(evenement);
    }
}
