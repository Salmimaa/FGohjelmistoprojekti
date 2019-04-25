package Model;

public class Kisa {

		private int kisaId;
		private String kisaNimi, aika;
		private Rata rataId;
		
		public Kisa() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Kisa(int kisaId, String kisaNimi, String aika, Rata rataId) {
			super();
			this.kisaId = kisaId;
			this.kisaNimi = kisaNimi;
			this.aika = aika;
			this.rataId = rataId;
		}

		public int getKisaId() {
			return kisaId;
		}

		public void setKisaId(int kisaId) {
			this.kisaId = kisaId;
		}

		public String getKisaNimi() {
			return kisaNimi;
		}

		public void setKisaNimi(String kisaNimi) {
			this.kisaNimi = kisaNimi;
		}

		public String getAika() {
			return aika;
		}

		public void setAika(String aika) {
			this.aika = aika;
		}

		public Rata getRataId() {
			return rataId;
		}

		public void setRataId(Rata rataId) {
			this.rataId = rataId;
		}

		@Override
		public String toString() {
			return "Kisa [kisaId=" + kisaId + ", kisaNimi=" + kisaNimi + ", aika=" + aika + ", rataId=" + rataId + "]";
		}
		
		
	
}
