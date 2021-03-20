package ar.com.educacionit.interfaces.main;

import ar.com.educacionit.interfaces.ILogger;
import ar.com.educacionit.interfaces.impl.EmailLogger;
import ar.com.educacionit.interfaces.impl.HDLogger;

public class ILoggerFactory {

	public static ILogger[] buildLogger(String dest, String msj) {
		
		//ahora creo un vector de interfaces
		EmailLogger emailLogger = new EmailLogger(dest, msj);
		//emailLogger.log();
		
		HDLogger hdLogger = new HDLogger("c:/logs", "aprendiendo interfaces en java");
		//hdLogger.log();
		
		ILogger[] loggers = new ILogger[2]; 
		loggers[0] = emailLogger;
		loggers[1] = hdLogger;
		
		return loggers;
	}
}
