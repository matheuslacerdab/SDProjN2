import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TV {
	public static void main(String[] args) {
		String resp = null;
		int op;
		
		Scanner tc = new Scanner(System.in);
		
		while(true) {
			op = tc.nextInt();
			switch (op) {
			case 1:
				try {
					Socket tv = new Socket("127.0.0.1", 12345);
					
						PrintStream saida = new PrintStream(tv.getOutputStream());
						saida.println("TV");
						
						Scanner entrada = new Scanner(tv.getInputStream());
						
						if(entrada.hasNextLine()) {
							resp = entrada.nextLine();
							System.out.println("SENHA: " + resp);
						}
					
				} catch (UnknownHostException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				break;
				
			}
				
				
			}
		}
		
}

