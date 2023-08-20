package org.centaur.ioc.java.beans;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyEditorSupport;
import java.util.stream.Stream;

/**
 * @author Centaur
 * @version 1.0
 * @description: TODO
 * @date 2023/8/20 16:33
 */
public class BeanInfoDemo {

    public static void main(String[] args) throws IntrospectionException {
        BeanInfo beanInfo = Introspector.getBeanInfo(Person.class, Object.class);
        Stream.of(beanInfo.getPropertyDescriptors())
                .forEach(propertyDescriptor -> {
                    System.out.println(propertyDescriptor);
                    //PropertyDescriptor 允许添加属性编辑器 - PropertyEditor
                    Class<?> propertyType = propertyDescriptor.getPropertyType();
                    System.out.println(propertyType);
                    if("age".equals(propertyDescriptor.getName())){
                        // 为age属性增加类型转换 PropertyEditor
                        propertyDescriptor.setPropertyEditorClass(StringToIntegerPropertyEditor.class);
                    }
                    System.out.println(propertyDescriptor);
                });
    }

    static class StringToIntegerPropertyEditor extends PropertyEditorSupport {
        public void setAsText(String text) throws java.lang.IllegalArgumentException{
            Integer value = Integer.valueOf(text);
            setValue(value);
        }
    }



}
