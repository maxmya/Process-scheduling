package lab;

/**
 * Created by abdu on 4/20/16.
 */
public class SJF {
    

    Process[] SJF_Schedule (Process [] Process){
        Process temp;
        int waiting = 0;

        for (int i = 0; i < Process.length; ++i){
            for (int j = Process.length - 1; j > i; --j){
                if (Process[j].getArrive() <= waiting)
                if (Process[j].getTime() < Process[j-1].getTime()){
                    temp = Process[j];
                    Process[j] = Process[j-1];
                    Process[j-1] = temp;
                }
            }
            Process[i].setWaiting(waiting - Process[i].getArrive());
            Process[i].setResponse(waiting - Process[i].getArrive());
            Process[i].setStart(waiting);
            Process[i].setEnd(waiting + Process[i].getTime());
            waiting += Process[i].getTime();
        }
        return Process;
    }
}
