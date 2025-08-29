import java.util.*;
public class rockpaperscissor{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter 0 for rock,1 for paper,2 for scissor");
        int humaninput=sc.nextInt();

        Random random=new Random();
        int compinput=random.nextInt(3);

        if(humaninput<=2){
            System.out.println("Game starts:");
        }
        else{
            System.out.println("invalid user input");
        }

        if(humaninput==compinput)
            System.out.println("Game draw!");
        else if(humaninput==0&&compinput==2||humaninput==1&&compinput==0||humaninput==2&&compinput==1)
           System.out.println("You wins!");
        else 
           System.out.println("computer Wins!");
    }
}