import java.awt.GridLayout;
import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class adminpage implements ActionListener {
	private JDialog win;
	private complaintSoln cfile;
	private JTextArea taSoln;
	private JTextField tfCompNum;
	private JButton submitBtn;
	private JButton listBtn;
	//file path
	String folderPath = "C:\\ProjectData\\";
	String about = "id&pass.txt";

	public adminpage(complaintSoln cfile) {
		this.cfile = cfile;
		win = new JDialog();
		win.setModalityType(ModalityType.APPLICATION_MODAL);
		win.setTitle("Complaints Filed");
		win.setSize(600, 500);
		win.setLayout(new GridLayout(2, 1));
		//gui dim.

		JTable tableAllComps = cfile.returnTable();
		tableAllComps.setEnabled(false);

		tfCompNum = new JTextField(40);

		taSoln = new JTextArea(7, 40);

		submitBtn = new JButton("Submit");
		submitBtn.addActionListener(this);

		listBtn = new JButton("Id & Pass List");
		listBtn.addActionListener(this);

		JPanel panel = new JPanel();
		panel.add(new JLabel("Complaint No. "));
		panel.add(tfCompNum);
		panel.add(new JLabel("            Solution        "));
		panel.add(new JScrollPane(taSoln));
		panel.add(submitBtn);
		panel.add(listBtn);

		win.add(new JScrollPane(tableAllComps));
		win.add(panel);

		win.setVisible(true);
	}

	@Override
	
	public void actionPerformed(ActionEvent e) {
		try{
			String aboutData = new String(Files.readAllBytes(Paths.get(folderPath + about)));
		if (submitBtn == (JButton) e.getSource()) {
			boolean flag = true;
			int cno = 0;
			String sol = taSoln.getText();
			try {
				cno = Integer.parseInt(tfCompNum.getText());
			} catch (Exception exc) {
				flag = false;
				JOptionPane.showMessageDialog(null, "Invalid Complaint No");
			}
			if (flag) {
				if (!cfile.findComp(cno)) {
					JOptionPane.showMessageDialog(null, "No Complaint exist for given Complain No.");
				} else if (sol.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Solution cant be empty");
				} else // Everything right
				{
					try {
						cfile.addSoln(cno, sol);
						JOptionPane.showMessageDialog(null, "Successfully Added");
					} catch (Exception e1) {
						int opt = JOptionPane.showConfirmDialog(null, "Solution Already Exists. Overwrite?");
						if (opt == JOptionPane.YES_OPTION) {
							cfile.overwriteSoln(cno, sol);
							JOptionPane.showMessageDialog(null, "Successfully Overwrited");
						}
					}
				}
			}
			if (flag) {
				win.dispose();
			}
		}
		else if(listBtn == (JButton) e.getSource()) {

			JOptionPane.showMessageDialog(win, aboutData);
		}
	}catch (IOException e1) {
		e1.printStackTrace();
	}
	
	}
}
