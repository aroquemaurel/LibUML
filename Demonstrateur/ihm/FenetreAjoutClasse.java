package ihm;

import evenements.btn.BtnAnnulerAjoutMethode;
import evenements.btn.BtnValiderAjoutMethode;
import java.awt.Dimension;
import javax.swing.*;

/**
 *
 */
public class FenetreAjoutClasse extends JDialog {
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
    
    private BtnValiderAjoutMethode boutonValider;
    private BtnAnnulerAjoutMethode boutonAnnuler;
    
   private void parametrerBoiteDialogue(){
        this.setSize(500, 600);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setModal(true);
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        
        this.nomMethodeChampTexte.setPreferredSize(new Dimension(250,20));
        this.typeRetourChampTexte.setPreferredSize(new Dimension(250,20));
        this.visibiliteListe.setPreferredSize(new Dimension(250,20));
        this.add(this.panneauPrincipal);       
    }
    private void ajouterElements(){      
        this.panneauPrincipal.add(this.panneauNomMethode);
        this.panneauPrincipal.add(this.panneauTypeRetour);
        this.panneauPrincipal.add(this.panneauVisibilite);
        this.panneauPrincipal.add(this.boutonValider);
        this.panneauPrincipal.add(this.boutonAnnuler);
        
        this.panneauNomMethode.add(nomMethodeLabel);
        this.panneauNomMethode.add(nomMethodeChampTexte);
        
        this.panneauTypeRetour.add(typeRetourLabel);
        this.panneauTypeRetour.add(typeRetourChampTexte);
        
        this.panneauVisibilite.add(visibiliteLabel);
        this.panneauVisibilite.add(visibiliteListe);
    }
    
   public FenetreAjoutClasse(FenetreDemo p_fenetre, String p_texte){
        super(p_fenetre, p_texte);
        this.panneauPrincipal = new JPanel();
        this.nomMethodeChampTexte = new JTextField();
        this.nomMethodeLabel = new JLabel("Nom de la méthode");
        this.panneauNomMethode = new JPanel();
        
        this.typeRetourChampTexte = new JTextField();
        this.typeRetourLabel = new JLabel("Type de retour        ");
        this.panneauTypeRetour = new JPanel();
        
        this.visibiliteListe = new JComboBox();
        this.visibiliteListe.addItem("Package");
        this.visibiliteListe.addItem("Private");
        this.visibiliteListe.addItem("Protected");
        this.visibiliteListe.addItem("Public");
        this.visibiliteLabel = new JLabel("Visibilité                   ");
        this.panneauVisibilite = new JPanel();
        
        this.boutonValider = new BtnValiderAjoutMethode(this);
        this.boutonAnnuler = new BtnAnnulerAjoutMethode(this);
        
        this.parametrerBoiteDialogue();
        this.ajouterElements();
    }
   
    public void afficherFenetre(){
        this.setVisible(true);
    }   
}
