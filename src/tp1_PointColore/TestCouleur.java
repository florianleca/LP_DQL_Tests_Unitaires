package tp1_PointColore;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestCouleur {

	private Couleur c;
	
	@Before
	public void setUp() throws Exception { 
		this.c = new Couleur(1,2,3);
	}
	
	@After
	public void tearDown() throws Exception { 
		this.c = null;
	}
	
//	(P1) rouge = uneCouleur (255, 0, 0)
	@Test
	public void testConstanteRouge() { 
		assertEquals(255,Couleur.ROUGE.getRouge()); 
		assertEquals(0,Couleur.ROUGE.getVert()); 
		assertEquals(0,Couleur.ROUGE.getBleu());
	}
	
//	(P2) vert = uneCouleur (0, 255, 0)
	@Test
	public void testConstanteVert() { 
		assertEquals(0,Couleur.VERT.getRouge()); 
		assertEquals(255,Couleur.VERT.getVert()); 
		assertEquals(0,Couleur.VERT.getBleu());
	}
	
//	(P3) bleu = uneCouleur (0, 0, 255)
	@Test
	public void testConstanteBleu() { 
		assertEquals(0,Couleur.BLEU.getRouge()); 
		assertEquals(0,Couleur.BLEU.getVert()); 
		assertEquals(255,Couleur.BLEU.getBleu());
	}
	
//	(P4) NuanceRouge (uneCouleur (r, v, b)) = r 
	@Test
	public void testComposanteRougeConstructeur() { 
		assertEquals(1,this.c.getRouge());
	}
	
//	(P5) NuanceVert (uneCouleur (r, v, b)) = v 
	@Test
	public void testComposanteVerteConstructeur() { 
		assertEquals(2,this.c.getVert());
	}
	
//	(P6) NuanceBleu (uneCouleur (r, v, b)) = b
	@Test
	public void testComposanteBleuConstructeur() { 
		assertEquals(3,this.c.getBleu());
	}
	
//	(P7) modifierNuanceRouge (uneCouleur (r1, v, b), r2) = uneCouleur (r2, v, b) 
	@Test
	public void testComposanteRougeSetter() { 
		this.c.setRouge(255); 
		assertEquals(255,this.c.getRouge());
	}
	
//	(P8) modifierNuanceVert (uneCouleur (r, v1, b), v2) = uneCouleur (r, v2, b) 
	@Test
	public void testComposanteVerteSetter() { 
		this.c.setVert(255); 
		assertEquals(255,this.c.getVert());
	}
	
//	(P9) modifierNuanceBleu (uneCouleur (r, v, b1), b2) = uneCouleur (r, v, b2)
	@Test
	public void testComposanteBleuSetter() { 
		this.c.setBleu(255); 
		assertEquals(255,this.c.getBleu());
	}
	
//	(P10) valeurRVB (uneCouleur (r, v, b)) = r * 2562 + v * 256 + b
	@Test
	public void testValeurRVB() {
	assertEquals(256 * 256 + 2 * 256 + 3,this.c.valeurRVB()); 
	}

	@Test(expected = IllegalArgumentException.class) 
	public void testValeurNégativeComposanteRouge() {
		this.c.setRouge(-1); 
	}
	
	@Test(expected = IllegalArgumentException.class) 
	public void testValeurTropGrandeComposanteRouge() {
		this.c.setRouge(256); 
	}
		
	@Test(expected = IllegalArgumentException.class) 
	public void testValeurNégativeComposanteVert() {
		this.c.setVert(-1); 
	}
		
	@Test(expected = IllegalArgumentException.class) 
	public void testValeurTropGrandeComposanteVert() {
		this.c.setVert(256); 
	}
		
	@Test(expected = IllegalArgumentException.class) 
	public void testValeurNégativeComposanteBleu() {
		this.c.setBleu(-1); 
	}
		
	@Test(expected = IllegalArgumentException.class) 
	public void testValeurTropGrandeComposanteBleu() {
		this.c.setBleu(256); 
	}
	
}
