/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfinal;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import javax.swing.JFileChooser;

public class FileDemo {
    
    // Date and Time
    
        public static String getCurrentTimeUsingCalendar() {
            Calendar cal = Calendar.getInstance();
            Date date=cal.getTime();
            DateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");
            String formattedDate=dateFormat.format(date);
            return formattedDate;
}
    // fxn end
        public String create(){
            Date now = new Date();
SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");
String time = dateFormat.format(now);
JFileChooser fu = new JFileChooser();
        fu.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); 
        fu.showSaveDialog(null);
        String fdest=""+fu.getSelectedFile();
        String date = getCurrentTimeUsingCalendar();
        fdest = fdest+"\\"+date+"\\";
        
        System.out.println(fdest);
        System.out.println(fu.getSelectedFile());
         File dir = new File(fdest);
        dir.mkdir();
        return(""+fdest);
        }
    
    

    public static void main(String args[]) throws IOException {
        Date now = new Date();
SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");
String time = dateFormat.format(now);
JFileChooser fu = new JFileChooser();
        fu.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); 
        fu.showSaveDialog(null);
        String fdest=""+fu.getSelectedFile();
        String date = getCurrentTimeUsingCalendar();
        fdest = fdest+"\\"+date+"\\";
        
        System.out.println(fdest);
        System.out.println(fu.getSelectedFile());
         File dir = new File(fdest);
    dir.mkdir();

        /*Scanner reader = new Scanner(System.in);
        boolean success = false;

        System.out.println("Enter path of directory to create");
        //String dir = reader.nextLine();
        String date = getCurrentTimeUsingCalendar().toString();
        String dir = "D:\\tst\\"+date+"\\";
        
        // Creating new directory in Java, if it doesn't exists
        File directory = new File(dir);
        if (directory.exists()) {
            System.out.println("Directory already exists ...");

        } else {
            System.out.println("Directory does not exist, creating now...");

            success = directory.mkdir();
            if (success) {
                System.out.printf("Successfully created new directory : %s%n", dir);
            } else {
                System.out.printf("Failed to create new directory: %s%n", dir);
            }
        }

        // Creating new file in Java, only if not exists
        System.out.println("Enter file name to be created ");
        String filename = reader.nextLine();*/
          
        /*File f = new File(filename);
        if (f.exists()) {
            System.out.println("File already exists");

        } else {
            System.out.println("No such file exists, creating now");
            success = f.createNewFile();
            if (success) {
                System.out.printf("Successfully created new file: %s%n", f);
            } else {
                System.out.printf("Failed to create new file: %s%n", f);
            }
        }

        // close Scanner to prevent resource leak
        reader.close();*/

    }
}

