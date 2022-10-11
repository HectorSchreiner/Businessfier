import java.util.ArrayList;

public class WordCombiner {
    ArrayList<String> BWords;
    ArrayList<Boolean> placement;
    ArrayList<String> Words;
    ArrayList<String> output;

    public WordCombiner(ArrayList<String> input){
        Words = input;

        GetPlacemt();


        //gets business words from businessWords clas
        BusinessWords a = new BusinessWords();
        a.GetWords();
        BWords = a.BWords;
 
        
    }
    
    public void GetPlacemt() {
        WordChecker x = new WordChecker(Words);
        x.CheckLength();
        placement = x.NeedsWord;
    }

    public void Combine() {
        for (int i = 0; i < Words.size(); i++) {
            System.out.println(Words.get(i));
        }

        for (int i = 0; i < placement.size(); i++) {
            System.out.println(placement.get(i));
        }
    }
}
