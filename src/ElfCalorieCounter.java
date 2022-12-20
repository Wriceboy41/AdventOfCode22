import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class ElfCalorieCounter {

    public static void day1() {
        String path = "res/Elf.txt";
        File file = new File(path);

        Scanner scr;

        try {

            scr = new Scanner(file);

        } catch (FileNotFoundException e) {

            throw new RuntimeException(e);
        }
        int total = 0;
        int top = 0;
        int second = 0;
        int third = 0;
        int elves = 0;
        while (scr.hasNextLine()) {
            String s = scr.nextLine();
            System.out.println(s);

            // found a number,
            if (!s.isEmpty()) {
                int cal = Integer.parseInt(s);
                total += cal;

                // if its the end of the text file, add totals
                if(!scr.hasNextLine()){
                    if(top < total){
                        third = second;
                        second = top;
                        top = total;
                    } else if(second < total){
                        third = second;
                        second = total;
                    } else if(third < total){
                        third = total;
                    }
                    total=0;
                    elves++;
                }
            }
            // reached the end of the elf, add totals
            if (s.isEmpty()){
                if(top < total){
                    third = second;
                    second = top;
                    top = total;
                } else if(second < total){
                    third = second;
                    second = total;
                } else if(third < total){
                    third = total;
                }
                total=0;
                elves++;
            }

        }
        System.out.println(third);
        System.out.println(second);
        System.out.println(top);
        total = top + second + third;
        System.out.println(elves);
        System.out.println(total);
    }

    public static void day2() {
        String path = "res/rock.txt";
        File file = new File(path);

        Scanner scr;

        try {

            scr = new Scanner(file);

        } catch (FileNotFoundException e) {

            throw new RuntimeException(e);
        }

        int total = 0;
        while (scr.hasNextLine()){
            String s = scr.nextLine();
            System.out.println(s);
            char me = s.charAt(2);
            char them = s.charAt(0);

            switch (them){
                case 'A':
                    switch (me) {
                        case 'Y' -> total += 1+3; // rock vs rock
                        case 'X' -> total += 0+3; //rock vs scissors
                        case 'Z' -> total += 6+2; // rock vs paper
                    }
                 break;
                case 'B':
                    switch (me) {
                        case 'Y' -> total += 3+2; // paper vs paper
                        case 'X' -> total += 0+1; // paper vs rock
                        case 'Z' -> total += 6+3; // paper vs scissors
                    }
                    break;
                case 'C':
                    switch (me) {
                        case 'Y' -> total += 3+3; //scissors vs scissors
                        case 'X' -> total += 0+2; // scissors vs paper
                        case 'Z' -> total += 6+1; // scissors vs rock
                    }
            }

        }
        System.out.println(total);

    }

    public static void day3() {
        String path = "res/day3.txt";
        File file = new File(path);

        Scanner scr;

        try {

            scr = new Scanner(file);

        } catch (FileNotFoundException e) {

            throw new RuntimeException(e);
        }
        int total = 0;
        while(scr.hasNextLine()){
            String s = scr.nextLine();
            String t = scr.nextLine();
            String u = scr.nextLine();
            String top = s.substring(0, s.length()/2);
            String bot = s.substring(s.length()/2);

            String alph = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
            for (int i = 0; i < s.length(); i++) {
                for (int j = 0; j < t.length(); j++) {
                    /* part 1 if (top.charAt(i) == bot.charAt(j)){
                        System.out.println(top.charAt(i));
                        total += alph.indexOf(top.charAt(i))+1;
                        System.out.println(total);
                        i += 20000000;
                        break; ***/
                    for (int k = 0; k < u.length(); k++) {
                        if(s.charAt(i) == t.charAt(j) && s.charAt(i) == u.charAt(k)){
                            total += alph.indexOf(s.charAt(i))+1;

                            j += 800;
                            i += 800;
                            break;
                        }
                    }

                    }
                }

            }

        System.out.println(total);
    }

    public static void day4(){
        String path = "res/day4.txt";
        File file = new File(path);

        Scanner scr;

        try {

            scr = new Scanner(file);

        } catch (FileNotFoundException e) {

            throw new RuntimeException(e);
        }

        int total = 0;
        while(scr.hasNextLine()){
            String s = scr.nextLine();
            System.out.println(s);
            String a = "";
            String b = "";
            String y = "";
            String z = "";
            int val = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != '-' && s.charAt(i) != ','){
                    if(val == 0){
                    a = a + s.charAt(i);
                    } else if(val == 1){
                        b = b + s.charAt(i);
                    }else if(val == 2){
                        y = y + s.charAt(i);
                    }else if(val == 3){
                        z = z + s.charAt(i);
                    }
                } else{
                    val++;
                }
            }


            if(Integer.parseInt(y) <= Integer.parseInt(b) && Integer.parseInt(a) <= Integer.parseInt(y)){
                total++;
                System.out.println(total);

            }

        }
        System.out.println(total);
    }

    public static void day5() {
        String path = "res/Input.txt";
        File file = new File(path);

        Scanner scr;

        try {

            scr = new Scanner(file);

        } catch (FileNotFoundException e) {

            throw new RuntimeException(e);
        }
        // initialize all stacks
        Stack[] stacks = new Stack[9];

        for (int i = 0; i < stacks.length; i++) {
            stacks[i] = new Stack<Character>();
        }
        String[] strings = new String[9];

        for (int i = 0; i < 8; i++) {
            String s = scr.nextLine();
            int o = 0;
            System.out.println(s);
            for (int j = 1; j < s.length(); j+=4) {
                if(!(s.charAt(j) == ' ' )){

                    strings[o] = strings[o] +s.charAt(j);
                    System.out.println(strings[o]);
                    o++;
                }
                if(s.charAt(j) == ' ' ){
                    o++;
                }
            }
        }
        System.out.println(Arrays.toString(strings));

        for (int i = 8; i >= 0; i--) {
            int boat = strings[i].length()-1;
            while(!(strings[i].charAt(boat) == 'l')){
                stacks[i].push(strings[i].charAt(boat));
                boat--;
            }
            System.out.println(stacks[i].peek());
        }
        // read a line of input
        System.out.println(scr.nextLine());
        System.out.println(scr.nextLine());

        while (scr.hasNextLine()){
            String s = scr.nextLine();

        }
        //perform the line of input

        // output the top of the stack
    }


    public static void main(String[] args) {
        day4();
    }
}