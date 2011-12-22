package eltGraphique;

import com.mxgraph.model.mxCell;
import com.mxgraph.util.mxConstants;
import com.mxgraph.view.mxGraph;
import com.mxgraph.view.mxStylesheet;
import java.util.HashMap;

/**
 *
 * @author satenske
 */
abstract public class EltGraphique {
    protected mxCell cellule;
    protected mxGraph graph;    
    
   private void creerLesStyle() {
		mxStylesheet stylesheet =
		    this.graph.getStylesheet();
		HashMap<String, Object> style =
		    new HashMap<String, Object>();

        /* Ateur */
		style.put(mxConstants.STYLE_SHAPE,
			  mxConstants.SHAPE_ACTOR);
		style.put(mxConstants.STYLE_OPACITY, 50);
		style.put(mxConstants.STYLE_FONTCOLOR, "#774400");
		stylesheet.putCellStyle("ACTEUR", style);


		/* UseCase */
		style = null;
		style = new HashMap<String, Object>();
		style.put(mxConstants.STYLE_SHAPE,
			  mxConstants.SHAPE_ELLIPSE);
		style.put(mxConstants.STYLE_OPACITY, 50);
		style.put(mxConstants.STYLE_FONTCOLOR, "#774400");
		stylesheet.putCellStyle("USECASE", style);
        
        /* Spécialisation */
        style = null;
		style = new HashMap<String, Object>();
		style.put(mxConstants.STYLE_EDGE,
			  mxConstants.EDGESTYLE_ORTHOGONAL);
        style.put(mxConstants.STYLE_ENDARROW, mxConstants.ARROW_BLOCK);
		style.put(mxConstants.STYLE_OPACITY, 50);
		style.put(mxConstants.STYLE_STROKECOLOR, "#000000");
		stylesheet.putCellStyle("SPECIALISATION", style);        
        
        /* Lien continu */
        style = null;
		style = new HashMap<String, Object>();
		style.put(mxConstants.STYLE_EDGE,
			  mxConstants.EDGESTYLE_ORTHOGONAL);
        style.put(mxConstants.STYLE_ENDARROW, mxConstants.ARROW_SPACING);
		style.put(mxConstants.STYLE_OPACITY, 50);
		style.put(mxConstants.STYLE_STROKECOLOR, "#000000");
		stylesheet.putCellStyle("LIENCONTINU", style);          
	}
   
   public EltGraphique(mxGraph p_graph){
       this.graph = p_graph;
       this.creerLesStyle();
   }
       
    public void setVisible(boolean p_bool){
        this.cellule.setVisible(p_bool);     
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
    abstract public void creer();    
}
