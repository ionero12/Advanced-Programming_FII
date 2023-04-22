package org.example.lab6.compulsory;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static org.example.lab6.compulsory.MainFrame.canvas;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton exitBtn = new JButton("Exit");
    JButton loadBtn = new JButton("Load");
    JButton saveBtn = new JButton("Save");
    JButton resetBtn = new JButton("Reset");

    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        //change the default layout manager

        //add all buttons
        add(loadBtn);
        add(saveBtn);
        add(resetBtn);
        add(exitBtn);

        loadBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File selectedFile = new File("D:\\Facultate\\An 2 Semestru 2\\PA - Programare avansata\\ProgramareAvansata\\src\\main\\java\\org\\example\\lab6\\homework\\gameboard.png");
                BufferedImage image = null;
                try {
                    image = ImageIO.read(selectedFile);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                JLabel label = new JLabel(new ImageIcon(image));
                frame.getContentPane().removeAll();
                frame.getContentPane().add(label);
                frame.getContentPane().revalidate();
                frame.getContentPane().repaint();

            }
        });
        saveBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // create a BufferedImage to store the contents of the drawingPanel
                    BufferedImage image = new BufferedImage(frame.getWidth(), frame.getHeight(), BufferedImage.TYPE_INT_RGB);
                    Graphics2D g2 = image.createGraphics();
                    frame.printAll(g2);
                    g2.dispose();

                    // save the image as a PNG file
                    File file = new File("D:\\Facultate\\An 2 Semestru 2\\PA - Programare avansata\\ProgramareAvansata\\src\\main\\java\\org\\example\\lab6\\homework\\gameboard.png");
                    ImageIO.write(image, "png", file);
                    JOptionPane.showMessageDialog(null, "Game board image saved to file: " + file.getAbsolutePath(), "Image saved", JOptionPane.INFORMATION_MESSAGE);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Failed to save image: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        resetBtn.addActionListener(e -> {

            canvas.createBoard(0, (double) 0);
            System.out.println("Cleared the game board.");
        });
        exitBtn.addActionListener(e -> {
            int option = JOptionPane.showConfirmDialog(frame, "Are you sure you want to exit?", "Exit Game", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                frame.dispose();
            }
        });
    }

    private void exitGame(ActionEvent e) {
        frame.dispose();
    }
}