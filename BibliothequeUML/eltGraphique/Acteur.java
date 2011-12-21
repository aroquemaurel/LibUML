package eltGraphique;

import com.mxgraph.view.mxGraph;

/**
 *
 * @author satenske
 */
abstract public class Acteur extends ElementModelisation {
    abstract public void creer();
         
    public Acteur(mxGraph p_graph, String p_nom){
        super.graph = p_graph;
        super.setNom(p_nom);
    }

    @Override
    public void setNom(String p_nom){
        super.setNom(p_nom);
        super.cellule.setValue(p_nom);
    }

}
