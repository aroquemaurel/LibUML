package  evenements.btn;

import eltModelisation.CasUtilisation;
import evenements.Btn;
import ihm.FenetreDemo;
import ihm.FenetreInterdiction;
import ihm.FenetreInterdictionAjoutElement;
import java.awt.event.MouseEvent;

/**
* Cette classe permet de gérer un clic sur le bouton de UseCase.
*/
public class BtnUseCase extends Btn {
    
    /**
    * Constructeur d'un bouton de UseCase
    * @param p_string lien de l'image du bouton
    * @param p_fenetre fenêtre dans laquel se trouve le bouton
    */
    public BtnUseCase(String p_string, FenetreDemo p_fenetre){
        super(p_string, p_fenetre);
    }

    /**
    * Cette méthode permet de gérer l'action de clic avec la souris sur un bouton de UseCase.
    * @param event évènement en cours
    */
    @Override
    public void mouseClicked(MouseEvent event) {
        CasUtilisation useCase = new CasUtilisation(fenetre.getPanneauGraph().getGraph(),
            fenetre.getPanneauGraph().getDiagramme(), "Mon useCase");
        if(this.fenetre.getPanneauGraph().getDiagramme().eltAutorise(useCase)){
            useCase.creer();
        } else {
            FenetreInterdiction fenetreInterdiction = new FenetreInterdictionAjoutElement(this.fenetre);
            fenetreInterdiction.afficherInterdiction();
        }    
    }    

}
