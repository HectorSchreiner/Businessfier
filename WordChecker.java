import java.util.ArrayList;

public class WordChecker {
    ArrayList<String> Words;
    ArrayList<Boolean> NeedsWord;

    public WordChecker(ArrayList<String> input) {
        this.Words = input;
        this.NeedsWord = new ArrayList<Boolean>();
    }

    // fills the input list with words, only used for debugging
    public void FillWords() {
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                this.Words.set(i, "teststring");
            } else {
                this.Words.set(i, "test");
            }

        }
    }

    // chesks wether or not a word has more than five caracters
    public void CheckLength() {
        for (int i = 0; i < this.Words.size(); i++) {
            if (this.Words.get(i).length() > 5) {
                this.NeedsWord.add(true);
            } else {
                this.NeedsWord.add(false);
            }
        }
    }
}