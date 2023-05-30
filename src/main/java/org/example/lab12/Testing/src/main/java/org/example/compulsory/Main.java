package org.example.compulsory;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Main {

    private static int testMethodsCount = 0;
    private static int successfulTestsCount = 0;
    private static int failedTestsCount = 0;

    public static void main(String[] args) throws MalformedURLException, ClassNotFoundException, IOException {
        String inputPath = "D:\\Facultate\\An 2 Semestru 2\\PA - Programare avansata\\Programare_Avansata\\src\\main\\java\\org\\example\\lab12\\Testing\\src\\main\\java\\org\\example\\compulsory\\classes\\classes.jar"; // Update with the input path
        System.out.println("IN MAIN");
        List<Class<?>> classes = loadClasses(inputPath);

        for (Class<?> cls : classes) {
            System.out.println("Class Name: " + cls.getName());
            System.out.println("Dynamic Package: " + cls.getPackage().getName());
            printFields(cls);
            printMethods(cls);
            invokeTestMethods(cls);
        }

        printStatistics();
    }

    private static List<Class<?>> loadClasses(String inputPath) throws MalformedURLException, ClassNotFoundException, IOException {
        List<Class<?>> classes = new ArrayList<>();
        File input = new File(inputPath);
        System.out.println("Exista path" + input.exists());
        if (input.exists() && input.isDirectory()) {
            // Load classes from the directory recursively
            loadClassesFromDirectory(input, classes);
        } else if (input.isFile() && input.getName().endsWith(".jar")) {
            // Load classes from the jar file
            loadClassesFromJar(input, classes);
        }

        return classes;
    }

    private static void loadClassesFromDirectory(File directory, List<Class<?>> classes) throws MalformedURLException, ClassNotFoundException {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    loadClassesFromDirectory(file, classes);
                } else if (file.isFile() && file.getName().endsWith(".class")) {
                    String classFilePath = file.getAbsolutePath();
                    String className = getClassPath(directory.toPath(), file.toPath());
                    Class<?> cls = loadClass(className, classFilePath);
                    classes.add(cls);
                }
            }
        }
    }

    private static void loadClassesFromJar(File jarFile, List<Class<?>> classes) throws MalformedURLException, ClassNotFoundException {
        URLClassLoader classLoader = new URLClassLoader(new URL[]{jarFile.toURI().toURL()});
        try (java.util.jar.JarFile jf = new java.util.jar.JarFile(jarFile)) {
            Enumeration<java.util.jar.JarEntry> entries = jf.entries();
            while (entries.hasMoreElements()) {
                java.util.jar.JarEntry entry = entries.nextElement();
                if (!entry.isDirectory() && entry.getName().equals("Test1.class")) {
                    System.out.println("Found Test1.class");
                    String className = entry.getName().replace('/', '.');
                    className = className.substring(0, className.length() - ".class".length());
                    System.out.println("Class Name: " + className);
                    Class<?> cls = classLoader.loadClass(className);
                    classes.add(cls);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static String getClassPath(Path basePath, Path classFilePath) {
        Path relativePath = basePath.relativize(classFilePath);
        String relativeClassPath = relativePath.toString().replace(File.separator, ".");
        return relativeClassPath.substring(0, relativeClassPath.lastIndexOf('.'));
    }

    private static Class<?> loadClass(String className, String classFilePath) throws MalformedURLException, ClassNotFoundException {
        File classFile = new File(classFilePath);
        URL[] urls = {classFile.toURI().toURL()};
        ClassLoader classLoader = new URLClassLoader(urls);
        return classLoader.loadClass(className);
    }

    private static void printFields(Class<?> cls) {
        System.out.println("Fields:");
        for (Field field : cls.getDeclaredFields()) {
            System.out.println("Field: " + field.getName() + " Type: " + field.getType());
        }
    }

    private static void printMethods(Class<?> cls) {
        System.out.println("Methods:");
        for (Method method : cls.getDeclaredMethods()) {
            System.out.println("Method Name: " + method.getName());
            System.out.println("Method Return Type: " + method.getReturnType());
            System.out.println("Method Parameters: " + Arrays.toString(method.getParameters()));
            System.out.println("Method Exceptions: " + Arrays.toString(method.getExceptionTypes()));
        }
    }

    private static void invokeTestMethods(Class<?> cls) {
        System.out.println("Testing Methods:");
        for (Method method : cls.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Test.class)) {
                if (Modifier.isStatic(method.getModifiers()) && method.getParameterCount() == 0) {
                    invokeStaticTestMethod(method);
                } else if (!Modifier.isStatic(method.getModifiers())) {
                    invokeInstanceTestMethod(cls, method);
                }
            }
        }
    }

    private static void invokeStaticTestMethod(Method method) {
        try {
            System.out.println("Invoking static test method: " + method.getName());
            method.invoke(null);
            successfulTestsCount++;
        } catch (Exception e) {
            System.out.println("Test failed for method: " + method.getName());
            failedTestsCount++;
        }
        testMethodsCount++;
    }

    private static void invokeInstanceTestMethod(Class<?> cls, Method method) {
        try {
            System.out.println("Creating instance for class: " + cls.getName());
            Object instance = cls.getDeclaredConstructor().newInstance();
            System.out.println("Invoking test method: " + method.getName());
            method.invoke(instance);
            successfulTestsCount++;
        } catch (Exception e) {
            System.out.println("Test failed for method: " + method.getName());
            failedTestsCount++;
        }
        testMethodsCount++;
    }

    private static void printStatistics() {
        System.out.println("Test Statistics:");
        System.out.println("Total Test Methods: " + testMethodsCount);
        System.out.println("Successful Tests: " + successfulTestsCount);
        System.out.println("Failed Tests: " + failedTestsCount);
    }
}
