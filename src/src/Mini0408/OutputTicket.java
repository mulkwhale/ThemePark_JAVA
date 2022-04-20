package Mini0408;

import java.util.ArrayList;

public class OutputTicket {
	public ArrayList<OrderData> orderList = new ArrayList<OrderData>(); // 주문 내역 저장
	CalTicket calTicket = new CalTicket();
	
	int price() {
		int continueNumber;
		
		System.out.println("가격은 " + calTicket.inputTicket.orderItem.getLastPriceResult() + " 원 입니다.\n감사합니다.");
		continueNumber = calTicket.inputTicket.continueInput();
		
		return continueNumber;
	}
	
	void exit(){
		int temp = 0;
		System.out.println("티켓 발권을 종료합니다. 감사합니다.\n");
		System.out.println("=================== 롯데월드 ===================");
		for (int index = 0; index < orderList.size(); index++) {
			if (orderList.get(index).getTicketType() == StaticValue.TICKET_ALL) {
				System.out.print("종합이용권 ");
			} else {
				System.out.print("파크이용권 ");
			}
			if (orderList.get(index).getAgeResult() < StaticValue.YOUNGER_BABY)  {
				System.out.print("12개월 미만 베이비 ");
			} else if (orderList.get(index).getAgeResult() < StaticValue.OLDER_BABY) {
				System.out.print("36개월 미만 베이비 ");
			} else if (orderList.get(index).getAgeResult() < StaticValue.CHILD) {
				System.out.print("어린이 ");
			} else if (orderList.get(index).getAgeResult() < StaticValue.TEEN) {
				System.out.print("청소년 ");
			} else if (orderList.get(index).getAgeResult() < StaticValue.ADULT) {
				System.out.print("어른 ");
			} else {
				System.out.print("65세 이상 어른 ");
			}
			if (orderList.get(index).getDay() == StaticValue.ONEDAY) {
				System.out.print("1Day ");
			} else {
				System.out.print("After4 ");
			}
			System.out.print("X     " + orderList.get(index).getOrderCount() + "     ");
			System.out.print(orderList.get(index).getLastPriceResult() + "원");
			
			temp += orderList.get(index).getLastPriceResult();
			calTicket.inputTicket.orderItem.setTotalPrice(temp);
			
			if (orderList.get(index).getAdvantageType() == StaticValue.NO_ADVENTAGE) {
				System.out.println(" * 우대적용 없음");
			} else if (orderList.get(index).getAdvantageType() == StaticValue.ADVENTAGE_DISABLED) {
				System.out.println(" * 장애인 우대적용");
			} else if (orderList.get(index).getAdvantageType() == StaticValue.ADVENTAGE_NATIONAL_MERIT) {
				System.out.println(" * 국가유공자 우대적용");
			} else if (orderList.get(index).getAdvantageType() == StaticValue.ADVENTAGE_ARMY) {
				System.out.println(" * 휴가장병 우대적용");
			} else if (orderList.get(index).getAdvantageType() == StaticValue.ADVENTAGE_PREGNANT) {
				System.out.println(" * 임산부 우대적용");
			} else if (orderList.get(index).getAdvantageType() == StaticValue.ADVENTAGE_CHILDREN) {
				System.out.println(" * 다둥이 행복카드 우대적용");
			} 
		}
		System.out.println("\n입장료 총액은 " + calTicket.inputTicket.orderItem.getTotalPrice() + "원 입니다.");
		System.out.println("==============================================\n");
	}
	
	void customer() {
		orderList.add(calTicket.inputTicket.orderItem);
	}
	
	void dataReset() {
		calTicket.inputTicket.orderItem = new OrderData();
	}
	
	void listReset() {
		orderList = new ArrayList<OrderData>();
	}
}