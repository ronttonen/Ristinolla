package ristinolla;

import java.util.Scanner;
import java.util.InputMismatchException;

public class main{
	private static Scanner lu = new Scanner(System.in);
	public static void main(String[] args) {
		
		// define variables
		int gametype = 0;
		String p1 = null;
		String p2 = null;
		
		//gametype must be defined 
		do{
			try { // single or multiplayer
				p("Yksin(1) vai kaksinpeli(2), syötä 1 tai 2");
				gametype = lu.nextInt();
				if (gametype == 1){
					p1 = "bot";
				}
			}
			catch(InputMismatchException e){
				break;
			}
		}
		while(gametype == 1 && gametype == 2);
		
		//Player 1 name always needed
		do{
			try { //p1 name
				p("Pelaajan 1 nimi");
				p1 = lu.next();
			}
			catch(InputMismatchException e){
				break;
			}
		}
		while (p1 == null);
		//get player 2 name if needed
		if (gametype == 2 && p1 != null){
			do {
				try { //p2 name
					p("Pelaajan 2 nimi");
					p2 = lu.next();
				}
				catch(InputMismatchException e){
					break;
				}
			}
			while (p2 == null);
		}
		
		
		int turn = 0;
		int win = 0;
		int a = 0;
		botDance(1, 250); // LOOPS, WAIT
		char[] taulu = new char[9]; 
		for (int i=0;i<taulu.length;i++){
				a = i+1;
				taulu[i] = Character.forDigit(a, 10);			
		}
		int turn_count = 0;
		do {
			clear();
			tulostaTaulu(taulu);
			win = checkWin(taulu);
			p(win + " ");
			if (win == 1){
				p("X VOITTI");
				victoryDance(p1);
				turn = 2;
			}
			else if(win == 2){
				p("O VOITTI");
				victoryDance(p2);
				turn = 2;
			}
			else if(win == 3){
				p("TASAPELI");
				turn = 2;
			}
			else if (win == 0){
				if (turn == 0 && win == 0){
					do{
						
						p("Pelaajan X vuoro syötä 1-9");
						int sy;
						try{
							sy = lu.nextInt(); // TRY CATCH
						}
						catch(InputMismatchException e){
							break;
						}					
						if (sy > 9 || sy < 1){
							break;
						}
						if (taulu[sy-1] != 'X' && taulu[sy-1] != 'O'){
							taulu[sy-1] = 'X';
							turn = 1;
						}
					}
					while (turn == 0);
				}
				else {
					if (gametype == 2 && win == 0){
						do{
							p("Pelaajan O vuoro syötä 1-9");
							int sy;
							try{
								sy = lu.nextInt(); // TRY CATCH
							}
							catch(InputMismatchException e){
								break;
							}
							if (sy > 9 || sy < 1){
								break;
							}
							if (taulu[sy-1] != 'X' && taulu[sy-1] != 'O'){
								taulu[sy-1] = 'O';
								turn = 0;
							}
						}
						while(turn == 1);
					}
					else if (gametype == 1 && turn == 1 && win == 0){
						wait(750);
						clear();
						tulostaTaulu(taulu);
						botPelaa(taulu);
						turn = 0;
					}
				}
				win = checkWin(taulu);
				if (win == 1){
					p("X VOITTI");
					victoryDance(p1);
					turn = 2;
				}
				else if(win == 2){
					p("O VOITTI");
					victoryDance(p2);
					turn = 2;
				}
				else if(win == 3){
					p("TASAPELI");
					turn = 2;
				}
			}
		}
		while(win == 0);
		clear();
		tulostaTaulu(taulu);
		if (win == 1){
			p("X VOITTI");
		}
		else if(win == 2){
			p("O VOITTI");
		}
		else if(win == 3){
			p("TASAPELI");
		}
	}
	
	/*FUNCTIONS START*/
	public static void wait(int mil){
		try{
			Thread.sleep(mil);
		}
		catch(InterruptedException ie){
			
		}
	}
	public static void clear(){
		for(int i = 0; i < 25;i++){
		p("");	
		}
	}
	public static void p(String a){
		System.out.println(a);
	}
	public static void botDance(int loops, int wait){
		for (int i=0;i<loops;i++){
			wait(wait);
			clear();
			p("\\[^.^]/");
			wait(wait);
			clear();
			p("_[^.^]|");
			wait(wait);
			clear();
			p("\\[^.^]/");
			wait(wait);
			clear();
			p("|[^.^]_");
		}
	}
	public static void tulostaTaulu(char[] t){
		
		p("-------------");
		p("| " + t[0] + " | " + t[1] + " | " + t[2] + " |");
		p("-------------");
		p("| " + t[3] + " | " + t[4] + " | " + t[5] + " |");
		p("-------------");
		p("| " + t[6] + " | " + t[7] + " | " + t[8] + " |");
		p("-------------");
		
	}
	public static int checkWin(char[] taulu){
		  if (	(taulu[0] == 'X' && taulu[1] == 'X' && taulu[2] == 'X') || 
				(taulu[3] == 'X' && taulu[4] == 'X' && taulu[5] == 'X') || 
				(taulu[6] == 'X' && taulu[7] == 'X' && taulu[8] == 'X') || 
				(taulu[0] == 'X' && taulu[4] == 'X' && taulu[8] == 'X') || 
				(taulu[6] == 'X' && taulu[4] == 'X' && taulu[2] == 'X') || 
				(taulu[0] == 'X' && taulu[3] == 'X' && taulu[6] == 'X') || 
				(taulu[1] == 'X' && taulu[4] == 'X' && taulu[7] == 'X') || 
				(taulu[2] == 'X' && taulu[5] == 'X' && taulu[8] == 'X')) {
			  		// X 
			  	return 1;

	        } else if ((taulu[0] == 'O' && taulu[1] == 'O' && taulu[2] == 'O') || 
					(taulu[3] == 'O' && taulu[4] == 'O' && taulu[5] == 'O') || 
					(taulu[6] == 'O' && taulu[7] == 'O' && taulu[8] == 'O') || 
					(taulu[0] == 'O' && taulu[4] == 'O' && taulu[8] == 'O') || 
					(taulu[6] == 'O' && taulu[4] == 'O' && taulu[2] == 'O') || 
					(taulu[0] == 'O' && taulu[3] == 'O' && taulu[6] == 'O') || 
					(taulu[1] == 'O' && taulu[4] == 'O' && taulu[7] == 'O') || 
					(taulu[2] == 'O' && taulu[5] == 'O' && taulu[8] == 'O')) {
	            // O WINS
	        	return 2;
	        } else if (taulu[0] != '1' && taulu[1] != '2' && taulu[2] != '3' && taulu[3] != '4' && taulu[4] != '5'
	                && taulu[5] != '6' && taulu[6] != '7' && taulu[7] != '8' && taulu[8] != '9') {
	        	// DRAW
	        	return 3;
	        }
	        else {
	        	return 0;
	        }

	}
	
	//botPelaa palauttaa numeron 0-9 mihin ruutuun se laittaa arvon
	public static int botPelaa(char[] t){
		// BOT always O
		if (t[5] != 'X' && t[5] != 'O'){
			return (int) 5;
		}
		return 0;
		
	}
	
	public static void victoryDance(String p){
		for (int i=0;i<50;i++){
			for (int a=0;a<i;a++){
				System.out.print("-");
			}
			System.out.print(p + " Voitti!");
			for (int b=50;b>i;b--){
				System.out.print("-");
			}
			wait(100);
			clear();
		}
	}
	
}
