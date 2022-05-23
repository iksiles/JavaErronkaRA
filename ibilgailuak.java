package ERRONKA;

public class ibilgailuak {
	
	String bast_znbk , matrikula , marka , modeloa , bez_nan;
	
	ibilgailuak(String bast_znbk , String matrikula , String marka , String modeloa , String bez_nan){
		setBast_znbk(bast_znbk);
		setMatrikula(matrikula);
		setMarka(marka);
		setModeloa(modeloa);
		setBez_nan(bez_nan);
	}

	public String getBast_znbk() {
		return bast_znbk;
	}

	public void setBast_znbk(String bast_znbk) {
		this.bast_znbk = bast_znbk;
	}

	public String getMatrikula() {
		return matrikula;
	}

	public void setMatrikula(String matrikula) {
		this.matrikula = matrikula;
	}

	public String getMarka() {
		return marka;
	}

	public void setMarka(String marka) {
		this.marka = marka;
	}

	public String getModeloa() {
		return modeloa;
	}

	public void setModeloa(String modeloa) {
		this.modeloa = modeloa;
	}

	public String getBez_nan() {
		return bez_nan;
	}

	public void setBez_nan(String bez_nan) {
		this.bez_nan = bez_nan;
	}

	@Override
	public String toString() {
		return "Bastidore zenbakia: "+bast_znbk+"  |  Matrikula: "+matrikula+" |  Autoa: "+ marka+" "+modeloa+"  |  Jabea: "+bez_nan;
	}
}
