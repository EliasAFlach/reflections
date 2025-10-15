package com.elias.reflections.reflection;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Transformator {

    public <I, O> O transform(I input) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> source = input.getClass();
        String targetClassName = source.getName().replace(".entity.", ".dto.") + "DTO";
        Class<?> target = Class.forName(targetClassName);

        O targetClass = (O) target.getDeclaredConstructor().newInstance();

        for (Field sourceField : source.getDeclaredFields()) {
            try {
                Field targetField = target.getDeclaredField(sourceField.getName());

                sourceField.setAccessible(true);
                targetField.setAccessible(true);

                if (targetField.getType().isAssignableFrom(sourceField.getType())) {
                    Object value = sourceField.get(input);
                    targetField.set(targetClass, value);
                }

            } catch (NoSuchFieldException e) {
            }
        }

        return targetClass;
    }
}