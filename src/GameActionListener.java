import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameActionListener implements ActionListener {
    private PuzzleBoard board;

    public GameActionListener(PuzzleBoard board) {
        this.board = board;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton) e.getSource();
        if (source.getText().equals("Nytt spel")) {
            board.shuffleTiles();
        } else if (source.getText().equals("Demo-spel")) {
            board.demoSolve();
        }
    }
}
