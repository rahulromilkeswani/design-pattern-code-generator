package Output;
public class ${classModel.className} implements ${classModel.interfaceName}{
<#list classModel.fieldsList as field>
    private ${field.type} ${field.name?uncap_first};
    public ${classModel.className}(${field.type} ${field.name?uncap_first}){
    this.${field.name?uncap_first} = ${field.name?uncap_first};
    }
</#list>
<#list classModel.methodsList as method>
    <#list classModel.fieldsList as field>
    public ${method.type} ${method.name}(){
        //to do
        return ${field.name?uncap_first}.${method.name}();
    }
    </#list>
</#list>
}