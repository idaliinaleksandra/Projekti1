package com.laine.projekti.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Hahmo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long Id;
	private String nimi;
	private int ika;
	private int koodi;
	private String elain;
	
	public Hahmo() {}
	
	public Hahmo(String nimi, int ika, int koodi, String elain){
		super ();
		this.nimi = nimi;
		this.ika = ika;
		this.koodi = koodi;
		this.elain = elain;
	}

	public void setId(Long id) {
		Id = id;
	}

	public void setNimi(String nimi) {
		this.nimi = nimi;
	}

	public void setIka(int ika) {
		this.ika = ika;
	}

	public void setKoodi(int koodi) {
		this.koodi = koodi;
	}

	public void setElain(String elain) {
		this.elain = elain;
	}

	
	public Long getId() {
		return Id;
	}

	public String getNimi() {
		return nimi;
	}

	public int getIka() {
		return ika;
	}

	public int getKoodi() {
		return koodi;
	}

	public String getElain() {
		return elain;
	}

	@Override
	public String toString() {
		return "Hahmo [Id=" + Id + ", nimi=" + nimi + ", ika=" + ika + ", koodi=" + koodi + ", elain=" + elain + "]";
	}
	
	

}
