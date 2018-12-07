package abc;

import java.util.concurrent.ThreadLocalRandom;

import javax.faces.bean.ManagedBean;

@ManagedBean(name = "abc")
public class abcController {
	
	private int random;

	public int getRandom() {
		return random;
	}

	public void setRandom(int random) {
		this.random = random;
	}

	public String toB() {
		random = ThreadLocalRandom.current().nextInt(0 , 1 +1);
		if(random == 0) {
			return "defeat";
		}
		return "b";
	}
	
	public String toC() {
		random = ThreadLocalRandom.current().nextInt(0 , 1 +1);
		if(random == 0) {
			return "defeat";
		}
		return "c";
	}

}
