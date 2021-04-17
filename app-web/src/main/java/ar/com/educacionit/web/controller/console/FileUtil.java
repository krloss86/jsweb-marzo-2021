package ar.com.educacionit.web.controller.console;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public final class FileUtil {

	public final static void copyFile(File source, File target) throws IOException {
		FileInputStream fin = null;
		FileOutputStream fout = null;
		try {
			// create FileInputStream object for source file
			fin = new FileInputStream(source);
	
			// create FileOutputStream object for destination file
			fout = new FileOutputStream(target);
	
			byte[] b = new byte[1024];
			int noOfBytes = 0;
	
			System.out.println("Copying file using streams");
	
			// read bytes from source file and write to destination file
			while ((noOfBytes = fin.read(b)) > 0) {
				fout.write(b, 0, noOfBytes);
			}		
		}finally{
			fin.close();
			fout.close();
		}
	}
}
