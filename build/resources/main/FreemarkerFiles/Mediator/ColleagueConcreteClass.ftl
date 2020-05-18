package Output;
public class ${classModel.className} extends ${classModel.interfaceName?keep_before(",")}{

<#list classModel.fieldsList as field>
    private ${field.type} ${field.name?uncap_first};
</#list>
    void set${classModel.interfaceName?keep_after(",")}(<#list classModel.fieldsList as field>${field.type} ${field.name?uncap_first}<#sep>,</#sep></#list>){
        <#list classModel.fieldsList as field>
        this.${field.name?uncap_first}=${field.name?uncap_first};
        </#list>
    }
    public void mediate(${classModel.interfaceName?keep_after_last(",")} ${classModel.interfaceName?keep_after(",")?uncap_first}){
    <#list classModel.fieldsList as field>
            if(${classModel.interfaceName?keep_after(",")?uncap_first} == ${field.name?uncap_first}){
                //to do
            }
    </#list>
    }
}