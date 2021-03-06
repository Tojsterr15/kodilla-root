package rock_paper_scissors;


public class GameRules {
    private int roundNumber;
    private int userPoints;
    private int computerPoints;
    private Move computerChoice;
    private int maxRounds;

    public int getMaxRounds() {
        return maxRounds;
    }

    public void setMaxRounds(int maxRounds) {
        this.maxRounds = maxRounds;
    }

    @Override
    public String toString() {
        return "GameRules{" +
                "roundNumber=" + roundNumber +
                ", userPoints=" + userPoints +
                ", computerPoints=" + computerPoints +
                ", computerChoice=" + computerChoice +
                '}';
    }

    public void setRoundNumber(int roundNumber) {
        this.roundNumber = roundNumber;
    }

    public void nextRound() {
        this.roundNumber = this.roundNumber + 1;
    }

    public void setUserPoints(int userPoints) {
        this.userPoints = userPoints;
    }

    public void addUserPoints() {
        this.userPoints = this.userPoints + 1;
    }

    public void setComputerPoints(int computerPoints) {
        this.computerPoints = computerPoints;
    }

    public void addComputerPoints() {
        this.computerPoints = this.computerPoints + 1;
    }

    public void setComputerChoice(Move computerChoice) {
        this.computerChoice = computerChoice;
    }

    public int getRoundNumber() {
        return roundNumber;
    }

    public int getUserPoints() {

        return userPoints;
    }

    public int getComputerPoints() {

        return computerPoints;
    }

    public Move getComputerChoice() {


        return computerChoice;
    }

    public GameRules() {

    }
}
