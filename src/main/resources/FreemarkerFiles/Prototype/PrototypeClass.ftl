package Output;
public class ${classModel.className} implements ${classModel.interfaceName}{
<#list classModel.fieldsList as field>
    private ${field.type} ${field.name};
</#list>
    public ${classModel.className}(${classModel.className} ${classModel.className?uncap_first}){}
    public ${classModel.interfaceName?keep_before(",")} clone(){
        return new ${classModel.className}(this);
    }
<#list classModel.methodsList as method>
    public ${method.type} ${method.name}(){
        //to do
        return null;
    }
</#list>
}