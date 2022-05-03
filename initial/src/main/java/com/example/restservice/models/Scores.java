package com.example.restservice.models;


import java.util.List;
import java.util.Objects;

public class Scores {

    Integer id;
    Boolean socialOverEnv;
    Boolean economyOverHealthcare;
    Boolean povertyOverEducation;
    Boolean targetedOverDiverse;
    String managementFees;
    Boolean esgOverAll;
    Boolean shortOverLongTerm;
    List<String> region;

    public Scores(){}

    public Scores(Integer id, Boolean socialOverEnv, Boolean economyOverHealthcare, Boolean povertyOverEducation, Boolean targetedOverDiverse, String managementFees, Boolean esgOverAll, Boolean shortOverLongTerm, List<String> region) {
        this.id = id;
        this.socialOverEnv = socialOverEnv;
        this.economyOverHealthcare = economyOverHealthcare;
        this.povertyOverEducation = povertyOverEducation;
        this.targetedOverDiverse = targetedOverDiverse;
        this.managementFees = managementFees;
        this.esgOverAll = esgOverAll;
        this.shortOverLongTerm = shortOverLongTerm;
        this.region = region;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getSocialOverEnv() {
        return socialOverEnv;
    }

    public void setSocialOverEnv(Boolean socialOverEnv) {
        this.socialOverEnv = socialOverEnv;
    }

    public Boolean getEconomyOverHealthcare() {
        return economyOverHealthcare;
    }

    public void setEconomyOverHealthcare(Boolean economyOverHealthcare) {
        this.economyOverHealthcare = economyOverHealthcare;
    }

    public Boolean getPovertyOverEducation() {
        return povertyOverEducation;
    }

    public void setPovertyOverEducation(Boolean povertyOverEducation) {
        this.povertyOverEducation = povertyOverEducation;
    }

    public Boolean getTargetedOverDiverse() {
        return targetedOverDiverse;
    }

    public void setTargetedOverDiverse(Boolean targetedOverDiverse) {
        this.targetedOverDiverse = targetedOverDiverse;
    }

    public String getManagementFees() {
        return managementFees;
    }

    public void setManagementFees(String managementFees) {
        this.managementFees = managementFees;
    }

    public Boolean getEsgOverAll() {
        return esgOverAll;
    }

    public void setEsgOverAll(Boolean esgOverAll) {
        this.esgOverAll = esgOverAll;
    }

    public Boolean getShortOverLongTerm() {
        return shortOverLongTerm;
    }

    public void setShortOverLongTerm(Boolean shortOverLongTerm) {
        this.shortOverLongTerm = shortOverLongTerm;
    }

    public List<String> getRegion() {
        return region;
    }

    public void setRegion(List<String> region) {
        this.region = region;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Scores scores = (Scores) o;
        return id == scores.id &&
                Objects.equals(socialOverEnv, scores.socialOverEnv) &&
                Objects.equals(economyOverHealthcare, scores.economyOverHealthcare) &&
                Objects.equals(povertyOverEducation, scores.povertyOverEducation) &&
                Objects.equals(targetedOverDiverse, scores.targetedOverDiverse) &&
                managementFees == scores.managementFees &&
                Objects.equals(esgOverAll, scores.esgOverAll) &&
                Objects.equals(shortOverLongTerm, scores.shortOverLongTerm) &&
                Objects.equals(region, scores.region);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, socialOverEnv, economyOverHealthcare, povertyOverEducation, targetedOverDiverse, managementFees, esgOverAll, shortOverLongTerm, region);
    }

    @Override
    public String toString() {
        return "Scores{" +
                "id=" + id +
                ", socialOverEnv=" + socialOverEnv +
                ", economyOverHealthcare=" + economyOverHealthcare +
                ", povertyOverEducation=" + povertyOverEducation +
                ", targetedOverDiverse=" + targetedOverDiverse +
                ", managementFees=" + managementFees +
                ", esgOverAll=" + esgOverAll +
                ", shortOverLongTerm=" + shortOverLongTerm +
                ", region=" + region +
                '}';
    }
}
