import java.util.ArrayList;
import java.io.IOException;
import java.lang.Math;

public class WordCombiner {
    ArrayList<String> businessWords;
    ArrayList<Boolean> placement;
    ArrayList<String> Words;

    public WordCombiner(String fileName) throws IOException {
        ParseFile parser = new ParseFile();
        parser.readFile(fileName);
        this.Words = parser.FileArray;
        GetPlacement();

        // gets business words from businessWords clas
        BusinessWords b = new BusinessWords();
        b.GetWords();
        this.businessWords = b.businessWordArray;
    }

    public void GetPlacement() {
        WordChecker checker = new WordChecker(this.Words);
        checker.CheckLength();
        this.placement = checker.needsWord;
    }

    public void Combine() {
        for (int i = 0; i < this.Words.size(); i++) {
            System.out.print(this.Words.get(i) + " ");
        }

        for (int i = 0; i < this.placement.size(); i++) {
            System.out.println(this.placement.get(i));

            if (this.placement.get(i)) {
                int randBusinessIndex = (int) Math.floor((this.businessWords.size() * Math.random()));
                System.out.println(randBusinessIndex);
                this.Words.add(i + counter, businessWords.get(randBusinessIndex));
                counter++;
            }
        }

        for (int i = 0; i < this.words.length; i++) {

        }

    }
}
