package lab;

import java.io.*;
import java.util.ArrayList;

public class Parser {

	public static void main(String[] args) {

		ArrayList<Process> m = Parser.parsPer("C:/Users/Maxmya/Documents/JavaCode/OS/src/lab/p.txt");

		System.out.println(m.toString());

	}

	public Parser() {

	}

	static ArrayList<Process> pars(String fileName) {
		ArrayList<Process> s = new ArrayList<Process>();
		try {
			BufferedReader in = new BufferedReader(new FileReader(fileName));
			String str;
			int counter = 0;
			while ((str = in.readLine()) != null) {
			//	System.err.println("DD");
				if (counter > 0) {
					String[] tokens = str.split("\\s+");
					int id, arr, ex;
					id = Integer.parseInt(tokens[0]);
					arr = Integer.parseInt(tokens[1]);
					ex = Integer.parseInt(tokens[2]);
					Process p = new Process(id, arr, ex);
					s.add(p);
				}
				counter++;
			}
			in.close();
			return s;
		} catch (IOException e) {
			System.err.println("Erorr");
			e.printStackTrace();
		}
		return s;
	}

	static ArrayList<Process> parsPer(String fileName) {
		ArrayList<Process> s = new ArrayList<Process>();
		try {
			BufferedReader in = new BufferedReader(new FileReader(fileName));
			String str;
			int counter = 0;
			while ((str = in.readLine()) != null) {
			//	System.err.println("DD");
				if (counter > 0) {
						String[] tokens = str.split("\\s+");
					int id, arr, ex, preo;
					id = Integer.parseInt(tokens[0]);
					arr = Integer.parseInt(tokens[1]);
					ex = Integer.parseInt(tokens[2]);
					preo = Integer.parseInt(tokens[3]);
					Process p = new Process(id, arr, ex ,preo);
					s.add(p);
				}
				counter++;
			}
			in.close();
			return s;
		} catch (IOException e) {
			System.err.println("Erorr");
			e.printStackTrace();
		}
		return s;
	}
}
