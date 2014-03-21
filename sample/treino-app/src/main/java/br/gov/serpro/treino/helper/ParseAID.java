package br.gov.serpro.treino.helper;

import java.util.Hashtable;

public class ParseAID {

	@SuppressWarnings("unchecked")
	public static Hashtable parseAID(String aid) {
		
		Hashtable ht = new Hashtable();		
		String[] splitName = aid.split("@");		
		ht.put("name", splitName[0].toString());
		String[] ipAux =  splitName[0].split("-");
		ht.put("ip", ipAux[1].toString());
		return ht;
		
	}
	
}
