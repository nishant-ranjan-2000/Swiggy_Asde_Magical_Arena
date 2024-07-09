package com.SwiggyRound1.MagicalArena;

import java.util.Random;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.SwiggyRound1.MagicalArena.entity.Player;

@SpringBootApplication
public class MagicalArenaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MagicalArenaApplication.class, args);
		Random random = new Random();
		Player player1=new Player(50,15,10);
		Player player2=new Player(100,10,5);
		while(player1.getHealth()>0&&player2.getHealth()>0) {
			int attack = random.nextInt(6) + 1;
			int deffender = random.nextInt(6) + 1;
			if(player1.getHealth()<player2.getHealth()) {
				int excessDamage=(player1.getAttack()*attack)-(player2.getStrength()*deffender);
				player2.setHealth(player2.getHealth()-Math.max(excessDamage, 0));
			}
			else {
				int excessDamage=(player2.getAttack()*attack)-(player1.getStrength()*deffender);
				player1.setHealth(player1.getHealth()-Math.max(excessDamage, 0));
			}
		}
		System.out.println("===============================RESULT==============================================");
		System.out.println("===============================RESULT==============================================");
		System.out.println();
		if(player1.getHealth()<=0) {
			System.out.println("Player2 Wins!!");
		}
		else if(player2.getHealth()<=0) {
			System.out.println("Player1 Wins!!");
		}
		else {
			System.out.println("Result Tie!!");
		}
	}

}
