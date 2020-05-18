package Output;
public interface ${classModel.className}{
<#list classModel.methodsList as method>
    <#list classModel.fieldsList as field>
     ${method.type} ${method.name?uncap_first}(${field.name} ${field.type?uncap_first});
    </#list>
</#list>
}