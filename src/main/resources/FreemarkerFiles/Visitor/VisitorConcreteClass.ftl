package Output;
public class ${classModel.className} extends ${classModel.interfaceName}{
<#list classModel.fieldsList as field>
    public void visit${field.type}(${field.type} ${field.name?uncap_first}){
        //to do
    }
</#list>
}