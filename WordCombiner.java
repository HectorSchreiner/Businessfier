import java.net.SocketImplFactory;
import java.util.ArrayList;

public class WordCombiner {
    ArrayList<String> businessWords;
    ArrayList<Boolean> placement;
    ArrayList<String> words;
    ArrayList<String> output;

    public WordCombiner(ArrayList<String> input) {
        this.words = input;
        GetPlacement();

        // gets business words from businessWords clas
        BusinessWords a = new BusinessWords();
        a.GetWords();
        this.businessWords = a.BWords;
    }

    public void GetPlacement() {
        WordChecker checker = new WordChecker(this.words);

        checker.CheckLength();
        this.placement = checker.needsWord;
    }

    public void Combine() {
        for (int i = 0; i < this.words.size(); i++) {
            System.out.print(this.words.get(i) + " ");
        }

        for (int i = 0; i < this.placement.size(); i++) {
            System.out.print(this.placement.get(i) + " ");
        }

        for (int i = 0; i < this.words.size(); i++) {

        }
    }
}
