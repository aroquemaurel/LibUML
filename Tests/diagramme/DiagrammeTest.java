package diagramme;

import com.mxgraph.view.mxGraph;
import eltGraphique.*;
import eltGraphique.classe.Classe;
import eltGraphique.ligne.Lien;
import eltGraphique.ligne.TypeLien;
import java.util.List;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import util.Liste;

/**
 * Classe de test unitaires de la classe <b>Diagramme</b>.
 * @author Marie-Ly
 * @author geoffroy
 */
public class DiagrammeTest {
    
    private Diagramme monDiagramme;
    
    @Before
    public void setUp() {
        this.monDiagramme = new Diagramme();
    }
    
    @After
    public void tearDown() {
        this.monDiagramme = null;
    }
    
    @Test
    public void testConstructeurDiagramme(){
        assertTrue(this.monDiagramme.getElementsGraphiques() instanceof List);
    }
    
    @Test
    public void testLienAutoriseAssociationActeurActifCasUtilisation () {
        assertTrue(this.monDiagramme.lienAutorise(
                new ActeurActif(new mxGraph(),new Diagramme(), new String()), 
                new CasUtilisation(new mxGraph(), new Diagramme(), new String()),
                TypeLien.ASSOCIATION));
    }
    @Test
    public void testLienAutoriseAssociationCasUtilisationActeurActif () {
        assertTrue(this.monDiagramme.lienAutorise(
                new CasUtilisation( new mxGraph(),new Diagramme(), new String()),
                new ActeurActif(new mxGraph(),new Diagramme(), new String()),
                TypeLien.ASSOCIATION));
    }
    
    @Test
    public void testLienAutoriseAssociationCasUtilisationCasUtilisation () {
        assertTrue(this.monDiagramme.lienAutorise(
                new CasUtilisation(new mxGraph(), new Diagramme(), new String()),
                new CasUtilisation(new mxGraph(), new Diagramme(), new String()),
                TypeLien.ASSOCIATION));
    }
    
    @Test
    public void testLienAutoriseAssociationActeurActifActeurActif () {
        assertTrue(this.monDiagramme.lienAutorise(
                new ActeurActif(new mxGraph(),new Diagramme(), new String()),
                new ActeurActif(new mxGraph(),new Diagramme(), new String()),
                TypeLien.ASSOCIATION));
    }

    @Test
    public void testLienAutoriseAssociationActeurPassifActeurPassif () {
        assertTrue(this.monDiagramme.lienAutorise(
                new ActeurPassif(new mxGraph(),new Diagramme(), new String()), 
                new ActeurPassif(new mxGraph(), new Diagramme(),new String()),
                TypeLien.ASSOCIATION));
    }
    @Test
    public void testLienAutoriseGeneralisationCasUtilisationCasUtilisation () {
        assertTrue(this.monDiagramme.lienAutorise(
                new CasUtilisation(new mxGraph(), new Diagramme(), new String()),
                new CasUtilisation(new mxGraph(), new Diagramme(), new String()),
                TypeLien.GENERALISATION));
    }
    
    @Test
    public void testLienAutoriseGeneralisationActeurActifActeurActif () {
        assertTrue(this.monDiagramme.lienAutorise(
                new ActeurActif(new mxGraph(), new Diagramme(), new String()),
                new ActeurActif(new mxGraph(), new Diagramme(), new String()),
                TypeLien.GENERALISATION));
    }

    @Test
    public void testLienAutoriseDependanceCasUtilisationCasUtilisation () {
        assertTrue(this.monDiagramme.lienAutorise(
                new CasUtilisation(new mxGraph(), new Diagramme(), new String()),
                new CasUtilisation(new mxGraph(), new Diagramme(), new String()),
                TypeLien.DEPENDANCE));
    }
    
