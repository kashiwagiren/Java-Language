import java.util.Scanner;

class mainQuiz {
    private static int score = 0;
    private static int total_questions = 0;
    private static int scoreViewing = 0;

    private static boolean cheatsEnabled = false;
    public static boolean colorsEnabled = true;
    public static Scanner scanner = new Scanner(System.in);
    
    private static final String ASCII_ART = " ____  _     _  ____    _____ ____  _      _____\n/  _ \\/ \\ /\\/ \\/_   \\  /  __//  _ \\/ \\__/|/  __/\n| / \\|| | ||| | /   /  | |  _| / \\/|| |\\/|||  \\  \n| \\_\\|| \\_/|| |/   /_  | |_//| |-||| |  |||  /_ \n\\____\\\\____/\\_/\\____/  \\____\\\\_/ \\|\\_/  \\|\\____\\";
    
    public static void main(String[] args) {
        char choice;
        
        while (true) {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println((colorsEnabled ? "\u001B[36m" + ASCII_ART + "\u001B[0m" : ASCII_ART));
            System.out.println(" _______________________________________");
            System.out.println("/                                       \\");
            System.out.println("|                                       |");
            System.out.println("|       Press '" + (colorsEnabled ? "\u001B[92mS\u001B[0m" : "S") + "' To Start              |");
            System.out.println("|       Press '" + (colorsEnabled ? "\u001B[95mI\u001B[0m" : "I") + "' For Info              |");
            System.out.println("|       Press '" + (colorsEnabled ? "\u001B[34mV\u001B[0m" : "V") + "' To View Score         |");
            System.out.println("|       Press '" + (colorsEnabled ? "\u001B[90mR\u001B[0m" : "R") + "' To Reset              |");
            System.out.println("|       Press '" + (colorsEnabled ? "\u001B[96mO\u001B[0m" : "O") + "' For Settings          |");
            System.out.println("|       Press '" + (colorsEnabled ? "\u001B[91mE\u001B[0m" : "E") + "' To Exit               |");
            System.out.println("|                                       |");
            System.out.println("\\_______________________________________/");
            System.out.print("\n          -> ");
                choice = scanner.next().charAt(0);
                choice = Character.toLowerCase(choice);
            
                switch (choice) {
                    case 's':
                        total_questions = 0;
                        startGame();
                        break;
                    case 'i':
                        gameInfo();
                        break;
                    case 'v':
                        viewScore();
                        break;
                    case 'r':
                        resetScore();
                        break;
                    case 'o':
                        openSettings();
                        break;
                    case 'e':
                        System.exit(0);
                        break;
                    default:
                        System.out.println("          " + (colorsEnabled ? "\u001B[91mInvalid choice.\u001B[0m" : "Invalid choice.") + "");
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        break;
                
            }
        }
    }

    public static void startGame() {
        int level;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            level = displayLevelMenu(scanner);
            if (level != -1) {
                break;
            }
            System.out.println("\n+----------------------------------------+");
            System.out.println("|  Invalid input. Please choose a level  |");
            System.out.println("|    between 1 - 3.                      |");
            System.out.println("+----------------------------------------+");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    
        gameQuestions(level);
    }
    
    private static int displayLevelMenu(Scanner scanner) {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("/----------------------------------------\\");
        System.out.println("+----------------------------------------+");
        System.out.println("|    1. " + (colorsEnabled ? "\u001B[92mEasy\u001B[0m" : "Easy") + "                             |");
        System.out.println("|    2. " + (colorsEnabled ? "\u001B[94mNormal\u001B[0m" : "Normal") + "                           |");
        System.out.println("|    3. " + (colorsEnabled ? "\u001B[91mHard\u001B[0m" : "Hard") + "                             |");
        System.out.println("\\----------------------------------------/");
        System.out.print("\nSelect choice of difficulty (1-3): ");
    
        String input = scanner.next();
        if (input.matches("[1-3]")) {
            return Integer.parseInt(input);
        }
        return -1;
    }

