package ERRONKA;

public class faktura {
	
	int fak_id;
	double prezioa;
	String data, fitxizn, bez_nan, lan_nan, amai;
	
	faktura (int fak_id , double prezioa , String data , String fitxizn , String bez_nan , String lan_nan , String amai){
		setFak_id(fak_id);
		setPrezioa(prezioa);
		setData(data);
		setFitxizn(fitxizn);
		setBez_nan(bez_nan);
		setLan_nan(lan_nan);
		setAmai(amai);
	}

	public int getFak_id() {
		return fak_id;
	}

	public void setFak_id(int fak_id) {
		this.fak_id = fak_id;
	}

	public double getPrezioa() {
		return prezioa;
	}

	public void setPrezioa(double prezioa) {
		this.prezioa = prezioa;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getFitxizn() {
		return fitxizn;
	}

	public void setFitxizn(String fitxizn) {
		this.fitxizn = fitxizn;
	}

	public String getBez_nan() {
		return bez_nan;
	}

	public void setBez_nan(String bez_nan) {
		this.bez_nan = bez_nan;
	}

	public String getLan_nan() {
		return lan_nan;
	}

	public void setLan_nan(String lan_nan) {
		this.lan_nan = lan_nan;
	}

	public String getAmai() {
		return amai;
	}

	public void setAmai(String amai) {
		this.amai = amai;
	}

	@Override
	public String toString() {
		return "ID: "+fak_id+" | "+data+" | Fitxategi izena: "+fitxizn+" | Prezioa: "+prezioa+" | Bez_nan: "+bez_nan;
	}
}
