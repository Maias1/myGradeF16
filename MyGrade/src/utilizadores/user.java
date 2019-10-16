package utilizadores;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class user {
	static String dono = "hgaspar";
	//static String dono = "gaandrad";
	
	static ArrayList<String> userNames = new ArrayList<String>();
	static ArrayList<user> userList = new ArrayList<user>();
	String nColaborador;
	String nome;
	String email;
	String pw;
	int myGrade;
	String myFilePath;

	public user(String nColaborador, String pw) {
		this.nome = nColaborador;
		this.pw = pw;
	}
	
	public user(String nColaborador, String nome, String email, String pw, int grade) {
		this.nColaborador = nColaborador;
		this.nome = nome;
		this.email = email;
		this.pw = pw;
		this.myGrade = grade;
	}

	public static boolean login(String numero, String pw) {
		user novo = new user(numero, pw);
		
		for (user registados : userList) {
			if(novo.nome.equals(registados.nome))
				if(novo.pw.equals(registados.pw))
					return true;
				else {
					System.out.println("pw errada!");
					return false;
				}
			else {
				System.out.println("Numero errado!");
				return false;
			}	
		}
		return false;
	}

	public static ArrayList<String> initUsers() {
		File ficheiroUsers = new File("C:\\Users\\" + dono + "\\git\\myGradeF16\\MyGrade\\usersDB.txt");
		ArrayList<String> conteudo = new ArrayList<String>();
		
		StringBuilder sb = new StringBuilder();
	    try (BufferedReader br = new BufferedReader(new FileReader(ficheiroUsers)))
	    {
	    	
	        String sCurrentLine;
	        while ((sCurrentLine = br.readLine()) != null)
	        {
	            sb.append(conteudo).append("\n");
	        }
	    }
	    catch (IOException e)
	    {
	        e.printStackTrace();
	    }
		
//0 numero
	    //1 - Nome
	    //2- Email
		for (String string : conteudo) {
			String[] parts = string.split("#");
			user utilizador = new user(parts[0], "123");
			userList.add(utilizador);
			//System.out.println(string);
		}
		
		for (int i = 0; i < userList.size(); i++) {
			userNames.add(userList.get(i).getNome());
		}
		System.out.println("MyGrade - Users carregados!");
		return userNames;
	}

	public static void initFiles() throws IOException {
		
		new File("C:\\Users\\" + dono + "\\git\\myGradeF16\\users").mkdir();
		for (String nColaborador : userNames) {
			
			new File("C:\\Users\\" + dono + "\\git\\myGradeF16\\users\\" + nColaborador).mkdir();
			File ficheiroUsers = new File("C:\\Users\\" + dono + "\\git\\myGradeF16\\users\\" + nColaborador +"\\avaliacaoUsers.txt");
			
			ficheiroUsers.createNewFile();
			PrintWriter printW = new PrintWriter (ficheiroUsers);
			for (String string2 : userNames) {
				printW.println(string2 + "-");
			} 
			
			printW.close( );
		
		}

		
	}
	public String getNome() {
		return nome;
	}


	
}
