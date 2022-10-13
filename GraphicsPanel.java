import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.DelayQueue;

import javax.swing.*;

public class GraphicsPanel extends JPanel {
	public GraphicsPanel() throws IOException {
		setLayout(null);

		JPanel MainPanel = new JPanel();
		MainPanel.setBounds(0, 0, 450, 300);
		add(MainPanel);
		MainPanel.setLayout(null);

		JLabel Titel = new JLabel("Output");
		Titel.setHorizontalAlignment(SwingConstants.CENTER);
		Titel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Titel.setBounds(226, 83, 206, 26);
		MainPanel.add(Titel);

		JLabel InputTitel = new JLabel("Input");
		InputTitel.setHorizontalAlignment(SwingConstants.CENTER);
		InputTitel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		InputTitel.setBounds(10, 83, 206, 26);
		MainPanel.add(InputTitel);

		JLabel OutputTitel = new JLabel("Businessfier");
		OutputTitel.setHorizontalAlignment(SwingConstants.CENTER);
		OutputTitel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		OutputTitel.setBounds(0, 0, 450, 100);
		MainPanel.add(OutputTitel);

		JLabel OutputText = new JLabel("New label");
		OutputText.setFont(new Font("Tahoma", Font.PLAIN, 13));
		OutputText.setVerticalAlignment(SwingConstants.TOP);
		OutputText.setHorizontalAlignment(SwingConstants.LEFT);
		OutputText.setBounds(236, 111, 196, 107);
		MainPanel.add(OutputText);

		JTextArea TextArea = new JTextArea();
		TextArea.setLineWrap(true);
		TextArea.setText("Indtast tekst her...");
		TextArea.setWrapStyleWord(true);
		TextArea.setBounds(10, 111, 206, 107);
		MainPanel.add(TextArea);

		JButton ActionButton = new JButton("Generate");
		ActionButton.setBounds(90, 236, 275, 40);
		MainPanel.add(ActionButton);
		ActionButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				Collector collector = new Collector();
				String newOutput = collector.Collect(TextArea.getText(), "BusinessWords.txt");
				System.out.println(newOutput);
				OutputText.setText(newOutput);

				ParseFile parserFile = new ParseFile();
				try (FileWriter file = new FileWriter("config.txt")) {
					try {
						file.write(newOutput);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
	}
}