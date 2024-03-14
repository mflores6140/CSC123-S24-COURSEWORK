package labs;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class MyFile {
	
	File f = null;
	
	public MyFile(String fileName) throws IOException {
		File f = new File(fileName);
		if (!f.exists()) {
			System.out.println("File does not exist!");
			System.exit(0);
		}
		
		if (!f.isFile()) {
			System.out.println("Not a file!!");
			System.exit(0);
		}
		
		if (!f.canRead()) {
			System.out.println("Can't read file!!");
			System.exit(0);
		}
		
		this.f = f;
		
	}
	
	public String toString() {
		try {
		InputStream in=new FileInputStream(f);
		
		int i;

		
		while((i=in.read())!=-1) {
            System.out.print((char)i);
        }
		
	    in.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return "";
	}

	
}
