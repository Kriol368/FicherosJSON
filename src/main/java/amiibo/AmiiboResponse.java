package amiibo;

import java.util.Arrays;

class AmiiboResponse {
    Amiibo[] amiibo;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Amiibo a : amiibo) {
            sb.append(a.toString()).append("\n");
        }
        return sb.toString();
    }
}