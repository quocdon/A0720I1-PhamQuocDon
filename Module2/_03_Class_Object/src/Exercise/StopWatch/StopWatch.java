package Exercise.StopWatch;

import java.util.Date;

public class StopWatch {
    private Date startTime, endTime;
    public void getStartTime(){
        this.startTime = new Date();
    }
    public void getEndTime(){
        this.endTime = new Date();
    }
    public double getElapsedTime(){
        return this.endTime.getTime() - this.startTime.getTime();
    }

}
