package eltGraphique.eltModelisation;

import com.mxgraph.model.mxCell;
import com.mxgraph.util.mxConstants;
import com.mxgraph.util.mxPoint;
import com.mxgraph.view.mxGraph;
import com.mxgraph.view.mxStylesheet;
import diagramme.Diagramme;
import java.awt.Dimension;
import java.util.HashMap;
import java.util.Map;
import util.Constantes;
import util.Position;

/**
 * Classe propre aux acteurs actifs (représentation graphique)
 *
 * @see Acteur
 * @see ActeurActif
 *
 * @author Antoine
 * @author Mathieu
 */
public class ActeurActif extends Acteur {
	/**
	 * Décalage du texte lié à l'acteur (ordonnée)
	 */
    private static final double OFFSET_TEXTE_ACTEUR_Y = 51;
	
	/**
	 * Décalage du texte lié à l'acteur (abscisse)
	 */
    private static final double OFFSET_TEXTE_ACTEUR_X = 0;

    /**
	 * Creer le style d'un acteur Actif
	 */
    private void creerStyleActeurActif() {
		Map<String, Object> nouveauStyle = new HashMap<String, Object>();
		mxStylesheet feuilleStyles = super.getGraph().getStylesheet();

		nouveauStyle.put(mxConstants.STYLE_SHAPE, mxConstants.SHAPE_ACTOR);
		nouveauStyle.put(mxConstants.STYLE_OPACITY, Constantes.OPACITE);
		nouveauStyle.put(mxConstants.STYLE_FONTCOLOR, Constantes.COULEUR_TEXTE);
		nouveauStyle.put(mxConstants.STYLE_STROKECOLOR, Constantes.COULEUR_BORDURE);
		nouveauStyle.put(mxConstants.STYLE_FOLDABLE, mxConstants.NONE);

		feuilleStyles.putCellStyle("ACTEUR_ACTIF", nouveauStyle);
    }

    /**
     * Constructeur de la classe ActeurActif qui créer un acteur actif
     * lié à un graphe donné avec un texte donné
	 *
     * @param p_graph Le graphe sur lequel sera ajouté l'acteur actif
     * @param p_texte Le texte lié à l'acteur actif
     */
    public ActeurActif(mxGraph p_graph, Diagramme p_diagramme, String p_texte, Position p_position){
        super(p_graph, p_diagramme, p_texte, new Dimension(60,85), p_position);
    }

    /**
     * Crée la représentation de l'acteur actif
     */
    @Override
    public final void creer(){
        super.getGraph().getModel().beginUpdate();
        this.creerStyleActeurActif();

        super.setCellule((mxCell) super.getGraph().insertVertex(
            null, null, super.getTexte(), super.getPosition().getAbscisse(), 
                        super.getPosition().getOrdonnee(),
			super.getDimension().getWidth(), super.getDimension().getHeight(), "ACTEUR_ACTIF"));

		super.getCellule().getGeometry().setOffset(new mxPoint(OFFSET_TEXTE_ACTEUR_X, OFFSET_TEXTE_ACTEUR_Y));
        super.getDiagramme().getElementsGraphiques().add(this);

        super.creerLigneDeVie();
		super.afficherLigneDeVie(false);
		super.getGraph().getModel().endUpdate();
    }

}

