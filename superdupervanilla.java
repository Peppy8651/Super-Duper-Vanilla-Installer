import java.io.File;
import java.io.IOException;
import java.util.Scanner;
public class superdupervanilla {
    Scanner scanner;
    public superdupervanilla() {
        System.out.println("Searching for default directory");
        String minecraftPath = System.getenv("APPDATA") + "\\.minecraft";
        File defaultPath = new File(minecraftPath);
        if (defaultPath.exists()) {
            System.out.println("Default directory for Minecraft Java Edition exists, now checking for the Optifine shaderpacks folder.");
            File shaderPath = new File(minecraftPath + "\\shaderpacks");
            if (shaderPath.exists()) {
                System.out.println(minecraftPath + "\\shaderpacks" + " exists, Optifine is likely installed");
                System.out.println("Preparing to install.");
                try {
                    Runtime runtime = Runtime.getRuntime();
                    String runtimeString = ".\\PortableGit\\bin\\git.exe clone git://github.com/Eldeston/Super-Duper-Vanilla.git " + minecraftPath + "\\shaderpacks\\Super-Duper-Vanilla";
                    runtime.exec(runtimeString);
                    System.out.println("Done!");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else {
                System.out.println(minecraftPath + "\\shaderpacks" + " does not exist. Optifine is required for use of this shader, unless you're using some other mod that is not compatible with this installer. If you're sure Optifine is installed, create a new folder in your .minecraft folder called shaderpacks and try again.");
                System.out.println("Would you like to choose another directory? Say yes or no.");
                getAnswer(minecraftPath);
            }
        }
        else {
            System.out.println("Default directory does not exist, would you like to choose another directory? Say yes or no.");
            getAnswer(minecraftPath);
        }
    }
    public static void main(String[] args) {
        new superdupervanilla();
    }
    public void getAnswer(String minecraftPath) {
        scanner = new Scanner(System.in);
        String answer = scanner.nextLine();
        if (answer.toLowerCase().equals("yes")) {
            System.out.println("What directory? Type \"quit\" to quit.");
            getDirectory(minecraftPath);
        }
        else if (answer.toLowerCase().equals("no")) {
            System.out.println("Alright.");
            scanner.close();
        }
        else {
            System.out.println("Not a valid answer. Valid answers are \"yes\" and \"no\". It can be uppercase or lowercase.");
            getAnswer(minecraftPath);
        }
    }
    public void getDirectory(String minecraftPath) {
        scanner = new Scanner(System.in);
        String directory = scanner.nextLine();
        if (directory.toLowerCase().equals("quit")) {
            System.out.println("Very well then, quitting now.");
            scanner.close();
        }
        else {
            File Directory = new File(directory);
            if (Directory.exists()) {
                System.out.println("Directory exists, checking for shaderpacks folder.");
                File shaderpacks = new File(directory + "\\shaderpacks");
                if (shaderpacks.exists()) {
                    System.out.println("Shaderpacks folder inside directory does exist.");
                    System.out.println("Preparing to install.");
                    try {
                        Runtime runtime = Runtime.getRuntime();
                        String runtimeString = ".\\PortableGit\\bin\\git.exe clone git://github.com/Eldeston/Super-Duper-Vanilla.git " + minecraftPath + "\\shaderpacks\\Super-Duper-Vanilla";
                        runtime.exec(runtimeString);
                        System.out.println("Done!");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                else {
                    System.out.println("Shaderpacks folder inside directory does not exist, please use a valid directory.");
                }
            }
            else {
                System.out.println("Directory does not exist. Please enter a valid directory or type \"quit\" to quit.");
                getDirectory(minecraftPath);
            }
        }
    }
}