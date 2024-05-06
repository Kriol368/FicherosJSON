package amiibo;
import java.util.HashMap;
import java.util.Map;

class Amiibo {
    String amiiboSeries;
    String character;
    String gameSeries;
    String head;
    String image;
    String name;
    Map<String, String> release;
    String tail;
    String type;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Amiibo Series: ").append(amiiboSeries).append("\n");
        sb.append("Character: ").append(character).append("\n");
        sb.append("Game Series: ").append(gameSeries).append("\n");
        sb.append("Release Dates: ").append("\n");
        for (Map.Entry<String, String> entry : release.entrySet()) {
            sb.append("\t").append(entry.getKey().toUpperCase()).append(": ").append(entry.getValue()).append("\n");
        }
        sb.append("Image: ").append(image).append("\n");
        return sb.toString();
    }
}
