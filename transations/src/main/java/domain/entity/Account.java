package domain.entity;

public class Account {
    String userName;
    int balence;

    public Account(String userName) {
        this.userName = userName;
    }

    public void setBalence(int balence) {
        this.balence = balence;
    }

    public int getBalence() {
        return balence;
    }

    public String getUserName() {
        return userName;
    }

    @Override
    public String toString() {
        return "Account[" + "userName:" + userName + ", Balance:" + balence + "]";
    }
}
