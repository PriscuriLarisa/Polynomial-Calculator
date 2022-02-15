package Calculator.View;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CalculatorView extends JFrame {
    private Container container;
    private JPanel pnl0, pnl1, pnl2, pnl3, pnl4, pnl5, pnl6, pnl7, pnl8, pnl9, pnl10;
    private JLabel firstPolynomialLabel, secondPolynomialLabel, resultPolynomialLabel, remainderPolynomialLabel;
    private JTextField firstPolynomial, secondPolynomial, resultPolynomial, remainderPolynomial;
    private JButton additionButton, subtractionButton, multiplicationButton, divisionButton;
    private JButton derivativeFirstButton, integrationFirstButton, derivativeSecondButton, integrationSecondButton;
    private JButton clearFirstButton, clearSecondButton;
    private JTextField testTextField;

    public CalculatorView(String title) {
        setTitle(title);
        setSize(700, 570);
        setResizable(false);
        setLocation(100, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        container = getContentPane();
        container.setLayout(null);

        testTextField = new JTextField();
        testTextField.setBounds(10, 470, 230, 30);
        Font labelFont = new Font("DialogInput", Font.BOLD, 20);
        Font textFont = new Font("Courier New", Font.BOLD, 18);
        testTextField.setFont(textFont);

        firstPolynomialLabel = new JLabel("First Polynomial:");
        firstPolynomialLabel.setMaximumSize(new Dimension(250, 30));
        firstPolynomialLabel.setFont(labelFont);
        secondPolynomialLabel = new JLabel("Second Polynomial:");
        secondPolynomialLabel.setFont(labelFont);
        resultPolynomialLabel = new JLabel("Result Polynomial:");
        resultPolynomialLabel.setFont(labelFont);
        remainderPolynomialLabel = new JLabel("Remainder Polynomial:");
        remainderPolynomialLabel.setFont(labelFont);

        firstPolynomial = new JTextField();
        firstPolynomial.setPreferredSize(new Dimension(400, 30));
        firstPolynomial.setFont(textFont);
        secondPolynomial = new JTextField();
        secondPolynomial.setFont(textFont);
        secondPolynomial.setPreferredSize(new Dimension(400, 30));
        resultPolynomial = new JTextField();
        resultPolynomial.setFont(textFont);
        resultPolynomial.setEditable(false);
        resultPolynomial.setBorder(BorderFactory.createEmptyBorder());
        remainderPolynomial = new JTextField();
        remainderPolynomial.setBorder(BorderFactory.createEmptyBorder());
        remainderPolynomial.setFont(textFont);
        remainderPolynomial.setEditable(false);


        derivativeFirstButton = new JButton();
        derivativeFirstButton.setMaximumSize(new Dimension(70, 70));
        derivativeFirstButton.setBorderPainted(false);
        derivativeFirstButton.setForeground(Color.BLACK);
        derivativeSecondButton = new JButton();
        derivativeSecondButton.setMaximumSize(new Dimension(70, 70));
        derivativeSecondButton.setBorderPainted(false);
        derivativeSecondButton.setForeground(Color.BLACK);
        integrationFirstButton = new JButton();
        integrationFirstButton.setMaximumSize(new Dimension(70, 70));
        integrationFirstButton.setBorderPainted(false);
        integrationFirstButton.setForeground(Color.BLACK);
        integrationSecondButton = new JButton();
        integrationSecondButton.setMaximumSize(new Dimension(70, 70));
        integrationSecondButton.setBorderPainted(false);
        integrationSecondButton.setForeground(Color.BLACK);

        clearFirstButton = new JButton();
        clearFirstButton.setOpaque(false);
        clearFirstButton.setContentAreaFilled(false);
        clearFirstButton.setBorderPainted(false);
        clearFirstButton.setMaximumSize(new Dimension(50, 50));
        clearSecondButton = new JButton();
        clearSecondButton.setMaximumSize(new Dimension(50, 50));
        clearSecondButton.setOpaque(false);
        clearSecondButton.setContentAreaFilled(false);
        clearSecondButton.setBorderPainted(false);



        additionButton = new JButton();
        additionButton.setMaximumSize(new Dimension(100, 100));
        additionButton.setOpaque(false);
        additionButton.setContentAreaFilled(false);
        additionButton.setBorderPainted(false);

        subtractionButton = new JButton();
        subtractionButton.setMaximumSize(new Dimension(100, 100));
        subtractionButton.setOpaque(false);
        subtractionButton.setContentAreaFilled(false);
        subtractionButton.setBorderPainted(false);

        multiplicationButton = new JButton();
        multiplicationButton.setMaximumSize(new Dimension(100, 100));
        multiplicationButton.setOpaque(false);
        multiplicationButton.setContentAreaFilled(false);
        multiplicationButton.setBorderPainted(false);

        divisionButton = new JButton();
        divisionButton.setMaximumSize(new Dimension(100, 100));
        divisionButton.setOpaque(false);
        divisionButton.setContentAreaFilled(false);
        divisionButton.setBorderPainted(false);

        remainderPolynomial.setVisible(false);
        remainderPolynomialLabel.setVisible(false);

        try{
            Image derivateImage = ImageIO.read(getClass().getResource("/derivare.png"));
            derivativeFirstButton.setIcon(new ImageIcon(derivateImage));
            derivativeSecondButton.setIcon(new ImageIcon(derivateImage));
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try{
            Image integrateImage = ImageIO.read(getClass().getResource("/integrala.png"));
            integrationFirstButton.setIcon(new ImageIcon(integrateImage));
            integrationSecondButton.setIcon(new ImageIcon(integrateImage));
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try{
            Image integrateImage = ImageIO.read(getClass().getResource("/clear.png"));
            clearFirstButton.setIcon(new ImageIcon(integrateImage));
            clearSecondButton.setIcon(new ImageIcon(integrateImage));
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try{
            Image integrateImage = ImageIO.read(getClass().getResource("/plus.png"));
            additionButton.setIcon(new ImageIcon(integrateImage));
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try{
            Image integrateImage = ImageIO.read(getClass().getResource("/minus.png"));
            subtractionButton.setIcon(new ImageIcon(integrateImage));

        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try{
            Image integrateImage = ImageIO.read(getClass().getResource("/ori.png"));
            multiplicationButton.setIcon(new ImageIcon(integrateImage));
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try{
            Image integrateImage = ImageIO.read(getClass().getResource("/impartit.png"));
            divisionButton.setIcon(new ImageIcon(integrateImage));
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        pnl0 = new JPanel();
        pnl0.setLayout(new BoxLayout(pnl0, BoxLayout.Y_AXIS));
        pnl0.setMinimumSize(new Dimension(400, 70));
        pnl0.add(firstPolynomialLabel);
        pnl0.add(Box.createVerticalStrut(20));
        pnl0.add(firstPolynomial);

        pnl1 = new JPanel();
        pnl1.setLayout(new BoxLayout(pnl1, BoxLayout.X_AXIS));
        pnl1.add(Box.createHorizontalStrut(10));
        pnl1.add(derivativeFirstButton);
        pnl1.add(Box.createHorizontalStrut(20));
        pnl1.add(integrationFirstButton);
        pnl1.add(Box.createHorizontalStrut(20));
        pnl1.add(clearFirstButton);

        pnl2 = new JPanel();
        pnl2.setLayout(new BoxLayout(pnl2, BoxLayout.X_AXIS));
        pnl2.add(pnl0);
        pnl2.add(pnl1);

        pnl3 = new JPanel();
        pnl3.setLayout(new BoxLayout(pnl3, BoxLayout.Y_AXIS));
        pnl3.setMinimumSize(new Dimension(400, 70));
        pnl3.add(secondPolynomialLabel);
        pnl3.add(Box.createVerticalStrut(20));
        pnl3.add(secondPolynomial);

        pnl4 = new JPanel();
        pnl4.setLayout(new BoxLayout(pnl4, BoxLayout.X_AXIS));
        pnl4.add(Box.createHorizontalStrut(10));
        pnl4.add(derivativeSecondButton);
        pnl4.add(Box.createHorizontalStrut(20));
        pnl4.add(integrationSecondButton);
        pnl4.add(Box.createHorizontalStrut(20));
        pnl4.add(clearSecondButton);

        pnl5 = new JPanel();
        pnl5.setLayout(new BoxLayout(pnl5, BoxLayout.X_AXIS));
        pnl5.add(pnl3);
        pnl5.add(pnl4);

        pnl6 = new JPanel();
        pnl6.setLayout(new BoxLayout(pnl6, BoxLayout.Y_AXIS));
        pnl6.setBounds(10, 10, 680, 180);
        pnl6.add(pnl2);
        pnl6.add(Box.createVerticalStrut(20));
        pnl6.add(pnl5);
        pnl6.setMinimumSize(new Dimension(680, 180));

        pnl7 = new JPanel();
        pnl7.setMinimumSize(new Dimension(660, 100));
        pnl7.setLayout(new BoxLayout(pnl7, BoxLayout.X_AXIS));
        pnl7.setBounds(10, 200, 660, 100);
        pnl7.add(Box.createHorizontalStrut(20));
        pnl7.add(additionButton);
        pnl7.add(Box.createHorizontalStrut(35));
        pnl7.add(subtractionButton);
        pnl7.add(Box.createHorizontalStrut(35));
        pnl7.add(multiplicationButton);
        pnl7.add(Box.createHorizontalStrut(35));
        pnl7.add(divisionButton);

        pnl8 = new JPanel();
        pnl8.setLayout(new BoxLayout(pnl8, BoxLayout.Y_AXIS));
        pnl8.setBounds(10, 320, 600, 160);
        pnl8.setMinimumSize(new Dimension(600, 160));
        pnl8.add(resultPolynomialLabel);
        pnl8.add(Box.createVerticalStrut(20));
        pnl8.add(resultPolynomial);
        pnl8.add(Box.createVerticalStrut(20));
        pnl8.add(remainderPolynomialLabel);
        pnl8.add(Box.createVerticalStrut(20));
        pnl8.add(remainderPolynomial);


        container.add(pnl6);
        container.add(pnl7);
        container.add(pnl8);

        setVisible(true);

    }

    public String getFirstPolynomial(){
        return firstPolynomial.getText();
    }

    public String getSecondPolynomial(){
        return secondPolynomial.getText();
    }

    public void setFirstPolynomial(String firstPolynomial) {
        this.firstPolynomial.setText(firstPolynomial);
    }

    public void setSecondPolynomial(String secondPolynomial) {
        this.secondPolynomial.setText(secondPolynomial);
    }

    public String getResultPolynomial(){
        return  resultPolynomial.getText();
    }

    public void setResultPolynomial(String polynomialString){
        hideRemainderPolynomial();
        resultPolynomial.setText(polynomialString);
    }

    public void setRemainderPolynomial(String polynomialString){
        remainderPolynomialLabel.setVisible(true);
        remainderPolynomial.setVisible(true);
        remainderPolynomial.setText(polynomialString);
    }
    public void hideRemainderPolynomial() {
        remainderPolynomialLabel.setVisible(false);
        remainderPolynomial.setVisible(false);
    }

    public void clearFirstListener(ActionListener listenForClearFirst) {
        clearFirstButton.addActionListener(listenForClearFirst);
    }

    public void clearSecondListener(ActionListener listenForClearSecond) {
        clearSecondButton.addActionListener(listenForClearSecond);
    }

    public void additionListener(ActionListener listenForAddition) {
        additionButton.addActionListener(listenForAddition);
    }

    public void integrationFirstListener(ActionListener listenForIntegrationFirst) {
        integrationFirstButton.addActionListener(listenForIntegrationFirst);
    }

    public void integrationSecondListener(ActionListener listenForIntegrationSecond) {
        integrationSecondButton.addActionListener(listenForIntegrationSecond);
    }

    public void derivativeFirstListener(ActionListener listenForDerivativeSecond) {
        derivativeFirstButton.addActionListener(listenForDerivativeSecond);
    }

    public void derivativeSecondListener(ActionListener listenForDerivativeFirst) {
        derivativeSecondButton.addActionListener(listenForDerivativeFirst);
    }

    public void subtractionListener(ActionListener listenForSubtraction) {
        subtractionButton.addActionListener(listenForSubtraction);
    }

    public void multiplicationListener(ActionListener listenForMultiplication) {
        multiplicationButton.addActionListener(listenForMultiplication);
    }

    public void divisionListener(ActionListener listenerForDivision) {
        divisionButton.addActionListener(listenerForDivision);
    }
}
