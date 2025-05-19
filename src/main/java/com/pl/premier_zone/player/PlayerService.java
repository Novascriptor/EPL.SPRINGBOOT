package com.pl.premier_zone.player;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    // Finding All Players
    public List<Player> getPlayers() {
        return playerRepository.findAll();
    }

    // Finding Players from a Specific Team
    public List<Player> getPlayersFromTeam(String teamName) {
        return playerRepository.findAll().stream()
                .filter(player -> teamName.equals(player.getTeam()))
                .collect(Collectors.toList());
    }

     // Getting Players by Name
    public List<Player> getPlayersByName(String searchText) {
        return playerRepository.findAll().stream()
                .filter(player -> player.getPlayer().toLowerCase().contains(searchText.toLowerCase()))
                .collect(Collectors.toList());
    }

    // Getting Players by Position
    public List<Player> getPlayersByPosition(String searchText) {
        return playerRepository.findAll().stream()
                .filter(player -> player.getPos().toLowerCase().contains(searchText.toLowerCase()))
                .collect(Collectors.toList());
    }
    //GETTING PLAYERS BY TEAM AND POSITION
    public List<Player>getPLayersByTeamAndPos(String team, String position){
        return playerRepository.findAll().stream()
        .filter(player ->team.equals(player.getTeam()) && position.equals(player.getPos()))
        .collect(Collectors.toList());
    }

    //GET BY TEAM AND NATION
    public List<Player> getPlayersByTeamAndNation(String team, String nation) {
        return playerRepository.findByTeamAndNation(team, nation);
    }
    

      // Getting player by name and team
      public Optional<Player> getPlayerByNameAndTeam(String playerName, String teamName) {
        return playerRepository.findByPlayerAndTeam(playerName, teamName);
    }

       //GETTING PLAYERS BY THEIR NATIONS
       public List<Player>getPlayersByNation(String searchText){
        return playerRepository.findAll().stream()
        .filter(player ->player.getNation().toLowerCase().contains(searchText.toLowerCase()))
        .collect(Collectors.toList());  
    }

        //ADDING PLAYERS TO DB
        public Player addPlayer(Player player){
            playerRepository.save(player);
            return player;
        }
    

    // Updating a Player
    public Player updatePlayer(Player player) {
        Optional<Player> existingPlayer = playerRepository.findByPlayer(player.getPlayer());

        if (existingPlayer.isPresent()) {
            Player playerToUpdate = existingPlayer.get();
            playerToUpdate.setPlayer(player.getPlayer());
            playerToUpdate.setTeam(player.getTeam());
            playerToUpdate.setPos(player.getPos());
            playerToUpdate.setNation(player.getNation());

            playerRepository.save(playerToUpdate);
            return playerToUpdate;
        }
        return null;
    }

    @Transactional
    public String deletePlayer(String player) {
        Optional<Player> existingPlayer = playerRepository.findByPlayer(player);

        if (existingPlayer.isPresent()) {
            playerRepository.deleteByPlayer(player);
            return "Player deleted successfully.";
        } else {
            return "Player not found.";
        }
    }
}
