package Assignment1;

public class Student_Thread extends Thread
{
    public Student_Thread(int Malay_Student, int Chinese_Student, int Indian_Student,  int Total_Student)
    {
        System.out.println();
        //divider
        System.out.println("--------------------- Total All Student ---------------------");

        //Print Total Student
        System.out.println("All Total Students = " + Total_Student);

        //Print Malaysian Student
        System.out.println("All Malay Students in Total : " + Malay_Student);

        //Print Chinese Student
        System.out.println("All Chinese Students in Total : " + Chinese_Student);

        //Print Indian Student
        System.out.println("All indian Students in Total : " + Indian_Student);
    }
}
