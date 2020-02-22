package mexicoprogram;

import javax.swing.JOptionPane;

public class MexicoProgram {

    public static void main(String[] args) {
        //Elijah Knight, CSC 110, Fall 2016, Program #4, Mexico with a twist

        //Welcome Message
        JOptionPane.showMessageDialog(null, "Welcome to Mexico With a Twist, by Elijah Knight."
                + "\nThis is a two-player dice game in which each player has 5 lives. Each player "
                + "\ngets three rolls of the dice, starting with three dice, then two, then one, of which they are assigned the highest value. Whoever's"
                + "\nsum of highest values is lower than their opponent's loses one live. The first person to lose"
                + "\nall five lives first, loses the game. Good Luck!");
        //set values
        int firstPlayerLives = 5;
        int secondPlayerLives = 5;
        int player1Roll = 0;
        int player2Roll = 0;
        int roll1 = 0;
        int roll2 = 0;
        int roll3 = 0;
        int max1 = Math.max(roll1, Math.max(roll2, roll3));
        int max2 = Math.max(max1, roll3);
        String replay;
        String restartGame;

        Dice die1 = new Dice();
        Dice die2 = new Dice();
        Dice die3 = new Dice();
        //ask player's names
        String FirstPlayerName = JOptionPane.showInputDialog("What is the name of the first player?");
        String SecondPlayerName = JOptionPane.showInputDialog("What is the name of the second player?");

        Player firstPlayer = new Player(FirstPlayerName);
        Player secondPlayer = new Player(SecondPlayerName);

        String restart;
        //do/while loops
        do {
            do { //rolldice
                roll1 = die1.roll();
                roll2 = die1.roll();
                roll3 = die1.roll();
                //set max values
                max1 = Math.max(roll1, roll2);
                max2 = Math.max(max1, roll3);

                //display rolls, get max values, and show scores (1) (Player one)
                JOptionPane.showMessageDialog(null, firstPlayer.getName1() + "'s rolls are " + roll1 + ", " + roll2 + ", " + roll3);
                firstPlayer.addScore(max2);
                JOptionPane.showMessageDialog(null, firstPlayer.getName1() + " has a total of " + firstPlayer.getScore() + " after the first roll");
                //roll dice/set max
                roll1 = die1.roll();
                roll2 = die1.roll();
                max1 = Math.max(roll1, roll2);
                //show rolls, get max values, and show scores (2) (Player one)
                JOptionPane.showMessageDialog(null, firstPlayer.getName1() + "'s rolls are " + roll1 + ", " + roll2);
                firstPlayer.addScore(max1);
                JOptionPane.showMessageDialog(null, firstPlayer.getName1() + " has a total of " + firstPlayer.getScore() + " after the second roll");
                //show rolls, get max values, and show scores (3) (Player one)
                die1.roll();
                JOptionPane.showMessageDialog(null, firstPlayer.getName1() + "'s roll is a " + roll1);
                firstPlayer.addScore(roll1);
                JOptionPane.showMessageDialog(null, firstPlayer.getName1() + " has a total of " + firstPlayer.getScore() + " after the third roll");
                //roll dice/max values
                roll1 = die1.roll();
                roll2 = die1.roll();
                roll3 = die1.roll();
                max1 = Math.max(roll1, roll2);
                max2 = Math.max(max1, roll3);
                //show rolls, get max values, and show scores (1) (Player two)
                JOptionPane.showMessageDialog(null, secondPlayer.getName1() + "'s rolls are " + roll1 + ", " + roll2 + ", " + roll3);
                secondPlayer.addScore(max2);
                JOptionPane.showMessageDialog(null, secondPlayer.getName1() + " has a total of " + secondPlayer.getScore() + " after the first roll");
                //roll dice
                roll1 = die1.roll();
                roll2 = die1.roll();
                max1 = Math.max(roll1, roll2);
                //show rolls, get max values, and show scores (2) (Player two)
                JOptionPane.showMessageDialog(null, secondPlayer.getName1() + "'s rolls are " + roll1 + ", " + roll2);
                secondPlayer.addScore(max1);
                JOptionPane.showMessageDialog(null, secondPlayer.getName1() + " has a total of " + secondPlayer.getScore() + " after the second roll");
                //roll dice///show rolls, get max values, and show scores (3) (Player two)
                roll1 = die1.roll();
                JOptionPane.showMessageDialog(null, secondPlayer.getName1() + "'s rolls are " + roll1);
                secondPlayer.addScore(roll1);
                JOptionPane.showMessageDialog(null, secondPlayer.getName1() + " has a total of " + secondPlayer.getScore() + " after the third roll");
                //subtract live from player 2 if their score is less than player 1
                if (secondPlayer.getScore() < firstPlayer.getScore()) {
                    secondPlayer.loseLife();
                    JOptionPane.showMessageDialog(null, secondPlayer.getName1() + ", you lost one of your lives. You now have " + secondPlayer.getLives()
                            + "\n lives left... " + firstPlayer.getName1() + ", you have " + firstPlayer.getLives() + " lives left.");

                } //subtract live from player 1 if their score is less than player 2
                else if (firstPlayer.getScore() < secondPlayer.getScore()) {
                    firstPlayer.loseLife();
                    JOptionPane.showMessageDialog(null, firstPlayer.getName1() + ", you lost one of your lives. You now have " + firstPlayer.getLives()
                            + "\n lives left... " + secondPlayer.getName1() + ", you have " + secondPlayer.getLives() + " lives left.");
                } else { //say its a tie if the scores are equal
                    JOptionPane.showMessageDialog(null, "No blood on this one! It's a tie...");

                } //If player one loses all lives, say they lost and that player two won
                if (firstPlayer.getLives() == 0) {
                    JOptionPane.showMessageDialog(null, firstPlayer.getName1() + " you lost all of your lives!!! You lose! a" + secondPlayer.getName1() + ", you win!!");
                } //If player two loses all lives, say they lost and that player one won
                else if (secondPlayer.getLives() == 0) {
                    JOptionPane.showMessageDialog(null, secondPlayer.getName1() + ", you lost all of your lives!!! You lose! " + firstPlayer.getName1() + ", you win!!");
                }
                //ask if players want to play again
                replay = JOptionPane.showInputDialog("Play again??? (yes),(no)");
                firstPlayer.restartRound();
                secondPlayer.restartRound();
                //ask if they want to restart the round 
            } while (firstPlayerLives > 0 && secondPlayerLives > 0 && replay.equalsIgnoreCase("yes"));
            restartGame = JOptionPane.showInputDialog("Restart Game? (yes),(no)");
            firstPlayer.restartGame();
            secondPlayer.restartGame();

        } while (restartGame.equalsIgnoreCase("yes"));
        //closing message
        JOptionPane.showMessageDialog(null, "Thanks for using my program, Hope you had fun!");
    }
}
