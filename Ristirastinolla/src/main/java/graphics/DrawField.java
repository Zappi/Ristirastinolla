/**
 *This class draws the game field and it also draws the X's and O's for the game.
 */
package graphics;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import ristirastinolla.logic.Game;

public class DrawField extends JPanel {

    public final int rows = 3;
    public final int cols = 3;
    public final int cellSize = 166;
    public final int fieldWidth = cellSize * cols;
    public final int fieldHeight = cellSize * rows;
    private final Game game;

    public DrawField(Game game) {
        this.game = game;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        super.setBackground(Color.WHITE);

        //Draws the lines
        g.setColor(Color.DARK_GRAY);
        for (int i = 1; i < rows; i++) {
            g.fillRoundRect(0, cellSize * i - (20 / 2), fieldWidth - 1, 20, 20, 20);
        }
        for (int j = 0; j < cols; j++) {
            g.fillRoundRect(cellSize * j - (20 / 2), 0, 10, fieldHeight - 1, 20, 20);
        }

        Graphics2D graphics = (Graphics2D) g;
        graphics.setStroke(new BasicStroke(10, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));

        //DRAWING THE MARKS ON THE FIELD
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int x1 = i * cellSize + (cellSize / 6);
                int y1 = j * cellSize + (cellSize / 6);

                if (game.returnPlayer() == 'X') {
                    graphics.setColor(Color.BLUE.darker());
                    int x2 = (i + 1) * cellSize - (cellSize / 6);
                    int y2 = (j + 1) * cellSize - (cellSize / 6);
                    graphics.drawLine(x1, y1, x2, y2);
                    graphics.drawLine(x2, y1, x1, y2);
                } else if (game.returnPlayer() == 'O') {
                    graphics.setColor(Color.red);
                    graphics.drawOval(x1, y1, cellSize - (cellSize / 6) * 2, cellSize - (cellSize / 6) * 2);
                }
            }
        }

    }

}
