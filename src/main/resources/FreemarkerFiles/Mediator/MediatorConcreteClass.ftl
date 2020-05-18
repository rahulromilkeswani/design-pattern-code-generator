package Output;
public class ${classModel.className} extends ${classModel.interfaceName}{
<#list classModel.fieldsList as field>
    public ${classModel.className}(${field.type} ${field.name?uncap_first}){
        super(${field.name?uncap_first});
    }
</#list>
<#list classModel.methodsList as method>
    public ${method.type} ${method.name}(){
        //to do
        return null;
    }
</#list>
}