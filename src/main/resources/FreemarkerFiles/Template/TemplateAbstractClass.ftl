package Output;
public abstract class ${classModel.className}{
<#list classModel.fieldsList as field>
    private ${field.type} ${field.name};
</#list>
<#list classModel.methodsList as method>
    protected abstract ${method.type} ${method.name}();
</#list>
    public final void template(){
   <#list classModel.methodsList as method>
        ${method.name}();
   </#list>
    }
}