package ihm.fenetreClasses;

import eltGraphique.eltModelisation.Classe;
import evenements.btn.BtnAnnulerAjoutMethode;
import evenements.btn.BtnValiderAjoutMethode;
import ihm.FenetreDemo;
import java.awt.Dimension;
import javax.swing.*;

/**
 * Affiche une fenetre pour pouvoir entrer une nouvelle méthode
 */
public class FenetreAjoutMethode extends FenetreDialog {  
    private JPanel panneauPrincipal;
    
    private JLabel nomMethodeLabel;
    private JTextField nomMethodeChampTexte;
    private JPanel panneauNomMethode;
    
    private JLabel typeRetourLabel;
    private JTextField typeRetourChampTexte;
    private JPanel panneauTypeRetour;
    
    private JLabel visibiliteLabel;
    private JComboBox visibiliteListe;
    private JPanel panneauVisibilite;
    
    /* 
     * Les paramètres 
     */
    /*paramètre 1 */
    private JLabel nomParametre1Label;
    private JTextField nomParametre1ChampTexte;
    private JPanel panneauNomParametre1;
    private JLabel typeParametre1Label;
    private JTextField typeParametre1ChampTexte;
    private JPanel panneauTypeParametre1;  
    private JPanel panneauConstantParametre1;  
    private JLabel constantParametre1Label;
    private JLabel espaceParametre1Label;
    private JCheckBox constantParametre1CheckBox;
    
    /* paramètre 2 */
    private JLabel nomParametre2Label;
    private JTextField nomParametre2ChampTexte;
    private JPanel panneauNomParametre2;
    private JLabel typeParametre2Label;
    private JTextField typeParametre2ChampTexte;
    private JPanel panneauTypeParametre2;  
    private JPanel panneauConstantParametre2;  
    private JLabel constantParametre2Label;
    private JLabel espaceParametre2Label;
    private JCheckBox constantParametre2CheckBox;
    
    /* paramètre 3 */
    private JLabel nomParametre3Label;
    private JTextField nomParametre3ChampTexte;
    private JPanel panneauNomParametre3;
    private JLabel typeParametre3Label;
    private JTextField typeParametre3ChampTexte;
    private JPanel panneauTypeParametre3;  
    private JPanel panneauConstantParametre3;  
    private JLabel constantParametre3Label;
    private JLabel espaceParametre3Label;
    private JCheckBox constantParametre3CheckBox;
    
    /* 
     * boutons 
     */
    private BtnValiderAjoutMethode boutonValider;
    private BtnAnnulerAjoutMethode boutonAnnuler;
    
    /**
     * Paramètre la fenetre
     */
    @Override
   protected final void parametrerBoiteDialogue(){
        this.setSize(500, 600);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setModal(true);
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        
        this.nomMethodeChampTexte.setPreferredSize(new Dimension(250,20));
        this.typeRetourChampTexte.setPreferredSize(new Dimension(250,20));
        this.visibiliteListe.setPreferredSize(new Dimension(250,20));
        this.nomParametre1ChampTexte.setPreferredSize(new Dimension(250,20));        
        this.typeParametre1ChampTexte.setPreferredSize(new Dimension(250,20));        
        this.nomParametre2ChampTexte.setPreferredSize(new Dimension(250,20));  
        this.typeParametre2ChampTexte.setPreferredSize(new Dimension(250,20));            
        this.nomParametre3ChampTexte.setPreferredSize(new Dimension(250,20));     
        this.typeParametre3ChampTexte.setPreferredSize(new Dimension(250,20));            
        
        this.add(this.panneauPrincipal);       
    }
   
