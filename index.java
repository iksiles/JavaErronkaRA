package ERRONKA;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class index {
	
//loginmain ireki eta programari hasiera eman
	public static void main(String[] args){
		erabZerrenda();
		new login();
		   login loginframe = new login();
		   loginframe.setBounds(0,0,900,550);
		   loginframe.setVisible(true);
		   loginframe.setResizable(false);
		   loginframe.setLocationRelativeTo(null);
	}
	
//arraylista sortu
	public static ArrayList<erab> erabAL = new ArrayList<erab>();
		
	public static void erabZerrenda() {
		erabAL.add(new erab("Admin", "Admin", "0000000Z", 000000000, "admin", "admin", "Administrazioa", "00/00/0000")) ;
	}
}
