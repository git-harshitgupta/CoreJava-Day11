package Validation;

import CustomException.StudentExecptionHandler;
import com.app.core.Course;
import com.app.core.Student;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import static com.app.core.Student.sdf;
public class Validation {

    public static String validateEmail(String email){
        return email;
    }
    public static String validatePassword(String password){
        return password;
    }

    public static Date convertDate(String date) throws ParseException {
        return sdf.parse(date);
    }
    public static boolean courseExist(String course) throws StudentExecptionHandler {
        for(Course temp : Course.values()){
            if(temp.name().equals(course.toUpperCase()))
                return true;
        }
        throw new StudentExecptionHandler("Course is not aviable");
    }
    public static Course convertCourse(String course) throws StudentExecptionHandler {
        if(courseExist(course))
            return Course.valueOf(course.toUpperCase());
        throw new StudentExecptionHandler("Course not exist");
    }

    public static boolean pnrVarification(String pnr , ArrayList<Student> student) throws StudentExecptionHandler{
        if(student.contains(new Student(pnr)))
            return true;
        throw new StudentExecptionHandler("Invalid PNR entered");
    }

    public static void showCourse(String course, ArrayList<Student> student) throws StudentExecptionHandler{
        for(Student temp : student){

            if(temp.equalsCourse(course.toUpperCase())){
                System.out.println(temp);
            }
        }
    }

    public static ArrayList<Student> returnCourse(String course, ArrayList<Student> student) throws StudentExecptionHandler{
        ArrayList<Student> tem = null;
        for(Student temp : student){

            if(temp.equalsCourse(course.toUpperCase())){
                tem.add(temp);
            }
        }
        return tem;
    }





}
