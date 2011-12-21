package eltGraphique;

import com.mxgraph.model.mxCell;
import com.mxgraph.view.mxGraph;

/**
 *
 * @author satenske
 */
abstract public class EltGraphique {
    protected mxCell cellule;
    protected mxGraph graph;    
    
    public void afficher(){
        this.cellule.setVisible(true);     
    }
    
    public mxCell getCellule(){
        return this.cellule;
    }
    
    public void setCellule(mxCell p_cellule){
        this.cellule = p_cellule;
    }    
    
    public mxGraph getGraph(){
        return (this.graph);
    }
    
    public void setGraph(mxGraph p_graph){
        this.graph = p_graph;
    }
}
