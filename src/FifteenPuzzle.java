import javax.swing.*;
import java.awt.*;

public class FifteenPuzzle extends JFrame {
    private PuzzleBoard board;
    private JButton newGameButton, demoButton;

    public FifteenPuzzle() {
        setTitle("15-spel");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 450);

        board = new PuzzleBoard();

        newGameButton = new JButton("Nytt spel");
        demoButton = new JButton("Demo-spel");

        GameActionListener listener = new GameActionListener(board);
        newGameButton.addActionListener(listener);
        demoButton.addActionListener(listener);

        add(board.getPanel(), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(newGameButton);
        buttonPanel.add(demoButton);
        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        new FifteenPuzzle();
    }
}
