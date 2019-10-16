package utilizadores;

import java.util.ArrayList;

public class user {
	static ArrayList<user> userList = new ArrayList<user>();
	String nome;
	String pw;
	int myGrade;
	String myFilePath;

	public user(String user, String pw) {
		this.nome = user;
		this.pw = pw;
	}
	
	public user(String user, String pw, int grade) {
		this.nome = user;
		this.pw = pw;
		this.myGrade = grade;
	}

	public static boolean login(String user, String pw) {
		user novo = new user(user, pw);
		
		for (user registados : userList) {
			if(novo.nome.equals(registados.nome))
				if(novo.pw.equals(registados.pw))
					return true;
				else {
					System.out.println("pw errada!");
					return false;
				}
			else {
				System.out.println("Nome não consta!");
				return false;
			}	
		}
		return false;
	}

	public static void initUsers() {
		String[] nomes = {"Maias", "Gabi", "Marcelo", "Andre"}; 

		for (String string : nomes) {
			user utilizador = new user(string.toString(), "123", 0);
			userList.add(utilizador);
			//System.out.println(string);
		}

		System.out.println("MyGrade - Users carregados!");
	}

	public static void initFiles() {
		// TODO Auto-generated method stub
		
	}
}
