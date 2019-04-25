package Model;

public class Postinumero {

		private String postinumero, postitoimipaikka;

		public Postinumero() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Postinumero(String postinumero, String postitoimipaikka) {
			super();
			this.postinumero = postinumero;
			this.postitoimipaikka = postitoimipaikka;
		}

		public String getPostinumero() {
			return postinumero;
		}

		public void setPostinumero(String postinumero) {
			this.postinumero = postinumero;
		}

		public String getPostitoimipaikka() {
			return postitoimipaikka;
		}

		public void setPostitoimipaikka(String postitoimipaikka) {
			this.postitoimipaikka = postitoimipaikka;
		}

		@Override
		public String toString() {
			return "Postinumero [postinumero=" + postinumero + ", postitoimipaikka=" + postitoimipaikka + "]";
		}
		
		
}
