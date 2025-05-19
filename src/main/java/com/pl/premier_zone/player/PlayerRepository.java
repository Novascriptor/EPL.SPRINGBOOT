package com.pl.premier_zone.player;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player, String> {

    void deleteByPlayer(String player);

    Optional<Player> findByPlayer(String player);
    Optional<Player> findByPlayerAndTeam(String playerName, String team);
    Optional<Player> findByTeamAndPos(String team, String pos);
   @Query("SELECT p FROM Player p WHERE LOWER(p.team) = LOWER(:team) AND LOWER(p.nation) = LOWER(:nation)")
   List<Player> findByTeamAndNation(@Param("team") String team, @Param("nation") String nation);



    

    
}
