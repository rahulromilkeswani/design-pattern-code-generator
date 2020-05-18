package Output;
public abstract class ${classModel.className}{
<#list classModel.fieldsList as field>
    private ${field.type} ${field.name};
    public ${classModel.className}(){
    }
    public ${classModel.className}(${field.type} ${field.name}){
        this.${field.name} =  ${field.name};
    }
</#list>
<#list classModel.methodsList as method>
<#list classModel.fieldsList as field>
    public ${method.type} ${method.name}(){
        if(${field.name} != null){
            return ${field.name}.${method.name}();
        }
        return null;
    }
</#list>
</#list>
    public boolean canHandleRequest(){
        //check runtime conditions
        return false;
    }

}