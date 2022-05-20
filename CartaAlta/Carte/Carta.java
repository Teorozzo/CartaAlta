package it.unibs.fp.CartaAlta.Carte;

public class Carta {

	private static final String MSG_CARTA = "--> %s di %s, (%d punti)";
	NumeriCarte valore;
	String simbolo;
	
	public Carta(NumeriCarte valore, String simbolo) {
		super();
		this.valore = valore;
		this.simbolo = simbolo;
		
	}



	public int getValore() {
		return valore.getValore();
	}



	public String getSimbolo() {
		return simbolo;
	}



	public int confronta(Carta banco) {
		return (this.getValore()-banco.getValore());
	}



	@Override
	public String toString() {
		return (String.format(MSG_CARTA, this.valore.getDescrizione(),this.simbolo,this.getValore()));
	}



	
	
	
	
	
}
