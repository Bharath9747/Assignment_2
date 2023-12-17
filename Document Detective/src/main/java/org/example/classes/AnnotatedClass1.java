package org.example.classes;

import org.example.MethodDocumentation;
import org.example.ClassDocumentation;

@ClassDocumentation(value = "HelloAnnotation")
public class AnnotatedClass1 {
    @MethodDocumentation(value = "Hi")
    public void exampleMethod() {
        System.out.println("Method in AnnotatedClass");
    }
}
