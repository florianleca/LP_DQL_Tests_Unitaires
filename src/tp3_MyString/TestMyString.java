package tp3_MyString;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestMyString {

	String test;
	private char[] characters = {'h', 'e', 'y'};
	private StringBuffer buffer = new StringBuffer("hey");
	private MyString myString;
	private MyString myEmptyString;
	MyString myStringBuffer;
	
	@Before
	public void setUp() {
		myString = new MyString(characters);
		myEmptyString = new MyString(new StringBuffer(""));
		myStringBuffer = new MyString(buffer);

	}
	
	@After
	public void tearDown() {
		myString = null;
	}
	
//	@Test
//	public void testConstructeurArrayNotSameAndRecopieEquals() { String str = "abc";
//	char[] value = str.toCharArray(); 
//	MyString test = new MyString(value); 
//	assertNotSame(value,test.value); 
//	assertArrayEquals(value,test.value);
//	}
	
	
	@Test
	public void testCommonConstructor() {
		assertEquals(characters.length, myString.length());
		for (int i = 0; i < characters.length; i++) {
			assertEquals(characters[i], myString.value[i]);
		}
	}

	//subsequent modification of the character array does not affect the newly created string
	@Test
	public void testModifyCharArray() {
		MyString temp = myString;
		characters[0] = 'z';
		assertEquals(temp, myString);
	}
	
	@Test
	public void testBufferConstructorLength() {
		assertEquals(buffer.length(), myStringBuffer.length());
	}
	
	@Test
	public void testBufferConstructor() {
		for (int i = 0; i < characters.length; i++) {
			assertEquals(buffer.charAt(i), myStringBuffer.value[i]);
		}
	}
	
	@Test
	public void testLength() {
		assertEquals(3, myString.length());
		assertEquals(0, myEmptyString.length());
	}
	
	@Test
	public void testIsEmpty() {
		assertFalse(myString.isEmpty());
		assertTrue(myEmptyString.isEmpty());
	}
	
	@Test
	public void testCharAt() {
		assertEquals('h', myString.charAt(0));
	}
	
	@Test(expected = StringIndexOutOfBoundsException.class)
	public void testIndexOutOfBoundsCharAtNegative() {
		myString.charAt(-1);
	}
	
	@Test(expected = StringIndexOutOfBoundsException.class)
	public void testIndexOutOfBoundsCharAtTooMuch() {
		myString.charAt(50);
	}
	
	@Test
	public void testEqualsSameObject() {
		assertTrue(myString.equals(myString));
	}
	
	@Test
	public void testEqualsNotSameObjectButSameString() {
		MyString mySameString = new MyString(characters);
		assertTrue(myString.equals(mySameString));
	}
	
	@Test
	public void testEqualsNotSameLength() {
		assertFalse(myString.equals(myEmptyString));
	}
	
	@Test
	public void testEqualsSameLengthButNotSameString() {
		char[] characters2 = {'h', 'e', 'u'};
		MyString myOtherString = new MyString(characters2);
		assertFalse(myString.equals(myOtherString));
	}
	
	@Test
	public void testEqualsNotMyString() {
		assertFalse(myString.equals(3));
	}
	
	@Test
	public void testIndexOf() {
		assertEquals(-1, myString.indexOf('x'));
		assertEquals(1, myString.indexOf('e'));
	}
	
	@Test
	public void testLastIndexOf() {
		char[] characters2 = {'h', 'e', 'h'};
		MyString myOtherString = new MyString(characters2);
		assertEquals(-1, myOtherString.lastIndexOf('x'));
		assertEquals(2, myOtherString.lastIndexOf('h'));
	}
	
	@Test
	public void testConcatWithEmpty() {
		assertEquals(myString, myString.concat(myEmptyString));
	}
	@Test
	public void testConcatWithNonEmpty() {
		char[] characters2 = {'h', 'o'};
		char[] characters3 = {'h','e','y','h', 'o'};
		MyString myString2 = new MyString(characters2);
		MyString myString3 = new MyString(characters3);

		assertEquals(myString3, myString.concat(myString2));
	}
	
	@Test(expected = StringIndexOutOfBoundsException.class)
	public void testSubstringNegativeStartIndex() {
		myString.substring(-2, 2);
	}
	
	@Test(expected = StringIndexOutOfBoundsException.class)
	public void testSubstringEndIndexTooBig() {
		myString.substring(0, 20);
	}
	
	@Test(expected = StringIndexOutOfBoundsException.class)
	public void testSubstringEndIndexBiggerThanStart() {
		myString.substring(2, 1);
	}
	
	@Test
	public void testSubstringOfEverything() {
		//assertEquals(myString, myString.substring(0, 3));
		assertSame(myString, myString.substring(0, 3));

	}
	
	@Test
	public void testSubstringCas1() {
		char[] characters2 = {'h', 'e'};
		MyString myString2 = new MyString(characters2);
		assertEquals(myString2, myString.substring(0, 2));
	}
	
//	@Test
//	public void testSubstringCas2() {
//		char[] characters2 = {'e', 'y'};
//		MyString myString2 = new MyString(characters2);
//		assertEquals(myString2, myString.substring(1, 3));
//	}
//	
//	@Test
//	public void testSubstringCas3() {
//		char[] characters2 = {'e'};
//		MyString myString2 = new MyString(characters2);
//		assertEquals(myString2, myString.substring(1, 2));
//	}

}
