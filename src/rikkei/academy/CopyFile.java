package rikkei.academy;


import java.io.*;
import java.util.Scanner;

public class CopyFile {
    public static void copyFileUsingStream(File source, File dest) throws IOException{
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0){
                os.write(buffer, 0, length);
            }
        }finally {
            is.close();
            os.close();
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter source file:");
        String sourcePath = in.nextLine();
        System.out.println("Enter destination file:");
        String desPath = in.nextLine();

        File sourceFile = new File(sourcePath);
        File destFile = new File(desPath);

        try {
            copyFileUsingStream(sourceFile, destFile);
            System.out.println("Copy complete");
        }catch (IOException ioe) {
            System.out.println("Can't copy that file");
            System.out.println(ioe.getMessage());
        }
    }
}
