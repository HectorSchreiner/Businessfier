import java.util.ArrayList;

public class WordCombiner {
    ArrayList<String> BWords;
    ArrayList<Boolean> placement;
    ArrayList<String> Words;
    ArrayList<String> output;

    public WordCombiner(ArrayList<String> input) {
        this.Words = input;
        GetPlacemt();

        // gets business words from businessWords clas
        BusinessWords a = new BusinessWords();
        a.GetWords();
        this.BWords = a.BWords;
    }

    public void GetPlacemt() {
        WordChecker checker = new WordChecker(this.Words);

        checker.CheckLength();
        this.placement = checker.NeedsWord;
    }

    public void Combine() {
        for (int i = 0; i < this.Words.size(); i++) {
            System.out.print(this.Words.get(i) + " ");
        }
        System.out.println("");
        for (int i = 0; i < this.placement.size(); i++) {
            System.out.print(this.placement.get(i) + " ");
        }
    }
}
