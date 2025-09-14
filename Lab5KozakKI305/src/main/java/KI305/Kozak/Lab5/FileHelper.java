/**Package for Lab 5 */
package KI305.Kozak.Lab5;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * FileHelper class simplifies interaction with files
 * like writing to or reading from .txt, .bin files
 */
public class FileHelper {
    private String filename = "";

    /**
     * Creates a Filehelper with default values.
     */
    public FileHelper(){}

    /**
     * Creates a FileHelper with provided filename
     * 
     * @param filename file that will be writen to
     */
    public FileHelper(String filename){
        this.filename = filename;
    }

    /**
     * Gets the filename.
     * 
     * @return filename.
     */
    public String getFilename() {
        return this.filename;
    }

    /**
     * Sets the new filename.
     * 
     * @param filename new filename.
     */
    public void setFilename(String filename) {
        this.filename = filename;
    }

    /**
     * Writes into {@code filename}.txt file
     * 
     * @param result the value to write
     * @throws FileNotFoundException if file couldn't be opened
     */
    public void writeTxt(double result) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(new File(filename));
        pw.printf("%f", result);
        pw.close();
    }

    /**
     * Returns the file format of current {@code filename}
     * 
     * @return the file format.
     */
    public String getFileFormat(){
        String[] fileFormatArr = filename.split("\\.");
        return fileFormatArr[fileFormatArr.length - 1];
    }

    /**
     * Reads the data from current {@code filename}.txt
     * 
     * @return data from file
     */
    public double readTxt() {
        double result = 0.0;
        try {
            File f = new File(filename);
            if (!f.exists())
                throw new FileNotFoundException("File" + filename + "not found.");

            Scanner s = new Scanner(f);
            result = s.nextDouble();
            s.close();

        } catch (FileNotFoundException ex) {
            System.out.print(ex.getMessage());
        }
        return result;
    }

    /**
     * Writes into {@code filename}.bin file
     * 
     * @param result value to write
     * @throws FileNotFoundException if file couldn't be opened
     * @throws IOException if there's issue writting to file
     */
    public void writeBin(double result) throws FileNotFoundException, IOException {
        DataOutputStream f = new DataOutputStream(new FileOutputStream(filename));
        f.writeDouble(result);
        f.close();
    }

    /**
     * Reads the data from current {@code filename}.bin
     * 
     * @return data from file
     * @throws FileNotFoundException if file couldn't be opened
     * @throws IOException if there's issue writting to file
     */
    public double readBin() throws FileNotFoundException, IOException{
        double result = 0.0;
        
        DataInputStream f = new DataInputStream(new FileInputStream(filename));
        result = f.readDouble();
        f.close();

        return result;
    }
}