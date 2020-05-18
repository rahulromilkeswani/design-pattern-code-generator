package Output;
public class ${classModel.className} extends ${classModel.interfaceName?keep_before(",")}{
    public ${classModel.className}(${classModel.interfaceName?keep_after(",")} ${classModel.interfaceName?keep_after(",")?uncap_first}){
        super(${classModel.interfaceName?keep_after(",")?uncap_first});
    }
<#list classModel.methodsList as method>
    public ${method.type} ${method.name}(){
        //to do
        return null;
    }
</#list>
}