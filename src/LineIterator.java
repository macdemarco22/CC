import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LineIterator {
    private Iterator<Line> iterator;
    private List<Line> lineList;

    public LineIterator(List<Line> lineList){
        this.lineList = new LinkedList<>(lineList);
        iterator = lineList.listIterator();
    }


    public boolean hasNextLine(){
        return iterator.hasNext();
    }

    public Line readNextLine(){
        if(iterator.hasNext()){
            return iterator.next();
        }
        throw new IllegalStateException("cannot read next line because there are no lines left");
    }


    public List<Line> readNextXLines(int numberOfLinesToIterate){
        int countNumbOfLines = 0;
        List<Line> readLines = new LinkedList<>();
        while(iterator.hasNext()&&countNumbOfLines<numberOfLinesToIterate){
            readLines.add(iterator.next());
            countNumbOfLines++;
        }
        if(countNumbOfLines < numberOfLinesToIterate){
            throw new IllegalStateException("cannot read next "+numberOfLinesToIterate+ " lines because there are only "+countNumbOfLines+" left");
        }
        return readLines;
    }

}
