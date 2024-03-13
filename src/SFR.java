package src;
import java.io.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
public class SFR
{
    //SmyleFileReader
    public SFR(){

    }
    public static void main(String[] args) {
        System.out.println(returnFilesInFolder("./src/showcase/").size());
    }
    public static List<String> returnFilesInFolder(String folderPath){
        return Stream.of(new File(folderPath).listFiles())
              .filter(file -> !file.isDirectory())
              .map(File::getName).collect(Collectors.toList());
    }
    public static int returnAmountInFolder(String folderPath){
        return returnFilesInFolder(folderPath).size();
    }
}