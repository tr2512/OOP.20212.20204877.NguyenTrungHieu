package hust.soict.dsai.garbage;
import java.util.Random;
public class GarbageCollector {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = new String("abcdefghik123456789");
		Random r = new Random();
		for (int i = 0; i < 1e8; i++) {
			s += s.charAt(r.nextInt(s.length()));
		}
		System.out.println("Finish");
	}

}
