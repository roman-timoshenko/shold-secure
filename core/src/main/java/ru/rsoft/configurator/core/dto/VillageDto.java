package ru.rsoft.configurator.core.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import ru.rsoft.configurator.core.entity.User;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Created by Admin on 22.11.2015.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class VillageDto {
    private final Integer id;
//    private final int userId;
    @Nullable
    private final Integer playerId;
    @Nullable
    private final String name;
    @Nonnull
    private final Integer idInWorld;

    public VillageDto() {
        this(0, 0, "", 0);
    }

    public VillageDto(Integer id, @Nullable Integer playerId, @Nullable String name,
                       @Nonnull Integer idInWorld) {
        this.id = id;
        this.playerId = playerId;
        this.name = name;
        this.idInWorld = idInWorld;
    }

    public Integer getId() {
        return id;
    }

    @Nullable
    public Integer getPlayerId() {
        return playerId;
    }

    @Nullable
    public String getName() {
        return name;
    }

    @Nonnull
    public Integer getIdInWorld() {
        return idInWorld;
    }


    @Override
    public String toString() {
        return "VillageDto{" +
                "id=" + id +
                ", playerId=" + playerId +
                ", name=" + name +
                ", idInWorld='" + idInWorld + '\'' +
                '}';
    }
}