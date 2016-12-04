/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hlibbabii.classparser17;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @version 1.0
 * @author Gleb
 */
public class ClassParser {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ClassParser classParser = new ClassParser();
        Class loadedClass = null;
        try {
            loadedClass = Class.forName("java.util.ArrayList", true, null);
        } catch (ClassNotFoundException ex) {
            System.out.println("Class not found");
        }
        if (loadedClass != null) {
            classParser.parseClass(loadedClass, 0);
        }
    }

    //TODO this method is too big
    /**
     * Prints the full description of the class with given name including all
     * information about class (fields, constructors, method signatures, nested
     * classes)
     *
     * @param classToParse class to be parsed
     * @param levelOfNesting shoud be 0
     */
    public void parseClass(Class classToParse, int levelOfNesting) {

        /*
         * Define class Header
         */
        String header = "";
        for (int l = levelOfNesting; l > 0; l--) {
            header += "    ";
        }
        int mods = classToParse.getModifiers();
        if (Modifier.isAbstract(mods)) {
            header += "abstract ";
        }
        if (classToParse.isInterface()) {
            header = "Interface ";
        } else if (false) { // TODO add smth
        }
        header += classToParse.getName() + " ";
        Class superClass = classToParse.getSuperclass();
        if (superClass != null && superClass != Object.class) {
            header += "extends ";
            header += superClass.getName() + " ";
        }
        Class[] implemented = classToParse.getInterfaces();
        if (implemented.length > 0) {
            header += "implements ";
            for (int i = 0; i < implemented.length; i++) {
                header += implemented[i].getName() + " ";
            }
        }
        header += "{";

        System.out.println(header);
        /*
         * Find nested classes
         */
        Class nestedClasses[] = classToParse.getDeclaredClasses();
        for (int i = 0; i < nestedClasses.length; i++) {
            parseClass(nestedClasses[i], levelOfNesting + 1);
        }

        /*
         * Find fields
         */
        Field fields[] = classToParse.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            String str = "";
            for (int l = levelOfNesting + 1; l > 0; l--) {
                str += "    ";
            }

            /*
             * Find modifiers
             */
            int mod = fields[i].getModifiers();

            if (Modifier.isPrivate(mod)) {
                str += "private ";
            } else if (Modifier.isProtected(mod)) {
                str += "protected ";
            } else if (Modifier.isPublic(mod)) {
                str += "public ";
            }

            if (Modifier.isFinal(mod)) {
                str += "final ";
            }
            if (Modifier.isStatic(mod)) {
                str += "static ";
            }
            if (Modifier.isTransient(mod)) {
                str += "transient ";
            }
            if (Modifier.isVolatile(mod)) {
                str += "volatile ";
            }

            /*
             * Identify type
             */
            Class type = fields[i].getType();

            /*
             * Identify name of the field
             */
            String name = fields[i].getName();

            str += type.toString() + " " + name + ";";

            System.out.println(str);
        }
        System.out.println();
        /*
         * Find constructors
         */
        Constructor constructors[] = classToParse.getDeclaredConstructors();
        for (int i = 0; i < constructors.length; i++) {
            String str = "";
            for (int l = levelOfNesting + 1; l > 0; l--) {
                str += "    ";
            }

            int mod = constructors[i].getModifiers();

            if (Modifier.isPrivate(mod)) {
                str += "private ";
            } else if (Modifier.isProtected(mod)) {
                str += "protected ";
            } else if (Modifier.isPublic(mod)) {
                str += "public ";
            }

            if (Modifier.isStatic(mod)) {
                str += "static ";
            } else if (Modifier.isNative(mod)) {
                str += "native ";
            }

            str += classToParse.getName() + "(";
            Class parameters[] = constructors[i].getParameterTypes();
            for (int j = 0; j < parameters.length; j++) {
                str += parameters[j].getName() + " ";
            }
            str += ") {...}";

            System.out.println(str);
        }
        System.out.println();
        /*
         * Find methods
         */
        Method methods[] = classToParse.getDeclaredMethods();
        for (int i = 0; i < methods.length; i++) {
            String str = "";
            for (int l = levelOfNesting + 1; l > 0; l--) {
                str += "    ";
            }

            int mod = methods[i].getModifiers();

            if (Modifier.isPrivate(mod)) {
                str += "private ";
            } else if (Modifier.isProtected(mod)) {
                str += "protected ";
            } else if (Modifier.isPublic(mod)) {
                str += "public ";
            }

            Class returnType = methods[i].getReturnType();
            str += returnType.getName() + " ";

            str += methods[i].getName() + "(";
            Class parameters[] = methods[i].getParameterTypes();
            for (int j = 0; j < parameters.length; j++) {
                str += parameters[j].getName() + " ";
            }
            str += ") {...}";

            System.out.println(str);
        }
        String str = "";
        for (int l = levelOfNesting; l > 0; l--) {
            str += "    ";
        }
        str += "}";
        System.out.println(str);
    }
}
