package org.example;

import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import com.github.javaparser.javadoc.Javadoc;
import lombok.Getter;

@Getter
public class MethodAnnotationAndJavaDoc extends VoidVisitorAdapter<Void> {
    private final String targetAnnotation;
    private boolean annotationPresent;
    private String annotatedMethod;
    private String javaDoc;

    MethodAnnotationAndJavaDoc(String targetAnnotation) {
        this.targetAnnotation = targetAnnotation;
        this.annotationPresent = false;
        this.annotatedMethod = null;
        this.javaDoc = null;
    }

    @Override
    public void visit(MethodDeclaration methodDeclaration, Void arg) {
        if (methodDeclaration.getAnnotations().stream()
                .anyMatch(annotation -> annotation.getNameAsString().equals(targetAnnotation))) {
            annotationPresent = true;
            annotatedMethod = methodDeclaration.getNameAsString();
            Javadoc javadoc = methodDeclaration.getJavadoc().orElse(null);
            if (javadoc!=null)
                javaDoc = javadoc.toText();
            else
                javaDoc = "Nothing Available";
        }
        super.visit(methodDeclaration, arg);
    }
}

