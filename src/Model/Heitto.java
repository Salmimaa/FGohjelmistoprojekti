package Model;


public class Heitto {
	
	private int heittoId, lkm;
	private Osallistuja osallistuja;
	private Vayla vayla;
	
	public Heitto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Heitto(int heittoId, int lkm, Osallistuja osallistuja, Vayla vayla) {
		super();
		this.heittoId = heittoId;
		this.lkm = lkm;
		this.osallistuja = osallistuja;
		this.vayla = vayla;
	}

	public int getHeittoId() {
		return heittoId;
	}

	public void setHeittoId(int heittoId) {
		this.heittoId = heittoId;
	}

	public int getLkm() {
		return lkm;
	}

	public void setLkm(int lkm) {
		this.lkm = lkm;
	}

	public Osallistuja getOsallistuja() {
		return osallistuja;
	}

	public void setOsallistuja(Osallistuja osallistuja) {
		this.osallistuja = osallistuja;
	}

	public Vayla getVayla() {
		return vayla;
	}

	public void setVayla(Vayla vayla) {
		this.vayla = vayla;
	}

	@Override
	public String toString() {
		return "Heitto [heittoId=" + heittoId + ", lkm=" + lkm + ", osallistuja=" + osallistuja + ", vayla="
				+ vayla + "]";
	}
	
	

}
