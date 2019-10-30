package com.example.shop_e;

        import android.content.Context;

        import java.io.BufferedReader;
        import java.io.File;
        import java.io.FileOutputStream;
        import java.io.FileReader;

public class IOManager {
    static void readIntoBuffer(StringBuffer stringBuffer, File file) {
        try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = reader.readLine();
            while(line != null) {
                stringBuffer.append(line).append('\n');
                line = reader.readLine();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    static void writeFromBuffer(StringBuffer stringBuffer, String fileName,Context context) {
        try{
            FileOutputStream outputStream = context.openFileOutput(fileName, Context.MODE_PRIVATE);
            outputStream.write(stringBuffer.toString().getBytes());
            outputStream.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}
