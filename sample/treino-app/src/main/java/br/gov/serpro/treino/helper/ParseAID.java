package br.gov.serpro.treino.helper;

import java.util.Hashtable;

public class ParseAID {

	public static Hashtable<String, String> parseAID(String aid) {
		
		Hashtable<String, String> ht = new Hashtable<String, String>();		
		String[] splitName = aid.split("@");		
		ht.put("name", splitName[0].toString());
		String[] ipAux =  splitName[0].split("-");
		ht.put("ip", ipAux[1].toString());
		return ht;
		
	}
	
}
