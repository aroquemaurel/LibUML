package eltGraphique;

import com.mxgraph.model.mxCell;
import com.mxgraph.view.mxGraph;

/**
 *
 * @author satenske
 */
public class ActeurPassif extends Acteur {
    public ActeurPassif(mxGraph p_graph, String p_nom){
        super(p_graph, p_nom);
    }
    
    @Override
    public void creer(){
        Object parent = super.getGraph().getDefaultParent();
        
        super.setCellule((mxCell) super.getGraph().insertVertex(
            parent, null, super.getNom(), 30, 30, 100, 35));
        super.getCellule().setVisible(false);
    }
    
    @Override
    public void afficher(){
        super.getCellule().setVisible(true);     
    }
    
    @Override
    public void setNom(String p_nom){
        super.setNom(p_nom);
        super.getCellule().setValue(p_nom);
    }
}
