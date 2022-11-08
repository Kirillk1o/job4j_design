package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        byte age = 27;
        char sex = 'M';
        double weight = 84.5;
        boolean learning = true;
        float growth = 1.85f;
        long file = 11225;
        short amountStepsPerDay = 10000;
        int programmsDay = 119;
        LOG.debug("User info : age : {}, sex : {}, weight : {}, "
                + "learning : {}, growth : {}, file : {}, amountStepsPerDay : {}, programmsDay : {}",
                age, sex, weight, learning, growth, file, amountStepsPerDay, programmsDay);
    }
}
