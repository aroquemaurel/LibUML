package eltGraphique.ligne;

import com.mxgraph.model.mxCell;
import com.mxgraph.util.mxConstants;
import com.mxgraph.view.mxGraph;
import com.mxgraph.view.mxStylesheet;
import eltGraphique.ElementModelisation;
import eltGraphique.ElementGraphique;
import java.util.HashMap;
import java.util.Map;

/**
 * Classe servant à la modélistaion des liens dans les différents diagrammes
 *
 * Les différents types de liens sont gérés grâce à un attribut de type TypeLien
 *
 * @see TypeLien
 */
public class Lien extends ElementGraphique {
    /**
     * Element à l'origine du lien
     * @see ElementModelisation
     */
    private ElementModelisation source;
    /**
     * Element à l'extremite du lien
     * @see ElementModelisation
     */
    private ElementModelisation destination;
    /**
     * Rôle du côté de l'origine du lien
     */
    private String roleSource;
    /**
     * Rôle du côté de l'extrémité du lien
     */
    private String roleDestination;
    /**
     * Le type de la flèche à l'extrémité
     */
    private String typePointeDestination;
    /**
     * Le type de la flèche à l'origine
     */
    private String typePointeSource;
    /**
     * La cardinalité à l'origine
     * @see Cardinalite
     */
    private Cardinalite cardinaliteSource;
    /**
     * La cardinalité à l'extrémité
     * @see Cardinalite
     */
    private Cardinalite cardinaliteDestionation;
    /**
     * Le type de la flèche
	 * @see TypeLien
     */
    private TypeLien typeLien;

	/**
	 * Constructeur de la classe Lien modelisant tout type de lien dans un graphe
	 * @param p_source Element à l'origine de la flèche
	 * @param p_destination Elemet à l'extrémité de la flèche
	 * @param p_graph Graphe auquel est associé la flèche
	 * @param p_typeFleche Type de la flèche
	 *
	 * @see ElementModelisation
	 * @see TypeLien
	 */
    public Lien(ElementModelisation p_source, ElementModelisation p_destination, mxGraph p_graph,
        TypeLien p_typeLien){
        super(p_graph);
        this.source = p_source;
        this.destination = p_destination;
        this.typeLien = p_typeLien;
    }
	/*
	 * Getters
	 */
	/**
	 * Récupère l'élément à l'extrémité de la flèche
	 * @return L'élément à l'extrémité de la flèche
	 */
	public ElementModelisation getDestination() {
		return (this.destination);
	}

	/**
	 * Récupère l'élément à l'origine de la flèche
	 * @return L'élément à l'origine de la flèche
	 */
	@Override
	public ElementModelisation getSource() {
		return (this.source);
	}

	/**
	 * Récupère le rôle du côté de l'origine de la flèche
	 * @return Le rôle de l'origine de la pièce
	 */
	public String getRoleSource() {
		return (this.roleSource);
	}

	/**
	 * Récupère le type de pointe de flèche à l'extrémité
	 * @return Le type de pointe de flèche à l'extrémité
	 */
	public String getTypePointeDestination() {
		return (this.typePointeDestination);
	}

	/**
	 * Récupère le type de pointe de flèche à l'origine
	 * @return Le type de pointe de flèche à l'origine
	 */
	public String getTypePointeSource() {
		return (this.typePointeSource);
	}

	/*
	 * Setters
	 */

	/**
	 * Modifie l'élément à l'extrémité de la flèche
	 * @param p_destination Le nouvel élément à l'éxtrémité de la flèche
	 */
	public void setExtremite(ElementModelisation p_destination) {
		this.destination = p_destination;
	}

	/**
	 * Modifie l'élément à l'origine de la flèche
	 * @param p_source Le nouvelle élément à l'origine de la flèche
	 */
	public void setOrigine(ElementModelisation p_source) {
		this.source = p_source;
	}

	/**
	 * Modifie le rôle du côté de l'extrémité de la flèche
	 * @param p_roleDestionation Le nouveau rôle de l'extrémité de la flèche
	 */
	public void setTexteExtremite(String p_roleDestionation) {
		this.roleDestination = p_roleDestionation;
	}

	/**
	 * Modifi le rôle du côté de l'origine de la flèche
	 * @param p_roleSource Le nouveau rôle de l'origine de la flèche
	 */
	public void setTexteOrigine(String p_roleSource) {
		this.roleSource = p_roleSource;
	}

