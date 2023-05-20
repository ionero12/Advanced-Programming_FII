package org.example.lab12.compulsory;

import org.testng.annotations.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ClassAnalyzer {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, ClassNotFoundException {

        String classFilePath = "D:\\Facultate\\An 2 Semestru 2\\PA - Programare avansata\\Programare_Avansata\\target\\classes\\org\\example\\lab3\\compulsory\\Person.class";
        Path p1 = Paths.get(classFilePath);
        System.out.println(p1);
        try {
            Class<?> clazz = Class.forName(getClassFullName(classFilePath));

            String packageName = getPackageName(clazz);

            // Display package name and class name
            System.out.println("Package: " + packageName);
            System.out.println("Class: " + clazz.getSimpleName());

            Method[] methods = clazz.getDeclaredMethods();
            System.out.println("Methods:");
            for (Method method : methods) {
                System.out.println("  " + getMethodSignature(method));
                if (Modifier.isStatic(method.getModifiers()) && method.isAnnotationPresent(Test.class)) {
                    // Invoke static methods annotated with @Test
                    method.invoke(null);
                }
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    private static String getClassFullName(String classFilePath) {
        String className = classFilePath.replace(".class", "");
        className = className.replace(System.getProperty("file.separator"), ".");
        return className;
    }

    private static String getPackageName(Class<?> clazz) {
        Package classPackage = clazz.getPackage();
        if (classPackage != null) {
            return classPackage.getName();
        }
        return "(default)";
    }

    private static String getMethodSignature(Method method) {
        StringBuilder signature = new StringBuilder();
        signature.append(Modifier.toString(method.getModifiers()));
        signature.append(" ");
        signature.append(method.getReturnType().getSimpleName());
        signature.append(" ");
        signature.append(method.getName());
        signature.append("(");
        Class<?>[] parameterTypes = method.getParameterTypes();
        for (int i = 0; i < parameterTypes.length; i++) {
            signature.append(parameterTypes[i].getSimpleName());
            if (i < parameterTypes.length - 1) {
                signature.append(", ");
            }
        }
        signature.append(")");
        return signature.toString();
    }

    @Test
    public static void sampleTestMethod() {
        System.out.println("Executing sampleTestMethod...");
    }
}
