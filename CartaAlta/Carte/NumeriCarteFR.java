package it.unibs.fp.CartaAlta.Carte;

public enum NumeriCarteFR implements NumeriCarte{
	Asso(14,"Asso"),
	Due(2,"Due"),
	Tre(3,"Tre"),
	Quattro(4,"Quattro"),
	Cinque(5,"Cinque"),
	Sei(6,"Sei"),
	Sette(7,"Sette"),
	Otto(8,"Otto"),
	Nove(9,"Nove"),
	Dieci(10,"Dieci"),
	Jack(11,"Jack"),
	Donna(12,"Donna"),
	Re(13,"Re");
	
	private int value;
	private String description;

	NumeriCarteFR(int value, String description) {
		this.value = value;
		this.description = description;
	}

	public int getValore() {
		return value;
	}

	public String getDescrizione() {
		return description;
	}
	
}
