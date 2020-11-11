package com.bilgeadam.java.tutorials.design_patterns.factory;

public class HardwareFactory {

    private float CPUSpeed = 3.2f;
    private int RAMSize = 8;
    private int HarddiscSize = 2;

    public void setCPUSpeed(float CPUSpeed) {
        this.CPUSpeed = CPUSpeed;
    }

    public void setRAMSize(int RAMSize) {
        this.RAMSize = RAMSize;
    }

    public void setHarddiscSize(int harddiscSize) {
        HarddiscSize = harddiscSize;
    }

    public Hardware createHardware(String type){
        if (type.equalsIgnoreCase("CPU"))
            return new CPU("Intel", CPUSpeed);
        else if (type.equalsIgnoreCase("RAM"))
            return new RAM("DDR3", RAMSize);
        else if (type.equalsIgnoreCase("Harddisc"))
            return new Harddisc(HarddiscSize);
        else
            return null;
    }
}
