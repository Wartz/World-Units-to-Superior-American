package com.schlimmer.wutsaConvert;

/**
 * Created by joe on 11/2/14.
 */
public class ConversionMath {
    double unitValue;
    double convertedValue;
    String unitMeasurementType;
    String unitConvertToType;
    String unitTypes;
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
        convertedValue = 0;
        unitMeasurementType = "";
        unitConvertToType = "";
        unitTypes = "";
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
        unitTypes = unitMeasurementType+unitConvertToType;
    }

    private double kmToMi()
    {
        convertedValue = (unitValue * kmValue * mValue * cmToInches / ftValue / miValue);
        return convertedValue;
    }

    private double miToKm()
    {
        convertedValue = (unitValue * miValue * ftValue * inchesToCm / mValue / kmValue);
        return convertedValue;
    }

    private enum UnitTypesList
        {
            kmmi, mikm
        }


    private double FilterConversionParameters()
    {
        UnitTypesList unitTypesList = UnitTypesList.valueOf(unitTypes);

        switch (unitTypesList) {
            case kmmi:
                convertedValue=kmToMi();
                break;
            case mikm:
                convertedValue=miToKm();
                break;
        }

        return convertedValue;
    }

    public String toString()
    {
        return unitValue + " <unitType> is equal to "  + this.FilterConversionParameters() + " <convertedUnitType>"; //for now
    }
}
