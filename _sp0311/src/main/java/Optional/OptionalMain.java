package Optional;

import java.util.Optional;

class Bbb{
	int x;
	public Bbb(int x) {
		this.x = x;
	}
	void print() {
		System.out.println("Bbb:" + x);
	}
}

class Aaa{
	void print(Bbb bb) {
		bb.print();
	}
}

public class OptionalMain {
	
	public static void main(String[] args) {
		Aaa aa = new Aaa();
		//Bbb bb = new Bbb(100);
		Bbb bb = null;
		//aa.print(bb);
		
		Optional<Bbb> bb1 = Optional.ofNullable(bb); //null이면 값으로 바꿈
		System.out.println(bb1);
		aa.print(bb1.orElseGet(()->new Bbb(0))); //orElseGet메서드는 null이면 객체를 생성해서 대체 값을 줌
	}
}
