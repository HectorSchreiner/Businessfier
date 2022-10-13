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

        // der manipuleres med userinputlist. Det er også den vi returnerer
        ArrayList<String> userInputList = parser.splitStringToList(userInput);

        // gets list of words, from a txt file
        try {
            wordList = parser.readFile(fileName);
        } catch (IOException e) {
            System.out.println("Hovsa, noget gik galt!");
        }

        // kalder Algoritmen og returnerer placement listen. Til hvor ord skal skiftes
        placementList = Algoritm(userInputList, placementList);

        // tilføjer random ord fra wordlist til userinputlist hvis
        for (int i = 0, j = 0; i < placementList.size(); i++) {
            if (placementList.get(i)) {
                userInputList.add(i + j, GetRandWord(wordList));
                j += 1;
            }
        }
        return parser.listToString(userInputList);
    }

    private String GetRandWord(ArrayList<String> list) {
        Random rand = new Random();
        String randWord = list.get(rand.nextInt(list.size()));
        return randWord;
    }

    private ArrayList<Boolean> Algoritm(ArrayList<String> userInputList, ArrayList<Boolean> placementList) {

        int lengthLimit = 7;
        ParseFile parser = new ParseFile();

        // hvis der er et adjektiv skal der sættes endnu et foran
        try {
            ArrayList<String> adjektiver = parser.readFile("Adjektiver.txt");
            ArrayList<String> nouns = parser.readFile("EnglishNouns.txt");
            ArrayList<String> workWord = parser.readFile("WorkRelatedWords.txt");

            addToPlacementList(userInputList, adjektiver, placementList);
            addToPlacementList(userInputList, nouns, placementList);
            addToPlacementList(userInputList, workWord, placementList);

        } catch (Exception e) {
        }

        // hvis userInputList ord er længere end 5 characters, skal der et businessord
        for (var item : userInputList) {
            Boolean val = item.length() >= lengthLimit ? true : false;
            placementList.add(val);
        }
        return placementList;
    }

    private void addToPlacementList(ArrayList<String> userInputList, ArrayList<String> wordList,
            ArrayList<Boolean> placementList) {
        for (int i = 0; i < userInputList.size(); i++) {
            for (var word : wordList) {
                if (userInputList.get(i).equals(word)) {
                    placementList.add(i, true);
                }
            }
        }
    }
}
