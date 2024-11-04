package dev.sumantakumar.designpatterns.structural;

public class DecoratorDesignPatternTest {
    public static void main(String[] args) {
        InsurancePolicy basePolicyPlan = new BasePolicyPlan();
        System.out.println("Base Policy Plan:");
        System.out.println(basePolicyPlan.getPremiumCost());
        System.out.println(basePolicyPlan.getPolicyDescription());
        System.out.println("##################\n\n");



        InsurancePolicy accidentPolicyPlan = new BasePolicyPlan();
        accidentPolicyPlan = new AccidentPolicyPlan(accidentPolicyPlan);
        System.out.println("Base Policy with Accident Plan :");
        System.out.println(accidentPolicyPlan.getPremiumCost());
        System.out.println(accidentPolicyPlan.getPolicyDescription());
        System.out.println("##################\n\n");

        InsurancePolicy criticalPolicyPlan = new BasePolicyPlan();
        criticalPolicyPlan = new CriticalPolicyPlan(criticalPolicyPlan);
        System.out.println("Base Policy with Critical Plan :");
        System.out.println(criticalPolicyPlan.getPremiumCost());
        System.out.println(criticalPolicyPlan.getPolicyDescription());
        System.out.println("##################\n\n");


        InsurancePolicy allPlans = new BasePolicyPlan();
        allPlans = new CriticalPolicyPlan(allPlans);
        allPlans = new AccidentPolicyPlan(allPlans);
        System.out.println("All Plans :");
        System.out.println(allPlans.getPremiumCost());
        System.out.println(allPlans.getPolicyDescription());
        System.out.println("##################");


    }
}


interface InsurancePolicy{
    int getPremiumCost();
    String getPolicyDescription();
}

class BasePolicyPlan implements InsurancePolicy{

    @Override
    public int getPremiumCost() {
        return 1500;
    }

    @Override
    public String getPolicyDescription() {
        return "You have selected Basic Policy Plan";
    }
}


abstract class InsurancePolicyDecorator implements InsurancePolicy{
    InsurancePolicy insurancePolicy;
    public InsurancePolicyDecorator(InsurancePolicy insurancePolicy) {
        this.insurancePolicy = insurancePolicy;
    }

    @Override
    public int getPremiumCost() {
        return insurancePolicy.getPremiumCost();
    }

    @Override
    public String getPolicyDescription() {
        return insurancePolicy.getPolicyDescription();
    }
}

class AccidentPolicyPlan extends InsurancePolicyDecorator {

    public AccidentPolicyPlan(InsurancePolicy insurancePolicy) {
        super(insurancePolicy);
    }

    @Override
    public int getPremiumCost() {
        return super.getPremiumCost() + 100;
    }

    @Override
    public String getPolicyDescription() {
        return super.getPolicyDescription()+" with Accident Policy";
    }
}

class CriticalPolicyPlan extends InsurancePolicyDecorator {
    public CriticalPolicyPlan(InsurancePolicy insurancePolicy) {
        super(insurancePolicy);
    }

    @Override
    public int getPremiumCost() {
        return super.getPremiumCost() + 700;
    }

    @Override
    public String getPolicyDescription() {
        return super.getPolicyDescription()+" with Critical Policy";
    }
}