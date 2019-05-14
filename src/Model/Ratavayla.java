package Model;

public class Ratavayla {
	
	private int ratavaylaId;
	private Rata rata;
	private Vayla vayla;

	public Ratavayla() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Ratavayla(int ratavaylaId, Rata rata, Vayla vayla) {
		super();
		this.ratavaylaId = ratavaylaId;
		this.rata = rata;
		this.vayla = vayla;
	}

	public int getRatavaylaId() {
		return ratavaylaId;
	}

	public void setRatavaylaId(int ratavaylaId) {
		this.ratavaylaId = ratavaylaId;
	}

	public Rata getRata() {
		return rata;
	}

	public void setRata(Rata rata) {
		this.rata = rata;
	}

	public Vayla getVayla() {
		return vayla;
	}

	public void setVayla(Vayla vayla) {
		this.vayla = vayla;
	}

	@Override
	public String toString() {
		return "Ratavayla [ratavaylaId=" + ratavaylaId + ", rata=" + rata + ", vayla=" + vayla + "]";
	}

	

}
