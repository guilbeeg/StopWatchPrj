package Project1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.*;
import javax.swing.filechooser.FileSystemView;

/************************************************************************
 * CIS 163 Project 1- StopWatch
 * @author Nate Tubergen, Gabe Guilbee
 * Due: 5/23/18
 ************************************************************************/

public class MyTimerPanel {

    private StopWatch s1;
    private Timer timer1;

    private JFrame frame;

    private JPanel mainPanel;

    private JPanel pane1;
    private JPanel pane2;
    private JPanel subPanel1;

    private JTextArea timeResults1;

    private JTextArea timeChange1;

    private JMenuBar menu;
    private JMenu fileMenu;
    private JMenuItem quit;

    private JButton start1;
    private JButton stop1;
    private JButton reset1;
    private JButton add1;
    private JButton sub1;
    private JButton load1;
    private JButton save1;

    private JButton suspend;

    private File file;

    public MyTimerPanel(String StopWatchNum) {

        s1 = new StopWatch();

        file = new File("Timer1.txt");
        if (!file.exists()) {
            s1.save("Timer1.txt");
        }

        frame = new JFrame("Stop Watch");

        mainPanel = new JPanel();

        pane1 = new JPanel();
        pane2 = new JPanel();
        subPanel1 = new JPanel();

        timeResults1 = new JTextArea("0:00:000");

        timeChange1 = new JTextArea("0:00:000");

        start1 = new JButton("Start");
        stop1 = new JButton("Stop");
        reset1 = new JButton("Reset");
        add1 = new JButton("Add");
        sub1 = new JButton("Subtract");
        load1 = new JButton("Load");
        save1 = new JButton("Save");

        suspend = new JButton("   Suspend   ");

        menu = new JMenuBar();
        fileMenu = new JMenu("File");
        quit = new JMenuItem("Quit");

        ButtonListener listener = new ButtonListener();

        start1.addActionListener(listener);
        stop1.addActionListener(listener);
        reset1.addActionListener(listener);
        load1.addActionListener(listener);
        save1.addActionListener(listener);
        add1.addActionListener(listener);
        sub1.addActionListener(listener);

        suspend.addActionListener(listener);

        quit.addActionListener(listener);

        timer1 = new Timer(100, listener);

        stop1.setEnabled(false);
        stop1.setFocusPainted(false);
        start1.setFocusPainted(false);
        reset1.setFocusPainted(false);
        add1.setFocusPainted(false);
        sub1.setFocusPainted(false);
        save1.setFocusPainted(false);
        load1.setFocusPainted(false);

        suspend.setFocusPainted(true);

        start1.setMaximumSize(new Dimension(100, 25));
        stop1.setMaximumSize(new Dimension(100, 25));
        reset1.setMaximumSize(new Dimension(100, 25));
        add1.setMaximumSize(new Dimension(100, 25));
        sub1.setMaximumSize(new Dimension(100, 25));
        save1.setMaximumSize(new Dimension(100, 25));
        load1.setMaximumSize(new Dimension(100, 25));

        suspend.setMaximumSize(new Dimension(150, 50));

        timeResults1.setFont(new Font("Arial", Font.BOLD, 20));
        timeResults1.setForeground(Color.red);
        timeResults1.setBackground(null);
        timeResults1.setEditable(false);

        timeChange1.setFont(new Font("Arial", Font.ITALIC, 20));
        timeChange1.setBackground(Color.WHITE);
        timeChange1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        timeChange1.setEditable(true);

        pane1.setLayout(new BoxLayout(pane1, BoxLayout.PAGE_AXIS));
        pane2.setLayout(new BoxLayout(pane2, BoxLayout.PAGE_AXIS));
        subPanel1.setBorder(BorderFactory.createTitledBorder("Stop Watch " + StopWatchNum));

        suspend.setLayout((new BoxLayout(suspend, BoxLayout.PAGE_AXIS)));

        fileMenu.add(quit);

        menu.add(fileMenu);

        pane1.add(start1);
        pane1.add(Box.createVerticalStrut(10));
        pane1.add(stop1);
        pane1.add(Box.createVerticalStrut(10));
        pane1.add(reset1);
        pane1.add(Box.createVerticalStrut(10));
        pane1.add(add1);
        pane1.add(Box.createVerticalStrut(10));
        pane1.add(sub1);
        pane1.add(Box.createVerticalStrut(10));
        pane1.add(load1);
        pane1.add(Box.createVerticalStrut(10));
        pane1.add(save1);

        pane2.add(timeResults1);
        pane2.add(Box.createVerticalStrut(50));
        pane2.add(timeChange1);

        subPanel1.add(Box.createHorizontalStrut(25));
        subPanel1.add(pane1);
        subPanel1.add(Box.createHorizontalStrut(25));
        subPanel1.add(pane2);
        subPanel1.add(Box.createHorizontalStrut(25));

        mainPanel.add(subPanel1);
        mainPanel.add(Box.createVerticalStrut(10));
     //    mainPanel.add(suspend);

     /*   frame.add(mainPanel);

        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setJMenuBar(menu);
        frame.pack();
        frame.setVisible(true);*/
    }

