package eltGraphique;

import com.mxgraph.model.mxCell;
import com.mxgraph.view.mxGraph;

/**
 * Classe représentant un acteur passif
 */
public class ActeurPassif extends Acteur {
	/**
	 * Constructeur de la classe ActeurPassif
	 * @param p_graph Le graph dans lequel sera l'acteur passif
	 * @param p_texte Le texte qui sera lié à l'acteur passif
	 *
	 * @see Acteur
	 * @see ElementModelisation
	 */
    public ActeurPassif(mxGraph p_graph, String p_texte) {
        super(p_graph, "<<passif>>\n"+p_texte);
    }

	/**
	 * Methode qui permet de créer l'apparence graphique de l'acteur passif
	 */
    @Override
    public final void creer(){
        super.setCellule((mxCell) super.getGraph().insertVertex(
            super.getParent(), null, super.getTexte(), 30, 30, 100, 35));
        super.setVisible(false);
    }


	/**
	 * Changer le texte lié à l'acteur passif
	 * @param p_texte Le nouveau texte à lier
	 */
    @Override
    public void setTexte(String p_texte){
        super.setTexte(p_texte);
        super.setValue(p_texte);
    }
}
