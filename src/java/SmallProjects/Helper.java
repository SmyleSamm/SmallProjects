package SmallProjects;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Stream;

public class Helper {
    public static class IntInputException extends Exception{
        public IntInputException(){
            super("Invalid Input!\nOnly numbers are accepted!");
        }
    }


    public static String stringInput(){
        @SuppressWarnings("resource")
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }
    public static int intInputInRange(int minNumber, int maxNumber){
        @SuppressWarnings("resource")
        Scanner scan = new Scanner(System.in);
        int ans=0;
        IntInputException inputException = new IntInputException();
        try{
            try{
                ans=scan.nextInt();
                if(ans<minNumber||ans>maxNumber)
                    throw inputException;
            }catch(Exception e){
                throw inputException;
            }
        }catch(Exception e){
            scan.nextLine();
            System.out.println("Invalid Input!\nPlease try again with a valid input.\nNumbers between "+minNumber+" and "+maxNumber);
            return intInputInRange(minNumber, maxNumber);
        }
        return ans;
    }
    public static void c() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void delay(long inMilliseconds){
        try{
            Thread.sleep(inMilliseconds);
        }catch(InterruptedException e){}
    }
    public static void defaultSlowPrint(String str){
        String[] text = str.split("");
        for(int i = 0; i < text.length; ++i){
            System.out.print(text[i]);
            Helper.delay(50);
        }
    }
    public static void slowPrint(String str, long delayInMilli){
        String[] text = str.split("");
        for(int i = 0; i < text.length; ++i){
            System.out.print(text[i]);
            Helper.delay(delayInMilli);
        }
    }
    @SafeVarargs
    @SuppressWarnings("unchecked")
    public static <T> T[] combineArrays(T[]... ar){
        return Stream.of(ar)
            .flatMap(Stream::of)
            .toArray(size -> (T[]) Array.newInstance(ar[0].getClass().getComponentType(), size));
    }
}
