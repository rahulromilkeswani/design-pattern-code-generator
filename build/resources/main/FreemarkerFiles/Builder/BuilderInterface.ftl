package Output;
public interface ${classModel.className}{
<#list classModel.methodsList as method>
    public void build${method.name}();
</#list>
<#list classModel.fieldsList as field>
    public ${field.type} getResult();
</#list>
}