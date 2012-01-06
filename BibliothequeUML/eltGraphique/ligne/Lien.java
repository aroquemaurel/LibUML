package eltGraphique.ligne;

import com.mxgraph.model.mxCell;
import com.mxgraph.util.mxConstants;
import com.mxgraph.view.mxGraph;
import com.mxgraph.view.mxStylesheet;
import eltGraphique.ElementModelisation;
import eltGraphique.EltGraphique;
import java.util.HashMap;
import java.util.Map;

/**
 * Classe servant à la modélistaion des liens dans les différents diagrammes
 * 
 * Les différents types de liens sont gérés grâce à un attribut de type TypeLien
 * 
 * @see TypeLien
 */
public class Lien extends EltGraphique {
    /**
     * Element à l'origine du lien
     * @see ElementModelisation
     */
    private ElementModelisation origine;
    /**
     * Element à l'extremite du lien
     * @see ElementModelisation
     */
    private ElementModelisation extremite;
    /**
     * Rôle du côté de l'origine du lien
     */
    private String texteOrigine;
    /**
     * Rôle du côté de l'extrémité du lien
     */
    private String texteExtremite;
    /**
     * Le type de la flèche à l'extrémité
     */
    private String typeFlecheExtremite;
    /**
     * Le type de la flèche à l'origine
     */
    private String typeFlecheOrigine;
    /**
     * La cardinalité à l'origine
     * @see Cardinalite
     */
    private Cardinalite cardinaliteOrigine;
    /**
     * La cardinalité à l'extrémité
     * @see Cardinalite
     */
    private Cardinalite cardinaliteExtremite;
    /**
     * Le type de la flèche 
	 * @see TypeLien
     */
    private TypeLien typeFleche;
    
	/**
	 * Constructeur de la classe Lien modelisant tout type de lien dans un graphe
	 * @param p_origine Element à l'origine de la flèche
	 * @param p_extremite Elemet à l'extrémité de la flèche
	 * @param p_graph Graphe auquel est associé la flèche
	 * @param p_typeFleche Type de la flèche
	 * 
	 * @see ElementModelisation
	 * @see TypeLien
	 */
    public Lien(ElementModelisation p_origine, ElementModelisation p_extremite, mxGraph p_graph,
        TypeLien p_typeFleche){
        super(p_graph);
        this.origine = p_origine;
        this.extremite = p_extremite;
        this.typeFleche = p_typeFleche;
    }
	/*
	 * Getters
	 */
	/**
	 * Récupère l'élément à l'extrémité de la flèche
	 * @return L'élément à l'extrémité de la flèche
	 */
	public ElementModelisation getExtremite() {
		return (this.extremite);
	}

	/**
	 * Récupère l'élément à l'origine de la flèche
	 * @return L'élément à l'origine de la flèche
	 */
	public ElementModelisation getOrigine() {
		return (this.origine);
	}

	/**
	 * Récupère le rôle du côté de l'origine de la flèche
	 * @return Le rôle de l'origine de la pièce
	 */
	public String getTexteOrigine() {
		return (this.texteOrigine);
	}

	/**
	 * Récupère le type de pointe de flèche à l'extrémité
	 * @return Le type de pointe de flèche à l'extrémité
	 */
	public String getTypeFlecheExtremite() {
		return (this.typeFlecheExtremite);
	}

	/**
	 * Récupère le type de pointe de flèche à l'origine
	 * @return Le type de pointe de flèche à l'origine
	 */
	public String getTypeFlecheOrigine() {
		return (this.typeFlecheOrigine);
	}

	/*
	 * Setters
	 */
	
	/**
	 * Modifie l'élément à l'extrémité de la flèche
	 * @param p_extremite Le nouvel élément à l'éxtrémité de la flèche
	 */
	public void setExtremite(ElementModelisation p_extremite) {
		this.extremite = p_extremite;
	}

	/**
	 * Modifie l'élément à l'origine de la flèche
	 * @param p_origine Le nouvelle élément à l'origine de la flèche
	 */
	public void setOrigine(ElementModelisation p_origine) {
		this.origine = p_origine;
	}

