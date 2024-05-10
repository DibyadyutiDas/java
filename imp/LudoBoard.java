import javax.swing.*;
import java.awt.*;

public class LudoBoard extends JPanel {

    private final Color RED = Color.RED;
    private final Color GREEN = Color.GREEN;
    private final Color BLUE = Color.BLUE;
    private final Color YELLOW = Color.YELLOW;
    private final Color WHITE = Color.WHITE;
    private final Color GRAY = Color.GRAY;
    private final Color PATH_COLOR = new Color(200, 200, 200); // Light gray for the path
    private final Color SAFE_SPOT_COLOR = new Color(100, 100, 100); // Darker gray for safe spots

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int tileSize = 40;  // Size of each square
        int boardSize = 15; // Number of squares on one side of the board

        // Draw the background
        g.setColor(WHITE);
        g.fillRect(0, 0, boardSize * tileSize, boardSize * tileSize);

        // Draw the home areas
        drawHomeArea(g, 0 * tileSize, 0 * tileSize, RED);     // Top-left (Red)
        drawHomeArea(g, 9 * tileSize, 0 * tileSize, GREEN);  // Top-right (Green)
        drawHomeArea(g, 0 * tileSize, 9 * tileSize, BLUE);   // Bottom-left (Blue)
        drawHomeArea(g, 9 * tileSize, 9 * tileSize, YELLOW); // Bottom-right (Yellow)

        // Draw safe spots
        drawSafeSpots(g, 0 * tileSize, 0 * tileSize, RED);    // Red safe spots
        drawSafeSpots(g, 9 * tileSize, 0 * tileSize, GREEN);  // Green safe spots
        drawSafeSpots(g, 0 * tileSize, 9 * tileSize, BLUE);   // Blue safe spots
        drawSafeSpots(g, 9 * tileSize, 9 * tileSize, YELLOW); // Yellow safe spots

        // Draw the central square
        g.setColor(GRAY);
        g.fillRect(6 * tileSize, 6 * tileSize, 3 * tileSize, 3 * tileSize);

        // Draw the arrows in the central square
        drawArrow(g, 6 * tileSize, 7 * tileSize, "LEFT");  // Red arrow
        drawArrow(g, 9 * tileSize, 7 * tileSize, "RIGHT");  // Yellow arrow
        drawArrow(g, 7 * tileSize, 6 * tileSize, "UP");  // Green arrow
        drawArrow(g, 7 * tileSize, 9 * tileSize, "DOWN");    // Blue arrow

        // Draw the paths
        drawPath(g, 1 * tileSize, 7 * tileSize, 5, 1, RED);  // Red path (top-left to center)
        drawPath(g, 7 * tileSize, 1 * tileSize, 1, 5, GREEN);  // Green path (top-right to center)
        drawPath(g, 7 * tileSize, 9 * tileSize, 1, 5, BLUE);  // Blue path (bottom-left to center)
        drawPath(g, 9 * tileSize, 7 * tileSize, 5, 1, YELLOW); // Yellow path (bottom-right to center)

        // Draw the borders around paths
        drawPathBorder(g, 1 * tileSize, 7 * tileSize, 5, 1);  // Red path border
        drawPathBorder(g, 7 * tileSize, 1 * tileSize, 1, 5);  // Green path border
        drawPathBorder(g, 7 * tileSize, 9 * tileSize, 1, 5);  // Blue path border
        drawPathBorder(g, 9 * tileSize, 7 * tileSize, 5, 1); // Yellow path border
    }

    private void drawHomeArea(Graphics g, int x, int y, Color color) {
        g.setColor(color);
        g.fillRect(x, y, 6 * 40, 6 * 40);
        // No need to draw circles in home area
    }

    private void drawPath(Graphics g, int startX, int startY, int width, int height, Color color) {
        g.setColor(PATH_COLOR);
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                g.fillRect(startX + i * 40, startY + j * 40, 40, 40);
            }
        }

        // Draw safe spots on the path
        // g.setColor(SAFE_SPOT_COLOR);
        // g.fillRect(startX + 40, startY + 40, 40, 40); // Example safe spot
    }

    private void drawPathBorder(Graphics g, int startX, int startY, int width, int height) {
        g.setColor(Color.BLACK);
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                g.drawRect(startX + i * 40, startY + j * 40, 40, 40);
            }
        }
    }

    private void drawSafeSpots(Graphics g, int x, int y, Color color) {
        g.setColor(SAFE_SPOT_COLOR);

        // Draw 4 safe spots in a 2x2 grid within the home area
        g.fillRect(x + 1 * 40, y + 1 * 40, 40, 40);
        g.fillRect(x + 4 * 40, y + 1 * 40, 40, 40);
        g.fillRect(x + 1 * 40, y + 4 * 40, 40, 40);
        g.fillRect(x + 4 * 40, y + 4 * 40, 40, 40);

        // Draw circles inside the safe spots
        g.setColor(Color.WHITE);
        g.fillOval(x + 1 * 40 + 2 , y + 1 * 40 + 2 , 36, 36); // Circle 1
        g.fillOval(x + 4 * 40 + 2 , y + 1 * 40 + 2 , 36, 36); // Circle 2
        g.fillOval(x + 1 * 40 + 2 , y + 4 * 40 + 2 , 36, 36); // Circle 3
        g.fillOval(x + 4 * 40 + 2 , y + 4 * 40 + 2 , 36, 36); // Circle 4
    }
    
    private void drawArrow(Graphics g, int x, int y, String direction) {
        // g.setColor(Color.BLACK);
        int[] xPoints;
        int[] yPoints;

        switch (direction) {
            case "UP":
            g.setColor(Color.GREEN);
                xPoints = new int[]{x - 40, x + 80, x + 20};
                yPoints = new int[]{y, y, y + 60};
                break;
            case "DOWN":
            g.setColor(Color.BLUE);
                xPoints = new int[]{x - 40, x + 80, x + 20};
                yPoints = new int[]{y, y, y - 60};
                break;
            case "LEFT":
            g.setColor(Color.RED);
                xPoints = new int[]{x, x, x + 60};
                yPoints = new int[]{y - 40, y + 80, y + 20};
                break;
            case "RIGHT":
            g.setColor(Color.YELLOW);
                xPoints = new int[]{x, x, x - 60};
                yPoints = new int[]{y - 40, y + 80, y + 20};
                break;
            default:
                xPoints = new int[]{};
                yPoints = new int[]{};
                break;
        }

        g.fillPolygon(xPoints, yPoints, 3);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ludo Board");
        LudoBoard board = new LudoBoard();
        frame.add(board);
        frame.setSize(650, 650);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}