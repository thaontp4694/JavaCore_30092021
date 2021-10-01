import java.io.IOException;
import java.io.*;

public class App {
    public static void main(String[] args) throws IOException {
        PrintWriter pw = new PrintWriter("Exam3.txt");

        FileOutputStream fosA = new FileOutputStream("Exam1.txt");
        PrintWriter pwA = new PrintWriter(fosA);
        pwA.println("Nội dung trong file Exam1");
        pwA.close();
        BufferedReader br = new BufferedReader(new FileReader("Exam1.txt"));

        String line = br.readLine();
        while (line != null) {
            pw.println(line);
            line = br.readLine();
        }
        FileOutputStream fosB = new FileOutputStream("Exam2.txt");
        PrintWriter pwB = new PrintWriter(fosB);
        pwB.println("Nội dung trong file Exam2");
        pwB.close();
        br = new BufferedReader(new FileReader("Exam2.txt"));

        line = br.readLine();
        while (line != null) {
            pw.println(line);
            line = br.readLine();
        }
        pw.flush();
        br.close();
        pw.close();
        try (BufferedReader brC = new BufferedReader(new FileReader("Exam3.txt"))) {
            String lineC = null;
            while ((lineC = brC.readLine()) != null) {
                System.out.println(lineC);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
