package ihm.menu;

import eltGraphique.eltModelisation.Classe;
import ihm.FenetreDemo;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
* Menu contenant le tableau avec les données
*/
public class MenuDroite extends Menu {   
    private JScrollPane panneauTableau;
    private JTable tableauAttributs;
    private JLabel typeDiagrammeLabel;
    private JLabel attributsLabel;
    private JLabel methodesLabel;
    
    private void parametrerMenuDroite(){
    }
    
    public MenuDroite (Dimension p_dimension, FenetreDemo p_fenetre){
        super(p_dimension, p_fenetre);
    }

    public void ajouterLabelDiagramme() {
        this.typeDiagrammeLabel = new JLabel(super.getFenetre().getPanneauGraph().getDiagramme().toString());
        super.add(this.typeDiagrammeLabel);
        super.updateUI();
    }

    public void afficherTableauClasse(Classe classe){
        /* Si un tableau est déjà affiché, on le supprime pour en mettre un neuf */
        if(this.tableauAttributs != null){
            super.remove(1);
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

    @Override
    public void ajouterObjetsGraphiques() {
    }
}

