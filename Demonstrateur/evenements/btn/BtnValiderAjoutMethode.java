package evenements.btn;

import eltModelisation.Classe;
import eltModelisation.Methode;
import eltModelisation.Variable;
import eltModelisation.Visibilite;
import ihm.FenetreAjoutMethode;
import java.awt.event.MouseEvent;
import javax.swing.JDialog;
import util.Liste;

/**
 *
 */
public class BtnValiderAjoutMethode extends BoutonFenetres {   
    private Classe classe;
    private final int PACKAGE = 0;
    private final int PROTECTED = 1;
    private final int PUBLIC = 2;
    private final int PRIVATE = 3;
    
    public BtnValiderAjoutMethode(FenetreAjoutMethode p_fenetre, Classe p_classe){
        super(p_fenetre, "J'ai fini!");
        this.classe = p_classe;
    }
    
    @Override
    public void mousePressed(MouseEvent me) {
        Visibilite visibilite;
        Liste<Variable> liste = new Liste<Variable>();
        liste.ajouterElement(new Variable(true, "test", "truc"));
        switch(this.getFenetre().getVisibiliteListe().getSelectedIndex()){
             case PROTECTED:
                 visibilite = Visibilite.PROTECTED;
                break;
            case PUBLIC:
                visibilite = Visibilite.PUBLIC;
                break;
            case PRIVATE:
                visibilite = Visibilite.PRIVATE;
                break;
            default : //PACKAGE
                visibilite = Visibilite.PACKAGE;
        }
        System.out.print(this.classe);
        
        this.classe.ajouterMethode(new Methode(visibilite,
                super.getFenetre().getTypeRetourChampTexte().getText(),
                super.getFenetre().getNomMethodeChampTexte().getText(), 
                null, true, true, true));
        System.out.print(super.getFenetre().getTypeRetourChampTexte().getText());
        
        super.getFenetre().setVisible(false);
        
    }
    
    
}
