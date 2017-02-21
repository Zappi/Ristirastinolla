package ristirastinolla.graphics;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import ristirastinolla.logic.Board;

/**
 * This class draws the game field and it also draws the X's and O's for the
 * game.
 *
 */
public class DrawBoard extends JPanel {

    public int row;
    public int col;
    public final int cellSize = 65;
    public int fieldWidth;
    public int fieldHeight;
    private final Board board;

    /**
     * Draws the board.
     * @param board given board.
     * @param row given row size.
     * @param col given col size.
     */
    public DrawBoard(Board board, int row, int col) {
        this.row = row;
        this.col = col;
        this.fieldWidth = cellSize * this.col;
        this.fieldHeight = cellSize * this.row;
        this.board = board;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        super.setBackground(Color.WHITE);

        //Draws the lines
        g.setColor(Color.DARK_GRAY);
        for (int i = 1; i < row; i++) {
            g.fillRoundRect(0, cellSize * i - (20 / 2), fieldWidth - 1, 20, 20, 20);
        }
        for (int j = 0; j < col; j++) {
            g.fillRoundRect(cellSize * j - (20 / 2), 0, 10, fieldHeight - 1, 20, 20);
        }

        Graphics2D graphics = (Graphics2D) g;
        graphics.setStroke(new BasicStroke(10, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));

        //DRAWING THE MARKS ON THE FIELD
        for (int x = 0; x < row; x++) {
            for (int y = 0; y < col; y++) {
                int x1 = x * cellSize + (cellSize / 6);
                int y1 = y * cellSize + (cellSize / 6);

                if (board.returnPosition('X', x, y)) {
                    graphics.setColor(Color.BLUE.darker());
                    int x2 = (x + 1) * cellSize - (cellSize / 6);
                    int y2 = (y + 1) * cellSize - (cellSize / 6);
                    graphics.drawLine(x1, y1, x2, y2);
                    graphics.drawLine(x2, y1, x1, y2);
                } else if (board.returnPosition('O', x, y)) {
                    graphics.setColor(Color.red);
                    graphics.drawOval(x1, y1, cellSize - (cellSize / 6) * 2, cellSize - (cellSize / 6) * 2);
                }
            }
        }

    }

}
