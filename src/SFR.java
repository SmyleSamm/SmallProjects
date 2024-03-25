package src;
import java.io.*;
import java.util.*;
import java.util.stream.*;
public class SFR
{
    //SmyleFileReader
    public SFR(){

    }
    public static void main(String[] args) {
        System.out.println(returnFilesInFolder("./src/showcase/").size());
        System.out.println(checkPath("src/showcase"));
    }
    public static List<String> returnFilesInFolder(String folderPath){
        return Stream.of(new File(folderPath).listFiles())
              .filter(file -> !file.isDirectory())
              .map(File::getName).collect(Collectors.toList());
    }
    public static int returnAmountInFolder(String folderPath){
        return returnFilesInFolder(folderPath).size();
    }
    public static boolean checkPath(String path){
        File f = new File(path);
        return f.exists();
    }
    public static void createFolder(String path){
        new File(path).mkdirs();
    }
    public static void createFile(String name, String path){
        try{
            new File(path+"/"+name+".txt").createNewFile();
        }catch(Exception e){

        }
    }
    public static String[] returnContentFromTextFile(String path){
        List<String> lines = new ArrayList<>();
        File f = new File(path);
        if(f.exists()&&f.canRead()){
            try(BufferedReader reader = new BufferedReader(new FileReader(path))){
                String line;
                while((line = reader.readLine())!=null){
                    lines.add(line);
                }
            }catch(IOException e){
                System.err.println("Failed to load save!");
            }
            return lines.toArray(new String[0]);
        }else{
            System.out.println("Error in SFR line: "+(Thread.currentThread().getStackTrace())[2].getLineNumber());
        }
        
        return null;
    }
}