
package controllers;

import java.util.ArrayList;
import java.util.Collections;
import models.Student;

public class StudentManager {
    private static ArrayList<Student> students = new ArrayList<>();
    
    public void initiate() {
        students.add(new Student("DE180000", "Hoang Trong Quang", "Spring", "Java"));
        students.add(new Student("DE180001", "Nguyen Dinh Chinh", "Spring", "C/C++"));
        students.add(new Student("DE180002", "Tran Trung Dung", "Spring", ".Net"));
        students.add(new Student("DE180003", "Nguyen Quoc Cuong", "Spring", ".Net"));
    }
    
    public String createID() {
        return "DE" + String.valueOf(180000 + students.size());
    }
    
    public void add(int course, String name, int semester) {
        String[] courses = {"Java", ".Net", "C/C++"};
        String[] semesters = {"Spring", "Summer", "Fall"};
        students.add(new Student(createID(), name, semesters[semester-1], courses[course-1]));  
    }
    
    public void add(String id, int course, String name, int semester) {
        String[] courses = {"Java", ".Net", "C/C++"};
        String[] semesters = {"Spring", "Summer", "Fall"};
        students.add(new Student(id, name, semesters[semester-1], courses[course-1]));  
    }
    
    public void view() {
        for (Student s : students) {
            System.out.println(s);
        }
    }
    
    public String checkExist(String id) {
        for (Student s : students) {
            if (s.getId().equals(id)) {
                return s.getName();
            }
        }
        return "";
    }
    
    public void search(String name) {
        Collections.sort(students);
        for (Student s : students) {
            if (s.getName().contains(name)) {
                System.out.println(s);
            }
        }
    }
    
    public void delete(String id){
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId().equals(id)) {
                students.remove(i);
                i--;
            }
        }
    }
    
    public void update(String id, String name) {
        if (name.equals("")) {
            return;
        }
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId().equals(id)) {
                students.get(i).setName(name);
            }
        }
    }
    
    public void report() {
        ArrayList<Student> temp = students;
        while (temp.size() != 0) {         
            int count = 1;
            for (int i = 1; i < temp.size(); i++) {
                if (temp.get(i).getId().equals(temp.get(0).getId()) && temp.get(i).getCourse().equals(temp.get(0).getCourse())) {
                    count++;
                    temp.remove(i);
                    i--;
                }       
            }
            System.out.println(String.format("%-8s | %-18s | %-6s | %-2d |", temp.get(0).getId(), temp.get(0).getName(), temp.get(0).getCourse(), count));
            temp.remove(0);
        }
    }
}