    /**
     * Ajoute les différents éléments dans la fenêtre
     */
    @Override
    protected final void ajouterElements(){      
        this.panneauPrincipal.add(this.panneauNomMethode);
        this.panneauPrincipal.add(this.panneauTypeRetour);
        this.panneauPrincipal.add(this.panneauVisibilite);
        this.panneauPrincipal.add(this.panneauNomParametre1);
        this.panneauPrincipal.add(this.panneauTypeParametre1);
        this.panneauPrincipal.add(this.panneauConstantParametre1);
        this.panneauPrincipal.add(this.panneauNomParametre2);
        this.panneauPrincipal.add(this.panneauTypeParametre2);
        this.panneauPrincipal.add(this.panneauConstantParametre2);        
        this.panneauPrincipal.add(this.panneauNomParametre3);
        this.panneauPrincipal.add(this.panneauTypeParametre3);
        this.panneauPrincipal.add(this.panneauConstantParametre3);        

        this.panneauPrincipal.add(this.boutonValider);
        this.panneauPrincipal.add(this.boutonAnnuler);
        
        this.panneauNomMethode.add(nomMethodeLabel);
        this.panneauNomMethode.add(nomMethodeChampTexte);
        
        this.panneauTypeRetour.add(typeRetourLabel);
        this.panneauTypeRetour.add(typeRetourChampTexte);
        
        this.panneauVisibilite.add(visibiliteLabel);
        this.panneauVisibilite.add(visibiliteListe);
        
        this.panneauNomParametre1.add(this.nomParametre1Label);
        this.panneauNomParametre1.add(this.nomParametre1ChampTexte);
        this.panneauTypeParametre1.add(this.typeParametre1Label);
        this.panneauTypeParametre1.add(this.typeParametre1ChampTexte);
        this.panneauConstantParametre1.add(this.constantParametre1Label);
        this.panneauConstantParametre1.add(this.constantParametre1CheckBox);
        this.panneauConstantParametre1.add(this.espaceParametre1Label);
        
        this.panneauNomParametre2.add(this.nomParametre2Label);
        this.panneauNomParametre2.add(this.nomParametre2ChampTexte);
        this.panneauTypeParametre2.add(this.typeParametre2Label);
        this.panneauTypeParametre2.add(this.typeParametre2ChampTexte);
        this.panneauConstantParametre2.add(this.constantParametre2Label);
        this.panneauConstantParametre2.add(this.constantParametre2CheckBox);
        this.panneauConstantParametre2.add(this.espaceParametre2Label);
        
        this.panneauNomParametre3.add(this.nomParametre3Label);
        this.panneauNomParametre3.add(this.nomParametre3ChampTexte);
        this.panneauTypeParametre3.add(this.typeParametre3Label);
        this.panneauTypeParametre3.add(this.typeParametre3ChampTexte);
        this.panneauConstantParametre3.add(this.constantParametre3Label);
        this.panneauConstantParametre3.add(this.constantParametre3CheckBox);
        this.panneauConstantParametre3.add(this.espaceParametre3Label);

    }
    
    /**
     * Construit la fenêtre permettant d'ajouter la méthode. Instancie tous les attributs
     * @param p_fenetre La fenêtre principale, fenetre où s'affiche la fenetre d'ajout de méthode
     * @param p_texte Le titre de la fenetre
     * @param p_classe La classe à qui on veut ajouter une méthode
     */
   public FenetreAjoutMethode(FenetreDemo p_fenetre, String p_texte, Classe p_classe){
        super(p_fenetre, p_texte);
        this.panneauPrincipal = new JPanel();
        this.nomMethodeChampTexte = new JTextField();
        this.nomMethodeLabel = new JLabel("Nom de la méthode ");
        this.panneauNomMethode = new JPanel();
        
        this.typeRetourChampTexte = new JTextField();
        this.typeRetourLabel = new JLabel("Type de retour         ");
        this.panneauTypeRetour = new JPanel();
        
        this.visibiliteListe = new JComboBox();
        this.visibiliteListe.addItem("Package");
        this.visibiliteListe.addItem("Private");
        this.visibiliteListe.addItem("Protected");
        this.visibiliteListe.addItem("Public");
        this.visibiliteLabel = new JLabel("Visibilité                    ");
        this.panneauVisibilite = new JPanel();
        
        this.nomParametre1ChampTexte = new JTextField();
        this.nomParametre1Label = new JLabel("Nom paramètre 1    ");
        this.panneauNomParametre1 = new JPanel();
        this.typeParametre1ChampTexte = new JTextField();
        this.typeParametre1Label = new JLabel("Type paramètre 1    ");
        this.panneauTypeParametre1 = new JPanel();        
        this.constantParametre1CheckBox = new JCheckBox();
        this.constantParametre1Label = new JLabel("Est constant paramètre 1    ");
        this.espaceParametre1Label = new JLabel("                                          ");
        this.panneauConstantParametre1 = new JPanel();    
        
        this.nomParametre2ChampTexte = new JTextField();
        this.nomParametre2Label = new JLabel("Nom paramètre 2    ");
        this.panneauNomParametre2 = new JPanel();
        this.typeParametre2ChampTexte = new JTextField();
        this.typeParametre2Label = new JLabel("Type paramètre 2    ");
        this.panneauTypeParametre2 = new JPanel();        
        this.constantParametre2CheckBox = new JCheckBox();
        this.constantParametre2Label = new JLabel("Est constant paramètre 2    ");
        this.espaceParametre2Label = new JLabel("                                          ");
        this.panneauConstantParametre2 = new JPanel();    

        this.nomParametre3ChampTexte = new JTextField();
        this.nomParametre3Label = new JLabel("Nom paramètre 3    ");
        this.panneauNomParametre3 = new JPanel();
        this.typeParametre3ChampTexte = new JTextField();
        this.typeParametre3Label = new JLabel("Type paramètre 3    ");
        this.panneauTypeParametre3 = new JPanel();        
        this.constantParametre3CheckBox = new JCheckBox();
        this.constantParametre3Label = new JLabel("Est constant paramètre 3    ");
        this.espaceParametre3Label = new JLabel("                                          ");
        this.panneauConstantParametre3 = new JPanel();    
        
        this.boutonValider = new BtnValiderAjoutMethode(this, p_classe);
        this.boutonAnnuler = new BtnAnnulerAjoutMethode(this);
               
        this.parametrerBoiteDialogue();
        this.ajouterElements();
    }

