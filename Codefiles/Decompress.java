package Codefiles;

import java.io.*;
import java.util.zip.GZIPInputStream;

public class Decompress {
    public static void decompressFunction(File file) throws IOException {
    String fileDirectory=file.getParent();
       // System.out.println(fileDirectory);
        FileInputStream fis = new FileInputStream(file);
        FileOutputStream fos = new FileOutputStream(fileDirectory+"/decompressedFile.txt");
        GZIPInputStream gzipIS = new GZIPInputStream(fis);
        byte[] buffer = new byte[1024];
        int len;
        while((len=gzipIS.read(buffer))!=-1){
            fos.write(buffer,0,len);
        }
        gzipIS.close();
        fis.close();
        fos.close();
    }
public static  void main(String [] args) throws IOException {
    File path=new File("C:\\Java Projects\\CompressorDecompressor\\CompressorDecompressor\\src\\Codefiles\\CompressedFile.gz");
    decompressFunction(path);
}
}
