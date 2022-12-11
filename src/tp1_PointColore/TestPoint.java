package tp1_PointColore;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestPoint {

	private Point p;
	
	@Before
	public void setUp() throws Exception { 
		this.p = new Point(1.0f,2.0f);
	}
	
	@After
	public void tearDown() throws Exception { 
		this.p = null;
	}
	
//	(P1) pointOrigine = unPoint (0.0, 0.0)
	@Test
	public void testPointOrigine() {
		assertEquals(0, Point.POINT_ORIGINE.getAbscisse(), 0);
		assertEquals(0, Point.POINT_ORIGINE.getOrdonnee(), 0);
	}
	
//	(P2) abscisse (unPoint (x, y)) = x
	@Test
	public void testAbscisse() {
		assertEquals(1.0f, this.p.getAbscisse(), 0);	
	}

//	(P3) ordonnee (unPoint (x, y)) = y
	@Test
	public void testOrdonnee() {
		assertEquals(2.0f, this.p.getOrdonnee(), 0);	
	}
	
//	(P4) translater (unPoint (x, y), tx, ty) = unPoint (x + tx, y + ty)
	@Test
	public void testTranslation() {
		this.p.translater(3.0f, 4.0f);
		assertEquals(new Point(1.0f + 3.0f, 2.0f + 4.0f), this.p);	
	}
	
//	(P5) mettreAEchelle (unPoint (x, y), h) = unPoint (x * h, y * h)
	@Test
	public void testMettreAEchelle() {
		this.p.mettreAEchelle(2.0f);	
		assertEquals(new Point(1.0f*2.0f, 2.0f*2.0f), this.p);
	}
	
	@Test
	public void testEquals() {
		assertTrue(this.p.equals(this.p));
		assertFalse(this.p.equals(null));
		assertFalse(this.p.equals(new Couleur(1, 2, 3)));
		assertFalse(this.p.equals(new Point(2, 2)));
		assertFalse(this.p.equals(new Point(1, 1)));
	}
	
	
	@Test(expected = IllegalArgumentException.class) 
	public void testMettreAEchelleException1() {
	      this.p.mettreAEchelle(-2);
	}
	
	@Test(expected = IllegalArgumentException.class) 
	public void testMettreAEchelleException2() {
	      this.p.mettreAEchelle(0); 
	}
}
