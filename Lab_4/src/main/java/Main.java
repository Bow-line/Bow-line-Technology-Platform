import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);
        Scanner scanning = new Scanner(System.in);
        EntityManagerFactory emf
                = Persistence.createEntityManagerFactory("lab4");

        EditWizard editorWizard = new EditWizard(emf);
        EditSchool editorSchool = new EditSchool(emf);

        String name ="";
        int levelOrHeight = 0;

        while(true){
            System.out.println("Write down the commend: ");
            String command = scan.nextLine();
            if(Objects.equals(command, "addWizard")) {
                System.out.println("Wizard name: ");
                name = scan.nextLine();
                System.out.println("Wizard level: ");
                levelOrHeight = scan.nextInt();
                System.out.println("Name of the school: ");
                String school = scanning.nextLine();
                School theSchool = editorSchool.find(school);


                Wizard newWizard = new Wizard(name, levelOrHeight);
                    newWizard.setSchool(theSchool);
                    editorWizard.add(newWizard);
                    System.out.println("Wizard has been added");
            }
            else if(Objects.equals(command, "removeWizard")) {
                System.out.println("What is the name of the mage you want to remove? ");
                name = scan.nextLine();

                Wizard theWizard = editorWizard.find(name);

                editorWizard.remove(theWizard);
                System.out.println("Wizard has been removed");
            }
            else if(Objects.equals(command, "printWizard")) {
                List<Wizard> wizards = editorWizard.findAllObjects();
                System.out.println(wizards);
            }
            else if(Objects.equals(command, "addSchool")){
                System.out.println("School's name is: ");
                name = scan.nextLine();
                System.out.println("School's influence is: ");
                levelOrHeight = scan.nextInt();

                School newSchool = new School(name,levelOrHeight);

                editorSchool.add(newSchool);
                System.out.println("School has been added");
            }
            else if(Objects.equals(command, "removeSchool")) {
                System.out.println("What is the name of the school you want to remove? ");
                name = scan.nextLine();

                School theSchool = editorSchool.find(name);

                editorSchool.remove(theSchool);
                System.out.println("School has been removed");
            }
            else if(Objects.equals(command, "printSchool")) {
                List<School> schools = editorSchool.findAllObjects();
                System.out.println(schools);
            }
            else if(Objects.equals(command, "showQuery")){
                System.out.println("Choose one of 3 queries");
                System.out.println("Queries: \n 1.Nazwy szkoły o pływie > niż X \n " +
                        "2.Posortowane imion czarodziejów ze szkoły X, których poziom jest > niż Y");
                System.out.println("The query number: ");
                int answer = scan.nextInt();

                switch (answer){
                    case 1:
                        System.out.println("Give the number of influence: ");
                        int case1 = scan.nextInt();
                        System.out.println(editorSchool.findTheSchoolWithProperInfluence(case1));
                        break;
                    case 2:
                        System.out.println("Give the school name: ");
                        String case2 = scanning.nextLine();
                        School theSchool = editorSchool.find(case2);
                        System.out.println("Give the Wizard level number: ");
                        int case2_2 = scan.nextInt();
                        System.out.println(editorWizard.findTheParticularWizards(case2_2,theSchool));
                        break;
                }
            } else if (Objects.equals(command, "finish")) {
                emf.close();
                break;
            }
            else {
                System.out.println("Unrecognized command! Try again");
            }
        }
    }
}
