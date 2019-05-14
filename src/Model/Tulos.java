package Model;

public class Tulos {
		private int tulos;
		private Osallistuja osallistuja;
		public Tulos() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Tulos(int tulos, Osallistuja osallistuja) {
			super();
			this.tulos = tulos;
			this.osallistuja = osallistuja;
		}
		public int getTulos() {
			return tulos;
		}
		public void setTulos(int tulos) {
			this.tulos = tulos;
		}
		public Osallistuja getOsallistuja() {
			return osallistuja;
		}
		public void setOsallistuja(Osallistuja osallistuja) {
			this.osallistuja = osallistuja;
		}
		@Override
		public String toString() {
			return "Tulos [tulos=" + tulos + ", osallistuja=" + osallistuja + "]";
		}
		
		
}
