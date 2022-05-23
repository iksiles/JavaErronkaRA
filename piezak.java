package ERRONKA;

public class piezak {

	String pieza_izn;
	int pieza_kop , pieza_kod , hor_kod;
	double pieza_prz;
	
	piezak(int pieza_kod, String pieza_izn, double pieza_prz, int pieza_kop , int hor_kod) {
		setPieza_kod(pieza_kod);
		setPieza_izn(pieza_izn);
		setPieza_prz(pieza_prz);
		setPieza_kop(pieza_kop);
		setHor_kod(hor_kod);
	}

	public String getPieza_izn() {
		return pieza_izn;
	}

	public void setPieza_izn(String pieza_izn) {
		this.pieza_izn = pieza_izn;
	}

	public int getPieza_kop() {
		return pieza_kop;
	}

	public void setPieza_kop(int pieza_kop) {
		this.pieza_kop = pieza_kop;
	}

	public int getPieza_kod() {
		return pieza_kod;
	}

	public void setPieza_kod(int pieza_kod) {
		this.pieza_kod = pieza_kod;
	}

	public int getHor_kod() {
		return hor_kod;
	}

	public void setHor_kod(int hor_kod) {
		this.hor_kod = hor_kod;
	}

	public double getPieza_prz() {
		return pieza_prz;
	}

	public void setPieza_prz(double pieza_prz) {
		this.pieza_prz = pieza_prz;
	}
	
	@Override
	public String toString() {
		return "Kodea: "+pieza_kod+"  |  Izena: "+pieza_izn+"  |  Unitate prezioa: "+pieza_prz+"€  |  Stock kopurua: "+pieza_kop;
	}

}
