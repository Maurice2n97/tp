package seedu.address.model.meeting;

import static seedu.address.commons.util.AppUtil.checkArgument;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import seedu.address.model.group.Group;

/**
 * Represents a meeting in MeetBuddy.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Meeting {

    public static final String MESSAGE_CONSTRAINTS =
            "The start date time of a meeting should be strictly earlier than the terminate date time.";

    // Identity fields
    private final MeetingName meetingName;
    private final DateTime start;
    private final DateTime terminate;

    // Data fields
    private final Priority priority;
    private final Description description;
    private final Set<Group> groups = new HashSet<>();

    /**
     * Every field must be present and not null.
     */
    public Meeting(MeetingName meetingName, DateTime start, DateTime terminate, Priority priority,
                   Description description, Set<Group> groups) {
        requireAllNonNull(meetingName, start, terminate, priority, description, groups);
        checkArgument(isValidStartTerminate(start, terminate), MESSAGE_CONSTRAINTS);
        this.meetingName = meetingName;
        this.start = start;
        this.terminate = terminate;
        this.priority = priority;
        this.description = description;
        this.groups.addAll(groups);
    }

    public MeetingName getName() {
        return meetingName;
    }

    public DateTime getStart() {
        return start;
    }

    public DateTime getTerminate() {
        return terminate;
    }

    public Priority getPriority() {
        return priority;
    }

    public Description getDescription() {
        return description;
    }

    /**
     * Returns an immutable group set, which throws {@code UnsupportedOperationException}
     * if modification is attempted.
     */
    public Set<Group> getGroups() {
        return Collections.unmodifiableSet(groups);
    }

    /**
     * Returns true if both meetings have the same meetingName, start and terminate time. (Use identify fields only)
     * This defines a weaker notion of equality between two meetings.
     */
    public boolean isSameMeeting(Meeting otherMeeting) {
        if (otherMeeting == this) {
            return true;
        }

        return otherMeeting != null
                && otherMeeting.getName().equals(getName())
                && otherMeeting.getStart().equals(getStart())
                && otherMeeting.getTerminate().equals(getTerminate());
    }



    /**
     * Returns true if a given date time for the meeting is valid.
     */
    public static boolean isValidStartTerminate(DateTime start, DateTime terminate) {
        return start.compareTo(terminate) == -1;
    }

    /**
     * Returns true if both meetings have the same identity and data fields.
     * This defines a stronger notion of equality between two meetings.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Meeting)) {
            return false;
        }

        Meeting otherMeeting = (Meeting) other;
        return otherMeeting.getName().equals(getName())
                && otherMeeting.getStart().equals(getStart())
                && otherMeeting.getTerminate().equals(getTerminate())
                && otherMeeting.getPriority().equals(getPriority())
                && otherMeeting.getDescription().equals(getDescription())
                && otherMeeting.getGroups().equals(getGroups());
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(meetingName, start, terminate, priority, description, groups);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getName())
                .append("; Start: ")
                .append(getStart())
                .append("; Terminate: ")
                .append(getTerminate())
                .append("; Priority: ")
                .append(getPriority())
                .append("; Description: ")
                .append(getDescription());

        Set<Group> groups = getGroups();
        if (!groups.isEmpty()) {
            builder.append("; Groups: ");
            groups.forEach(builder::append);
        }
        return builder.toString();
    }

}
