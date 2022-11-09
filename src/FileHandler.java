import java.io.File;
import java.util.Arrays;
import java.util.List;

public class FileHandler {


    private static final String INPUT_DIRECTORY = "input";
    private static final String OUTPUT_DIRECTORY = "output";
    private static final String OUTPUT_FILE_EXTENTION = ".out";



    public static List<File> getFilteredInputFiles(Mode mode){
        File directory= new File(INPUT_DIRECTORY);
        //System.out.println(directory.getAbsolutePath());
        if(!directory.isDirectory()){
            throw new IllegalStateException("this is not a directory");
        }

        File [] files= directory.listFiles();
        if(mode== Mode.TESTING_WITH_EXAMPLE_FILES){
            files = directory.listFiles((dir, name) -> getFileName(name).contains("example"));
        }
        else if(mode == Mode.TESTING_WITHOUT_EXAMPLE_FILES){
            files = directory.listFiles((dir,name) -> !getFileName(name).contains("example"));
        }

        return Arrays.asList(files);
    }

    /*let's be vanilla today */
    private static String getFileName(String filenameWithExtention){
        return filenameWithExtention.substring(0, filenameWithExtention.lastIndexOf('.'));
    }



    public File getOutputFile(File inputFile) {
        return new File(OUTPUT_DIRECTORY+"/"+getFileName(inputFile.getName())+ OUTPUT_FILE_EXTENTION);
    }


}
