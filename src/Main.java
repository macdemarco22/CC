import java.io.File;
import java.io.FileNotFoundException;

public class Main {

    private static final String DELIMITER = " ";

    public static void main(String [] args) throws FileNotFoundException {

        System.out.println("start program:");
        FileHandler fileHandler = new FileHandler();

        for (File inputFile : fileHandler.getFilteredInputFiles(Mode.TESTING_WITHOUT_EXAMPLE_FILES)) {
            System.out.println("working with file "+inputFile.getName());
            File outputFile = fileHandler.getOutputFile(inputFile);
            //System.out.println("output file "+ outputFile.getName());
            process(inputFile, outputFile);
            System.out.println("========================");
        }
    }

    public static void process(File input, File outputFile) throws FileNotFoundException {

        //read File and put every text line in a list of Line objects
        CustomFileReader fileReader = new CustomFileReader(input,DELIMITER);

        //TODO: change level File here for every level
        //Level class gets list of Line objects + processes it + creates a list of Line objects for the output file
        Level1 fileProcessor = new Level1(fileReader.getListOfLines());

        //write created list of lines in output file
        CustomFileWriter fileWriter = new CustomFileWriter(DELIMITER,outputFile);
        fileWriter.writeLines(fileProcessor.getOutPutLines());
        fileWriter.close();
    }
}
