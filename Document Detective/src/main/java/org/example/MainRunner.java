package org.example;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ParseResult;
import com.github.javaparser.ast.CompilationUnit;

import java.io.*;

public class MainRunner {
    public static void main(String[] args) {
        try {
            String folder = "C:\\Users\\bharath.m\\IdeaProjects\\Final_2_1\\src\\main\\java\\org\\example\\classes";
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("Output.txt"));
            File[] files = new File(folder).listFiles();
            if (files != null) {
                for (File f : files) {
                    ParseResult<CompilationUnit> parseResult = parseJavaFile(f);

                    if (parseResult != null && parseResult.isSuccessful()) {
                        CompilationUnit compilationUnit = parseResult.getResult().get();

                        ClassAnnotationAndJavaDoc presenceChecker =
                                new ClassAnnotationAndJavaDoc("ClassDocumentation");

                        compilationUnit.accept(presenceChecker, null);
                        bufferedWriter.write(f.getName());
                        bufferedWriter.newLine();
                        if (presenceChecker.isAnnotationPresent()) {

                            bufferedWriter.write("Java Doc : " + presenceChecker.getJavaDoc());
                            bufferedWriter.newLine();
                        } else {
                            bufferedWriter.write("Class Annotation Not Present ");
                            bufferedWriter.newLine();
                        }
                        bufferedWriter.newLine();
                        CompilationUnit compilationUnit1 = parseResult.getResult().get();
                        MethodAnnotationAndJavaDoc methodAnnotationChecker = new MethodAnnotationAndJavaDoc("MethodDocumentation");
                        compilationUnit1.accept(methodAnnotationChecker, null);
                        if (methodAnnotationChecker.isAnnotationPresent()) {
                            bufferedWriter.write("Annotated Method: " + methodAnnotationChecker.getAnnotatedMethod());
                            bufferedWriter.newLine();
                            bufferedWriter.write("Java Doc : " + methodAnnotationChecker.getJavaDoc());
                            bufferedWriter.newLine();
                        } else {
                            bufferedWriter.write("Method Annotation Not Present ");
                            bufferedWriter.newLine();
                        }
                        bufferedWriter.newLine();
                    }

                }
            }
            bufferedWriter.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public static ParseResult<CompilationUnit> parseJavaFile(File filePath) {
        try {
            return new JavaParser().parse(filePath);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
