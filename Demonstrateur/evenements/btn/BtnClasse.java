package evenements.btn;

import eltGraphique.classe.Attribut;
import eltGraphique.classe.Classe;
import eltGraphique.classe.Methode;
import eltGraphique.classe.Visibilite;
import evenements.Btn;
import ihm.FenetreDemo;
import java.awt.event.MouseEvent;

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
    * Cette méthode permet de gérer l'action de clique avec la souris sur un bouton Classe.
    * @param event évènement en cours
    */
    @Override
    public void mouseClicked(MouseEvent event) {
        Classe classe = new Classe(super.fenetre.getPanneauGraph().getGraph(),
            fenetre.getPanneauGraph().getDiagramme(), "Ma classe");

        /* On ajoute des méthodes et des attributs dans la classe
         * Le démonstrateur ne gère pas directement l'ajout d'attributs et/ou de méthodes
         */
        classe.ajouterMethode(new Methode(Visibilite.PROTECTED, "void", "maMethode1", null, false, false, false));
        classe.ajouterMethode(new Methode(Visibilite.PRIVATE, "void", "maMethode2", null, false, false, false));
        classe.ajouterMethode(new Methode(Visibilite.PUBLIC, "void", "maMethode3", null, false, false, false));

        classe.ajouterAttribut(new Attribut(Visibilite.PROTECTED, false, false, "int", "monAttribut1"));
        classe.ajouterAttribut(new Attribut(Visibilite.PRIVATE, false, false, "long", "monAttribut2"));
        classe.ajouterAttribut(new Attribut(Visibilite.PRIVATE, false, false,"Classe", "monAttribut3"));
        
        classe.creer();

    }
}
