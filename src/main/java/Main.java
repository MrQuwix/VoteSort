import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javax.swing.*;
import java.util.*;

public class Main {

    public static void main(String [] args){
        String[] names = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"}; //, "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "AA", "BB", "CC", "DD", "EE", "FF", "GG", "HH", "II", "JJ", "KK", "LL", "MM", "NN", "OO", "PP", "QQ", "RR", "SS", "TT", "UU", "VV", "WW", "XX" };
        ArrayList<Selection> selections = new ArrayList<Selection>();

        for(int i=0; i< names.length; i++){
            selections.add(new Selection(names[i]));
        }

        for(int k=0; k<7; k++) {
            for (int i = 0; i < selections.size(); i += 2) {
                vote(selections.get(i), selections.get(i + 1));
            }

            Collections.sort(selections, new SortByRank());

            for(int i=0; i<selections.size(); i++){
                System.out.println(selections.get(i).getName() + " ranked: " + selections.get(i).getRank() + " defeated: " + selections.get(i).getDefeated());
            }

            selections = sort(selections);

            for(int i=0; i<selections.size(); i++){
                System.out.println(selections.get(i).getName() + " ranked: " + selections.get(i).getRank() + " defeated: " + selections.get(i).getDefeated());
            }
        }

        for(int i=0; i<selections.size(); i++){
            System.out.println(selections.get(i).getName() + " ranked: " + selections.get(i).getRank() + " defeated: " + selections.get(i).getDefeated().size());
        }


    }

    public Selection[] shuffle(Selection[] selections){

        Selection[] shuffled = new Selection[50];

        return shuffled;
    }

    public static void vote(Selection A, Selection B){
        int choice;
        if(A.getDefeated().contains((B))) {
            System.out.println((A.getName() + " has already defeated " + B.getName()));
            choice = 1;
        } else if(B.getDefeated().contains((A))) {
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

    public static ArrayList<Selection> sort(ArrayList<Selection> selections){

        //ArrayList<Selection> reRanked = new ArrayList<Selection>();

        for(int i=0; i<selections.size(); i++){
            for(int j=i+1; j<selections.size(); j++){
                if(selections.get(j).getDefeated().contains(selections.get(i))){
                    System.out.println(i + " " + j);
                    //reRanked.add(selections.get(j));
                    Collections.swap(selections, i, j);
                }
            }
            //reRanked.add(selections.get(i));
        }


        return selections;
    }

}