	/**
	 * Modifie le rôle du côté de l'extrémité de la flèche
	 * @param p_texteExtremite Le nouveau rôle de l'extrémité de la flèche
	 */
	public void setTexteExtremite(String p_texteExtremite) {
		this.texteExtremite = p_texteExtremite;
	}

	/**
	 * Modifi le rôle du côté de l'origine de la flèche
	 * @param p_texteOrigine Le nouveau rôle de l'origine de la flèche
	 */
	public void setTexteOrigine(String p_texteOrigine) {
		this.texteOrigine = p_texteOrigine;
	}

	/**
	 * Modifie le type de pointe de flèche du côté de l'extrémité de la flèche
	 * @param p_typeFlecheExtremite Le nouveau type de pointe de flèche
	 */
	public void setTypeFlecheExtremite(String p_typeFlecheExtremite) {
		this.typeFlecheExtremite = p_typeFlecheExtremite;
	}

	/**
	 * Modifie le type de pointe de flmèche du côté de l'origie de la flèche
	 * @param p_typeFlecheOrigine Le nouveau type de pointe de flèche
	 */
	public void setTypeFlecheOrigine(String p_typeFlecheOrigine) {
		this.typeFlecheOrigine = p_typeFlecheOrigine;
	}
    
	/**
	 * Créer le style et la représentation de la flèche en fonction 
	 * des attributs de la classe.
	 */
	@Override
    public void creer(){
		mxStylesheet feuilleStyles = this.getGraph().getStylesheet();
		Map<String, Object> nouveauStyle = new HashMap<String, Object>();
		
		if (this.typeFleche.equals(TypeLien.SPECIALISATION)) {
			nouveauStyle.put(mxConstants.STYLE_EDGE,
			mxConstants.EDGESTYLE_ORTHOGONAL);
			nouveauStyle.put(mxConstants.STYLE_ENDARROW, mxConstants.ARROW_BLOCK);
			nouveauStyle.put(mxConstants.STYLE_OPACITY, 50);
			nouveauStyle.put(mxConstants.STYLE_MOVABLE, 50);
			nouveauStyle.put(mxConstants.STYLE_STROKECOLOR, "#000000");
			feuilleStyles.putCellStyle("SPECIALISATION", nouveauStyle);
		} else if (this.typeFleche.equals(TypeLien.LIENCONTINU)) {
			nouveauStyle.put(mxConstants.STYLE_EDGE, mxConstants.EDGESTYLE_ORTHOGONAL);
			nouveauStyle.put(mxConstants.STYLE_ENDARROW, mxConstants.ARROW_SPACING);
			nouveauStyle.put(mxConstants.STYLE_OPACITY, 50);
			nouveauStyle.put(mxConstants.STYLE_MOVABLE, 50);
			nouveauStyle.put(mxConstants.STYLE_STROKECOLOR, "#000000");
			feuilleStyles.putCellStyle("LIENCONTINU", nouveauStyle);
		} else if (this.typeFleche.equals(TypeLien.FLECHECURVILIGNE)) {
			nouveauStyle.put(mxConstants.STYLE_EDGE, mxConstants.EDGESTYLE_TOPTOBOTTOM);
			nouveauStyle.put(mxConstants.STYLE_ENDARROW, mxConstants.ARROW_CLASSIC);
			nouveauStyle.put(mxConstants.STYLE_OPACITY, 50);
			nouveauStyle.put(mxConstants.STYLE_MOVABLE, 50);
			nouveauStyle.put(mxConstants.STYLE_STROKECOLOR, "#000000");
			feuilleStyles.putCellStyle("FLECHECURVILIGNE", nouveauStyle);
			
		}
		
		super.setCellule((mxCell) super.getGraph().insertEdge(
			super.getGraph().getDefaultParent(), null, null,
			this.getOrigine().getCellule(), this.getExtremite().getCellule(), 
			this.typeFleche.toString()));
		super.setConnectable(false);        
    }

}
