package FileHandling;

import java.io.*;
import java.util.Scanner;

public class FileReadingWriting {
    public static void main(String[] args) {

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            boolean choice = true;
            do {
                System.out.println("Enter text to be written - ");
                String line = bufferedReader.readLine();
                writeToFile("output.txt", line);
                System.out.println("Want to add more (yes/no)? ");
                String response = bufferedReader.readLine();
                if (!response.equalsIgnoreCase("yes")) {
                    choice = false;
                }
            } while (choice);

            try {
                System.out.println("Contents of output.txt - ");
                readFromFile("output.txt");
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    private static void writeToFile(String fileName, String line) throws IOException {
        try (Writer writer = new FileWriter(fileName, true)) {
            writer.write(line);
            writer.write("\n"); // Add newline after each line
        }
    }

    private static void readFromFile(String fileName) throws IOException {
        try (FileReader reader = new FileReader(fileName);
             BufferedReader bufferedReader = new BufferedReader(reader)) {
            String fileLine;
            while ((fileLine = bufferedReader.readLine()) != null) {
                System.out.println(fileLine);
            }
        }
    }
}

