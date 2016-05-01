package lab;

/**
 * Created by abdu on 4/23/16.
 */
public class RR {

    private int sum;
    private int T;
    private int Q;
    private int fStart = 1;
    

    public Process[] RR_Schedule(Process[] Process, int q) {
        T = 0; Q = q;
        while (true) {
            for (int i = 0; i < Process.length; ++i)
                if (Process[i].getTime() != 0) {
                    if (fStart == 1) {
                        Process[i].setStart(T);
                        Process[i].setResponse(T);
                        sum += Q;
                        for (int j = 0; j < i; ++j)
                            Process[i].setWaiting(sum - Process[i].getArrive());
                    }
                    if (Process[i].getTime() > Q) {
                        Process[i].setTime(Process[i].getTime() - Q);
                        T += Q;
                    } else {
                        T += (Q - (Q - Process[i].getTime()));
                        Process[i].setEnd(T);
                        Process[i].setTime(0);
                    }
                    if (fStart != 1)
                        for (int j = 0; j < Process.length; ++j)
                            if (Process[j].getTime() != 0 && i != j) {
                                if (Process[j].getTime() >= Q)
                                    Process[j].setWaiting(Process[j].getWaiting() + Q);
                                else
                                    Process[j].setWaiting(Process[j].getWaiting() + (Q - (Q - Process[j].getTime())));
                            }
                }
            fStart = -1;
            sum = 0;
            for (int i = 0; i < Process.length; ++i)
                sum += Process[i].getTime();
            if (sum == 0)
                break;
        }
        return Process;
    }
}
