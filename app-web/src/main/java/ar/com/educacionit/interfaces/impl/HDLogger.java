package ar.com.educacionit.interfaces.impl;

import ar.com.educacionit.interfaces.ILogger;

public class HDLogger implements ILogger {

	//path
	private String path;
	private String msj;
	
	//contructor
	public HDLogger(String path, String msj) {
		this.path = path;
		this.msj = msj;
	}
	
	public void log() {
		System.out.println("Grabando log en disco...." + this.path);
		System.out.println("grando.." + this.msj);
		System.out.println("se ha grabado exitosamente");
	}

	public void setPath(String path) {
		this.path = path;
	}

	public void setMsj(String msj) {
		this.msj = msj;
	}
	
}
