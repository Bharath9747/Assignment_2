package org.example.classes;

import org.example.ClassDocumentation;

/**
 * This is annotated Class
 */
@ClassDocumentation(value = "HelloAnnotation")
public class AnnotatedClass {
    public void exampleMethod() {
        System.out.println("Method in AnnotatedClass");
    }
}
