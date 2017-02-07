package graphics;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class DrawField extends JPanel {

    public final int rows = 3;
    public final int cols = 3;
    public final int cellSize = 166;
    public final int fieldWidth = cellSize*cols;
    public final int fieldHeight = cellSize*rows;
    
    @Override
      public void paintComponent(Graphics g) { 
          super.paintComponent(g);
          super.setBackground(Color.WHITE);
          
          //Draws the lines
          g.setColor(Color.DARK_GRAY);
          for (int i = 1; i < rows; i++) {
            g.fillRoundRect(0, cellSize*i-(20/2), fieldWidth-1, 20, 20, 20);
        }
          for (int j = 0; j< cols; j++) {
            g.fillRoundRect(cellSize*j-(20/2), 0, 10, fieldHeight-1, 20, 20);
        }
      }
      
}
