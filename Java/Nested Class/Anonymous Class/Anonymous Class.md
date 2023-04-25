# 익명 클래스
[노션으로 보기](https://jeweled-chance-709.notion.site/095f62ad15b44aff8f80d8e8c1288986)

익명 클래스(Anonymous Class)는 내부 클래스(Inner class) 일종으로 단어 그대로 이름이 없는 클래스를 말한다.

익명 클래스를 사용하면 코드를 보다 간결하게 만들 수 있으며 
클래스를 동시에 선언하고 인스턴스화할 수 있다. 

이름을 갖지 않는 것을 제외하면 지역 클래스와 같다. 
클래스를 한 번만 사용해야 할 경우 사용한다.
즉, 프로그램에서 일시적으로 한번만 사용되고 버려지는 객체라고 보면 된다. (일회용 클래스)

```Java
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
```
[코드보기](HelloWorldAnonymousClasses.java)

이전에 언급했듯이, 익명 클래스는 표현식이다. 
익명 클래스 표현식의 구문은 생성자 호출과 유사하지만, 
코드 블록 내에 클래스 정의가 필요하다.

```Java
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
```
익명 클래스 표현식은 다음과 같은 요소로 구성된다:

 - new 연산자
 - 구현할 인터페이스 또는 확장할 클래스의 이름. 
 이 예제에서는 익명 클래스가 HelloWorld 인터페이스를 구현하고 있다.
- 괄호 안에는 일반적인 클래스 인스턴스 생성 표현식과 마찬가지로 생성자에 전달할 인수가 포함됩니다. 참고: 인터페이스를 구현할 때는 생성자가 없으므로 이 예제와 같이 빈 괄호를 사용합니다.
- 클래스에서는 메서드 선언이 허용되지만 표현식인 익명 클래스는 새로운 메서드 선언이 불가능하다.

익명 클래스는 표현식이다. 이 예제에서 익명 클래스 표현식은 frenchGreeting 객체와 koreanGreeting 객체 생성하는 과정이다. (따라서 닫는 중괄호 뒤에 세미콜론이 있어야 한다.)

### 외부 스코프의 지역 변수에 접근과 익명 클래스의 멤버 선언과 접근
지역 클래스와 마찬가지로 익명 클래스는 변수를 가질 수 있다. 익명 클래스는 외부 스코프의 지역 변수에 대한 동일한 접근 권한을 갖는다.
 - 익명 클래스는 외부 클래스의 멤버에 접근할 수 있다.
 - 익명 클래스는 final 또는 effectively final로 선언되지 않은 외부 스코프의 지역 변수에는 접근할 수 없다.
 - 중첩 클래스와 마찬가지로, 익명 클래스에서 타입(변수 등)을 선언하면, 해당 이름을 가진 외부 스코프의 다른 선언을 가려버린다.


익명 클래스는 멤버에 관해 로컬 클래스와 동일한 제한 사항이 있다
- 익명 클래스에서 정적초기화(static initializer)나 멤버 인터페이스를 선언할 수 없다.
- 익명 클래스는 상수 변수인 경우에 한하여 static 멤버를 가질 수 있다. 

익명 클래스에서는 다음을 선언할 수 있다 (단, 외부에서 호출 불가능)
- 필드
- 추가 메서드
- 인스턴스 초기화자 
- 로컬 클래스

하지만 익명 클래스에서는 생성자를 선언할 수 없다.
