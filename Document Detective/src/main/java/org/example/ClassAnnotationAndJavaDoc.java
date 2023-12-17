package org.example;

import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import com.github.javaparser.javadoc.Javadoc;
import lombok.Getter;

@Getter
public class ClassAnnotationAndJavaDoc extends VoidVisitorAdapter<Void> {
    private final String targetAnnotation;
    private boolean annotationPresent;
    private String javaDoc;

    ClassAnnotationAndJavaDoc(String targetAnnotation) {
        this.targetAnnotation = targetAnnotation;
        this.annotationPresent = false;
        this.javaDoc =null;
    }


    @Override
    public void visit(ClassOrInterfaceDeclaration classDeclaration, Void arg) {
        if (classDeclaration.getAnnotations().stream()
                .anyMatch(annotationExpr -> annotationExpr.getNameAsString().equals(targetAnnotation))) {

            annotationPresent = true;
            Javadoc javadocComment = classDeclaration.getJavadoc().orElse(null);
            if(javadocComment!=null)
                javaDoc = javadocComment.toText();
            else
                javaDoc = "Nothing Available";
        }
        super.visit(classDeclaration, arg);
    }
}
