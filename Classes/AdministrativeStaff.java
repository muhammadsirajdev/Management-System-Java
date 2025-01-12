import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;



interface Reportable {
    String generateReport(ArrayList<Person> people);
    
    void exportToFile();
}

public class AdministrativeStaff extends Person implements Reportable{
    private int staffId;
    private String role;
    private String department;
    
    public AdministrativeStaff(){
        super();
        this.staffId = 0;
        this.role = null;
        this.department = null;
    }

    public AdministrativeStaff(String name, String email, Date dateOfBirth,int staffId, String role,  String department) {
        super(name,email,dateOfBirth);
        this.staffId = staffId;
        this.role = role;
        this.department = department;
    }
    
    // getters 
    public int getStaffId() {
        return staffId;
    }

    public String getRole() {
        return role;
    }

    public String getDepartment() {
        return department;
    }

    // setters 
    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

                         // METHODS ASEKD BY MAM 

    // generate report
    @Override
    public String generateReport(ArrayList<Person> people){

        String report = "Report Summary:\n";
        int StudentCounter = 0;
        int StaffCounter = 0;
        int TeacherCounter = 0;

        for (Person p :people){
            if (p instanceof Student)StaffCounter++;
            else if (p instanceof Teacher) TeacherCounter++;
            else if(p instanceof AdministrativeStaff)StaffCounter++;
        }
        report+="Total Students: "+ StudentCounter +"\n";
        report+="Total Teacher: "+  TeacherCounter +"\n";
        report+="Total Administrative: "+ StaffCounter +"\n";
        return report;
    }

// export to file
@Override 
public void exportToFile(){ 
    try (OutputStream os = new FileOutputStream("report.txt")) { 
        String data = "Report Summary:\n"; 
        data += "Total Students: " + Student.getTotalStudent() + "\n"; 
        data += "Total Teachers: " + Teacher.getTotalTeachers() + "\n"; 
        data += "Total Courses: " + Course.getTotalCourses() + "\n"; 

        os.write(data.getBytes()); 
        System.out.println("Successfully wrote to the file."); 
    } catch (IOException e) { 
        System.err.println("An error occurred while writing to the file: " + e.getMessage()); 
    } 
}


    @Override
    public String toString() {
        String details = "Staff Details:\n";
        details += "ID: " + staffId + "\n";
        details += "Name: " + super.getName() + "\n";
        details += "Role: " + role + "\n";
        details += "Department: " + department + "\n";
        return details;
    }
}



