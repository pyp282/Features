package data.structure;

/**
 * Created by pei on 2017/3/10.
 */
public class CollectionDemo {

    Object[] objects = new Object[16];

    public boolean isEmpty(){
        if(objects.length > 0)
            return false;
        return true;
    }

    public void makeEmpty(){
        for(Object obj : objects){
            obj = null;
        }
    }


}
