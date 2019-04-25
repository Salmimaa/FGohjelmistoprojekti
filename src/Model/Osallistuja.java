package Model;

public class Osallistuja {

		private int osallistujaId;
		private Pelaaja pelaajaId;
		private Kisa kisaId;

		public Osallistuja() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Osallistuja(int osallistujaId, Pelaaja pelaajaId, Kisa kisaId) {
			super();
			this.osallistujaId = osallistujaId;
			this.pelaajaId = pelaajaId;
			this.kisaId = kisaId;
		}

		public int getOsallistujaId() {
			return osallistujaId;
		}

		public void setOsallistujaId(int osallistujaId) {
			this.osallistujaId = osallistujaId;
		}

		public Pelaaja getPelaajaId() {
			return pelaajaId;
		}

		public void setPelaajaId(Pelaaja pelaajaId) {
			this.pelaajaId = pelaajaId;
		}

		public Kisa getKisaId() {
			return kisaId;
		}

		public void setKisaId(Kisa kisaId) {
			this.kisaId = kisaId;
		}

		@Override
		public String toString() {
			return "Osallistuja [osallistujaId=" + osallistujaId + ", pelaajaId=" + pelaajaId + ", kisaId=" + kisaId
					+ "]";
		}
		
		

		
}
