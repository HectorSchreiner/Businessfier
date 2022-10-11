import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ParseFile {
    ArrayList<String> FileArray;

    public void readFile(String fileName) throws IOException {
        try {
            File file = new File(fileName);
            Scanner input = new Scanner(file);

            while (input.hasNextLine()) {
                try {
                    String line = input.nextLine();
                    this.FileArray = splitStringToList(line);
                } catch (Exception e) {
                    System.out.println("File is empty");
                }
            }

            input.close();

        } catch (FileNotFoundException | NullPointerException e) {
            System.out.println("Error ocurred on reading the file...");
        }
    }

    public String readList(ArrayList<String> inputList) {
        String listString = inputList.stream().map(Object::toString)
                .collect(Collectors.joining(" "));
        replacer(listString);

        return listString;
    }

    private String replacer(String input) {
        input = input.replace(" ,", ",");
        input = input.replace(" .", ".");
        input = input.replace(" ,", ",");
        input = input.replace(" ,", ",");
        return input;
    }

    private ArrayList<String> splitStringToList(String input) {
        replacer(input);

        List<String> arr = new ArrayList<String>(Arrays.asList(input.split(" ")));
        return (ArrayList<String>) arr;
    }
}
