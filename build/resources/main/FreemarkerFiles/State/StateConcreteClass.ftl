package Output;
public class ${classModel.className} implements ${classModel.interfaceName} {
<#list classModel.fieldsList as field>
    private static final ${classModel.className} INSTANCE = new ${classModel.className}();
    private ${classModel.className}(){}
    public static ${classModel.className} getInstance(){
        return INSTANCE;
    }
    <#list classModel.methodsList as method>
        <#list classModel.fieldsList as field>
            public ${method.type} ${method.name?uncap_first}(${field.name} ${field.type?uncap_first}){
                ${field.type?uncap_first}.setState(${classModel.className}.getInstance());
                return null;
            }
        </#list>
    </#list>
</#list>
}