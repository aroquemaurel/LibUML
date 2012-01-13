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
 *
 * @author satenske
 */
public class EvenementsEltGraphiques implements MouseListener {
    private PanneauGraph panneauGraph;
    private Diagramme diagramme;
    private TypeLien typeDeLien;
    private int numeroClique;
    private mxCell sourceCelluleARelier;
    private mxCell destinationCelluleARelier;

    public EvenementsEltGraphiques(PanneauGraph p_panneauGraph, Diagramme p_diagramme,
                                    TypeLien p_typeDeLien) {
        this.panneauGraph = p_panneauGraph;
        this.diagramme = p_diagramme;
        this.typeDeLien = p_typeDeLien;
        this.sourceCelluleARelier = null;
        this.destinationCelluleARelier = null;
        this.numeroClique = 0;
    }

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

    public int getNumeroClique(){
        return (this.numeroClique);
    }

    @Override
    public void mousePressed(MouseEvent arg0) {
    }

    @Override
    public void mouseReleased(MouseEvent arg0) {

    }

    @Override
    public void mouseEntered(MouseEvent arg0) {
    }

    @Override
    public void mouseExited(MouseEvent arg0) {
    }

}
