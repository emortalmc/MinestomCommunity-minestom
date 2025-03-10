package net.minestom.server.entity.metadata.animal;

import net.minestom.server.entity.Entity;
import net.minestom.server.entity.Metadata;
import org.jetbrains.annotations.NotNull;

public class SnifferMeta extends AnimalMeta {
    public static final byte OFFSET = AnimalMeta.MAX_OFFSET;
    public static final byte MAX_OFFSET = OFFSET + 2;

    public SnifferMeta(@NotNull Entity entity, @NotNull Metadata metadata) {
        super(entity, metadata);
    }

    public @NotNull State getState() {
        return State.VALUES[super.metadata.getIndex(OFFSET, (byte) 0)];
    }

    public void setState(@NotNull State value) {
        super.metadata.setIndex(OFFSET, Metadata.Byte((byte) value.ordinal()));
    }

    public int getFinishingDigTime() {
        return super.metadata.getIndex(OFFSET + 1, 0);
    }

    public void setFinishingDigTime(int value) {
        super.metadata.setIndex(OFFSET + 1, Metadata.VarInt(value));
    }


    public enum State {
        IDLING,
        FEELING_HAPPY,
        SCENTING,
        SNIFFING,
        SEARCHING,
        DIGGING,
        RISING;

        private final static State[] VALUES = values();
    }
}
