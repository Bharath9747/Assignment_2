package org.example.classes;

import org.example.ClassDocumentation;
import org.example.MethodDocumentation;


/**
 * This Annotated class with annotated method
 */
@ClassDocumentation
public class AnnotatedMethod {

    /**
     * This is annotatedMethod
     */
    @MethodDocumentation("MethodAnnotation")
    public void annotatedMethod() {
        System.out.println("Annotated Method");
    }
}
