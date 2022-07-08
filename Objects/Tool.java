package Objects;

import Enums.ToolCode;

public class Tool {
    private ToolCode toolCode;
    private String toolType;
    private String brand;
    private float dailyCharge;
    private boolean weekendCharge;
    private boolean holidayCharge;
    
    public Tool (ToolCode toolCode, String toolType, String brand, float dailyCharge, boolean weekendCharge, boolean holidayCharge) {
        this.toolCode = toolCode;
        this.toolType = toolType;
        this.brand = brand;
        this.dailyCharge = dailyCharge;
        this.weekendCharge = weekendCharge;
        this.holidayCharge = holidayCharge;
    }

    public ToolCode getToolCode() {
        return toolCode;
    }
    public void setToolCode(ToolCode toolCode) {
        this.toolCode = toolCode;
    }

    public String getToolType() {
        return toolType;
    }
    public void setToolType(String toolType) {
        this.toolType = toolType;
    }

    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }

    public float getDailyCharge() {
        return dailyCharge;
    }
    public void setDailyCharge(float dailyCharge) {
        this.dailyCharge = dailyCharge;
    }

    public boolean isWeekendCharge () {
        return weekendCharge;
    }
    public void setWeekendCharge(boolean weekendCharge) {
        this.weekendCharge = weekendCharge;
    }

    public boolean isHolidayCharge() {
        return holidayCharge;
    }
    public void setHolidayCharge(boolean holidayCharge) {
        this.holidayCharge = holidayCharge;
    }
}
