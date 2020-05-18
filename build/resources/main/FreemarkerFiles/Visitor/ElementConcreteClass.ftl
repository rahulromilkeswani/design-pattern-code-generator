package Output;
public class ${classModel.className} extends ${classModel.interfaceName}{
<#list classModel.fieldsList as field>
    ${field.type} ${field.name};
</#list>
<#list classModel.fieldsList as field>
    public void accept(${field.type} ${field.name?uncap_first}){
        ${field.name?uncap_first}.visit${classModel.className}(this);
    }
</#list>
}