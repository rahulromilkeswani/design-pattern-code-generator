package Output;
public class ${classModel.className} extends ${classModel.interfaceName}{
    public ${classModel.className}(){}
<#list classModel.fieldsList as field>
    public void interpret(${field.type} ${field.name?uncap_first}){
        //to do
    }
</#list>
}