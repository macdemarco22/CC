import java.util.LinkedList;
import java.util.List;

public class Line {

    private List<String> lineList;

    //Map<String, TypeChecker.DataType> line
    public Line (List<String> line){
        this.lineList = new LinkedList<>(line);
    }


    public List<String> getListOfLine(){
        return lineList;
    }

    public int getNumberOfChunks(){
        return lineList.size();
    }

    public String getLineSeparatedBy(String separator){
        if(getNumberOfChunks()==0){
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(lineList.get(0));
        for(int i = 1; i < getNumberOfChunks(); i ++){
            stringBuilder.append(separator);
            stringBuilder.append(lineList.get(i));
        }
        return stringBuilder.toString();
    }
}
