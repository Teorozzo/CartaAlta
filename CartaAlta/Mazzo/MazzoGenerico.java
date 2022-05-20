package it.unibs.fp.CartaAlta.Mazzo;

import java.util.ArrayList;

import it.unibs.fp.CartaAlta.Carte.*;
import it.unibs.fp.mylib.EstrazioniCasuali;

public class MazzoGenerico {

	ArrayList <Carta> mazzoGioco ;
	ArrayList <Carta> scarti;
	
	public MazzoGenerico(TipoCarte tipo) {
	mazzoGioco = creaMazzo(tipo.getSimboli(), tipo.getNumeriCarte());
	scarti = new ArrayList <Carta>() ;
		
	}
	
	public ArrayList<Carta> creaMazzo(String[] semi,NumeriCarte[] valori) {
		ArrayList <Carta> mazzoGioco = new ArrayList <Carta>();
		for(String simboli : semi) {
			for(NumeriCarte valore: valori) {
				mazzoGioco.add(new Carta(valore,simboli));
			}
		}
		return mazzoGioco;
	}
	
	public Carta pescaCarta() {
		int pesca=EstrazioniCasuali.estraiIntero(0, mazzoGioco.size()-1);
		
		return mazzoGioco.get(pesca);
	}

	public void scarta (Carta daScartare) {
		scarti.add(daScartare);
		mazzoGioco.remove(cerca(daScartare));
	}
	
	public int cerca(Carta daCercare) {
		for(int i=0;i<mazzoGioco.size();i++) {
			if(mazzoGioco.get(i)==daCercare)
				return i;
		}
		System.out.println("Carta non trovata");
		return -1;
	}
	
	public Carta pescaEScarta() {
		Carta cartaPescata= pescaCarta();
		scarta(cartaPescata);
		System.out.println("\n"+cartaPescata.toString());
		return cartaPescata;
	}
	
	
	public ArrayList<Carta> getMazzoGioco() {
		return mazzoGioco;
	}

	public void setMazzoGioco(ArrayList<Carta> mazzoGioco) {
		this.mazzoGioco = mazzoGioco;
	}

	public ArrayList<Carta> getScarti() {
		return scarti;
	}

	public void setScarti(ArrayList<Carta> scarti) {
		this.scarti = scarti;
	}
	
}
