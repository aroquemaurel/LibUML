package eltGraphique;

import com.mxgraph.model.mxCell;
import com.mxgraph.view.mxGraph;

/**
 * Modélise un cas d'utilisation par une ellipse et un texte
 *
 * @author satenske
 */
public class CasUtilisation extends ElementModelisation {

	/**
	 * Construteur de la classe CasUtilisation
	 * @param p_graph Le graphe auquel sera ajouter le cas d'utilisation
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
        Object parent = this.graph.getDefaultParent();
        this.cellule = (mxCell) this.graph.insertVertex(
            parent, null, super.getTexte(), 30, 30, 150, 75, "USECASE");
        this.cellule.setVisible(false);
    }
  
	/**
	 * Affiche le cas d'utilisation sur le graphe
	 */
    public void afficher(){
        this.cellule.setVisible(true);     
    }
    
	/**
	 *
	 * @param p_texte Le nouveau texte lié au cas d'utilisation
	 */
    @Override
    public void setTexte(String p_texte){
        super.setTexte(p_texte);
        this.cellule.setValue(p_texte);
    }
}
