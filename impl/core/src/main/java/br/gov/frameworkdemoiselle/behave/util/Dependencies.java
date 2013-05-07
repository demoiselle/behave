package br.gov.frameworkdemoiselle.behave.util;

import java.util.Hashtable;
import java.util.ServiceLoader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe respónsável por utilizer a especificação SPI para encontrar os PARSERS e RUNNERS 
 * disponíveis. Ele guarda os objetos em um hashtable para que o objeto não seja instânciado 
 * em toda da a chamada. 
 * 
 * @author SERPRO
 *
 */
public class Dependencies {

	private Hashtable<String, Object> singletons = new Hashtable<String, Object>();
	private static Dependencies instance;

	private Logger logger = Logger.getLogger(this.toString());

	private Dependencies() {
	}

	public static Dependencies getInstance() {
		if (instance == null)
			instance = new Dependencies();
		return instance;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Object getInstanceDependecy(Class clazz) {

		if (singletons.containsKey(clazz.toString())) {
			logger.log(Level.INFO,
					"Recuperada do singleton a classe " + clazz.toString());

			return singletons.get(clazz.toString());
		} else {
			ServiceLoader<Object> service = ServiceLoader.load(clazz);
			int count = 0;
			
			for (Object object : service) {
				if (count > 0)
					throw new RuntimeException("Só pode existir 1 classe "
							+ clazz.toString()
							+ " selecionado no pom.xml como dependência.");

				logger.log(Level.INFO, "Instânciada a classe " + object.getClass().toString());
				
				singletons.put(clazz.toString(), object);

				count++;
			}

			if (!singletons.containsKey(clazz.toString()))
				throw new RuntimeException(
						"Não foram encontradas classes que implementem "
								+ clazz.toString() + ".");

			return singletons.get(clazz.toString());
		}

	}

}
