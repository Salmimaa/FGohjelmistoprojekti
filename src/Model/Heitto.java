package Model;


public class Heitto {
	
	private int heittoId, lkm;
	private Osallistuja osallistujaId;
	private Vayla vaylaId;
	
	public Heitto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Heitto(int heittoId, int lkm, Osallistuja osallistujaId, Vayla vaylaId) {
		super();
		this.heittoId = heittoId;
		this.lkm = lkm;
		this.osallistujaId = osallistujaId;
		this.vaylaId = vaylaId;
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

	public Osallistuja getOsallistujaId() {
		return osallistujaId;
	}

	public void setOsallistujaId(Osallistuja osallistujaId) {
		this.osallistujaId = osallistujaId;
	}

	public Vayla getVaylaId() {
		return vaylaId;
	}

	public void setVaylaId(Vayla vaylaId) {
		this.vaylaId = vaylaId;
	}

	@Override
	public String toString() {
		return "Heitto [heittoId=" + heittoId + ", lkm=" + lkm + ", osallistujaId=" + osallistujaId + ", vaylaId="
				+ vaylaId + "]";
	}
	
	

}
