package ar.com.educacionit.web.controller.console;

import java.io.File;
import java.io.IOException;

public class CopyBinaryMain {

	public static void main(String[] args) throws IOException {

		String fileName = "C:\\Desarrollo\\educacionit\\files\\nuevos-productos.xlsx";

		File source = new File(fileName);

		String fileTargetName = "C:\\Desarrollo\\educacionit\\files\\nuevos-productos-v1.xls";

		File target = new File(fileTargetName);

		FileUtil.copyFile(source, target);

		System.out.println(fileName + " se ha copiado en :");
		System.out.println(fileTargetName);
	}

}
