package eltGraphique;

import com.mxgraph.model.mxCell;
import com.mxgraph.view.mxGraph;

/**
 *
 * @author satenske
 */
public class ActeurActif extends Acteur {
    public ActeurActif(mxGraph p_graph, String p_nom){
        super(p_graph, p_nom);
        this.creer();
    }
    
    @Override
    public void creer(){
        Object parent = super.graph.getDefaultParent();
        
        super.cellule = (mxCell) super.graph.insertVertex(
            parent, null, super.getNom(), 30, 30, 60, 85, "ACTEUR");
        super.cellule.setVisible(false);
    }

}

