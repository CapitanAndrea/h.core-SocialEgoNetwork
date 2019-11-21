package contextualegonetwork;

/**
 * This class implements a generic interaction between two entities in a context. We assume that interactions
 * are not atomic, but rather events with a start time (modelled with a UNIX timestamp) and a duration, expressed in seconds.
 * This class is thought to be extended in order to model more specific events occurring between two entities,
 * e.g. messages, video-calls, commands (sent by a human entity to a smart object),...
 */
public final class Interaction {
    /**
     * When the interaction started
     */
    private long startTimestamp;
    /**
     * The number of seconds that elapse between the start time and the end time of the interaction
     */
    private int duration;
    /**
     * The interaction type
     */
    private String type;

    /**
     * Used in deserialization
     */
    protected Interaction()
    {}

    /**
     * Constructor method
     * @param timestamp The start timestamp
     * @param duration The duration of the interaction
     * @param type The type of the interaction
     * @throws IllegalArgumentException if timestamp or duration are less or equal than 0
     * @throws NullPointerException if type is null
     */
    protected Interaction(long timestamp, int duration, String type) {
        if(timestamp <= 0 || duration <= 0) throw new IllegalArgumentException();
        if(type == null) throw new NullPointerException();
        this.startTimestamp = timestamp;
        this.duration = duration;
        this.type = type;
    }

    /**
     * @return The timestamp that corresponds to the start of the interaction
     */
    public long getStartTime() {
        return this.startTimestamp;
    }
    
    /**
     * @return The timestamp that corresponds to the start of the interaction
     */
    public long getEndTime() {
        return this.startTimestamp + this.duration;
    }

    /**
     * @return The duration of the interaction
     */
    public int getDuration() {
        return this.duration;
    }

    /**
     * @return The type of this interaction
     */
    public String getType() {
        return this.type;
    }
}