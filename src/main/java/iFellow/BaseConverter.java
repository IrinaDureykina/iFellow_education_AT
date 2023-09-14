package iFellow;

public class BaseConverter {
    double value;
    int units;
    double convertedValue;

    public BaseConverter(double value, int units) {
        this.value = value;
        this.units = units;
        this.convertedValue = convert();
    }

    public double convert() {
        if (units == 1) {
            return (value * 1.8) - 32;
        } else {
            return value + 273.15;
        }
    }
}