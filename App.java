import java.awt.*;
import java.applet.*;

public class App extends Applet {
    
    private TextField text1, text2, text3;

    public void init() {
        setLayout(new FlowLayout(FlowLayout.LEFT));
        // setLayout(new GridLayout(4, 0, 40, 20));

        add(new Label("  Principle :  "));
        text1 = new TextField(18);
        add(text1);

        add(new Label("  Rate :        "));
        text2 = new TextField(18);
        add(text2);

        add(new Label("  Time :        "));
        text3 = new TextField(18);
        add(text3);

        text1.setText("");
        text2.setText("");
        text3.setText("");
        setBackground(Color.white);
    }

    public void paint(Graphics g) {
        double x = 0, y = 0, ans = 0;
        int z = 0;
        String s1, s2, s3, s;
        g.setColor(Color.black);
        // g.drawString(" Ammount Interest Time", 10, 50);
        try {
            s1 = text1.getText();
            x = Double.parseDouble(s1);
            s2 = text2.getText();
            y = Double.parseDouble(s2);
            s3 = text3.getText();
            z = Integer.parseInt(s3);

            Loan loanProfile = new Loan(x, y, z);
            ans = loanProfile.getLoanSI();

        } catch (Exception ex) {
        }
        // s = String.valueOf(ans);
        s = String.format("%,.02f", ans);
        g.drawString("Loan  :  ", 20, 180);
        g.drawString("₹ " + s, 80, 180);
    }

    public boolean action(Event event, Object object) {
        repaint();
        return true;
    }
}

class Loan {
    private double ammount;
    private double rate;
    private int time;
    private double loan;

    public Loan(double ammount, double rate, int time) {
        this.ammount = ammount;
        this.rate = rate;
        this.time = time;
        calculateLoan();
    }

    void calculateLoan() {
        loan = (ammount * rate * time) / 100;
    }

    double getLoanSI() {
        return loan;
    }

    void display() {
        System.out.println("Principle : " + ammount);
        System.out.println("Rate : " + rate);
        System.out.print("Time : " + time);
        System.out.println("Loan via SimpleInterest : " + loan);
    }
}