     @Test
    public void testLienAutoriseDepencanceActeurActifActeurActif () {
        assertTrue(this.monDiagramme.lienAutorise(
                new ActeurActif(new mxGraph(),new Diagramme(), new String()),
                new ActeurActif(new mxGraph(),new Diagramme(), new String()),
                TypeLien.DEPENDANCE));
    }  
     
    @Test
    public void testLienAutoriseCompositionClasseClasse () {
        assertTrue(this.monDiagramme.lienAutorise(
                new Classe(new mxGraph(), new Diagramme(), new String()), 
                new Classe(new mxGraph(), new Diagramme(),new String()),
                TypeLien.COMPOSITION));    
    }
    
    @Test
    public void testLienAutoriseCompositionClasseLien () {
        assertTrue(this.monDiagramme.lienAutorise(
                new Classe(new mxGraph(), new Diagramme(), new String()), 
                new Lien( null,null, new mxGraph(), new Diagramme(), null),
                TypeLien.COMPOSITION));    
    }
    
    @Test
    public void testLienAutoriseCompositionLienClasse () {
        assertTrue(this.monDiagramme.lienAutorise(
                new Lien( null,null, new mxGraph(), new Diagramme(), null),
                new Classe(new mxGraph(), new Diagramme(),new String()),
                TypeLien.COMPOSITION));    
    }
    
    @Test
    public void testLienAutoriseCompositionLienLien () {
        assertTrue(this.monDiagramme.lienAutorise(
                new Lien( null,null, new mxGraph(), new Diagramme(), null),
                new Lien( null,null, new mxGraph(), new Diagramme(), null),
                TypeLien.COMPOSITION));    
    }
    
    @Test
    public void testLienAutoriseAssociationClasseClasse () {
        assertTrue(this.monDiagramme.lienAutorise(
                new Classe(new mxGraph(), new Diagramme(), new String()), 
                new Classe(new mxGraph(), new Diagramme(),new String()),
                TypeLien.ASSOCIATION));    
    }
    
    @Test
    public void testLienAutoriseAssociationClasseLien () {
        assertTrue(this.monDiagramme.lienAutorise(
                new Classe(new mxGraph(), new Diagramme(), new String()), 
                new Lien( null,null, new mxGraph(), new Diagramme(), null),
                TypeLien.ASSOCIATION));    
    }
    @Test
    public void testLienAutoriseAssociationLienClasse () {
        assertTrue(this.monDiagramme.lienAutorise(
                new Lien( null,null, new mxGraph(), new Diagramme(), null),
                new Classe(new mxGraph(), new Diagramme(),new String()),
                TypeLien.ASSOCIATION));    
    }
    
    @Test
    public void testLienAutoriseAssociationLienLien () {
        assertTrue(this.monDiagramme.lienAutorise(
                new Lien( null,null, new mxGraph(), new Diagramme(), null),
                new Lien( null,null, new mxGraph(), new Diagramme(), null),
                TypeLien.ASSOCIATION));    
    }
    
    @Test
    public void testLienAutoriseGeneralisationClasseClasse () {
        assertTrue(this.monDiagramme.lienAutorise(
                new Classe(new mxGraph(), new Diagramme(), new String()), 
                new Classe(new mxGraph(), new Diagramme(),new String()),
                TypeLien.GENERALISATION));    
    }
    
    @Test
    public void testLienAutoriseGeneralisationClasseLien () {
        assertTrue(this.monDiagramme.lienAutorise(
                new Classe(new mxGraph(), new Diagramme(), new String()), 
                new Lien( null,null, new mxGraph(), new Diagramme(), null),
                TypeLien.GENERALISATION));    
    }
    @Test
    public void testLienAutoriseGeneralisationLienClasse () {
        assertTrue(this.monDiagramme.lienAutorise(
                new Lien( null,null, new mxGraph(), new Diagramme(), null),
                new Classe(new mxGraph(), new Diagramme(),new String()),
                TypeLien.GENERALISATION));    
    }
    
