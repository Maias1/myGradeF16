package myGrade;

import utilizadores.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class main {

	public static void main(String[] args) throws IOException {

		user.initUsers();
		user.initFiles();
		
		
		
		
		System.out.println("myGrade Capgemini F16 - Java 16/10/2016");
		Scanner keyboard = new Scanner(System.in);
		//		System.out.print("Nome de utilizador (Primeiro nome em letra minuscula):");
		//		String user = keyboard.next();
		//		System.out.print("Password (123 por defeito):");
		//		String pw = keyboard.next();
		//		System.out.println();

		System.out.print("Nome de utilizador (Primeiro nome em letra minuscula):");
		System.out.print("Password (123):");
		System.out.println();

		//if(User.login(user, pw)) {
		if(user.login("Maias", "123")) {
			//System.out.println("Olá " + user);
			menu1();
	
		}
		else {
			System.out.println("Login falhou reinicie o programa!");
			System.exit(0);
		}
		keyboard.close();
	}

	private static void menu1() {
		System.out.println("Por favor escolha uma opção: ");
		Scanner escolha = new Scanner(System.in);
		int nextLine = escolha.nextInt();

		System.out.println("1-Avaliar um colega");
		System.out.println("2-Minhas avaliações");
		System.out.println("3-Minha Classificação");
		System.out.println("0-Terminar programa");

		switch (nextLine) {
		case 1:

			break;
		case 2:

			break;
		case 3:

			break;
		case 0:
			System.exit(0);
			break;
		default:
			System.exit(0);
		}
	}


	private static boolean verificaHelloWorld(File teste) throws IOException {

		FileReader fr = new FileReader(teste);

		BufferedReader br = new BufferedReader(fr);

		StringBuilder sb = new StringBuilder();

		while(br.readLine()!=null) {
			sb.append(br.readLine());

		}

		System.out.println(sb.toString());
		return true;
	}
	


}
