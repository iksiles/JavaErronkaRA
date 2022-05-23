package ERRONKA;

public class hornitzaileak {
	
	String hor_izn , hor_helb;
	int hor_kod;
	
	hornitzaileak(int hor_kod , String hor_izn,  String hor_helb) {
		setHor_kod(hor_kod);
		setHor_izn(hor_izn);
		setHor_helb(hor_helb);
	}

	public String getHor_izn() {
		return hor_izn;
	}

	public void setHor_izn(String hor_izn) {
		this.hor_izn = hor_izn;
	}

	public String getHor_helb() {
		return hor_helb;
	}

	public void setHor_helb(String hor_helb) {
		this.hor_helb = hor_helb;
	}

	public int getHor_kod() {
		return hor_kod;
	}

	public void setHor_kod(int hor_kod) {
		this.hor_kod = hor_kod;
	}

	@Override
	public String toString() {
		return "Kodea: "+hor_kod+"  |  Izena: "+hor_izn+"  |  Helbidea: "+hor_helb;
	}

}
