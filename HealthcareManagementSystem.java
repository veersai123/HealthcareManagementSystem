
abstract class HealthcareProfessional{
    private String name;
    private String licenseNumber;

    public HealthcareProfessional(String name,String licenseNumber){
        this.name=name;
        this.licenseNumber=licenseNumber;
    }

    public String getName() {
        return name;
    }
    public String getLicenseNumber() {
        return licenseNumber;
    }
    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("License Number: " + licenseNumber);
    }

//    public abstract void display();
}

class Doctor extends HealthcareProfessional{
    private String specialization;
    public Doctor(String name,String licenseNumber,String specialization){
        super(name,licenseNumber);
        this.specialization=specialization;
    }
    public void prescribeMedication(String medicine){
        System.out.println("Dr. "+getName()+"prescribed: "+medicine);
    }
    @Override
    public void displayInfo(){
        super.displayInfo();
        System.out.println("Specialization: " + specialization);
        System.out.println("Role: Doctor");
        System.out.println("-----------------------------");
    }
}
class Nurse extends HealthcareProfessional{
    private String shift;
    private String responsibilities;
    public Nurse(String name, String licenseNumber,String shift,String responsibilities) {
        super(name, licenseNumber);
        this.shift = shift;
        this.responsibilities = responsibilities;
    }
    // Method specific to Nurse
    public void managePatient(String patientName) {
        System.out.println("Nurse " + getName() + " is managing patient: " + patientName);
        System.out.println("Responsibilities: " + responsibilities);
    }
    @Override
    public void displayInfo(){
        super.displayInfo();
        System.out.println("Shift: " + shift);
        System.out.println("Responsibilities: " + responsibilities);
        System.out.println("Role: Nurse");
        System.out.println("-----------------------------");
    }
}

public class HealthcareManagementSystem {
    public static void main(String[] args) {
        Doctor doctor = new Doctor("Dr. Amit Sharma", "DOC78945", "Neurology");
        Nurse nurse = new Nurse("Sunita Devi", "NUR45678", "Morning", "Patient monitoring, Medication administration, Wound care");
        // Displaying information
        System.out.println("=== Doctor Information ===");
        doctor.displayInfo();
        System.out.println("=== Nurse Information ===");
        nurse.displayInfo();
        // Using specific methods
        doctor.prescribeMedication("Paracetamol 500mg");
        nurse.managePatient("Rahul Kumar");
    }
}
