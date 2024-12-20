import java.io.*;
import java.util.ArrayList;

public class University {
    private Repository<Student> studentRepository;
    private Repository<Teacher> teacherRepository;
    private Repository<Course> courseRepository;
    private Repository<AdministrativeStaff> staffRepository;

    public University() {
        studentRepository = new Repository<>();
        teacherRepository = new Repository<>();
        courseRepository = new Repository<>();
        staffRepository = new Repository<>();
    }

    // Add methods
    public void addStudent(Student student) {
        if (student == null) {
            System.err.println("Invalid student input.");
            return;
        }
        studentRepository.add(student);
    }

    public void addTeacher(Teacher teacher) {
        if (teacher == null) {
            System.err.println("Invalid teacher input.");
            return;
        }
        teacherRepository.add(teacher);
    }

    public void addCourse(Course course) {
        if (course == null) {
            System.err.println("Invalid course input.");
            return;
        }
        courseRepository.add(course);
    }

    public void addStaff(AdministrativeStaff staff) {
        if (staff == null) {
            System.err.println("Invalid staff input.");
            return;
        }
        staffRepository.add(staff);
    }

    // Remove methods
    public void removeStudent(Student student) {
        if (student == null) {
            System.err.println("Invalid student input.");
            return;
        }
        studentRepository.remove(student);
    }

    public void removeTeacher(Teacher teacher) {
        if (teacher == null) {
            System.err.println("Invalid teacher input.");
            return;
        }
        teacherRepository.remove(teacher);
    }

    public void removeCourse(Course course) {
        if (course == null) {
            System.err.println("Invalid course input.");
            return;
        }
        courseRepository.remove(course);
    }

    public void removeStaff(AdministrativeStaff staff) {
        if (staff == null) {
            System.err.println("Invalid staff input.");
            return;
        }
        staffRepository.remove(staff);
    }

    // Assign relationships
    public void assignTeacherToCourse(Teacher teacher, Course course) {
        teacher.assignCourse(course);
        course.setAssignedTeacher(teacher);
    }


    public void enrollStudentInCourse(Student student, Course course) {
        student.enrollInCourse(course);
        course.addStudent(student);
    }

    
    public static void displaySystemStats() {
        System.out.println("University System Stats:");
        System.out.println("Total Students: " + Student.getTotalStudent());
        System.out.println("Total Teachers: " + Teacher.getTotalTeachers());
        System.out.println("Total Courses: " + Course.getTotalCourses());
        
    }

    // Search methods

    public ArrayList<Student> searchStudentByName(String name){
        //Returns a list of students with matching names
        ArrayList<Student> students = new ArrayList<>();
        for(Student student : studentRepository.getAll()){
            if(student.getName().contains(name)){
                students.add(student);
            }
        }
        return students; 
    }

    public ArrayList<Course> filterCoursesByCredits(int minCredits){
        
        ArrayList<Course> courses = new ArrayList<>();

        for(Course course : courseRepository.getAll()){
            if(course.getCredits() >= minCredits){
                courses.add(course);
            }
        }
        return courses;
    }

// additional methods, not asked by mam
    public Student findStudentById(int studentId) {
        for (Student student : studentRepository.getAll()) {
            if (student.getStudentId() == studentId) {
                return student;
            }
        }
        return null;
    }

    public Teacher findTeacherById(int teacherId) {
        for (Teacher teacher : teacherRepository.getAll()) {
            if (teacher.getTeacherId() == teacherId) {
                return teacher;
            }
        }
        return null;
    }

    public Course findCourseById(int courseId) {
        for (Course course : courseRepository.getAll()) {
            if (course.getCourseId() == courseId) {
                return course;
            }
        }
        return null;
    }

    // Save data to file
    public void saveData(String filename) {
        if (filename == null || filename.isEmpty()) {
            System.err.println("Invalid filename.");
            return;
        }
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(studentRepository.getAll());
            oos.writeObject(teacherRepository.getAll());
            oos.writeObject(courseRepository.getAll());
            oos.writeObject(staffRepository.getAll());
            System.out.println("Data saved successfully to " + filename);
        } catch (IOException e) {
            System.err.println("Error saving data: " + e.getMessage());
        }
    }

    // Load data from file
    @SuppressWarnings("unchecked")
    public void loadData(String filename) {
        if (filename == null || filename.isEmpty()) {
            System.err.println("Invalid filename.");
            return;
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            studentRepository.setAll((ArrayList<Student>) ois.readObject());
            teacherRepository.setAll((ArrayList<Teacher>) ois.readObject());
            courseRepository.setAll((ArrayList<Course>) ois.readObject());
            staffRepository.setAll((ArrayList<AdministrativeStaff>) ois.readObject());
            System.out.println("Data loaded successfully from " + filename);
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading data: " + e.getMessage());
        }
    }

}


