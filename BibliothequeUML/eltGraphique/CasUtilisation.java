package eltGraphique;

import com.mxgraph.model.mxCell;
import com.mxgraph.view.mxGraph;

/**
 * Modélise un cas d'utilisation par une ellipse et un texte
 *
 */
public class CasUtilisation extends ElementModelisation {

	/**
	 * Constructeur de la classe CasUtilisation
	 * @param p_graph Le graphe auquel sera ajouté le cas d'utilisation
	 * @param p_texte Le texte qui sera associé au cas d'utilisation
	 */
    public CasUtilisation(mxGraph p_graph, String p_texte) {
		super(p_graph, p_texte);
        this.creer();        
    }
    
	/**
	 * Crée la représentation graphique du cas d'utilisation
	 */
    public final void creer(){
        super.setCellule((mxCell) this.graph.insertVertex(
            super.getParent(), null, super.getTexte(), 30, 30, 150, 75, "USECASE"));
    }
  

	/**
	 * Modifie le texte lié au cas d'utilisation
	 * @param p_texte Le nouveau texte lié au cas d'utilisation
	 */
    @Override
    public void setTexte(String p_texte){
        super.setTexte(p_texte);
        super.setValue(p_texte);
    }
}
