package Model;

public class Vayla {

		private int vaylaId, par;

		public Vayla() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Vayla(int vaylaId, int par) {
			super();
			this.vaylaId = vaylaId;
			this.par = par;
		}

		public int getVaylaId() {
			return vaylaId;
		}

		public void setVaylaId(int vaylaId) {
			this.vaylaId = vaylaId;
		}

		public int getPar() {
			return par;
		}

		public void setPar(int par) {
			this.par = par;
		}

		@Override
		public String toString() {
			return "Vayla [vaylaId=" + vaylaId + ", par=" + par + "]";
		}
		
		
}
