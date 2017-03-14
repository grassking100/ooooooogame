import java.io.BufferedReader;
import java.io.InputStreamReader;

public class A01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		try {
			while(true){
				String s=in.readLine();
				if(s==null)break;
				System.out.println("hello, "+s);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
	}

}