package evenements.btn;

import eltGraphique.eltModelisation.Classe;
import eltGraphique.eltModelisation.Methode;
import eltGraphique.eltModelisation.Variable;
import eltGraphique.eltModelisation.Visibilite;
import ihm.fenetreClasses.FenetreAjoutMethode;
import java.awt.event.MouseEvent;
import util.Liste;

/**
 * Le bouton permettant de valider l'ajout d'une méthode
 */
public class BtnValiderAjoutMethode extends BoutonFenetres {   
    private Classe classe;
    private final int PACKAGE = 0;
    private final int PROTECTED = 1;
    private final int PUBLIC = 2;
    private final int PRIVATE = 3;
    
    /**
     * Construit le bouton permettant d'ajouter une méthode
     * @param p_fenetre La fenetre principale
     * @param p_classe La classe danslaquelle on veut ajouter la méthode
     */
    public BtnValiderAjoutMethode(FenetreAjoutMethode p_fenetre, Classe p_classe){
        super(p_fenetre, "J'ai fini!");
        this.classe = p_classe;
    }
    
    @Override
    public void mousePressed(MouseEvent me) {
        Visibilite visibilite;
        Liste<Variable> liste = new Liste<Variable>();
        liste.ajouterElement(new Variable(super.getFenetre().getConstantParametre1CheckBox().isSelected(),
                super.getFenetre().getTypeParametre1ChampTexte().getText(), 
                super.getFenetre().getNomParametre1ChampTexte().getText()));
        
        liste.ajouterElement(new Variable(super.getFenetre().getConstantParametre2CheckBox().isSelected(),
                super.getFenetre().getTypeParametre2ChampTexte().getText(), 
                super.getFenetre().getNomParametre2ChampTexte().getText()));        
        
        liste.ajouterElement(new Variable(super.getFenetre().getConstantParametre3CheckBox().isSelected(),
                super.getFenetre().getTypeParametre3ChampTexte().getText(), 
                super.getFenetre().getNomParametre3ChampTexte().getText()));
        
        switch(this.getFenetre().getVisibiliteListe().getSelectedIndex()) {  
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
        
        this.classe.ajouterMethode(new Methode(visibilite,
                super.getFenetre().getTypeRetourChampTexte().getText(),
                super.getFenetre().getNomMethodeChampTexte().getText(), 
                liste, true, true, true));
        
        super.getFenetre().setVisible(false);
        
    }
    
    
}
