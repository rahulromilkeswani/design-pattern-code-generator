package Output;
public abstract class ${classModel.className}{
<#list classModel.fieldsList as field>
    public abstract void visit${field.type}(${field.type} ${field.name?uncap_first});
</#list>
}