    @Test
    public void testLienAutoriseGeneralisationLienLien () {
        assertTrue(this.monDiagramme.lienAutorise(
                new Lien( null,null, new mxGraph(), new Diagramme(), null),
                new Lien( null,null, new mxGraph(), new Diagramme(), null),
                TypeLien.GENERALISATION));    
    }
    
    @Test
    public void testLienAutoriseDependanceClasseClasse () {
        assertTrue(this.monDiagramme.lienAutorise(
                new Classe(new mxGraph(), new Diagramme(), new String()), 
                new Classe(new mxGraph(), new Diagramme(),new String()),
                TypeLien.DEPENDANCE));    
    }
    
    @Test
    public void testLienAutoriseDependanceClasseLien () {
        assertTrue(this.monDiagramme.lienAutorise(
                new Classe(new mxGraph(), new Diagramme(), new String()), 
                new Lien( null,null, new mxGraph(), new Diagramme(), null),
                TypeLien.DEPENDANCE));    
    }
    @Test
    public void testLienAutoriseDependanceLienClasse () {
        assertTrue(this.monDiagramme.lienAutorise(
                new Lien( null,null, new mxGraph(), new Diagramme(), null), 
                new Classe(new mxGraph(), new Diagramme(),new String()),
                TypeLien.DEPENDANCE));    
    }
    
    @Test
    public void testLienAutoriseDependanceLienLien () {
        assertTrue(this.monDiagramme.lienAutorise(
                new Lien( null,null, new mxGraph(), new Diagramme(), null), 
                new Lien( null,null, new mxGraph(), new Diagramme(), null),
                TypeLien.DEPENDANCE));    
    }
    @Test
    public void testLienAutoriseAgregationClasseClasse () {
        assertTrue(this.monDiagramme.lienAutorise(
                new Classe(new mxGraph(), new Diagramme(), new String()), 
                new Classe(new mxGraph(), new Diagramme(),new String()),
                TypeLien.AGREGATION));    
    }
    
    @Test
    public void testLienAutoriseAgregationClasseLien () {
        assertTrue(this.monDiagramme.lienAutorise(
                new Classe(new mxGraph(), new Diagramme(), new String()), 
                new Lien( null,null, new mxGraph(), new Diagramme(), null),
                TypeLien.AGREGATION));    
    }
    
    @Test
    public void testLienAutoriseAgregationLienClasse () {
        assertTrue(this.monDiagramme.lienAutorise(
                new Lien( null,null, new mxGraph(), new Diagramme(), null), 
                new Classe(new mxGraph(), new Diagramme(),new String()),
                TypeLien.AGREGATION));    
    }
    
    @Test
    public void testLienAutoriseAgregationLienLien () {
        assertTrue(this.monDiagramme.lienAutorise(
                new Lien( null,null, new mxGraph(), new Diagramme(), null), 
                new Lien( null,null, new mxGraph(), new Diagramme(), null),
                TypeLien.AGREGATION));    
    }
    
    @Test
    public void testLienAutoriseAssociationTraitementTraitement () {
        assertTrue(this.monDiagramme.lienAutorise(
                new Traitement(null, monDiagramme, null, null, true),
                new Traitement(null, monDiagramme, null, null, true),
                TypeLien.ASSOCIATION));
    }
    
    
    @Test
    public void testLienAutoriseDependanceTraitementTraitement () {
        assertTrue(this.monDiagramme.lienAutorise(
                new Traitement(null, monDiagramme, null, null, true),
                new Traitement(null, monDiagramme, null, null, true),
                TypeLien.DEPENDANCE));
    }
    
    @Test
    public void testLienAutoriseDependanceActeurActifActeurActif () {
        assertTrue(this.monDiagramme.lienAutorise(
                new ActeurActif(new mxGraph(), new Diagramme(), new String()),
                new ActeurActif(new mxGraph(), new Diagramme(), new String()),
                TypeLien.DEPENDANCE));
    }
     
    @Test
    public void testEltAutoriseTraitement () {
        assertTrue(this.monDiagramme.eltAutorise(new Traitement(null, monDiagramme, 
                null, null, true)));
    }
    
