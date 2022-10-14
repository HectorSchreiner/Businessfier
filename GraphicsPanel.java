import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;

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
		PanelButtom.setLayout(null);

		String[] optionsToChoose = { "BusinessWords.txt", "BabyWords.txt" };
		JComboBox<String> ComboBox = new JComboBox(optionsToChoose);
		ComboBox.setBounds(0, 21, 225, 63);
		PanelButtom.add(ComboBox);

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
			}
		});
	}
}