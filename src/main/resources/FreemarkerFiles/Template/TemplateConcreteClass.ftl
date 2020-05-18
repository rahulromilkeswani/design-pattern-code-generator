package Output;
public class ${classModel.className} extends ${classModel.interfaceName}{
<#list classModel.fieldsList as field>
    private ${field.type} ${field.name};
</#list>
<#list classModel.methodsList as method>
    protected ${method.type} ${method.name}(){
        //to do
        return null;
    }
</#list>
}