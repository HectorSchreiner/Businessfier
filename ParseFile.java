import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ParseFile {

    // reads a file, and returns arraylist of files content with the correct
    // formatting
    public ArrayList<String> readFile(String fileName) throws IOException {
        ArrayList<String> fileArray = new ArrayList<String>();
        try {
            File file = new File(fileName);
            Scanner input = new Scanner(file);

            while (input.hasNextLine()) {
                String line = input.nextLine();
                fileArray.addAll(splitStringToList(line));
            }

            input.close();
        } catch (FileNotFoundException | NullPointerException e) {
            System.out.println("Error ocurred on reading the file...");
        }
        return fileArray;
    }

    // takes a given list, and converts to a string with correct formatting
    public String readList(ArrayList<String> inputList) {
        String[] symbols = { " ,", " ." };
        String[] replacements = { ",", "." };

        String listString = inputList.stream().map(Object::toString)
                .collect(Collectors.joining(" "));
        replacer(listString, symbols, replacements);

        return listString;
    }

    // given a string as input, returns it as a new arraylist, formattet correctly
    public ArrayList<String> splitStringToList(String input) {
        String[] symbols = { ",", ".", "m.", "  ", "m. " };
        String[] replacements = { " ,", " .", " ", " ", " " };
        replacer(input, symbols, replacements);

        List<String> arr = new ArrayList<String>(Arrays.asList(input.split(" ")));
        return (ArrayList<String>) arr;
    }

    private String replacer(String input, String[] symbols, String[] replacements) {
        for (int i = 0; i < symbols.length; i++) {
            input = input.replace(symbols[i], replacements[i]);
        }
        return input;
    }
}
