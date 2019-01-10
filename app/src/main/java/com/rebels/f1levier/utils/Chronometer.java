package com.rebels.f1levier.utils;

public class Chronometer implements Runnable {

    private static final long MILLIS_TO_SECONDS = 1000;
    private static final long MILLIS_TO_MINUTES = 60000;
    private static final long MILLIS_TO_HOURS = 3600000;

    private ChronometerRunner runner;

    private long startTime;

    private boolean running;

    public Chronometer(ChronometerRunner runner) {
        this.runner = runner;
        running = false;
    }

    public void start() {
        startTime = System.currentTimeMillis();
        running = true;
    }

    public void stop() {
        running = false;
    }

    public long getSince() {
        if (running)
            return System.currentTimeMillis() - startTime;
        else
            return -1;
    }

    @Override
    public void run() {
        while (true) {
            if (running) {
                long since = System.currentTimeMillis() - startTime;

                int millis = (int) (since  % 1000);
                int seconds = (int) ((since / MILLIS_TO_SECONDS) % 60);
                int minutes = (int) ((since / MILLIS_TO_MINUTES) % 60);
                int hours = (int) ((since / MILLIS_TO_HOURS) % 24);

                runner.updateTimerText(
                        String.format("%02d:%02d:%02d:%03d", hours, minutes, seconds, millis));

                try {
                    Thread.sleep(50);
                }
                catch (InterruptedException e) {}
            }
        }
    }

    public boolean isRunning() {
        return running;
    }

    public interface ChronometerRunner {
        void updateTimerText(final String time);
    }
}
