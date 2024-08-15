package edu.gatech.seclass.jobcompare6300;

public class Weights {

    private int yearlySalaryWeight;
    private int yearlyBonusWeight;
    private int restrictedStockUnitAwardWeight;
    private int relocationStipendWeight;
    private int personalChoiceHolidaysWeight;

    public Weights() {
        yearlySalaryWeight = 1;
        yearlyBonusWeight = 1;
        restrictedStockUnitAwardWeight = 1;
        relocationStipendWeight = 1;
        personalChoiceHolidaysWeight = 1;
    };

    public Weights(int yearlySalaryWeight, int yearlyBonusWeight, int restrictedStockUnitAwardWeight, int relocationStipendWeight, int personalChoiceHolidaysWeight) {
        this.yearlySalaryWeight = yearlySalaryWeight;
        this.yearlyBonusWeight = yearlyBonusWeight;
        this.restrictedStockUnitAwardWeight = restrictedStockUnitAwardWeight;
        this.relocationStipendWeight = relocationStipendWeight;
        this.personalChoiceHolidaysWeight = personalChoiceHolidaysWeight;
    }

    public int getYearlySalaryWeight() {
        return yearlySalaryWeight;
    }

    public int getYearlyBonusWeight() {
        return yearlyBonusWeight;
    }

    public int getRestrictedStockUnitAwardWeight() {
        return restrictedStockUnitAwardWeight;
    }

    public int getRelocationStipendWeight() {
        return relocationStipendWeight;
    }

    public int getPersonalChoiceHolidaysWeight() {
        return personalChoiceHolidaysWeight;
    }

    public void setYearlySalaryWeight(int yearlySalaryWeight) {
        this.yearlySalaryWeight = yearlySalaryWeight;
    }

    public void setYearlyBonusWeight(int yearlyBonusWeight) {
        this.yearlyBonusWeight = yearlyBonusWeight;
    }

    public void setRestrictedStockUnitAwardWeight(int restrictedStockUnitAwardWeight) {
        this.restrictedStockUnitAwardWeight = restrictedStockUnitAwardWeight;
    }

    public void setRelocationStipendWeight(int relocationStipendWeight) {
        this.relocationStipendWeight = relocationStipendWeight;
    }

    public void setPersonalChoiceHolidaysWeight(int personalChoiceHolidaysWeight) {
        this.personalChoiceHolidaysWeight = personalChoiceHolidaysWeight;
    }
}
