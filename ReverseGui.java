// Copyright (c) 2017 by Randy Scroggins. All Rights Reserved.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JFrame;
public class ReverseGui extends JFrame implements ActionListener{
    JButton reverseBtn = new JButton("Reverse String");
    JTextField reverseText = new JTextField("wrong text space",60);
    JTextField inputText = new JTextField("Input text here.",30);
    JTextField outputText = new JTextField("String Reversed", 30);
    private ReverseMyStuff rVM = new ReverseMyStuff();
    public ReverseGui(){
        //create Frame
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
        //Make textFields


        //Make a panel for the input out put
        JPanel inOutPanel = new JPanel();
        inOutPanel.setBackground(Color.RED);
        inOutPanel.setLayout(new GridLayout(2,2));
        //add labels to panel
        inOutPanel.add(input);
        inOutPanel.add(inputText);
        inOutPanel.add(output);
        inOutPanel.add(outputText);
        //make a button
        JButton btnOK = new JButton("OK");

        //make a second button
        JButton btnCncl = new JButton("Cancel");

        //trying to get  ActionListener to work

        reverseText.addActionListener(this);

        // work on getting the textField placed
        JPanel textFieldPanel = new JPanel();

        //add textField to the textFieldPanel
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
        // make visible
        frame.setVisible(true);

    }
    //working on

    public void actionPerformed(ActionEvent evt) {
        //String text = reverseText.getText();
        //ReverseGui temp = new ReverseGui();
        //System.out.println(text);
        //reverseText.selectAll();
        //System.out.println();
    }
    private class CloseGUI implements ActionListener{
        public void actionPerformed(ActionEvent e){
            System.exit(0);
        }
    }
    //ActionListener to change the outputText to what is in the reverseText
    private class GetText implements ActionListener{
        public void actionPerformed(ActionEvent e){
            String text = inputText.getText();
            outputText.setText(rVM.reverser(text));
        }
    }
    //this is a class to make my buttons
    public class getMyButtons extends JPanel{
        public getMyButtons(){
            //make a panel to store the buttons on
            //JPanel buttonPanel = new JPanel();
            //add btn to panels
            setBackground(Color.pink);

            //
            JButton okbtn = new JButton("OK");
            okbtn.addActionListener(new GetText());
            this.add(okbtn);
            //trying some stuff

            JButton cnclBtn = new JButton("Cancel");
            cnclBtn.addActionListener(new CloseGUI());
            this.add(cnclBtn);
            //this.add(new JButton("Cancel").addActionListener(new closeGUI()));
            //set color
            //this.setBackground(Color.GREEEN);
        }
        public void setColor(Color clr){
            this.setBackground(clr);
        }
    }
    //this is a class to make an empty space on the north side of gui
    public class emptySpace extends JPanel{
        public emptySpace(){
            setBackground(Color.blue);
            //setSize(1400,1300);
        }

    }
}
