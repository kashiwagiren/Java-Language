import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("In this Java quiz game program, the player is asked a series of multiple-choice questions.\n");
        System.out.println("The score is incremented for each correct answer. Finally, the program displays the player's final score.");
        System.out.print("\nENTER YOUR NAME: ");
        String name = sc.nextLine();
        char ch1 = '0';
        while (ch1 != '1' || ch1 != '2') {
            clearConsole();
            System.out.print("|| Welcome, " + name + " ||\n\n\t1. START\n\t2. EXIT\n\n= ");
            ch1 = sc.next().charAt(0);
            switch (ch1) {
                case '1':
                    clearConsole();
                    System.out.print("||CHOOSE DIFFICULTY||\n\n\t1.EASY\n\t2.MEDIUM\n\t3.HARD\n\n= ");
                    int ch2 = sc.nextInt();
                    switch (ch2) {
                        case 1:
                            System.out.print("\nEASY");
                            easy();
                            break;
                        case 2:
                            System.out.print("\nMEDIUM");
                            medium();
                            break;
                        case 3:
                            System.out.print("\nHARD");
                            hard();
                            break;
                        case 4:
                            clearConsole();
                            main(null);
                            break;
                        default:
                            System.out.print("\nInvalid.");
                            try {
                                Thread.sleep(2000);
                            } catch (InterruptedException ex) {
                                Thread.currentThread().interrupt();
                            }
                            break;
                    }
                    break;
                case '2':
                    System.exit(0);
                    break;
            }
        }
    }
    
    static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    static int question(String[] questions, String[] choices, char[] answers, char[] answers1) {
        Scanner sc = new Scanner(System.in);
        int score = 0;
        for (int i = 0; i < 10; i++) {
            clearConsole();
            System.out.print(questions[i] + choices[i]);
            System.out.print("\n\n= ");
            char ans = sc.next().charAt(0);
            if (ans == answers[i] || ans == answers1[i]) {
                score++;
                System.out.println("\nCorrect!");
            } else {
                System.out.println("\nWrong!");
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
        clearConsole();
        System.out.println("YOUR SCORE IS " + score);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        
        return score;
    }
    
    static boolean askToProceed() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nWould you like to proceed to the next level? (y/n): ");
        char ans = sc.next().charAt(0);
        return ans == 'Y' || ans == 'y';
    }

    static int easy() {
        String noviceq[] = {"1.An ______ is a special \"class\" that represents a group of constants",
                "2. A ___________ is a block of codes similar to the method.It is called when an instance of the class is created.",
                "3. An ________ is an instance of a class. ",
                "4. A _____ is a group of objects which have common properties.",
                "5. A ________ is like a function which is used to expose the behavior of an object.",
                "6. What keyword is used when allocating memory at runtime?",
                "7. What keyword is used for mainly memory management?",
                "8. An access level that can only be accessed within the package and doesn't have a specific access level.",
                "9. A modifier that has an access level everywhere.",
                "10.An entity that has state and behavior is known as what?",};
        String novicec[] = {"\nA. enum          B. constructor \nC. method        D. array",
                "\nA. enum          B. constructor\nC. method        D. object",
                "\nA. package       B. constructor\nC. method        D. object",
                "\nA. package       B. class\nC. method        D. object",
                "\nA. method        B. class\nC. object        D. package",
                "\nA. new           B. static\nC. final         D. package",
                "\nA. new           B. static\nC. final         D. package",
                "\nA. protected     B. public\nC. private       D. default",
                "\nA. protected     B. public\nC. private       D. default",
                "\nA. object        B. method\nC. class         D. package"};
        char novicens[] = {'A', 'B', 'D', 'B', 'A', 'A', 'C', 'D', 'B', 'A'};
        char noviceans[] = {'a', 'b', 'd', 'b', 'a', 'a', 'c', 'd', 'b', 'a'};
        question(noviceq, novicec, novicens, noviceans);
        if(askToProceed()) {
            return medium();
        }
        return 0;
    }

    static int medium() {
        String standardq[]={"1. What does OOP stands for in computer programming?",
                "2. It is a variable that is used when declaring a constant, \n\t\t\t\t\t     unchangeable and a read-only.",
                "3. All Java variables must be identified with ______ names.",
                "4. These are rules in naming variables EXCEPT",
                "5. It is a data type which specifies the size and the type of variable\n\t\t\t\t\t      values",
                "6. These are examples of Non-Primitive Data Types EXCEPT",
                "7. Give me one example of Java Comparison Operator",
                "8. These are examples of Java Logical Operator EXCEPT",
                "9. It is an operator used in combining https://www.onlinegdb.com/#tab-stdintwo strings together.",
                "10.These are conditional statements EXCEPT"};
        String standardc[]={"\nA. Orient Object Programming      B. Output Object Programming\nC. Object Oriented Programming     D. Object Output Programming", 
                "\nA. Public      B. Private\nC. Final     D. Static",
                "\nA. Variables   B. Object\nC. Data Type   D. Unique",
                "\nA. It contains letters,numbers   B. It should start in number\nC. It can begin with _ and $  D.It cannot contain whitespace",
                "\nA. Primitive Data Type   B. Non-Primitive Data Type\nC. Float Data Type  D. Integer Data type",
                "\nA. String    B. Int\nC. Arrays   D. Classes",
                "\nA. &&    B.!=\nC. +=     D. /=",
                "\nA. ==    B. >\nC. >=     D. ||",
                "\nA. Combine   B. Concatenation\nC. Compare  D. Clean",
                "\nA. If        B. Switch\nC. For Loop      D. Method"};
        char standarda[]={'C','C','D','B','A','B','B','D','B','D'};
        char standarda1[]={'c','c','d','b','a','b','b','d','b','d'};
        question(standardq, standardc, standarda, standarda1);
        if(askToProceed()) {
            return hard();
        }
        return 0;
    }

    static int hard() {
        String expertq[]={"1. public class Main{\n\t\t\t\t\t     public static void main(String[]args){\n\t\t\t\t\t     printf(\"Hello World\")\n\t\t\t\t\t     }\n\t\t\t\t\t     }",
                            "2. public class Main{\n\t\t\t\t\t     public static void main(String[]args){\n\t\t\t\t\t     System.out.println(\"Hello World\")\n\t\t\t\t\t     }\n\t\t\t\t\t     }",
                            "3. public class who{\n\t\t\t\t\t     public static void main(String[]args){\n\t\t\t\t\t     int a=20;\n\t\t\t\t\t     System.out.println(a);\n\t\t\t\t\t     }\n\t\t\t\t\t     }",
                            "4. public class Main{\n\t\t\t\t\t     public static void main(String[]args){\n\t\t\t\t\t     int x=5,y=5,total;\n\n\t\t\t\t\t     total=x+y;\n\t\t\t\t\t     System.out.println(\"x\");\n\t\t\t\t\t     }\n\t\t\t\t\t     }",
                            "5. public class yes{\n\t\t\t\t\t     public static void main(String[]args){\n\t\t\t\t\t     int x=38,y=3,z,total;\n\n\t\t\t\t\t     z=y-x;\n\t\t\t\t\t     total=x+z;\n\t\t\t\t\t     System.out.println(total);\n\t\t\t\t\t     }\n\t\t\t\t\t     }",
                            "6. public class yessir{\n\t\t\t\t\t     int cat=5;\n\t\t\t\t\t     public static void main(String[]args){\n\t\t\t\t\t     System.out.println(\"Hi I am \" +cat);\n\t\t\t\t\t     }\n\t\t\t\t\t     }",
                            "7. public class Main{\n\t\t\t\t\t     String name=\"sircris\";\n\t\t\t\t\t     public static void main(String[]args){\n\t\t\t\t\t     Main obj = new Main();\n\t\t\t\t\t     System.out.println(\"Hi \" +obj.name);\n\t\t\t\t\t     }\n\t\t\t\t\t     }",
                            "8. public class Main{\n\t\t\t\t\t     int name=\"Adriane\";\n\t\t\t\t\t     String age=23;\n\t\t\t\t\t     public static void main(String[]args){\n\t\t\t\t\t     System.out.println(\"My name is \" +name+ \"and I am \" +age);\n\t\t\t\t\t     }\n\t\t\t\t\t     }",
                            "9. public class Main{\n\t\t\t\t\t     public static void main(String[]args){\n\t\t\t\t\t     rizz();\n\t\t\t\t\t     }\n\n\t\t\t\t\t     static void rizz(){\n\t\t\t\t\t     System.out.print(\"Watch me rizz\");\n\t\t\t\t\t     }\n\t\t\t\t\t     }",
                            "10. public class Main{\n\t\t\t\t\t     public static void main(String[]args){\n\t\t\t\t\t     Main obj = new Main();\n\t\t\t\t\t     obj.hi();\n\t\t\t\t\t     }\n\n\t\t\t\t\t     public void hi(){\n\t\t\t\t\t     System.out.print(\"what if\");\n\t\t\t\t\t     }\n\t\t\t\t\t     }"};
        String expertc[]={"\n\n\t\t\t\t\t     A. Hello World         B. HelloWorld\n\t\t\t\t\t     C. helloworld          D. Error",
                            "\n\n\t\t\t\t\t     A. Hello World         B. HelloWorld\n\t\t\t\t\t     C. helloworld          D. Error",
                            "\n\n\t\t\t\t\t     A. a        B. 20\n\t\t\t\t\t     C. who      D. Error    ",
                            "\n\n\t\t\t\t\t     A. x        B. 10\n\t\t\t\t\t     C. 5        D. Error         ",
                            "\n\n\t\t\t\t\t     A. -35      B. 38\n\t\t\t\t\t     C. 41       D. 3          ",
                            "\n\n\t\t\t\t\t     A. Hi I am 5        B. Hi I am cat     \n\t\t\t\t\t     C. cat              D. Error         ",
                            "\n\n\t\t\t\t\t     A. Hi sircris        B. Hi name    \n\t\t\t\t\t     C. Hi              D. Error          ",
                            "\n\n\t\t\t\t\t     A. My name is name and I am age        B. My name is 23 and I am Adriane     \n\t\t\t\t\t     C. My name is Adriane and I am 23      D. Error         ",
                            "\n\n\t\t\t\t\t     A. Watch me rizz        B. rizz     \n\t\t\t\t\t     C. No display       D. Error         ",
                            "\n\n\t\t\t\t\t     A. obj.hi        B. hi      \n\t\t\t\t\t     C. what if       D. Error         ",};
        char experta[]={'D','D','B','A','D','D','A','D','A','C'};
        char experta1[]={'d','d','b','a','d','d','a','d','a','c'};
        question(expertq, expertc, experta, experta1);
        return 0;
    }
    
}