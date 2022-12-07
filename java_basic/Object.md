# Object

## equals
> - boolean equals(Object obj)
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
```
___

## hashCode
