package evenements.btn.toolbar;

import eltGraphique.eltModelisation.Classe;
import evenements.Btn;
import ihm.FenetreDemo;
import ihm.fenetreInterdiction.FenetreInterdiction;
import ihm.fenetreInterdiction.FenetreInterdictionAjoutElement;
import java.awt.event.MouseEvent;
import util.Position;

/**
* Cette classe permet de gérer un click sur le bouton Classe.
*/
public class BtnClasse extends Btn {
    
    /**
    * Constructeur d'un bouton Classe
    * @param p_string image du bouton
    * @param p_fenetre fenêtre dans laquel se trouve le bouton
    */
    public BtnClasse(String p_string, FenetreDemo p_fenetre){
        super(p_string, p_fenetre);
    }

    /**
    * Cette méthode permet de gérer l'action de clic avec la souris sur un bouton Classe.
    * @param event évènement en cours
    */
    @Override
    public void mouseClicked(MouseEvent event) {
        Classe classe = new Classe(super.fenetre.getPanneauGraph().getGraph(),
            fenetre.getPanneauGraph().getDiagramme(), "Ma classe", new Position(20,20));
        
        if(this.fenetre.getPanneauGraph().getDiagramme().eltAutorise(classe)){
            classe.creer();
        } else {
            FenetreInterdiction fenetreInterdiction = new FenetreInterdictionAjoutElement(this.fenetre);
            fenetreInterdiction.afficherInterdiction();
        }

    }
}
