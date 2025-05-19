package com.pl.premier_zone.player;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")// Allow frontend requests
@RequestMapping(path = "/api/v1/player")
public class PlayerController {

    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

   
    @GetMapping
    public List<Player> getPlayers(
            @RequestParam(required = false) String team,
            @RequestParam(required = false) String player,
            @RequestParam(required = false) String position,
            @RequestParam(required = false) String nation) {

          if (team !=null && position !=null){
            return playerService.getPLayersByTeamAndPos(team, position);
          }   
         if (team !=null && nation !=null){
            return playerService.getPlayersByTeamAndNation(team, nation);
          }
          if (player !=null && team !=null){
            Optional<Player> optionalPlayer = playerService.getPlayerByNameAndTeam(player, team);
return optionalPlayer.map(Collections::singletonList).orElse(Collections.emptyList());

          }

       
         if (team != null) {
            return playerService.getPlayersFromTeam(team);
        } else if (player != null) {
            return playerService.getPlayersByName(player);
        } else if (position != null) {
            return playerService.getPlayersByPosition(position);
        } else if (nation != null) {
            return playerService.getPlayersByNation(nation);
        } else {
            return playerService.getPlayers();
        }
    }

    // Add Player
    @PostMapping
    public ResponseEntity<Player> addPlayer(@RequestBody Player player) {
        Player createdPlayer = playerService.addPlayer(player);
        return new ResponseEntity<>(createdPlayer, HttpStatus.CREATED);
    }

    // Update Player
    @PutMapping()
    public ResponseEntity<Player> updatePlayer(@PathVariable String playerName, @RequestBody Player player) {
        Player updatedPlayer = playerService.updatePlayer(player);

        if (updatedPlayer != null) {
            return new ResponseEntity<>(updatedPlayer, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete Player
    @DeleteMapping("/{playerName}")
    public ResponseEntity<String> deletePlayer(@PathVariable String playerName) {
        String response = playerService.deletePlayer(playerName);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
