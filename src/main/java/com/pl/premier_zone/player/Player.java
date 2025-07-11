package com.pl.premier_zone.player;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "premierleaguestats")
public class Player {
    
    @Column(name = "Player", unique=true)
     @Id
    private String player;

    @Column(name = "Nation")
    private String nation;

    @Column(name = "Pos")
    private String pos;

    @Column(name = "Age")
    private Integer age;

    @Column(name = "MP")
    private Integer mp;

    @Column(name = "Starts")
    private Integer starts;

    @Column(name = "Min")
    private Double min;

    @Column(name = "Gls")
    private Double gls;

    @Column(name = "Ast")
    private Double ast;

    @Column(name = "PK")
    private Double pk;

    @Column(name = "CrdY")
    private Double crdy;

    @Column(name = "CrdR")
    private Double crdr;

    @Column(name = "xG")
    private Double xg;

    @Column(name = "xAG")
    private Double xag;

    @Column(name = "Team")
    private String team;

    //DEFAULT CONSTRUCTOR
    public Player() {
    }

//PARAMETERISED CONSTRUCTORS
    public Player(String player, String nation, String pos, Integer age, Integer mp, Integer starts, Double min,
            Double gls, Double ast, Double pk, Double crdy, Double crdr, Double xg, Double xag, String team) {
        this.player = player;
        this.nation = nation;
        this.pos = pos;
        this.age = age;
        this.mp = mp;
        this.starts = starts;
        this.min = min;
        this.gls = gls;
        this.ast = ast;
        this.pk = pk;
        this.crdy = crdy;
        this.crdr = crdr;
        this.xg = xg;
        this.xag = xag;
        this.team = team;
    }

    //CONSTRUCTORS WITH SPECIFIC VARIABLE
    public Player(String player) {
        this.player = player;
    }
    //GETTERS AND SETTERS (SOURCE ACTION)

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getMp() {
        return mp;
    }

    public void setMp(Integer mp) {
        this.mp = mp;
    }

    public Integer getStarts() {
        return starts;
    }

    public void setStarts(Integer starts) {
        this.starts = starts;
    }

    public Double getMin() {
        return min;
    }

    public void setMin(Double min) {
        this.min = min;
    }

    public Double getGls() {
        return gls;
    }

    public void setGls(Double gls) {
        this.gls = gls;
    }

    public Double getAst() {
        return ast;
    }

    public void setAst(Double ast) {
        this.ast = ast;
    }

    public Double getPk() {
        return pk;
    }

    public void setPk(Double pk) {
        this.pk = pk;
    }

    public Double getCrdy() {
        return crdy;
    }

    public void setCrdy(Double crdy) {
        this.crdy = crdy;
    }

    public Double getCrdr() {
        return crdr;
    }

    public void setCrdr(Double crdr) {
        this.crdr = crdr;
    }

    public Double getXg() {
        return xg;
    }

    public void setXg(Double xg) {
        this.xg = xg;
    }

    public Double getXag() {
        return xag;
    }

    public void setXag(Double xag) {
        this.xag = xag;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }



}