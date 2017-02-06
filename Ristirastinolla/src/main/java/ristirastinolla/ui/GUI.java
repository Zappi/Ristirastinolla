package ristirastinolla.ui;

import graphics.DrawField;
import java.awt.*;
import javax.swing.*;
import ristirastinolla.logic.Board;
import ristirastinolla.logic.Game;

public class GUI extends JFrame implements Runnable {

    private Game game;
    private JLabel gameStatus;
    private JButton[] buttons;
    private JPanel jpanel;
    private DrawField field;

    public GUI() {
        buttons = new JButton[9];
        this.jpanel = new JPanel(new GridLayout(3, 3));
    }

    @Override
    public void run() {
       
        field = new DrawField();
        field.setPreferredSize(new Dimension(400, 400));
        
        Container container = getContentPane();
        container.setLayout(new BorderLayout());
        container.add(field, BorderLayout.CENTER);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setTitle("Ristirastinolla");
        setVisible(true);
        setResizable(false);
        
        
    }
    
    private void createComponents(Container container) {
        JPanel mainPanel = new JPanel();
        intializeTheButtons(container);
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        
    }

    private void intializeTheButtons(Container container) {     
        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            buttons[i].setBackground(Color.WHITE);
            buttons[i].setPreferredSize(new Dimension(400, 100));
            buttons[i].setText("");
            jpanel.add(buttons[i]);
        }
        container.add(jpanel);
    }

}
