package com.model;

import javax.validation.constraints.NotNull;
import org.springframework.lang.NonNull;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class caculatetax {



    @NotNull
    private double nsal;

    @NotNull
    private double bsal;
    @NotNull
    private double allo;

    @NotNull
    private double tax;

    public caculatetax() {
    }

    public caculatetax(double nsal, double tax, double allo, double bsal) {
        this.nsal = nsal;
        this.tax= tax;
        this.allo= allo;
        this.bsal= bsal;
    }

    public double getbsal() {
        return bsal;
    }

    public void setbsal(double bsal) {
        this.bsal = bsal;
    }

    public double gettax() {
        return tax;
    }

    public void settax(double tax) {
        this.tax = tax;
    }

    public double getAllo() {
        return allo;
    }

    public void setAllo(double allo) {
        this.allo = allo;
    }

    public double getNsal() {
        return nsal;
    }

    public void setNsal(double nsal) {
        this.nsal = nsal;
    }

}
