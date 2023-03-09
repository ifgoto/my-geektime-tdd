package geektime.tdd.args;


import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.List;

public class Args {
    public static <T> T parse(Class<T> optionsClass, String... args) {
        try {
            Constructor<?> constructor = optionsClass.getDeclaredConstructors()[0];
            Parameter parameter = constructor.getParameters()[0];
            Option option = parameter.getAnnotation(Option.class);
            List<String> argument = Arrays.asList(args);


            Object value = null;
            if (parameter.getType() == boolean.class){

                value = argument.contains("-" + option.value());
            }

            if (parameter.getType() == int.class) {
                int index = argument.indexOf("-" + option.value());
                value = Integer.parseInt(argument.get(index + 1));
            }

            if (parameter.getType() == String.class) {
                int index = argument.indexOf("-" + option.value());
                value = argument.get(index+1);
            }

            return (T) constructor.newInstance(value);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
