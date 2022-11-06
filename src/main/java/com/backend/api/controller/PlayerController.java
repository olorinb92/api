package com.backend.api.controller;

import com.backend.api.helper.JsonHelper;
import com.backend.api.service.PlayerService;
import com.backend.api.model.PlayerModel;
import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;

@RestController
@RequestMapping("api/v1/players")
@AllArgsConstructor
public class PlayerController {
    private final Gson gson;
    private final PlayerService playerService;

    @GetMapping
    public List<PlayerModel> fetchAllPlayers() {
        return playerService.getAllPlayers();
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> createPlayer(@RequestBody PlayerModel player) {
        PlayerModel createdPlayer = null;
        try {
            player.setCreatedAt(LocalDateTime.now().atZone(ZoneOffset.UTC).toLocalDateTime());
            createdPlayer = playerService.create(player);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }

        return new ResponseEntity<>(JsonHelper.parse(createdPlayer), HttpStatus.CREATED);
    }

}