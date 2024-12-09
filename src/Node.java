public class Node {
    private User user;
    private Node next;

    public Node(User user) {
        this.user = user;
        this.next = null;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
