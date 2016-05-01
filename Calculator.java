package lab;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Calculator {

	public static String CalculatorRes(String s, int mode) {

		switch (mode) {

		case 0: {

			ArrayList<Process> list = Parser.pars(s);
			int size = list.size();
			Process[] proces = new Process[size];
			for (int i = 0; i < proces.length; i++) {
				proces[i] = list.get(i);
			}
			Operations.FCFS(proces);

			StringBuilder ss = new StringBuilder();
			ss.append("ID   arr   ex   start   end   res   wait\r\n");
			for (int i = 0; i < proces.length; i++) {
				ss.append(String.format("%d    %d     %d    %d       %d     %d     %d\r\n", proces[i].getID(),
						proces[i].getArrive(), proces[i].getTime(), proces[i].getStart(), proces[i].getEnd(),
						proces[i].getResponse(), proces[i].getWaiting()));
			}

			return ss.toString();
		}
		case 1: {

			ArrayList<Process> list = Parser.pars(s);
			int size = list.size();
			Process[] pr = new Process[size];
			for (int i = 0; i < pr.length; i++) {
				pr[i] = list.get(i);
			}
			int avg = 0;
			SJF t = new SJF();
			pr = t.SJF_Schedule(pr);
			StringBuilder ss = new StringBuilder();
			ss.append("ID   arr   ex   start   end   res   wait\r\n");
			for (int i = 0; i < pr.length; i++) {
				ss.append(String.format("%d    %d     %d    %d       %d     %d     %d\r\n", pr[i].getID(),
						pr[i].getArrive(), pr[i].getTime(), pr[i].getStart(), pr[i].getEnd(), pr[i].getResponse(),
						pr[i].getWaiting()));
			}
			for (int i = 0; i < pr.length; ++i) {
				avg += pr[i].getWaiting();
			}
			ss.append(avg / pr.length);

			return ss.toString();

		}
		case 2: {
			ArrayList<Process> list = Parser.pars(s);
			int size = list.size();
			Process[] pr = new Process[size];
			for (int i = 0; i < pr.length; i++) {
				pr[i] = list.get(i);
			}
			Operations.Priority(pr);
			StringBuilder ss = new StringBuilder();
			ss.append("ID   arr   ex   start   end   res   wait   priority\n");
			for (int i = 0; i < pr.length; i++) {
				ss.append(String.format("%d    %d     %d    %d       %d     %d     %d      %d\r\n", pr[i].getID(),
						pr[i].getArrive(), pr[i].getTime(), pr[i].getStart(), pr[i].getEnd(), pr[i].getResponse(),
						pr[i].getWaiting(), pr[i].getPriority()));
			}

			return ss.toString();
		}
		case 3: {
			ArrayList<Process> list = Parser.pars(s);
			int size = list.size();
			Process[] pr = new Process[size];
			for (int i = 0; i < pr.length; i++) {
				pr[i] = list.get(i);
			}
			RR r = new RR();
			StringBuilder ss = new StringBuilder();

			try {
				pr = r.RR_Schedule(pr, Integer.parseInt(main.rrQ.getText()));
				ss.append("ID   arr   start   end   res   wait\r\n");
				for (int i = 0; i < pr.length; i++) {
					ss.append(String.format("%d    %d     %d       %d     %d     %d\r\n", pr[i].getID(), pr[i].getArrive(),
							pr[i].getStart(), pr[i].getEnd(), pr[i].getResponse(), pr[i].getWaiting()));
				}
				return ss.toString();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Enter Quantity Pleas !");
			}

		}

		default:
			return "";
		}

	}

}
