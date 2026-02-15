package com.example.demo.model;

import java.time.LocalDateTime;
import java.util.List;

public class Vehicle {

    private String id;
    private int speed;
    private int fuelLevel;
    private int engineTemp;

    private int rpm;
    private double batteryVoltage;
    private int brakeTemp;

    private String status;
    private List<String> warnings;
    private boolean resolved;

    private LocalDateTime createdAt;

    public Vehicle() {
        this.createdAt = LocalDateTime.now();
        this.resolved = false;
    }


    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public int getSpeed() { return speed; }
    public void setSpeed(int speed) { this.speed = speed; }

    public int getFuelLevel() { return fuelLevel; }
    public void setFuelLevel(int fuelLevel) { this.fuelLevel = fuelLevel; }

    public int getEngineTemp() { return engineTemp; }
    public void setEngineTemp(int engineTemp) { this.engineTemp = engineTemp; }

    public int getRpm() { return rpm; }
    public void setRpm(int rpm) { this.rpm = rpm; }

    public double getBatteryVoltage() { return batteryVoltage; }
    public void setBatteryVoltage(double batteryVoltage) { this.batteryVoltage = batteryVoltage; }

    public int getBrakeTemp() { return brakeTemp; }
    public void setBrakeTemp(int brakeTemp) { this.brakeTemp = brakeTemp; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public List<String> getWarnings() { return warnings; }
    public void setWarnings(List<String> warnings) { this.warnings = warnings; }

    public boolean isResolved() { return resolved; }
    public void setResolved(boolean resolved) { this.resolved = resolved; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
