import java.io.Serializable;
import java.util.Date;

public class Person implements Serializable{
    private String name;
    private String email;
    private Date dateOfBirth;

    public Person(){
        name = null;
        email = null;
        dateOfBirth = null;
    }

    public Person(String name, String email, Date dateOfBirth){
        this.name = name;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
    }

    public void setName(String name){
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setEmail(String email){
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Email cannot be null or empty");
        }
        this.email = email;
    }

    public String getEmail(){
        return email;
    }

    public void setDateOfBirth(Date dateOfBirth){
        if (dateOfBirth == null) {
            throw new IllegalArgumentException("Date of Birth cannot be null");
        }
        this.dateOfBirth = dateOfBirth;
    }

    public Date getDateOfBirth(){
        return dateOfBirth;
    }
    
    public void displayDetails(){
        System.out.println(" Name: "+ getName() + "\n Email: "+ getEmail() + "\n Date of Birth: "+ getDateOfBirth());
    }

    @Override
    public String toString() {
        return "Name: " + name + "\nEmail: " + email + "\nDate of Birth: " + dateOfBirth;
    }
}
