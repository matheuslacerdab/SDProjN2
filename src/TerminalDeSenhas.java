import java.io.IOException;
import java.io.PrintStream;
import java.net.*;
import java.util.Scanner;

public class TerminalDeSenhas {
	
	public static void gerarSenha(String senha) {
		try {
			Socket ts = new Socket("127.0.0.1", 12345);
			
			PrintStream saida = new PrintStream(ts.getOutputStream());
			saida.println(senha);
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args){
		
		Scanner tc = new Scanner(System.in);
		int op, normal = 0, priori = 0;
		
		while(true) {
			System.out.println("Terminal de Senhas");
			System.out.println("Selecione uma opção:");
			System.out.println("1 - Senha Normal");
			System.out.println("2 - Senha Prioritária");
			op = tc.nextInt();
			
			switch (op) {
			case 1:
				normal = normal + 1;
				gerarSenha("N"+normal);
				
				break;
	
			case 2:
				priori = priori + 1;
				gerarSenha("P"+priori);
				
				break;
				
			default:
				System.out.println("Selecione uma opção válida.");
				break;
			}
		
		
		}
	}

}
