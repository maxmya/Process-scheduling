/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab;

import java.util.Scanner;

/**
 *
 * @author Zizo
 */
public class Operations {

    /**
     * @param args the command line arguments
     */
//    public static void main(String[] args) {
//        Process pr[] = new Process[4];
//        pr[0] = new Process(1, 0, 6, 3);
//        pr[1] = new Process(2, 0, 8, 3);
//        pr[2] = new Process(3, 0, 7, 1);
//        pr[3] = new Process(4, 2, 3, 1);
//
//        Scanner s = new Scanner(System.in);
//        System.out.println("1-First come first serve \n2-Priority \n3-Shortest job first \n4-Round robin");
//        int choose = s.nextInt();
//        switch (choose) {
//            case 1:
//                FCFS(pr);
//                System.out.println("ID   arr   ex   start   end   res   wait ");
//                for (int i = 0; i < pr.length; i++) {
//                    System.out.printf("%d    %d     %d    %d       %d     %d     %d\n", pr[i].getID(), pr[i].getArrive(), pr[i].getTime(), pr[i].getStart(), pr[i].getEnd(), pr[i].getResponse(), pr[i].getWaiting());
//                }
//                break;
//            case 2:
//                Priority(pr);
//                System.out.println("ID   arr   ex   start   end   res   wait   priority");
//                for (int i = 0; i < pr.length; i++) {
//                    System.out.printf("%d    %d     %d    %d       %d     %d     %d      %d\n", pr[i].getID(), pr[i].getArrive(), pr[i].getTime(), pr[i].getStart(), pr[i].getEnd(), pr[i].getResponse(), pr[i].getWaiting(), pr[i].getPriority());
//                }
//                break;
//            case 3:
//                int avg = 0;
//                SJF t = new SJF();
//                pr = t.SJF_Schedule(pr);
//                System.out.println("ID   arr   ex   start   end   res   wait ");
//                for (int i = 0; i < pr.length; i++) {
//                    System.out.printf("%d    %d     %d    %d       %d     %d     %d\n", pr[i].getID(), pr[i].getArrive(), pr[i].getTime(), pr[i].getStart(), pr[i].getEnd(), pr[i].getResponse(), pr[i].getWaiting());
//                }
//                for (int i = 0; i < pr.length; ++i){
//                    avg += pr[i].getWaiting();
//                }
//                System.out.println(avg/pr.length);
//                break;
//            case 4:
//                RR r = new RR();
//                pr = r.RR_Schedule(pr, 3);
//                System.out.println("ID   arr   start   end   res   wait ");
//                for (int i = 0; i < pr.length; i++) {
//                    System.out.printf("%d    %d     %d       %d     %d     %d\n", pr[i].getID(), pr[i].getArrive(), pr[i].getStart(), pr[i].getEnd(), pr[i].getResponse(), pr[i].getWaiting());
//                }
//                break;
//            default:
//                System.err.println("bad input !");
//
//        }
//    }

    public static Process[] Priority(Process pr[]) {
        int wait = 0;
        Process temp;
        for (int i = 0; i < pr.length; i++) {
            for (int j = pr.length-1; j > i; j--) {
                if (pr[i].getArrive() <= wait) 
                    if (pr[j].getPriority() < pr[j - 1].getPriority()) {
                        temp = pr[j];
                        pr[j] = pr[j - 1];
                        pr[j - 1] = temp;
                    }
            }
            pr[i].setStart(wait);
            pr[i].setEnd(wait + pr[i].getTime());
            pr[i].setResponse(wait - pr[i].getArrive());
            pr[i].setWaiting(wait - pr[i].getArrive());
            wait += pr[i].getTime();
        }

        return pr;
    }

    public static Process[] FCFS(Process pr[]) {

        for (int i = 0; i < pr.length; i++) {
            if (i == 0) {
                pr[i].setStart(0);
                pr[i].setEnd(pr[i].getTime());
                pr[i].setWaiting(0);
            } else {
                pr[i].setStart(pr[i - 1].getEnd());
                pr[i].setEnd(pr[i].getStart() + pr[i].getTime());
                pr[i].setResponse(pr[i].getStart() - pr[i].getArrive());
                pr[i].setWaiting(pr[i].getStart() - pr[i].getArrive());
            }
        }
        
        return pr;
    }
}
