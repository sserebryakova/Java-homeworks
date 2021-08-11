package homework7;
import javax.swing.*;
import java.awt.*;

public class MyWindow extends JFrame {

    private JPanel gameInfo;
    private JPanel gameControls;
    private JPanel playerInfo;
    private JScrollPane containerForGameLog;
    private JPanel gameMap;
    private JPanel playerActions;

    public static void main(String[] args) {
        new MyWindow();
    }

    public MyWindow() {
        setTitle("Game Window");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(500, 300, 700, 700);
        JPanel gameWindow = new JPanel();
        JPanel gui = new JPanel();
        gui.setLayout(new GridLayout(5, 1));
        add(gui, BorderLayout.EAST);
        add(gameWindow);

        prepareGameMap();
        add(gameMap);

        prepareGameControls();
        gui.add(gameControls);

        prepareGameInfo();
        gui.add(gameInfo);

        preparePlayerInfo();
        gui.add(playerInfo);

        preparePlayerActions();
        gui.add(playerActions);

        prepareGameActionsLog();
        gui.add(containerForGameLog);

        setVisible(true);
    }

    private void prepareGameMap() {
        gameMap = new JPanel();
        gameMap.setBackground(Color.cyan);
    }

    private void prepareGameControls() {
        gameControls = new JPanel();
        gameControls.setLayout(new GridLayout(2, 1));
        JButton btnStartGame = new JButton("Start Game!");
        JButton btnExitGame = new JButton("Exit Game!");
        gameControls.add(btnStartGame);
        gameControls.add(btnExitGame);
    }

    private void prepareGameInfo() {
        gameInfo = new JPanel();
        gameInfo.setLayout(new GridLayout(4, 1));
        gameInfo.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JLabel mapSizeInfo = new JLabel("Current map size: ");
        JLabel countEnemyInfo = new JLabel("Current enemy count: ");
        JLabel gameRoundInfo = new JLabel("Current Round: ");
        gameInfo.add(new JLabel("== Game Info =="));
        gameInfo.add(gameRoundInfo);
        gameInfo.add(mapSizeInfo);
        gameInfo.add(countEnemyInfo);
    }

    private void preparePlayerInfo() {
        playerInfo = new JPanel();
        playerInfo.setLayout(new GridLayout(3, 1));
        playerInfo.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JLabel playerHealthInfo = new JLabel("Health: - ");
        JLabel playerStepsInfo = new JLabel("Steps: -");
        playerInfo.add(new JLabel("== Player Info =="));
        playerInfo.add(playerHealthInfo);
        playerInfo.add(playerStepsInfo);
    }

    private void preparePlayerActions() {
        playerActions = new JPanel();
        playerActions.setLayout(new GridLayout(3, 3));
        playerActions.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JButton moveLeftUp = new JButton("\u2196");
        JButton moveUp = new JButton("\u2191");
        JButton moveRightUp = new JButton("\u2197");
        JButton moveRight = new JButton("\u2192");
        JPanel center = new JPanel();
        JButton moveRightDown = new JButton("\u2198");
        JButton moveDown = new JButton( "\u2193");
        JButton moveLeftDown = new JButton("\u2199");
        JButton moveLeft = new JButton("\u2190");
        playerActions.add(moveLeftUp);
        playerActions.add(moveUp);
        playerActions.add(moveRightUp);
        playerActions.add(moveLeft);
        playerActions.add(center);
        playerActions.add(moveRight);
        playerActions.add(moveLeftDown);
        playerActions.add(moveDown);
        playerActions.add(moveRightDown);
    }

    private void prepareGameActionsLog() {
        containerForGameLog = new JScrollPane();
        containerForGameLog.setLayout(new ScrollPaneLayout());
        containerForGameLog.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JTextArea gameLog = new JTextArea();
        containerForGameLog.add(gameLog);
    }
}

