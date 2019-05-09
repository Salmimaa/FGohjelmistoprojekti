package Model;

import java.util.Date;

public class Kisa {

		private int kisaId;
		private String kisaNimi;
		private Rata rata;
		private Date aika;
		public Kisa() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Kisa(int kisaId, String kisaNimi, Date aika, Rata rata) {
			super();
			this.kisaId = kisaId;
			this.kisaNimi = kisaNimi;
			this.aika = aika;
			this.rata = rata;
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

		public Date getAika() {
			return aika;
		}

		public void setAika(Date aika) {
			this.aika = aika;
		}

		public Rata getRata() {
			return rata;
		}

		public void setRata(Rata rata) {
			this.rata = rata;
		}

		@Override
		public String toString() {
			return "Kisa [kisaId=" + kisaId + ", kisaNimi=" + kisaNimi + ", aika=" + aika + ", rataId=" + rata + "]";
		}
		
		
	
}
