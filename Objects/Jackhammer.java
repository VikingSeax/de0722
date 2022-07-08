package Objects;

import Enums.ToolCode;

public class Jackhammer extends Tool {
    public Jackhammer (ToolCode toolCode) {
        super(toolCode, "Jackhammer", toolCode == ToolCode.JAKD ? "DeWalt" : "Ridgid", (float)2.99, false, false);
    }
}
