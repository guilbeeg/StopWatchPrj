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

public class StopWatchGUI {

    private StopWatch s1;
    private StopWatch s2;
    private StopWatch s3;

    private Timer timer1;
    private Timer timer2;
    private Timer timer3;

    private JFrame frame;

    private JPanel mainPanel;

    private JPanel pane1;
    private JPanel pane2;
    private JPanel subPanel1;
    private JPanel pane3;
    private JPanel pane4;
    private JPanel subPanel2;
    private JPanel pane5;
    private JPanel pane6;
    private JPanel subPanel3;

    private JTextArea timeResults1;
    private JTextArea timeResults2;
    private JTextArea timeResults3;

    private JTextArea timeChange1;
    private JTextArea timeChange2;
    private JTextArea timeChange3;

    private JMenuBar menu;
    private JMenu fileMenu;
    private JMenuItem quit;

    private JMenu stopWatch1;
    private JMenuItem load1;
    private JMenuItem save1;

    private JMenu stopWatch2;
    private JMenuItem load2;
    private JMenuItem save2;

    private JMenu stopWatch3;
    private JMenuItem load3;
    private JMenuItem save3;

    private JButton start1;
    private JButton stop1;
    private JButton reset1;
    private JButton add1;
    private JButton sub1;

    private JButton start2;
    private JButton stop2;
    private JButton reset2;
    private JButton add2;
    private JButton sub2;

    private JButton start3;
    private JButton stop3;
    private JButton reset3;
    private JButton add3;
    private JButton sub3;

    private JButton suspend;

    private File file;

