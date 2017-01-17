/**
* @Author: Randy Scroggins <scroggir>
* @Date:   09-01-2017
* @Email:  scroggins@csus.edu
* @Project: Reverser
* @Filename: ReverseGui.java
* @Last modified by:   scroggir
* @Last modified time: 16-01-2017
*/


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JFrame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class ReverseGui extends JFrame{
    Boolean firstClick = true;
    JTextField inputText = new JTextField("Input text here.",30);
    JTextField outputText = new JTextField("String Reversed", 30);
    protected ReverseGui(){
        //create Frame and add WindowListener
        JFrame  frame = new JFrame("My Frame");
        //make sure frame exits on close
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //create container
        Container contentPane = frame.getContentPane();
        //set contentPane layout
        contentPane.setLayout(new BorderLayout());
        //Make labels
        JLabel input = new JLabel("Input");
        JLabel output = new JLabel("Output");
        //set labels to the JTextFields
        input.setLabelFor(inputText);
        output.setLabelFor(outputText);
        //set up container for the in/out
        Container inContainer = Box.createHorizontalBox();
        inContainer.add(input);
        inContainer.add(inputText);
        Container outContainer = Box.createHorizontalBox();
        outContainer.add(output);
        outContainer.add(outputText);
        //Make a panel for the input output
        JPanel inOutPanel = new JPanel();
        inOutPanel.setBackground(Color.RED);
        //set up a group layout
        GroupLayout inOutLayout = new GroupLayout(inOutPanel);
        //assign inOutPanel layout
        inOutPanel.setLayout(inOutLayout);
        //Get gaping to be automated
        inOutLayout.setAutoCreateGaps(true);
        inOutLayout.setAutoCreateContainerGaps(true);
        //set horizontal group
        GroupLayout.SequentialGroup horizGroup = inOutLayout.createSequentialGroup();
        horizGroup.addGroup(inOutLayout.createParallelGroup().addComponent(input).addComponent(output));
        horizGroup.addGroup(inOutLayout.createParallelGroup().addComponent(inputText).addComponent(outputText));
        inOutLayout.setHorizontalGroup(horizGroup);
        //set vertical group
        GroupLayout.SequentialGroup vertGroup = inOutLayout.createSequentialGroup();
        vertGroup.addGroup(inOutLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(input).addComponent(inputText));
        vertGroup.addGroup(inOutLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(output).addComponent(outputText));
        inOutLayout.setVerticalGroup(vertGroup);
        //make the OK button
        JButton btnOK = new JButton("OK");
        btnOK.addActionListener(new GetText());
        //make the cancel
        JButton btnCncl = new JButton("Cancel");
        btnCncl.addActionListener(new CloseGUI());
        //third button that if clicked that will reverse word by word
        JButton wordByWord = new JButton("Words");
        wordByWord.addActionListener(new WordByWord());
        //highlight when output is focused
        outputText.addFocusListener(new FocusListener() {
            public void focusLost(final FocusEvent pE) {
                outputText.getHighlighter().removeAllHighlights();
            }
            public void focusGained(final FocusEvent pE) {
                outputText.selectAll();
            }
        });
        //highlight when input is focused and remove when not focused
        inputText.addFocusListener(new FocusListener() {
            public void focusLost(final FocusEvent pE) {
                inputText.getHighlighter().removeAllHighlights();
            }
            public void focusGained(final FocusEvent pE) {
                inputText.selectAll();
            }
        });
        JPanel textFieldPanel = new JPanel();
        //create and add a label to the north part of frame
        JLabel reverseText = new JLabel("Welcome to Reverser");
        textFieldPanel.add(reverseText);
        //button and button panel for the south of the frame
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnOK);
        buttonPanel.add(wordByWord);//add the wordbyword button to panel
        buttonPanel.add(btnCncl);
        buttonPanel.setBackground(Color.GREEN);
        //add components to contentPane
        contentPane.add(buttonPanel, BorderLayout.SOUTH);
        contentPane.add(textFieldPanel,BorderLayout.NORTH);
        contentPane.add(inOutPanel,BorderLayout.CENTER);
        contentPane.add((new getMyButtons()),BorderLayout.EAST);
        contentPane.add((new getMyButtons()),BorderLayout.WEST);
        frame.pack();
        //center the GUI
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();frame.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        //putting the focus on the input text field
        frame.addWindowListener(new WindowAdapter() {
              public void windowOpening(WindowEvent windowEvent){
                inputText.requestFocus();
           }
        });
        //clear the input textfield when clicked
        inputText.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                //quick dirty way of dealing with the field repeatedly getting cleared
                if(firstClick){
                    inputText.setText("");
                    firstClick = false;
                }
            }
        });
        // make visible
        frame.setVisible(true);
    }
    private class CloseGUI implements ActionListener{
        public void actionPerformed(ActionEvent e){
            System.exit(0);
        }
    }
    //ActionListener to change the outputText to what is in the inputText
    private class GetText implements ActionListener{
        public void actionPerformed(ActionEvent e){
            String text = inputText.getText();
            outputText.setText(ReverseMyStuff.reverser(text));
        }
    }
    private class WordByWord implements ActionListener{
        public void actionPerformed(ActionEvent e){
            String text = inputText.getText();
            outputText.setText(ReverseMyStuff.wordReverser(text));
        }
    }
    //this is a class to make my buttons so I can put them every where
    private class getMyButtons extends JPanel{
        private getMyButtons(){
            setBackground(Color.pink);
            //the ok button that when pressed will reverse the string
            JButton okbtn = new JButton("OK");
            okbtn.addActionListener(new GetText());
            this.add(okbtn);
            //cancel button to exit the application
            JButton cnclBtn = new JButton("Cancel");
            cnclBtn.addActionListener(new CloseGUI());
            this.add(cnclBtn);
        }
    }
}
