package evenements.menu.contextuel;

import eltGraphique.eltModelisation.Classe;
import ihm.FenetreAjoutMethode;
import ihm.FenetreDemo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 */
public class EvenementAjouterMethode implements ActionListener {
    private FenetreDemo fenetre;
    private Classe classe;
    
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
