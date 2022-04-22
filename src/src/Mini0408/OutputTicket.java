package Mini0408;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;

public class OutputTicket {
	public ArrayList<OrderData> orderList = new ArrayList<OrderData>(); // 주문 내역 저장
	ArrayList<String> dateStr = new ArrayList<String>();
	ArrayList<String> specialStr = new ArrayList<String>();
	HashSet<String> date = new HashSet<String>();
	HashSet<String> special = new HashSet<String>();
	public CalTicket calTicket;	
	public OutputTicket(CalTicket calTicket) {
		this.calTicket = calTicket;
	}
	int countTicketAllAll = 0;
	int countTicketParkAll = 0;
	int countTicketAllAfter = 0;
	int countTicketParkAfter = 0;
	int countMoneyAll = 0;
	int countMoneyAfter = 0;
	
	boolean outputFromKeyboard() {
		return true;
	}
	
	boolean outputFromDatabase() {
		return true;
	}
	
	boolean outputFromTouch() {
		return true;
	}
	
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
				System.out.print(calTicket.inputTicket.orderItem.getLineTicketType()[0] + " ");
			} else {
				System.out.print(calTicket.inputTicket.orderItem.getLineTicketType()[1] + " ");
			}
			if (orderList.get(index).getAgeResult() < StaticValue.YOUNGER_BABY)  {
				System.out.print(calTicket.inputTicket.orderItem.getLineAgeResult()[0] + " ");
				calTicket.inputTicket.orderItem.setIndexAge(0);
			} else if (orderList.get(index).getAgeResult() < StaticValue.OLDER_BABY) {
				System.out.print(calTicket.inputTicket.orderItem.getLineAgeResult()[1] + " ");
				calTicket.inputTicket.orderItem.setIndexAge(1);
			} else if (orderList.get(index).getAgeResult() < StaticValue.CHILD) {
				System.out.print(calTicket.inputTicket.orderItem.getLineAgeResult()[2] + " ");
				calTicket.inputTicket.orderItem.setIndexAge(2);
			} else if (orderList.get(index).getAgeResult() < StaticValue.TEEN) {
				System.out.print(calTicket.inputTicket.orderItem.getLineAgeResult()[3] + " ");
				calTicket.inputTicket.orderItem.setIndexAge(3);
			} else if (orderList.get(index).getAgeResult() < StaticValue.ADULT) {
				System.out.print(calTicket.inputTicket.orderItem.getLineAgeResult()[4] + " ");
				calTicket.inputTicket.orderItem.setIndexAge(4);
			} else {
				System.out.print(calTicket.inputTicket.orderItem.getLineAgeResult()[5] + " ");
				calTicket.inputTicket.orderItem.setIndexAge(5);
			}
			if (orderList.get(index).getDay() == StaticValue.ONEDAY) {
				System.out.print(calTicket.inputTicket.orderItem.getLineDay()[0] + " ");
			} else {
				System.out.print(calTicket.inputTicket.orderItem.getLineDay()[1] + " ");
			}
			System.out.print("X     " + orderList.get(index).getOrderCount() + "     ");
			System.out.print(orderList.get(index).getLastPriceResult() + "원");
			
			temp += orderList.get(index).getLastPriceResult();
			calTicket.inputTicket.orderItem.setTotalPrice(temp);
			
			if (orderList.get(index).getAdvantageType() == StaticValue.NO_ADVENTAGE) {
				System.out.print(" * 우대적용 " + calTicket.inputTicket.orderItem.getLineAdvantageType()[0]);
			} else if (orderList.get(index).getAdvantageType() == StaticValue.ADVENTAGE_DISABLED) {
				System.out.print(" * " + calTicket.inputTicket.orderItem.getLineAdvantageType()[1] + " 우대적용");
			} else if (orderList.get(index).getAdvantageType() == StaticValue.ADVENTAGE_NATIONAL_MERIT) {
				System.out.print(" * " + calTicket.inputTicket.orderItem.getLineAdvantageType()[2] + " 우대적용");
			} else if (orderList.get(index).getAdvantageType() == StaticValue.ADVENTAGE_ARMY) {
				System.out.print(" * " + calTicket.inputTicket.orderItem.getLineAdvantageType()[3] + " 우대적용");
			} else if (orderList.get(index).getAdvantageType() == StaticValue.ADVENTAGE_PREGNANT) {
				System.out.print(" * " + calTicket.inputTicket.orderItem.getLineAdvantageType()[4] + " 우대적용");
			} else if (orderList.get(index).getAdvantageType() == StaticValue.ADVENTAGE_CHILDREN) {
				System.out.print(" * " + calTicket.inputTicket.orderItem.getLineAdvantageType()[5] + " 우대적용");
			} 
			
			System.out.println("index age " + calTicket.inputTicket.orderItem.getIndexAge());
		}
		System.out.println("indexAge for문 밖 " + calTicket.inputTicket.orderItem.getIndexAge());
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
	
	void csvResult() throws IOException{
		BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\공윤정PC\\Desktop\\report.csv"));
		String str;
		String[] line;
		System.out.println("============================= report.csv =============================");
		System.out.println("날짜\t\t권종\t연령구분\t\t시간대\t수량\t가격\t우대사항");
		while ((str = reader.readLine()) != null) {
			line = str.split(",");
			
			if (line.length > 6) {
				if (line[1].equals("종합이용권") && line[3].equals("1Day")) {
					countTicketAllAll++;
					countMoneyAll += Integer.parseInt(line[5]);
				} else if (line[1].equals("파크이용권") && line[3].equals("1Day")) {
					countTicketParkAll++;
					countMoneyAfter += Integer.parseInt(line[5]);
				} else if (line[1].equals("종합이용권") && line[3].equals("After4")) {
					countTicketAllAfter++;
					countMoneyAll += Integer.parseInt(line[5]);
				} else if (line[1].equals("파크이용권") && line[3].equals("After4")) {
					countTicketParkAfter++;
					countMoneyAfter += Integer.parseInt(line[5]);
				}
			}
			
			if (line.length > 6) {
				date.add(line[0]);
				special.add(line[6]);
			}
		}
		System.out.println("----------------------------------------------------------------------");
	}
	
	void ticketTypeResult(){
		System.out.println("============ 권종 별 판매현황 ============");
		
		System.out.println(calTicket.inputTicket.orderItem.getLineTicketType()[0] + " 총 "
						 + (countTicketAllAll + countTicketAllAfter) + "매");
		System.out.println("1Day " + countTicketAllAll + "매, After4 " + countTicketAllAfter);
		System.out.println("종합이용권 매출 : " + countMoneyAll + "원");
		System.out.println();
		System.out.println(calTicket.inputTicket.orderItem.getLineTicketType()[1] + " 총 "
				 + (countTicketParkAll + countTicketParkAfter) + "매");
		System.out.println("1Day " + countTicketParkAll + "매, After4 " + countTicketParkAfter);
		System.out.println("파크이용권 매출 : " + countMoneyAfter + "원");
		System.out.println("-------------------------------------");
	}
	
	void dayResult() throws IOException{
		int[] dateSales = new int[date.size()];
		BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\공윤정PC\\Desktop\\report.csv"));
		String str;
		String[] line;
		
		Iterator iter = date.iterator();
		while(iter.hasNext()) {
			dateStr.add((String) iter.next());
		}
		
		Collections.sort(dateStr);
		
		while ((str = reader.readLine()) != null) {
			line = str.split(",");
			
			for (int index = 0; index < dateStr.size(); index++) {
				if (line[0].equals(dateStr.get(index))) {
					dateSales[index] += Integer.parseInt(line[5]);
				}
			}
		}
		
		System.out.println("============ 일자별 매출 현황 ============");
		for (int index = 0; index < dateStr.size(); index++) {
			System.out.print(dateStr.get(index).substring(0, 4) + "년 "
					+ dateStr.get(index).substring(4, 6) + "월 "
					+ dateStr.get(index).substring(6, 8) + "일 : ");
			System.out.println("총 매출\t" + dateSales[index] + "원");
		}
		System.out.println("-------------------------------------");
	}
	
	void specialResult() throws IOException{
		int[] specialSales = new int[special.size()];
		BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\공윤정PC\\Desktop\\report.csv"));
		String str;
		String[] line;
		int sum = 0;
		
		Iterator iter = special.iterator();
		while(iter.hasNext()) {
			specialStr.add((String) iter.next());
		}
		
		Collections.sort(specialStr);
		
		while ((str = reader.readLine()) != null) {
			line = str.split(",");
			
			for (int index = 0; index < specialStr.size(); index++) {
				if (line.length > 6) {
					if (line[6].equals(specialStr.get(index))) {
						specialSales[index]++;
					}
				}
			}
		}
		
		for (int index = 0; index < specialSales.length; index++) {
			sum += specialSales[index];
		}
		
		System.out.println("======== 우대권 판매 현황 ========");
		System.out.println("총 판매 티켓수\t:\t" + sum + "매");
		for (int index = 0; index < specialStr.size(); index++) {
			System.out.println(specialStr.get(index) + "\t:\t" + specialSales[index] + "매");
		}
		System.out.println("-----------------------------");
	}
}