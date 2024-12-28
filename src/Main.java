import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        School school = new School();

        Scanner scanner = new Scanner(new File("/Users/violettayun/IdeaProjects/Assigment.1/src/studens.txt"));
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();

            if (line.isEmpty()) continue;

            String[] parts = line.split(",");

            if (parts.length < 4) {
                System.out.println("" + line);
                continue;
            }

            String name = parts[0].trim();
            String surname = parts[1].trim();
            int age = Integer.parseInt(parts[2].trim());
            boolean gender = parts[3].trim().equalsIgnoreCase("male");

            Student student = new Student(name, surname, age, gender);

            for (int i = 4; i < parts.length; i++) {
                student.addGrade(Integer.parseInt(parts[i].trim()));
            }
            school.addMember(student);
        }
        scanner.close();

        scanner = new Scanner(new File("/Users/violettayun/IdeaProjects/Assigment.1/src/teacher.txt"));
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();

            if (line.isEmpty()) continue;

            String[] parts = line.split(",");

            if (parts.length < 7) {
                System.out.println("" + line);
                continue;
            }

            String name = parts[0].trim();
            String surname = parts[1].trim();
            int age = Integer.parseInt(parts[2].trim());
            boolean gender = parts[3].trim().equalsIgnoreCase("male");
            String subject = parts[4].trim();
            int yearsOfExperience = Integer.parseInt(parts[5].trim());
            int salary = Integer.parseInt(parts[6].trim());

            Teacher teacher = new Teacher(name, surname, age, gender, subject, yearsOfExperience, salary);
            school.addMember(teacher);
        }
        scanner.close();

        System.out.println("School Members:");
        System.out.println(school);


        for (Person member : school.getMembers()) {
            if (member instanceof Student) {
                Student student = (Student) member;
                System.out.println(student.getName() + " GPA: " + student.calculateGPA());
            } else if (member instanceof Teacher) {
                Teacher teacher = (Teacher) member;
                if (teacher.getYearsOfExperience() > 10) {
                    teacher.giveRaise(10);
                    System.out.println(teacher.getName() + " received a raise. New salary: " + teacher.getSalary());
                }
            }
        }
    }
}
