import java.util.ArrayList;
import java.util.Random;
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
        //System.out.println("test");
        this.businessWords = b.businessWordArray;
    }

    public void GetPlacement() {
        WordChecker checker = new WordChecker(this.Words);
        checker.CheckLength();
        this.placement = checker.needsWord;
    }

    public void Combine() {
        int counter = 0;

        for (int i = 0; i < this.placement.size(); i++) {
            System.out.println(this.placement.get(i));

            if (this.placement.get(i)) {

                Random r = new Random();
                int result = r.nextInt(100);



                //int randBusinessIndex = (int) Math.floor((this.businessWords.size() * Math.random()));
                System.out.println(businessWords.get(5));
                this.Words.add(i + counter, businessWords.get(result));
                counter++;
            }
        }

        for (var i : this.Words) {
            System.out.print(i + " ");
        }
    }
}
