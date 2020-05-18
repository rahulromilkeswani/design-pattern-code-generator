package Output;
public class ${classModel.className} extends ${classModel.interfaceName}{
<#list classModel.fieldsList as field>
    public ${classModel.className}(${field.type} ${field.name}){
    super(${field.name});
    }
</#list>
<#list classModel.methodsList as method>
    <#list classModel.fieldsList as field>
        public ${method.type} ${method.name}(){
            if(canHandleRequest()){
                //to do
                return null;
            }
            else{
                return super.${method.name}();
            }
        }
    </#list>
</#list>
}