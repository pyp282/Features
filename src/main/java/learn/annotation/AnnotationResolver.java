package learn.annotation;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * Created by pei on 2017/3/15.
 */
public class AnnotationResolver {
    Class clazz;
    String rootname;
    Map<String, String> element_methods;
    String xmlData;

    public AnnotationResolver(Class clazz) {
        this.clazz = clazz;
    }

    public AnnotationResolver() {
    }

    public AnnotationResolver(Class clazz, String xmlData) {
        this.clazz = clazz;
        this.xmlData = xmlData;
    }

    //get name of class and methods
    public <T extends Object>T initClass() throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Object obj = clazz.newInstance();
        XmlRootElement rootElement =(XmlRootElement) clazz.getAnnotation(XmlRootElement.class);
        rootname = rootElement.name();

        Method[] methods = clazz.getMethods();

        for(Method method : methods){
            if(method.isAnnotationPresent(XmlElement.class)){
                String elementName = method.getAnnotation(XmlElement.class).name();
//                String methodName = method.getName();
//                element_methods.put(elementName, methodName);

                if(method.getParameterCount() == 1){
                    Class parameterTypes = method.getParameterTypes()[0];

                    String nodeValue = getNodeValue(xmlData, elementName);

                    String simpleName = parameterTypes.getSimpleName();
                    if(simpleName.equals("int")){
                        method.invoke(obj, Integer.valueOf(nodeValue));
                        continue;
                    }

                    method.invoke(obj, nodeValue);

                }
            }
        }

        return (T)obj;
    }

    public void resolve(String xmlData){


    }

    public String getNodeValue(String xmlData, String nodeName){
        int beginIndex = xmlData.indexOf("<" + nodeName);
        int endIndex = xmlData.lastIndexOf("</" + nodeName) + nodeName.length() + 3;
        String xmlEle = xmlData.substring(beginIndex, endIndex);
        return xmlEle.substring(xmlEle.indexOf(">") + 1, xmlEle.indexOf("</"));
    }

    public static void main(String[] args)throws Exception {
        String xmlData = "<Person>people<Name font = d>jaff</Name><Age>23</Age><Address>beijing</Address></Person>";
        AnnotationResolver annotationResolver = new AnnotationResolver(Person.class, xmlData);

        Person o = annotationResolver.initClass();
        System.out.println(o.getName() + o.getAddress()+ o.getAge());
    }
}
