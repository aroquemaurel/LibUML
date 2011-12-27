package eltGraphique;

import com.mxgraph.model.mxCell;
import com.mxgraph.view.mxGraph;

/**
 * Classe représentant un acteur passif
 * @author satenske
 */
public class ActeurPassif extends Acteur {
    public ActeurPassif(mxGraph p_graph, String p_nom){
        super(p_graph, "<<passif>>\n"+p_nom);
        this.creer();        
    }
    
    @Override
    public void creer(){
        Object parent = super.getGraph().getDefaultParent();
        
        super.setCellule((mxCell) super.getGraph().insertVertex(
            parent, null, super.getTexte(), 30, 30, 100, 35));
        super.getCellule().setVisible(false);
    }
    
    @Override
    public void afficher(){
        super.getCellule().setVisible(true);     
    }
    
    @Override
    public void setTexte(String p_texte){
        super.setTexte(p_texte);
        super.getCellule().setValue(p_texte);
    }
}
