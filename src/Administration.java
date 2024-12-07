
import java.util.ArrayList;
import java.util.Date;
interface Reportable {
    String generateReport(ArrayList<Person> people);

}
 class AdministrativeStaff extends Person implements Reportable{
    private int staffId;
    private String role;
    private String department;
    AdministrativeStaff(){}

    public AdministrativeStaff(String name, String email, Date dateOfBirth,int staffId, String role,  String dep) {
        super(name,email,dateOfBirth);
        this.staffId = staffId;
        this.role = role;
        this.department = dep;
    }
    public String generateReport(ArrayList<Person> people){
        //array list of type person,
        //// so it may contain multiple objects of different datatype(teacher,std,admin)
//        //so we will make a string and then append the counter which will count
//        // the no of each  objects, we also doing down casting here thru instance of
//        //reason the parameter is type of Person which is parent so we have to
//        //check wether it is of type std/teacher /staff.
        String report = "Report Summary:\n";
        int StudentCounter=0;
        int StaffCounter=0;
        int TeacherCounter=0;

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
    public String displayDetails() {
        String details = "Staff Details:\n";
        details += "ID: " + staffId + "\n";
        details += "Name: " + super.getName() + "\n";
        details += "Role: " + role + "\n";
        details += "Department: " + department + "\n";
        return details;
    }
}