	/**
	 * Modifie le type de pointe de flèche du côté de l'extrémité de la flèche
	 * @param p_typePointeDestionation Le nouveau type de pointe de flèche
	 */
	public void setTypeFlecheExtremite(String p_typePointeDestionation) {
		this.typePointeDestination = p_typePointeDestionation;
	}

	/**
	 * Modifie le type de pointe de flmèche du côté de l'origie de la flèche
	 * @param p_typePointeSource Le nouveau type de pointe de flèche
	 */
	public void setTypeFlecheOrigine(String p_typePointeSource) {
		this.typePointeSource = p_typePointeSource;
	}

	/**
	 * Créer le style et la représentation de la flèche en fonction
	 * des attributs de la classe.
	 */
	@Override
    public void creer(){
		mxStylesheet feuilleStyles = this.getGraph().getStylesheet();
		Map<String, Object> nouveauStyle = new HashMap<String, Object>();

        switch(this.typeLien){
            case SPECIALISATION:
                nouveauStyle.put(mxConstants.STYLE_EDGE,
                mxConstants.EDGESTYLE_ORTHOGONAL);
                nouveauStyle.put(mxConstants.STYLE_ENDARROW, mxConstants.ARROW_BLOCK);
                nouveauStyle.put(mxConstants.STYLE_OPACITY, 50);
                nouveauStyle.put(mxConstants.STYLE_MOVABLE, mxConstants.NONE);
                nouveauStyle.put(mxConstants.STYLE_STROKECOLOR, "#000000");
                feuilleStyles.putCellStyle("SPECIALISATION", nouveauStyle);
                break;
            case ASSOCIATION:
                nouveauStyle.put(mxConstants.STYLE_EDGE, mxConstants.EDGESTYLE_ORTHOGONAL);
                nouveauStyle.put(mxConstants.STYLE_ENDARROW, mxConstants.ARROW_SPACING);
                nouveauStyle.put(mxConstants.STYLE_OPACITY, 50);
                nouveauStyle.put(mxConstants.STYLE_MOVABLE, 50);
                nouveauStyle.put(mxConstants.STYLE_STROKECOLOR, "#000000");
                feuilleStyles.putCellStyle("ASSOCIATION", nouveauStyle);
                break;
            case FLECHE:
                nouveauStyle.put(mxConstants.STYLE_EDGE, mxConstants.EDGESTYLE_TOPTOBOTTOM);
                nouveauStyle.put(mxConstants.STYLE_ENDARROW, mxConstants.ARROW_CLASSIC);
                nouveauStyle.put(mxConstants.STYLE_OPACITY, 50);
                nouveauStyle.put(mxConstants.STYLE_MOVABLE, mxConstants.NONE);
                nouveauStyle.put(mxConstants.STYLE_STROKECOLOR, "#000000");
                feuilleStyles.putCellStyle("FLECHE", nouveauStyle);
                break;
            case AGREGATION:
                nouveauStyle.put(mxConstants.STYLE_EDGE, mxConstants.EDGESTYLE_TOPTOBOTTOM);
                nouveauStyle.put(mxConstants.STYLE_ENDARROW, mxConstants.ARROW_DIAMOND);
                nouveauStyle.put(mxConstants.STYLE_OPACITY, 100);
                nouveauStyle.put(mxConstants.STYLE_MOVABLE, mxConstants.NONE);
                nouveauStyle.put(mxConstants.STYLE_STROKECOLOR, "#000000");
                nouveauStyle.put(mxConstants.STYLE_FONTCOLOR, "#FFFFFF");
                nouveauStyle.put(mxConstants.STYLE_FILLCOLOR, "#FFFFFF");
                //TODO couleur de fond bout des flêches ?!
                feuilleStyles.putCellStyle("AGREGATION", nouveauStyle);
                break;
            case COMPOSITION:
                nouveauStyle.put(mxConstants.STYLE_EDGE, mxConstants.EDGESTYLE_TOPTOBOTTOM);
                nouveauStyle.put(mxConstants.STYLE_ENDARROW, mxConstants.ARROW_DIAMOND);
                nouveauStyle.put(mxConstants.STYLE_OPACITY, 50);
                nouveauStyle.put(mxConstants.STYLE_MOVABLE, mxConstants.NONE);
                nouveauStyle.put(mxConstants.STYLE_STROKECOLOR, "#000000");
                feuilleStyles.putCellStyle("COMPOSITION", nouveauStyle);
            break;
        }

		super.setCellule((mxCell) super.getGraph().insertEdge(
			super.getGraph().getDefaultParent(), null, null,
			this.getSource().getCellule(), this.getDestination().getCellule(),
			this.typeLien.toString()));
		super.setConnectable(false);
    }

}
