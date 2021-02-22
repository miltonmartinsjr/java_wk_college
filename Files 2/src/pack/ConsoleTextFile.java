package pack;


import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ConsoleTextFile {

	public static void main(String[] args) throws IOException {		
		
		Scanner sc = new Scanner(System.in);
		PrintWriter w =new PrintWriter (new FileWriter("mytext.txt"));
		System.out.println(" Entrez un text (pour finir entrez une line avec 00):");		
		String  ligne = sc.nextLine(); 
		while (!ligne.equals("00")) {
			w.println(ligne);
			ligne = sc.nextLine(); 
			
		}	
		System.out.println("Bye.");
		w.close();
		sc.close();
	}

}
