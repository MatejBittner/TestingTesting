import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class MyHistory_Test {


    @TempDir
    private Path tmpDir;

    @org.junit.jupiter.api.Test
    void read_test1() throws IOException {
        MyHistory h = new MyHistory(tmpDir + "\\abcd.data");

        assertThrows(IOException.class, h::read);
    }

    @org.junit.jupiter.api.Test
    void read_test2() throws IOException {
        MyHistory h = new MyHistory(tmpDir + "\\abcd.data");
        File f = new File(tmpDir + "\\abcd.data");
        
        assertThrows(IOException.class, h::read);
    }


    @org.junit.jupiter.api.Test
    void addLine_test1() {
        MyHistory h = new MyHistory("abcd");
        h.addLine("a");

        assertEquals("a\n", h.toString());
    }


    @org.junit.jupiter.api.Test
    void addLine_test2() {
        MyHistory h = new MyHistory("abcd");
        h.addLine("a");
        h.addLine("a");
        h.addLine("a");

        assertEquals("a\n", h.toString());
    }

    @org.junit.jupiter.api.Test
    void addLine_test3() {
        MyHistory h = new MyHistory("abcd");
        h.addLine("a");
        h.addLine("b");
        h.addLine("c");

        assertEquals("a\nb\nc\n", h.toString());
    }

    @org.junit.jupiter.api.Test
    void save_test() {
        MyHistory h = new MyHistory(tmpDir + "abcd");


        try {
            h.save();
        } catch (IOException e) {
            fail();
        }

    }

}