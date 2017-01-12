// Copyright (c) 2017 by Randy Scroggins. All Rights Reserved.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JFrame;
public class ReverseGui extends JFrame{
    JButton reverseBtn = new JButton("Reverse String");
    JLabel reverseText = new JLabel("Welcome to Reverser");
    JTextField inputText = new JTextField("Input text here.",30);
    JTextField outputText = new JTextField("String Reversed", 30);
    private ReverseMyStuff rVM = new ReverseMyStuff();
    public ReverseGui(){
        //create Frame and add WindowListener
        JFrame  frame = new JFrame("My Frame");
        //set size
        frame.setSize(new Dimension(500,500));
        //make sure frame exits on close
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //create container
        Container contentPane = frame.getContentPane();
        //set contentPane layout
        contentPane.setLayout(new BorderLayout());
        //Make labels
        JLabel input = new JLabel("Input");
        JLabel output = new JLabel("Output");
        //Make a panel for the input output
        JPanel inOutPanel = new JPanel();
        inOutPanel.setBackground(Color.RED);
        inOutPanel.setLayout(new GridLayout(2,2));
        //add labels adn textFields to panel
        inOutPanel.add(input);
        inOutPanel.add(inputText);
        inOutPanel.add(output);
        inOutPanel.add(outputText);
        //make a button
        JButton btnOK = new JButton("OK");
        btnOK.addActionListener(new GetText());
        //make a second button
        JButton btnCncl = new JButton("Cancel");
        btnCncl.addActionListener(new CloseGUI());
        // work on getting the textField placed
        inputText.addFocusListener(new FocusListener() {
            public void focusLost(final FocusEvent pE) {}
            public void focusGained(final FocusEvent pE) {
                inputText.selectAll();
            }
        });
        JPanel textFieldPanel = new JPanel();
        //adding a label to the north part of frame
        textFieldPanel.add(reverseText);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnOK);
        buttonPanel.add(btnCncl);
        buttonPanel.setBackground(Color.GREEN);
        //add components
        contentPane.add(buttonPanel, BorderLayout.SOUTH);
        contentPane.add(textFieldPanel,BorderLayout.NORTH);
        contentPane.add(inOutPanel,BorderLayout.CENTER);
        contentPane.add((new getMyButtons()),BorderLayout.EAST);
        contentPane.add((new getMyButtons()),BorderLayout.WEST);
        frame.pack();
        //center the GUI
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        //putting the focus on the input text field
        frame.addWindowListener(new WindowAdapter() {
              public void windowOpening(WindowEvent windowEvent){
                inputText.requestFocus();
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
            outputText.setText(rVM.reverser(text));
        }
    }
    //this is a class to make my buttons so i can put them every where
    public class getMyButtons extends JPanel{
        public getMyButtons(){
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
        //color changer because yeah
        public void setColor(Color clr){
            this.setBackground(clr);
        }
    }
}
