package com.example.quizapp;

public class QuesAnswer {


        public static String question []={
                "Which of the following is not a Java features?",
                "Which of the following option leads to the portability in Java?",
                "The \\u0021 article referred to as a",
                "Which is used to find and fix bugs in the Java programs?",
                "Which of the following is a valid declaration of a char?"

        };

        public static String choices [][]={
                {"Dynamic","Architecture Neutral","Use of pointers","Object-oriented"},
                {"Bytecode is executed by JVM","The applet makes the Java code secure and portable","Use of exception handling","Dynamic binding between objects"},
                {"Unicode escape sequence","Octal escape","Hexadecimal","Line feed"},
                {"JVM","JRE","JDK","JDB"},
                {"char ch = '\\utea';","char ca = 'tea';","char cr = \\u0223;","char cc = '\\itea';"}
        };

        public static String correctAnswers []={
                "Use of pointers",
                " Bytecode is executed by the JVM."
                ,
                "Unicode escape sequence",

                "JDB",
                "char ch = '\\utea';",

        };

}
