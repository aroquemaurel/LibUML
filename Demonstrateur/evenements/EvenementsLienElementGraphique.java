package evenements;

import com.mxgraph.model.mxCell;
import diagramme.Diagramme;
import eltGraphique.ElementModelisation;
import eltGraphique.ligne.Lien;
import eltGraphique.ligne.TypeLien;
import ihm.PanneauGraph;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Cette classe prmet de gérér le lien entre deux éléments graphiques.
 * @author satenske
 */
public class EvenementsLienElementGraphique implements MouseListener {
    private final PanneauGraph panneauGraph;
    private final Diagramme diagramme;
    private final TypeLien typeDeLien;
    private int numeroClique;
    private mxCell sourceCelluleARelier;
    private mxCell destinationCelluleARelier;

    /**
    * Constructeur d'un évènement de lien entre deux éléments graphiques.
    * @param p_panneauGraph panneau graphique dans lequel le lien est fait
    * @param  p_diagramme diagramme dans lequel le lien est fait
    * @param p_typeDeLien type du lien créé
    */
    public EvenementsLienElementGraphique(PanneauGraph p_panneauGraph, Diagramme p_diagramme,
                                    TypeLien p_typeDeLien) {
        this.panneauGraph = p_panneauGraph;
        this.diagramme = p_diagramme;
        this.typeDeLien = p_typeDeLien;
        this.sourceCelluleARelier = null;
        this.destinationCelluleARelier = null;
        this.numeroClique = 0;
    }

    /**
    * Cette classe permet de gérer les actions produites lors d'un click avec la souris.
    * @param event évènement en cours
    */
    @Override
    public void mouseClicked(MouseEvent event) {
        mxCell celluleActuelle = (mxCell) this.panneauGraph.getGraph().getSelectionCell();
        if(celluleActuelle != null){
            if(this.sourceCelluleARelier == null) {
                this.numeroClique++;
                this.sourceCelluleARelier = celluleActuelle;

                celluleActuelle = null;
            } else if(!celluleActuelle.equals(sourceCelluleARelier)){
                this.numeroClique++;
                this.destinationCelluleARelier = celluleActuelle;

            }
            if(this.destinationCelluleARelier != null && sourceCelluleARelier != null){
                Lien monLien = new Lien(
                    (ElementModelisation) this.diagramme.getElementGraphiqueViaCellule(
                                                                    this.sourceCelluleARelier),
                    (ElementModelisation) this.diagramme.getElementGraphiqueViaCellule(
                                                                    this.destinationCelluleARelier),
                    this.panneauGraph.getGraph(), this.panneauGraph.getDiagramme(),
                    this.typeDeLien);

                monLien.creer();
            }
        }

        if(numeroClique >= 2){
            this.panneauGraph.getGraphControl().removeMouseListener(this);
        }

    }
    
    /**
    * Retourne le numéro du clique.
    * @return numéro du clique
    */
    public int getNumeroClique(){
        return (this.numeroClique);
    }

    /**
    * Cette classe permet de gérer les actions produites lors d'une pression avec la souris.
    * @param arg0 évènement en cours
    */
    @Override
    public void mousePressed(MouseEvent arg0) {
    }

    /**
    * Cette classe permet de gérer les actions produites lors d'une release avec la souris.
    * @param event évènement en cours
    */
    @Override
    public void mouseReleased(MouseEvent arg0) {

    }

    /**
    * Cette classe permet de gérer les actions produites lors d'une entrée avec la souris.
    * @param arg0 évènement en cours
    */
    @Override
    public void mouseEntered(MouseEvent arg0) {
    }

    /**
    * Cette classe permet de gérer les actions produites lors d'une sortie avec la souris.
    * @param arg0 évènement en cours
    */
    @Override
    public void mouseExited(MouseEvent arg0) {
    }

    /* TODO Relire la JavaDoc */
}
