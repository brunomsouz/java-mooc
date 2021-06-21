
import java.util.ArrayList;
import java.util.HashMap;


public class Main {

    public static void main(String[] args) {
        // the following is the same sample program shown in ex 8.13 description
        
        LicensePlate foxBranco = new LicensePlate("BR", "FMB-1060");
        LicensePlate foxPreto = new LicensePlate("BR", "FBR-2603");
        
        VehicleRegistry registry = new VehicleRegistry();
        
        registry.add(foxBranco, "Wanessa");
        registry.add(foxPreto, "Maria");
        
        registry.printLicensePlates();
        registry.printOwners();
    }
}
