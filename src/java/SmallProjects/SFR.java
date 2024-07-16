package SmallProjects;
import java.io.*;
import java.util.*;
import java.util.stream.*;
public class SFR
{
    //SmyleFileReader
    public SFR(){

    }
    public static void main(String[] args) {
        System.out.println(returnFilesInFolder("./src/java/SmallProjects/showcase/").length);
        System.out.println(checkPath("src/java/SmallProjects/showcase"));
    }
    public static String[] returnFilesInFolder(String folderPath){
        return Stream.of(new File(folderPath).listFiles())
              .filter(file -> !file.isDirectory())
              .map(File::getName)
              .toArray(String[]::new);
    }
    public static String[] returnDirectoriesInFolder(String folderPath){
        return Stream.of(new File(folderPath).listFiles())
            .filter(File::isDirectory)
            .map(File::getName)
            .toArray(String[]::new);
    }
    public static int returnFileAmountInFolder(String folderPath){
        return returnFilesInFolder(folderPath).length;
    }
    public static int returnDirectoryAmountInFolder(String folderPath){
        return returnDirectoriesInFolder(folderPath).length;
    }
    public static int returnTotalAmountInFolder(String folderPath){
        return returnFileAmountInFolder(folderPath) + returnDirectoryAmountInFolder(folderPath);
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
            System.out.println("Failed critically during saving Todo-List");
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
                System.out.println("Error in SFR line: "+(Thread.currentThread().getStackTrace())[2].getLineNumber());
            }
            return lines.toArray(new String[0]);
        }else{
            System.out.println("Error in SFR line: "+(Thread.currentThread().getStackTrace())[2].getLineNumber());
        }
        
        return null;
    }
    public static void writeContentToTextFile(String[] c, String path){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(path))){
            for(int i = 0; i < c.length; ++i){
                writer.write(c[i]);
                writer.newLine();
            }
        }catch(IOException e){
            System.err.println("Error writing content to file: "+e.getMessage());
        }
    }
    public static String[] returnFileNamesWithoutExtensionInDirectory(String path){
        String[] name = returnFilesInFolder(path);
        for(int i = 0; i < name.length; i++){
            name[i] = name[i].split("\\.")[0];
        }
        return name;
    }
}