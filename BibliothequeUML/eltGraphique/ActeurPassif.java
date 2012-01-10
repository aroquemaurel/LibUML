package eltGraphique;

import com.mxgraph.model.mxCell;
import com.mxgraph.view.mxGraph;
import diagramme.Diagramme;
import java.awt.Dimension;

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
    public ActeurPassif(mxGraph p_graph, Diagramme p_diagramme, String p_texte) {
        super(p_graph, p_diagramme, "<<passif>>\n"+p_texte, new Dimension(100,35));
    }

	/**
	 * Methode qui permet de créer l'apparence graphique de l'acteur passif
	 */
    @Override
    public final void creer(){
        super.setCellule((mxCell) super.getGraph().insertVertex(
            super.getParent(), null, super.getTexte(), 30, 30,
			super.getDimension().getWidth(), super.getDimension().getHeight()));
        super.setVisible(false);
        super.getDiagramme().getElementsGraphique().add(this);
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
