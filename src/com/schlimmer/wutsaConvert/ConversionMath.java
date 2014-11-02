package com.schlimmer.wutsaConvert;

/**
 * Created by joe on 11/2/14.
 */
public class ConversionMath {
    double unitValue;
    String unitMeasurementType;
    String unitConvertToType;
    private double inchesToCm;
    private double cmToInches;
    private String mile;
    private String kilometer;
    private int miValue;
    private int ftValue;
    private int inValue;
    private int kmValue;
    private int mValue;
    private int cmValue;

    public ConversionMath()
    {
        unitValue = 0;
        unitMeasurementType = "";
        unitConvertToType = "";
    }

    static {
        double inchesToCm = 2.54;
        double cmToInches = 0.3937;
        String mile = "mi";
        String kilometer = "km";
        int miValue = 5280;
        int ftValue = 12;
        int inValue = 1;
        int kmValue = 1000;
        int mValue = 100;
        int cmValue = 1;
    }

    public ConversionMath(double inputUnitValue, String inputUnitMeasurementType, String inputUnitConvertToType)
    {
        unitValue = inputUnitValue;
        unitMeasurementType = inputUnitMeasurementType;
        unitConvertToType = inputUnitConvertToType;
    }

    private double kmToMi()
    {
        unitValue = (unitValue * miValue * ftValue * inchesToCm / mValue / kmValue);
        return unitValue;
    }

        /*
        if (unitMeasurementType == "mi" && unitConvertToType == "km")
        {

        }
        else if (unitMeasurementType == "km" && unitConvertToType == "mi")
        {
            unitValue = (unitValue * kmValue * mValue * cmToInches / ftValue / miValue);
        }
        */

    private double filterConversionParameters() {

        char unitTypes = unitMeasurementType.charAt(0) + "-" + unitConvertToType.charAt(0);

        switch (unitTypes) {
            case "km-mi":
                unitValue=kmToMi();
        }

        return unitValue;
    }

    public String toString()
    {
        return unitValue + " <unitType> is equal to "  + this.filterConversionParameters() + " <convertedUnitType>"; //for now
    }
}
