import java.io.IOException;
import java.util.ArrayList;

public class BusinessWords {
    ArrayList<String> businessWordArray = new ArrayList<String>();

    public void GetWords() throws IOException {
        ParseFile parser = new ParseFile();
        this.businessWordArray = parser.readFile("BusinessWords.txt");
    }

}
