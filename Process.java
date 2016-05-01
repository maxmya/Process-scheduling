/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab;

/**
 *
 * @author Zizo
 */
public class Process {
    private int ID;
    private int Arrive;
    private int Time;
    private int Start;
    private int End;
    private int Response;
    private int Waiting;
    private int Priority;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getArrive() {
        return Arrive;
    }

    public void setArrive(int arrive) {
        Arrive = arrive;
    }

    public int getTime() {
        return Time;
    }

    public void setTime(int time) {
        Time = time;
    }

    public int getStart() {
        return Start;
    }

    public void setStart(int start) {
        Start = start;
    }

    public int getEnd() {
        return End;
    }

    public void setEnd(int end) {
        End = end;
    }

    public int getResponse() {
        return Response;
    }

    public void setResponse(int response) {
        Response = response;
    }

    public int getWaiting() {
        return Waiting;
    }

    public void setWaiting(int waiting) {
        Waiting = waiting;
    }
    
    public void setPriority(int pr){
        Priority = pr;
    }
    
    public int getPriority(){
        return Priority;
    }

    Process(int id, int ar, int ex, int per) {
        setID(id);
        setArrive(ar);
        setTime(ex);
        setPriority(per);
    }
    
    Process(int id, int ar, int ex){
        setID(id);
        setArrive(ar);
        setTime(ex);
    }
}
