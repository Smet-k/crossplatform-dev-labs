package com.NULP.Lab1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Lab1KozakKI305 class implements example program for Lab. task №1
 */
public class Lab1KozakKI305 {

    /**
     * Static method CustomPrint outputs S string into the terminal and file
     * simultaneously
     *
     * @param s output string
     * @param fout writer for the file
     *
     */
    public static void CustomPrint(String s, PrintWriter fout) {
        System.out.print(s);
        fout.print(s);
    }

    /**
     * Init Matrix method initializes and fills the jagged matrix with provided
     * size and symbol
     *
     * @param size Size of the matrix
     * @param symbol Symbol that is used in matrix
     * @return The jagged matrix
     */
    public static String[][] InitMatrix(int size, String symbol) {
        String[][] matrix = new String[size][];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = new String[i + 1];
            Arrays.fill(matrix[i], symbol);
        }
        return matrix;
    }

    /**
     * DrawFigure method reads data from matrix and calls custom print.
     * Used to draw the actual figure.
     *
     * @param matrix Matrix that will be used to draw figure
     * @throws FileNotFoundException if there's a problem with file creation
     *
     */
    public static void DrawFigure(String[][] matrix) throws FileNotFoundException {
        final File outputFile = new File("Figure.txt");
        PrintWriter fout = new PrintWriter(outputFile);

        for (String[] arr : matrix) {
            for (int i = matrix.length; i > 0; i--) {
                if (i <= arr.length) {
                    CustomPrint(arr[i - 1], fout); 
                }else {
                    CustomPrint(" ", fout);
                }
            }
            CustomPrint("\n", fout);
        }

        fout.flush();
        fout.close();
    }

    /**
     * main is a program entry point
     *
     * @param args
     * @throws FileNotFoundException if there's a problem with file creation
     *
     */
    public static void main(String[] args) throws FileNotFoundException {
        final Scanner in = new Scanner(System.in);
        int size;
        String symbol;

        System.out.print("Enter the size of Square Matrix: ");
        size = in.nextInt();
        in.nextLine();

        System.out.print("Enter the filling symbol: ");
        symbol = in.next();

        in.close();
        if (symbol.length() > 1 || symbol.length() == 0) {
            System.err.println(symbol.length() > 1 ? "Too many symbols provided" : "Filling symbol was not provided");
            return;
        }

        String[][] matrix = InitMatrix(size, symbol);
        DrawFigure(matrix);
    }
}
