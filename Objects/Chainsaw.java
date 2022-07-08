package Objects;

import Enums.ToolCode;

public class Chainsaw extends Tool {
    public Chainsaw(ToolCode toolCode) {
        super(toolCode, "Chainsaw", "Stihl", (float)1.49, false, true);
    }
}