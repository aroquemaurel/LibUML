package evenements.menu.contextuel;

import eltGraphique.eltModelisation.Classe;
import ihm.fenetreClasses.FenetreAjoutMethode;
import ihm.FenetreDemo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Evenement lorsque l'on ajoute une méthode
 */
public class EvenementAjouterMethode implements ActionListener {
    private FenetreDemo fenetre;
    private Classe classe;
    
    /** 
     * Construit l'événement d'ajout d'une méthode
     * @param p_fenetre La fenetre principale
     * @param p_classe La classe dans laquelle on veut ajouter une méthode
     */
    public EvenementAjouterMethode(FenetreDemo p_fenetre, Classe p_classe) {
        this.fenetre = p_fenetre;
        this.classe = p_classe;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        FenetreAjoutMethode fenetreAjoutMethode = new FenetreAjoutMethode(this.fenetre, 
                "Ajouter une méthode", this.classe);
        fenetreAjoutMethode.afficherFenetre();

    }
    
}
