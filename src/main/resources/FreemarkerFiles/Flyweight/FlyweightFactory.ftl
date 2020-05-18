package Output;
import java.util.*;
public class ${classModel.className}{
    private static final ${classModel.className} INSTANCE = new ${classModel.className}();
    private ${classModel.className}(){}
    public static ${classModel.className} getInstance(){
        return INSTANCE;
    }
    private Map< String,${classModel.interfaceName} > ${classModel.interfaceName?uncap_first} = new HashMap< String,${classModel.interfaceName} >();
    public ${classModel.interfaceName} get${classModel.interfaceName}(String key){
        if(${classModel.interfaceName?uncap_first}.containsKey(key)){
            return ${classModel.interfaceName?uncap_first}.get(key);
        }
        else{
            <#list classModel.fieldsList as field>
            ${classModel.interfaceName} ${classModel.interfaceName?uncap_first}Object = new ${field.name}(key);
            ${classModel.interfaceName?uncap_first}.put(key,${classModel.interfaceName?uncap_first}Object);
            return ${classModel.interfaceName?uncap_first}Object;
            </#list>
        }
    }
}
