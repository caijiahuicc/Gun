package fileCache;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.CRC32;

/**
 * @author cc
 * @create 2024/01/06
 * @description
 */
public class MemoryMapTest {
    public static long checksumInputStream(Path pathName) throws IOException {
        try(InputStream in = Files.newInputStream(pathName)){
             CRC32 crc = new CRC32();

             int c;
            while ((c = in.read()) != -1){
                crc.update(c);
            }
            return crc.getValue();
        }
    }

    public static long checksumBufferedInputStream(Path pathName) throws IOException{
        try(BufferedInputStream in= new BufferedInputStream(Files.newInputStream(pathName))) {
            CRC32 crc = new CRC32();
            int c;
            while ((c = in.read()) != -1){
                crc.update(c);
            }
            return crc.getValue();
        }
    }

    public static long checksumMapperFile(Path pathName) throws IOException{
        try(FileChannel channel = FileChannel.open(pathName)){
           CRC32 crc =  new CRC32();
            int length = (int) channel.size();
            MappedByteBuffer buff = channel.map(FileChannel.MapMode.READ_ONLY, 0, length);
            for (int i = 0; i < length; i++) {
                int c = buff.get(i);
                crc.update(c);
            }
            return crc.getValue();
        }
    }

    public static void main(String[] args) throws IOException{
        System.out.println("Input Stream: ");
        long start = System.currentTimeMillis();
        Path fileName = Paths.get("src/base2/Test");
        long crcValue = checksumInputStream(fileName);
        long end = System.currentTimeMillis();
        System.out.println(Long.toHexString(crcValue));
        System.out.println("end - start = " + (end - start) + "  mills");

        System.out.println("Random Arcess File: ");
        start = System.currentTimeMillis();
        crcValue = checksumBufferedInputStream(fileName);
        end = System.currentTimeMillis();
        System.out.println(Long.toHexString(crcValue));
        System.out.println("end - start = " +(end - start)+ "  mills");

        System.out.println("Mapper File: ");
        start = System.currentTimeMillis();
        crcValue = checksumMapperFile(fileName);
        end = System.currentTimeMillis();
        System.out.println(Long.toHexString(crcValue));
        System.out.println("end - start: " +(end - start)+ "  mills");
    }
}
