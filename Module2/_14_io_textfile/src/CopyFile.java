import java.io.*;

public class CopyFile {
    public static void copyFile(String sourcePath, String targetPath){
        File sourceFile = new File(sourcePath);
        File targetFile = new File(targetPath);
        FileReader fileReader = null;
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        BufferedReader bufferedReader = null;

        try {
            fileReader = new FileReader(sourceFile);
            bufferedReader = new BufferedReader(fileReader);
            fileWriter = new FileWriter(targetFile);
            bufferedWriter = new BufferedWriter(fileWriter);
            String line = null;
            while ((line = bufferedReader.readLine()) != null){
                bufferedWriter.append(line);
                bufferedWriter.append("\n");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
                bufferedWriter.flush();
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        final String SOURCE_PATH = "D:/CodeGym/A0720I1-PhamQuocDon/Module2/_14_io_textfile/src/SourceFile";
        final String TARGET_PATH = "D:/CodeGym/A0720I1-PhamQuocDon/Module2/_14_io_textfile/src/TargetFile";

        copyFile(SOURCE_PATH, TARGET_PATH);
    }
}
