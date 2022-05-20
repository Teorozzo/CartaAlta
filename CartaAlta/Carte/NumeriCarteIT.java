package it.unibs.fp.CartaAlta.Carte;

public enum NumeriCarteIT implements NumeriCarte {
	Asso(14,"Asso"),
	Due(2,"Due"),
	Tre(3,"Tre"),
	Quattro(4,"Quattro"),
	Cinque(5,"Cinque"),
	Sei(6,"Sei"),
	Sette(7,"Sette"),
	Fante(11,"Fante"),
	Cavallo(12,"Cavallo"),
	Re(13,"Re");
	
	private int value;
	private String description;

	NumeriCarteIT(int value, String description) {
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
