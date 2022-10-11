import java.util.ArrayList;

public class WordChecker {
    ArrayList<String> words;
    ArrayList<Boolean> needsWord;

    public WordChecker(ArrayList<String> input) {
        this.words = input;
        this.needsWord = new ArrayList<Boolean>();
    }

    // fills the input list with words, only used for debugging
    public void FillWords() {
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                this.words.set(i, "teststring");
            } else {
                this.words.set(i, "test");
            }

        }
    }

    // chesks wether or not a word has more than five caracters
    public void CheckLength() {
        for (int i = 0; i < this.words.size(); i++) {
            if (this.words.get(i).length() > 5) {
                this.needsWord.add(true);
            } else {
                this.needsWord.add(false);
            }
        }
    }
}