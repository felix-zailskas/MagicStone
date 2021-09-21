package nl.rug.oop.cardgame.view.frame;

import lombok.Data;
import lombok.EqualsAndHashCode;
import nl.rug.oop.cardgame.controller.clicker.CardClicker;
import nl.rug.oop.cardgame.model.menu.MainMenu;
import nl.rug.oop.cardgame.view.panel.*;
import nl.rug.oop.cardgame.view.textures.CardTextures;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Frame window of the application
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class MagicStoneFrame extends JFrame {

    private MagicStonePanel gamePanel;
    private MainMenuPanel mainMenuPanel;
    private GameOverPanel gameOverPanel;
    private TutorialPanel tutorialPanel;
    private CardCollectionPanel cardCollectionPanel;
    private CardClicker clicker;
    private JLabel gifLabel;
    private Image loadedLogo;
    private MainMenu mainMenu;

    /**
     * Creating game frame
     * @param mainMenu main menu panel
     */
    public MagicStoneFrame(MainMenu mainMenu) {
        super("Magic Stone");
        this.mainMenu = mainMenu;
        try {
            this.loadedLogo = ImageIO.read(CardTextures.class.getResource(File.separator + "textures"
                    + File.separator + "MAGICSTONE_LOGO.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.setIconImage(loadedLogo);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        gamePanel = new MagicStonePanel(mainMenu.getGame(), this);
        gamePanel.setLayout(null);

        mainMenuPanel = new MainMenuPanel(mainMenu, this);
        mainMenuPanel.setLayout(null);

        cardCollectionPanel = new CardCollectionPanel(mainMenu,this);
        cardCollectionPanel.setLayout(null);

        tutorialPanel = new TutorialPanel(mainMenu, this);
        tutorialPanel.setLayout(null);

        setContentPane(mainMenuPanel);
        setPreferredSize(new Dimension(1280, 720));
        gifLabel = new JLabel();
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
    }

    /**
     * Play gif, keeping method in case we decide to use it again
     * @param gifName gif name
     * @param coords coordinates of card
     */
    public void playGif(String gifName, int[] coords) {
        ImageIcon gif = new ImageIcon(this.getClass().getResource(File.separator + "textures"
                + File.separator + gifName + ".gif"));
        gif.setImage(gif.getImage().getScaledInstance(coords[2],coords[2], Image.SCALE_DEFAULT));
        gifLabel.setIcon(gif);
        gifLabel.setBounds(coords[0], coords[1], coords[2], coords[2]);
        gamePanel.add(gifLabel);
        pack();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        gifLabel.setIcon(null);
    }

    /**
     * changes the current panel to the game
     */
    public void changeToGamePanel() {
        System.out.println("CHANGED TO GAME PANEL!");
        setContentPane(gamePanel);
        setPreferredSize(new Dimension(1280, 720));
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        repaint();
    }

    /**
     * Game is over
     * @param win who won
     */
    public void gameOver(boolean win) {
        this.gameOverPanel = new GameOverPanel(win, this);
        setContentPane(this.gameOverPanel);
        setPreferredSize(new Dimension(300, 200));
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        repaint();
    }

    /**
     * Change to main menu panel
     */
    public void changeToMainMenuPanel() {
        setContentPane(mainMenuPanel);
        setPreferredSize(new Dimension(1280, 720));
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        repaint();
    }

    public void changeToTutorialPanel() {
        setContentPane(tutorialPanel);
        setPreferredSize(new Dimension(1280, 720));
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        repaint();
    }

    /**
     * Change to card collection panel
     */
    public void changeToCardCollectionPanel() {
        setContentPane(cardCollectionPanel);
        setPreferredSize(new Dimension(1280, 720));
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        repaint();
    }
}
