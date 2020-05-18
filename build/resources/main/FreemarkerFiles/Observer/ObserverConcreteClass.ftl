package Output;
public class ${classModel.className} extends ${classModel.interfaceName}{
    private int state;
<#list classModel.fieldsList as field>
    private ${field.type} ${field.name?uncap_first};
</#list>
    public ${classModel.className}(<#list classModel.fieldsList as field>${field.type} ${field.name?uncap_first}</#list>){
<#list classModel.fieldsList as field>
        this.${field.name?uncap_first} = ${field.name?uncap_first};
        ${field.name?uncap_first}.attach(this);
</#list>
    }
    public void update(){
<#list classModel.fieldsList as field>
        this.state = ${field.name?uncap_first}.getState();
</#list>
    }
}