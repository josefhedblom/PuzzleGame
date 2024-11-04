import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PuzzleButton {
    private JButton button;
    private int row, col;
    private PuzzleBoard board;

    public PuzzleButton(int row, int col, PuzzleBoard board) {
        this.row = row;
        this.col = col;
        this.board = board;
        button = new JButton();
        button.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 20));

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                board.moveTile(row, col);
            }
        });
    }

    public JButton getButton() {
        return button;
    }

    public void setText(String text) {
        button.setText(text);
    }

    public String getText() {
        return button.getText();
    }
}
