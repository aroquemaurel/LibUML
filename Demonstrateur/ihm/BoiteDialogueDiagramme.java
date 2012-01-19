package ihm;

import evenements.EvenementChoixDiagramme;
import java.awt.Dimension;
import javax.swing.*;

/**
 *
 */
public class BoiteDialogueDiagramme extends JDialog {
    private JPanel panneau;
    private JComboBox listeDeroulanteDiagrammes;
    private JLabel labelListeDeroulante;
    private JButton boutonValider;
    private EvenementChoixDiagramme evenementBoutonValider;
    
    private void parametrerBoiteDialogue(){
        this.setSize(330, 100);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.boutonValider.setPreferredSize(new Dimension(100,20));
        this.listeDeroulanteDiagrammes.setPreferredSize(new Dimension(250, 20));
    }
    
    private void ajouterObjetsGraphiques(){
        this.add(this.panneau);
        this.panneau.add(this.labelListeDeroulante);
        this.panneau.add(this.listeDeroulanteDiagrammes);
        this.panneau.add(this.boutonValider);
        this.boutonValider.addMouseListener(this.evenementBoutonValider);
        this.listeDeroulanteDiagrammes.addItem("Aucune contrainte");
        this.listeDeroulanteDiagrammes.addItem("Diagramme de cas d'utilisation");
        this.listeDeroulanteDiagrammes.addItem("Diagramme de classe");
        this.listeDeroulanteDiagrammes.addItem("Diagramme de séquence");
    }
    
    public BoiteDialogueDiagramme(FenetreDemo p_fenetre){
        super(p_fenetre, "Nouveau diagramme", true);
        this.panneau = new JPanel();
        this.labelListeDeroulante = new JLabel("Choisir le type de diagramme");
        this.listeDeroulanteDiagrammes = new JComboBox();
        this.boutonValider = new JButton("Valider");
        this.evenementBoutonValider = new EvenementChoixDiagramme(p_fenetre);
        this.ajouterObjetsGraphiques();
        this.parametrerBoiteDialogue();
    }
    public void afficherBoiteDialogue(){
        this.setVisible(true);        
    }
    
    public JComboBox getListe(){
        return (this.listeDeroulanteDiagrammes);
    }

}
