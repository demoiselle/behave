package br.gov.frameworkdemoiselle.behave.runner.ui.base;

import java.util.ArrayList;
import java.util.List;

public enum StateUI {

	PRESENT("Present"), ABSENT("Absent"), VISIBLE("Visible"), INVISIBLE("Invisible"), EDITABLE("Editable"), NOTEDITABLE("Not Editable"), ENABLE("Enable"), DISABLE("Disable"), OTHER("Other");

	private String text;

	StateUI(String text) {
		this.text = text;
	}

	public String getText() {
		return this.text;
	}

	public static StateUI fromString(String text) {
		StateUI state = null;
		if (text != null) {
			for (StateUI e : StateUI.values()) {
				if (text.equalsIgnoreCase(e.text)) {
					state = e;
				}
			}
		}
		if (state == null) {
			throw new RuntimeException("Estado '" + text + "' não encontrado na lista: " + StateUI.listar());
		}
		return state;
	}

	public static String listar() {
		List<String> lista = new ArrayList<String>();
		for (StateUI e : StateUI.values()) {
			lista.add(e.text);
		}
		return lista.toString();
	}

}
