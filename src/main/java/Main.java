import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javax.swing.*;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String [] args){
        String[] names = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"}; //, "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "AA", "BB", "CC", "DD", "EE", "FF", "GG", "HH", "II", "JJ", "KK", "LL", "MM", "NN", "OO", "PP", "QQ", "RR", "SS", "TT", "UU", "VV", "WW", "XX" };
        Selection[] selections = new Selection[10];

        for(int i=0; i< names.length; i++){
            selections[i] = new Selection(names[i]);
        }

        for(int k=0; k<7; k++) {
            for (int i = 0; i < selections.length; i += 2) {
                vote(selections[i], selections[i + 1]);
            }

            Arrays.sort(selections, new SortByRank());

            for(int i=0; i<selections.length; i++){
                System.out.println(selections[i].getName() + " ranked: " + selections[i].getRank() + " defeated: " + selections[i].getDefeated().size());
            }

            sort(selections);

            for(int i=0; i<selections.length; i++){
                System.out.println(selections[i].getName() + " ranked: " + selections[i].getRank() + " defeated: " + selections[i].getDefeated().size());
            }
        }

        for(int i=0; i<selections.length; i++){
            System.out.println(selections[i].getName() + " ranked: " + selections[i].getRank() + " defeated: " + selections[i].getDefeated().size());
        }


    }

    public Selection[] shuffle(Selection[] selections){

        Selection[] shuffled = new Selection[50];

        return shuffled;
    }

    public static void vote(Selection A, Selection B){
        int choice;
        if(Arrays.asList(A.getDefeated()).contains((B))) {
            System.out.println((A.getName() + " has already defeated " + B.getName()));
            choice = 1;
        } else if(Arrays.asList(B.getDefeated()).contains((A))) {
            System.out.println((B.getName() + " has already defeated " + A.getName()));
            choice = 2;
        } else {
            Scanner in = new Scanner(System.in);
            // Display the menu
            System.out.println("1\t" + A.getName());
            System.out.println("2\t" + B.getName());

            System.out.println("Please enter your choice:");

            //Get user's choice
            choice = in.nextInt();
        }
        //Display the title of the chosen module
        switch (choice) {
            case 1: System.out.println(A.getName());
                A.addDefeated(B);
                A.setRank(A.getRank()+1);
                break;
            case 2: System.out.println(B.getName());
                B.addDefeated(A);
                B.setRank(B.getRank()+1);
                break;
            default: System.out.println("Idiot");
        }

    }

    public static Selection[] sort(Selection[] selections){

        Selection[] reRanked = new Selection[10];

        for(int i=0; i<selections.length; i++){
            for(int j=i+1; j<selections.length; j++){
                if(Arrays.asList(selections[i].getDefeated()).contains(selections[j])){
                    reRanked[i] = selections[j];
                    selections[j] = selections[i];
                }
            }
            reRanked[i]=selections[i];
        }


        return reRanked;
    }

}
