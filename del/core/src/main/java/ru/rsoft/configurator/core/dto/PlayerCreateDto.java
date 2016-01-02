package ru.rsoft.configurator.core.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Created by Admin on 26.11.2015.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PlayerCreateDto {
    @Nonnull
    private final Integer playerId;
    @Nonnull
    private final String name;

    public PlayerCreateDto() {
        this(0, "");
    }

    public PlayerCreateDto(@Nonnull Integer playerId, @Nonnull String name) {
        this.playerId = playerId;
        this.name = name;
    }

    @Nonnull
    public Integer getPlayerId() {
        return playerId;
    }

    @Nonnull
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "PlayerCreateDto{" +
                "playerId=" + playerId +
                ", name='" + name + '\'' +
                '}';
    }
}
