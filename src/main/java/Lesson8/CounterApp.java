package Lesson8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Создается 2 кнопки как на уроке, и еще 2 кнопки которые увеличивают или уменьшают шаг счетчика.
 * грубо говоря если шаг счетчика равен 5, тогда при увеличении счетчика будет прибавляться 5 (шаг равен 5)
 * а при уменьшении счетчика отниматься 5
 */
public class CounterApp extends JFrame {
    public static int counterValue, additionValue;
    JButton buttonDec, buttonInc, buttonAdditionCountHigh, buttonAdditionCountLess;
    Font font;
    JLabel labelCounter;

    public static void main(String[] args) {
        new CounterApp(0);
    }

    public CounterApp(int setCounterValue) {
        counterValue = setCounterValue;
        additionValue = 1;
        setTitle("CounterApplication");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300,300,500,300);
        buttonDec = new JButton("Decremento");
        buttonInc = new JButton("Incremento");
        add(buttonDec, BorderLayout.WEST);
        add(buttonInc, BorderLayout.EAST);
        font = new Font ("Arial", Font.BOLD, 90);

        //Кнопка для увеличения шага счетчика
        buttonAdditionCountHigh = new JButton("High (" + additionValue + ")");
        buttonAdditionCountHigh.setBounds(250,200,100,50);
        add(buttonAdditionCountHigh);
        buttonAdditionCountHigh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateAdditionButtons(1);
            }
        });

        //Кнопка для уменьшения шага счетчика
        buttonAdditionCountLess = new JButton("Less (" + additionValue + ")");
        buttonAdditionCountLess.setBounds(150,200,100,50);
        add(buttonAdditionCountLess);
        buttonAdditionCountLess.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateAdditionButtons(-1);
            }
        });

        labelCounter = new JLabel(String.valueOf(counterValue));
        labelCounter.setHorizontalAlignment(SwingConstants.CENTER);
        add(labelCounter, BorderLayout.CENTER);
        labelCounter.setFont(font);
        setVisible(true);

        buttonDec.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                incrementoAndDecremento(false);
            }
        });

        buttonInc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                incrementoAndDecremento(true);
            }
        });
    }

    /**
     * Метод обновляющий значение кнопок для увеличения или уменьшения шага счетчика
     * @param addValue положительное или отрицательное значение
     */
    public void updateAdditionButtons(int addValue) {
        additionValue += addValue;
        if (additionValue < 0) additionValue = 0;
        buttonAdditionCountHigh.setText("High (" + additionValue+ ")");
        buttonAdditionCountLess.setText("Less (" + additionValue+ ")");
    }

    /**
     * Один метод для вызову в двух кнопка увеличения и уменьшения счетчика, в методе используется переменная
     * additionValue - шаг счетчика
     * @param increment Если true - значит увеличиваем счетчик, если false - то уменьшаем счетчик
     */
    public void incrementoAndDecremento(boolean increment) {
        if (increment) {
                counterValue += additionValue;
            } else {
                counterValue -= additionValue;
            }
        labelCounter.setText(String.valueOf(counterValue));
    }

}
