import com.model.FileHandler;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FileHandler handler = new FileHandler();
        while(true) {
            System.out.println("============= Writer Program ===============\n" +
                        "Do you want write file?(Y/N or y/n):\n");
            Scanner sc = new Scanner(System.in);
            String writeChoice = sc.nextLine();
            if (writeChoice.equalsIgnoreCase("y")) {
                System.out.print("Please input path file: ");
                String filePath = sc.nextLine();

                System.out.print("Please input content file: ");
                String fileContent = sc.nextLine();

                try {
                    handler.writeFile(filePath, fileContent);
                } catch (Exception e) {
                    System.out.println("Error writing file: " + e.getMessage());
                }
            }
            System.out.print("Do you want read file?(Y/N or y/n): ");
            String readChoice = sc.nextLine();

            if (readChoice.equalsIgnoreCase("Y")) {
                // Handle reading from a file
                System.out.print("Please input path file: ");
                String filePath = sc.nextLine();

                try {
                    String fileContent = handler.readFile(filePath);
                    System.out.println("File content:");
                    System.out.println(fileContent);
                    System.out.println("Read file success.");
                } catch (Exception e) {
                    System.err.println("Error reading from file: " + e.getMessage());
                }
            }

            System.out.print("Do you want to continue? (Y/N or y/n): ");
            String continueChoice = sc.nextLine();

            if (continueChoice.equalsIgnoreCase("N")) {
                break;
            }

            sc.close();
        }
    }
}
