package ihm;

import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;
import diagramme.Diagramme;
import java.awt.Dimension;

/**
 * Panneau contenant le graph
 */
public class PanneauGraph extends mxGraphComponent {
    private final int largeurPanneau;
    private final int longueurPanneau;
    private Diagramme diagramme;


    /* Paramètres du panneau */
    private void parametrerPanneau(){
        this.setGridVisible(false);
        this.setInvokesStopCellEditing(true);
        this.setPreferredSize(new Dimension(this.largeurPanneau, this.longueurPanneau));
    }

    /* Construit le panneau du graph */
    public PanneauGraph(int p_largeurPanneau, int p_longueurPanneau){
        super(new mxGraph());

        this.largeurPanneau = p_largeurPanneau;
        this.longueurPanneau = p_longueurPanneau;

        this.diagramme = null;
        this.parametrerPanneau();
    }

    /* Retourne le diagramme contenant tous les éléments grahiques */
    public Diagramme getDiagramme() {
        return (this.diagramme);
    }
    
    public void initialiserDiagramme(Diagramme p_diagramme){
        this.diagramme = p_diagramme;
    }
    


}
