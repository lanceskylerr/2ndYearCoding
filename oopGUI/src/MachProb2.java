
class Animal {
	public void Pig() {
		System.out.print("The pig says ");
	}

	public void Cow() {
		System.out.print("The Cow says ");
	}

	public void Dog() {
		System.out.print("The Dog says ");
	}
}

class Pig {
	public void SoundPig() {
		System.out.println("Oink!");
	}

}

class Dog {
	public void SoundDog() {
		System.out.println("Aw! Aw! Aw!");
	}
}	

class Cow {
	public void SoundCow() {
		System.out.println("Mooo!");
	}

}

class MachProb2 {
	public static void main(String args[]) {
		Animal txt = new Animal();
		Pig oink = new Pig();
		Cow moo = new Cow();
		Dog aw = new Dog();

		txt.Pig();
		oink.SoundPig();
		txt.Cow();
		moo.SoundCow();
		txt.Dog();
		aw.SoundDog();

	}

}
