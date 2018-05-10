public class IsUpperCaseChainElement extends AbstractChain {

    @Override
    public boolean find(String dupa) {
        if (dupa != null && dupa.equals(dupa.toUpperCase())) {
            System.out.println("Text isUpper!!");
            return true;
        } else {
            System.out.println("Not UPPER, going to next =" + next.getClass().getSimpleName());
            return next.find(dupa);
        }


    }

}
