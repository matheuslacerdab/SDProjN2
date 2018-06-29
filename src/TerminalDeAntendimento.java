import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TerminalDeAntendimento {
	public static void solicitarSenha(String opcao) {
		try {
			Socket ta = new Socket("127.0.0.1", 12345);
			
			PrintStream saida = new PrintStream(ta.getOutputStream());
			
			Scanner entrada = new Scanner(ta.getInputStream());
			
			saida.println(opcao);
			String senha = entrada.nextLine();
			
			if(senha.equals("NOSENHAS")) {
				System.out.println("Não há senhas!!");
			}else {
				System.out.println("SENHA: "+ senha);
			}
			
			ta.close();
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		Scanner tc = new Scanner(System.in);
		String op;
		
		while (true) {
			System.out.println("Terminal de Atendimento");
			System.out.println("Solicitar senha?");
			System.out.println("S - Sim");
			System.out.println("N - Não");
			op = tc.nextLine();
			
			switch (op) {
			case "S":
				solicitarSenha("SIM");
				break;

			case "N":
				break;
				
			default:
				System.out.println("Selecione uma opção válida.");
				break;
			}
			
		}
	}

}
