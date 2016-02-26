package pl.codeme.jse1.oop;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileOperations extends File {

    private static final long serialVersionUID = 2683682626647602604L;

    private File file;

    public FileOperations(File file) throws IOException {
        super(file.getAbsolutePath());
        String path = file.getAbsolutePath() + "\\plik.txt";
        this.file = new File(path);
        if(!file.exists()) {
            file.createNewFile();
        }
    }

    public void save(String text) {
        try(BufferedWriter write = new BufferedWriter(new FileWriter(file, true))) {
            write.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String load() {
        String text = null;
        try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
            text = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return text;
    }

    public static void main(String[] args) throws IOException {
        File dir = new File(ClassLoader.getSystemClassLoader().getResource("META-INF").getPath());
        FileOperations file = new FileOperations(dir);
        file.save("Ala ma kota, a Ola ma psa\r\n");
        System.out.println(file.load());
    }
}
