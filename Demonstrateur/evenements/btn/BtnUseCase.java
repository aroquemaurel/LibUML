package evenements.btn;

import eltGraphique.CasUtilisation;
import evenements.Btn;
import ihm.FenetreDemo;
import java.awt.event.MouseEvent;

/**
* Cette classe permet de gérer un click sur le bouton de UseCase.
*/
public class BtnUseCase extends Btn {
    
    /**
    * Constructeur d'un bouton de UseCase
    * @param p_string message
    * @param p_fenetre fenêtre dans laquel se trouve le bouton
    */
    public BtnUseCase(String p_string, FenetreDemo p_fenetre){
        super(p_string, p_fenetre);
    }

    /**
    * Cette classe permet de gérer l'action de click avec la souris sur un bouton de UseCase.
    * @param event évènement en cours
    */
    @Override
    public void mouseClicked(MouseEvent event) {
        CasUtilisation useCase = new CasUtilisation(fenetre.getPanneauGraph().getGraph(),
            fenetre.getPanneauGraph().getDiagramme(), "Mon useCase");
        useCase.creer();
    }

}
