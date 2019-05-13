package Model;

public class Osallistuja {

		private int osallistujaId;
		private Pelaaja pelaaja;
		private Kisa kisa;

		public Osallistuja() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Osallistuja(int osallistujaId, Pelaaja pelaaja, Kisa kisa) {
			super();
			this.osallistujaId = osallistujaId;
			this.pelaaja = pelaaja;
			this.kisa = kisa;
		}

		public int getOsallistujaId() {
			return osallistujaId;
		}

		public void setOsallistujaId(int osallistujaId) {
			this.osallistujaId = osallistujaId;
		}

		public Pelaaja getPelaaja() {
			return pelaaja;
		}

		public void setPelaaja(Pelaaja pelaaja) {
			this.pelaaja = pelaaja;
		}

		public Kisa getKisa() {
			return kisa;
		}

		public void setKisa(Kisa kisa) {
			this.kisa = kisa;
		}

		@Override
		public String toString() {
			return "Osallistuja [osallistuja=" + osallistujaId + ", pelaaja=" + pelaaja + ", kisa=" + kisa
					+ "]";
		}
		
		

		
}
