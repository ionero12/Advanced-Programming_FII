package org.example.lab12.compulsory;

import java.util.Arrays;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class Main {

    public static void main(String[] args) throws MalformedURLException, ClassNotFoundException {
        String className = "Test1";
        String packageName = "org.example.lab12.compulsory";

        Class<?> cls = loadClass(className, packageName);

        System.out.println("Class Name: " + cls.getName()); //numele clasei
        System.out.println("Dynamic Package: "+ cls.getPackage().getName()); //pachetul clasei
        for(Field field : cls.getDeclaredFields()) { //campurile clasei
            System.out.println("Field: " + field.getName() + " Type: " + field.getType());
        }
        for (Method method : cls.getDeclaredMethods()) { //metodele clasei
            if (method.getParameterCount() == 0) {
                try {
                    method.invoke(null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Method name: " + method.getName() + " Type: " + method.getReturnType() + " Parameters: " + Arrays.toString(method.getParameters()));
        }
    }

    private static Class<?> loadClass(String className, String packageName) throws MalformedURLException, ClassNotFoundException {
        String classFilePath = "D:\\Facultate\\An 2 Semestru 2\\PA - Programare avansata\\Programare_Avansata\\src\\main\\java\\org\\example\\lab12\\compulsory\\testClasses\\Test1.class";

        File classFile = new File(classFilePath);
        URL[] urls = {classFile.toURI().toURL()};
        ClassLoader classLoader = new URLClassLoader(urls);

        return classLoader.loadClass(packageName + "." + className);
    }

    private static void invokeTestMethods(Class<?> cls) {
        // Get all methods of the class
        Method[] methods = cls.getDeclaredMethods();

        for (Method m : methods) {
            if (m.getParameterCount() == 0) {
                try {
                    // Invoke the method
                    m.invoke(null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Method name: " + m.getName());
            System.out.println("Method parameters: " + Arrays.toString(m.getParameters()));
            System.out.println("Method return type: " + m.getReturnType());
            System.out.println("Method exceptions: " + Arrays.toString(m.getExceptionTypes()));
        }
    }
}
