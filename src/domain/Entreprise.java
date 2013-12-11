package domain;

public class Entreprise extends Contact {
	private int numSiret;
	private int version;

	public int getNumSiret() {
		return numSiret;
	}

	public void setNumSiret(int numSiret) {
		this.numSiret = numSiret;
	}
}
