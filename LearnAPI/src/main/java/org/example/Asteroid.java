package org.example;

import java.math.BigDecimal;
import java.util.Objects;

public class Asteroid implements Comparable {

    private String designation;
    private String discovery_date;
    private String period_yr;
    private String pha;

    @Override
    public String toString() {
        return Objects.isNull(this.designation)?"0":this.designation;
    }

    public Asteroid(String designation, String discovery_date, String period_yr, String pha) {
        this.designation = designation;
        this.discovery_date = discovery_date;
        this.period_yr = period_yr;
        this.pha = pha;
    }

    @Override
    public int compareTo(Object o) {
        Asteroid p = (Asteroid) o;
        if (this.getPeriod_yr().equals(p.getPeriod_yr())) {
            return this.getDesignation().compareTo(p.getDesignation());
        } else {
            BigDecimal b1 = new BigDecimal(this.getPeriod_yr());
            BigDecimal b2 = new BigDecimal(p.getPeriod_yr());
            return b2.compareTo(b1);
        }
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getDiscovery_date() {
        return discovery_date;
    }

    public void setDiscovery_date(String discovery_date) {
        this.discovery_date = discovery_date;
    }

    public String getPeriod_yr() {
        return period_yr;
    }

    public void setPeriod_yr(String period_yr) {
        this.period_yr = period_yr;
    }

    public String getPha() {
        return pha;
    }

    public void setPha(String pha) {
        this.pha = pha;
    }



}
