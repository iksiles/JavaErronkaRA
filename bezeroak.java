package ERRONKA;

public class bezeroak extends pertsona{
		
	String mail , kale , prtl , pisu;
	int kodpost;

	bezeroak(pertsona p, String mail, String kale, String prtl, String pisu , int kodpost) {
		super(p.getNan() , p.getIzn(), p.getAbz(), p.getTlf());
		setMail(mail);
		setKale(kale);
		setPrtl(prtl);
		setPisu(pisu);
		setKodpost(kodpost);
	}

	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getKale() {
		return kale;
	}
	public void setKale(String kale) {
		this.kale = kale;
	}
	public String getPrtl() {
		return prtl;
	}
	public void setPrtl(String prtl) {
		this.prtl = prtl;
	}
	public String getPisu() {
		return pisu;
	}
	public void setPisu(String pisu) {
		this.pisu = pisu;
	}
	public int getKodpost() {
		return kodpost;
	}
	public void setKodpost(int kodpost) {
		this.kodpost = kodpost;
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
	public int getTlf() {
		return super.tlf;
	}
	public void setTlf(int tlf) {
		super.tlf = tlf;
	}
	
	@Override
	public String toString() {
		return super.nan +" | "+super.izn+" | "+ super.abz+" | "+mail;
	}

}
