import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

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

    // får et random
    private String GetRandWord(ArrayList<String> list) {
        Random rand = new Random();
        String randWord = list.get(rand.nextInt(list.size()));
        return randWord;
    }

    private ArrayList<Boolean> Algoritm(ArrayList<String> userInputList, ArrayList<Boolean> placementList) {

        int lengthLimit = 7;
        ParseFile parser = new ParseFile();

        // hvis der er et ord fra en af de nedenstående filer, skal der sættes endnu et
        // foran!
        try {
            ArrayList<String> adjektiver = parser.readFile("Adjektiver.txt");
            ArrayList<String> nouns = parser.readFile("EnglishNouns.txt");
            ArrayList<String> workRelatedWord = parser.readFile("WorkRelatedWords.txt");

            placementList = addIf(addToPlacementList(userInputList, adjektiver, placementList), placementList);
            placementList = addIf(addToPlacementList(userInputList, nouns, placementList), placementList);
            placementList = addIf(addToPlacementList(userInputList, workRelatedWord, placementList), placementList);

        } catch (Exception e) {
        }

        // hvis userInputList ord er længere end lenghtlimit characters, skal der et
        // businessord ind.
        for (var item : userInputList) {
            Boolean val = item.length() >= lengthLimit ? true : false;
            placementList.add(val);
        }
        return placementList;
    }

    // sætter ord fra den givne liste ind.
    private ArrayList<Boolean> addToPlacementList(ArrayList<String> userInputList, ArrayList<String> wordList,
            ArrayList<Boolean> placementList) {
        for (int i = 0; i < userInputList.size(); i++) {
            for (var word : wordList) {
                if (userInputList.get(i).equals(word)) {
                    placementList.add(i, true);
                }
            }
        }
        return placementList;
    }

    // hvis placementlist ikke er true når algoritmen siger den skal, skal den
    // ændres til true!
    private ArrayList<Boolean> addIf(ArrayList<Boolean> list, ArrayList<Boolean> outputList) {
        for (int i = 0; i < outputList.size(); i++) {
            if (list.get(i) && outputList.get(i)) {
                outputList.set(i, true);
            }

        }
        return outputList;
    }
}
