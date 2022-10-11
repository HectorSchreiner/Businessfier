import java.io.*;

public class SaveSystem {
	public static void write(String text, String fileName) throws IOException{
		FileWriter file = new FileWriter(fileName);
		PrintWriter out = new PrintWriter(file);
		out.close();
		System.out.println("Text saved to: " + fileName);
	}
}
