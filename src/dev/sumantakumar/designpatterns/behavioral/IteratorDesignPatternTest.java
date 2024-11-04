package dev.sumantakumar.designpatterns.behavioral;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class IteratorDesignPatternTest {
    public static void main(String[] args) {
        InsurancePolicyCollection policyCollection = new InsurancePolicyCollection();
        policyCollection.addPolicy(new InsurancePolicy("Sumanta Kumar Sahoo", "Term", "TI2002", 2000));
        policyCollection.addPolicy(new InsurancePolicy("Sumanta Kumar Sahoo", "Health", "HI2003", 3000));
        policyCollection.addPolicy(new InsurancePolicy("Sumair", "Term", "TI204", 2500));
        policyCollection.addPolicy(new InsurancePolicy("Sumair", "Health", "HI205", 3500));


        Iterator<InsurancePolicy> iterator = policyCollection.iterator();

        while (iterator.hasNext()) {
            InsurancePolicy policy = iterator.next();
            System.out.println(policy);
            iterator.remove();

        }
    }
}

class InsurancePolicy{
    private final String policyHolderName;
    private final String policyType;
    private final String policyNumber;
    private final double premiumAmount;

    public InsurancePolicy(String policyHolderName, String policyType, String policyNumber, double premiumAmount) {
        this.policyHolderName = policyHolderName;
        this.policyType = policyType;
        this.policyNumber = policyNumber;
        this.premiumAmount = premiumAmount;
    }


    @Override
    public String toString() {
        return "InsurancePolicy{" + "policyHolderName='" + policyHolderName + '\'' +
                ", policyType='" + policyType + '\'' +
                ", policyNumber='" + policyNumber + '\'' +
                ", premiumAmount=" + premiumAmount +
                '}';
    }
}

class InsurancePolicyCollection implements Iterable<InsurancePolicy>{
    private final List<InsurancePolicy> policyCollection;
    public InsurancePolicyCollection() {
        policyCollection = new ArrayList<>();
    }

    public void addPolicy(InsurancePolicy policy) {
        policyCollection.add(policy);
    }

    @Override
    public Iterator<InsurancePolicy> iterator() {
        return new PolicyIterator();
    }

    private class PolicyIterator implements Iterator<InsurancePolicy>{
        private int currentIndex = 0;
        private boolean canRemove = false;

        @Override
        public boolean hasNext() {
            return currentIndex < policyCollection.size();
        }

        @Override
        public InsurancePolicy next() {
            if(!hasNext()){
                throw new NoSuchElementException();
            }
            canRemove = true;
            return policyCollection.get(currentIndex++);
        }

        @Override public void remove() {
            if (!canRemove) {
                throw new IllegalStateException("next() should be called before remove()");
            }
            policyCollection.remove(--currentIndex);
            canRemove = false;
        }
    }
}
