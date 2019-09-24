package com.qf.jsondemo;

public class Word {
    private double english;
    private double maths;

    public Word() {
    }


    @Override
    public String toString() {
        return "word{" +
                "english=" + english +
                ", maths=" + maths +
                '}';
    }

    public double getEnglish() {
        return english;
    }

    public void setEnglish(double english) {
        this.english = english;
    }

    public double getMaths() {
        return maths;
    }

    public void setMaths(double maths) {
        this.maths = maths;
    }

    public Word(double english, double maths) {
        this.english = english;
        this.maths = maths;
    }
}
