package Output;
public class ${classModel.className} extends ${classModel.interfaceName}{
<#list classModel.fieldsList as field>
    private ${field.type} ${field.name?uncap_first};
</#list>
    public ${classModel.className}(<#list classModel.fieldsList as field>${field.type} ${field.name?uncap_first}<#sep>,</#sep> </#list>){
<#list classModel.fieldsList as field>
        this.${field.name?uncap_first} = ${field.name?uncap_first};
</#list>
    }
<#list classModel.methodsList as method>
    public ${method.type} ${method.name}(){
        //to do
        return null;
    }
</#list>
}