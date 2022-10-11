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
                String line = input.nextLine();
                this.FileArray = splitStringToList(line);
            }

            input.close();

        } catch (FileNotFoundException e) {
            System.out.println("No file found!");
        }
    }

    public String readList(ArrayList<String> inputList) {
        String listString = inputList.stream().map(Object::toString)
                .collect(Collectors.joining(" "));
        return listString;
    }

    private ArrayList<String> splitStringToList(String input) {
        input = input.replace(",", " ,");
        input = input.replace(".", " .");
        input = input.replace("!", " !");
        input = input.replace(":", " :");
        input = input.replace("-", " - ");

        List<String> arr = new ArrayList<String>(Arrays.asList(input.split(" ")));
        return (ArrayList<String>) arr;
    }
}
