import java.util.Scanner;

public class mainQuiz {
    private static int score = 0;
    private static int total_questions = 0;
    private static int scoreViewing = 0;

    private static boolean cheatsEnabled = false;
    public static boolean colorsEnabled = true;
    
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
            Scanner scannerOne = new Scanner(System.in);
            choice = scannerOne.next().charAt(0);
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
    Scanner scannerTwo = new Scanner(System.in);
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
        pick = scannerTwo.next().charAt(0);
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
                System.out.println("|    choose between [A], [B], [C], or [D] to input    |");
                System.out.println("|    the correct answer. There are 3 levels of        |");
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
                pick = scannerTwo.next().charAt(0);
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
    Scanner scannerThree = new Scanner(System.in);
    char answer;
    
    switch (level) {
        case 1:
            System.out.print("\033[H\033[2J");
            System.out.flush();
            String[] questions = { "" + (colorsEnabled ? "\u001B[92mEasy level.\u001B[0m" : "Easy level.") + "\nWhat does 'printf' do?\n\na) Reads input from the user\n" + (cheatsEnabled ? "\u001B[31mb\u001B[0m" : "b") + ") Prints output to the console\nc) Performs mathematical calculations\n",
                                   "\n What is the use for Scanner?\n\n" + (cheatsEnabled ? "\u001B[31ma\u001B[0m" : "a") + ") breaks its input into tokens using a delimiter pattern, which by default matches whitespace\nb) It is a standard input, standard output, and error output streams\nc) their values cannot be changed after they are created\n",
                                   "\n The String class represents?\n\na) output\n" + (cheatsEnabled ? "\u001B[31mb\u001B[0m" : "b") + ") character strings\nc) input\n",
                                   "\n The System class contains what?\n\n" + (cheatsEnabled ? "\u001B[31ma\u001B[0m" : "a") + ") several useful class fields and methods\nb) a delimiter pattern\nc) whitespaces\n",
                                   "\n What is the purpose of:\n\n\t" + (colorsEnabled ? "\u001B[36mSystem.out.flush();\u001B[0m" : "System.out.flush();") + "\n\n" + (cheatsEnabled ? "\u001B[31ma\u001B[0m" : "a") + ") Flushes the stream\nb) Flushes the output\nc) Reads input from the user\n" };
            char[] answers = { 'b', 'a', 'b', 'a', 'a' };

            for (int i = 0; i < questions.length; i++) {
                while (true) {
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.println(questions[i]);
                    System.out.print("Your answer: ");
                    answer = Character.toLowerCase(scannerThree.next().charAt(0));

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

            levelProceed(level);
            break;
        
        case 2:
            System.out.print("\033[H\033[2J");
            System.out.flush();
            String[] questions1 = { "" + (colorsEnabled ? "\u001B[94mNormal level.\u001B[0m" : "Normal level.") + "\nWhat is the default value of a boolean variable in Java?\n\na) null\n" + (cheatsEnabled ? "\u001B[31mb\u001B[0m" : "b") + ") false\nc) true\n",
                                    "\nWhich method signature is correct for the main method in a Java program?\n\n" + (cheatsEnabled ? "\u001B[31ma\u001B[0m" : "a") + ") public static void main(String[] args)\nb) public void main(String[] args)\nc) public static void main(String args[])\n",
                                    "\nWhat is the output of the following code?\n\n\t" + (colorsEnabled ? "\u001B[96mclass\u001B[0m Test \u001B[93m{\u001B[0m\n\t\t\u001B[96mpublic static void\u001B[0m main\u001B[95m(\u001B[0m\u001B[96mString\u001B[0m\u001B[34m[]\u001B[0m args\u001B[95m) {\u001B[0m\n\t\t\t\u001B[96mint\u001B[0m x = \u001B[92m10\u001B[0m;\n\t\t\t\u001B[96mint\u001B[0m y = \u001B[92m5\u001B[0m;\n\t\t\tx = x + y;\n\t\t\ty = x - y;\n\t\t\tx = x - y;\n\t\t\tSystem.out.println(\"x = \" + x + \", y = \" + y);\n\t\t\u001B[95m}\u001B[0m\n\t\u001B[93m}\u001B[0m" : "class Test {\n\t\tpublic static void main(String[] args) {\n\t\t\tint x = 10;\n\t\t\tint y = 5;\n\t\t\tx = x + y;\n\t\t\ty = x - y;\n\t\t\tx = x - y;\n\t\t\tSystem.out.println(\"x = \" + x + \", y = \" + y);\n\t\t}\n\t}") + "\n\na) x = 10, y = 5\n" + (cheatsEnabled ? "\u001B[31mb\u001B[0m" : "b") + ") x = 5, y = 10\nc) x = 15, y = 0\n",
                                    "\nTo use a class or package from the library, you need to use the important keyword:\n\na) syntax\nb) class\nc) package\n", };
            char[] answers1 = { 'b', 'a', 'b', 'a' };
            for (int i = 0; i < questions1.length; i++) {
                while (true) {
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.println(questions1[i]);
                    System.out.print("Your answer: ");
                    answer = Character.toLowerCase(scannerThree.next().charAt(0));

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

            levelProceed(level);
            break;

        case 3:
            System.out.print("\033[H\033[2J");
            System.out.flush();
            String[] questions2 = { "" + (colorsEnabled ? "\u001B[91mHard level.\u001B[0m" : "Hard level.") + "\n" };
            char[] answers2 = { 'b' };
            for (int i = 0; i < questions2.length; i++) {
                while (true) {
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.println(questions2[i]);
                    System.out.print("Your answer: ");
                    answer = Character.toLowerCase(scannerThree.next().charAt(0));

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

public static void levelProceed(int level) {
    Scanner scannerFour = new Scanner(System.in);
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
            choice = Character.toLowerCase(scannerFour.next().charAt(0));
            
            if (choice == 'y') {
                gameQuestions(level + 1);
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
        } else {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            char[] message = "Congratulations! You have completed the levels.".toCharArray();
            for (char c : message) {
                System.out.print(c);
                System.out.flush();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            try {
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
    Scanner scannerFive = new Scanner(System.in);
    char choice;
    
    while (true) {
        System.out.print("\nDo you want to go back to the menu? (" + (colorsEnabled ? "\u001B[92mY\u001B[0m/\u001B[91mN\u001B[0m" : "Y/N") + "): ");
        choice = Character.toLowerCase(scannerFive.next().charAt(0));

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
    System.out.println("\n             Current score: " + scoreViewing);
    try {
        Thread.sleep(1500);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}

public static void openSettings() {
    Scanner scannerSix = new Scanner(System.in);
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
        choice = scannerSix.next().charAt(0);
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
        Scanner scannerSeven = new Scanner(System.in);
        
        String password;
        String correctPassword = "JavaQuizGame";
        
        System.out.print("\n          Enter the password to enable cheats: ");
        password = scannerSeven.nextLine();
    
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