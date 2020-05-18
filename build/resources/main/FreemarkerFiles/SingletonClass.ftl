package Output;
public class ${classModel.className}{
<#list classModel.fieldsList as field>
    private static ${classModel.className} ${field.name} = null;
    public static ${classModel.className} getInstance(){
        if(${field.name}==null)
            ${field.name} = new ${classModel.className} ();
        return ${field.name};
    }
</#list>
}
