package Output;
import java.util.*;
public class ${classModel.className} {
<#list classModel.fieldsList as field>
    private List<${field.type}> children = new ArrayList<${field.type}>();
    public boolean add(${field.type} child){
        return children.add(child);
    }
    public Iterator<${field.type}> iterator(){
        return children.iterator();
    }
</#list>
}