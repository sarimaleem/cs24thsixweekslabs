import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class GraphicBinaryTree extends JPanel {

    private static GraphicTree bst;

    public static void main(String[]args) throws FileNotFoundException {

        bst = new GraphicTree();

        Scanner in = new Scanner(new File("GraphicBinarySearchTree.txt"));
        while (in.hasNextInt()) {
            bst.add(new GraphicBinaryNode(in.nextInt()));
        }


        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(1920, 1080);
        window.setSize(1920, 1080);
        GraphicBinaryTree graphicBinaryTree = new GraphicBinaryTree();
        window.add(graphicBinaryTree);
        window.setVisible(true);
    }


    public void paintComponent(Graphics graphics) {


        Graphics2D graphics2D = (Graphics2D)graphics;

        graphics2D.setColor(new Color(212,175,55));
        graphics2D.fillRect(0, 0, 1920, 1080);

        graphics2D.setColor(Color.BLACK);


        try {
            draw(graphics2D, bst.root, 1, 1920 / 2);
        } catch (NullPointerException e) {
        }
        repaint();
    }


    public static void draw(Graphics2D graphics2D, GraphicBinaryNode graphicBinaryNode, int level, int x) {
        int length = 1920;

        int yFactor = 100;

        int y = level * yFactor;

        graphics2D.setColor((new Color(0, 255, 0,  255)).darker());
        graphics2D.fillOval(x-12, y-27, 40, 40);
        graphics2D.setColor(Color.black);

        System.out.println(graphicBinaryNode.getValue());
        graphics2D.setFont(new Font("times", Font.BOLD,  15));
        String formatted = String.format("%02d", graphicBinaryNode.getValue());
        graphics2D.drawString(formatted, x, y);

        if (graphicBinaryNode.getLeft() != null) {

            int childX = x - 1920/powerOfTwo(level +1);
            int childY = (level+1)*yFactor;
            draw(graphics2D, graphicBinaryNode.getLeft(), level+1, childX);
            graphics2D.drawLine(x+7, y+12, childX+25, childY-5);
        }

        if (graphicBinaryNode.getRight() != null) {
            int childX = x + 1920/powerOfTwo(level + 1);
            draw(graphics2D, graphicBinaryNode.getRight(), level+1, childX);
            int childY = (level+1)*yFactor;
            graphics2D.drawLine(x+7, y+12, childX-10, childY-5);
        }

    }



    public static int powerOfTwo(int num) {
        int n = 1;
        for (int i = 0; i < num; i++) {
            n*= 2;
        }
        return n;
    }



}
