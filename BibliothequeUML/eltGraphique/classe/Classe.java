package eltGraphique.classe;

import com.mxgraph.model.mxCell;
import com.mxgraph.util.mxConstants;
import com.mxgraph.view.mxGraph;
import com.mxgraph.view.mxStylesheet;
import diagramme.Diagramme;
import java.awt.Dimension;
import java.util.HashMap;
import java.util.Map;
import util.Constantes;
import util.Liste;

/**
 *
 * @author Mathieu
 * @author Antoine
 */
public class Classe extends eltGraphique.ElementModelisation {
    /**
            * Classe abstraite ?
            */
    private boolean abstraite;
    
    /**
    * Liste des méthodes de la classe
    * @see Methode
    */
    private Liste<Methode> methodes;
    
    /**
    * Liste des attributs de la classe
    * @see Attribut
    */
    private Liste<Attribut> attributs;
    
    /**
    * Classe cosntante ?
    */
    private boolean constante;
    
    /**
    * Creer le style d'une classe
    */
    private void creerStyleClasse(){
        mxStylesheet feuilleStyles = this.getGraph().getStylesheet();
        Map<String, Object> nouveauStyle = new HashMap<String, Object>();

        nouveauStyle.put(mxConstants.STYLE_SHAPE, mxConstants.SHAPE_SWIMLANE);
        nouveauStyle.put(mxConstants.STYLE_OPACITY, Constantes.OPACITE);
        nouveauStyle.put(mxConstants.STYLE_FOLDABLE, mxConstants.NONE);
        nouveauStyle.put(mxConstants.STYLE_FONTCOLOR, Constantes.COULEUR_TEXTE);
        nouveauStyle.put(mxConstants.STYLE_RESIZABLE, 0);
        feuilleStyles.putCellStyle("CLASSE", nouveauStyle);
	}
    
    /**
    * Créer le style du contenu d'une classe (cadre méthodes, cadre attributs)
    */
    private void creerStyleContenuClasse(){
        mxStylesheet feuilleStyles = this.getGraph().getStylesheet();
        Map<String, Object> nouveauStyle = new HashMap<String, Object>();

        nouveauStyle.put(mxConstants.STYLE_SHAPE, mxConstants.SHAPE_RECTANGLE);
        nouveauStyle.put(mxConstants.STYLE_OPACITY, Constantes.OPACITE);
        nouveauStyle.put(mxConstants.STYLE_FILLCOLOR, Constantes.COULEUR_FOND);
        nouveauStyle.put(mxConstants.STYLE_MOVABLE, mxConstants.NONE);
        nouveauStyle.put(mxConstants.STYLE_RESIZABLE, mxConstants.NONE);
        nouveauStyle.put(mxConstants.STYLE_DELETABLE, mxConstants.NONE);
        nouveauStyle.put(mxConstants.STYLE_ALIGN, mxConstants.ALIGN_LEFT);
        nouveauStyle.put(mxConstants.STYLE_FONTCOLOR, Constantes.COULEUR_TEXTE);
        feuilleStyles.putCellStyle("CONTENUCLASSE", nouveauStyle);
    }


    private String genererChaineMethodes(){
       String retour = new String();

       for(int i=0; i < this.methodes.taille(); i++){
		   retour += this.methodes.get(i);
       }

       return retour;
    }

    private String genererChaineAttributs(){
       String retour = "";

       for(int i=0; i < this.attributs.taille(); i++) {
		   retour += this.attributs.get(i).toString();
       }

       return retour;
    }

    /**
    * Constructeur d'un élément 'classe'
    * @param p_graph Le graphe auquel sera ajouter la classe
    * @param p_texte Le texte associé à la classe (son nom)
    */
    public Classe(mxGraph p_graph, Diagramme p_diagramme, String p_texte){
        super(p_graph, p_diagramme, p_texte, new Dimension(125,150));

        this.attributs = new Liste<Attribut>();
        this.methodes = new Liste<Methode>();
		this.abstraite = false;
		this.constante = false;
    }

    /**
    * Ajoute la méthode passée en paramètre à la liste des méthodes
    * @param p_nouvelleMethode
    * @return La méthode ajoutée
    *
    * @see Methode
    */
    public final Methode ajouterMethode(Methode p_nouvelleMethode) {
            this.methodes.ajouterElement(p_nouvelleMethode);
            return(p_nouvelleMethode);
    }

    /**
    * Ajoue un attribut à la liste d'attributs de la classe
    * @param p_nouvelAttribut Le nouvel attribut à ajouter à la classe
    * @return Le nouvel attribut ajouté
    *
    * @see Attribut
    */
    public final Attribut ajouterAttribut(Attribut p_nouvelAttribut) {
        this.attributs.ajouterElement(p_nouvelAttribut);
		return(p_nouvelAttribut);
    }

    /*
     * Guetteurs
     */
    /**
     * Retourne vrai si la classe est constante, faux sinon.
     * @return Classe constante ?
     */
    public boolean estConstante() {
        return (this.constante);
    }

    /**
     * Retourne vrai si la classe est abstraite, faux sinon.
     * @return si la classe est abstraite ou non.
     */
    public boolean estAbstraite() {
        return (this.abstraite);
    }

    /**
     * Retourne la liste des attributs de la classe
     * @return Liste des attributs de la classe
     * @see Attribut
     */
    public Liste<Attribut> getAttributs() {
        return (this.attributs);
    }

    /**
     * Retourne la liste des méthodes de la classe
     * @return Liste des méthodes de la classe
     * @see Methode
     */
    public Liste<Methode> getMethodes() {
        return (this.methodes);
    }

	/*
	 * Setters
	 */
    /**
     * Modifie la constance de la classe
     * @param p_constante Classe constante ?
     */
    public void setConstante(boolean p_constante) {
        this.constante = p_constante;
    }

    /**
     * Modifie l'abstraction de la classe
     * @param p_abstraite Classe abstraite ?
     */
    public void setAbstraite(boolean p_abstraite) {
        this.abstraite = p_abstraite;
    }

    /**
     * Remplace la liste des attributs de la classe
     * @param p_attributs La nouvelle liste d'attributs
     * @see Attribut
     */
    public void setAttributs(Liste<Attribut> p_attributs) {
        this.attributs = p_attributs;
    }

    /**
     * Remlpace la liste des méthodes de la classe
     * @param p_methodes La nouvelle liste de méthodes
     * @see Methode
     */
    public void setMethodes(Liste<Methode> p_methodes) {
        this.methodes = p_methodes;
    }

    /**
     * Crée la représentation graphique de la classe
     */
    @Override
    public final void creer() {
        
        mxCell celluleAttributs;
        mxCell celluleMethodes;
        this.creerStyleClasse();
        this.creerStyleContenuClasse();

        super.setCellule((mxCell) super.getGraph().insertVertex( null, null, super.getTexte(), 350, 350,
                         super.getDimension().getWidth(), super.getDimension().getHeight(), "CLASSE"));

        celluleAttributs = (mxCell) super.getGraph().insertVertex( super.getCellule(), null,
                                this.genererChaineAttributs(), 0, 0, super.getDimension().getWidth(), 60,
                                "CONTENUCLASSE");

        celluleMethodes = (mxCell) super.getGraph().insertVertex( super.getCellule(), null,
                               this.genererChaineMethodes(), 0, 100, super.getDimension().getWidth(), 60,
                               "CONTENUCLASSE");

        celluleAttributs.setConnectable(false);
        celluleMethodes.setConnectable(false);

        super.getDiagramme().getElementsGraphiques().add(this);
    }
}

