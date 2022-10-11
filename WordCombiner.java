import java.util.ArrayList;
import java.lang.Math;  

public class WordCombiner {
    ArrayList<String> businessWords;
    ArrayList<Boolean> placement;
    ArrayList<String> Words;

    public WordCombiner(ArrayList<String> input) {
        this.Words = input;
        GetPlacement();

        // gets business words from businessWords clas
        BusinessWords a = new BusinessWords();
        a.GetWords();
        this.businessWords = a.BWords;
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
            if(this.placement.get(i)){
                
                
                int randBusinessIndex = (int) Math.floor((this.businessWords.size()*Math.random()));

                this.Words.add(i+counter, businessWords.get(randBusinessIndex));
                counter++;
            }
        }

        for (var i : this.Words) {
            System.out.print(i+" ");
        }
    }
}
