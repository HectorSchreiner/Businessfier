import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
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

        System.out.println(listString);
        return listString;
    }

    private ArrayList<String> splitStringToList(String input) {
        String[] arr = {};
        input = input.replace(",", " ,");
        input = input.replace(".", " .");
        input = input.replace("!", " !");
        input = input.replace(":", " :");
        input = input.replace("-", " - ");

        arr = input.split(" ");
        return (ArrayList<String>) Arrays.asList(arr);
    }
}
