package eltGraphique;

import com.mxgraph.model.mxCell;
import com.mxgraph.view.mxGraph;

/**
 *
 * @author satenske
 */
public class CasUtilisation extends ElementModelisation {
    public CasUtilisation(mxGraph p_graph, String p_nom){
        super(p_nom, p_graph);
        this.creer();        
    }
    
    public void creer(){
        Object parent = super.graph.getDefaultParent();
        super.setCellule((mxCell) super.graph.insertVertex(
            parent, null, super.getNom(), 30, 30, 150, 75, "USECASE"));
        super.getCellule().setVisible(false);
    }
  
    @Override
    public void setNom(String p_nom){
        super.setNom(p_nom);
        super.cellule.setValue(p_nom);
    }
}
