package Assignment1;
import javafx.application.Application;
import javafx.stage.Stage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;



    public class App extends Application {



        @Override
        public void start(Stage stage) throws Exception {
            //declare githubLink
            final String githubLink = "https://github.com/socuum/STIX3912/wiki/List-of-Supervisors-(A211)";

            //declare String Name, Number List, Matric Number, Supervisor
            String[] Name = new String[170];
            String[] Number_List = new String[170];
            String[] Matric_Number = new String[170];
            String[] Superv = new String[170];

            //declare All Student and Supervisor
            int Malaysian_Student = 0;
            int Indian_Student = 0;
            int Chinese_Student = 0;
            int Supervisor_Total = 0;
            int i = 0;

            //try catch method to execute the data
            try {
                final Document document = Jsoup.connect(githubLink).get();

                //using for loop and if else statement to divide the name, number matric, number list, and supervisor
                for (Element row : document.select("table tr"))
                    if (row.select("td:nth-of-type(1)").text().equals("")) {
                        continue;
                    } else {
                        Number_List[i] =
                                row.select("td:nth-of-type(1)").text();
                        Matric_Number[i] =
                                row.select("td:nth-of-type(2)").text();
                        Name[i] =
                                row.select("td:nth-of-type(3)").text();
                        Superv[i] =
                                row.select("td:nth-of-type(4)").text();

                        System.out.println(Number_List[i] + " " + Matric_Number[i] + " " + Name[i] + " " + Superv[i]);
                        i++;
                    }

                //using for loop to filter malaysian, chinese, indian student
                for (int a = 0; a < i; a++) {
                    if (Name[a].contains("BINTI") || Name[a].contains("BIN")) {
                        Malaysian_Student++;
                    } else if (Name[a].contains("A/L") || Name[a].contains("A/P")) {
                        Indian_Student++;
                    } else {
                        Chinese_Student++;
                    }
                }

                //Print all Malaysian Student List
                System.out.println();
                System.out.println("--------------------- Malaysian Student List ---------------------");
                System.out.println("All Malaysian Student List : ");

                //for loop to filter the malaysian Student
                for (int a = 0; a < i; a++) {
                    if (Name[a].contains("BINTI") || Name[a].contains("BIN")) {
                        System.out.println(Name[a]);
                    }
                }

                //Print all Chinese Student List
                System.out.println();
                System.out.println("--------------------- Chinese Student List ---------------------");
                System.out.println("All Chinese Student List : ");

                //for loop to filter the chinese Student
                for (int a = 0; a < i; a++) {
                    if (!Name[a].contains("A/L") && !Name[a].contains("A/P") && !Name[a].contains("BINTI") && !Name[a].contains("BIN")) {
                        System.out.println(Name[a]);
                    }
                }

                //Print all Indian Student List
                System.out.println();
                System.out.println("--------------------- Indian Student List ---------------------");
                System.out.println("All Indian Student List  : ");

                //for loop to filter the indian Student
                for (int a = 0; a < i; a++) {
                    if (Name[a].contains("A/L") || Name[a].contains("A/P")) {
                        System.out.println(Name[a]);
                    }
                }

                //Print all Supervisor List
                System.out.println();
                System.out.println("--------------------- All Supervisor List ---------------------");
                System.out.println("All Supervisor List : ");

                //for loop to filter All Supervisor
                for (int a = 0; a < i; a++) {
                    if (Superv[a].equals(Superv[a + 1]) && !Superv[a].equals(Superv[a + 2]) && !Superv[a].equals(Superv[a + 3])) {
                        System.out.println(Superv[a]);
                        Supervisor_Total++;
                    }
                }

                //declare Thread
                Student_Thread Student_Thread = new Student_Thread(Malaysian_Student, Indian_Student, Chinese_Student, i);
                Supervisor_Thread Supervisor_Thread = new Supervisor_Thread(Supervisor_Total);
                Exec_Time Execution_Time = new Exec_Time();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }