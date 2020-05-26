package com.popov.homework.arcade.arcade;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Window {
    public static void main(String[] args) throws InterruptedException {
        JFrame frame = new JFrame("Window");
        int lives = 3;
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Button spacer = new Button("SPACER");
        spacer.setBounds(30, 750, 150, 30);
        spacer.setBackground(Color.BLACK);
        spacer.setForeground(Color.RED);
        frame.add(spacer);
        List<Button> goals = new ArrayList<>();
        FlyButton ball = new FlyButton(25, 25, Color.GREEN);
        frame.add(ball);
        int k = 0;
        for (int i = 0; i < 18; i++) {
            for (int j = 0; j < 5; j++) {
                Button button = new Button();
                button.setBounds(30 + i * 40, 30 + j * 40, 30, 30);
                button.setBackground(Color.RED);
                goals.add(button);
                frame.add(button);
            }
        }
        k = 0;
        Font aux = new Font("Bold", Font.BOLD, 20);

        Label Score = new Label("" + goals.size());
        Score.setBounds(830, 30, 50, 50);
        Score.setFont(aux);
        frame.add(Score);

        Label Lives = new Label("Lives left: " + lives);
        Lives.setBounds(800, 130, 150, 50);
        Lives.setFont(aux);
        frame.add(Lives);

        frame.setSize(1000, 800);
        frame.setLayout(null);
        frame.setVisible(true);
        while (lives > 0) {
            for (int i = 0; i < goals.size(); i++) {
                if (ball.getBounds().intersects(goals.get(i).getBounds())) {
                    frame.remove(goals.get(i));
                    goals.remove(i);
                    ball.setDy(-1 * ball.getDy());
                    Score.setText("" + goals.size());
                }
            }
            if (spacer.getBounds().intersects(ball.getBounds())) {
                ball.setDy(-1 * ball.getDy());
            }
            if (!ball.move()) {
                lives--;
                Lives.setText("Lives left: " + lives);
            }
            Point p = MouseInfo.getPointerInfo().getLocation();
            spacer.setLocation((int) p.getX() - frame.getX(), 700);
            Thread.sleep(10);
        }
    }
}
