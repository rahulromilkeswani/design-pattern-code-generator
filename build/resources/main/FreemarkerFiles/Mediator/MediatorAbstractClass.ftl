package Output;
public abstract class ${classModel.className}{
<#list classModel.fieldsList as field>
    private ${field.type} ${field.name?uncap_first};
</#list>
<#list classModel.fieldsList as field>
    public ${classModel.className}(${field.type} ${field.name?uncap_first}){
        this.${field.name?uncap_first} = ${field.name?uncap_first};
    }
</#list>
}