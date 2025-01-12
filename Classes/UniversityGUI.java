import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

public class UniversityGUI extends JFrame {
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private University university;

    public UniversityGUI() {
        university = new University();

        setTitle("University Management System");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create main panel with CardLayout
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // Create panels for different operations
        JPanel homePanel = createHomePanel(); 
        JPanel addStudentPanel = createAddStudentPanel();
        JPanel removeStudentPanel = createRemoveStudentPanel();
        JPanel addTeacherPanel = createAddTeacherPanel();
        JPanel removeTeacherPanel = createRemoveTeacherPanel();
        JPanel addCoursePanel = createAddCoursePanel();
        JPanel removeCoursePanel = createRemoveCoursePanel();
        JPanel addStaffPanel = createAddStaffPanel();
        JPanel removeStaffPanel = createRemoveStaffPanel();
        JPanel assignTeacherToCoursePanel = createAssignTeacherToCoursePanel(); 
        JPanel enrollStudentInCoursePanel = createEnrollStudentInCoursePanel();
        JPanel displayStudentCoursesPanel = createDisplayStudentCoursesPanel();
        JPanel calculateAverageGradePanel = createCalculateAverageGradePanel();
        JPanel calculateMedianGradePanel = createCalculateMedianGradePanel();
        JPanel displayStudentDetailPanel = createDisplayStudentDetailPanel();
        JPanel displayTeacherDetailPanel = createDisplayTeacherDetailPanel();
        JPanel displayStaffDetailPanel = createDisplayStaffDetailPanel();
        JPanel exportToFilePanel = createExportToFilePanel();
        JPanel loadDataPanel = createLoadDataPanel();
        JPanel saveDataPanel = createSaveDataPanel();
        JPanel searchStudentByNamePanel = createSearchStudentByNamePanel();
        JPanel filterCoursesByCreditsPanel = createFilterCoursesByCreditsPanel();
        JPanel displayTeacherCoursesPanel = createDisplayTeacherCoursesPanel();
        JPanel removeStudentFromCoursePanel = createRemoveStudentFromCoursePanel();
        JPanel displaySystemStatsPanel = createDisplaySystemStatsPanel();
        JPanel addGradePanel = createAddGradePanel();

        // Add panels to main panel
        mainPanel.add(homePanel, "Home");
        mainPanel.add(addStudentPanel, "Add Student");
        mainPanel.add(removeStudentPanel, "Remove Student");
        mainPanel.add(addTeacherPanel, "Add Teacher");
        mainPanel.add(removeTeacherPanel, "Remove Teacher");
        mainPanel.add(addCoursePanel, "Add Course");
        mainPanel.add(removeCoursePanel, "Remove Course");
        mainPanel.add(addStaffPanel, "Add Staff");
        mainPanel.add(removeStaffPanel, "Remove Staff");
        mainPanel.add(assignTeacherToCoursePanel, "Assign Teacher to Course");
        mainPanel.add(enrollStudentInCoursePanel, "Enroll Student in Course");
        mainPanel.add(displayStudentCoursesPanel, "Display Student Courses");
        mainPanel.add(calculateAverageGradePanel, "Calculate Average Grade");
        mainPanel.add(calculateMedianGradePanel, "Calculate Median Grade");
        mainPanel.add(displayStudentDetailPanel, "Display Student Detail");
        mainPanel.add(displayTeacherDetailPanel, "Display Teacher Detail");
        mainPanel.add(displayStaffDetailPanel, "Display Staff Detail");
        mainPanel.add(exportToFilePanel, "Export to File");
        mainPanel.add(loadDataPanel, "Load Data");
        mainPanel.add(saveDataPanel, "Save Data");
        mainPanel.add(searchStudentByNamePanel, "Search Student By Name");
        mainPanel.add(filterCoursesByCreditsPanel, "Filter Courses By Credits");
        mainPanel.add(displayTeacherCoursesPanel, "Display Teacher Courses");
        mainPanel.add(removeStudentFromCoursePanel, "Remove Student From Course");
        mainPanel.add(displaySystemStatsPanel, "Display System Stats");
        mainPanel.add(addGradePanel, "Add Grade");

        // Add main panel to frame
        add(mainPanel);

        // Show home panel initially
        cardLayout.show(mainPanel, "Home");
    }

