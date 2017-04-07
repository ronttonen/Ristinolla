package ristinolla;

import java.util.Scanner;
import java.util.InputMismatchException;

public class main{
	private static Scanner lu = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		p("Mikä on nimesi");
		String name = lu.nextLine();
		int turn = 0;
		int win = 0;
		botDance(1, 250); // LOOPS, WAIT
		char[] taulu = new char[9]; 
		for (int i=0;i<taulu.length;i++){
				int a = i+1;
				taulu[i] = Character.forDigit(a, 10);			
		}
		int turn_count = 0;
		do {
			win = checkWin(taulu);
			if (a == 1){
				p("X VOITTI");
				
			}
			else if(a == 2){
				p("O VOITTI");
			}
			else if(a == 3){
				p("TASAPELI");
			}
			else{
				if (turn == 0){
					do{
						clear();
						tulostaTaulu(taulu);
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
					do{
						clear();
						tulostaTaulu(taulu);
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
				turn_count++;
				if (turn_count==8){
					win = 1;
				}
			}
		}
		while(win == 0);
		clear();
		tulostaTaulu(taulu);
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
		  if ((taulu[0] == 'X' && taulu[1] == 'X' &&
	                taulu[2] == 'X') || (taulu[0] == 'X' && taulu[5] == 'X' &&
	                taulu[8] == 'X') || (taulu[0] == 'X' && taulu[3] == 'X' &&
	                taulu[7] == 'X') || (taulu[0] == 'X' && taulu[4] == 'X' &&
	                taulu[6] == 'X') || (taulu[1] == 'X' && taulu[3] == 'X' &&
	                taulu[6] == 'X') || (taulu[2] == 'X' && taulu[4] == 'X' &&
	                taulu[7] == 'X') || (taulu[3] == 'X' && taulu[5] == 'X' &&
	                taulu[4] == 'X') || (taulu[6] == 'X' && taulu[8] == 'X' &&
	                taulu[7] == 'X')) {
			  		// X 
			  	return 1;

	        } else if ((taulu[0] == 'O' && taulu[1] == 'O' &&
	                taulu[2] == 'O') || (taulu[0] == 'O' && taulu[5] == 'O' &&
	                taulu[8] == 'O') || (taulu[0] == 'O' && taulu[3] == 'O' &&
	                taulu[7] == 'O') || (taulu[0] == 'O' && taulu[4] == 'O' &&
	                taulu[6] == 'O') || (taulu[1] == 'O' && taulu[3] == 'O' &&
	                taulu[6] == 'O') || (taulu[2] == 'O' && taulu[4] == 'O' &&
	                taulu[7] == 'O') || (taulu[3] == 'O' && taulu[5] == 'O' &&
	                taulu[4] == 'O') || (taulu[6] == 'O' && taulu[8] == 'O' &&
	                taulu[7] == 'O')) {
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
}
