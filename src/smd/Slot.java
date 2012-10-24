package smd;

public class Slot {
	int num;
	double rate = 0;

	public Slot(int num){
		this.num = num;
		this.rate = 0.02*num;
	}

	public int play() {
		if(Math.random() < rate){
			return 2;
		} else {
			return 0;
		}
	}

}
