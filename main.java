package lab;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import net.miginfocom.swing.MigLayout;

import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class main extends JFrame {

	private JPanel mainPane;
	private JTextField filePath;
	private File myFile;
	public static JTextField rrQ;
	private JLabel msgLable;
	static Point mouseDownCompCoords;
	private JLabel label;
	private JLabel lblProcessScheduling;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			// UIManager.setLookAndFeel("com.seaglasslookandfeel.SeaGlassLookAndFeel");
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			JFrame.setDefaultLookAndFeelDecorated(false);
			// JDialog.setDefaultLookAndFeelDecorated(true);

		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main frame = new main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public main() {
		setTitle("Process Scheduling");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 506, 195);
		mainPane = new JPanel();
		mainPane.setBackground(Color.DARK_GRAY);
		mainPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(mainPane);
		mainPane.setLayout(null);

		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - getWidth()) / 2);
		int y = (int) ((dimension.getHeight() - getHeight()) / 2);
		setLocation(x, y);
		
		
		addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {
				mouseDownCompCoords = null;
			}

			public void mousePressed(MouseEvent e) {
				mouseDownCompCoords = e.getPoint();
			}

			public void mouseExited(MouseEvent e) {
			}

			public void mouseEntered(MouseEvent e) {
			}

			public void mouseClicked(MouseEvent e) {
			}
		});

		addMouseMotionListener(new MouseMotionListener() {
			public void mouseMoved(MouseEvent e) {
			}

			public void mouseDragged(MouseEvent e) {
				Point currCoords = e.getLocationOnScreen();
				setLocation(currCoords.x - mouseDownCompCoords.x, currCoords.y - mouseDownCompCoords.y);
			}
		});

		JLabel lblNewLabel = new JLabel("Choose Method");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(34, 75, 95, 16);
		mainPane.add(lblNewLabel);

		JComboBox cbxMethods = new JComboBox();
		cbxMethods.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cbxMethods.getSelectedIndex() == 3) {
					rrQ.setEnabled(true);
					rrQ.setText("Quantity");
					msgLable.setText(null);
				} else if (cbxMethods.getSelectedIndex() == 2) {
					rrQ.setText(null);
					rrQ.setEnabled(false);
					msgLable.setText("Warning: Priority should be inculuded in the table");
				} else {

					rrQ.setText(null);
					rrQ.setEnabled(false);
					msgLable.setText(null);
				}
			}
		});
		cbxMethods.setBounds(141, 70, 251, 26);
		cbxMethods.setModel(new DefaultComboBoxModel(new String[] { "FCFS (First Come First Served)",
				"SJF (Shortest Job First) ", "Priority", "RR (Round Robin)" }));
		mainPane.add(cbxMethods);

		JLabel lblTable = new JLabel("Processes Table");
		lblTable.setForeground(Color.WHITE);
		lblTable.setBounds(34, 107, 105, 16);
		mainPane.add(lblTable);

		filePath = new JTextField();
		filePath.setForeground(new Color(0, 0, 0));
		filePath.setFont(new Font("Segoe UI Light", Font.PLAIN, 12));
		filePath.setBounds(141, 101, 251, 28);
		filePath.setEditable(false);
		mainPane.add(filePath);
		filePath.setColumns(10);

		JButton btnUpload = new JButton("Upload");
		btnUpload.setBounds(396, 101, 68, 28);
		btnUpload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser chooser = new JFileChooser();
				chooser.setCurrentDirectory(new java.io.File("."));
				chooser.setDialogTitle("Choose File of Process");
				chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
				FileNameExtensionFilter filter = new FileNameExtensionFilter(
						".txt , .text (text files conains tables) ", "txt", "text");
				chooser.setFileFilter(filter);
				chooser.setAcceptAllFileFilterUsed(false);
				if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					// System.out.println("getCurrentDirectory(): " +
					// chooser.getCurrentDirectory());
					// System.out.println("getSelectedFile() : " +
					// chooser.getSelectedFile());
					filePath.setText(null);
					filePath.setText("" + chooser.getSelectedFile());

				}
				// else {
				// System.out.println("No Selection ");
				// }

			}
		});
		mainPane.add(btnUpload);

		JButton btnCalculate = new JButton("Calculate");
		btnCalculate.setBounds(204, 156, 97, 28);
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (filePath.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "No File Uploaded !");
				} else {

					String filePth = filePath.getText();
					myFile = new File(filePth);

					new screen();
					screen.screen.setText(Calculator.CalculatorRes(filePth, cbxMethods.getSelectedIndex()));

				}
			}
		});
		mainPane.add(btnCalculate);

		rrQ = new JTextField();
		rrQ.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (rrQ.getText().equals("Quantity")) {
					rrQ.setText(null);
				}
			}

		});
		// rrQ
		rrQ.setEnabled(false);
		rrQ.setBounds(396, 69, 68, 28);
		mainPane.add(rrQ);
		rrQ.setColumns(10);

		msgLable = new JLabel("");
		msgLable.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 11));
		msgLable.setForeground(Color.RED);
		msgLable.setBounds(6, 164, 297, 26);
		mainPane.add(msgLable);

		label = new JLabel("");
		label.setIcon(new ImageIcon(main.class.getResource("/lab/icons/norma.png")));
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}

			@Override
			public void mouseEntered(MouseEvent e) {

				label.setIcon(new ImageIcon(main.class.getResource("/lab/icons/ready.png")));

			}

			@Override
			public void mouseExited(MouseEvent e) {
				label.setIcon(new ImageIcon(main.class.getResource("/lab/icons/norma.png")));

			}

			@Override
			public void mousePressed(MouseEvent e) {
				label.setIcon(new ImageIcon(main.class.getResource("/lab/icons/slctd.png")));

			}
		});
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(454, 11, 42, 34);
		mainPane.add(label);
		
		lblProcessScheduling = new JLabel("Process Scheduling");
		lblProcessScheduling.setForeground(Color.WHITE);
		lblProcessScheduling.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 14));
		lblProcessScheduling.setHorizontalAlignment(SwingConstants.CENTER);
		lblProcessScheduling.setBounds(172, 11, 161, 34);
		mainPane.add(lblProcessScheduling);

		setUndecorated(true);
	}
}
