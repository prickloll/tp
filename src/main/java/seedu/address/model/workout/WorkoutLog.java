package seedu.address.model.workout;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.time.LocalDateTime;
import java.util.Objects;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.model.person.Location;
import seedu.address.model.person.Person;

/**
 * Represents a singular Workout Session.
 * Guarantees: immutable
 */
public class WorkoutLog {

    private final Person trainee;
    private final LocalDateTime time;
    private final Location location;

    /**
     * Constructs a WorkoutLog object. All fields must be non-null.
     * @param trainee Person that performed the workout
     * @param time Time during which the workout took place
     * @param location Location of the Gym at which the workout took place
     */
    public WorkoutLog(Person trainee, LocalDateTime time, Location location) {
        requireAllNonNull(trainee, time, location);
        this.trainee = trainee;
        this.time = time;
        this.location = location;
    }

    /**
     * Returns the Person that did the workout
     */
    public Person getTrainee() {
        return trainee;
    }

    /**
     * Returns the gym location where the workout took place
     */
    public Location getLocation() {
        return location;
    }

    /**
     * Returns the time during which the workout took place
     */
    public LocalDateTime getTime() {
        return time;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof WorkoutLog)) {
            return false;
        }

        WorkoutLog otherLog = (WorkoutLog) other;
        return trainee.equals(otherLog.trainee)
                && location.equals(otherLog.location)
                && time.equals(otherLog.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(trainee, location, time);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("trainee", trainee)
                .add("location", location)
                .add("time", time)
                .toString();
    }

}
