package CollectionUtils;

import CustomException.StudentExecptionHandler;
import com.app.core.Student;

import java.text.ParseException;
import java.util.ArrayList;

import static Validation.Validation.*;
import static Validation.Validation.convertDate;

public class CollectionUtils {
    public static ArrayList<Student> polulateStudent(){
        ArrayList<Student> list = new ArrayList<Student>();
        try{
            list.add(new Student("2","Akash",validateEmail("akash@test.com"),validatePassword("akash"),convertCourse("Spring"),convertDate("8-05-1997"),"7.8"));
            list.add(new Student("1","Harshit",validateEmail("harshit@test.com"),validatePassword("harshit"),convertCourse("REACT"),convertDate("18-07-1998"),"9.8"));
            list.add(new Student("3","Shivendra",validateEmail("shivendra@test.com"),validatePassword("shivendra"),convertCourse("REACT"),convertDate("10-01-1997"),"4"));
            list.add(new Student("4","Rishabh",validateEmail("rishabh@test.com"),validatePassword("rishabh"),convertCourse("dbt"),convertDate("19-05-1998"),"7.9"));
            list.add(new Student("5","Juhi",validateEmail("juhi@test.com"),validatePassword("juhi"),convertCourse("angular"),convertDate("1-11-1999"),"8.5"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
