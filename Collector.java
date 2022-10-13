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

        // programmet skal crashe hvis de to ikke har samme størrelse
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

    private ArrayList<Boolean> Algoritm(ArrayList<String> userInputList, ArrayList<Boolean> placementList) {
        int lengthLimit = 11;
        ParseFile parser = new ParseFile();

        // hvis der er et adjektiv skal der sættes endnu et foran
        try {
            ArrayList<String> adjektiver = parser.readFile("Adjektiver.txt");
            ArrayList<String> nouns = parser.readFile("EnglishNouns.txt");

            for (int i = 0; i < userInputList.size(); i++) {
                for (var adjektiv : adjektiver) {
                    if (userInputList.get(i).equals(adjektiv)) {
                        placementList.add(i, true);
                    }
                }
            }
            for (int i = 0; i < userInputList.size(); i++) {
                for (var noun : nouns) {
                    if (userInputList.get(i).equals(noun)) {
                        placementList.add(i, true);
                    }
                }
            }
        } catch (Exception e) {
        }

        // hvis userInputList ord er længere end 5 characters, skal der et businessord
        for (var item : userInputList) {
            Boolean val = item.length() >= lengthLimit ? true : false;
            placementList.add(val);
        }

        return placementList;
    }
}
