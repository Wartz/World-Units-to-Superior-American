package com.schlimmer.wutsaConvert;

/**
 * Created by joe on 11/2/14.
 */
public class ConversionMath {
    double unitValue;
    String unitMeasurementType;
    String unitConvertToType;
    private double inchesToCm = 2.54;
    private double cmToInches = 0.3937;
    private String mile = "mi";
    private String kilometer = "km";
    private int miValue = 5280;
    private int ftValue = 12;
    private int inValue = 1;
    private int kmValue = 1000;
    private int mValue = 100;
    private int cmValue = 1;

    public ConversionMath()
    {
        unitValue = 0;
        unitMeasurementType = "";
        unitConvertToType = "";
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
