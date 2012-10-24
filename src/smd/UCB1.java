package smd;

import java.util.ArrayList;

public class UCB1 {

	int sltsSize;
	int[] sltsHit;
	int[] sltsPlayCount;
	double[] sltsScores;

	ArrayList<Slot> slots;

	public UCB1(ArrayList<Slot> slts) {
		this.slots = slts;

		this.sltsSize = slots.size()-1;

		this.sltsHit = new int[sltsSize];
		this.sltsPlayCount = new int[sltsSize];
		this.sltsScores = new double[sltsSize];
		init();
	}


	private void init() {
		for(int i = 0;i < sltsSize;i++){
			sltsHit[i]=0;
			sltsPlayCount[i]=1;
			sltsScores[i] = sltsHit[i]/sltsPlayCount[i]+Math.sqrt(sltsPlayCount[i]);
		}
	}


	public int play() {
		int num = 0;
		int max = 0;
		for(int i = 0;i < sltsSize;i++){
			if(max < sltsScores[i]){
				num = i;
			}
		}
		int score = slots.get(num).play();
		sltsPlayCount[num]++;
		sltsHit[num]++;

		for(int i = 0;i < sltsSize;i++){
			sltsScores[i] = sltsHit[i]/sltsPlayCount[i]+Math.sqrt(sltsPlayCount[i]);
		}

		return score;

	}

}
