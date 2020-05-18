package Output;
public class ${classModel.className} implements ${classModel.interfaceName}{
    private String key;
    public  ${classModel.className}(String key){
        this.key = key;
    }
<#list classModel.methodsList as method>
    public ${method.type} ${method.name}(){
        //to do
        return null;
    }
</#list>
}