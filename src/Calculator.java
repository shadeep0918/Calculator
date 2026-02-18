import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class Calculator {
    int boardWidth =360;
    int boardHeight =540;
    Color customLightGray = new Color(212,212,210);
    Color customDarkGray = new Color(80,80,80);
    Color customBlack = new Color(28,28,28);
    Color customOrange = new Color(255,149,0);

    String buttonValues [] ={
      "Ac","+/-","%","/",
      "7","8","9","*",
      "4","5","6","-",
      "1","2","3","+",
      "0",".","√","="
    };

    String rightSymbols []={"/","*","-","+","="};
    String topSymbols []= {"Ac","+/-","%"};


    JFrame frame = new JFrame("Calculator");
    JLabel displayJLabel = new JLabel();
    JPanel disJPanel = new JPanel();
    JPanel buttoPanel = new JPanel();

    Calculator(){
        frame.setVisible(true);
        frame.setSize(boardWidth, boardHeight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        displayJLabel.setBackground(customBlack);
        displayJLabel.setForeground(Color.white);
        displayJLabel.setFont(new Font( "Arial",Font.PLAIN,80));
        displayJLabel.setHorizontalAlignment(JLabel.RIGHT);
        displayJLabel.setText("0");
        displayJLabel.setOpaque(true);


        disJPanel.setLayout(new BorderLayout());
        disJPanel.add(displayJLabel);
        frame.add(disJPanel,BorderLayout.NORTH);

        buttoPanel.setLayout(new GridLayout(5,4));
        buttoPanel.setBackground(customBlack);
        frame.add(buttoPanel);

        for(int i =0;i <buttonValues.length;i++){
            JButton button = new JButton();
            String buttonValue =buttonValues[i];
            button.setFont(new Font("Arial",Font.PLAIN, 30));
            button.setText(buttonValue);
            buttoPanel.add(button);
            button.setFocusable(false);
            button.setBorder(new LineBorder(customBlack));

            if(Arrays.asList(topSymbols).contains(buttonValue)){
                button.setBackground(customLightGray);
                button.setForeground(customBlack);
                
            }else if(Arrays.asList(rightSymbols).contains(buttonValue)){
                button.setBackground(customOrange);
                button.setForeground(Color.white);
            }else{
                button.setBackground(customDarkGray);
                button.setForeground(Color.white);
            }
            buttoPanel.add(button);

            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e){
                    JButton button = (JButton) e.getSource();
                    String buttonValue = button.getText();
                    if(Arrays.asList(rightSymbols).contains(buttonValue)){

                    }else if(Arrays.asList(topSymbols).contains(buttonValue)){

                    }else {
                        if(buttonValue == "."){
                            if(!displayJLabel.getText().contains(buttonValue)){
                                displayJLabel.setText(displayJLabel.getText()+buttonValue);
                            }

                        }else if ("0123456789".contains(buttonValue)){
                            if(displayJLabel.getText() == "0"){
                                displayJLabel.setText(buttonValue);
                            }else {
                                displayJLabel.setText(displayJLabel.getText()+buttonValue);
                            }
                        }
                    }
                }
            });
        }




    }

}
