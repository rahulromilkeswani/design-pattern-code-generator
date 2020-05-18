package Output;
public class ${classModel.className} implements ${classModel.interfaceName}{
<#list classModel.fieldsList as field>
    private ${field.type} ${field.name?uncap_first} = new ${field.type}() ;
</#list>
<#list classModel.methodsList as method>
<#list classModel.fieldsList as field>
    public void build${method.name}(){
        ${field.name?uncap_first}.add(new ${method.name}());
    }
</#list>
</#list>
<#list classModel.fieldsList as field>
    public ${field.type} getResult(){
        return ${field.name?uncap_first};
    }
</#list>
}