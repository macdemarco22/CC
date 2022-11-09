import java.util.LinkedList;
import java.util.List;

public abstract class Level {

    protected List<Line> listOfLines;

    protected Level(List<Line> listOfLines){
        this.listOfLines = new LinkedList<>(listOfLines);
    }

    protected abstract List<Line> getOutPutLines();
}
