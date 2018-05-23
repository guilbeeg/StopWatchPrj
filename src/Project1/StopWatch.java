package Project1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/************************************************************************
 CIS 162 Project 1- StopWatch
 @author Nate Tubergen, Gabe Guilbee
 Due: 5/23/18
 ************************************************************************/
public class StopWatch {

    /** This variable holds minutes for our stopwatch */
    private int minutes;

    /** This variable holds seconds for our stopwatch */
    private int seconds;

    /** This variable holds milliseconds for our stopwatch */
    private int milliseconds;

    /** This variable suspends or allows our stopwatch functions */
    private static boolean suspend = false;


    /******************************************************************
     Getter method for Minutes
     Returns Minutes value
     ******************************************************************/
    public int getMinutes() {

        return minutes;
    }

    /******************************************************************
     Setter method for Minutes
     @param minutes number of minutes
     ******************************************************************/
    public void setMinutes(int minutes) {

        this.minutes = minutes;
    }

    /***************************************************************
     Getter method for Seconds
     @return seconds
     ***************************************************************/
    public int getSeconds() {

        return seconds;
    }

    /***************************************************************
     Setter method for Seconds
     @param seconds number of seconds
     ***************************************************************/
    public void setSeconds(int seconds) {
        if (!suspend) {
            this.seconds = seconds;
        }
    }

    /***************************************************************
     Getter method for Milliseconds
     @return milliseconds
     ***************************************************************/
    public int getMilliseconds() {

        return milliseconds;
    }

    /***************************************************************
     Setter method for Milliseconds
     @param milliseconds number of milliseconds
     ***************************************************************/
    public void setMilliseconds(int milliseconds) {
        if (!suspend) {
            this.milliseconds = milliseconds;
        }
    }

    /******************************************************************
     Default constructor sets minutes, seconds, and milliseconds to 0
     ******************************************************************/
    public StopWatch() {
        minutes = 00;
        seconds = 00;
        milliseconds = 000;
    }

    /******************************************************************
     Constructor creates Stop Watch based on given minutes, seconds, and milliseconds
     @param minutes number of minutes.
     @param seconds number of seconds.
     @param milliseconds number of milliseconds.
     ******************************************************************/
    public StopWatch(int minutes, int seconds, int milliseconds) {
        if (minutes == 0 && seconds == 0 && milliseconds == 0) {
            this.minutes = 0;
            this.seconds = 00;
            this.milliseconds = 000;
        } else if (minutes > 0 && seconds == 0 && milliseconds == 0) {
            this.minutes = minutes;
            this.seconds = 00;
            this.milliseconds = 000;
        } else if (minutes > 0 && seconds > 0 && milliseconds == 0) {
            this.minutes = minutes;
            this.seconds = seconds;
            this.milliseconds = 000;
        } else if (minutes == 0 && seconds == 0 && milliseconds > 0) {
            this.minutes = 0;
            this.seconds = 00;
            this.milliseconds = milliseconds;
        }  else if (minutes == 0 && seconds > 0 && milliseconds == 0) {
            this.minutes = 0;
            this.seconds = seconds;
            this.milliseconds = 000;
        }else if (minutes > 0 && seconds > 0 && milliseconds > 0 && seconds < 60 && milliseconds < 1000) {
            this.minutes = minutes;
            this.seconds = seconds;
            this.milliseconds = milliseconds;
        } else throw new IllegalArgumentException();

    }

    /******************************************************************
     Constructor creates Stop Watch based on given seconds and milliseconds.
     @param seconds number of seconds.
     @param milliseconds number of milliseconds.
     ******************************************************************/
    public StopWatch( int seconds, int milliseconds) {
        if (seconds>=0 && milliseconds>=0 && seconds<60 && milliseconds<1000) {
            this.minutes = 0;
            this.seconds = seconds;
            this.milliseconds = milliseconds;
        }
        else {
            throw  new IllegalArgumentException();
        }
    }

    /******************************************************************
     Constructor creates Stop Watch based on given milliseconds.
     @param milliseconds number of milliseconds.
     ******************************************************************/
    public StopWatch(int milliseconds) {
        if (milliseconds>=0 && milliseconds<1000) {
            this.minutes = 0;
            this.seconds = 0;
            this.milliseconds = milliseconds;
        }
        else {
            throw  new IllegalArgumentException();
        }
    }

