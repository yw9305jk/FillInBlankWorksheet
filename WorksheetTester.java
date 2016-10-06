import java.awt.Desktop;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class WorksheetTester extends JFrame {
	
	Worksheet test = new Worksheet();
	
	ArrayList<String> wordArrayList = new ArrayList<String>();
	ArrayList<String> themeArrayList = new ArrayList<String>();
	ArrayList<String> urlArrayList = new ArrayList<String>();
	
	private JLabel fileLabel;
	private JLabel titleLabel;
	private JLabel themeLabel;
	private JLabel numberOfWordsLabel;
	private JLabel lengthOfWordLabel;
	private JLabel blanksLabel;
	private JLabel showBlanksLabel;
	
	private JButton fileButton;
	private JButton okButton;
	private JButton helpButton;
	private JButton quitButton;
	
	private JTextField fileTextfield;
	private JTextField titleTextfield;
	private JTextField themeTextfield;
	private JTextField numberOfWordsTextfield;
	private JTextField lengthOfWordTextfield;
	
	private JComboBox themeList;
	private JComboBox blanksList;
	
	private JCheckBox showBlanksCheckBox;
	
	public WorksheetTester()
	{
		
		setLayout(new GridLayout(0,3));
		eventChooseFile e = new eventChooseFile();
		eventOkFile o = new eventOkFile();
		eventHelpFile h = new eventHelpFile();
		eventQuitFile q = new eventQuitFile();
		
		fileLabel = new JLabel("File");
		add(fileLabel);
		fileTextfield = new JTextField(15);
		add(fileTextfield);
		fileButton = new JButton("Load...");
		add(fileButton);
		fileButton.addActionListener(e);
		
		titleLabel = new JLabel("Title");
		add(titleLabel);
		titleTextfield = new JTextField(15);
		titleTextfield.setText("All Words");
		add(titleTextfield);
		add(new JLabel(""));
		
		themeLabel = new JLabel("Theme");
		add(themeLabel);
		String[] themeStringTest = {"All Words", "Animal", "Tool", "Food"};
		themeList = new JComboBox(themeStringTest);
		themeList.setSelectedIndex(0);
		add(themeList);
		add(new JLabel(""));
		
		
		numberOfWordsLabel = new JLabel("Number of Words");
		add(numberOfWordsLabel);
		numberOfWordsTextfield = new JTextField(15);
		numberOfWordsTextfield.setText("10");
		add(numberOfWordsTextfield);
		add(new JLabel(""));

		lengthOfWordLabel = new JLabel("Minimum Length of Word)");
		add(lengthOfWordLabel);
		lengthOfWordTextfield = new JTextField(15);
		lengthOfWordTextfield.setText("2");
		add(lengthOfWordTextfield);
		add(new JLabel(""));

		blanksLabel = new JLabel("Blanks");
		add(blanksLabel);
		String[] blanksStringTest = {
				"One Blank At the beginning of word ",
				"One Blank At the end of the word", 
				"One Blank at Random Location", 
				"Multiple Blanks at all Consonants",
				"Multiple Blanks at all Vowels"};
		blanksList = new JComboBox(blanksStringTest);
		blanksList.setSelectedIndex(0);
		add(blanksList);
		add(new JLabel(""));

		showBlanksLabel = new JLabel("Show Blank Hints");
		add(showBlanksLabel);
		showBlanksCheckBox = new JCheckBox();
		add(showBlanksCheckBox);
		add(new JLabel(""));

		okButton = new JButton("Ok");
		add(okButton);
		okButton.addActionListener(o);
		helpButton = new JButton("Help");
		add(helpButton);
		helpButton.addActionListener(h);
		quitButton = new JButton("Quit");
		add(quitButton);
		quitButton.addActionListener(q);

		
		
	}
	
	public class eventChooseFile implements ActionListener 
	{
		public void actionPerformed(ActionEvent e)
		{
			
			
			JFileChooser chooser = new JFileChooser();
			   File F = new File ("D:/Kou/Homeworks/ICS 240/Assignment 5/");
			   File nameDir, namePath;
			   int checker;
			   chooser.setCurrentDirectory(F);
			   checker = chooser.showOpenDialog(null);
			   
				
				fileTextfield.setText(chooser.getSelectedFile().toString());
			
		}
	}
		
		public class eventOkFile implements ActionListener {
			public void actionPerformed(ActionEvent o)
			{
				
			test.setTitle(titleTextfield.getText());
			test.setTheme(themeList.getSelectedItem().toString());
			test.setNumberOfWords(Integer.parseInt(numberOfWordsTextfield.getText()));
			test.setLengthOfWord(Integer.parseInt(lengthOfWordTextfield.getText()));
			test.setBlanks(blanksList.getSelectedItem());
			test.setShowBlanks(showBlanksCheckBox.isSelected());
			
			if (fileTextfield.getText() == "" )
			{
				JOptionPane.showMessageDialog(null, "Please load a CSV file. ");
						
			}
			
			else if (Integer.parseInt(lengthOfWordTextfield.getText()) < 2 || Integer.parseInt(lengthOfWordTextfield.getText()) > 10 )
			{
				JOptionPane.showMessageDialog(null, "The minimum length of the word must be greater than 2 and no " +
						"more than 10");
						
			}
			
			else
			System.out.println(test.getTitle());
			System.out.println(test.getTheme());
			System.out.println(test.getNumberOfWords());
			System.out.println(test.getLengthOfWord());
			System.out.println(test.getBlanks());
			System.out.println(test.getShowBlanks() + "\n");
			
			String csvFile = fileTextfield.getText();
			
			
			BufferedReader br = null;
			String line = "";
			String cvsSplitBy = ",";
			
		 
			try {
				PrintWriter output = new PrintWriter("D://Kou/Homeworks/ICS 240/Assignment 5/Assn5.html");
				
				int i = 0;
				
				br = new BufferedReader(new FileReader(csvFile));
				while ((line = br.readLine()) != null) 
				{
					
				        // use comma as separator
					String[] words = line.split(cvsSplitBy);
			
						
						wordArrayList.add(words[0]);
						themeArrayList.add(words[1]);
						urlArrayList.add(words[2]);
						

						output.println("<table><tr><td>" + "<img src=\" " + urlArrayList.get(i) + "\">" +
								 "<br>" + wordArrayList.get(i) + "</td>" + "<td>" + "IMG2" + "</td></tr></table>");
						
						
					
				
					
					i++;
					output.close();
					
				}
		 
			} catch (FileNotFoundException n) {
				n.printStackTrace();
			} catch (IOException n) {
				n.printStackTrace();
			} finally {
				if (br != null) {
					try {
						br.close();
					} catch (IOException n) {
						n.printStackTrace();
					}
				}
			}
		 
			File f = new File("D://Kou/Homeworks/ICS 240/Assignment 5/Assn5.html");

			try {
			   Desktop.getDesktop().browse(f.toURI());
			}

			catch (IOException e) {
			   // TODO Auto-generated catch block
			   e.printStackTrace();
			}
			
			System.out.println(wordArrayList);
		    System.out.println(themeArrayList);
			System.out.println(urlArrayList);
			
			System.out.println("Done");
			
			
			
			}
		}
		
		public class eventHelpFile implements ActionListener {
			public void actionPerformed(ActionEvent h)
			{
				JOptionPane.showMessageDialog(null, 
						"File: Choose the CSV file you wish to load \n\n" +
						"Title: Enter a name for the title of your worksheet. \n\n" + 
						"Theme: Enter a name for the theme of your worksheet. \n\n" +
						"Number of Words: Enter the number of words you would like on your worksheet. \n\n" +
						"Length of Word: Enter the minimum number of letters you would like for each word. \n\n" +
						"Blanks: Choose an option for the blank letters. \n\n" +
						"Show Blank Hints: Check if you would like to show hints for the blank letters. \n\n" );
			}
		}
		
		public class eventQuitFile implements ActionListener {
			public void actionPerformed(ActionEvent q)
			{
				System.exit(0);
			}
	
		}
		

	public static void main(String[] args) {
		
		WorksheetTester gui = new WorksheetTester();
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setSize(800, 600);
		gui.setVisible(true);
		gui.setTitle("Fill In The Blank Worksheet GUI");
		
		
	 
	  }

	
}
