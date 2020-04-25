package lab4;

import lab4.Service.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader file = new BufferedReader(new FileReader("C:\\Users\\Fwerfad\\IdeaProjects\\OOP_new\\src\\lab4\\ini.property"));
        Scanner scanner = new Scanner(file);
        String parsedString = scanner.nextLine();
        Pattern pattern = Pattern.compile(":");
        String[] strings = pattern.split(parsedString);
        Service service = new Service(Boolean.parseBoolean(strings[1]));

    }
}
