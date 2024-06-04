package parser;

import errorHandler.ErrorHandler;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ParserFacade {
    private final Parser parser;

    public ParserFacade() {
        this.parser = new Parser();
    }

    public void parse(String filePath) {
        try {
            parser.startParse(new Scanner(new File(filePath)));
            System.out.println("Parsing successful!");
        } catch (IOException e) {
            ErrorHandler.printError("Error reading file: " + e.getMessage());
        } catch (Exception e) {
            ErrorHandler.printError("Error parsing file: " + e.getMessage());
        }
    }
}