    private JPanel createHomePanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(9, 1));

        JButton studentButton = new JButton("Student Operations");
        JButton teacherButton = new JButton("Teacher Operations");
        JButton courseButton = new JButton("Course Operations");
        JButton staffButton = new JButton("Administrative Staff Operations");
        JButton displayStatsButton = new JButton("Display System Stats");
        JButton exportToFileButton = new JButton("Export to File");
        JButton loadDataButton = new JButton("Load Data");
        JButton saveDataButton = new JButton("Save Data");
        JButton exitButton = new JButton("Exit");
   
        studentButton.addActionListener(e -> showStudentOperations());
        teacherButton.addActionListener(e -> showTeacherOperations());
        courseButton.addActionListener(e -> showCourseOperations());
        staffButton.addActionListener(e -> showStaffOperations());
        displayStatsButton.addActionListener(e -> cardLayout.show(mainPanel, "Display System Stats"));
        exportToFileButton.addActionListener(e -> cardLayout.show(mainPanel, "Export to File"));
        loadDataButton.addActionListener(e -> cardLayout.show(mainPanel, "Load Data"));
        saveDataButton.addActionListener(e -> cardLayout.show(mainPanel, "Save Data"));
        exitButton.addActionListener(e -> System.exit(0));

        studentButton.setBackground(Color.LIGHT_GRAY);
        studentButton.setForeground(Color.BLACK);
        teacherButton.setBackground(Color.LIGHT_GRAY);
        teacherButton.setForeground(Color.BLACK);
        courseButton.setBackground(Color.LIGHT_GRAY);
        courseButton.setForeground(Color.BLACK);
        staffButton.setBackground(Color.LIGHT_GRAY);
        staffButton.setForeground(Color.BLACK);
        displayStatsButton.setBackground(Color.LIGHT_GRAY);
        displayStatsButton.setForeground(Color.BLACK);
        exportToFileButton.setBackground(Color.LIGHT_GRAY);
        exportToFileButton.setForeground(Color.BLACK);
        loadDataButton.setBackground(Color.LIGHT_GRAY);
        loadDataButton.setForeground(Color.BLACK);
        saveDataButton.setBackground(Color.LIGHT_GRAY);
        saveDataButton.setForeground(Color.BLACK);
        exitButton.setBackground(Color.RED);
        exitButton.setForeground(Color.BLACK);

        panel.add(studentButton);
        panel.add(teacherButton);
        panel.add(courseButton);
        panel.add(staffButton);
        panel.add(displayStatsButton);
        panel.add(exportToFileButton);
        panel.add(loadDataButton);
        panel.add(saveDataButton);
        panel.add(exitButton);




        return panel;
    }

    private void showStudentOperations() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7, 1));

        JButton addStudentButton = new JButton("Add Student");
        JButton removeStudentButton = new JButton("Remove Student");
        JButton displayStudentCoursesButton = new JButton("Display Student Courses");
        JButton displayStudentDetailButton = new JButton("Display Student Detail");
        JButton enrollInCourseButton = new JButton("Enroll In Course");
        JButton searchStudentByNameButton = new JButton("Search Student By Name");
        JButton backButton = new JButton("Back");

        addStudentButton.addActionListener(e -> cardLayout.show(mainPanel, "Add Student"));
        removeStudentButton.addActionListener(e -> cardLayout.show(mainPanel, "Remove Student"));
        displayStudentCoursesButton.addActionListener(e -> cardLayout.show(mainPanel, "Display Student Courses"));
        displayStudentDetailButton.addActionListener(e -> cardLayout.show(mainPanel, "Display Student Detail"));
        enrollInCourseButton.addActionListener(e -> cardLayout.show(mainPanel, "Enroll Student in Course"));
        searchStudentByNameButton.addActionListener(e -> cardLayout.show(mainPanel, "Search Student By Name"));
        backButton.addActionListener(e -> cardLayout.show(mainPanel, "Home"));

        addStudentButton.setBackground(Color.LIGHT_GRAY);
        addStudentButton.setForeground(Color.BLACK);
        removeStudentButton.setBackground(Color.LIGHT_GRAY);
        removeStudentButton.setForeground(Color.BLACK);
        displayStudentCoursesButton.setBackground(Color.LIGHT_GRAY);
        displayStudentCoursesButton.setForeground(Color.BLACK);
        displayStudentDetailButton.setBackground(Color.LIGHT_GRAY);
        displayStudentDetailButton.setForeground(Color.BLACK);
        enrollInCourseButton.setBackground(Color.LIGHT_GRAY);
        enrollInCourseButton.setForeground(Color.BLACK);
        searchStudentByNameButton.setBackground(Color.LIGHT_GRAY);
        searchStudentByNameButton.setForeground(Color.BLACK);
        backButton.setBackground(Color.LIGHT_GRAY);
        backButton.setForeground(Color.BLACK);



        panel.add(addStudentButton);
        panel.add(removeStudentButton);
        panel.add(displayStudentCoursesButton);
        panel.add(displayStudentDetailButton);
        panel.add(enrollInCourseButton);
        panel.add(searchStudentByNameButton);
        panel.add(backButton);



        mainPanel.add(panel, "Student Operations");
        cardLayout.show(mainPanel, "Student Operations");
    }

    private void showTeacherOperations() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 1));

        JButton addTeacherButton = new JButton("Add Teacher");
        JButton removeTeacherButton = new JButton("Remove Teacher");
        JButton assignTeacherToCourseButton = new JButton("Assign Teacher to Course");
        JButton displayTeacherDetailButton = new JButton("Display Teacher Detail");
        JButton displayTeacherCoursesButton = new JButton("Display Teacher Courses");
        JButton backButton = new JButton("Back");

        addTeacherButton.addActionListener(e -> cardLayout.show(mainPanel, "Add Teacher"));
        removeTeacherButton.addActionListener(e -> cardLayout.show(mainPanel, "Remove Teacher"));
        assignTeacherToCourseButton.addActionListener(e -> cardLayout.show(mainPanel, "Assign Teacher to Course"));
        displayTeacherDetailButton.addActionListener(e -> cardLayout.show(mainPanel, "Display Teacher Detail"));
        displayTeacherCoursesButton.addActionListener(e -> cardLayout.show(mainPanel, "Display Teacher Courses"));
        backButton.addActionListener(e -> cardLayout.show(mainPanel, "Home"));

        addTeacherButton.setBackground(Color.LIGHT_GRAY);
        addTeacherButton.setForeground(Color.BLACK);
        removeTeacherButton.setBackground(Color.LIGHT_GRAY);
        removeTeacherButton.setForeground(Color.BLACK);
        assignTeacherToCourseButton.setBackground(Color.LIGHT_GRAY);
        assignTeacherToCourseButton.setForeground(Color.BLACK);
        displayTeacherDetailButton.setBackground(Color.LIGHT_GRAY);
        displayTeacherDetailButton.setForeground(Color.BLACK);
        displayTeacherCoursesButton.setBackground(Color.LIGHT_GRAY);
        displayTeacherCoursesButton.setForeground(Color.BLACK);
        backButton.setBackground(Color.LIGHT_GRAY);
        backButton.setForeground(Color.BLACK);


        panel.add(addTeacherButton);
        panel.add(removeTeacherButton);
        panel.add(assignTeacherToCourseButton);
        panel.add(displayTeacherDetailButton);
        panel.add(displayTeacherCoursesButton);
        panel.add(backButton);

        mainPanel.add(panel, "Teacher Operations");
        cardLayout.show(mainPanel, "Teacher Operations");
    }

    private void showCourseOperations() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(8, 1));

        JButton addCourseButton = new JButton("Add Course");
        JButton removeCourseButton = new JButton("Remove Course");
        JButton addGradeButton = new JButton("Add Grade");
        JButton calculateAverageGradeButton = new JButton("Calculate Average Grade");
        JButton calculateMedianGradeButton = new JButton("Calculate Median Grade");
        JButton filterCoursesByCreditsButton = new JButton("Filter Courses By Credits");
        JButton removeStudentFromCourseButton = new JButton("Remove Student From Course");
        JButton backButton = new JButton("Back");

        addCourseButton.addActionListener(e -> cardLayout.show(mainPanel, "Add Course"));
        removeCourseButton.addActionListener(e -> cardLayout.show(mainPanel, "Remove Course"));
        addGradeButton.addActionListener(e -> cardLayout.show(mainPanel, "Add Grade"));
        calculateAverageGradeButton.addActionListener(e -> cardLayout.show(mainPanel, "Calculate Average Grade"));
        calculateMedianGradeButton.addActionListener(e -> cardLayout.show(mainPanel, "Calculate Median Grade"));
        filterCoursesByCreditsButton.addActionListener(e -> cardLayout.show(mainPanel, "Filter Courses By Credits"));
        removeStudentFromCourseButton.addActionListener(e -> cardLayout.show(mainPanel, "Remove Student From Course"));
        backButton.addActionListener(e -> cardLayout.show(mainPanel, "Home"));

        addCourseButton.setBackground(Color.LIGHT_GRAY);
        addCourseButton.setForeground(Color.BLACK);
        addGradeButton.setBackground(Color.LIGHT_GRAY);
        addGradeButton.setForeground(Color.BLACK);
        removeCourseButton.setBackground(Color.LIGHT_GRAY);
        removeCourseButton.setForeground(Color.BLACK);
        calculateAverageGradeButton.setBackground(Color.LIGHT_GRAY);
        calculateAverageGradeButton.setForeground(Color.BLACK);
        calculateMedianGradeButton.setBackground(Color.LIGHT_GRAY);
        calculateMedianGradeButton.setForeground(Color.BLACK);
        filterCoursesByCreditsButton.setBackground(Color.LIGHT_GRAY);
        filterCoursesByCreditsButton.setForeground(Color.BLACK);
        removeStudentFromCourseButton.setBackground(Color.LIGHT_GRAY);
        removeStudentFromCourseButton.setForeground(Color.BLACK);
        backButton.setBackground(Color.LIGHT_GRAY);
        backButton.setForeground(Color.BLACK);


        panel.add(addCourseButton);
        panel.add(removeCourseButton);
        panel.add(addGradeButton);
        panel.add(calculateAverageGradeButton);
        panel.add(calculateMedianGradeButton);
        panel.add(filterCoursesByCreditsButton);
        panel.add(removeStudentFromCourseButton);
        panel.add(backButton);

        mainPanel.add(panel, "Course Operations");
        cardLayout.show(mainPanel, "Course Operations");
    }

    private void showStaffOperations() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1));

        JButton addStaffButton = new JButton("Add Staff");
        JButton removeStaffButton = new JButton("Remove Staff");
        JButton displayStaffDetailButton = new JButton("Display Staff Detail");
        JButton backButton = new JButton("Back");

        addStaffButton.addActionListener(e -> cardLayout.show(mainPanel, "Add Staff"));
        removeStaffButton.addActionListener(e -> cardLayout.show(mainPanel, "Remove Staff"));
        displayStaffDetailButton.addActionListener(e -> cardLayout.show(mainPanel, "Display Staff Detail"));
        backButton.addActionListener(e -> cardLayout.show(mainPanel, "Home"));

        addStaffButton.setBackground(Color.LIGHT_GRAY);
        addStaffButton.setForeground(Color.BLACK);
        removeStaffButton.setBackground(Color.LIGHT_GRAY);
        removeStaffButton.setForeground(Color.BLACK);
        displayStaffDetailButton.setBackground(Color.LIGHT_GRAY);
        displayStaffDetailButton.setForeground(Color.BLACK);
        backButton.setBackground(Color.LIGHT_GRAY);
        backButton.setForeground(Color.BLACK);


        panel.add(addStaffButton);
        panel.add(removeStaffButton);
        panel.add(displayStaffDetailButton);
        panel.add(backButton);

        mainPanel.add(panel, "Staff Operations");
        cardLayout.show(mainPanel, "Staff Operations");
    }

    private JPanel createAddStudentPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7, 2));

        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField();
        JLabel emailLabel = new JLabel("Email:");
        JTextField emailField = new JTextField();
        JLabel dobLabel = new JLabel("Date of Birth:(YYYY/MM/DD)");
        JTextField dobField = new JTextField();
        JLabel idLabel = new JLabel("Student ID:");
        JTextField idField = new JTextField();
        JLabel addressLabel = new JLabel("Address:");
        JTextField addressField = new JTextField();
        JButton addButton = new JButton("Add Student");
        JButton backButton = new JButton("Back");


        backButton.setBackground(Color.LIGHT_GRAY);
        backButton.setForeground(Color.BLACK);
        addButton.setBackground(Color.LIGHT_GRAY);
        addButton.setForeground(Color.BLACK);


        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(emailLabel);
        panel.add(emailField);
        panel.add(dobLabel);
        panel.add(dobField);
        panel.add(idLabel);
        panel.add(idField);
        panel.add(addressLabel);
        panel.add(addressField);
        panel.add(addButton);
        panel.add(backButton);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //  student logic here
                if (nameField.getText().isEmpty() || emailField.getText().isEmpty() || dobField.getText().isEmpty() ||
                    idField.getText().isEmpty() || addressField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(panel, "Please fill in all fields.");
                    return;
                }

                int id = Integer.parseInt(idField.getText());
                if (university.studentExists(id)) {
                    JOptionPane.showMessageDialog(panel, "Student with ID " + id + " already exists!");
                    return;
                }
                String name = nameField.getText();
                String email = emailField.getText();
                Date dob = new Date(dobField.getText()); 
                String address = addressField.getText();

                Student student = new Student(name, email, dob, id, address);
                university.addStudent(student);
                JOptionPane.showMessageDialog(panel, "Student added successfully!");
            }
        });

        backButton.addActionListener(e -> cardLayout.show(mainPanel, "Student Operations"));

        return panel;
    }

    private JPanel createRemoveStudentPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        JLabel idLabel = new JLabel("Student ID:");
        JTextField idField = new JTextField();
        JButton removeButton = new JButton("Remove Student");
        JButton backButton = new JButton("Back");
    
        removeButton.setBackground(Color.LIGHT_GRAY);
        removeButton.setForeground(Color.BLACK);
        backButton.setBackground(Color.LIGHT_GRAY);
        backButton.setForeground(Color.BLACK);



        panel.add(idLabel);
        panel.add(idField);
        panel.add(removeButton);
        panel.add(backButton);

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Remove student logic here

                if (idField.getText().isEmpty() ) {
                JOptionPane.showMessageDialog(panel, "Please fill in all fields.");
                return;
            }

                int id = Integer.parseInt(idField.getText());
                Student student = university.findStudentById(id);
                if (student != null) {
                    university.removeStudent(student);
                    // if it is enrolled to a course, remove it from the course

                    for (Course course : university.getCourses()) {
                        if (course.isEnrolled(student)) {
                            course.removeStudent(student);
                        }
                    }

                    JOptionPane.showMessageDialog(panel, "Student removed successfully!");
                } else {
                    JOptionPane.showMessageDialog(panel, "Student not found!");
                }
            }
        });

        backButton.addActionListener(e -> cardLayout.show(mainPanel, "Student Operations"));

        return panel;
    }

    private JPanel createAddTeacherPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2));

        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField();
        JLabel emailLabel = new JLabel("Email:");
        JTextField emailField = new JTextField();
        JLabel idLabel = new JLabel("Teacher ID:");
        JTextField idField = new JTextField();
        JLabel departmentLabel = new JLabel("Specialization:");
        JTextField departmentField = new JTextField();
        JButton addButton = new JButton("Add Teacher");
        JButton backButton = new JButton("Back");

        addButton.setBackground(Color.LIGHT_GRAY);
        addButton.setForeground(Color.BLACK);
        backButton.setBackground(Color.LIGHT_GRAY);
        backButton.setForeground(Color.BLACK);


        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(emailLabel);
        panel.add(emailField);
        panel.add(idLabel);
        panel.add(idField);
        panel.add(departmentLabel);
        panel.add(departmentField);
        panel.add(addButton);
        panel.add(backButton);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add teacher logic here
                if (nameField.getText().isEmpty() || emailField.getText().isEmpty() || idField.getText().isEmpty() ||
                    departmentField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(panel, "Please fill in all fields.");
                    return;
                }

                int id = Integer.parseInt(idField.getText());
                if (university.teacherExists(id)) {
                    JOptionPane.showMessageDialog(panel, "Teacher with ID " + id + " already exists!");
                    return;
                }
                String name = nameField.getText();
                String email = emailField.getText();
                String department = departmentField.getText();

                Teacher teacher = new Teacher(name, email, new Date(), id, department);
                university.addTeacher(teacher);
                JOptionPane.showMessageDialog(panel, "Teacher added successfully!");
            }
        });

        backButton.addActionListener(e -> cardLayout.show(mainPanel, "Teacher Operations"));

        return panel;
    }

    private JPanel createRemoveTeacherPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        JLabel idLabel = new JLabel("Teacher ID:");
        JTextField idField = new JTextField();
        JButton removeButton = new JButton("Remove Teacher");
        JButton backButton = new JButton("Back");


        removeButton.setBackground(Color.LIGHT_GRAY);
        removeButton.setForeground(Color.BLACK);
        backButton.setBackground(Color.LIGHT_GRAY);
        backButton.setForeground(Color.BLACK);



        panel.add(idLabel);
        panel.add(idField);
        panel.add(removeButton);
        panel.add(backButton);

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Remove teacher logic here

                if (idField.getText().isEmpty() ) {
                    JOptionPane.showMessageDialog(panel, "Please fill in all fields.");
                    return;
                }

                int id = Integer.parseInt(idField.getText());
                Teacher teacher = university.findTeacherById(id);
                if (teacher != null) {
                    university.removeTeacher(teacher);
                    // if it is assigned to a course, remove it from the course
                    for (Course course : university.getCourses()) {
                        if (course.isAssigned(teacher)) {
                            course.removeTeacher();
                        }
                    }
                    JOptionPane.showMessageDialog(panel, "Teacher removed successfully!");
                } else {
                    JOptionPane.showMessageDialog(panel, "Teacher not found!");
                }
            }
        });

        backButton.addActionListener(e -> cardLayout.show(mainPanel, "Teacher Operations"));

        return panel;
    }

    private JPanel createAddCoursePanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2));

        JLabel nameLabel = new JLabel("Course Name:");
        JTextField nameField = new JTextField();
        JLabel idLabel = new JLabel("Course ID:");
        JTextField idField = new JTextField();
        JLabel creditsLabel = new JLabel("Credits:");
        JTextField creditsField = new JTextField();
        JLabel teacherIdLabel = new JLabel("Assigned Teacher ID:");
        JTextField teacherIdField = new JTextField();
        JButton addButton = new JButton("Add Course");
        JButton backButton = new JButton("Back");

        addButton.setBackground(Color.LIGHT_GRAY);
        addButton.setForeground(Color.BLACK);
        backButton.setBackground(Color.LIGHT_GRAY);
        backButton.setForeground(Color.BLACK);

        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(idLabel);
        panel.add(idField);
        panel.add(creditsLabel);
        panel.add(creditsField);
        panel.add(teacherIdLabel);
        panel.add(teacherIdField);
        panel.add(addButton);
        panel.add(backButton);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add course logic here
                if (nameField.getText().isEmpty() || idField.getText().isEmpty() || creditsField.getText().isEmpty() ||
                    teacherIdField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(panel, "Please fill in all fields.");
                    return;
                }

                int id = Integer.parseInt(idField.getText());
                if (university.courseExists(id)) {
                    JOptionPane.showMessageDialog(panel, "Course with ID " + id + " already exists!");
                    return;
                }
                String name = nameField.getText();
                int credits = Integer.parseInt(creditsField.getText());
                int teacherId = Integer.parseInt(teacherIdField.getText());

                Teacher assignedTeacher = university.findTeacherById(teacherId);
                if (assignedTeacher != null) {
                    if ( assignedTeacher.getAssignedCourseCount() >= 5) {
                        JOptionPane.showMessageDialog(panel, "Teacher " + assignedTeacher.getName() + " already has the maximum number of assigned courses.");
                        return;
                    }
                    Course course = new Course(id, name, credits, assignedTeacher);
                    university.addCourse(course);
                    JOptionPane.showMessageDialog(panel, "Course added successfully!");
                } else {
                    JOptionPane.showMessageDialog(panel, "Assigned Teacher not found!");
                }
            }
        });

        backButton.addActionListener(e -> cardLayout.show(mainPanel, "Course Operations"));

        return panel;
    }

    private JPanel createRemoveCoursePanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        JLabel idLabel = new JLabel("Course ID:");
        JTextField idField = new JTextField();
        JButton removeButton = new JButton("Remove Course");
        JButton backButton = new JButton("Back");

        removeButton.setBackground(Color.LIGHT_GRAY);
        removeButton.setForeground(Color.BLACK);
        backButton.setBackground(Color.LIGHT_GRAY);
        backButton.setForeground(Color.BLACK);

        panel.add(idLabel);
        panel.add(idField);
        panel.add(removeButton);
        panel.add(backButton);

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Remove course logic here
                if (idField.getText().isEmpty() ) {
                    JOptionPane.showMessageDialog(panel, "Please fill in all fields.");
                    return;
                }
                int id = Integer.parseInt(idField.getText());
                Course course = university.findCourseById(id);
                
                if (course != null) {

                    if(university.isCourseAssignedToStudent(course.getCourseId())){
                        for (Student student : university.getStudents()) {
                            student.removeCourse(course);
                        }
                    }
                    
                    university.removeCourse(course);
                    JOptionPane.showMessageDialog(panel, "Course removed successfully!");
                } else {
                    JOptionPane.showMessageDialog(panel, "Course not found!");
                }
            }
        });

        backButton.addActionListener(e -> cardLayout.show(mainPanel, "Course Operations"));

        return panel;
    }

    private JPanel createAddStaffPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(8, 2));

        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField();
        JLabel emailLabel = new JLabel("Email:");
        JTextField emailField = new JTextField();
        JLabel idLabel = new JLabel("Staff ID:");
        JTextField idField = new JTextField();
        JLabel departmentLabel = new JLabel("Department:");
        JTextField departmentField = new JTextField();
        JLabel roleLabel = new JLabel("Role: ");
        JTextField roleField = new JTextField();
        JButton addButton = new JButton("Add Staff");
        JButton backButton = new JButton("Back");

        addButton.setBackground(Color.LIGHT_GRAY);
        addButton.setForeground(Color.BLACK);
        backButton.setBackground(Color.LIGHT_GRAY);
        backButton.setForeground(Color.BLACK);


        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(emailLabel);
        panel.add(emailField);
        panel.add(idLabel);
        panel.add(idField);
        panel.add(departmentLabel);
        panel.add(departmentField);
        panel.add(roleLabel);
        panel.add(roleField);
        panel.add(addButton);
        panel.add(backButton);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add staff logic here
                if (nameField.getText().isEmpty() || emailField.getText().isEmpty() || idField.getText().isEmpty() ||
                    departmentField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(panel, "Please fill in all fields.");
                    return;
                }

                int id = Integer.parseInt(idField.getText());
                if (university.staffExists(id)) {
                    JOptionPane.showMessageDialog(panel, "Staff with ID " + id + " already exists!");
                    return;
                }
                String name = nameField.getText();
                String email = emailField.getText();
                String department = departmentField.getText();
                String role = roleField.getText();

                AdministrativeStaff staff = new AdministrativeStaff(name, email, new Date(), id, role ,department);
                university.addStaff(staff);
                JOptionPane.showMessageDialog(panel, "Staff added successfully!");
            }
        });

        backButton.addActionListener(e -> cardLayout.show(mainPanel, "Staff Operations"));

        return panel;
    }

    private JPanel createRemoveStaffPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        JLabel idLabel = new JLabel("Staff ID:");
        JTextField idField = new JTextField();
        JButton removeButton = new JButton("Remove Staff");
        JButton backButton = new JButton("Back");

        
        removeButton.setBackground(Color.LIGHT_GRAY);
        removeButton.setForeground(Color.BLACK);
        backButton.setBackground(Color.LIGHT_GRAY);
        backButton.setForeground(Color.BLACK);


        panel.add(idLabel);
        panel.add(idField);
        panel.add(removeButton);
        panel.add(backButton);

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Remove staff logic here
                if (idField.getText().isEmpty() ) {
                    JOptionPane.showMessageDialog(panel, "Please fill in all fields.");
                    return;
                }

                int id = Integer.parseInt(idField.getText());
                AdministrativeStaff staff = university.findStaffById(id);
                if (staff != null) {
                    university.removeStaff(staff);
                    JOptionPane.showMessageDialog(panel, "Staff removed successfully!");
                } else {
                    JOptionPane.showMessageDialog(panel, "Staff not found!");
                }
            }
        });

        backButton.addActionListener(e -> cardLayout.show(mainPanel, "Staff Operations"));

        return panel;
    }

    private JPanel createAssignTeacherToCoursePanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));

        JLabel teacherIdLabel = new JLabel("Teacher ID:");
        JTextField teacherIdField = new JTextField();
        JLabel courseIdLabel = new JLabel("Course ID:");
        JTextField courseIdField = new JTextField();
        JButton assignButton = new JButton("Assign Teacher to Course");
        JButton backButton = new JButton("Back");
        
        assignButton.setBackground(Color.LIGHT_GRAY);
        assignButton.setForeground(Color.BLACK);
        backButton.setBackground(Color.LIGHT_GRAY);
        backButton.setForeground(Color.BLACK);

        panel.add(teacherIdLabel);
        panel.add(teacherIdField);
        panel.add(courseIdLabel);
        panel.add(courseIdField);
        panel.add(assignButton);
        panel.add(backButton);

        assignButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Assign teacher to course logic here
                
                if (teacherIdField.getText().isEmpty() || courseIdField.getText().isEmpty() ) {
                    JOptionPane.showMessageDialog(panel, "Please fill in all fields.");
                    return;
                }
                int teacherId = Integer.parseInt(teacherIdField.getText());
                int courseId = Integer.parseInt(courseIdField.getText());

                if (university.isCourseAssignedToTeacher(teacherId, courseId)) {
                    JOptionPane.showMessageDialog(panel, "Course is already assigned to this teacher!");
                    return;
                }

                Teacher teacher = university.findTeacherById(teacherId);
                Course course = university.findCourseById(courseId);
                
                if (teacher != null && teacher.getAssignedCourseCount() >= 5) {
                    JOptionPane.showMessageDialog(panel, "Teacher " + teacher.getName() + " already has the maximum number of assigned courses.");
                    return;
                }

                if (teacher != null && course != null) {
                    university.assignTeacherToCourse(teacher, course);
                    JOptionPane.showMessageDialog(panel, "Teacher assigned to course successfully!");
                } else {
                    JOptionPane.showMessageDialog(panel, "Teacher or Course not found!");
                }
            }
        });

        backButton.addActionListener(e -> cardLayout.show(mainPanel, "Teacher Operations"));

        return panel;
    }

    private JPanel createEnrollStudentInCoursePanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));

        JLabel studentIdLabel = new JLabel("Student ID:");
        JTextField studentIdField = new JTextField();
        JLabel courseIdLabel = new JLabel("Course ID:");
        JTextField courseIdField = new JTextField();
        JButton enrollButton = new JButton("Enroll Student in Course");
        JButton backButton = new JButton("Back");

        enrollButton.setBackground(Color.LIGHT_GRAY);
        enrollButton.setForeground(Color.BLACK);
        backButton.setBackground(Color.LIGHT_GRAY);
        backButton.setForeground(Color.BLACK);


        panel.add(studentIdLabel);
        panel.add(studentIdField);
        panel.add(courseIdLabel);
        panel.add(courseIdField);
        panel.add(enrollButton);
        panel.add(backButton);

        enrollButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Enroll student in course logic here

                if (studentIdField.getText().isEmpty() || courseIdField.getText().isEmpty() ) {
                    JOptionPane.showMessageDialog(panel, "Please fill in all fields.");
                    return;
                }

                int studentId = Integer.parseInt(studentIdField.getText());
                int courseId = Integer.parseInt(courseIdField.getText());
                
                Student student = university.findStudentById(studentId);
                Course course = university.findCourseById(courseId);

                
                if (university.isCourseAssignedToStudent(studentId, courseId)) {
                    JOptionPane.showMessageDialog(panel, "Course is already assigned to this student!");
                    return;
                }
                
                if(student != null && student.getEnrolledCourseCount() >= 5){
                    JOptionPane.showMessageDialog(panel, "Student already enrolled in 5 courses!");
                    return;
                }


                if (student != null && course != null) {
                    university.enrollStudentInCourse(student, course);
                    JOptionPane.showMessageDialog(panel, "Student enrolled in course successfully!");
                } else {
                    JOptionPane.showMessageDialog(panel, "Student or Course not found!");
                }
            }
        });

        backButton.addActionListener(e -> cardLayout.show(mainPanel, "Student Operations"));

        return panel;
    }

    private JPanel createDisplayStudentCoursesPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        JLabel studentIdLabel = new JLabel("Student ID:");
        JTextField studentIdField = new JTextField();
        JButton displayButton = new JButton("Display Courses");
        JButton backButton = new JButton("Back");

        displayButton.setBackground(Color.LIGHT_GRAY);
        displayButton.setForeground(Color.BLACK);
        backButton.setBackground(Color.LIGHT_GRAY);
        backButton.setForeground(Color.BLACK);


        panel.add(studentIdLabel);
        panel.add(studentIdField);
        panel.add(displayButton);
        panel.add(backButton);

        displayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (studentIdField.getText().isEmpty()  ) {
                    JOptionPane.showMessageDialog(panel, "Please fill in all fields.");
                    return;
                }

                int studentId = Integer.parseInt(studentIdField.getText());
                Student student = university.findStudentById(studentId);
                if (student != null) {
                    JOptionPane.showMessageDialog(panel, student.getCourseDetails());
                    System.out.println(student.getCourseDetails());
                } else {
                    JOptionPane.showMessageDialog(panel, "Student not found!");
                }
            }
        });

        backButton.addActionListener(e -> cardLayout.show(mainPanel, "Student Operations"));

        return panel;
    }

    private JPanel createCalculateAverageGradePanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        JLabel courseIdLabel = new JLabel("Course ID:");
        JTextField courseIdField = new JTextField();
        JButton calculateButton = new JButton("Calculate Average Grade");
        JButton backButton = new JButton("Back");

        calculateButton.setBackground(Color.LIGHT_GRAY);
        calculateButton.setForeground(Color.BLACK);
        backButton.setBackground(Color.LIGHT_GRAY);
        backButton.setForeground(Color.BLACK);

        panel.add(courseIdLabel);
        panel.add(courseIdField);
        panel.add(calculateButton);
        panel.add(backButton);

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (courseIdField.getText().isEmpty()  ) {
                    JOptionPane.showMessageDialog(panel, "Please fill in Course Id field.");
                    return;
                }

                int courseId = Integer.parseInt(courseIdField.getText());
                Course course = university.findCourseById(courseId);
                if (course != null) {
                    double averageGrade = course.calculateAverageGrade();
                    JOptionPane.showMessageDialog(panel, "Average Grade: " + averageGrade);
                    System.out.println("Average Grade: " + averageGrade);
                } else {
                    JOptionPane.showMessageDialog(panel, "Course not found!");
                }
            }
        });

        backButton.addActionListener(e -> cardLayout.show(mainPanel, "Course Operations"));

        return panel;
    }

    private JPanel createCalculateMedianGradePanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        JLabel courseIdLabel = new JLabel("Course ID:");
        JTextField courseIdField = new JTextField();
        JButton calculateButton = new JButton("Calculate Median Grade");
        JButton backButton = new JButton("Back");

        calculateButton.setBackground(Color.LIGHT_GRAY);
        calculateButton.setForeground(Color.BLACK);
        backButton.setBackground(Color.LIGHT_GRAY);
        backButton.setForeground(Color.BLACK);


        panel.add(courseIdLabel);
        panel.add(courseIdField);
        panel.add(calculateButton);
        panel.add(backButton);

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (courseIdField.getText().isEmpty()  ) {
                    JOptionPane.showMessageDialog(panel, "Please fill in Course Id field.");
                    return;
                }

                int courseId = Integer.parseInt(courseIdField.getText());
                Course course = university.findCourseById(courseId);
                if (course != null) {
                    double medianGrade = course.calculateMedianGrade();
                    JOptionPane.showMessageDialog(panel, "Median Grade: " + medianGrade);
                    System.out.println("Median Grade: " + medianGrade);
                } else {
                    JOptionPane.showMessageDialog(panel, "Course not found!");
                }
            }
        });

        backButton.addActionListener(e -> cardLayout.show(mainPanel, "Course Operations"));

        return panel;
    }

    private JPanel createDisplayStudentDetailPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        JLabel studentIdLabel = new JLabel("Student ID:");
        JTextField studentIdField = new JTextField();
        JButton displayButton = new JButton("Display Student Detail");
        JButton backButton = new JButton("Back");

        displayButton.setBackground(Color.LIGHT_GRAY);
        displayButton.setForeground(Color.BLACK);
        backButton.setBackground(Color.LIGHT_GRAY);
        backButton.setForeground(Color.BLACK);


        panel.add(studentIdLabel);
        panel.add(studentIdField);
        panel.add(displayButton);
        panel.add(backButton);

        displayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (studentIdField.getText().isEmpty()  ) {
                    JOptionPane.showMessageDialog(panel, "Please enter Student Id first.");
                    return;
                }

                int studentId = Integer.parseInt(studentIdField.getText());
                Student student = university.findStudentById(studentId);
                if (student != null) {
                    String studentDetail = student.toString();
                    JOptionPane.showMessageDialog(panel, studentDetail);
                    System.out.println(studentDetail);
                } else {
                    JOptionPane.showMessageDialog(panel, "Student not found!");
                }
            }
        });

        backButton.addActionListener(e -> cardLayout.show(mainPanel, "Student Operations"));

        return panel;
    }

    private JPanel createDisplayTeacherDetailPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        JLabel teacherIdLabel = new JLabel("Teacher ID:");
        JTextField teacherIdField = new JTextField();
        JButton displayButton = new JButton("Display Teacher Detail");
        JButton backButton = new JButton("Back");

        displayButton.setBackground(Color.LIGHT_GRAY);
        displayButton.setForeground(Color.BLACK);
        backButton.setBackground(Color.LIGHT_GRAY);
        backButton.setForeground(Color.BLACK);


        panel.add(teacherIdLabel);
        panel.add(teacherIdField);
        panel.add(displayButton);
        panel.add(backButton);

        displayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (teacherIdField.getText().isEmpty()  ) {
                    JOptionPane.showMessageDialog(panel, "Please enter Teacher ID first.");
                    return;
                }

                int teacherId = Integer.parseInt(teacherIdField.getText());
                // university.filterTeacherByCourseName(teacherId);
                Teacher teacher = university.findTeacherById(teacherId);
                if (teacher != null) {
                    String teacherDetail = teacher.toString();
                    JOptionPane.showMessageDialog(panel, teacherDetail);
                    System.out.println(teacherDetail);
                } else {
                    JOptionPane.showMessageDialog(panel, "Teacher not found!");
                }
            }
        });

        backButton.addActionListener(e -> cardLayout.show(mainPanel, "Teacher Operations"));

        return panel;
    }

    private JPanel createDisplayStaffDetailPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        JLabel staffIdLabel = new JLabel("Staff ID:");
        JTextField staffIdField = new JTextField();
        JButton displayButton = new JButton("Display Staff Detail");
        JButton backButton = new JButton("Back");

        displayButton.setBackground(Color.LIGHT_GRAY);
        displayButton.setForeground(Color.BLACK);
        backButton.setBackground(Color.LIGHT_GRAY);
        backButton.setForeground(Color.BLACK);


        panel.add(staffIdLabel);
        panel.add(staffIdField);
        panel.add(displayButton);
        panel.add(backButton);

        displayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (staffIdField.getText().isEmpty()  ) {
                    JOptionPane.showMessageDialog(panel, "Please enter Staff ID first.");
                    return;
                }
                
                int staffId = Integer.parseInt(staffIdField.getText());
                AdministrativeStaff staff = university.findStaffById(staffId);
                if (staff != null) {
                    String staffDetail = staff.toString();
                    JOptionPane.showMessageDialog(panel, staffDetail);
                    System.out.println(staffDetail);
                } else {
                    JOptionPane.showMessageDialog(panel, "Staff not found!");
                }
            }
        });

        backButton.addActionListener(e -> cardLayout.show(mainPanel, "Staff Operations"));

        return panel;
    }

    private JPanel createExportToFilePanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1));

        JButton exportButton = new JButton("Export to File");
        JButton backButton = new JButton("Back");

        exportButton.setBackground(Color.LIGHT_GRAY);
        exportButton.setForeground(Color.BLACK);
        backButton.setBackground(Color.LIGHT_GRAY);
        backButton.setForeground(Color.BLACK);


        panel.add(exportButton);
        panel.add(backButton);

        exportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Export to file logic here
                university.getAdministrativeStaff().exportToFile();
                JOptionPane.showMessageDialog(panel, "Data exported to file successfully!");
            }
        });

        backButton.addActionListener(e -> cardLayout.show(mainPanel, "Home"));

        return panel;
    }

    private JPanel createLoadDataPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1));

        JButton loadButton = new JButton("Load Data");
        JButton backButton = new JButton("Back");

        loadButton.setBackground(Color.LIGHT_GRAY);
        loadButton.setForeground(Color.BLACK);
        backButton.setBackground(Color.LIGHT_GRAY);
        backButton.setForeground(Color.BLACK);


        panel.add(loadButton);
        panel.add(backButton);

        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Load data logic here
                university.loadData("university_data.dat");
                JOptionPane.showMessageDialog(panel, "Data loaded successfully!");
            }
        });

        backButton.addActionListener(e -> cardLayout.show(mainPanel, "Home"));

        return panel;
    }

    private JPanel createSaveDataPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1));

        JButton saveButton = new JButton("Save Data");
        JButton backButton = new JButton("Back");

        
        saveButton.setBackground(Color.LIGHT_GRAY);
        saveButton.setForeground(Color.BLACK);
        backButton.setBackground(Color.LIGHT_GRAY);
        backButton.setForeground(Color.BLACK);

        panel.add(saveButton);
        panel.add(backButton);

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Save data logic here
                university.saveData("university_data.dat");
                JOptionPane.showMessageDialog(panel, "Data saved successfully!");
            }
        });

        backButton.addActionListener(e -> cardLayout.show(mainPanel, "Home"));

        return panel;
    }

    private JPanel createSearchStudentByNamePanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        JLabel nameLabel = new JLabel("Student Name:");
        JTextField nameField = new JTextField();
        JButton searchButton = new JButton("Search");
        JButton backButton = new JButton("Back");

                
        searchButton.setBackground(Color.LIGHT_GRAY);
        searchButton.setForeground(Color.BLACK);
        backButton.setBackground(Color.LIGHT_GRAY);
        backButton.setForeground(Color.BLACK);

        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(searchButton);
        panel.add(backButton);

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                if (nameField.getText().isEmpty()  ) {
                    JOptionPane.showMessageDialog(panel, "Please enter Student name first.");
                    return;
                }

                String name = nameField.getText();
                ArrayList<Student> students = university.searchStudentByName(name);

                if (!students.isEmpty()) {
                    StringBuilder studentDetails = new StringBuilder("Students:\n");
                    for (Student student : students) {
                        studentDetails.append(student.toString()).append("\n");
                    }
                    JOptionPane.showMessageDialog(panel, studentDetails.toString());
                } else {
                    JOptionPane.showMessageDialog(panel, "No students found with the name: " + name);
                }
            }
        });

        backButton.addActionListener(e -> cardLayout.show(mainPanel, "Student Operations"));

        return panel;
    }

    private JPanel createFilterCoursesByCreditsPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        JLabel creditsLabel = new JLabel("Credits:");
        JTextField creditsField = new JTextField();
        JButton filterButton = new JButton("Filter");
        JButton backButton = new JButton("Back");

                        
        filterButton.setBackground(Color.LIGHT_GRAY);
        filterButton.setForeground(Color.BLACK);
        backButton.setBackground(Color.LIGHT_GRAY);
        backButton.setForeground(Color.BLACK);

        panel.add(creditsLabel);
        panel.add(creditsField);
        panel.add(filterButton);
        panel.add(backButton);

        filterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (creditsField.getText().isEmpty()  ) {
                    JOptionPane.showMessageDialog(panel, "Please enter Credits .");
                    return;
                }


                int credits = Integer.parseInt(creditsField.getText());
                java.util.List<Course> courses = university.filterCoursesByCredits(credits);
                if (!courses.isEmpty()) {
                    StringBuilder courseDetails = new StringBuilder("Courses:\n");
                    for (Course course : courses) {
                        courseDetails.append(course.toString()).append("\n");
                    }
                    JOptionPane.showMessageDialog(panel, courseDetails.toString());
                } else {
                    JOptionPane.showMessageDialog(panel, "No courses found with " + credits + " credits.");
                }
            }
        });

        backButton.addActionListener(e -> cardLayout.show(mainPanel, "Course Operations"));

        return panel;
    }

    private JPanel createDisplayTeacherCoursesPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        JLabel teacherIdLabel = new JLabel("Teacher ID:");
        JTextField teacherIdField = new JTextField();
        JButton displayButton = new JButton("Display Courses");
        JButton backButton = new JButton("Back");

        displayButton.setBackground(Color.LIGHT_GRAY);
        displayButton.setForeground(Color.BLACK);
        backButton.setBackground(Color.LIGHT_GRAY);
        backButton.setForeground(Color.BLACK);

        panel.add(teacherIdLabel);
        panel.add(teacherIdField);
        panel.add(displayButton);
        panel.add(backButton);

        displayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

               if( teacherIdField.getText().isEmpty()  ) {
                    JOptionPane.showMessageDialog(panel, "Please enter Teacher ID first.");
                    return;
                }
                int teacherId = Integer.parseInt(teacherIdField.getText());
                Teacher teacher = university.findTeacherById(teacherId);
                if (teacher != null) {
                    JOptionPane.showMessageDialog(panel, teacher.getCourseDetails());
                    System.out.println(teacher.getCourseDetails());
                } else {
                    JOptionPane.showMessageDialog(panel, "Teacher not found!");
                }
            }
        });

        backButton.addActionListener(e -> cardLayout.show(mainPanel, "Teacher Operations"));

        return panel;
    }


    private JPanel createRemoveStudentFromCoursePanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));

        JLabel studentIdLabel = new JLabel("Student ID:");
        JTextField studentIdField = new JTextField();
        JLabel courseIdLabel = new JLabel("Course ID:");
        JTextField courseIdField = new JTextField();
        JButton removeButton = new JButton("Remove");
        JButton backButton = new JButton("Back");

        removeButton.setBackground(Color.LIGHT_GRAY);
        removeButton.setForeground(Color.BLACK);
        backButton.setBackground(Color.LIGHT_GRAY);
        backButton.setForeground(Color.BLACK);

        panel.add(studentIdLabel);
        panel.add(studentIdField);
        panel.add(courseIdLabel);
        panel.add(courseIdField);
        panel.add(removeButton);
        panel.add(backButton);

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if( studentIdField.getText().isEmpty() || courseIdField.getText().isEmpty()  ) {
                    JOptionPane.showMessageDialog(panel, "Stdeunt ID or Course ID field cannot be empty.");
                    return;
                }

                int studentId = Integer.parseInt(studentIdField.getText());
                int courseId = Integer.parseInt(courseIdField.getText());

                Student student = university.findStudentById(studentId);
                Course course = university.findCourseById(courseId);

                if(student != null && student.getEnrolledCourseCount() == 0){

                    JOptionPane.showMessageDialog(panel, "Student is not enrolled in any course!");
                    return;
                }

                if(!university.isCourseAssignedToStudent(studentId, courseId)){
                    JOptionPane.showMessageDialog(panel, "Student is not enrolled in this course!");
                    return;
                }

                if (student != null && course != null) {
                    university.removeStudentFromCourse(student, course);
                    JOptionPane.showMessageDialog(panel, "Student removed from course successfully!");
                } else {
                    JOptionPane.showMessageDialog(panel, "Student or Course not found!");
                }
            }
        });

        backButton.addActionListener(e -> cardLayout.show(mainPanel, "Course Operations"));

        return panel;
    }

    private JPanel createDisplaySystemStatsPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1));

        JButton displayButton = new JButton("Display System Stats");
        JButton backButton = new JButton("Back");

        displayButton.setBackground(Color.LIGHT_GRAY);
        displayButton.setForeground(Color.BLACK);
        backButton.setBackground(Color.LIGHT_GRAY);
        backButton.setForeground(Color.BLACK);

        panel.add(displayButton);
        panel.add(backButton);

        displayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Display system stats logic here
                String stats = university.getSystemStats();
                JOptionPane.showMessageDialog(panel, stats);
            }
        });

        backButton.addActionListener(e -> cardLayout.show(mainPanel, "Home"));

        return panel;
    }

    private JPanel createAddGradePanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));

        JLabel studentIdLabel = new JLabel("Student ID:");
        JTextField studentIdField = new JTextField();
        JLabel courseIdLabel = new JLabel("Course ID:");
        JTextField courseIdField = new JTextField();
        JLabel gradeLabel = new JLabel("Grade:");
        JTextField gradeField = new JTextField();
        JButton addGradeButton = new JButton("Add Grade");
        JButton backButton = new JButton("Back");

        addGradeButton.setBackground(Color.LIGHT_GRAY);
        addGradeButton.setForeground(Color.BLACK);
        backButton.setBackground(Color.LIGHT_GRAY);
        backButton.setForeground(Color.BLACK);

        panel.add(studentIdLabel);
        panel.add(studentIdField);
        panel.add(courseIdLabel);
        panel.add(courseIdField);
        panel.add(gradeLabel);
        panel.add(gradeField);
        panel.add(addGradeButton);
        panel.add(backButton);

        addGradeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add grade logic here
                if (studentIdField.getText().isEmpty() || courseIdField.getText().isEmpty() || gradeField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(panel, "Please fill in all fields.");
                    return;
                }

                int studentId = Integer.parseInt(studentIdField.getText());
                int courseId = Integer.parseInt(courseIdField.getText());
                double grade = Double.parseDouble(gradeField.getText());

                Student student = university.findStudentById(studentId);
                Course course = university.findCourseById(courseId);

                if (student != null && course != null) {

                    if (grade < 0 || grade > 100) {
                        JOptionPane.showMessageDialog(panel,"Invalid grade input. Grade must be between 0 and 100."
                        );
                        return;
                    }
                    if (!university.isCourseAssignedToStudent(course.getCourseId())) {
                        JOptionPane.showMessageDialog(panel,"Student " + student.getName() + " is not enrolled in course " + course.getTitle()
                        );

                        return;
                    }

                    university.addGrade(student, course, grade);
                    JOptionPane.showMessageDialog(panel, "Grade added successfully!");
                } else {
                    JOptionPane.showMessageDialog(panel, "Student or Course not found!");
                }
            }
        });

        backButton.addActionListener(e -> cardLayout.show(mainPanel, "Course Operations"));

        return panel;
    }


}