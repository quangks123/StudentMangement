package views;

import controllers.StudentManager;
import controllers.Validation;

public class MainMenu extends Menu{
    private Validation val = new Validation();

    public MainMenu(String title, String[] choices) {
        super(title, choices);
    }

    @Override
    public void execute(int ch) {
        switch (ch) {
            case 1:
                while (true) {
                    
                    System.out.println("===== CREATE =====");
                    System.out.println("1. Create new student");
                    System.out.println("2. Create new course for student");
                    System.out.print("Choose: ");
                    int choice;
                    
                    //choose
                    while (true) {                        
                        choice = val.inputNum();
                        if ((choice < 1) || equals(choice > 2)) {
                            System.out.println("---------------");
                            System.out.print("Choose again: ");
                        } else {
                            break;
                        }
                    }
                    
                    switch (choice) {
                        case 1:
                            String name;
                            int course, semester;

                            //Input Name                    
                            System.out.print("Name: ");
                            while (true) {                        
                                name = val.inputString();
                                if (name.equals("")) {
                                    System.out.println("---------------");
                                    System.out.println("Name just contain letter!!");
                                    System.out.print("Re-enter name: ");
                                } else {
                                    break;
                                }
                            }

                            //Choose course
                            System.out.println("---- COURSE ----");
                            System.out.println("1. Java");
                            System.out.println("2. .Net");
                            System.out.println("3. C/C++");

                            System.out.print("Choose course: ");
                            while (true) {                        
                                course = val.inputNum();
                                if ((course < 1) || (course > 3)) {
                                    System.out.println("---------------");
                                    System.out.print("Not found course!!\nChoose again: ");
                                } else {
                                    break;
                                }
                            }

                            //choose semester
                            System.out.println("---- SEMESTER ----");
                            System.out.println("1. Spring");
                            System.out.println("2. Summer");
                            System.out.println("3. Fall");

                            System.out.print("Choose semester: ");
                            while (true) {                        
                                semester = val.inputNum();
                                if ((semester < 1) || (semester > 3)) {
                                    System.out.println("---------------");
                                    System.out.print("Not found semester!!\nChoose again: ");
                                } else {
                                    break;
                                }
                            }

                            //create
                            new StudentManager().add(course, name, semester);
                            System.out.println("CREATE SUCCESS!!");
                            System.out.println("---------------");
                            break;
                        case 2:
                            //ID
                            String id;
                            System.out.print("ID: ");
                            while (true) {                                
                                id = val.inputString();
                                if (!val.checkID(id)) {
                                    System.out.println("---------------");
                                    System.out.println("ID must be formed: DE******");
                                    System.out.print("Re-enter: ");
                                } else {
                                    break;
                                }
                            }
                            id = id.toUpperCase();
                            
                            //check exist
                            if (new StudentManager().checkExist(id).equals("")) {
                                System.out.println("Not found!!");
                                System.out.println("---------------");
                                System.out.println("CREATE FAILED!!");
                                System.out.println("---------------");
                                break;
                            }
                            
                            name = new StudentManager().checkExist(id);
                            
                            //Choose course
                            System.out.println("---- COURSE ----");
                            System.out.println("1. Java");
                            System.out.println("2. .Net");
                            System.out.println("3. C/C++");

                            System.out.print("Choose course: ");
                            while (true) {                        
                                course = val.inputNum();
                                if ((course < 1) || (course > 3)) {
                                    System.out.println("---------------");
                                    System.out.print("Not found course!!\nChoose again: ");
                                } else {
                                    break;
                                }
                            }

                            //choose semester
                            System.out.println("---- SEMESTER ----");
                            System.out.println("1. Spring");
                            System.out.println("2. Summer");
                            System.out.println("3. Fall");

                            System.out.print("Choose semester: ");
                            while (true) {                        
                                semester = val.inputNum();
                                if ((semester < 1) || (semester > 3)) {
                                    System.out.println("---------------");
                                    System.out.print("Not found semester!!\nChoose again: ");
                                } else {
                                    break;
                                }
                            }
                            
                            new StudentManager().add(id, course, name, semester);
                    }

                    //check continue
                    String stop;
                    while (true) {                        
                        System.out.print("Do you want to continue (Y/N)? Choose Y to continue, N to return main screen: ");
                        stop = val.inputString();
                        if (!stop.equalsIgnoreCase("Y") && !stop.equalsIgnoreCase("N")) {
                            
                        } else {
                            break;
                        }
                    }   
                    
                    if (stop.equalsIgnoreCase("N")) {
                        break;
                    }
                }
                break;
            
            case 2:
                new StudentManager().view();
                break;
                
            case 3:
                System.out.println("===== SEARCH =====");
                System.out.print("Name: ");
                String name = val.inputString();
                new StudentManager().search(name);
                break;
            
            case 4:  
                String id;
                String choice;
                int course, semester;
                while (true) {   
                    System.out.print("Do you want to update (U) or delete (D) student: ");
                    choice = val.inputString();
                    if (!choice.equalsIgnoreCase("U") && !choice.equalsIgnoreCase("D")) {
                    } else {
                        break;
                    }
                }    
                
                if (choice.equalsIgnoreCase("U")) {
                    System.out.print("ID: ");
                    while (true) {                                
                        id = val.inputString();
                        if (!val.checkID(id)) {
                            System.out.println("---------------");
                            System.out.println("ID must be formed: DE******");
                            System.out.print("Re-enter: ");
                        } else {
                            break;
                        }
                    }
                    id = id.toUpperCase();
                            
                    //check exist
                    if (new StudentManager().checkExist(id).equals("")) {
                        System.out.println("Not found!!");
                        break;
                    }
                    
                    System.out.print("Name: ");                       
                    name = val.inputString();
                    
                    new StudentManager().update(id, name);
                    System.out.println("UPDATE SUCCESS!!");
                }
                
                if (choice.equalsIgnoreCase("D")) {
                    System.out.print("ID: ");
                    while (true) {                                
                        id = val.inputString();
                        if (!val.checkID(id)) {
                            System.out.println("---------------");
                            System.out.println("ID must be formed: DE******");
                            System.out.print("Re-enter: ");
                        } else {
                            break;
                        }
                    }
                        id = id.toUpperCase();

                    //check exist
                    if (new StudentManager().checkExist(id).equals("")) {
                        System.out.println("Not found!!");
                        break;
                    }

                    new StudentManager().delete(id);
                    System.out.println("DELETE SUCCESS!!");
                }
                break;
            case 5:
                System.out.println("===== REPORT =====");
                new StudentManager().report();
                break;
        }
        
    }
    
}
