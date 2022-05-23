package hust.soict.dsai.garbage;
import java.util.Random;
public class NoGarbage {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuffer s = new StringBuffer("abcdefghik123456789");
		Random r = new Random();
		for (int i = 0; i < 1e8; i++) {
			s.append(s.charAt(r.nextInt(s.length())));
		}
		System.out.println("Finish");
	}
}
