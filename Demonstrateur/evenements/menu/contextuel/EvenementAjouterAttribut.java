package evenements.menu.contextuel;

import eltGraphique.eltModelisation.Classe;
import ihm.FenetreAjoutAttribut;
import ihm.FenetreDemo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 */
public class EvenementAjouterAttribut implements ActionListener {
    private FenetreDemo fenetre;
    private Classe classe;
    
    public EvenementAjouterAttribut(FenetreDemo p_fenetre, Classe p_classe) {
        this.fenetre = p_fenetre;
        this.classe = p_classe;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        FenetreAjoutAttribut fenetreAttribut = new FenetreAjoutAttribut(
                this.fenetre, "Ajout d'un attribut", this.classe);
        fenetreAttribut.afficherFenetre();
    }
    
    
    
}
