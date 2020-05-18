package Output;
import java.util.*;
public class ${classModel.className} extends ${classModel.interfaceName}{
    private List<${classModel.interfaceName}> children = new ArrayList<${classModel.interfaceName}>();
    public ${classModel.className}(){
        super();
    }
    public boolean add(${classModel.interfaceName} child){
        return children.add(child);
    }
    public Iterator<${classModel.interfaceName}> iterator(){
        return children.iterator();
    }
}