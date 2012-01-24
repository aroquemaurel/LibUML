package ihm.menu;

import eltGraphique.eltModelisation.Classe;
import ihm.FenetreDemo;
import java.awt.Dimension;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
* Menu contenant le tableau avec les données
*/
public class MenuDroite extends Menu {   
    private JScrollPane panneauTableau;
    private JTable tableauAttributs;
    
    private void parametrerMenuDroite(){
    }
    
    public MenuDroite (Dimension p_dimension, FenetreDemo p_fenetre){
        super(p_dimension, p_fenetre);
/*        this.listeDeroulanteDiagrammes = new JComboBox();
        this.labelListeDeroulante = new JLabel("Type de contrainte: ");
        this.evenementListeDiagramme = new EvenementListeDiagramme(this.listeDeroulanteDiagrammes);
        this.parametrerMenuDroite();
  */  }

    /*  */
    @Override
    public void ajouterObjetsGraphiques() {
      /*  super.add(labelListeDeroulante);
        super.add(listeDeroulanteDiagrammes);
        
        this.listeDeroulanteDiagrammes.addItem("Aucune contrainte");
        this.listeDeroulanteDiagrammes.addItem("Diagramme de cas d'utilisation");
        this.listeDeroulanteDiagrammes.addItem("Diagramme de classe");
        this.listeDeroulanteDiagrammes.addItem("Diagramme de séquence");
        
        this.listeDeroulanteDiagrammes.addActionListener(this.evenementListeDiagramme);
    */
    }

    public void afficherTableauClasse(Classe classe){
        /* Si un tableau est déjà affiché, on le supprime pour en mettre un neuf */
        if(this.tableauAttributs != null){
            super.remove(0);
        }
        
        /* On remplit le taleau des attributs ! */
        Object[][] donnees = new Object[classe.getAttributs().size()][5];
        for(int i = 0 ; i < classe.getAttributs().size() ; i++){
            donnees[i][0] = classe.getAttributs().get(i).getVisibilite();
            donnees[i][1] = classe.getAttributs().get(i).getType();
            donnees[i][2] = classe.getAttributs().get(i).getNom();
            donnees[i][3] = classe.getAttributs().get(i).estDeClasse();
            donnees[i][4] = classe.getAttributs().get(i).estConstante();
        }
        
        //Les titres des colonnes
        String  title[] = {"Visibilité", "Type", "Nom", "Static", "Final"};

        this.tableauAttributs = new JTable(donnees, title);
        this.tableauAttributs.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        this.panneauTableau = new JScrollPane(tableauAttributs);
        
        super.add(new JScrollPane(tableauAttributs));
        super.updateUI(); // On met à jour le panneau
    }
}