    public class ButtonListener implements ActionListener {

        public String FileSaver() {

            JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

            int returnValue = jfc.showSaveDialog(null);
            // int returnValue = jfc.showSaveDialog(null);
            String fileName = "";

            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File selectedFile = jfc.getSelectedFile();
                fileName = (selectedFile.getAbsolutePath());
            }
            return fileName;
        }

        public String FileLoader() {
            JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

            int returnValue = jfc.showOpenDialog(null);
            String fileName = "";

            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File selectedFile = jfc.getSelectedFile();
                fileName = (selectedFile.getAbsolutePath());
            }
            return fileName;
        }

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == start1) {
                timer1.start();
                stop1.setEnabled(true);
                start1.setEnabled(false);
            }
            if (e.getSource() == stop1) {
                timer1.stop();
                stop1.setEnabled(false);
                start1.setEnabled(true);
                timeResults1.setText(s1.toString());
            }
            if (e.getSource() == reset1) {
                if(!StopWatch.isSuspend()) {
                    timer1.stop();
                    stop1.setEnabled(false);
                    start1.setEnabled(true);
                    s1 = new StopWatch();
                    timeResults1.setText(s1.toString());
                } else
                    throw new IllegalArgumentException();

            }
            if (e.getSource() == timer1) {
                s1.add(100);
                timeResults1.setText(s1.toString());
            }
            if (e.getSource() == quit) {
                System.exit(1);
            }
            if (e.getSource() == suspend) {
                if (StopWatch.isSuspend() == true) {
                    StopWatch.setSuspend(false);
                    suspend.setText("   Suspend   ");
                } else {
                    StopWatch.setSuspend(true);
                    suspend.setText("   Resume   ");
                }
            }
            if (e.getSource() == add1) {
                if(!StopWatch.isSuspend()) {
                    try {
                        StopWatch s4 = new StopWatch(timeChange1.getText());
                        //timeChange1.getText()
                        s1.add(s4);
                        timeResults1.setText(s1.toString());
                    } catch (IllegalArgumentException i) {
                        JOptionPane.showMessageDialog(null, "Please Enter A Correct Time Value", "INPUT ERROR", JOptionPane.WARNING_MESSAGE);
                    }
                }else
                    throw new IllegalArgumentException();
            }
            if (e.getSource() == sub1) {
                if(!StopWatch.isSuspend()) {
                    try {
                    StopWatch s4 = new StopWatch(timeChange1.getText());
                    s1.sub(s4);
                    timeResults1.setText(s1.toString());
                } catch (IllegalArgumentException i) {
                    JOptionPane.showMessageDialog(null, "Please Enter A Correct Time Value", "INPUT ERROR", JOptionPane.WARNING_MESSAGE);
                }
                }
                else
                    throw new IllegalArgumentException();
            }

            if (e.getSource() == save1) {
                s1.save(FileSaver());
            }
            if (e.getSource() == load1) {
                if(!StopWatch.isSuspend()) {
                    s1.load(FileLoader());
                timeResults1.setText(s1.toString()); }
                else
                    throw new IllegalArgumentException();
            }
        }
    }
    public void panel3(){

        JPanel trio = new JPanel();

        MyTimerPanel m1 = new MyTimerPanel("1");
        MyTimerPanel m2 = new MyTimerPanel("2");
        MyTimerPanel m3 = new MyTimerPanel("3");

        trio.add(m1.mainPanel);
        trio.add(m2.mainPanel);
        trio.add(m3.mainPanel);
        trio.add(suspend);

        frame.add(trio);

        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setJMenuBar(menu);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {


            MyTimerPanel m = new MyTimerPanel("Stop Watch");
            m.panel3();

    }

}






