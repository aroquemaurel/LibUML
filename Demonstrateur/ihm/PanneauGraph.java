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
    private final Diagramme diagramme;

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
        this.diagramme = new Diagramme();

        this.parametrerPanneau();
    }

    public Diagramme getDiagramme() {
        return diagramme;
    }

}
