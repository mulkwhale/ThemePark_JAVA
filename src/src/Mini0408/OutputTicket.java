package Mini0408;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;

public class OutputTicket {
	public ArrayList<OrderData> orderList = new ArrayList<OrderData>(); // �ֹ� ���� ����
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
		
		System.out.println("������ " + calTicket.inputTicket.orderItem.getLastPriceResult() + " �� �Դϴ�.\n�����մϴ�.");
		continueNumber = calTicket.inputTicket.continueInput();
		
		return continueNumber;
	}
	
	void exit(){
		int temp = 0;
		System.out.println("Ƽ�� �߱��� �����մϴ�. �����մϴ�.\n");
		System.out.println("=================== �Ե����� ===================");
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
			System.out.print(orderList.get(index).getLastPriceResult() + "��");
			
			temp += orderList.get(index).getLastPriceResult();
			calTicket.inputTicket.orderItem.setTotalPrice(temp);
			
			if (orderList.get(index).getAdvantageType() == StaticValue.NO_ADVENTAGE) {
				System.out.print(" * ������� " + calTicket.inputTicket.orderItem.getLineAdvantageType()[0]);
			} else if (orderList.get(index).getAdvantageType() == StaticValue.ADVENTAGE_DISABLED) {
				System.out.print(" * " + calTicket.inputTicket.orderItem.getLineAdvantageType()[1] + " �������");
			} else if (orderList.get(index).getAdvantageType() == StaticValue.ADVENTAGE_NATIONAL_MERIT) {
				System.out.print(" * " + calTicket.inputTicket.orderItem.getLineAdvantageType()[2] + " �������");
			} else if (orderList.get(index).getAdvantageType() == StaticValue.ADVENTAGE_ARMY) {
				System.out.print(" * " + calTicket.inputTicket.orderItem.getLineAdvantageType()[3] + " �������");
			} else if (orderList.get(index).getAdvantageType() == StaticValue.ADVENTAGE_PREGNANT) {
				System.out.print(" * " + calTicket.inputTicket.orderItem.getLineAdvantageType()[4] + " �������");
			} else if (orderList.get(index).getAdvantageType() == StaticValue.ADVENTAGE_CHILDREN) {
				System.out.print(" * " + calTicket.inputTicket.orderItem.getLineAdvantageType()[5] + " �������");
			} 
			
			System.out.println("index age " + calTicket.inputTicket.orderItem.getIndexAge());
		}
		System.out.println("indexAge for�� �� " + calTicket.inputTicket.orderItem.getIndexAge());
		System.out.println("\n����� �Ѿ��� " + calTicket.inputTicket.orderItem.getTotalPrice() + "�� �Դϴ�.");
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
		BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\������PC\\Desktop\\report.csv"));
		String str;
		String[] line;
		System.out.println("============================= report.csv =============================");
		System.out.println("��¥\t\t����\t���ɱ���\t\t�ð���\t����\t����\t������");
		while ((str = reader.readLine()) != null) {
			line = str.split(",");
			
			if (line.length > 6) {
				if (line[1].equals("�����̿��") && line[3].equals("1Day")) {
					countTicketAllAll++;
					countMoneyAll += Integer.parseInt(line[5]);
				} else if (line[1].equals("��ũ�̿��") && line[3].equals("1Day")) {
					countTicketParkAll++;
					countMoneyAfter += Integer.parseInt(line[5]);
				} else if (line[1].equals("�����̿��") && line[3].equals("After4")) {
					countTicketAllAfter++;
					countMoneyAll += Integer.parseInt(line[5]);
				} else if (line[1].equals("��ũ�̿��") && line[3].equals("After4")) {
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
		System.out.println("============ ���� �� �Ǹ���Ȳ ============");
		
		System.out.println(calTicket.inputTicket.orderItem.getLineTicketType()[0] + " �� "
						 + (countTicketAllAll + countTicketAllAfter) + "��");
		System.out.println("1Day " + countTicketAllAll + "��, After4 " + countTicketAllAfter);
		System.out.println("�����̿�� ���� : " + countMoneyAll + "��");
		System.out.println();
		System.out.println(calTicket.inputTicket.orderItem.getLineTicketType()[1] + " �� "
				 + (countTicketParkAll + countTicketParkAfter) + "��");
		System.out.println("1Day " + countTicketParkAll + "��, After4 " + countTicketParkAfter);
		System.out.println("��ũ�̿�� ���� : " + countMoneyAfter + "��");
		System.out.println("-------------------------------------");
	}
	
	void dayResult() throws IOException{
		int[] dateSales = new int[date.size()];
		BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\������PC\\Desktop\\report.csv"));
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
		
		System.out.println("============ ���ں� ���� ��Ȳ ============");
		for (int index = 0; index < dateStr.size(); index++) {
			System.out.print(dateStr.get(index).substring(0, 4) + "�� "
					+ dateStr.get(index).substring(4, 6) + "�� "
					+ dateStr.get(index).substring(6, 8) + "�� : ");
			System.out.println("�� ����\t" + dateSales[index] + "��");
		}
		System.out.println("-------------------------------------");
	}
	
	void specialResult() throws IOException{
		int[] specialSales = new int[special.size()];
		BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\������PC\\Desktop\\report.csv"));
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
		
		System.out.println("======== ���� �Ǹ� ��Ȳ ========");
		System.out.println("�� �Ǹ� Ƽ�ϼ�\t:\t" + sum + "��");
		for (int index = 0; index < specialStr.size(); index++) {
			System.out.println(specialStr.get(index) + "\t:\t" + specialSales[index] + "��");
		}
		System.out.println("-----------------------------");
	}
}