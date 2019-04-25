package Model;

public class Ratavayla {
	
	private int ratavaylaId;
	private Rata rataId;
	private Vayla vaylaId;

	public Ratavayla() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Ratavayla(int ratavaylaId, Rata rataId, Vayla vaylaId) {
		super();
		this.ratavaylaId = ratavaylaId;
		this.rataId = rataId;
		this.vaylaId = vaylaId;
	}

	public int getRatavaylaId() {
		return ratavaylaId;
	}

	public void setRatavaylaId(int ratavaylaId) {
		this.ratavaylaId = ratavaylaId;
	}

	public Rata getRataId() {
		return rataId;
	}

	public void setRataId(Rata rataId) {
		this.rataId = rataId;
	}

	public Vayla getVaylaId() {
		return vaylaId;
	}

	public void setVaylaId(Vayla vaylaId) {
		this.vaylaId = vaylaId;
	}

	@Override
	public String toString() {
		return "Ratavayla [ratavaylaId=" + ratavaylaId + ", rataId=" + rataId + ", vaylaId=" + vaylaId + "]";
	}

	

}
