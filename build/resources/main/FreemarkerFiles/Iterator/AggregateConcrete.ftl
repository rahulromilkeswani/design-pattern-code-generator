package Output;
import java.util.*;
public class ${classModel.className}< E > implements ${classModel.interfaceName?keepBefore(",")}< E >{
    private Object[] elementData;
    private int index=0;
    private int size;
    public ${classModel.className}(int size){
        if(size<0)
            throw new IllegalArgumentException("Size : "+size);
        this.size = size;
        elementData = new Object[size];
    }
    public boolean add(E element){
        if(index < size){
            elementData[index++] = element;
            return true;
        }
        else
            return false;
    }
    public int getSize(){
        return size;
    }
    public ${classModel.interfaceName?keepAfter(",")}< E > createIterator(){
        return new <#list classModel.fieldsList as field>${field.type}</#list>< E >();
    }

    private class <#list classModel.fieldsList as field>${field.type}</#list>< E > implements ${classModel.interfaceName?keepAfter(",")} < E >{
        private int cursor = 0;
        public boolean hasNext(){
            return cursor < size ;
        }
        public E next(){
            if(cursor>=size)
                throw new NoSuchElementException();
            return (E) elementData[cursor++];
        }
    }
}