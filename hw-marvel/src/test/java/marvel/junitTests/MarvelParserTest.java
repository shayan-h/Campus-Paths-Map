package marvel.junitTests;

import org.junit.Test;
import static marvel.MarvelParser.parseData;
import java.util.HashMap;
import java.util.HashSet;

import static org.junit.Assert.*;

public class MarvelParserTest {

    //////////////////////////////////////////////////////////
    /////  Parse Data Test
    //////////////////////////////////////////////////////////
    @Test
    public void parseDataTest() {
        String filename = "mcu.csv";
        HashMap<String, HashSet<String>> map = new HashMap<>();
        map.put("Iron-Man-1", new HashSet<String>());
        map.get("Iron-Man-1").add("Iron-Man");
        map.put("Iron-Man-2", new HashSet<String>());
        map.get("Iron-Man-2").add("Iron-Man");
        map.get("Iron-Man-2").add("Black-Widow");
        map.put("Iron-Man-3", new HashSet<String>());
        map.get("Iron-Man-3").add("Iron-Man");
        map.put("Captain-America-1", new HashSet<String>());
        map.get("Captain-America-1").add("Captain-America");
        map.put("Avengers", new HashSet<String>());
        map.get("Avengers").add("Iron-Man");
        map.get("Avengers").add("Black-Widow");
        map.get("Avengers").add("Captain-America");
        map.get("Avengers").add("Hawkeye");
        map.put("Captain-America-2", new HashSet<String>());
        map.get("Captain-America-2").add("Captain-America");
        map.get("Captain-America-2").add("Black-Widow");
        assertEquals("HashMaps do not match:", map, parseData(filename));
    }
}
