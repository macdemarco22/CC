import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

public class CustomFileWriter {


    private String delimiter;
    private PrintWriter printWriter;

    public CustomFileWriter(String delimiter,File file) throws FileNotFoundException {
        this.delimiter = delimiter;
        printWriter = new PrintWriter(file.getAbsolutePath());
    }


    public void writeLines(List<Line> lines){
        for (Line line: lines) {
            printWriter.println(line.getLineSeparatedBy(delimiter));
        }
    }

    public void close(){
        printWriter.close();
    }
}
