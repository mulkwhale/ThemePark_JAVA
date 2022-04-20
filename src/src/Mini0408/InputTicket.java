package Mini0408;

import java.util.Scanner;

public class InputTicket {
	public Scanner scanner = new Scanner(System.in);
	public OrderData orderItem = new OrderData();
	
	void inputData() {
		System.out.println("권종을 선택하세요.\n1. 종합이용권\n2. 파크이용권");
		orderItem.setTicketType(scanner.nextInt());
		System.out.println("주민번호를 입력하세요");
		orderItem.setIDNumber(scanner.next());
		orderItem.setBirthInt(Integer.parseInt(orderItem.getIDNumber().substring(0, 6)));
		orderItem.setGeneInt(Integer.parseInt(orderItem.getIDNumber().substring(6, 7)));
		System.out.println("시간대를 선택하세요\n1. 1Day\n2. After4");
		orderItem.setDay(scanner.nextInt());
		System.out.println("몇 개를 주문하시겠습니까? (최대 10개)");
		orderItem.setOrderCount(scanner.nextInt());
		System.out.println("우대사항을 선택하세요.\n1. 없음 (나이 우대는 자동처리)\n2. 장애인\n3. 국가유공자\n4. 휴가장병\n5. 임산부\n6. 다둥이 행복카드");
		orderItem.setAdvantageType(scanner.nextInt());
	}
	
	String coInputData() {
		String coId;
		
		System.out.println("동반인의 주민번호를 입력하세요");
		coId = scanner.next();
		
		return coId;
	}
	
	int continueInput() {
		int continueNumber;
		
		System.out.println("계속 발권 하시겠습니까?\n1. 티켓 발권\n2. 종료");
		continueNumber = scanner.nextInt();
		
		return continueNumber;
	}
	
	void lastExit(){
		System.out.print("계속 진행(1: 새로운 주문, 2: 프로그램 종료) : ");
		orderItem.setIsExit(scanner.nextInt());
		
		orderItem.setTotalPrice(0);
	}
}