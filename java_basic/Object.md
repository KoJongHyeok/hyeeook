# Object

## boolean equals(Object obj)
> 
> ```java
> class People {
> 
>   int id; // 주민번호
> 
> 	People() { super(); }
> 
> 	People(int id) {
> 		super();
> 		this.id = id;
> 	}
> 
> 	@Override
> 	public boolean equals(Object obj) {
> 		// 타입이 Value가 아니면 비교할 필요도 없음.
> 		if (!(obj instanceof People)) { return false; }
> 
> 		People p = (People) obj;
> 		return this.id == p.id;
> 		// cv : 객체에 관계없이 공통 값.
> 		// iv : 객체마다 다른 개별 값.
> 		// equals는 모든 iv가 같으면 같은 객체로 판단하도록, iv의 값만 비교하도록 오버라이딩 해야 함.
> 	}
> 
> }
> ```

___

## native int hashCode(), String toString()
### hashCode()
> - 객체의 지문
> - equals() 메서드를 오버라이딩하면 hashCode() 메서드도 오버라이딩 해야 함.
>   - 두 객체의 equals() 메서드의 결과가 true이면 hashCode 값도 같아야 하기 때문.
> - 32bit JVM에서는 주소값이 int 타입(4byte), 64bit JVM에서는 주소값이 long 타입(8byte).
>   - hashCode() 메서드의 반환타입은 int 타입(32bit)이므로 64bit JVM에서는 hashCode 값이 중복될 수 있음.
>   - 32bit의 숫자로 64bit를 만들기 때문.
> 
> ```java
> class Card {
> 	final String kind;
> 	final int number;
> 	
> 	@Override
> 	public String toString() {
> 		return "kind : " + this.kind + ", number : " + this.number;
> 	}
> 	
> 	@Override
> 	public int hashCode() {
> 		return Objects.hash(this.kind, this.number);
>   }
> 	
> 	@Override
> 	public boolean equals(Object obj) {
> 		if(!(obj instanceof Card)) { return false; }
> 		Card c = (Card) obj;
> 		return this.kind.equals(c.kind) && this.number==c.number;
> 	}
> 	
> 	Card() {this("SPADE", 1);}
> 	Card(String kind, int number) {
> 		super();
> 		this.kind = kind;
> 		this.number = number;
> 	}
> } 
> ```

___
