package Output;
public class ${classModel.className} implements ${classModel.interfaceName}{
<#list classModel.fieldsList as field>
    private ${field.type} ${field.name};
</#list>
<#list classModel.methodsList as method>
    public ${method.type} ${method.name}(){
        //to do
        return null;
    }
</#list>
}