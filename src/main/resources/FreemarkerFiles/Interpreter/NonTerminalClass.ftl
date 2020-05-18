package Output;
import java.util.*;
public class ${classModel.className} extends ${classModel.interfaceName}{
    private List<${classModel.interfaceName}> ${classModel.interfaceName?uncap_first}List= new ArrayList<${classModel.interfaceName}>();
    public ${classModel.className}(){
        super();
    }
<#list classModel.fieldsList as field>
    public void interpret(${field.type} ${field.name?uncap_first}){
        for(${classModel.interfaceName} ${classModel.interfaceName?uncap_first} : ${classModel.interfaceName?uncap_first}List){
            ${classModel.interfaceName?uncap_first}.interpret(${field.name?uncap_first});
        }
    }
</#list>
    public boolean add(${classModel.interfaceName} e){
        return ${classModel.interfaceName?uncap_first}List.add(e);
    }

}