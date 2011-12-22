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

    }

    public void creer(String p_style) {
        super.cellule = (mxCell) super.getGraph().insertEdge(
            super.getGraph().getDefaultParent(), null, null,
            super.getOrigine().getCellule(), super.getExtremite().getCellule(), 
            p_style);
    }

    @Override
    public void creer() {
        this.creer("LIENCONTINU");
    }
}
