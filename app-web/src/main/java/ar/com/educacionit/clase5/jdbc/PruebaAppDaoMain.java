package ar.com.educacionit.clase5.jdbc;

import ar.com.educacionit.dao.jdbc.ConnectionMainTest;

public class PruebaAppDaoMain {

	public static void main(String[] args) {
		try {
			ConnectionMainTest.main(args);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
