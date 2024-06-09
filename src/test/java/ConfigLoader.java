import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ConfigLoader {

    public static List<String> getStaticPages() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            Map<String, List<String>> config = mapper.readValue(new File("src/test/resources/static_pages.json"), Map.class);
            return config.get("staticPages");
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load static pages configuration");
        }
    }
}
