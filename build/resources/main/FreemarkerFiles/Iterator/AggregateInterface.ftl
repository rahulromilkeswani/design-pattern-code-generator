package Output;
public interface ${classModel.className}< E >{
    <#list classModel.fieldsList as field>${field.type}</#list>< E > createIterator();
    boolean add(E element);
}