    /******************************************************************
     Constructor creates Stop Watch based on given user input.
     @param startTimeIn, user input in "0:00:000" format.
     ******************************************************************/
    public StopWatch(String startTimeIn) {

       //  Nate's Version
 /*       String[] values=startTime.split(":");
        if (values.length>2) {
            if (Integer.parseInt(values[0])>=0 && Integer.parseInt(values[1])>0 && Integer.parseInt(values[2])>=0 && Integer.parseInt(values[1])<60 && Integer.parseInt(values[2])<1000) {
                this.minutes = Integer.parseInt(values[0]);
                this.seconds = Integer.parseInt(values[1]);
                this.milliseconds = Integer.parseInt(values[2]);
            }
            else {
                throw  new IllegalArgumentException();
            }
        }
        else if (values.length>1) {
            if (Integer.parseInt(values[0])>0 && Integer.parseInt(values[1])>=0 && Integer.parseInt(values[0])<60 && Integer.parseInt(values[1])<1000) {
                this.seconds = Integer.parseInt(values[0]);
                this.milliseconds = Integer.parseInt(values[1]);
            }
            else {
                throw  new IllegalArgumentException();
            }
        }
        else {
            if (Integer.parseInt(values[0])>=0 && Integer.parseInt(values[0])<1000) {
                this.milliseconds = Integer.parseInt(values[0]);
            }
            else {
                throw  new IllegalArgumentException();
            }
        }*/

// Gabe's Version

        String startTime[] = startTimeIn.split(":");
        int timeValue[] = new int[startTime.length];

        if (!startTime[0].isEmpty()) {
            for (int i = 0; i < startTime.length; i++) {
                timeValue[i] = Integer.parseInt(startTime[i].trim());
            }
        }

        if (startTime[0].isEmpty()) {
            minutes = 0;
            seconds = 0;
            milliseconds = 0;
        } else if (startTime.length == 3) {
            validate(timeValue[0], timeValue[1], timeValue[2]);
            minutes = timeValue[0];
            seconds = timeValue[1];
            milliseconds = timeValue[2];
        } else if (startTime.length == 2) {
            validate(0, timeValue[0], timeValue[1]);
            minutes = 0;
            seconds = timeValue[0];
            milliseconds = timeValue[1];
        } else {
            validate(0, 0, timeValue[0]);
            minutes = 0;
            seconds = 0;
            milliseconds = timeValue[0];
        }

        formatTime();
    }

    /******************************************************************
     Formats time by converting milliseconds to seconds and seconds to minutes.
     ***************************************************************/
    private void formatTime() {

        while (milliseconds >= 1000) {
            milliseconds -= 1000;
            seconds++;
        }

        while (seconds >= 60) {
            seconds -= 60;
            minutes++;
        }

    }

    /***************************************************************
     Used to validate if input is legal
     @param min inputed minutes
     @param sec inputed seconds
     @param milli inputed milliseconds
     ***************************************************************/
    private void validate(int min, int sec, int milli) {

        if (milli >= 1000 || milli < 0) {
            throw new IllegalArgumentException(
                    "Invalid input for milliseconds!");
        }

        if (sec >= 60 || sec < 0) {
            throw new IllegalArgumentException(
                    "Invalid input for seconds!");
        }

        if (min < 0) {
            throw new IllegalArgumentException(
                    "Invalid input for minutes!");
        }

    }

    /******************************************************************
     Check if StopWatch is equal to another StopWatch
     @param other StopWatch object
     @return true if StopWatchs are equal
     ******************************************************************/
    public boolean equals(Object other) {
        if (other!= null) {
            if (other instanceof StopWatch) {
                StopWatch temp = (StopWatch) other;
                return (temp.minutes==this.minutes) &&
                        (temp.seconds == this.seconds) &&
                        (temp.milliseconds == this.milliseconds);
            }
        }
        return false;
    }

    /******************************************************************
     Checks if current StopWatch is greater than sent StopWatch
     @param other StopWatch object
     @return int 1 if current watch is greater
     		     0 if current watch is equal
     	        -1 if current watch is less
     ******************************************************************/
    public int compareTo(StopWatch other) {
        int otherMilliseconds=((((other.minutes * 60) + other.seconds) * 1000 ) + other.milliseconds);
        int milliseconds= ((((this.minutes * 60) + this.seconds) * 1000 ) + this.milliseconds);

        if (milliseconds>otherMilliseconds) {
            return 1;
        }

        else if (milliseconds < otherMilliseconds) {
            return -1;
        }

        else {
            return 0;
        }
    }

    /******************************************************************
     Check if a StopWatch is equal to another StopWatch.
     @param s1 StopWatch 1
     @param s2 StopWatch 2
     @return true if Stop Watches are equal.
     ******************************************************************/
    public static boolean equals(StopWatch s1, StopWatch s2) {
        return (s1.minutes == s2.minutes) && (s1.seconds == s2.seconds) && (s1.milliseconds == s2.milliseconds);
    }

    /******************************************************************
     Adds milliseconds to StopWatch
     @param milliseconds number of milliseconds to be added
     ******************************************************************/
    public void add (int milliseconds) {
        if (milliseconds>0) {
            if (!suspend){
                for(int i=milliseconds;i>0; i--) {
                    this.inc();
                }
            }

        }
        else {
            throw  new IllegalArgumentException();
        }
    }

