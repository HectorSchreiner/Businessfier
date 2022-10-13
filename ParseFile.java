import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ParseFile {
    ArrayList<String> FileArray = new ArrayList<String>();

    public void readFile(String fileName) throws IOException {
        try {
            File file = new File(fileName);
            Scanner input = new Scanner(file);

            while (input.hasNextLine()) {
                String line = input.nextLine();
                this.FileArray.addAll(splitStringToList(line));
            }

            input.close();

        } catch (FileNotFoundException | NullPointerException e) {
            System.out.println("Error ocurred on reading the file...");
        }
    }

    public String readList(ArrayList<String> inputList) {
        String[] symbols = { " ,", " ." };
        String[] replacements = { ",", "." };

        String listString = inputList.stream().map(Object::toString)
                .collect(Collectors.joining(" "));
        replacer(listString, symbols, replacements);

        return listString;
    }

    private ArrayList<String> splitStringToList(String input) {
        String[] symbols = { ",", "." };
        String[] replacements = { " ,", " ." };
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