    public StopWatchGUI() {

        s1 = new StopWatch();
        s2 = new StopWatch();
        s3 = new StopWatch();

        file = new File("Timer1.txt");
        if (!file.exists()) {
            s1.save("Timer1.txt");
        }

        file = new File("Timer2.txt");
        if (!file.exists()) {
            s2.save("Timer2.txt");
        }

        file = new File("Timer3.txt");
        if (!file.exists()) {
            s3.save("Timer3.txt");
        }

        frame = new JFrame("Stop Watch");

        mainPanel = new JPanel();

        pane1 = new JPanel();
        pane2 = new JPanel();
        subPanel1 = new JPanel();

        pane3 = new JPanel();
        pane4 = new JPanel();
        subPanel2 = new JPanel();

        pane5 = new JPanel();
        pane6 = new JPanel();
        subPanel3 = new JPanel();

        timeResults1 = new JTextArea("0:00:000");
        timeResults2 = new JTextArea("0:00:000");
        timeResults3 = new JTextArea("0:00:000");

        timeChange1 = new JTextArea("0:00:000");
        timeChange2 = new JTextArea("0:00:000");
        timeChange3 = new JTextArea("0:00:000");

        start1 = new JButton("Start");
        stop1 = new JButton("Stop");
        reset1 = new JButton("Reset");
        add1 = new JButton("Add");
        sub1 = new JButton("Subtract");

        start2 = new JButton("Start");
        stop2 = new JButton("Stop");
        reset2 = new JButton("Reset");
        add2 = new JButton("Add");
        sub2 = new JButton("Subtract");

        start3 = new JButton("Start");
        stop3 = new JButton("Stop");
        reset3 = new JButton("Reset");
        add3 = new JButton("Add");
        sub3 = new JButton("Subtract");

        suspend = new JButton("   Suspend   ");

        menu = new JMenuBar();
        fileMenu = new JMenu("File");
        quit = new JMenuItem("Quit");

        stopWatch1 = new JMenu("Stop Watch 1");
        load1 = new JMenuItem("Load");
        save1 = new JMenuItem("Save");

        stopWatch2 = new JMenu("Stop Watch 2");
        load2 = new JMenuItem("Load");
        save2 = new JMenuItem("Save");

        stopWatch3 = new JMenu("Stop Watch 3");
        load3 = new JMenuItem("Load");
        save3 = new JMenuItem("Save");

        ButtonListener listener = new ButtonListener();

        start1.addActionListener(listener);
        stop1.addActionListener(listener);
        reset1.addActionListener(listener);
        load1.addActionListener(listener);
        save1.addActionListener(listener);
        add1.addActionListener(listener);
        sub1.addActionListener(listener);

        start2.addActionListener(listener);
        stop2.addActionListener(listener);
        reset2.addActionListener(listener);
        load2.addActionListener(listener);
        save2.addActionListener(listener);
        add2.addActionListener(listener);
        sub2.addActionListener(listener);

        start3.addActionListener(listener);
        stop3.addActionListener(listener);
        reset3.addActionListener(listener);
        load3.addActionListener(listener);
        save3.addActionListener(listener);
        add3.addActionListener(listener);
        sub3.addActionListener(listener);

        suspend.addActionListener(listener);

        quit.addActionListener(listener);

        timer1 = new Timer(1, listener);
        timer2 = new Timer(1, listener);
        timer3 = new Timer(1, listener);

        stop1.setEnabled(false);
        stop1.setFocusPainted(false);
        start1.setFocusPainted(false);
        reset1.setFocusPainted(false);
        add1.setFocusPainted(false);
        sub1.setFocusPainted(false);

        stop2.setEnabled(false);
        stop2.setFocusPainted(false);
        start2.setFocusPainted(false);
        reset2.setFocusPainted(false);
        add2.setFocusPainted(false);
        sub2.setFocusPainted(false);

        stop3.setEnabled(false);
        stop3.setFocusPainted(false);
        start3.setFocusPainted(false);
        reset3.setFocusPainted(false);
        add3.setFocusPainted(false);
        sub3.setFocusPainted(false);

        suspend.setFocusPainted(true);

        start1.setMaximumSize(new Dimension(100, 25));
        stop1.setMaximumSize(new Dimension(100, 25));
        reset1.setMaximumSize(new Dimension(100, 25));
        add1.setMaximumSize(new Dimension(100, 25));
        sub1.setMaximumSize(new Dimension(100, 25));

        start2.setMaximumSize(new Dimension(100, 25));
        stop2.setMaximumSize(new Dimension(100, 25));
        reset2.setMaximumSize(new Dimension(100, 25));
        add2.setMaximumSize(new Dimension(100, 25));
        sub2.setMaximumSize(new Dimension(100, 25));

        start3.setMaximumSize(new Dimension(100, 25));
        stop3.setMaximumSize(new Dimension(100, 25));
        reset3.setMaximumSize(new Dimension(100, 25));
        add3.setMaximumSize(new Dimension(100, 25));
        sub3.setMaximumSize(new Dimension(100, 25));

        suspend.setMaximumSize(new Dimension(150, 50));

        timeResults1.setFont(new Font("Arial", Font.BOLD, 20));
        timeResults1.setForeground(Color.red);
        timeResults1.setBackground(null);
        timeResults1.setEditable(false);

        timeResults2.setFont(new Font("Arial", Font.BOLD, 20));
        timeResults2.setForeground(Color.red);
        timeResults2.setBackground(null);
        timeResults2.setEditable(false);

        timeResults3.setFont(new Font("Arial", Font.BOLD, 20));
        timeResults3.setForeground(Color.red);
        timeResults3.setBackground(null);
        timeResults3.setEditable(false);

        timeChange1.setFont(new Font("Arial", Font.ITALIC, 20));
        timeChange1.setBackground(Color.WHITE);
        timeChange1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        timeChange1.setEditable(true);

        timeChange2.setFont(new Font("Arial", Font.ITALIC, 20));
        timeChange2.setBackground(Color.WHITE);
        timeChange2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        timeChange2.setEditable(true);

        timeChange3.setFont(new Font("Arial", Font.ITALIC, 20));
        timeChange3.setBackground(Color.WHITE);
        timeChange3.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        timeChange3.setEditable(true);

        pane1.setLayout(new BoxLayout(pane1, BoxLayout.PAGE_AXIS));
        pane2.setLayout(new BoxLayout(pane2, BoxLayout.PAGE_AXIS));
        subPanel1.setBorder(BorderFactory.createTitledBorder("Stop Watch 1"));

        pane3.setLayout(new BoxLayout(pane3, BoxLayout.PAGE_AXIS));
        pane4.setLayout(new BoxLayout(pane4, BoxLayout.PAGE_AXIS));
        subPanel2.setBorder(BorderFactory.createTitledBorder("Stop Watch 2"));

        pane5.setLayout(new BoxLayout(pane5, BoxLayout.PAGE_AXIS));
        pane6.setLayout(new BoxLayout(pane6, BoxLayout.PAGE_AXIS));
        subPanel3.setBorder(BorderFactory.createTitledBorder("Stop watch 3"));

        suspend.setLayout((new BoxLayout(suspend, BoxLayout.PAGE_AXIS)));

        stopWatch1.add(load1);
        stopWatch1.add(save1);

        stopWatch2.add(load2);
        stopWatch2.add(save2);

        stopWatch3.add(load3);
        stopWatch3.add(save3);

        fileMenu.add(quit);

        menu.add(fileMenu);
        menu.add(stopWatch1);
        menu.add(stopWatch2);
        menu.add(stopWatch3);

        pane1.add(start1);
        pane1.add(Box.createVerticalStrut(10));
        pane1.add(stop1);
        pane1.add(Box.createVerticalStrut(10));
        pane1.add(reset1);
        pane1.add(Box.createVerticalStrut(10));
        pane1.add(add1);
        pane1.add(Box.createVerticalStrut(10));
        pane1.add(sub1);


        pane2.add(timeResults1);
        pane2.add(Box.createVerticalStrut(50));
        pane2.add(timeChange1);

        subPanel1.add(Box.createHorizontalStrut(25));
        subPanel1.add(pane1);
        subPanel1.add(Box.createHorizontalStrut(25));
        subPanel1.add(pane2);
        subPanel1.add(Box.createHorizontalStrut(25));

        pane3.add(start2);
        pane3.add(Box.createVerticalStrut(10));
        pane3.add(stop2);
        pane3.add(Box.createVerticalStrut(10));
        pane3.add(reset2);
        pane3.add(Box.createVerticalStrut(10));
        pane3.add(add2);
        pane3.add(Box.createVerticalStrut(10));
        pane3.add(sub2);

        pane4.add(timeResults2);
        pane4.add(Box.createVerticalStrut(50));
        pane4.add(timeChange2);

        subPanel2.add(Box.createHorizontalStrut(25));
        subPanel2.add(pane3);
        subPanel2.add(Box.createHorizontalStrut(25));
        subPanel2.add(pane4);
        subPanel2.add(Box.createHorizontalStrut(25));

        pane5.add(start3);
        pane5.add(Box.createVerticalStrut(10));
        pane5.add(stop3);
        pane5.add(Box.createVerticalStrut(10));
        pane5.add(reset3);
        pane5.add(Box.createVerticalStrut(10));
        pane5.add(add3);
        pane5.add(Box.createVerticalStrut(10));
        pane5.add(sub3);

        pane6.add(timeResults3);
        pane6.add(Box.createVerticalStrut(50));
        pane6.add(timeChange3);

        subPanel3.add(Box.createHorizontalStrut(25));
        subPanel3.add(pane5);
        subPanel3.add(Box.createHorizontalStrut(25));
        subPanel3.add(pane6);
        subPanel3.add(Box.createHorizontalStrut(25));

        mainPanel.add(subPanel1);
        mainPanel.add(subPanel2);
        mainPanel.add(subPanel3);
        mainPanel.add(Box.createVerticalStrut(10));
        mainPanel.add(suspend);

        frame.add(mainPanel);


        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setJMenuBar(menu);
        frame.pack();
        frame.setVisible(true);

    }

