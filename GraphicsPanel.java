import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.filechooser.FileNameExtensionFilter;

public class GraphicsPanel extends JPanel {
	public GraphicsPanel() {
		setLayout(new BorderLayout(0, 0));

		JPanel MainPanel = new JPanel();
		add(MainPanel, BorderLayout.CENTER);
		MainPanel.setLayout(new BoxLayout(MainPanel, BoxLayout.Y_AXIS));

		JLabel MainTitel = new JLabel("Businessfier");
		MainTitel.setAlignmentX(Component.CENTER_ALIGNMENT);
		MainTitel.setHorizontalAlignment(SwingConstants.CENTER);
		MainTitel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		MainPanel.add(MainTitel);

		JPanel PanelMid = new JPanel();
		MainPanel.add(PanelMid);
		PanelMid.setLayout(new GridLayout(0, 2, 0, 0));

		JPanel PanelLeft = new JPanel();
		PanelMid.add(PanelLeft);
		PanelLeft.setLayout(new BoxLayout(PanelLeft, BoxLayout.Y_AXIS));

		JLabel InputTitel = new JLabel("Input");
		InputTitel.setAlignmentX(Component.CENTER_ALIGNMENT);
		PanelLeft.add(InputTitel);
		InputTitel.setHorizontalAlignment(SwingConstants.CENTER);
		InputTitel.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JTextArea TextArea = new JTextArea();
		PanelLeft.add(TextArea);
		TextArea.setWrapStyleWord(true);
		TextArea.setText("Indtast tekst her...");
		TextArea.setLineWrap(true);

		JPanel PanelRight = new JPanel();
		PanelMid.add(PanelRight);
		PanelRight.setLayout(new BoxLayout(PanelRight, BoxLayout.Y_AXIS));

		JLabel OutputTitel = new JLabel("Output");
		OutputTitel.setAlignmentX(Component.CENTER_ALIGNMENT);
		OutputTitel.setVerticalAlignment(SwingConstants.TOP);
		PanelRight.add(OutputTitel);
		OutputTitel.setHorizontalAlignment(SwingConstants.CENTER);
		OutputTitel.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JTextArea OutputText = new JTextArea();
		OutputText.setEditable(false);
		OutputText.setWrapStyleWord(true);
		OutputText.setText("Output...");
		OutputText.setLineWrap(true);
		PanelRight.add(OutputText);

		JPanel PanelButtom = new JPanel();
		MainPanel.add(PanelButtom);

		String[] optionsToChoose = { "BusinessWords.txt", "BabyWords.txt" };
		PanelButtom.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		JComboBox<String> ComboBox = new JComboBox(optionsToChoose);
		PanelButtom.add(ComboBox);
		
		JButton FileButton = new JButton("Open File");
		FileButton.setHorizontalAlignment(SwingConstants.RIGHT);
		FileButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		PanelButtom.add(FileButton);
		FileButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				OpenFile(TextArea);
			}
		});

		JButton ActionButton = new JButton("Generate");
		ActionButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		MainPanel.add(ActionButton);
		ActionButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String fileName = ComboBox.getItemAt(ComboBox.getSelectedIndex());

				Collector collector = new Collector();
				String newOutput = collector.Collect(TextArea.getText(), fileName);
				OutputText.setText(newOutput);
				
				try {
					SaveFile(newOutput, "OutputFile.txt");
				} catch (IOException ee) {
					// TODO Auto-generated catch block
					ee.printStackTrace();
				}
			}
		});
	}
	
	//Opens a text-file, and inserts its content into a JTextArea
	private void OpenFile(JTextArea fileTextField) {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
		
		//Added filter which makes sure only text files can be selected
		FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
		fileChooser.setFileFilter(filter);

		int result = fileChooser.showOpenDialog(this);
		if (result == JFileChooser.APPROVE_OPTION) {
		    File selectedFile = fileChooser.getSelectedFile();
		    System.out.println("Selected file: " + selectedFile.getAbsolutePath());
		    try {
				fileTextField.setText(Files.readString(selectedFile.toPath()));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	//Saves a string to a fileName
	private void SaveFile(String fileText, String fileName) throws IOException {
		FileWriter file = new FileWriter(fileName);
		PrintWriter out = new PrintWriter(file);
		
		out.print(fileText);
		out.close();
		System.out.println("Text saved to: " + fileName);
	}
}