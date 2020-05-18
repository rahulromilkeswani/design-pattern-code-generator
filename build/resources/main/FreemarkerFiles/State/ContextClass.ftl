package Output;
public class ${classModel.className}{
<#list classModel.fieldsList as field>
    private ${field.type} ${field.name?uncap_first};
    public ${classModel.className}(${field.type} ${field.name?uncap_first}){
        this.${field.name?uncap_first} = ${field.name?uncap_first};
    }
    <#list classModel.methodsList as method>
    public ${method.type} ${method.name?uncap_first}(){
        return ${field.name?uncap_first}.${method.name?uncap_first}(this);
    }
    </#list>
    public void setState(${field.name} ${field.name?uncap_first}){
        this.${field.name?uncap_first} = ${field.name?uncap_first};
    }
</#list>
}