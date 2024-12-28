import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        School school = new School();

        Scanner studentScanner = new Scanner(new File("/Users/violettayun/IdeaProjects/Assigment.1/src/studens.txt"));
        while (studentScanner.hasNextLine()) {
            String line = studentScanner.nextLine().trim();
            if (!line.isEmpty()) {
                String[] studentData = line.split(" ");
                if (studentData.length >= 4) {
                    String name = studentData[0];
                    String surname = studentData[1];
                    int age = Integer.parseInt(studentData[2]);
                    boolean gender = Boolean.parseBoolean(studentData[3]);
                    Student student = new Student(name, surname, age, gender);
                    for (int i = 4; i < studentData.length; i++) {
                        student.addGrade(Integer.parseInt(studentData[i]));
                    }

                    school.addMember(student);
                }
            }
        }
        studentScanner.close();

        Scanner teacherScanner = new Scanner(new File("/Users/violettayun/IdeaProjects/Assigment.1/src/studens.txt"));
        while (teacherScanner.hasNextLine()) {
            String line = teacherScanner.nextLine().trim();
            if (!line.isEmpty()) {
                String[] teacherData = line.split(" ");
                if (teacherData.length >= 7) {
                    String name = teacherData[0];
                    String surname = teacherData[1];
                    int age = Integer.parseInt(teacherData[2]);
                    boolean gender = Boolean.parseBoolean(teacherData[3]);
                    String subject = teacherData[4];
                    int yearsOfExperience = Integer.parseInt(teacherData[5]);
                    int salary = Integer.parseInt(teacherData[6]);

                    Teacher teacher = new Teacher(name, surname, age, gender, subject, yearsOfExperience, salary);
                    school.addMember(teacher);
                }
            }
        }
        teacherScanner.close();

        for (Person member : school.getMembers()) {
            if (member instanceof Student) {
                Student student = (Student) member;
                System.out.println(student.getName() + "'s GPA: " + student.calculateGPA());
            }
        }

        for (Person member : school.getMembers()) {
            if (member instanceof Teacher) {
                Teacher teacher = (Teacher) member;
                if (teacher.getYearsOfExperience() > 10) {
                    teacher.giveRaise(10);
                    System.out.println(teacher.getName() + "'s new salary: " + teacher.getSalary());
                }
            }
        }

        school.displayMembers();
    }
}