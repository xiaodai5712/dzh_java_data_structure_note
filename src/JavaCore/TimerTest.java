package JavaCore;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class TimerTest
{
    public static void main(String[] args)
    {
        ActionListener listener = new TimerPrinter();
        Timer t = new Timer(3000,listener);
        t.start();
        JOptionPane.showMessageDialog(null,"quit program");
        System.out.println("exit");
    }
    static class TimerPrinter implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            System.out.println("the time is :" + new Date());
            Toolkit.getDefaultToolkit().beep();
        }
    }
}
