package evenements.btn;

import eltGraphique.classe.Classe;
import evenements.Btn;
import ihm.FenetreDemo;
import java.awt.event.MouseEvent;

/**
* Cette classe permet de gérer un click sur le bouton Classe.
*/
public class BtnClasse extends Btn {
    
    /**
    * Constructeur d'un bouton Classe
    * @param p_string message
    * @param p_fenetre fenêtre dans laquel se trouve le bouton
    */
    public BtnClasse(String p_string, FenetreDemo p_fenetre){
        super(p_string, p_fenetre);
    }

    /**
    * Cette classe permet de gérer l'action de click avec la souris sur un bouton Classe.
    * @param event évènement en cours
    */
    @Override
    public void mouseClicked(MouseEvent event) {
    Classe acteur = new Classe(super.fenetre.getPanneauGraph().getGraph(),
        fenetre.getPanneauGraph().getDiagramme(), "Ma classe");
    acteur.creer();
    }
}
