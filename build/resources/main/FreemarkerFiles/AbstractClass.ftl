package Output;
public abstract class ${classModel.className}{
<#list classModel.fieldsList as field>
    private ${field.type} ${field.name};
</#list>
<#list classModel.methodsList as method>
    public abstract ${method.type} ${method.name}();
</#list>

}