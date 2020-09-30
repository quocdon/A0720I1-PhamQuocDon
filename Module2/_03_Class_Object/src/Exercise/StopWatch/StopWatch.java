package Exercise.StopWatch;

import java.util.Date;

public class StopWatch {
    private Date startTime, endTime;
    public Date getStartTime(){
        return new Date();
    }
    public Date getEndTime(){
        return new Date();
    }
    public long getElapsedTime(Date start, Date end){
        return end.getTime() - start.getTime();
    }

}
