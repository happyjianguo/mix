package qlm.qlm15;

public class User {
    private int data;
    //@param rank is used to store the height of the set-tree
    //when this is the root user
    private int rank;
    private User parent;
    //status is used to judge if this is the root user
    private Boolean status;

    public User(int data) {
        this.data = data;
        this.parent = this;
        this.rank = 0;
        this.status = false;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public int getRank() {
        return rank;
    }

    public void rankInc() {
        this.rank++;
    }

    public User getParent() {
        return parent;
    }

    public void setParent(User parent) {
        this.parent = parent;
    }

    public Boolean isRoot() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}

