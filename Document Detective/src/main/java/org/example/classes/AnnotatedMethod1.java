package org.example.classes;

import org.example.MethodDocumentation;


public class AnnotatedMethod1 {

    /**
     * This Annotated twice
     */
    @MethodDocumentation("MethodAnnotation")
    public void annotatedMethod() {
        System.out.println("Annotated Method");
    }
}
