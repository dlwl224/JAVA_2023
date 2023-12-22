import java.io.FileInputStream;
import java.io.FileOutputStream;

public class XorEnc {
	static byte[] key= {10,20,30,40};

	public static void main(String[] args) throws Exception {
		FileInputStream is= new FileInputStream("test1.txt");
		FileOutputStream os=new FileOutputStream("test1.enc");
		
		byte[] data= new byte[1024];
		int read=is.read(data);
		int index=0;
		while(read !=-1) {
			for(int k=0;k<read;k++) {
				data[k]^=key[index%key.length];
				index++;
			}
			os.write(data,0,read);
			read=is.read(data);
		}
		os.flush();
		os.close();
		is.close();
		

	}

}
