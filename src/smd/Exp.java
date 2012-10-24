package smd;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Exp {

	final static int sltCount = 40;
	final static int money = 1000;

	public static void main(String[] args) throws InterruptedException, IOException{
		File export = new File("export.txt");
		FileWriter fw = new FileWriter(export);

		ArrayList<Slot> slts = makeSlots(sltCount);

		UCB1 UCB1 = new UCB1(slts);

		int scoreRan = money;;
		int scoreUCB = money;

		System.out.println("Random   vs   UCB1");
		Thread.sleep(5000);

		for(int i = 0;i< money;i++){
			scoreRan = scoreRan -1 + random(slts);
			scoreUCB = scoreUCB -1 + UCB1.play();

//			if(i % 100 == 1){
				fw.write(scoreRan + "," + scoreUCB + "\r\n");
				System.out.println(scoreRan + "\t" + scoreUCB);
//			}
		}
		fw.close();
	}


	private static int random(ArrayList<Slot> slts) {
		Random rnd = new Random();
		int ran = rnd.nextInt(sltCount);
		return slts.get(ran).play();
	}

	private static ArrayList<Slot> makeSlots(int sltCount) {
		int i = 0;
		ArrayList<Slot> slts = new ArrayList<Slot>();
		while(i < sltCount){
			slts.add(new Slot(i));
			i++;
		}
		return slts;
	}

}
