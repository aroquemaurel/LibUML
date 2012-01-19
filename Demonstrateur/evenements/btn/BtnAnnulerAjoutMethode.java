package evenements.btn;

import ihm.FenetreAjoutClasse;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

/**
 *
 */
public class BtnAnnulerAjoutMethode extends BoutonFenetres {
    private FenetreAjoutClasse fenetre;
    
    public BtnAnnulerAjoutMethode(FenetreAjoutClasse p_fenetre){
        super(p_fenetre, "Je ne veux plus");
        this.fenetre = p_fenetre;
    }
}
