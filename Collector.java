import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Collectors;

public class Collector {

    // takes userinput from inputfield (in GUI)
    // fileName er ordlisten
    public String Collect(String userInput, String fileName) {
        ParseFile parser = new ParseFile();
        ArrayList<String> wordList = new ArrayList<>();
        ArrayList<Boolean> placementList = new ArrayList<>();

        // der manipuleres med userinputlist, så det er også den vi returnerer
        ArrayList<String> userInputList = parser.splitStringToList(userInput);

        // gets list of words, from a txt file
        try {
            wordList = parser.readFile(fileName);
        } catch (IOException e) {
            System.out.println("Hovsa, noget gik galt!");
        }

        assert (placementList.size() == userInputList.size());

        // kalder Algoritmen og returnerer placement listen. Til hvor ord skal skiftes
        placementList = Algoritm(userInputList, placementList);

        // tilføjer random ord fra wordlist til userinputlist hvis
        for (int i = 0, j = 0; i < placementList.size(); i++) {
            if (placementList.get(i)) {
                userInputList.add(i + j, GetRandWord(wordList));
                j += 1;
            }
        }

        return parser.readList(userInputList);
    }

    private String GetRandWord(ArrayList<String> list) {
        Random rand = new Random();
        String randWord = list.get(rand.nextInt(list.size()));
        return randWord;
    }

    // hvis userInputList ord er længere end 5 characters, skal der et businessord
    private ArrayList<Boolean> Algoritm(ArrayList<String> userInputList, ArrayList<Boolean> placementList) {
        for (var item : userInputList) {
            Boolean val = item.length() >= 5 ? true : false;
            placementList.add(val);
        }
        return placementList;
    }
}
