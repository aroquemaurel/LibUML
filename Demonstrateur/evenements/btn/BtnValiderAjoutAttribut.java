package evenements.btn;

import eltGraphique.eltModelisation.Attribut;
import eltGraphique.eltModelisation.Classe;
import eltGraphique.eltModelisation.Variable;
import eltGraphique.eltModelisation.Visibilite;
import ihm.fenetreClasses.FenetreAjoutAttribut;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import util.Liste;

/**
 * Le bouton permettant de valider l'ajout d'une méthode
 */
public class BtnValiderAjoutAttribut extends JButton implements MouseListener {
    private Classe classe;
    private FenetreAjoutAttribut fenetre;
    private final int PACKAGE = 0;
    private final int PROTECTED = 1;
    private final int PUBLIC = 2;
    private final int PRIVATE = 3;

    /**
     * Construit le bouton permettant d'ajouter un attribut
     * @param p_fenetre La fenetre principale
     * @param p_classe La classe danslaquelle on veut ajouter l'attribut
     */
    public BtnValiderAjoutAttribut(FenetreAjoutAttribut p_fenetre, Classe p_classe) {
        super("J'ai fini!");
        this.fenetre = p_fenetre;
        this.classe = p_classe;        
        this.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent me) {
    }

    @Override
    public void mousePressed(MouseEvent me) {
        Visibilite visibilite;
        Liste<Variable> liste = new Liste<Variable>();
        liste.ajouterElement(new Variable(true, "test", "truc"));
        
        switch(this.fenetre.getVisibiliteListe().getSelectedIndex()) {  
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

        this.classe.ajouterAttribut(new Attribut(visibilite, this.fenetre.getDeClasseCheckBox().isSelected(),
                this.fenetre.getConstantCheckBox().isSelected(), this.fenetre.getTypeChampTexte().getText(), 
                this.fenetre.getNomAttributChampTexte().getText()));
        
        this.fenetre.setVisible(false);        
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }
    
}
