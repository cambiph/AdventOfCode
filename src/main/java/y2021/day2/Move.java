package y2021.day2;

public class Move {
    private String direction;
    private int amount;

    public Move(String direction, int amount) {
        this.direction = direction;
        this.amount = amount;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
