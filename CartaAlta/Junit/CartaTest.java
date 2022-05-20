package it.unibs.fp.CartaAlta.Junit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import it.unibs.fp.CartaAlta.Carte.Carta;
import it.unibs.fp.CartaAlta.Carte.NumeriCarteFR;
import it.unibs.fp.CartaAlta.Carte.NumeriCarteIT;

public class CartaTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCompareToItalianeReMaggioreCavallo() {
		Carta re = new Carta(NumeriCarteIT.Re,"SPADE");
		Carta cavallo = new Carta(NumeriCarteIT.Cavallo,"SPADE");
		assertTrue(re.confronta(cavallo) > 0);
	}
	

	@Test
	public void testCompareToFrancesiDonnaMinoreJack() {
		Carta donna = new Carta(NumeriCarteFR.Jack,"PICCHE");
		Carta re = new Carta(NumeriCarteFR.Donna,"PICCHE");
		assertTrue(donna.confronta(re) < 0);
	}
}
