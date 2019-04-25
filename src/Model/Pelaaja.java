package Model;

public class Pelaaja {
	
	private int pelaajaId;
	private String etunimi, sukunimi, kayttajanimi, salasana;
	
	public Pelaaja() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Pelaaja(int pelaajaId, String etunimi, String sukunimi, String kayttajanimi, String salasana) {
		super();
		this.pelaajaId = pelaajaId;
		this.etunimi = etunimi;
		this.sukunimi = sukunimi;
		this.kayttajanimi = kayttajanimi;
		this.salasana = salasana;
	}

	public int getPelaajaId() {
		return pelaajaId;
	}

	public void setPelaajaId(int pelaajaId) {
		this.pelaajaId = pelaajaId;
	}

	public String getEtunimi() {
		return etunimi;
	}

	public void setEtunimi(String etunimi) {
		this.etunimi = etunimi;
	}

	public String getSukunimi() {
		return sukunimi;
	}

	public void setSukunimi(String sukunimi) {
		this.sukunimi = sukunimi;
	}

	public String getKayttajanimi() {
		return kayttajanimi;
	}

	public void setKayttajanimi(String kayttajanimi) {
		this.kayttajanimi = kayttajanimi;
	}

	public String getSalasana() {
		return salasana;
	}

	public void setSalasana(String salasana) {
		this.salasana = salasana;
	}

	@Override
	public String toString() {
		return "Pelaaja [pelaajaId=" + pelaajaId + ", etunimi=" + etunimi + ", sukunimi=" + sukunimi
				+ ", kayttajanimi=" + kayttajanimi + ", salasana=" + salasana + "]";
	}
	
	

}
