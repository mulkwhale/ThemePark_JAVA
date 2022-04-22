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
		System.out.println("��¥�� �Է��ϼ���.");
		orderItem.setDate(scanner.nextInt());
		System.out.println("������ �����ϼ���.\n1. " + orderItem.getLineTicketType()[0] + "\n2. " + orderItem.getLineTicketType()[1]);
		orderItem.setTicketType(scanner.nextInt());
		System.out.println("�ֹι�ȣ�� �Է��ϼ���");
		orderItem.setIDNumber(scanner.next());
		orderItem.setBirthInt(Integer.parseInt(orderItem.getIDNumber().substring(0, 6)));
		orderItem.setGeneInt(Integer.parseInt(orderItem.getIDNumber().substring(6, 7)));
		System.out.println("�ð��븦 �����ϼ���\n1. " + orderItem.getLineDay()[0] + "\n2. " + orderItem.getLineDay()[1]);
		orderItem.setDay(scanner.nextInt());
		System.out.println("�� ���� �ֹ��Ͻðڽ��ϱ�? (�ִ� 10��)");
		orderItem.setOrderCount(scanner.nextInt());
		System.out.println("�������� �����ϼ���.");
		System.out.println("1. " + orderItem.getLineAdvantageType()[0] + " (���� ���� �ڵ�ó��)");
		System.out.println("2. " + orderItem.getLineAdvantageType()[1]);
		System.out.println("3. " + orderItem.getLineAdvantageType()[2]);
		System.out.println("4. " + orderItem.getLineAdvantageType()[3]);
		System.out.println("5. " + orderItem.getLineAdvantageType()[4]);
		System.out.println("6. " + orderItem.getLineAdvantageType()[5]);
		orderItem.setAdvantageType(scanner.nextInt());
	}
	
	String coInputData() {
		String coId;
		
		System.out.println("�������� �ֹι�ȣ�� �Է��ϼ���");
		coId = scanner.next();
		
		return coId;
	}
	
	int continueInput() {
		int continueNumber;
		
		System.out.println("��� �߱� �Ͻðڽ��ϱ�?\n1. Ƽ�� �߱�\n2. ����");
		continueNumber = scanner.nextInt();
		
		return continueNumber;
	}
	
	void lastExit(){
		System.out.print("��� ����(1: ���ο� �ֹ�, 2: ���α׷� ����) : ");
		orderItem.setIsExit(scanner.nextInt());
		
		orderItem.setTotalPrice(0);
	}
	
	void saveData() throws IOException {
		FileWriter fw = new FileWriter("C:\\Users\\������\\Desktop\\report.csv", true);
		
		orderItem.setLine("\n" + Integer.toString(orderItem.getDate())); // ��¥
		orderItem.setLine("," +
		orderItem.getLineTicketType()[orderItem.getTicketType() - 1]); // ����
		orderItem.setLine("," +
				orderItem.getLineAgeResult()[orderItem.getIndexAge()]); // ���ɱ���
		orderItem.setLine("," +
				orderItem.getLineDay()[orderItem.getDay() - 1]); // �ð���
		orderItem.setLine("," + orderItem.getOrderCount()); // ����
		orderItem.setLine("," + orderItem.getLastPriceResult()); // ����
		orderItem.setLine("," +
				orderItem.getLineAdvantageType()[orderItem.getAdvantageType() - 1]); // ������
		
		fw.write(orderItem.getLine());
		
		fw.close();
	}
}