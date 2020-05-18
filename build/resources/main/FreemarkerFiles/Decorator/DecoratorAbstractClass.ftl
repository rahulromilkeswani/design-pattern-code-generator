package Output;
public abstract class ${classModel.className} extends ${classModel.interfaceName}{
    ${classModel.interfaceName} ${classModel.interfaceName?uncap_first};
    public ${classModel.className}(${classModel.interfaceName} ${classModel.interfaceName?uncap_first}){
        this.${classModel.interfaceName?uncap_first} = ${classModel.interfaceName?uncap_first};
    }
<#list classModel.methodsList as method>
    public ${method.type} ${method.name}(){
        return ${classModel.interfaceName?uncap_first}.${method.name}();
    }
</#list>
}