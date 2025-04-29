import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void update(String line) {
        String[] values = line.split(",");

        LocalTime now = LocalTime.now();

        updateLocation(Double.parseDouble(values[10].trim()), Double.parseDouble(values[2].trim()), Double.parseDouble(values[3].trim()), now);
        updateAltitude(Double.parseDouble(values[4].trim()), Double.parseDouble(values[7].trim()), Double.parseDouble(values[8].trim()), now);
        //updateGroundHeight(Double.parseDouble(values[5].trim()), Double.parseDouble(values[6].trim()));
        updateSpeed(Double.parseDouble(values[9].trim()), Double.parseDouble(values[19].trim()), Double.parseDouble(values[20].trim()), Double.parseDouble(values[21].trim()));
        updateGPS(Double.parseDouble(values[12].trim()), Double.parseDouble(values[13].trim()), now);
        updateMax(Double.parseDouble(values[15].trim()), Double.parseDouble(values[16].trim()), Double.parseDouble(values[17].trim()), Double.parseDouble(values[18].trim()));
        updateBattery(Double.parseDouble(values[38].trim()), Double.parseDouble(values[46].trim()), Double.parseDouble(values[45].trim()), Double.parseDouble(values[14].trim()), Double.parseDouble(values[39].trim()), Double.parseDouble(values[40].trim()), Double.parseDouble(values[41].trim()), Double.parseDouble(values[42].trim()), Double.parseDouble(values[43].trim()), Double.parseDouble(values[44].trim()), now);
        updateOrientation(Double.parseDouble(values[22].trim()), Double.parseDouble(values[23].trim()), Double.parseDouble(values[24].trim()), Double.parseDouble(values[35].trim()), Double.parseDouble(values[36].trim()), Double.parseDouble(values[37].trim()));
        updateRC(Double.parseDouble(values[27].trim()), Double.parseDouble(values[28].trim()), Double.parseDouble(values[29].trim()), Double.parseDouble(values[30].trim()), Double.parseDouble(values[31].trim()), Double.parseDouble(values[32].trim()), Double.parseDouble(values[33].trim()), Double.parseDouble(values[34].trim()), now);
        updateFlightControl(Integer.parseInt(values[49].trim()), values[50].trim());
        try {
            message(values[51]);
        } catch (Exception e) {}
    }

    public static void updateLocation(double distance_feet, double latitude, double longitude, LocalTime time) {
        System.out.println("distance_feet: " + distance_feet);
//        System.out.println("latitude: " + latitude);
//        System.out.println("longitude: " + longitude);
    }
    public static void updateAltitude(double heightAboveTakeoff_feet, double altitudeAboveSeaLevel_feet, double heightSonar_feet, LocalTime now){
//        System.out.println("heightAboveTakeoff_feet: " + heightAboveTakeoff_feet);
//        System.out.println("altitudeAboveSeaLevel_feet: " + altitudeAboveSeaLevel_feet);
//        System.out.println("heightSonar_feet: " + heightSonar_feet);
    }
    public static void updateGroundHeight(double heightAboveGroundAtDroneLocation_feet, double groundElevationAtDroneLocation_feet){
//        System.out.println("heightAboveGroundAtDroneLocation_feet: " + heightAboveGroundAtDroneLocation_feet);
//        System.out.println("groundElevationAtDroneLocation_feet: " + groundElevationAtDroneLocation_feet);
    }
    public static void updateSpeed(double speed_mps, double xSpeed_mps, double ySpeed_mps, double zSpeed_mps) {
//        System.out.println("speed_mps: " + speed_mps);
//        System.out.println("xSpeed_mps: " + xSpeed_mps);
//        System.out.println("ySpeed_mps: " + ySpeed_mps);
//        System.out.println("zSpeed_mps: " + zSpeed_mps);
    }
    public static void updateGPS(double satellites, double gpsLevel, LocalTime now){
//        System.out.println("satellites: " + satellites);
//        System.out.println("gpsLevel: " + gpsLevel);
    }
    public static void updateMax(double maxAltitude_feet, double maxAscent_feet, double maxSpeed_mph, double maxDistance_feet){
//        System.out.println("maxAltitude_feet: " + maxAltitude_feet);
//        System.out.println("maxAscent_feet: " + maxAscent_feet);
//        System.out.println("maxSpeed_mph: " + maxSpeed_mph);
//        System.out.println("maxDistance_feet: " + maxDistance_feet);

    }
    public static void updateBattery(double batteryPercentage, double batteryTemperature_f, double current_A, double voltage_v, double voltageCell1, double voltageCell2, double voltageCell3, double voltageCell4, double voltageCell5, double voltageCell6, LocalTime now){
//        System.out.println("batteryPercentage: " + batteryPercentage);
//        System.out.println("batteryTemperature_ff: " + batteryTemperature_f);
//        System.out.println("current_A: " + current_A);
//        System.out.println("voltage_v: " + voltage_v);
//        System.out.println("voltageCell1: " + voltageCell1);
//        System.out.println("voltageCell2: " + voltageCell2);
//        System.out.println("voltageCell3: " + voltageCell3);
//        System.out.println("voltageCell4: " + voltageCell4);
//        System.out.println("voltageCell5: " + voltageCell5);
//        System.out.println("voltageCell6: " + voltageCell6);
    }
    public static void updateOrientation(double compassHeading_degrees, double pitch_degrees, double roll_degrees, double gimbalHeading_degrees, double gimbalPitch_degrees, double gimbalRoll_degrees){
//        System.out.println("compassHeading_degrees: " + compassHeading_degrees);
//        System.out.println("pitch_degrees: " + pitch_degrees);
//        System.out.println("roll_degrees: " + roll_degrees);
//        System.out.println("gimbalHeading_degrees: " + gimbalHeading_degrees);
//        System.out.println("gimbalPitch_degrees: " + gimbalPitch_degrees);
//        System.out.println("gimbalRoll_degrees: " + gimbalRoll_degrees);
    }

    public static void updateRC(double rcElevator, double rcAileron, double rcThrottle, double rcRudder, double rcElevator_percent, double rcAileron_percent, double rcThrottle_percent, double	rcRudder_percent, LocalTime now){
//        System.out.println("rcElevator: " + rcElevator);
//        System.out.println("rcAileron: " + rcAileron);
//        System.out.println("rcThrottle: " + rcThrottle);
//        System.out.println("rcRudder: " + rcRudder);
//        System.out.println("rcElevator_percent: " + rcElevator_percent);
//        System.out.println("rcAileron_percent: " + rcAileron_percent);
//        System.out.println("rcThrottle_percent: " + rcThrottle_percent);
//        System.out.println("rcRudder_percent: " + rcRudder_percent);
    }
    public static void updateFlightControl(int flycStateRaw, String flycState){
//        System.out.println("flycStateRaw: " + flycStateRaw);
//        System.out.println("flycState: " + flycState);
    }
    public static void message(String message) {
//        System.out.println(message);
    }

    public static void main(String[] args) {
        Random rand = new Random();

        File directory = new File("Airdata/");
        File[] files = directory.listFiles();
        for (File file : files) {
            System.out.println("--------------------------------------------");
            System.out.println("New file: " + file.getName());
            try {
                BufferedReader reader = new BufferedReader(new FileReader(file));

                String line;
                line = reader.readLine();
                String[] headers = line.split(",");

                while ((line = reader.readLine()) != null) {
                    update(line);
                    Thread.sleep(rand.nextInt(10) * 20);
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }

    }
}
