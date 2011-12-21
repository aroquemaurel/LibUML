package eltGraphique.ligne;

import com.mxgraph.model.mxCell;
import com.mxgraph.view.mxGraph;
import eltGraphique.ElementModelisation;

/**
 *
 * @author satenske
 */
public class LienContinu extends Lien {
    
    public LienContinu(ElementModelisation p_origine, ElementModelisation p_extremite, mxGraph p_graph){
        super(p_origine, p_extremite, p_graph);      
        super.cellule = (mxCell) super.graph.insertEdge(
            super.graph.getDefaultParent(), null, null,
            p_origine.getCellule(), p_extremite.getCellule(), 
            "LIENCONTINU");
        
        super.cellule.setVisible(false);
    }
}
