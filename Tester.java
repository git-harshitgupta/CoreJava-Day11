import com.app.core.Course;
import com.app.core.Student;

import java.util.*;

import static Validation.Validation.*;
import static CollectionUtils.CollectionUtils.*;

public class Tester {
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {
            ArrayList<Student> students = polulateStudent();
            boolean exit = false;
            while(!exit){
                try {
                    System.out.println("1.Add Student\n2.Fetch Student Details\n3.Display all Student\n4.Cancel Admission\n5.Update GPA");
                    System.out.println("Enter your choose");
                    switch(sc.nextInt()){
                        case 1:
                            System.out.println("Enter prn,name,email,password,course,dateOfBirth,GPA");
                            Student e = new Student(sc.next(),sc.next(),validateEmail(sc.next()),validatePassword(sc.next()),convertCourse(sc.next()),convertDate(sc.next()),sc.next());
                            students.add(e);
                            break;
                        case 2:
                            System.out.println("Enter the PNR number");
                            Student pnr = new Student(sc.next());
                            int index = students.indexOf(pnr);
                            System.out.println(students.get(index));
                            break;
                        case 3:
                            for (Student temp : students){
                                System.out.println(temp);
                            }
                            break;
                        case 4:
                            System.out.println("Enter the pnr to be removed");
                            String removePnr = sc.next();
                            if(pnrVarification(removePnr,students)){
                                int removeIndex=students.indexOf(new Student(removePnr));
                                students.remove(removeIndex);
                            }
                            break;
                        case 5:
                            System.out.println("Enter the pnr to be updated");
                            String updatePnr = sc.next();
                            if(pnrVarification(updatePnr,students)){
                                int updateIndex=students.indexOf(new Student(updatePnr));
                                System.out.println("Enter name,course,dateOfBirth,GPA");
                                students.set(updateIndex,new Student(sc.next(),convertCourse(sc.next()),convertDate(sc.next()),sc.next()));
                            }
                            break;
                        case 6:
                            System.out.println("Enter the course");
                            showCourse(sc.next(), students);
                            break;
                        case 7:
                            Collections.sort(students);
                            break;
                        case 8:
                            Collections.sort(students,new Comparator<Student>(){
                                @Override
                                public int compare (Student o1 , Student o2) {
                                    return o1.getGPA().compareTo(o2.getGPA());
                                }
                            });
                            break;
                        case 9:
                            Collections.sort(students, new Comparator<Student>() {
                                @Override
                                public int compare(Student o1, Student o2) {
                                    int index=o1.getCourse().name().compareTo(o2.getCourse().name());
                                    if(index==0){
                                        if(-1==o1.getPrn().compareTo(o2.getPrn())){
                                            return -1;
                                        }if(1==o1.getPrn().compareTo(o2.getPrn())){
                                            return 1;
                                        }
                                    }
                                    return index;
                                }
                            });
                            break;
                        case 10:
                            for(int i=0;i< students.size();i++){
                                double num=Double.parseDouble(students.get(i).getGPA());
                                if(num<5)
                                    students.remove(i);
                            }
                            break;
                        case 11:
                            for(int i= (students.size())-1;i>=0;--i){
                                System.out.println(students.get(i));
                            }

                    }
                }
                catch(Exception e){
                    e.printStackTrace();
                }
                sc.nextLine();
            }
        }
    }
}
