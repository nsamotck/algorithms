package lesson_3;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Stack;

public class BracketAnalyzer {
    private static Stack<String> stack;
    private static final char OPENING_BRACKET = '(';
    private static final char CLOSING_BRACKET = ')';
    private static final char OPENING_SQUARE_BRACKET = '[';
    private static final char CLOSING_SQUARE_BRACKET = ']';
    private static final char OPENING_CURLY_BRACKET = '{';
    private static final char CLOSING_CURLY_BRACKET = '}';

    private BracketAnalyzer() {
    }

    public static Stack<String> getStack() {
        return stack;
    }

    public static void initialize() {
        stack = new Stack<>();
    }

    // Решил немного изменить предложенную на занятии сигнатуру, чтоб можно было узнать номер строки с ошибкой
    private static void check(String input, int lineNum) {
        char[] charLine = input.toCharArray();
        for (char ch : charLine) {
            if (ch == OPENING_BRACKET || ch == OPENING_SQUARE_BRACKET || ch == OPENING_CURLY_BRACKET) {
                stack.push(String.valueOf(ch));
            } else if (ch == CLOSING_BRACKET || ch == CLOSING_SQUARE_BRACKET || ch == CLOSING_CURLY_BRACKET) {
                switch (ch) {
                    case CLOSING_BRACKET:
                        if (stack.peek().equals(String.valueOf(OPENING_BRACKET))) {
                            stack.pop();
                        } else {
                            // Удаляем всё из стека в случае ошибки
                            stack.removeAllElements();
                            throw new RuntimeException(String.format("Missing symbol \"%s\" at line %d", OPENING_BRACKET, lineNum));
                        }
                        break;
                    case CLOSING_SQUARE_BRACKET:
                        if (stack.peek().equals(String.valueOf(OPENING_SQUARE_BRACKET))) {
                            stack.pop();
                        } else {
                            // Удаляем всё из стека в случае ошибки
                            stack.removeAllElements();
                            throw new RuntimeException(String.format("Missing symbol \"%s\" at line %d", OPENING_SQUARE_BRACKET, lineNum));
                        }
                        break;
                    case CLOSING_CURLY_BRACKET:
                        if (stack.peek().equals(String.valueOf(OPENING_CURLY_BRACKET))) {
                            stack.pop();
                        } else {
                            // Удаляем всё из стека в случае ошибки
                            stack.removeAllElements();
                            throw new RuntimeException(String.format("Missing symbol \"%s\" at line %d", OPENING_CURLY_BRACKET, lineNum));
                        }
                        break;
                }
            }
        }
    }

    private static void checkList(List<String> fileLines) {
        for (int lineNum = 0; lineNum < fileLines.size(); lineNum++) {
            check(fileLines.get(lineNum), lineNum + 1);
        }
    }

    public static void checkFile(File fileToCheck) throws IOException {
        checkList(Files.readAllLines(fileToCheck.toPath()));
    }
}