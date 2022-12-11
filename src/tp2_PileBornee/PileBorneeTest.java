package tp2_PileBornee;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PileBorneeTest {

	private PileBornee pb;
	private PileBornee pb2;
	
	@Before
	public void setUp() throws Exception { 
		pb = new PileBornee(10);
		pb2 = new PileBornee(2);
	}
	
	@After
	public void tearDown() throws Exception { 
		pb = null;
		pb2 = null;

	}
	
	//Scénario de test 1 : Créer une pile et s’assurer qu’elle soit vide.
	@Test
	public void testIsEmpty() {
		assertTrue(pb.isEmpty());
	}
	
	//Scénario de test 2 : Créer une pile, empiler un élément et s’assurer qu’elle ne soit pas vide.
	@Test
	public void testIsNotEmpty() {
		pb.push(1);
		assertFalse(pb.isEmpty());
	}

	//Scénario de test 3 : Créer une pile et s’assurer que la taille maximale est celle
	//spécifiée comme paramètre du constructeur.
	@Test
	public void testTailleMax() {
		assertEquals(10, pb.getMaxSize());
	}
	
	//Scénario de test 4 : Créer une pile, empiler un élément et s’assurer que la
	//taille maximale reste inchangée.
	@Test
	public void testTailleMaxDoesntChange() {
		int maxSize = pb.getMaxSize();
		pb.push(1);
		assertEquals(maxSize, pb.getMaxSize());
	}
	
	//Scénario de test 5 : Créer une pile et s’assurer que le nombre d’éléments soit 0.
	@Test
	public void testNombreElementsNul() {
		assertEquals(0, pb.getSize());
	}
	
	//Scénario de test 6 : Créer une pile de 2 éléments, puis :
	@Test
	public void testNombreElements() {
		//Sous-scénario 1 : empiler un élément et s’assurer que le nombre
		//d’éléments soit 1.
		pb2.push(11);
		assertEquals(1, pb2.getSize());
		//Sous-scénario 2 : empiler un élément et s’assurer que le nombre
		//d’éléments soit 2.
		pb2.push(22);
		assertEquals(2, pb2.getSize());
		//Sous-scénario 3 : empiler un élément et s’assurer que le nombre
		//d’éléments reste 2.
		pb2.push(33);
		assertEquals(2, pb2.getSize());
	}
	
	//Scénario de test 7 : Créer une pile et s’assurer que la pile ne soit pas pleine.
	@Test
	public void testPileNotFull() {
		assertFalse(pb.isFull());
	}
	
	//Scénario de test 8 : Créer une pile de 2 éléments, puis :
	@Test
	public void testPileFull() {
		//Sous-scénario 1 : empiler un élément et s’assurer que la pile ne soit pas pleine.
		pb2.push(11);
		assertFalse(pb2.isFull());
		//Sous-scénario 2 : empiler un élément et s’assurer que la pile soit pleine.
		pb2.push(22);
		assertTrue(pb2.isFull());
	}
	
	//Scénario de test 9 : Créer une pile de 2 éléments, puis :
	@Test
	public void testTop() throws EmptyStackException {
		//Sous-scénario 1 : empiler un élément et s’assurer que top renvoie cet élément.
		pb2.push(11);
		assertEquals(11, pb2.top());
		//Sous-scénario 2 : empiler un élément et s’assurer que top renvoie cet élément.
		pb2.push(22);
		assertEquals(22, pb2.top());
		//Sous-scénario 3 : empiler un élément et s’assurer que top renvoie l’élément du sous-scénario 2.
		pb2.push(33);
		assertEquals(22, pb2.top());	
	}
	
	//Scénario de test 10 : Créer une pile de 2 éléments et s’assurer que pop laisse
	//la pile inchangée (taille et taille maximale).
	@Test
	public void testPopOnEmpty() {
		pb2.pop();
		assertEquals(0, pb2.getSize());
		assertEquals(2, pb2.getMaxSize());
	}
		
	//Scénario de test 11 : Créer une pile de 2 éléments, puis :
	@Test
	public void testPop() throws EmptyStackException {
		//Sous-scénario 1 : empiler un élément et s’assurer qu’après pop la pile
		//devienne vide.
		pb2.push(11);
		pb2.pop();
		assertTrue(pb2.isEmpty());
		//Sous-scénario 2 : empiler 2 éléments et s’assurer qu’après pop le
		//sommet de pile soit le premier élément empilé.
		pb2.push(11);
		pb2.push(22);
		pb2.pop();
		assertEquals(11, pb2.top());
	}
		
	//Scénario de test levée d’exception sur la méthode top : Créer une pile d’un
	//nombre d’éléments quelconque supérieur strictement à zéro et vérifier que
	//l’opération top lève une exception de type EmptyStackException.
	@Test(expected = EmptyStackException.class) 
	public void testTopExceptionSurPileVide() throws EmptyStackException {
		pb.top();
	}
	
	//Scénarios de test levée d’exception sur le constructeur d’une pile : créer
	//une pile à zéro élément, créer une pile avec un nombre négatif d’éléments et
	//vérifier que ces deux appels au constructeur d’une pile lèvent une exception de
	//type IllegalArgumentException
	@Test(expected = IllegalArgumentException.class) 
	public void testExceptionConstructeurPileNul() {
		new PileBornee(0);
	}
	
	@Test(expected = IllegalArgumentException.class) 
	public void testExceptionConstructeurPileNegatif() {
		new PileBornee(-1);
	}
		
	@Test
	public void testToString() {
		pb2.push(11);
		pb2.push(22);
		String s = "PileBornee [maxSize = 2, size = 2, elements = 22 11 ]";
		assertEquals(s, pb2.toString());
	}
		
	
		
	
	
		
	
		
	
		
	
}
