
public class Buyer {
	
//  ----------------------------------------------------------------------
//  >> 변수
	int money;
	int bonusPoint;
	
	Product[] cart = new Product[10];
	int i = 0;
	
//  ----------------------------------------------------------------------
//  >> 메서드
	void buy(Product p) {
		if (this.money < p.price) {
			System.out.println("잔액 부족!");
			return;
		}
		
		this.money -= p.price;
		this.bonusPoint += p.bonusPoint;
		
		cart[i++] = p;
		
		System.out.println(p + "을/를 구매했소!");
		System.out.println("잔액은 " + this.money + "만원이오!");
		System.out.println("보너스 포인트는 " + this.bonusPoint + "점이오!");
	}
	
	void summary() {
		int sum = 0;
		String itemList = "";
		
		for (int i=0; i<cart.length; i++) {
			if (cart[i]==null) {break;}
			sum += cart[i].price;
			itemList += cart[i] + " ";
		}
		
		System.out.println("구입한 제품의 총액 : " + sum + "만원!");
		System.out.println("구입한 제품 : " + itemList);
	}
	
//  ----------------------------------------------------------------------
//  >> 생성자
	Buyer() {super();}
	
}
