import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.*;

public class Main {
    public static void main(String[] args){
        ArrayList<Book> books = new ArrayList<>();
        BookManager bookManager = new BookManager(books);
        System.out.print("Welcome to the Library!\nYou can enter <<HELP>> to get the list of commands\n");
        String userInput;
        Scanner scan = new Scanner(System.in);
        do{
            System.out.print("Enter a command: ");
            userInput = scan.nextLine();
            executeCommand(userInput, bookManager);
        }while (!userInput.equals("STOP"));
        scan.close();

        System.out.print("The the Library was closed");
    }
    static void executeCommand(String userInput, BookManager bookManager){
        Pattern pattern = Pattern.compile("(\\s\\{\"|\":\"|\",\\s\"|\":|\"*})");
        String[] commandAndSup = pattern.split(userInput.trim());
        String[] supplement;
        switch (commandAndSup[0]){
            case "GET":
                supplement = supplementsOrder(commandAndSup);
                bookManager.get(supplement);
                break;
            case "HELP":
                bookManager.help();
                break;
            case "POST":
                supplement = supplementsOrder(commandAndSup);
                bookManager.post(supplement);
                break;
            case "STOP":
                System.out.println("The session was stopped");
                break;
            default:
                System.out.println("There is no such command");
        }
    }
    static String[] supplementsOrder(String[] commandAndSup){
        String[] supplement = new String[3];
        for(int i=1; i<commandAndSup.length; i+=2){
            switch (commandAndSup[i]){
                case "Name":
                    supplement[0]=commandAndSup[i+1];
                    break;
                case "Author":
                    supplement[1]=commandAndSup[i+1];
                    break;
                case "PagesCount":
                    supplement[2]=commandAndSup[i+1];
                    break;
                default:
                    System.out.println("The command is incorrect");
            }
        }
        return supplement;
    }
}