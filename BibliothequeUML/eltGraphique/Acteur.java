package eltGraphique;

import com.mxgraph.model.mxCell;
import com.mxgraph.util.mxConstants;
import com.mxgraph.view.mxGraph;
import com.mxgraph.view.mxStylesheet;
import diagramme.Diagramme;
import java.awt.Dimension;
import java.util.HashMap;
import java.util.Map;
import util.Constantes;

/**
 * Classe ancête aux deux types d'acteurs : actifs et passifs.
 * Ces deux types d'acteurs sont différenciers pour une raison de
 * représentation graphique principalement
 *
 * @see ActeurActif
 * @see ActeurPassif
 *
 */
abstract public class Acteur extends ElementModelisation {
	private mxCell ligneDeVie;

	private void creerStyleLigneDeVie(){
		mxStylesheet feuilleStyles = this.getGraph().getStylesheet();
		Map<String, Object> nouveauStyle = new HashMap<String, Object>();
		nouveauStyle.put(mxConstants.STYLE_ENDARROW, mxConstants.NONE);
        nouveauStyle.put(mxConstants.STYLE_EDGE, mxConstants.EDGESTYLE_TOPTOBOTTOM);
		nouveauStyle.put(mxConstants.STYLE_OPACITY, 100);
		nouveauStyle.put(mxConstants.STYLE_DASHED, true);
		nouveauStyle.put(mxConstants.STYLE_MOVABLE, 0);
        nouveauStyle.put(mxConstants.STYLE_FOLDABLE, 0);
        nouveauStyle.put(mxConstants.STYLE_AUTOSIZE, 0);
        nouveauStyle.put(mxConstants.STYLE_AUTOSIZE, 0);
        nouveauStyle.put(mxConstants.STYLE_TARGET_PERIMETER_SPACING, 3000);
        nouveauStyle.put(mxConstants.STYLE_SOURCE_PERIMETER_SPACING, 30);
		nouveauStyle.put(mxConstants.STYLE_STROKECOLOR, Constantes.COULEUR_FLECHE);
		nouveauStyle.put(mxConstants.STYLE_FONTCOLOR, Constantes.COULEUR_TEXTE);
		feuilleStyles.putCellStyle("LIGNE_DE_VIE", nouveauStyle);

	}

    /**
     * Méthode abstraite
     * Crée la représentation graphique de l'acteur
     *
     * @see ActeurActif
     * @see ActeurPassif
     */
    @Override
    abstract public void creer();

    /** * Constructeur le la classe Acteur * * @param p_graph le graphe sur lequel il faut ajouter l'acteur
     * @param p_texte le texte qui sera afficher sur l'acteur
     *
     */
    public Acteur(mxGraph p_graph, Diagramme p_diagramme, String p_texte, Dimension p_dimension) {
            super(p_graph, p_diagramme, p_texte, p_dimension);
    }

	public void creerLigneDeVie(){
		this.creerStyleLigneDeVie();
		this.ligneDeVie = (mxCell) super.getGraph().insertEdge(
			null, null, null, this.getCellule(), this.getCellule(), "LIGNE_DE_VIE");
        this.ligneDeVie.getGeometry().setX(420);
	}

    /**
     * Modifie le texte lié à l'acteur.
     * @param p_texte Le texte lié à l'acteur
     */
    @Override
    public void setTexte(String p_texte){
        super.setTexte(p_texte);
        super.setValue(p_texte);
    }

	public mxCell getLigneDeVie(){
		return (this.ligneDeVie);
	}

}

