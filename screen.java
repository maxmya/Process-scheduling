package lab;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JScrollPane;
import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.JTextArea;
import javax.swing.UIManager;

import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.SystemColor;
import java.awt.Font;

public class screen extends JFrame {

	private JPanel contentPane;
	static JTextArea screen;
	static Point mouseDownCompCoords;
	private JTextField fileName;

	/**
	 * Launch the application.
	 */
	// public static void main(String[] args) {
	// EventQueue.invokeLater(new Runnable() {
	// public void run() {
	// try {
	// screen frame = new screen();
	// frame.setVisible(true);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
	// });
	// }

	/**
	 * Create the frame.
	 */
	public screen() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			JFrame.setDefaultLookAndFeelDecorated(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// setLocationRelativeTo(null);

		setBounds(100, 100, 562, 368);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

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

		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 536, 299);
		contentPane.add(panel);
		panel.setLayout(new CardLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, "name_3825884298649");

		screen = new JTextArea();
		screen.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 15));
		screen.setForeground(SystemColor.infoText);
		screen.setBackground(SystemColor.control);
		screen.setEditable(false);
		scrollPane.setViewportView(screen);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setBounds(85, 321, 392, 35);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JButton btnNewButton = new JButton("Ok");
		btnNewButton.setBounds(0, 0, 120, 35);
		panel_1.add(btnNewButton);

		JButton button = new JButton("Save To File");
		button.setBounds(140, 0, 120, 35);
		panel_1.add(button);
		
		fileName = new JTextField();
		fileName.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(fileName.getText().equals("out file")){
					fileName.setText("");
				}
			}
		});
		fileName.setForeground(Color.GRAY);
		fileName.setHorizontalAlignment(SwingConstants.CENTER);
		fileName.setText("out file");
		fileName.setBounds(277, 0, 115, 35);
		panel_1.add(fileName);
		fileName.setColumns(10);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser chooser = new JFileChooser();
				String path = "";
				chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					path = chooser.getSelectedFile().getAbsolutePath();					
					
				if(!fileName.getText().equals(""))
				{
					path += "/"+fileName.getText()+".txt";
				}else {
				path +="/out file.txt";
				}
				try {
					PrintWriter out = new PrintWriter(path);
					out.write(String.format(screen.getText(),null));
					out.close();
				} catch (FileNotFoundException e) {
					JOptionPane.showMessageDialog(null, "Erorr !");
				}
				} else {
					JOptionPane.showMessageDialog(null, "No Folder Selected !");
				}


			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				setVisible(false);
			}
		});

		setUndecorated(true);
		setVisible(true);
	}
}
