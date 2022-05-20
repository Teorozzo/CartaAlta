package it.unibs.fp.CartaAlta.Carte;

public enum TipoCarte {
	
	Italiane("ITALIANO", new String[]{"Bastoni","Spade"/*,"Coppe","Denari"*/},NumeriCarteIT.values()),
	Francesi("FRANCESE", new String[]{"Cuori","Quadri","Fiori","Picche"},NumeriCarteFR.values());
	
	String desc;
	String[] simboli;
	NumeriCarte[] numeriCarte;
	
	
	TipoCarte(String desc, String[] simboli, NumeriCarte[] numeriCarte) {
		this.desc=desc;
		this.simboli=simboli;
		this.numeriCarte=numeriCarte;
	}


	public String[] getSimboli() {
		return simboli;
	}


	public NumeriCarte[] getNumeriCarte() {
		return numeriCarte;
	}

	
}

	

