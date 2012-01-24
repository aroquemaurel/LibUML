package evenements.menu.contextuel;

import eltGraphique.eltModelisation.Classe;
import ihm.FenetreDemo;
import ihm.fenetreClasses.FenetreAjoutAttribut;
import ihm.fenetreClasses.FenetreDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Evenement lorsque l'on veut ajouter un attribut
 */
public class EvenementAjouterAttribut implements ActionListener {
    private FenetreDemo fenetre;
    private Classe classe;
    
    /**
     * Construit l'événement
     * @param p_fenetre La fenetre principale
     * @param p_classe  La classe à laquelle on ajoute l'élément
     */
    public EvenementAjouterAttribut(FenetreDemo p_fenetre, Classe p_classe) {
        this.fenetre = p_fenetre;
        this.classe = p_classe;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        FenetreDialog fenetreAttribut = new FenetreAjoutAttribut(
                this.fenetre, "Ajout d'un attribut", this.classe);
        fenetreAttribut.afficherFenetre();
    }
    
    
    
}
