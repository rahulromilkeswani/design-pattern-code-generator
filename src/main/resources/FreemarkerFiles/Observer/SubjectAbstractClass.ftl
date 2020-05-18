package Output;
import java.util.*;
public abstract class ${classModel.className}{
    public List<${classModel.interfaceName}> ${classModel.interfaceName?uncap_first}List = new ArrayList<${classModel.interfaceName}>();
    public void attach(${classModel.interfaceName} ${classModel.interfaceName?uncap_first}){
        ${classModel.interfaceName?uncap_first}List.add(${classModel.interfaceName?uncap_first});
    }
    public void notifyObservers(){
        for(${classModel.interfaceName} ${classModel.interfaceName?uncap_first} : ${classModel.interfaceName?uncap_first}List)
            ${classModel.interfaceName?uncap_first}.update();
    }
}