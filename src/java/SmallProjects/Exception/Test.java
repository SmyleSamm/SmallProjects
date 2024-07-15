package SmallProjects.Exception;

import SmallProjects.SFR;

public class Test{
    public static void main(String[] args) {
        String showcasePath = "./src/java/SmallProjects/showcase";
        for (String string : SFR.returnFilesInFolder(showcasePath)) {
            System.out.println(string);
        }
        System.out.println(SFR.returnFileAmountInFolder(showcasePath));
        for(String string : SFR.returnDirectoriesInFolder(showcasePath)){
            System.out.println(string);
        }
        System.out.println(SFR.returnDirectoryAmountInFolder(showcasePath));
        System.out.println(SFR.returnTotalAmountInFolder(showcasePath));
    }
}
