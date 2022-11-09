import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CustomFileReader {

    private String delimiter;
    private Scanner scanner;


    public CustomFileReader(File file, String delimiter) throws FileNotFoundException {
        scanner = new Scanner(file);
        this.delimiter = delimiter;
    }


    private List<String> readLines(){
        List<String> lines = new LinkedList<>();
        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            if(!line.isBlank()){
                lines.add(line);
            }
        }
        scanner.close();

        if(lines.isEmpty()){
            throw new IllegalStateException("this file is empty");
        }

        return lines;
    }

    public List<Line> getListOfLines(){
        List<Line> listOfObjects = new LinkedList<>();
        List<String> lines = readLines();
        for (String line: lines) {
            List<String> lineSplitted = Arrays.asList(line.split(delimiter));
            listOfObjects.add(new Line(lineSplitted));
        }
        return listOfObjects;
    }



}
