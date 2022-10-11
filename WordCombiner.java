import java.util.ArrayList;
import java.lang.Math;  

public class WordCombiner {
    ArrayList<String> BWords;
    ArrayList<Boolean> placement;
    ArrayList<String> Words;

    public WordCombiner(ArrayList<String> input) {
        this.Words = input;
        GetPlacement();

        // gets business words from businessWords clas
        BusinessWords a = new BusinessWords();
        a.GetWords();
        this.BWords = a.BWords;
    }

    public void GetPlacement() {
        WordChecker checker = new WordChecker(this.Words);

        checker.CheckLength();

        this.placement = checker.NeedsWord;
    }

    public void Combine() {
<<<<<<< HEAD

        for (int i = 0; i < this.placement.size(); i++) {
            if(this.placement.get(i)){

                
                int index = (int) Math.floor((this.BWords.size()*Math.random()));

                this.Words.add(i, BWords.get(index));
            }
        }

        for (var i : this.Words) {
            System.out.print(i+" ");
=======
        for (int i = 0; i < this.Words.size(); i++) {
            System.out.print(this.Words.get(i) + " ");
        }

        for (int i = 0; i < this.placement.size(); i++) {

            System.out.print(this.placement.get(i) + " ");
        }

        for (int i = 0; i < this.Words.size(); i++) {

>>>>>>> 0dcc1c6b9c120c97cd83a042b8e23aefd220bd8d
        }
    }
}
