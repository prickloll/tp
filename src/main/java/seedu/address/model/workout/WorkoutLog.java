package seedu.address.model.workout;

import java.util.Objects;
import java.time.LocalDateTime;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.model.person.Location;
import seedu.address.model.person.Person;

public class WorkoutLog {
    
    private final Person trainee;
    private final LocalDateTime time;
    private final Location location;

    public WorkoutLog(Person trainee, LocalDateTime time, Location location) {
        this.trainee = trainee;
        this.time = time;
        this.location = location;
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
