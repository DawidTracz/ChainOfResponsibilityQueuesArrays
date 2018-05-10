public class IsLowerCaseChainElement extends AbstractChain {

    @Override
    public boolean find(String dupa) {
        System.out.println("Checking string '"+dupa+"'");
        if (dupa != null && dupa.equals(dupa.toLowerCase())) {
            System.out.println("Text isLower!!");
            return true;
        } else {
            System.out.println("Not LOWER, going to next =" + next.getClass().getSimpleName());
            return next.find(dupa);
        }

    }

}
