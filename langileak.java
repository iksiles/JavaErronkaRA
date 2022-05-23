package ERRONKA;

public class langileak extends pertsona{
	
	int dpto_znbk;
	
	langileak(pertsona p , int dpto_znbk) {
		super(p.getNan() , p.getIzn(), p.getAbz(), p.getTlf());
		setDpto_znbk(dpto_znbk);
	}
	
	public int getDpto_znbk() {
		return dpto_znbk;
	}
	
	public void setDpto_znbk(int dpto_znbk) {
		this.dpto_znbk = dpto_znbk;
	}

	public String getIzn() {
		return super.izn;
	}
	public void setIzn(String izn) {
		super.izn = izn;
	}
	public String getAbz() {
		return super.abz;
	}
	public void setAbz(String abz) {
		super.abz = abz;
	}
	public String getNan() {
		return super.nan;
	}
	public void setNan(String nan) {
		super.nan = nan;
	}
	
	@Override
	public String toString() {
		return super.nan +" | "+ super.izn+" | "+ super.abz+" | "+dpto_znbk;
	}
}
