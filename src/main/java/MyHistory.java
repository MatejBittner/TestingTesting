import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MyHistory {
    String filename;
    Set<String> set;
    List<String> list;


    public static void main(String[] args) throws IOException {
        MyHistory m = new MyHistory("history.data");
        m.addLine("newer gonna give you up");
        m.addLine("newer gonna let you down");
        m.save();
        System.out.println(m.toString());

    }

    public MyHistory(String fileName) {
        // vytvori instanci pro soubor _fileName_

        filename = fileName;
        set = new HashSet<>();
        list = new ArrayList<String>();
    }

    public void read() throws IOException {
        // načte soubor fileName do paměti, skončí výjimkou pokud soubor nejde načíst

            File f = new File(filename);
            set = new HashSet(Files.readAllLines(f.toPath()));
            list = Files.readAllLines(f.toPath());

            System.out.println("soubor neexistuje");

    }

    public void save() throws IOException {
        // zapíše obsah paměti do souboru, skončí výjimkou pokud soubor nejde uložit
        // pokud soubor již existuje, přepíše jej
        File f = new File(filename);
        FileWriter writer = new FileWriter(f);
        writer.write(toString());
        writer.close();


    }

    public void addLine(String str) {
        // přidá řádek str do paměti pokud tam ještě není,
        // duplicitní řádky ignoruje.
        if(!set.contains(str)){
            set.add(str);
            list.add(str);
        }
    }

    public String toString() {
        // vrátí řetězec obsahující všechny řádky
        String s = "";
        for(String str: list){
            s = s + str + "\n";
        }
        return s;
    }
}