    /******************************************************************
     Adds another StopWatch to current StopWatch
     @param other StopWatch object
     ******************************************************************/
    public void add (StopWatch other) {
       // Nate's Version
        /* int milliseconds=((((other.minutes * 60) + other.seconds) * 1000 ) + other.milliseconds);
        if (milliseconds>0) {
            if (!suspend){
                for(int i=milliseconds;i>0; i--) {
                    this.inc();
                }
            }
        }
        else {
            throw  new IllegalArgumentException();
        }*/

       // Gabe's version

      if (!suspend) {
            int milli = other.getMilliseconds();
            int sec = other.getSeconds();
            int min = other.getMinutes();

            int total = (min * 60 * 1000) + (sec * 1000) + milli;

            add(total);
        }
        else {
          throw  new IllegalArgumentException();
      }
    }

    /************************************************************************
     Subtrct milliseconds from Stop Watch timer
     @param milliseconds
     ************************************************************************/
    public void sub (int milliseconds) {
        if (milliseconds>0) {
            if(!suspend) {
                if (((((this.minutes*60)+this.seconds)*1000)+this.milliseconds) >= milliseconds){
                    for(int i=milliseconds;i>0; i--) {
                        this.dec();
                    }
                }
                else {
                    throw new IllegalArgumentException();
                }
            }
        }
        else {
            throw  new IllegalArgumentException();
        }

    }

    /************************************************************************
     Subtract one Stop Watch from another.
     @param other
     ************************************************************************/
    public void sub (StopWatch other) {
        int milliseconds=((((other.minutes * 60) + other.seconds) * 1000 ) + other.milliseconds);
        if (milliseconds>0 ) {
            if(!suspend) {
                if (((((this.minutes*60)+this.seconds)*1000)+this.milliseconds) >= milliseconds){
                    for(int i=milliseconds;i>0; i--) {
                        this.dec();
                    }
                }
                else {
                    throw new IllegalArgumentException();
                }
            }
        }
        else {
            throw  new IllegalArgumentException();
        }
    }

    /******************************************************************
     A method that decrements the “this” StopWatch by 1 millisecond
     ******************************************************************/
    public void dec() {
        if (this.milliseconds == 0){
            if (this.seconds == 0) {
                if(this.minutes == 0) {
                    return;
                }
                this.seconds=59;
                minutes--;
            }
            else {
                this.seconds--;
            }
            this.milliseconds= 999;
        }
        else {
            this.milliseconds--;
        }
    }

    /******************************************************************
     Adds 1 milliseconds to StopWatch
     ******************************************************************/
    public void inc() {
        // Nate's Version
   /*     if (!suspend) {
            if (this.milliseconds == 999){
                if (this.seconds == 59) {
                    this.seconds=0;
                    this.minutes++;
                }
                else {
                    this.seconds++;
                }
                this.milliseconds=0;
            }
            else {
                this.milliseconds++;
            }
        }*/

// Gabe's Version

     if (!suspend) {
            milliseconds++;

            if (milliseconds >= 1000) {
                milliseconds = 0;
                seconds++;
            }

            if (seconds >= 60) {
                seconds = 0;
                minutes++;
            }
        }
    }

    /************************************************************************
     toString method for timestamp of timer.
     ************************************************************************/
    public String toString() {
        String timeStamp ="";
        timeStamp += this.minutes + ":";
        if (seconds>9) {
            timeStamp += this.seconds + ":";
        }
        else {
            timeStamp += "0" + this.seconds + ":";
        }

        if(milliseconds>99) {
            timeStamp += this.milliseconds;
        }
        else if(milliseconds>9) {
            timeStamp += "0" + this.milliseconds ;
        }
        else {
            timeStamp += "00" + this.milliseconds;
        }
        return timeStamp;
    }
    /******************************************************************
     Saves current time to file
     @param fileName name of file
     ******************************************************************/
    public void save(String fileName) {
        PrintWriter out = null;
        try {
            out = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        out.println(this.minutes);
        out.println(this.seconds);
        out.println(this.milliseconds);
        out.close();
    }

    /******************************************************************
     Loads time from file
     @param fileName name of file
     ******************************************************************/
    public void load(String fileName) {
        if (!suspend) {
            try {

                // open the data file
                Scanner fileReader = new Scanner(new File(fileName));

                // read one int
                this.minutes = Integer.parseInt(fileReader.next());
                this.seconds = Integer.parseInt(fileReader.next());
                this.milliseconds = Integer.parseInt(fileReader.next());

                System.out.println(this.minutes);
                System.out.println(this.seconds);
                System.out.println(this.milliseconds);
                fileReader.close();
            }

            // problem reading the file
            catch (Exception error) {
                throw new IllegalArgumentException();
            }
        }
        else {
            throw  new IllegalArgumentException();
        }
    }

    /************************************************************************
     * Suspends all StopWatch functionality and interaction other than Save.
     * @param flag
     ************************************************************************/
    public static void setSuspend(boolean flag) {
        StopWatch.suspend = flag;
    }

    public static boolean isSuspend() {
        return suspend;
    }



}

