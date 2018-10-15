
public class Deposito {

	private int p;
	private int s;

	public Deposito(int s, int p) {
		this.s=s;
		this.p=p;
	}


	public int getCantidadMax() {
		return this.p*this.s;
	}
	public int getP() {
		return this.p;
	}
	
	public int getCantidadVPorP(int pa) {
		return (pa<this.p)?this.s:0;
	}

}
