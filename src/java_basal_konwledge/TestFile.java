package java_basal_konwledge;

import java.io.File;
import java.io.FileFilter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TestFile
{
    // 这个是用来测试 File 的用法，在Java中操作文件和目录用的都是File这个类
    public static void main(String[] args)
    {
        File f = new File("g:/DzhFiles/hehhe"); // 这一步并不是创建了一个文件对象，而是创建了一个工具对象，它可以操作文件，我并没有造一台电视机，我造的是遥控器
        File s = new File(f,"some.txt"); // 指定父目录，在hehhe中，创建some.txt
        s.mkdirs();
        File j  = new File("G:\\DzhFiles\\BaiduSDK");
        FileFilter fileFilter = new FileFilter() // FileFilter 是一个接口，以匿名内部类的方式重写完方法之后，要把其引用放如listFiles()中作为参数
        {
            @Override
            public boolean accept(File pathname)
            {
                String filePath = pathname.getAbsolutePath();
                return filePath.endsWith(".zip");
            }
        };
        File[] files = j.listFiles(fileFilter); // listFiles() 可以扫描当前目录中的所有文件和目录，只能是当前级
        for(File k : files)
        {
            if(k.isDirectory())
            {
                System.out.println(k + "是目录");
            }
            else
            {
                System.out.println(k + "是文件");
            }
        }
        // File 既可以操作文件也可以操作目录
        // 一个汉字好像是占三个字节
//        f.delete();
//        if(f.exists())
//        {
//            System.out.println("文件存在: " + f);
//            System.out.println(f.length());
//        }
//
//        long lastModified = f.lastModified(); // 其返回的是一个毫秒值，这个是一个整数
//        System.out.println("毫秒值" + lastModified);
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd  HH:mm:ss"); // 这个 new 出来的是一个时间格式
//        String date = simpleDateFormat.format(new Date(lastModified));  // 把时间放进时间格式里，new出来的时间需要放进一个整数值
//        System.out.println("修改时间为：" + date);
//        f.renameTo(new File("g:/DzhFiles/abc.txt")); // 得先new出来一个File，然后再把名字放进去
//        f.delete();


    }
}
