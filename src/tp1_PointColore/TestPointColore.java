package tp1_PointColore;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestPointColore extends TestPoint{
	
	PointColore pc;
		
	@Before
	public void setUp() throws Exception { 
		super.setUp();
		this.pc = new PointColore(1.0f, 2.0f, 100, 150, 200);
	}
	
	@After
	public void tearDown() throws Exception { 
		this.pc = null;
	}
	
//	(P1) pointOrigine = unPointColore (0.0, 0.0, 0, 0, 0)
	@Test
	public void testPointColore() {
		assertEquals(0.0f, PointColore.POINT_ORIGINE.getAbscisse(), 0);
		assertEquals(0.0f, PointColore.POINT_ORIGINE.getOrdonnee(), 0);
		assertEquals(0, PointColore.POINT_ORIGINE.getNuanceRouge());
		assertEquals(0, PointColore.POINT_ORIGINE.getNuanceVert());
		assertEquals(0, PointColore.POINT_ORIGINE.getNuanceBleu());
	}
	
//	(P4) nuanceRouge (unPointColore (x, y, r, v, b) = r
	@Test
	public void testNuanceRouge() {
		assertEquals(100, this.pc.getNuanceRouge());
	}
	
//	(P5) nuanceVert (unPointColore (x, y, r, v, b) = v
	@Test
	public void testNuanceVert() {
		assertEquals(150, this.pc.getNuanceVert());
	}

//	(P6) nuanceBleu (unPointColore (x, y, r, v, b) = b	
	@Test
	public void testNuanceBleu() {
		assertEquals(200, this.pc.getNuanceBleu());
	}
	
//	(P9) modifierNuanceRouge (unPointColore (x, y, c), r) = unPointColore (x, y, uneCouleur (r, nuanceVert (c), nuanceBleu(c), r) 
	@Test
	public void testModifierNuanceRouge() {
		this.pc.setNuanceRouge(0);
		assertEquals(new PointColore(1.0f, 2.0f, 0, 150, 200), this.pc);
	}
	
//	(P10) modifierNuanceVert (unPointColore (x, y, c), v) = unPointColore (x, y, uneCouleur (nuanceRouge (c), v, NuanceBleu (c)) 
	@Test
	public void testModifierNuanceVert() {
		this.pc.setNuanceVert(0);
		assertEquals(new PointColore(1.0f, 2.0f, 100, 0, 200), this.pc);
	}
	
//	(P11) modifierNuanceBleu (unPointColore (x, y, c), b) = unPointColore (x, y, uneCouleur (nuanceRouge (c), nuanceVert (c), b)
	@Test
	public void testModifierNuanceBleu() {
		this.pc.setNuanceBleu(0);
		assertEquals(new PointColore(1.0f, 2.0f, 100, 150, 0), this.pc);
	}

	

}
