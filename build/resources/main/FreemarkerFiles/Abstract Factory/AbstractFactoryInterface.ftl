package Output;
public interface ${classModel.className}{
<#list classModel.fieldsList as field>
    private ${field.type} ${field.name};
</#list>
<#list classModel.methodsList as method>
    ${method.type} create${method.name}();
</#list>
}