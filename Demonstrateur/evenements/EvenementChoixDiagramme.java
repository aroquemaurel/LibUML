package evenements;

import diagramme.Diagramme;
import diagramme.DiagrammeCasUtilisation;
import diagramme.DiagrammeClasse;
import diagramme.DiagrammeSequence;
import ihm.FenetreDemo;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
 
/**
 * Evenement lorsque l'on choisit un diagramme
 */
public class EvenementChoixDiagramme implements MouseListener {
    private FenetreDemo fenetre;
    
    /* Index dans la liste des diagrammes */
    private final int CONTRAINTE_DIAGRAMME_CAS_UTILISATION = 1;
    private final int CONTRAINTE_DIAGRAMME_CLASSE = 2;
    private final int CONTRAINTE_DIAGRAMME_SEQUENCE = 3;
    
    
    public EvenementChoixDiagramme(FenetreDemo p_fenetre){
        this.fenetre = p_fenetre;
    }
    
    @Override
    public void mouseClicked(MouseEvent me) {
        /* En fonction du choix du diagramme, on instancie un diagramme différent */
        Diagramme diagramme;
        switch(this.fenetre.getFenetreChoixDiagramme().getListe().getSelectedIndex()){
            case CONTRAINTE_DIAGRAMME_CAS_UTILISATION :
                diagramme = new DiagrammeCasUtilisation();
                break;
            case CONTRAINTE_DIAGRAMME_CLASSE : 
                diagramme = new DiagrammeClasse();
                break;
            case CONTRAINTE_DIAGRAMME_SEQUENCE :
                diagramme = new DiagrammeSequence();
                break;
            default: //Aucune contrainte :-)
                diagramme = new Diagramme();
        }
        
        this.fenetre.getPanneauGraph().initialiserDiagramme(diagramme);
        this.fenetre.getPanneauDroite().ajouterLabelDiagramme();
        this.fenetre.getFenetreChoixDiagramme().setVisible(false);
    }

    @Override
    public void mousePressed(MouseEvent me) {
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
