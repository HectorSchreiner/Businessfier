import java.io.*;

public class SaveSystem {
	
	private static String fileName = "SavedFile.txt";
	
	public static void write(String text) throws IOException{
		FileWriter file = new FileWriter(fileName);
		PrintWriter out = new PrintWriter(file);
		
		out.print(text);
		out.close();
		System.out.println("Text saved to: " + fileName);
	}
}
