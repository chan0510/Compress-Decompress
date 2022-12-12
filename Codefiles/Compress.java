package Codefiles;

import java.io.*;
import java.util.zip.GZIPOutputStream;

public class Compress {
    public static void compressFunction(File file) throws FileNotFoundException, IOException {
        String fileDirectory = file.getParent();
        //System.out.println(fileDirectory);
        FileInputStream fis = new FileInputStream(file);
        FileOutputStream fos = new FileOutputStream(fileDirectory+"/CompressedFile.gz");
        GZIPOutputStream gzipOS = new GZIPOutputStream(fos);
        byte[] buffer = new byte[1024];
        int len;
        while((len= fis.read(buffer))!=-1){
            gzipOS.write(buffer,0,len);
        }
        gzipOS.close();
        fos.close();
        fis.close();
    }
    public static void main(String[] args) throws  IOException{
        File path = new File("C:\\Java Projects\\CompressorDecompressor\\CompressorDecompressor\\src\\Codefiles\\TextFile.txt");

        compressFunction( path);
    }
}
