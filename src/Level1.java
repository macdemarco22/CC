import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Level1 extends Level {

    public Level1(List<Line> listOfLines){
        super(listOfLines);
    }

    public List<Line> getOutPutLines()  {
        List<Line> outputListOfLines = new LinkedList<>();
        LineIterator iterator = new LineIterator(listOfLines);
        Line firstLine = iterator.readNextLine();
        int n = Integer.parseInt(firstLine.getListOfLine().get(0));
        List<Line> lines = iterator.readNextXLines(n);
        int minIndex =getIndexOfMinimum(lines);
        outputListOfLines.add(new Line(Arrays.asList(String.valueOf(minIndex))));
        return outputListOfLines;
    }



    private int getIndexOfMinimum(List<Line> lines){
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i = 0; i < lines.size(); i++) {
            int number = Integer.parseInt(lines.get(i).getListOfLine().get(0));
            if (number < min) {
                min = number;
                minIndex = i;
            }
        }
        return minIndex;
    }
}
