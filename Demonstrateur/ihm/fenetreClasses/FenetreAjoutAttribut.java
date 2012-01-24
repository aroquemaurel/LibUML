package ihm.fenetreClasses;

import eltGraphique.eltModelisation.Classe;
import evenements.btn.BtnAnnulerAjoutAttribut;
import evenements.btn.BtnValiderAjoutAttribut;
import ihm.FenetreDemo;
import java.awt.Dimension;
import javax.swing.*;

/**
 * Créer une fenetre permettant d'ajouter des attributs
 */
public class FenetreAjoutAttribut extends FenetreDialog {
    private Classe classe;
    
    private JPanel panneauPrincipal;
    
    private JLabel nomAttributLabel;
    private JTextField nomAttributChampTexte;
    private JPanel panneauNomAttribut;
    
    private JLabel typeLabel;
    private JTextField typeChampTexte;
    private JPanel panneauType;
    
    private JLabel visibiliteLabel;
    private JComboBox visibiliteListe;
    private JPanel panneauVisibilite;
    
    private JLabel deClasseLabel;
    private JLabel espaceDeClasseLabel;
    private JCheckBox deClasseCheckBox;
    private JPanel panneauDeClasse;  

    private JLabel constantLabel;
    private JLabel espaceConstantLabel;
    private JCheckBox constantCheckBox;
    private JPanel panneauConstant;  
    
    private BtnValiderAjoutAttribut boutonValider;
    private BtnAnnulerAjoutAttribut boutonAnnuler;
    
    /**
     * Paramètre la boite de dialogue
     */
    @Override
   protected void parametrerBoiteDialogue(){
        this.setSize(500, 250);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setModal(true);
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        
        this.nomAttributChampTexte.setPreferredSize(new Dimension(250,20));
        this.typeChampTexte.setPreferredSize(new Dimension(250,20));
        this.visibiliteListe.setPreferredSize(new Dimension(250,20));
     
        
        this.add(this.panneauPrincipal);       
    }
   
   /**
    * Ajoute les éléments à la boite de dialogue
    */
    protected void ajouterElements(){      
        this.panneauPrincipal.add(this.panneauNomAttribut);
        this.panneauPrincipal.add(this.panneauType);
        this.panneauPrincipal.add(this.panneauVisibilite);
        this.panneauPrincipal.add(this.panneauConstant);
        this.panneauPrincipal.add(this.panneauDeClasse);
                
        this.panneauPrincipal.add(this.boutonValider);
        this.panneauPrincipal.add(this.boutonAnnuler);
        
        this.panneauNomAttribut.add(nomAttributLabel);
        this.panneauNomAttribut.add(nomAttributChampTexte);
        
        this.panneauType.add(typeLabel);
        this.panneauType.add(typeChampTexte);
        
        this.panneauVisibilite.add(visibiliteLabel);
        this.panneauVisibilite.add(visibiliteListe);
             
        this.panneauDeClasse.add(this.deClasseLabel);
        this.panneauDeClasse.add(this.deClasseCheckBox);
        this.panneauDeClasse.add(this.espaceDeClasseLabel);
        
        this.panneauConstant.add(this.constantLabel);
        this.panneauConstant.add(this.constantCheckBox);
        this.panneauConstant.add(this.espaceConstantLabel);
    }
    
    /**
     * Construit la fenetre d'ajout d'attribut
     * @param p_fenetre La fenetre principale
     * @param p_texte Le titre de la fenetre
     * @param p_classe La classe à laquelle on veut ajouter des attributs
     */
   public FenetreAjoutAttribut(FenetreDemo p_fenetre, String p_texte, Classe p_classe){
        super(p_fenetre, p_texte);
        this.panneauPrincipal = new JPanel();
        this.nomAttributChampTexte = new JTextField();
        this.nomAttributLabel = new JLabel("Nom de l'attribut ");
        this.panneauNomAttribut = new JPanel();
        
        this.typeChampTexte = new JTextField();
        this.typeLabel = new JLabel("Type                       ");
        this.panneauType = new JPanel();
        
        this.visibiliteListe = new JComboBox();
        this.visibiliteListe.addItem("Package");
        this.visibiliteListe.addItem("Private");
        this.visibiliteListe.addItem("Protected");
        this.visibiliteListe.addItem("Public");
        this.visibiliteLabel = new JLabel("Visibilité                ");
        this.panneauVisibilite = new JPanel();
        
        this.constantCheckBox = new JCheckBox();
        this.constantLabel = new JLabel("Est constant         ");
        this.espaceConstantLabel = new JLabel("                                                         ");
        this.panneauConstant = new JPanel();    

        this.deClasseCheckBox = new JCheckBox();
        this.deClasseLabel = new JLabel("   Est de classe        ");
        this.espaceDeClasseLabel = new JLabel("                                                            ");
        this.panneauDeClasse = new JPanel();    

        
        this.boutonValider = new BtnValiderAjoutAttribut(this, p_classe);
        this.boutonAnnuler = new BtnAnnulerAjoutAttribut(this);
        
        this.parametrerBoiteDialogue();
        this.ajouterElements();
        
        this.classe = p_classe;
    }
   
   /**
    * Retourne si l'attribut est constant
    * @return Vrai si l'attribut est constant, faux sinon
    */
    public JCheckBox getConstantCheckBox() {
        return constantCheckBox;
    }
    
    /**
     * Retourne si l'attribut est static ou non
     * @return Vrai si l'attribut est de Classe, faux sinon
     */
    public JCheckBox getDeClasseCheckBox() {
        return deClasseCheckBox;
    }

    /**
     * Retourne le nom de l'attribut
     * @return Le nom de l'attribut
     */
    public JTextField getNomAttributChampTexte() {
        return nomAttributChampTexte;
    }

    /**
     * Retourne le type de l'attribut
     * @return Le type de l'attribut
     */
    public JTextField getTypeChampTexte() {
        return typeChampTexte;
    }

    /**
     * Retourne la visibilité de l'attribut
     * @return La liste de la visibilité de l'attribut
     */
    public JComboBox getVisibiliteListe() {
        return visibiliteListe;
    }
}
