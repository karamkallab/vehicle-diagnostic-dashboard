package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Vehicle;

@Service
public class VehicleService {

    private final List<Vehicle> vehicles = new ArrayList<>();

    public Vehicle analyze(Vehicle vehicle) {

        List<String> warnings = new ArrayList<>();
        String status = "OK";

        if(vehicle.getSpeed() > 120) {
            warnings.add("High speed");
            status = "WARNING";
        }

        if(vehicle.getFuelLevel() < 15) {
            warnings.add("Low fuel");
            status = "WARNING";
        }

        if(vehicle.getEngineTemp() > 110) {
            warnings.add("Engine overheating");
            status = "CRITICAL";
        }

        if(vehicle.getRpm() > 6000) {
            warnings.add("RPM too high");
            status = "CRITICAL";
        }

        if(vehicle.getBatteryVoltage() < 11.5) {
            warnings.add("Battery voltage low");
            if(!status.equals("CRITICAL")) {
                status = "WARNING";
            }
        }

        if(vehicle.getBrakeTemp() > 400) {
            warnings.add("Brake temperature high");
            status = "CRITICAL";
        }

        vehicle.setWarnings(warnings);
        vehicle.setStatus(status);

        vehicles.add(vehicle);

        return vehicle;
    }

    public List<Vehicle> getAll() {
        return vehicles;
    }

    public void delete(String id) {
        vehicles.removeIf(v -> v.getId().equals(id));
    }

    public Vehicle update(String id, Vehicle updated) {

        for(Vehicle v : vehicles) {
            if(v.getId().equals(id)) {

                v.setSpeed(updated.getSpeed());
                v.setFuelLevel(updated.getFuelLevel());
                v.setEngineTemp(updated.getEngineTemp());
                v.setRpm(updated.getRpm());
                v.setBatteryVoltage(updated.getBatteryVoltage());
                v.setBrakeTemp(updated.getBrakeTemp());

                return analyze(v);
            }
        }
        return null;
    }

    public Vehicle resolve(String id) {

        for(Vehicle v : vehicles) {
            if(v.getId().equals(id)) {
                v.setResolved(true);
                v.setStatus("RESOLVED");
                return v;
            }
        }
        return null;
    }

    public Stats getStats() {

        int total = vehicles.size();
        int ok = 0;
        int warning = 0;
        int critical = 0;

        for(Vehicle v : vehicles) {
            if(v.getStatus().equals("OK")) ok++;
            if(v.getStatus().equals("WARNING")) warning++;
            if(v.getStatus().equals("CRITICAL")) critical++;
        }

        return new Stats(total, ok, warning, critical);
    }

    public static class Stats {

        private int totalVehicles;
        private int okCount;
        private int warningCount;
        private int criticalCount;

        public Stats(int total, int ok, int warning, int critical) {
            this.totalVehicles = total;
            this.okCount = ok;
            this.warningCount = warning;
            this.criticalCount = critical;
        }

        public int getTotalVehicles() { return totalVehicles; }
        public int getOkCount() { return okCount; }
        public int getWarningCount() { return warningCount; }
        public int getCriticalCount() { return criticalCount; }
    }
}
