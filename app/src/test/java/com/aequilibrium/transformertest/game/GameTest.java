package com.aequilibrium.transformertest.game;

import com.aequilibrium.transformertest.model.TransfomerEntity;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class GameTest {

    Game game=null;
    int res=0;
    @Before
    public void prepare(){
        game = new Game(new BattleStrategySimple());
    }

    @Test
    public void battle01(){
        TransfomerEntity a1=new TransfomerEntity();
        TransfomerEntity a2=new TransfomerEntity();
        TransfomerEntity d1=new TransfomerEntity();
        List<TransfomerEntity> list=new ArrayList();

        d1.setStrength(8);
        d1.setIntelligence(9);
        d1.setSpeed(2);
        d1.setEndurance(6);
        d1.setRank(7);
        d1.setCourage(5);
        d1.setFirepower(6);
        d1.setSkill(10);
        d1.setTeam("D");
        d1.setName("Soundwave");
        d1.setId("1");

        a1.setStrength(6);
        a1.setIntelligence(6);
        a1.setSpeed(7);
        a1.setEndurance(9);
        a1.setRank(5);
        a1.setCourage(2);
        a1.setFirepower(9);
        a1.setSkill(7);
        a1.setTeam("A");
        a1.setName("Bluestreak");
        a1.setId("2");

        a2.setStrength(4);
        a2.setIntelligence(4);
        a2.setSpeed(4);
        a2.setEndurance(4);
        a2.setRank(4);
        a2.setCourage(4);
        a2.setFirepower(4);
        a2.setSkill(4);
        a2.setTeam("A");
        a2.setName("Hubcap");
        a2.setId("3");


        list.add(a1);
        list.add(a2);
        list.add(d1);
        GameResult result=game.battle(list);
        assertEquals(1,result.getBattle_count());
        assertEquals("Decepticons",result.getWinning_team());
        List<TransfomerEntity> survivorList=result.getSurvivors();
        assertEquals(1,survivorList.size());
        assertEquals("Hubcap",survivorList.get(0).getName());
    }

    @Test
    public void battle02() {
        TransfomerEntity d1 = new TransfomerEntity();
        TransfomerEntity a1 = new TransfomerEntity();
        d1.setStrength(8);
        d1.setIntelligence(9);
        d1.setSpeed(2);
        d1.setEndurance(6);
        d1.setRank(7);
        d1.setCourage(5);
        d1.setFirepower(6);
        d1.setSkill(10);
        d1.setTeam("D");

        d1.setId("1");

        a1.setStrength(6);
        a1.setIntelligence(6);
        a1.setSpeed(7);
        a1.setEndurance(9);
        a1.setRank(5);
        a1.setCourage(2);
        a1.setFirepower(9);
        a1.setSkill(7);
        a1.setTeam("A");

        a1.setId("2");

        List<TransfomerEntity> list=new ArrayList();
        d1.setName("Optimus Prime");
        a1.setName("Predaking");
        list.clear();
        list.add(d1);
        list.add(a1);
        GameResult result=game.battle(list);
        assertEquals(true,result.isGameOver());


    }


    @Test
    public void battle03() {
        TransfomerEntity d1 = new TransfomerEntity();
        TransfomerEntity a1 = new TransfomerEntity();
        d1.setStrength(8);
        d1.setIntelligence(9);
        d1.setSpeed(2);
        d1.setEndurance(6);
        d1.setRank(7);
        d1.setCourage(5);
        d1.setFirepower(6);
        d1.setSkill(10);
        d1.setTeam("D");

        d1.setId("1");

        a1.setStrength(6);
        a1.setIntelligence(6);
        a1.setSpeed(7);
        a1.setEndurance(9);
        a1.setRank(5);
        a1.setCourage(2);
        a1.setFirepower(9);
        a1.setSkill(7);
        a1.setTeam("A");

        a1.setId("2");


        List<TransfomerEntity> list=new ArrayList();
        d1.setName("Optimus Prime");
        a1.setName("Optimus Prime");
        list.clear();
        list.add(d1);
        list.add(a1);
        GameResult result=game.battle(list);
        assertEquals(true,result.isGameOver());


    }

    @Test
    public void battle04() {
        TransfomerEntity d1 = new TransfomerEntity();
        TransfomerEntity a1 = new TransfomerEntity();
        d1.setStrength(8);
        d1.setIntelligence(9);
        d1.setSpeed(2);
        d1.setEndurance(6);
        d1.setRank(7);
        d1.setCourage(5);
        d1.setFirepower(6);
        d1.setSkill(10);
        d1.setTeam("D");

        d1.setId("1");

        a1.setStrength(6);
        a1.setIntelligence(6);
        a1.setSpeed(7);
        a1.setEndurance(9);
        a1.setRank(5);
        a1.setCourage(2);
        a1.setFirepower(9);
        a1.setSkill(7);
        a1.setTeam("A");

        a1.setId("2");

        List<TransfomerEntity> list=new ArrayList();
        d1.setName("Predaking");
        a1.setName("Predaking");
        list.clear();
        list.add(d1);
        list.add(a1);
        GameResult result=game.battle(list);
        assertEquals(true,result.isGameOver());


    }

    @Test
    public void battle05() {
        TransfomerEntity d1 = new TransfomerEntity();
        TransfomerEntity a1 = new TransfomerEntity();
        d1.setStrength(8);
        d1.setIntelligence(9);
        d1.setSpeed(2);
        d1.setEndurance(6);
        d1.setRank(7);
        d1.setCourage(5);
        d1.setFirepower(6);
        d1.setSkill(10);
        d1.setTeam("D");

        d1.setId("1");

        a1.setStrength(6);
        a1.setIntelligence(6);
        a1.setSpeed(7);
        a1.setEndurance(9);
        a1.setRank(5);
        a1.setCourage(2);
        a1.setFirepower(9);
        a1.setSkill(7);
        a1.setTeam("A");

        a1.setId("2");

        List<TransfomerEntity> list=new ArrayList();

        d1.setName("Predaking test");
        a1.setName("Predaking");
        list.clear();
        list.add(d1);
        list.add(a1);
        GameResult result=game.battle(list);
        assertEquals(false,result.isGameOver());


    }

    @Test
    public void battle06() {
        TransfomerEntity d1 = new TransfomerEntity();
        TransfomerEntity a1 = new TransfomerEntity();
        d1.setStrength(8);
        d1.setIntelligence(9);
        d1.setSpeed(2);
        d1.setEndurance(6);
        d1.setRank(7);
        d1.setCourage(5);
        d1.setFirepower(6);
        d1.setSkill(10);
        d1.setTeam("D");

        d1.setId("1");

        a1.setStrength(6);
        a1.setIntelligence(6);
        a1.setSpeed(7);
        a1.setEndurance(9);
        a1.setRank(5);
        a1.setCourage(2);
        a1.setFirepower(9);
        a1.setSkill(7);
        a1.setTeam("A");

        a1.setId("2");

        List<TransfomerEntity> list=new ArrayList();

        d1.setName("Predaking");
        a1.setName("Predaking Test");
        list.clear();
        list.add(d1);
        list.add(a1);
        GameResult result=game.battle(list);
        assertEquals(false,result.isGameOver());
    }
}
