import java.util.ArrayList;

public class WordChecker {
    String[] Words;
    ArrayList<Boolean> NeedsWord;

    public WordChecker(String[] in){
        Words = in;
        NeedsWord = new ArrayList<Boolean>();
    }

    //fills the input list with words, only used for debugging
    public void FillWords() {
        for (int i = 0; i <10; i++) {
            if(i%2==0){
                Words[i] = "teststring";
            } else {
                Words[i] = "test";
            }
        System.out.println(Words[i]);
        }
    }
    
    //chesks wether or not a word has more than five caretors
    public void CheckLength() {
        for(int i = 0; i<Words.length;i++){
            if(Words[i].length()>5){
                NeedsWord.add(true);
            } else {
                NeedsWord.add(false);
            }
        System.out.println(NeedsWord.get(i));
        }
    }
}