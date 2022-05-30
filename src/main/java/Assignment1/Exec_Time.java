package Assignment1;

public class Exec_Time extends Thread
{
    public Exec_Time()
    {
        //time start
        long Time_Start = System.currentTimeMillis();

        //for condition to find the execution time
        for (int a = 0; a < 5; a++) {
            try {
                Thread.sleep(60);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // finding the execution time
        long Time_End = System.currentTimeMillis();

        //calculate the time and then convert to seconds
        float Execution_Time = (Time_End - Time_Start) / 1000F;

        //print the execution time
        System.out.println();
        System.out.println("--------------------- Execution Time ---------------------");
        System.out.println("Total Execution The Project is : " + Execution_Time + " seconds");
    }
}