   /**
     * Retourne si le paramètre 1 est constant ou non
     * @return Vrai si le paramètre est constant, faux sinon
    */
    public JCheckBox getConstantParametre1CheckBox() {
        return constantParametre1CheckBox;
    }

    /**
     * Retourne si le paramètre 2 est constant ou non
     * @return Vrai si le paramètre est constant, faux sinon
     */
    public JCheckBox getConstantParametre2CheckBox() {
        return constantParametre2CheckBox;
    }

    /**
     * Retourne si le paramètre 3 est constant ou non
     * @return Vrai si le paramètre est constant, faux sinon
     */
    public JCheckBox getConstantParametre3CheckBox() {
        return constantParametre3CheckBox;
    }

    /**
     * Retourne le nom de la méthode
     * @return Le nom de la méthode
     */
    public JTextField getNomMethodeChampTexte() {
        return nomMethodeChampTexte;
    }

    /**
     * Retourne le nom du paramètre 1
     * @return Le nom du paramètre 1
     */
    public JTextField getNomParametre1ChampTexte() {
        return nomParametre1ChampTexte;
    }

    /**
     * Retourne le nom du paramètre 2
     * @return Le nom du paramètre 2
     */
    public JTextField getNomParametre2ChampTexte() {
        return nomParametre2ChampTexte;
    }

    /**
     * Retourne le nom du paramètre 3
     * @return Le nom du paramètre 3
     */
    public JTextField getNomParametre3ChampTexte() {
        return nomParametre3ChampTexte;
    }

    /**
     * Retourne le type de paramètre 1
     * @return Le type de paramètre 1
     */
    public JTextField getTypeParametre1ChampTexte() {
        return typeParametre1ChampTexte;
    }

    /**
     * Retourne le type de paramètre 2
     * @return Le type de de paramètre 2
     */
    public JTextField getTypeParametre2ChampTexte() {
        return typeParametre2ChampTexte;
    }

    /**
     * Retourne le type de paramètre 3
     * @return Le type de paramètre 3
     */
    public JTextField getTypeParametre3ChampTexte() {
        return typeParametre3ChampTexte;
    }

    /**
     * Retour le type de retour de la méthode
     * @return Le type de retour
     */
    public JTextField getTypeRetourChampTexte() {
        return typeRetourChampTexte;
    }
    
    /**
     * Retour la visibilité de la méthode
     * @return La liste de visibilité
     */
    public JComboBox getVisibiliteListe() {
        return visibiliteListe;
    }
    
    
}
