package it.unibs.fp.CartaAlta.Junit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import it.unibs.fp.CartaAlta.Carte.Carta;
import it.unibs.fp.CartaAlta.Carte.NumeriCarteFR;
import it.unibs.fp.CartaAlta.Carte.TipoCarte;
import it.unibs.fp.CartaAlta.Main.Partita;

public class PartitaTest {

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

	@Test(expected = IllegalArgumentException.class)
	public void creditoNegativo() {
		new Partita("Player", -1, null);
	}
	
	@Test
	public void estraiFranceseTest() {
		Partita p = new Partita("Player", 15, TipoCarte.Francesi);
		Carta c = p.getMazzoUsato().pescaCarta();
		assertNotNull(c);
	}
	
	@Test
	public void scommessaVinta() {
		int borsellino=15;
		Partita p = new Partita("Player", borsellino, TipoCarte.Francesi);
		Carta cUtente = new Carta( NumeriCarteFR.Asso,"PICCHE");
		Carta cPC = new Carta(NumeriCarteFR.Due,"PICCHE");
		p.scommetti(15, cUtente,cPC);
		assertEquals(p.getBorsellino(), 30);
	}
	
	@Test
	public void scommessaPersa() {
		int borsellino=15;
		Partita p = new Partita("Player", borsellino, TipoCarte.Francesi);
		Carta cUtente = new Carta(NumeriCarteFR.Due,"PICCHE");
		Carta cPC = new Carta( NumeriCarteFR.Asso,"PICCHE");
		p.scommetti(15,cUtente,cPC);
		assertEquals(p.getBorsellino(), 0);
	}
	
	
	@Test
	public void partitaPattaNonFinita() {
		int borsellino=15;
		Partita p = new Partita("Player", borsellino, TipoCarte.Francesi);
		Carta cUtente = new Carta(NumeriCarteFR.Asso,"PICCHE");
		Carta cPC = new Carta(NumeriCarteFR.Asso,"PICCHE");
		p.scommetti(15,cUtente,cPC);
		assertTrue(p.stillInGame());
	}
}
