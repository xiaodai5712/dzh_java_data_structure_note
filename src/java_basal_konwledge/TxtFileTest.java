package java_basal_konwledge;


import java.io.*;
import java.util.Calendar;
import java.util.Comparator;
import java.util.LinkedList;

public class TxtFileTest
{
    private LinkedList<Integer>[] adj; // 邻接表

    public static void main(String[] args) throws IOException
    {
        File f = new File("g:/examples");
        f.mkdirs();
        File s = new File(f,"student.stu");

        Student student = new Student("xiaoLi","1839","2773519");
        String stu = String.format("%s,%s,%s",student.name,student.id,student.phone);

        byte[] data = stu.getBytes("GBK");
        String txt = "你好啊，哈哈哈！";
        byte[] txtData = txt.getBytes("GBK");

        // 将整数写入文件
        try
        {
            FileOutputStream fileOutputStream  = new FileOutputStream(s);
            fileOutputStream.write(data);
            fileOutputStream.close();

        } catch (Exception e)
        {
            e.printStackTrace();
        }

        // 读取文件
        byte[] data1 = new byte[100];
        try
        {
            FileInputStream fileInputStream = new FileInputStream(s);
            int n = fileInputStream.read(data1); // 返回的是读取到的字节个数
            String txt1 = new String(data1,"GBK");
            String[] ss = txt1.split(","); // 使用 " , ",把原来的字符串分割成数组
            Student student1 = new Student();
            student1.name = ss[0];
            student1.id  = ss[1];
            student1.phone = ss[2];
            System.out.println("读出" + n + "个字节");
            System.out.println(student1);

            fileInputStream.close();
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        System.out.println("exit");


    }
    public static class Student implements Comparator<Student>
    {
        public String name;
        public String id;
        public String phone;
        public Student(String name,String id,String phone)
        {
            this.id = id;
            this.name = name;
            this.phone = phone;
        }
        public Student()
        {

        }

        @Override
        public String toString()
        {
            return String.format("%s,%s,%s",this.name,this.id,this.phone);
        }


        @Override
        public int compare(Student o1, Student o2)
        {
            return 0;
        }
    }
}
