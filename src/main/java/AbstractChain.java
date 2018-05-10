public abstract class AbstractChain {
    AbstractChain next;
    public void setNext(AbstractChain next) {
        this.next = next;
    }

    public abstract boolean find(String dupa);

}
