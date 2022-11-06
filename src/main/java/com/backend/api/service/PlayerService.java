package com.backend.api.service;

import com.backend.api.exception.PlayerExistException;
import com.backend.api.model.ExceptionModel;
import com.backend.api.model.PlayerModel;
import com.backend.api.repository.PlayerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@Service
public class PlayerService {
    private final PlayerRepository playerRepository;
    public List<PlayerModel> getAllPlayers() {
        return playerRepository.findAll();
    }

    public PlayerModel create(PlayerModel player) throws Exception {
        PlayerModel p = playerRepository.findByName(player.getName());
        if(!Objects.isNull(p)) {
            throw new PlayerExistException(ExceptionModel.builder().msg("Player already exist").build());
        }
        return playerRepository.insert(player);
    }


}
