package ru.rsoft.configurator.backend.handlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import ru.rsoft.configurator.core.dto.UserDto;
import ru.rsoft.configurator.core.dto.VillageCreateDto;
import ru.rsoft.configurator.core.dto.VillageDto;
import ru.rsoft.configurator.core.entity.Player;
import ru.rsoft.configurator.core.entity.User;
import ru.rsoft.configurator.core.entity.Village;
import ru.rsoft.configurator.core.repository.PlayerRepository;
import ru.rsoft.configurator.core.repository.VillageRepository;


import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.lang.reflect.Array;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Admin on 22.11.2015.
 */

@Component
@Path("/village")
public class VillageHandler {

    private final PlayerRepository playerRepository;
    private final VillageRepository villageRepository;


    @Autowired
    public VillageHandler(PlayerRepository playerRepository, VillageRepository villageRepository) {
        this.playerRepository = playerRepository;
        this.villageRepository = villageRepository;
    }

    @Path("/")
    @GET
    public List<VillageDto> list()  {
        return villageRepository.findAll().stream().map(this::convert)
                .collect(Collectors.toList());
    }

    @Path("/{id}")
    @GET
    public VillageDto get(@PathParam("id") Integer id) {
        return convert(requireNotNull(villageRepository.findOne(id)));
    }

/*
    @Path("/{user}")
    @GET
    public List<VillageDto> get(@PathParam("user") Integer user) {
//        int num;
//        final Set<User> i = userRepository.findByLogin(user);
        //num = Integer.parseInt(user);

        return villageRepository.findByUserId(user).stream().map(this::convert)
                .collect(Collectors.toList());
    }
*/

    @Path("/")
    @POST
    public VillageDto add(@RequestBody VillageCreateDto villageCreateDto) {
        return convert(villageRepository.save(convert(villageCreateDto)));
    }

    @Path("/{id}")
    @DELETE
    public void delete(@PathParam("id") int id) {
        try {
            villageRepository.delete(id);
        } catch (EmptyResultDataAccessException e) {
            // надо возвращать 404, если нет такого ресурса
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
    }

    private <T> T requireNotNull(T object) {
        if (object == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return object;
    }

    private VillageDto convert(Village village) {
//        if (village.getUser() == null) { userRepository.findOne(1);}
        return new VillageDto(
                village.getId(),
//                village.getUser().getId(),
                village.getPlayer() == null ? null : village.getPlayer().getId(),

//                village.getBody() == null ? null : village.getBody().getId(),
                village.getName(),
                village.getIdInWorld()
        );
    }
    private Village convert(VillageCreateDto villageCreateDto) {
//        User user = requireNotNull(userRepository.findOne(villageCreateDto.getUserId()));
        /**
         * Что будет, если user не объявлять как final?
         */
        Player player = playerRepository.findOne(villageCreateDto.getPlayerId());

        if (player == null){player = (playerRepository.findOne(1));}
        return new Village(
                player,
                villageCreateDto.getName(),
                villageCreateDto.getIdInWorld()
        );
    }
}