
public class Product {
	
//  ----------------------------------------------------------------------
//  >> 변수
	int price;
	int bonusPoint;
	
//  ----------------------------------------------------------------------
//  >> 메서드
	
//  ----------------------------------------------------------------------
//  >> 생성자
	Product() {super();}
	Product(int price) {
		this();
		this.price = price;
		this.bonusPoint = (int)(price/10.0);
	}
	
}
