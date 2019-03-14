public class Patient {

    public String patientID;
    public String name;
    public String checkInDate;
    public String assignedMedPersonnel;

    public Patient(String patient_id, String name, String checkin_date, String assigned_med_personnel) {

        this.patientID = patient_id;
        this.name = name;
        this.checkInDate = checkin_date;
        this.assignedMedPersonnel = assigned_med_personnel;

    }

    @Override

    public String toString() {
        return "Patient ID: " + patientID + "\nName: " + name + "\nCheck In Date: " + checkInDate + "\nAssigned Medical Personnel: " + assignedMedPersonnel +"\n";

    }

}