    private static void gameInfo() {
    char pick;
    
    while (true) {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println(" _____________________________________________________ ");
        System.out.println("|                                                     |");
        System.out.println("|    A Quiz Game Project Written & Designed by:       |");
        System.out.println("|                  \u001B[97mKieth Wilbur J. Chua\u001B[0m               |");
        System.out.println("|                     BSCpE - 1st Year                |");
        System.out.println("|_____________________________________________________|");
        System.out.println(" _____________________________________________________");
        System.out.println("|                                                     |");
        System.out.println("|             Press '" + (colorsEnabled ? "\u001B[92mI\u001B[0m" : "I") + "' >> Next                       |");
        System.out.println("|             Press '" + (colorsEnabled ? "\u001B[91mT\u001B[0m" : "T") + "' >> Menu                       |");
        System.out.println("|_____________________________________________________|");
        System.out.print("\n              -> ");
        pick = scanner.next().charAt(0);
        pick = Character.toLowerCase(pick);

        if (pick == 'i') {
            while (true) {
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.println(" _____________________________________________________ ");
                System.out.println("|                                                     |");
                System.out.println("|              What is this game for ?                |");
                System.out.println("|_____________________________________________________|");
                System.out.println("|                                                     |");
                System.out.println("|    The Quiz Game is a coding project that           |");
                System.out.println("|    allows users to play a quiz game written in the  |");
                System.out.println("|    Java programming language. This project is a     |");
                System.out.println("|    multiple choices quiz where you will have to     |");
                System.out.println("|    choose between [A], [B], [C] to input the        |");
                System.out.println("|    correct answer. There are 3 levels of            |");
                System.out.println("|    difficulty: " + (colorsEnabled ? "\u001B[92mEasy\u001B[0m, \u001B[94mNormal\u001B[0m, and \u001B[91mHard\u001B[0m" : "Easy, Normal, and Hard") + ". You can      |");
                System.out.println("|    choose any of these to start the game. After     |");
                System.out.println("|    answering all levels, your total score will be   |");
                System.out.println("|    displayed along with the correct answers. You    |");
                System.out.println("|    can then go back to the main menu. And have      |");
                System.out.println("|    your score viewed in the menu which you can      |");
                System.out.println("|    also reset it if you want.                       |");
                System.out.println("|_____________________________________________________|");
                System.out.println(" _____________________________________________________");
                System.out.println("|                                                     |");
                System.out.println("|             Press '" + (colorsEnabled ? "\u001B[91mT\u001B[0m" : "T") + "' << Menu                       |");
                System.out.println("|_____________________________________________________|");
                System.out.print("\n              -> ");
                pick = scanner.next().charAt(0);
                pick = Character.toLowerCase(pick);

                if (pick == 't') {
                    return;
                } else {
                    System.out.println("              " + (colorsEnabled ? "\u001B[91mInvalid input.\u001B[0m" : "Invalid input.") + "");
                    try {
                        Thread.sleep(1500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        } else if (pick == 't') {
            return;
        } else {
            System.out.println("                 " + (colorsEnabled ? "\u001B[91mInvalid input.\u001B[0m" : "Invalid input.") + "");
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

public static void gameQuestions(int level) {
    char answer;
    if (level > 3) {
        levelProceed(level);
    } else {
    switch (level) {
        case 1:
            System.out.print("\033[H\033[2J");
            System.out.flush();
            String[] questions = { "" + (colorsEnabled ? "\u001B[92mEasy level.\u001B[0m" : "Easy level.") + "\n\n1. What does 'print' do?\n\na) Reads input from the user\n" + (cheatsEnabled ? "\u001B[31mb\u001B[0m" : "b") + ") Prints output to the console\nc) Performs mathematical calculations\n",
                                   "" + (colorsEnabled ? "\u001B[92mEasy level.\u001B[0m" : "Easy level.") + "\n\n2. What is the use for Scanner?\n\n" + (cheatsEnabled ? "\u001B[31ma\u001B[0m" : "a") + ") breaks its input into tokens using a delimiter pattern, which by default matches whitespace\nb) It is a standard input, standard output, and error output streams\nc) their values cannot be changed after they are created\n",
                                   "" + (colorsEnabled ? "\u001B[92mEasy level.\u001B[0m" : "Easy level.") + "\n\n3. The String class represents?\n\na) output\n" + (cheatsEnabled ? "\u001B[31mb\u001B[0m" : "b") + ") character strings\nc) input\n",
                                   "" + (colorsEnabled ? "\u001B[92mEasy level.\u001B[0m" : "Easy level.") + "\n\n4. The System class contains what?\n\n" + (cheatsEnabled ? "\u001B[31ma\u001B[0m" : "a") + ") several useful class fields and methods\nb) a delimiter pattern\nc) whitespaces\n",
                                   "" + (colorsEnabled ? "\u001B[92mEasy level.\u001B[0m" : "Easy level.") + "\n\n5. What is the purpose of:\n\n\t" + (colorsEnabled ? "\u001B[36mSystem.out.flush();\u001B[0m" : "System.out.flush();") + "\n\n" + (cheatsEnabled ? "\u001B[31ma\u001B[0m" : "a") + ") Flushes the stream\nb) Flushes the output\nc) Reads input from the user\n",
                                   "" + (colorsEnabled ? "\u001B[92mEasy level.\u001B[0m" : "Easy level.") + "\n\n6. It is a template for objects\n\na) object\nb) method\n" + (cheatsEnabled ? "\u001B[31mc\u001B[0m" : "c") + ") class\n",
                                   "" + (colorsEnabled ? "\u001B[92mEasy level.\u001B[0m" : "Easy level.") + "\n\n7. What is the two main aspects of object-oriented programming?\n\na) main and method\nb) int and float\n" + (cheatsEnabled ? "\u001B[31mc\u001B[0m" : "c") + ") classes and objects\n",
                                   "" + (colorsEnabled ? "\u001B[92mEasy level.\u001B[0m" : "Easy level.") + "\n\n8. This variable stores values with two states: true or false\n\na) float\n" + (cheatsEnabled ? "\u001B[31mb\u001B[0m" : "b") + ") boolean\nc) char\n",
                                   "" + (colorsEnabled ? "\u001B[92mEasy level.\u001B[0m" : "Easy level.") + "\n\n9. This variable stores text, such as \"Hello\"\n\n" + (cheatsEnabled ? "\u001B[31ma\u001B[0m" : "a") + ") String\nb) System\nc) Scanner\n",
                                   "" + (colorsEnabled ? "\u001B[92mEasy level.\u001B[0m" : "Easy level.") + "\n\n10. All Java variables must be identified with unique names. These unique names are called?\n\na) data types\n" + (cheatsEnabled ? "\u001B[31mb\u001B[0m" : "b") + ") identifiers\nc) byte data types\n"
                                 };
            char[] answers = { 'b', 'a', 'b', 'a', 'a', 'c', 'c', 'b', 'a', 'b' };

            for (int i = 0; i < questions.length; i++) {
                while (true) {
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.println(questions[i]);
                    System.out.print("Your answer: ");
                    answer = Character.toLowerCase(scanner.next().charAt(0));

                    if (answer == 'a' || answer == 'b' || answer == 'c' || answer == answers[i]) {
                        if (answer == answers[i]) {
                            score++;
                            scoreViewing++;
                            System.out.println("\n" + (colorsEnabled ? "\u001B[92mCorrect.\u001B[0m" : "Correct.") + "");
                            try {
                                Thread.sleep(1500);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        } else {
                            System.out.println("\n" + (colorsEnabled ? "\u001B[91mIncorrect!\u001B[0m" : "Incorrect!") + "");
                            try {
                                Thread.sleep(1500);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }

                        total_questions++;
                        break;
                    } else {
                        System.out.print("\033[H\033[2J");
                        System.out.flush();
                        System.out.println("Invalid input. Please enter a, b, c.");
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }

            easyGame(level);
            break;
        
        case 2:
            System.out.print("\033[H\033[2J");
            System.out.flush();
            String[] questions1 = { "" + (colorsEnabled ? "\u001B[94mNormal level.\u001B[0m" : "Normal level.") + "\n\n1. What is the default value of a boolean variable in Java?\n\na) null\n" + (cheatsEnabled ? "\u001B[31mb\u001B[0m" : "b") + ") false\nc) true\n",
                                    "" + (colorsEnabled ? "\u001B[94mNormal level.\u001B[0m" : "Normal level.") + "\n\n2.Which method signature is correct for the main method in a Java program?\n\n" + (cheatsEnabled ? "\u001B[31ma\u001B[0m" : "a") + ") public static void main(String[] args)\nb) public void main(String[] args)\nc) public static void main(String args[])\n",
                                    "" + (colorsEnabled ? "\u001B[94mNormal level.\u001B[0m" : "Normal level.") + "\n\n3. To use a class or package from the library, you need to use the important keyword:\n\n" + (cheatsEnabled ? "\u001B[31ma\u001B[0m" : "a") + ") syntax\nb) class\nc) package\n",
                                    "" + (colorsEnabled ? "\u001B[94mNormal level.\u001B[0m" : "Normal level.") + "\n\n4. OOP stands for?\n\na) Oriented-Object Programming\n" + (cheatsEnabled ? "\u001B[31mb\u001B[0m" : "b") + ") Object-Oriented Programming\nc) Operation-Oriented Programming\n",
                                    "" + (colorsEnabled ? "\u001B[94mNormal level.\u001B[0m" : "Normal level.") + "\n\n5. Which of the following is not a primitive data type in Java?\n\na) int\nb) char\n" + (cheatsEnabled ? "\u001B[31mc\u001B[0m" : "c") + ") String\n",
                                    "" + (colorsEnabled ? "\u001B[94mNormal level.\u001B[0m" : "Normal level.") + "\n\n6. Which Java feature allows us to run the code on different types of machines?\n\na) Robustness\nb) Platform Independence\n" + (cheatsEnabled ? "\u001B[31mc\u001B[0m" : "c") + ") Multithreading\n",
                                    "" + (colorsEnabled ? "\u001B[94mNormal level.\u001B[0m" : "Normal level.") + "\n\n7. This is used when int is not large enough to store the value\n\n" + (cheatsEnabled ? "\u001B[31ma\u001B[0m" : "a") + ") long\nb) double\nc) float\n",
                                    "" + (colorsEnabled ? "\u001B[94mNormal level.\u001B[0m" : "Normal level.") + "\n\n8. What is the keyword for importing a single class?\n\na) package\nb) whole\n" + (cheatsEnabled ? "\u001B[31mc\u001B[0m" : "c") + ") syntax\n",
                                    "" + (colorsEnabled ? "\u001B[94mNormal level.\u001B[0m" : "Normal level.") + "\n\n9. This creates an object of the class and use any of the available methods found in the _______ ?\n\na) package\n" + (cheatsEnabled ? "\u001B[31mb\u001B[0m" : "b") + ") Scanner\nc) System\n",
                                    "" + (colorsEnabled ? "\u001B[94mNormal level.\u001B[0m" : "Normal level.") + "\n\n10. What is the output of the following code?\n\n\t" + (colorsEnabled ? "\u001B[96mclass\u001B[0m Test \u001B[93m{\u001B[0m\n\t\t\u001B[96mpublic static void\u001B[0m main\u001B[95m(\u001B[0m\u001B[96mString\u001B[0m\u001B[34m[]\u001B[0m args\u001B[95m) {\u001B[0m\n\t\t\t\u001B[96mint\u001B[0m x = \u001B[92m10\u001B[0m;\n\t\t\t\u001B[96mint\u001B[0m y = \u001B[92m5\u001B[0m;\n\t\t\tx = x + y;\n\t\t\ty = x - y;\n\t\t\tx = x - y;\n\t\t\tSystem.out.println(\"x = \" + x + \", y = \" + y);\n\t\t\u001B[95m}\u001B[0m\n\t\u001B[93m}\u001B[0m" : "class Test {\n\t\tpublic static void main(String[] args) {\n\t\t\tint x = 10;\n\t\t\tint y = 5;\n\t\t\tx = x + y;\n\t\t\ty = x - y;\n\t\t\tx = x - y;\n\t\t\tSystem.out.println(\"x = \" + x + \", y = \" + y);\n\t\t}\n\t}") + "\n\na) x = 10, y = 5\n" + (cheatsEnabled ? "\u001B[31mb\u001B[0m" : "b") + ") x = 5, y = 10\nc) x = 15, y = 0\n",
                                  };
            char[] answers1 = { 'b', 'a', 'a', 'b', 'c', 'c', 'a', 'c', 'b', 'b' };
            for (int i = 0; i < questions1.length; i++) {
                while (true) {
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.println(questions1[i]);
                    System.out.print("Your answer: ");
                    answer = Character.toLowerCase(scanner.next().charAt(0));

                    if (answer == 'a' || answer == 'b' || answer == 'c' || answer == answers1[i]) {
                        if (answer == answers1[i]) {
                            score++;
                            scoreViewing++;
                            System.out.println("\n" + (colorsEnabled ? "\u001B[92mCorrect.\u001B[0m" : "Correct.") + "");
                            try {
                                Thread.sleep(1500);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        } else {
                            System.out.println("\n" + (colorsEnabled ? "\u001B[91mIncorrect!\u001B[0m" : "Incorrect!") + "");
                            try {
                                Thread.sleep(1500);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        total_questions++;
                        break;
                    } else {
                        System.out.print("\033[H\033[2J");
                        System.out.flush();
                        System.out.println("Invalid input. Please enter a, b, c.");
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }

            normalGame(level);
            break;

        case 3:
            System.out.print("\033[H\033[2J");
            System.out.flush();
            String[] questions2 = { "" + (colorsEnabled ? "\u001B[91mHard level.\u001B[0m" : "Hard level.") + "\n\n1. What is the output of the following code?\n\n\t int x = 0;\n\t int y = 10;\n\t while (x < y) {\n\t\t y--;\n\t\t ++x;\n\t }\n\t System.out.println(x + \", \" + y);\n\na) 5, 5\nb) 5, 6\n" + (cheatsEnabled ? "\u001B[31mc\u001B[0m" : "c") + ") 6, 4\n",
                                    "" + (colorsEnabled ? "\u001B[91mHard level.\u001B[0m" : "Hard level.") + "\n\n2. Which of the following is not a Java keyword?\n\na) volatile\nb) import\n" + (cheatsEnabled ? "\u001B[31mc\u001B[0m" : "c") + ") print\n",
                                    "" + (colorsEnabled ? "\u001B[91mHard level.\u001B[0m" : "Hard level.") + "\n\n3. What does the default constructor return?\n\na) int\nb) float\n" + (cheatsEnabled ? "\u001B[31mc\u001B[0m" : "c") + ") void\n",
                                    "" + (colorsEnabled ? "\u001B[91mHard level.\u001B[0m" : "Hard level.") + "\n\n4. Which of these is a valid method signature in Java?\n\na) public int myMethod()\nb) int myMethod()\n" + (cheatsEnabled ? "\u001B[31mc\u001B[0m" : "c") + ") public void myMethod(int a, String b)\n",
                                    "" + (colorsEnabled ? "\u001B[91mHard level.\u001B[0m" : "Hard level.") + "\n\n5. Which of these is not a correct way to declare and initialize an array in Java?\n\na) int[] arr = new int[5];\nb) int arr[] = {1, 2, 3, 4, 5};\n" + (cheatsEnabled ? "\u001B[31mc\u001B[0m" : "c") + ") int arr[5];\n",
                                    "" + (colorsEnabled ? "\u001B[91mHard level.\u001B[0m" : "Hard level.") + "\n\n6. What is the size of int data type in Java?\n\na) 8 bits\nb) 16 bits\n" + (cheatsEnabled ? "\u001B[31mc\u001B[0m" : "c") + ") 32 bits\n",
                                    "" + (colorsEnabled ? "\u001B[91mHard level.\u001B[0m" : "Hard level.") + "\n\n7. The Scanner class is used to get user input, and it is found in?\n\na) java.import util\nb) java.util.Scanner\n" + (cheatsEnabled ? "\u001B[31mc\u001B[0m" : "c") + ") java.util package\n",
                                    "" + (colorsEnabled ? "\u001B[91mHard level.\u001B[0m" : "Hard level.") + "\n\n8. It is a special class that represents a group of constants (unchangeable variables, like final variables)\n\na) loop\nb) int\n" + (cheatsEnabled ? "\u001B[31mc\u001B[0m" : "c") + ") enum\n",
                                    "" + (colorsEnabled ? "\u001B[91mHard level.\u001B[0m" : "Hard level.") + "\n\n9. It is a block of codes similar to the method\n\na) enum\nb) object\n" + (cheatsEnabled ? "\u001B[31mc\u001B[0m" : "c") + ") constructors\n",
                                    "" + (colorsEnabled ? "\u001B[91mHard level.\u001B[0m" : "Hard level.") + "\n\n10. It is a group of objects which have common properties\n\n" + (cheatsEnabled ? "\u001B[31ma\u001B[0m" : "a") + ") class\nb) field\nc) method\n"
                                  };
            char[] answers2 = { 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'a' };
            for (int i = 0; i < questions2.length; i++) {
                while (true) {
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.println(questions2[i]);
                    System.out.print("Your answer: ");
                    answer = Character.toLowerCase(scanner.next().charAt(0));

                    if (answer == 'a' || answer == 'b' || answer == 'c' || answer == answers2[i]) {
                        if (answer == answers2[i]) {
                            score++;
                            scoreViewing++;
                            System.out.println("\n" + (colorsEnabled ? "\u001B[92mCorrect.\u001B[0m" : "Correct.") + "");
                            try {
                                Thread.sleep(1500);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        } else {
                            System.out.println("\n" + (colorsEnabled ? "\u001B[91mIncorrect!\u001B[0m" : "Incorrect!") + "");
                            try {
                                Thread.sleep(1500);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        total_questions++;
                        break;
                    } else {
                        System.out.print("\033[H\033[2J");
                        System.out.flush();
                        System.out.println("Invalid input. Please enter a, b, c.");
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }

            levelProceed(level);
            break;

        default:
            System.out.println("\nInvalid. Please choose a level between 1 and 3.");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            startGame();
            break;
    }
    
}

}

public static void easyGame(int level) {
    char choice;

    while (true) {
        if (level < 3) {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("\nYou have completed level " + level);
            System.out.printf("\n\nYour current score is %d / %d\n\n", score, total_questions);
            System.out.println("+----------------------------+");
            System.out.println("|  Do you want to proceed    |");
            System.out.println("|    to the next level?      |");
            System.out.println("+----------------------------+");
            System.out.println("|     " + (colorsEnabled ? "[\u001B[92mY\u001B[0m]         [\u001B[91mN\u001B[0m]" : "[Y]         [N]") + "        |");
            System.out.println("+----------------------------+");
            System.out.print("\nEnter your choice: ");
            choice = Character.toLowerCase(scanner.next().charAt(0));

            if (choice == 'y') {
                gameQuestions(2);
                break;
            } else if (choice != 'n' && choice != 'y') {
                System.out.println("\nInvalid.");
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else if (choice == 'n') {
                repeat();
                break;
            }
        }
    }
}

public static void normalGame(int level) {
    char choice;

    while (true) {
        if (level < 3) {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("\nYou have completed level " + level);
            System.out.printf("\n\nYour current score is %d / %d\n\n", score, total_questions);
            System.out.println("+----------------------------+");
            System.out.println("|  Do you want to proceed    |");
            System.out.println("|    to the next level?      |");
            System.out.println("+----------------------------+");
            System.out.println("|     " + (colorsEnabled ? "[\u001B[92mY\u001B[0m]         [\u001B[91mN\u001B[0m]" : "[Y]         [N]") + "        |");
            System.out.println("+----------------------------+");
            System.out.print("\nEnter your choice: ");
            choice = Character.toLowerCase(scanner.next().charAt(0));

            if (choice == 'y') {
                gameQuestions(3);
                break;
            } else if (choice != 'n' && choice != 'y') {
                System.out.println("\nInvalid.");
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else if (choice == 'n') {
                repeat();
                break;
            }
        }
    }
}

public static void levelProceed(int level) {
    char choice;
    int attempts = 3;
    final int PASSING_SCORE = 15;

    while (true) {
            System.out.print("\033[H\033[2J");
            System.out.flush();

            if (score < PASSING_SCORE && attempts > 0) {
                System.out.println("+-----------------------------------------------+");
                System.out.println("| You have not reached the passing score of " + PASSING_SCORE + ". |");
                System.out.println("+-----------------------------------------------+");
                System.out.println("\n\tYou have " + attempts + " attempts left.");
                System.out.print("\n\n Do you want to retry the game? (" + (colorsEnabled ? "\u001B[92mY\u001B[0m/\u001B[91mN\u001B[0m" : "Y/N") + "): ");
                choice = Character.toLowerCase(scanner.next().charAt(0));

                if (choice == 'y') {
                    attempts--;
                    score = 0;
                    total_questions = 0;
                    gameQuestions((level % 3) + 1); 
                    break;
                } else if (choice == 'n') {
                    repeat();
                    break;
                } else {
                    System.out.println("\n" + (colorsEnabled ? "\u001B[91mInvalid input.\u001B[0m" : "Invalid input.") + "\n");
                }
            } else if (score < PASSING_SCORE && attempts == 0) {
                System.out.println("+-----------------------------------------------+");
                System.out.println("| You have not reached the passing score of " + PASSING_SCORE + ". |");
                System.out.println("+-----------------------------------------------+");
                System.out.println("\n\tYour attempts have been used up!");
                repeat();
                break;
            } else {
                char[] message = "Congratulations! You have completed the levels.".toCharArray();
                for (char c : message) {
                    System.out.print(c);
                    System.out.flush();
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } try {
                    Thread.sleep(2500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.printf("\n\nYour total score is %d / %d\n", score, total_questions);
                System.out.println();
                repeat();
                break;
            }
    }
    
    
}    

public static void repeat() {
    char choice;
    
    while (true) {
        System.out.print("\nDo you want to go back to the menu? (" + (colorsEnabled ? "\u001B[92mY\u001B[0m/\u001B[91mN\u001B[0m" : "Y/N") + "): ");
        choice = Character.toLowerCase(scanner.next().charAt(0));

        if (choice == 'y') {
            score = 0;
            main(null);
            break;
        } else if (choice == 'n') {
            System.exit(0);
        } else {
            System.out.println("\n" + (colorsEnabled ? "\u001B[91mInvalid input.\u001B[0m" : "Invalid input.") + "\n");
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

private static void resetScore() {
    score = 0;
    scoreViewing = 0;
    System.out.println("\n          Score have been reset!");
    try {
        Thread.sleep(1500);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}

private static void viewScore() {
    int maxScoreViewing = 30;
    int displayScore = Math.min(scoreViewing, maxScoreViewing);
    System.out.println("\n             Current score: " + displayScore);
    try {
        Thread.sleep(1500);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}

public static void openSettings() {
    char choice;
    
    while (true) {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println(" ______________________________________________");
        System.out.println("/                                              \\");
        System.out.println("|                                              |\n|         Settings                             |\n|                                              |");
        System.out.println("|                                              |");
        System.out.println("|         Press '1' For Cheats (" + (cheatsEnabled ? "\u001B[31mEnabled\u001B[0m" : "Disabled") + ")      |");
        System.out.println("|         Press '2' For Colors (" + (colorsEnabled ? "\u001B[91mE\u001B[0m\u001B[92mn\u001B[0m\u001B[93ma\u001B[0m\u001B[94mb\u001B[0m\u001B[95ml\u001B[0m\u001B[96me\u001B[0m\u001B[90md\u001B[0m" : "Disabled") + ")       |");
        System.out.println("|                                              |\n|         Press 'M' To Return to Menu          |    ");
        System.out.print("|                                              |\n|                                              |\n");
        System.out.println("\\______________________________________________/ ");
        System.out.print("\n          -> ");
        choice = scanner.next().charAt(0);
        choice = Character.toLowerCase(choice);

        switch (choice) {
            case '1':
                toggleCheats();
                break;
            case '2':
                toggleColors();
                break;
            case 'm':
                return;
            default:
                System.out.println("          \u001B[91mInvalid choice.\u001B[0m");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

}

public static void toggleCheats() {
    if (!cheatsEnabled) {
        String password;
        String correctPassword = "JavaQuizGame";

        System.out.print("\n          Enter the password to enable cheats: ");
        scanner.nextLine(); // Consume newline left-over
        password = scanner.nextLine();

        if (password.equals(correctPassword)) {
            cheatsEnabled = !cheatsEnabled;
            System.out.println("\n          Cheats have been enabled!");
        } else {
            System.out.println("\n          \u001B[91mIncorrect password.\u001B[0m");
        }

    } else {
        cheatsEnabled = !cheatsEnabled;
        System.out.println("\n          Cheats have been disabled!");
    }
    try {
        Thread.sleep(1500);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}


public static void toggleColors() {
    colorsEnabled = !colorsEnabled;

    if (colorsEnabled) {
        System.out.println("\n          Colors have been \u001B[91me\u001B[0m\u001B[92mn\u001B[0m\u001B[93ma\u001B[0m\u001B[94mb\u001B[0m\u001B[95ml\u001B[0m\u001B[96me\u001B[0m\u001B[90md\u001B[0m!");
    } else {
        System.out.println("\n          Colors have been disabled!");
    }
    try {
        Thread.sleep(1500);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}

}