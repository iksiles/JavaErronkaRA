package ERRONKA;

import java.io.*;

public class pertsona {

	public static Object textNanLan;
	String nan, izn, abz;
	int tlf;
	
	pertsona(String nan, String izn, String abz, int tlf){
		setNan(nan);
		setIzn(izn);
		setAbz(abz);
		setTlf(tlf);
	}
	
	public String getNan() {
		return nan;
	}
	public void setNan(String nan) {
		this.nan = nan;
	}
	public String getIzn() {
		return izn;
	}
	public void setIzn(String izn) {
		this.izn = izn;
	}
	public String getAbz() {
		return abz;
	}
	public void setAbz(String abz) {
		this.abz = abz;
	}
	
	public int getTlf() {
		return tlf;
	}
	public void setTlf(int tlf) {
		this.tlf = tlf;
	}
}
