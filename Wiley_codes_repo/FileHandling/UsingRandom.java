package FileHandling;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class UsingRandom {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
                try (RandomAccessFile randomAccessFile = new RandomAccessFile("output.txt", "rw")) {
                    boolean choice = true;
                    do {
                        System.out.println("Enter text to be written:");
                        String line = sc.nextLine();
                        randomAccessFile.writeUTF(line);
                        randomAccessFile.seek(0);

                        System.out.println("Want to add more (yes/no)?");
                        String response = sc.nextLine();
                        if (!response.equalsIgnoreCase("yes")) {
                            choice = false;
                        }
                    } while (choice);

                    System.out.println("Contents of output.txt:");
                    String line;
                    while ((line = randomAccessFile.readUTF()) != null) {
                        System.out.println(line);
                    }

                } catch (IOException e) {
                    System.err.println(e.getMessage());
                }
            }
        }


