package com.naharoo;

import com.naharoo.annotation.MapperField;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Mapper {

    public static <R> R map(Object sourceObject, Class<R> targetClass) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException, NoSuchFieldException {

        Class<?> sourceClass = sourceObject.getClass();

        Field[] fields = sourceClass.getDeclaredFields();

        Constructor<R> constructor = targetClass.getConstructor();

        R result = constructor.newInstance();

        for (Field field : fields) {

            if (!field.isAnnotationPresent(MapperField.class)) {
                continue;
            }

            field.setAccessible(true);
            Object fieldValue = field.get(sourceObject);

            MapperField annotation = field.getAnnotation(MapperField.class);
            String fieldName = annotation.name();

            Field targetField = targetClass.getDeclaredField(fieldName);
            targetField.setAccessible(true);

            targetField.set(result, fieldValue);
        }

        return result;
    }
}
