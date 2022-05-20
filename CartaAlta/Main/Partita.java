package it.unibs.fp.CartaAlta.Main;


import it.unibs.fp.CartaAlta.Carte.Carta;
import it.unibs.fp.CartaAlta.Carte.TipoCarte;
import it.unibs.fp.CartaAlta.Mazzo.MazzoGenerico;
import it.unibs.fp.mylib.InputDati;

public class Partita {

	private static final String MSG_PERSO = "Hai perso :( ";
	private static final String MSG_VINTO= "Hai vinto :)";
	private static final String MSG_FINE = "\nGioco Finito.";
	private static final String MAZZO_FINITO = "Il mazzo è finito!\nMesocolo e possiamo ricominciare!";
	private static final String MSG_SALDO = "\n%s, il tuo saldo è %d";
	private static final String PARI = "Pari!  ";
	private static final String CARTA_BANCO = "\nBanco: ";
	private static final String MSG_SORTE = "Vuoi proseguire puntando???";
	private static final String TUA_CARTA = "\nHai pescato: ";
	private static final String LINE = "\n<=>-<=>-<=>-<=>-<=>-<=>-<=>-<=>-<=>-<=>-<=>-<=>-<=>-<=>-<=>-<=>-<=>-<=>";
	private static final String MSG_PUNTATA = "Quanti soldi hai portato con te?:";
	
	private  MazzoGenerico mazzoUsato;
	private static boolean inGame=true;
	private static int puntata;
	private static final int PUNTATA_MINIMA = 1;
	private String nome;
	private int borsellino;
	TipoCarte tipo;
	
	
	public Partita(String nome, int borsellino, TipoCarte tipo) {
		this.nome=nome;
		this.borsellino=borsellino;
		controllaBorsellino();
		this.tipo =  tipo;
		this.mazzoUsato = new MazzoGenerico(tipo);
		
	}

	
	private void controllaBorsellino() {
		if(borsellino <=0) {
			throw new IllegalArgumentException("Non puoi giocare se il tuo borsellino è minore di 1");
		}
	}


	public void avviaGioco() {	
					
		do {
			System.out.println(LINE);
			System.out.println(TUA_CARTA);
			Carta cartaGiocatore=mazzoUsato.pescaEScarta();
			
			inGame = InputDati.yesOrNo(MSG_SORTE);
			
			if(inGame) {
				puntata=InputDati.leggiInteroConMinimo(MSG_PUNTATA, PUNTATA_MINIMA);
				System.out.println(CARTA_BANCO);
				Carta cartaBanco= mazzoUsato.pescaEScarta();
				scommetti(puntata,cartaGiocatore,cartaBanco);
				
				
				if(mazzoUsato.getMazzoGioco().isEmpty()) {
					System.out.println(LINE);
					System.out.println(MAZZO_FINITO);
					mazzoUsato.getScarti().clear();
					mazzoUsato = new MazzoGenerico(tipo);
				}
			}
			
		}while(inGame && borsellino!=0);
		
		System.out.println(MSG_FINE);
	}



	/*public static void generaMazzoScelto() {
		switch(sceltaMazzi) {
			case 1:
				mazzoUsato = new MazzoGenerico(TipoCarte.Italiane);
				break;
			case 2:
				mazzoUsato = new MazzoGenerico(TipoCarte.Francesi);
				break;
			default:
				break;	
		}
	}*/


	public void scommetti(int puntata,Carta cartaGiocatore,Carta cartaBanco) {
		int differenza = cartaGiocatore.confronta(cartaBanco);
		
		if(differenza==0) {
			System.out.println(PARI);
		}
		else if(differenza<0) {
			lose(puntata);
		}
		else {
			
			win(puntata);
		}
		System.out.println(String.format(MSG_SALDO,nome, borsellino));
	}
	
	private void win(int puntata) {
		System.out.println(MSG_VINTO);
		setBorsellino(getBorsellino()+puntata);
		
	}

	private void lose(int puntata) {
		System.out.println(MSG_PERSO);
		System.out.println(getBorsellino());
		setBorsellino(getBorsellino()-puntata);
	}
	
	
	public void setBorsellino(int borsellino) {
		this.borsellino = borsellino;
	}


	public int getBorsellino() {
		return borsellino;
	}


	public MazzoGenerico getMazzoUsato() {
		return mazzoUsato;
	}
	
	public boolean stillInGame() {
		return inGame;
	}

}
		



