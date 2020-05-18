package Output;
public class ${classModel.className}{
<#list classModel.fieldsList as field>
    private ${field.type} ${field.name};
</#list>
    public ${classModel.className}(){
    }
<#list classModel.methodsList as method>
    public ${method.type} ${method.name?uncap_first}(){
        //to do
        return null;
    }
</#list>
}