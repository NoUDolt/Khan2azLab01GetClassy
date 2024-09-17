import jdk.internal.util.xml.impl.Input;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.CREATE;

// use the necessary imports

public class ProductGenerater {
    public static void main(String[] args) {

        //defines the array used to store each record
        ArrayList<Product> product = new ArrayList<>();
        //helps with getting inputted data from user
        SafeInputObj input = new SafeInputObj();

        //puts the created file in the directory this program is in
        File workingDirectory = new File(System.getProperty("user.dir"));
        //creates the output file with all of our data
        Path file = Paths.get(workingDirectory.getPath() + "\\src\\ProductTestData.csv");

        //variable definitions
        boolean done = false;

        String record = "";
        String id = "";
        String product_name = "";
        String product_description = "";
        double product_cost = 0;

        //a while loop that collects the user's inputs and puts it in a record, loops until user wants to stop
        do {
            id = input.getNonZeroLenString("Enter the product ID [6 digits]: ");
            product_name = input.getNonZeroLenString("Enter the product name: ");
            product_description = input.getNonZeroLenString("Enter a short description for the product: ");
            product_cost = input.getRangedDouble("Enter the cost of the product: ", 0, 9999);

            product.add(new Product(id, product_name, product_description, product_cost));

            done = input.getYNConfirm("Would you like to continue? (Y/N): ");

        }while(done);

        //a for loop that outputs each created record into the output file
        for(Product p : product)
            System.out.println(p);

        try
        {
            // Typical java pattern of inherited classes
            // we wrap a BufferedWriter around a lower level BufferedOutputStream
            OutputStream out =
                    new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer =
                    new BufferedWriter(new OutputStreamWriter(out));

            // Finally can write the file LOL!

            for(Product item : product)
            {
                writer.write(item.toCSV());  // stupid syntax for write rec
                // 0 is where to start (1st char) the write
                // rec. length() is how many chars to write (all)
                writer.newLine();  // adds the new line

            }
            writer.close(); // must close the file to seal it and flush buffer
            System.out.println("Data file written!");
        }
        //catches any errors
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
