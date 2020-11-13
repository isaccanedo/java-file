package br.com.isaccanedo;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

/**
 * @author Isac Canedo
 */

public class FileDemo {

    public static void main(String[] args) throws IOException {
        String fname = "src";
        File file = new File(fname);
        System.out.println(file.isFile());
        System.out.println(file.isDirectory());
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getCanonicalPath());
        System.out.println(file.getParentFile());

        listFiles(file);

        FileFilter filter = (f) -> f.isDirectory() ? true : f.getName().endsWith(".txt");

        System.out.println("Listando todos os arquivos de texto");
        listJavaFiles(file, filter);
    }

    static void listFiles(File f) {
        System.out.println("Listando arquivos para: " + f);
        if (f.isDirectory()) {
            File[] ff = f.listFiles();
            for (File a : ff) {
                if (a.isDirectory())
                    listFiles(a);
                else
                    System.out.println(a.getName());

            }
        }
        System.out.println();
    }

    static void listJavaFiles(File f, FileFilter filter) {

        if (f.isDirectory()) {
            File[] ff = f.listFiles(filter);
            for (File a : ff) {
                if (a.isDirectory())
                    listJavaFiles(a, filter);
                else
                    System.out.println(a.getName());

            }
        }
    }
}
