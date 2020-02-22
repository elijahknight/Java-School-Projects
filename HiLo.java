package hi.lo;

import javax.swing.JOptionPane;

public class HiLo {

    public static void main(String[] args) {
        // Elijah Knight, CSC 110, Fall 2016, Program #3, Hi-Lo Game
        
        // Intro Message
        JOptionPane.showMessageDialog(null, "Welcome to Hi-Lo, created by Elijah Knight. This"
                + "\nis a betting game that relies on your prediction of a die roll. First you "
                + "\ndecide how much you want to bet out of your $100. You bet either Lo (2-6)"
                + "\n Hi (8-12) or 7. If you guess correctly you win more money. If you guess incorrectly,"
                + "\n you lose the money that you bet. Good Luck!");
        
        // Set variables
        int money = 100;

        String predict;

        String playAgain = "yes";

        Die die = new Die();

        int roll;

        while (money > 0 && playAgain.equalsIgnoreCase("yes")) {
            // Ask user how much the bet will be
            int bet = Integer.parseInt(JOptionPane.showInputDialog("How much money would you like to bet? ($1 to $ " + money + ")"));
            
            while (bet > money) {
                JOptionPane.showMessageDialog(null, "The bet is too high!");
                bet = Integer.parseInt(JOptionPane.showInputDialog("How much money would you like to bet? ($1 to $" + money + ")"));
            }
            while (bet <= 0) {
                JOptionPane.showMessageDialog(null, "Your bet is too low!");
                bet = Integer.parseInt(JOptionPane.showInputDialog("How much money would you like to bet? (1 to $ " + money + ")"));
            } // Ask hi, lo, or 7 for prediction
            money -= bet;
            predict = JOptionPane.showInputDialog(null, "What is your prediction? (Hi) (Lo) or (7)");
            // roll dice
            roll = die.getTotal();
            JOptionPane.showMessageDialog(null, "The roll = " + roll);
            // show result of dice roll and award/penalize user
            if (predict.equalsIgnoreCase("Hi") && roll >= 8 && roll <= 12) {
                money += bet * 2;
                JOptionPane.showMessageDialog(null, "Winner winner chicken dinner! You have $" + money);

            } else if (predict.equalsIgnoreCase("7") && roll == 7) {
                money += bet * 4;
                JOptionPane.showMessageDialog(null, "Winner winner chicken dinner! You have $" + money);

            }
            else if (predict.equalsIgnoreCase("Lo") && roll >= 2 && roll <= 6) {
                money += bet * 2;
                JOptionPane.showMessageDialog(null, "Winner winner chicken dinner! You have $" + money);

            } else {
                JOptionPane.showMessageDialog(null, "Too bad, you smell like rotten eggs.. You now have $" + money);
            }
            // Give option to quit or keep playing
            playAgain = JOptionPane.showInputDialog(null, "Keep Playing? (Yes) (No)");

        }    //Closing Message
        JOptionPane.showMessageDialog(null, "Thanks for playing.. Good luck next time!");

    }

}
