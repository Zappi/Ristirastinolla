package ristirastinolla.UI;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class GUI implements Runnable {
    
    private JFrame frame;

    public GUI() {
        
    }
    
    @Override
    public void run() {
        frame = new JFrame();
        frame.setPreferredSize(new Dimension(400, 400));
        
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        frame.pack();
        frame.setVisible(true);
    }
    
    
}
