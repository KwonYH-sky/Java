import java.lang.*;

public class HelloWorldAnonymousClasses {
	interface HelloWorld {
		public void greet();
		public void greetSomeone(String someone);
	}

	public void sayHello() {

		class EnglishGreeting implements HelloWorld {
			String name = "world";

			@Override
			public void greet() {
				greetSomeone("world");
			}

			@Override
			public void greetSomeone(String someone) {
				name = someone;
				System.out.println("Hello " + name);
			}
		}

		HelloWorld enlishGreeting = new EnglishGreeting();

		HelloWorld frenchGreeting = new HelloWorld() {
			String name = "tout le monda";
			@Override
			public void greet() {
				greetSomeone("tout le monda");
			}

			@Override
			public void greetSomeone(String someone) {
				name = someone;
				System.out.println("Salut " + name);
			}
		};

		HelloWorld koreanGreeting = new HelloWorld() {
			String name = "세상";
			@Override
			public void greet() {
				greetSomeone("세상");
			}

			@Override
			public void greetSomeone(String someone) {
				name = someone;
				System.out.println("안녕 " + name);
			}
		};
		enlishGreeting.greet();
		frenchGreeting.greetSomeone("Fred");
		koreanGreeting.greet();
	}

	public static void main(String[] args) {
		HelloWorldAnonymousClasses myApp = new HelloWorldAnonymousClasses();
		myApp.sayHello();
	}
}