    @Test
    public void testEltAutoriseClasse () {
        assertTrue(this.monDiagramme.eltAutorise(
                new Classe(new mxGraph(), new Diagramme(), new String())));    
    }
    
    @Test
    public void testEltAutoriseLien () {
        assertTrue(this.monDiagramme.eltAutorise(
                new Lien(
                new ActeurActif(new mxGraph(), new Diagramme(), new String()),
                new CasUtilisation(new mxGraph(), new Diagramme(), new String()),
                new mxGraph(),
                new Diagramme(), 
                TypeLien.ASSOCIATION)));
    }

    @Test
    public void testEltAutoriseActeurActif () {
        assertTrue(this.monDiagramme.eltAutorise(
                new ActeurActif(new mxGraph(), new Diagramme(), new String())));
    }
    
    @Test
    public void testEltAutoriseActeurPassif () {
        assertTrue(this.monDiagramme.eltAutorise(
                new ActeurPassif(new mxGraph(), new Diagramme(), new String())));
    }
    
    @Test
    public void testEltAutoriseInterface () {
        assertTrue(this.monDiagramme.eltAutorise(
                new Interface(new mxGraph(), new String(),new Diagramme())));
    } 
    
    @Test
    public void testEltAutoriseCasUtilisation () {
        assertTrue(this.monDiagramme.eltAutorise(
                new CasUtilisation(new mxGraph(),new Diagramme(), new String())));
    }    

    @Test
    public void testGetElementsGraphiques(){
        assertEquals(this.monDiagramme.getElementsGraphiques(),new Liste<ElementGraphique>());
    } 
    
    @Test
    public void getElementGraphiqueViaCelluleTraitement(){
        ElementGraphique ElemTeste = new Traitement(new mxGraph(), monDiagramme, null, null, true);
        ElemTeste.creer();
        assertTrue(ElemTeste.getCellule() == ElemTeste);
    }
    
    @Test
    public void getElementGraphiqueViaCelluleClasse(){
        ElementGraphique ElemTeste = new Classe(new mxGraph(), new Diagramme(), new String());
        ElemTeste.creer();
        assertTrue(ElemTeste.getCellule()==ElemTeste);
    }
    
    @Test
    public void getElementGraphiqueViaCelluleLien(){
        ElementGraphique ElemTeste = new Lien(
                new ActeurActif(new mxGraph(), new Diagramme(), new String()),
                new CasUtilisation(new mxGraph(), new Diagramme(), new String()),
                new mxGraph(),
                new Diagramme(), 
                TypeLien.ASSOCIATION);
        ElemTeste.creer();
        assertTrue(ElemTeste.getCellule()==ElemTeste);
    }
    
    @Test
    public void getElementGraphiqueViaCelluleActeurActif(){
        ElementGraphique ElemTeste = new ActeurActif(new mxGraph(), new Diagramme(), new String());
        ElemTeste.creer();
        assertTrue(ElemTeste.getCellule()==ElemTeste);
    }
    
    @Test
    public void getElementGraphiqueViaCelluleActeurPassif(){
        ElementGraphique ElemTeste = new ActeurPassif(new mxGraph(), new Diagramme(), new String());
        ElemTeste.creer();
        assertTrue(ElemTeste.getCellule()==ElemTeste);
    }
    
    @Test
    public void getElementGraphiqueViaCelluleInterface(){
        ElementGraphique ElemTeste = new Interface(new mxGraph(), new String(),new Diagramme());
        ElemTeste.creer();
        assertTrue(ElemTeste.getCellule()==ElemTeste);
    }
    
    @Test
    public void getElementGraphiqueViaCelluleCasUtilisation(){
        ElementGraphique ElemTeste = new CasUtilisation(new mxGraph(),new Diagramme(), new String());
        ElemTeste.creer();
        assertTrue(ElemTeste.getCellule()==ElemTeste);
    }
}
