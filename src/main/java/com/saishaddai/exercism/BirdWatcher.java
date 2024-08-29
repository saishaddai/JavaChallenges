package com.saishaddai.exercism;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

class BirdWatcher {

    private final int[] birdsPerDay;
    public BirdWatcher(@NotNull int[] birdsPerDay) {
        this.birdsPerDay = birdsPerDay.clone();
    }
    public int[] getLastWeek() {
        return birdsPerDay;
    }
    public int getToday() {
        return birdsPerDay[birdsPerDay.length -1];
    }
    public void incrementTodaysCount() {
        birdsPerDay[birdsPerDay.length - 1]++;
    }
    public boolean hasDayWithoutBirds() {
        return Arrays.stream(birdsPerDay)
                .filter(x -> x == 0)
                .findAny()
                .isPresent();
    }
    public int getCountForFirstDays(int numberOfDays) {
        return Arrays.stream(birdsPerDay)
                .limit(numberOfDays)
                .sum();
    }
    public int getBusyDays() {
        return (int) Arrays.stream(birdsPerDay)
                .filter(x -> x >= 5)
                .count();
    }
}