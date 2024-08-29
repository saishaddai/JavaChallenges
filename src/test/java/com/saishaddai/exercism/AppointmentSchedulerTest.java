package com.saishaddai.exercism;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

class AppointmentSchedulerTest {

    @Test
    @Tag("task:1")
    @DisplayName("The schedule method correctly creates an appointment in the given date and time")
    public void testSchedule() {
        AppointmentScheduler as = new AppointmentScheduler();
        String description = "07/25/2019 13:45:00";
        LocalDateTime expected = LocalDateTime.of(2019, 7, 25, 13, 45, 0);
        LocalDateTime result = as.schedule(description);
        assertEquals(expected, result);
    }

    @Test
    @Tag("task:2")
    @DisplayName("The hasPassed method correctly indicates if am appointment already passed")
    public void itHasPassed() {
        AppointmentScheduler as = new AppointmentScheduler();
        LocalDateTime appointment = LocalDateTime.of(2019, 6, 17, 8, 15, 0);
        boolean result = as.hasPassed(appointment);
        assertTrue(result);

        LocalDateTime future = LocalDateTime.now().plusYears(1L);
        result = as.hasPassed(future);
        assertFalse(result);
    }

    @Test
    @Tag("task:3")
    @DisplayName("The isAfternoonAppointment method correctly indicates if an appointment occurs in the afternoon")
    public void itIsAfternoonAppointment() {
        AppointmentScheduler as = new AppointmentScheduler();
        LocalDateTime inMorning = LocalDateTime.now().withHour(8).withMinute(15);
        boolean result = as.isAfternoonAppointment(inMorning);
        assertFalse(result);

        LocalDateTime inAfternoon = inMorning.withHour(14).withMinute(59);
        result = as.isAfternoonAppointment(inAfternoon);
        assertTrue(result);

        LocalDateTime inNight = inAfternoon.withHour(23).withMinute(15);
        result = as.isAfternoonAppointment(inNight);
        assertFalse(result);
    }

    @Test
    @Tag("task:4")
    @DisplayName("The getLastWeek method correctly returns last week's counts")
    public void itTestGetLastWeek() {
        AppointmentScheduler as = new AppointmentScheduler();
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime test = now.withYear(2024).withMonth(8).withDayOfMonth(28).withHour(22).withMinute(28);
        String description = as.getDescription(test);
        assertEquals("You have an appointment on Wednesday, August 28, 2024, at 10:28 PM.", description);
    }

    @Test
    @Tag("task:5")
    @DisplayName("The getAnniversaryDate method correctly the Sept 15 of this year")
    public void itGetAnniversaryDate() {
        AppointmentScheduler as = new AppointmentScheduler();
        LocalDate anniversary = as.getAnniversaryDate();
        assertNotNull(anniversary);
        assertEquals(LocalDate.now().getYear(), anniversary.getYear());
        assertEquals(Month.SEPTEMBER, anniversary.getMonth());
        assertEquals(15, anniversary.getDayOfMonth());
    }
}