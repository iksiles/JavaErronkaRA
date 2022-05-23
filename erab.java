package ERRONKA;

import java.io.*;

public class erab extends pertsona implements Serializable {
	
	protected String erab, pass;
	String dpt, sdt;
	
	erab (String izn, String abz, String nan, int tlf, String erab , String pass, String dpt, String sdt) {
		super(izn, abz, nan, tlf);
		this.erab = erab;
		this.pass = pass;
		this.dpt = dpt;
		this.sdt = sdt;
	}
}
