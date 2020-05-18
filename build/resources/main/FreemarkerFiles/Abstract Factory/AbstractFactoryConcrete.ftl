package Output;
public class ${classModel.className} implements ${classModel.interfaceName}{
<#list classModel.fieldsList as field>
    private ${field.type} ${field.name};
</#list>
<#list classModel.methodsList as method>
    public ${method.type} create${method.name?cap_first}(){
        //to do
        return new ${method.name}();
    }
</#list>
}