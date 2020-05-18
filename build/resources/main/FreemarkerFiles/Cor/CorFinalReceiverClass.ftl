package Output;
public class ${classModel.className} extends ${classModel.interfaceName}{
<#list classModel.methodsList as method>
    <#list classModel.fieldsList as field>
    public ${method.type} ${method.name}(){
        //to do
        return null;
     }
    </#list>
</#list>
}