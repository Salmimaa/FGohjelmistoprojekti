package Model;

public class Rata {

		private int rataId, vaylanmaara;
		private String radanNimi, osoite;
		private Postinumero postinumero;
		
		public Rata() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Rata(int rataId, int vaylanmaara, String radanNimi, String osoite, Postinumero postinumero) {
			super();
			this.rataId = rataId;
			this.vaylanmaara = vaylanmaara;
			this.radanNimi = radanNimi;
			this.osoite = osoite;
			this.postinumero = postinumero;
		}

		public int getRataId() {
			return rataId;
		}

		public void setRataId(int rataId) {
			this.rataId = rataId;
		}

		public int getVaylanmaara() {
			return vaylanmaara;
		}

		public void setVaylanmaara(int vaylanmaara) {
			this.vaylanmaara = vaylanmaara;
		}

		public String getRadanNimi() {
			return radanNimi;
		}

		public void setRadanNimi(String radanNimi) {
			this.radanNimi = radanNimi;
		}

		public String getOsoite() {
			return osoite;
		}

		public void setOsoite(String osoite) {
			this.osoite = osoite;
		}

		public Postinumero getPostinumero() {
			return postinumero;
		}

		public void setPostinumero(Postinumero postinumero) {
			this.postinumero = postinumero;
		}

		@Override
		public String toString() {
			return "Rata [rataId=" + rataId + ", vaylanmaara=" + vaylanmaara + ", radanNimi=" + radanNimi + ", osoite="
					+ osoite + ", postinumero=" + postinumero + "]";
		}
		
		
}
