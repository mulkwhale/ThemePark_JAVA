package Mini0408;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class InputTicket {
	public Scanner scanner = new Scanner(System.in);
	public OrderData orderItem;
	public InputTicket(OrderData orderItem) {
		this.orderItem = orderItem;
	}
	
	boolean inputFromKeyboard() {
		return true;
	}
	
	boolean inputFromDatabase() {
		return true;
	}
	
	boolean inputFromTouch() {
		return true;
	}
	
	void inputData() {
		System.out.println("날짜를 입력하세요.");
		orderItem.setDate(scanner.nextInt());
		System.out.println("권종을 선택하세요.\n1. " + orderItem.getLineTicketType()[0] + "\n2. " + orderItem.getLineTicketType()[1]);
		orderItem.setTicketType(scanner.nextInt());
		System.out.println("주민번호를 입력하세요");
		orderItem.setIDNumber(scanner.next());
		orderItem.setBirthInt(Integer.parseInt(orderItem.getIDNumber().substring(0, 6)));
		orderItem.setGeneInt(Integer.parseInt(orderItem.getIDNumber().substring(6, 7)));
		System.out.println("시간대를 선택하세요\n1. " + orderItem.getLineDay()[0] + "\n2. " + orderItem.getLineDay()[1]);
		orderItem.setDay(scanner.nextInt());
		System.out.println("몇 개를 주문하시겠습니까? (최대 10개)");
		orderItem.setOrderCount(scanner.nextInt());
		System.out.println("우대사항을 선택하세요.");
		System.out.println("1. " + orderItem.getLineAdvantageType()[0] + " (나이 우대는 자동처리)");
		System.out.println("2. " + orderItem.getLineAdvantageType()[1]);
		System.out.println("3. " + orderItem.getLineAdvantageType()[2]);
		System.out.println("4. " + orderItem.getLineAdvantageType()[3]);
		System.out.println("5. " + orderItem.getLineAdvantageType()[4]);
		System.out.println("6. " + orderItem.getLineAdvantageType()[5]);
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
	
	void saveData() throws IOException {
		FileWriter fw = new FileWriter("C:\\Users\\공윤정\\Desktop\\report.csv", true);
		
		orderItem.setLine("\n" + Integer.toString(orderItem.getDate())); // 날짜
		orderItem.setLine("," +
		orderItem.getLineTicketType()[orderItem.getTicketType() - 1]); // 권종
		orderItem.setLine("," +
				orderItem.getLineAgeResult()[orderItem.getIndexAge()]); // 연령구분
		orderItem.setLine("," +
				orderItem.getLineDay()[orderItem.getDay() - 1]); // 시간대
		orderItem.setLine("," + orderItem.getOrderCount()); // 수량
		orderItem.setLine("," + orderItem.getLastPriceResult()); // 가격
		orderItem.setLine("," +
				orderItem.getLineAdvantageType()[orderItem.getAdvantageType() - 1]); // 우대사항
		
		fw.write(orderItem.getLine());
		
		fw.close();
	}
}