    public class ButtonListener implements ActionListener {
        public String FileSaver() {
            JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

            int returnValue = jfc.showSaveDialog(null);
            // int returnValue = jfc.showSaveDialog(null);
            String fileName = "";

            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File selectedFile = jfc.getSelectedFile();
                fileName =(selectedFile.getAbsolutePath());
            }
            return fileName;
        }
        public String FileLoader() {
            JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

            int returnValue = jfc.showOpenDialog(null);
            // int returnValue = jfc.showSaveDialog(null);
            String fileName = "";

            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File selectedFile = jfc.getSelectedFile();
                fileName =(selectedFile.getAbsolutePath());
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
                if (!StopWatch.isSuspend()) {
                    timer1.stop();
                    stop1.setEnabled(false);
                    start1.setEnabled(true);
                    s1 = new StopWatch();
                    timeResults1.setText(s1.toString());
                } else throw new IllegalArgumentException();
            }
            if (e.getSource() == start2) {
                timer2.start();
                stop2.setEnabled(true);
                start2.setEnabled(false);
            }
            if (e.getSource() == stop2) {
                timer2.stop();
                stop2.setEnabled(false);
                start2.setEnabled(true);
                timeResults2.setText(s2.toString());
            }
            if (e.getSource() == reset2) {
                if(!StopWatch.isSuspend()) {
                    timer2.stop();
                    stop2.setEnabled(false);
                    start2.setEnabled(true);
                    s2 = new StopWatch();
                    timeResults2.setText(s2.toString());
                } else
                    throw new IllegalArgumentException();
            }
            if (e.getSource() == start3) {
                timer3.start();
                stop3.setEnabled(true);
                start3.setEnabled(false);
            }
            if (e.getSource() == stop3) {
                timer3.stop();
                stop3.setEnabled(false);
                start3.setEnabled(true);
                timeResults3.setText(s3.toString());
            }
            if (e.getSource() == reset3) {
                if(!StopWatch.isSuspend()) {
                    timer3.stop();
                    stop3.setEnabled(false);
                    start3.setEnabled(true);
                    s3 = new StopWatch();
                    timeResults3.setText(s3.toString());
                } else
                    throw new IllegalArgumentException();

            }
            if (e.getSource() == timer1) {
                s1.inc();
                timeResults1.setText(s1.toString());
            }
            if (e.getSource() == timer2) {
                s2.inc();
                timeResults2.setText(s2.toString());
            }
            if (e.getSource() == timer3) {
                s3.inc();
                timeResults3.setText(s3.toString());
            }
            if (e.getSource() == quit) {
                System.exit(1);
            }
            if (e.getSource() == suspend) {
                if (StopWatch.isSuspend() == true) {
                    StopWatch.setSuspend(false);
                    suspend.setText("   Suspend   ");
                }
                else {
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
            if (e.getSource() == add2) {
                if(!StopWatch.isSuspend()) {
                    try {
                        StopWatch s4 = new StopWatch(timeChange2.getText());
                        s2.add(s4);
                        timeResults2.setText(s2.toString());
                    } catch (IllegalArgumentException i) {
                        JOptionPane.showMessageDialog(null, "Please Enter A Correct Time Value", "INPUT ERROR", JOptionPane.WARNING_MESSAGE);
                    }
                }else
                    throw new IllegalArgumentException();
            }
            if (e.getSource() == add3) {
                if(!StopWatch.isSuspend()) {
                    try {
                        StopWatch s4 = new StopWatch(timeChange3.getText());
                        s3.add(s4);
                        timeResults3.setText(s3.toString());
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
            if (e.getSource() == sub2) {
                if(!StopWatch.isSuspend()) {
                    try {
                        StopWatch s4 = new StopWatch(timeChange2.getText());
                        s2.sub(s4);
                        timeResults2.setText(s2.toString());
                    } catch (IllegalArgumentException i) {
                        JOptionPane.showMessageDialog(null, "Please Enter A Correct Time Value", "INPUT ERROR", JOptionPane.WARNING_MESSAGE);
                    }
                }
                else
                    throw new IllegalArgumentException();
            }
            if (e.getSource() == sub3) {
                if(!StopWatch.isSuspend()) {
                    try {
                        StopWatch s4 = new StopWatch(timeChange3.getText());
                        s3.sub(s4);
                        timeResults3.setText(s3.toString());
                    } catch (IllegalArgumentException i) {
                        JOptionPane.showMessageDialog(null, "Please Enter A Correct Time Value", "INPUT ERROR", JOptionPane.WARNING_MESSAGE);
                    }
                }
                else
                    throw new IllegalArgumentException();
            }
            if (e.getSource() == save1){
                s1.save(FileSaver());
            }
            if (e.getSource() == save2){
                s2.save(FileSaver());
            }
            if (e.getSource() == save3){
                s3.save(FileSaver());
            }
            if (e.getSource() == load1){
                if(!StopWatch.isSuspend()) {
                    s1.load(FileLoader());
                    timeResults1.setText(s1.toString()); }
                else
                    throw new IllegalArgumentException();
            }
            if (e.getSource() == load2){
                if(!StopWatch.isSuspend()) {
                    s2.load(FileLoader());
                    timeResults2.setText(s2.toString()); }
                else
                    throw new IllegalArgumentException();
            }
            if (e.getSource() == load3){
                if(!StopWatch.isSuspend()) {
                    s3.load(FileLoader());
                    timeResults3.setText(s3.toString()); }
                else
                    throw new IllegalArgumentException();
            }
        }
    }

    public static void main(String[] args) {
        @SuppressWarnings("unused") StopWatchGUI p = new StopWatchGUI();

    }

}