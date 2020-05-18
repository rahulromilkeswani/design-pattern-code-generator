package Output;
public abstract class ${classModel.className}{
    public abstract void mediate(<#list classModel.fieldsList as field>${field.type} ${field.name?uncap_first}</#list>);
}