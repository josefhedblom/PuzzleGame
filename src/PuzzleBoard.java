import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class PuzzleBoard {
    private final int SIZE = 4;
    private PuzzleButton[][] buttons = new PuzzleButton[SIZE][SIZE];
    private JPanel panel;
    private int emptyRow = SIZE - 1;
    private int emptyCol = SIZE - 1;

    public PuzzleBoard() {
        panel = new JPanel();
        panel.setLayout(new GridLayout(SIZE, SIZE));
        initializeButtons();
        shuffleTiles();
    }

    private void initializeButtons() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                buttons[i][j] = new PuzzleButton(i, j, this);
                panel.add(buttons[i][j].getButton());
            }
        }
    }

    public JPanel getPanel() {
        return panel;
    }

    public void shuffleTiles() {
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= SIZE * SIZE - 1; i++) {
            numbers.add(i);
        }
        numbers.add(0);
        Collections.shuffle(numbers);

        int index = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                int number = numbers.get(index++);
                if (number == 0) {
                    buttons[i][j].setText("");
                    emptyRow = i;
                    emptyCol = j;
                } else {
                    buttons[i][j].setText(String.valueOf(number));
                }
            }
        }
    }

    public void demoSolve() {
        int count = 1;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (i == SIZE - 1 && j == SIZE - 1) {
                    buttons[i][j].setText("");
                    emptyRow = i;
                    emptyCol = j;
                } else if (i == SIZE - 1 && j == SIZE - 2) {
                    buttons[i][j].setText(String.valueOf(count + 1));
                } else if (i == SIZE - 1 && j == SIZE - 3) {
                    buttons[i][j].setText(String.valueOf(count));
                } else {
                    buttons[i][j].setText(String.valueOf(count++));
                }
            }
        }
    }

    public void moveTile(int row, int col) {
        if ((Math.abs(row - emptyRow) == 1 && col == emptyCol) ||
                (Math.abs(col - emptyCol) == 1 && row == emptyRow)) {
            buttons[emptyRow][emptyCol].setText(buttons[row][col].getText());
            buttons[row][col].setText("");

            emptyRow = row;
            emptyCol = col;

            checkWin();
        }
    }

    private void checkWin() {
        int count = 1;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                String text = buttons[i][j].getText();
                if (i == SIZE - 1 && j == SIZE - 1) {
                    if (text.equals("")) {
                        JOptionPane.showMessageDialog(panel, "Grattis, du vann!");
                    }
                    return;
                }
                if (!text.equals(String.valueOf(count++))) {
                    return;
                }
            }
        }
    }
}
