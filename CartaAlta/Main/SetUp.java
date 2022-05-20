package it.unibs.fp.CartaAlta.Main;

import it.unibs.fp.CartaAlta.Carte.TipoCarte;
import it.unibs.fp.mylib.BelleStringhe;
import it.unibs.fp.mylib.InputDati;
import it.unibs.fp.mylib.MyMenu;

public class SetUp {
	
	private static final String MSG_INIZIO = "GIOCO DELLA CARTA PIU ALTA\nBenvenuto nel gioco\n";
	private static final int MSG_MIN_GIOCATA = 1;
	private static final String MSG_NOME = "Prima di cominciare, dimmi come ti chiami: ";
	private static final String BENVENUTO = "Per iniziare scegli il mazzo da usare:";
	private static final String [] menuMazzi = {"Mazzo Italiano","Mazzo Francese"};
	static int sceltaMazzi;
	static Partita p;
	
	
	public SetUp() {
		
	}
	
	
	public static void inizializzaGioco() {
		
		System.out.println(MSG_INIZIO);
		String nome = BelleStringhe.primaLetteraMaiuscola(InputDati.leggiStringaNonVuota(MSG_NOME));
		int borsello = InputDati.leggiInteroConMinimo("Con quanti soldi vuoi giocare? ", MSG_MIN_GIOCATA);
		MyMenu mazzi = new MyMenu(BENVENUTO, menuMazzi);
		
		sceltaMazzi = mazzi.scegli();
		
		switch(sceltaMazzi) {
		case 1:
			p= new Partita(nome, borsello, TipoCarte.Italiane);
			break;
		case 2:
			p= new Partita(nome, borsello, TipoCarte.Francesi);
			break;
		default:
			break;
		}
		p.avviaGioco();
		
	}

}
