package Mini0408;

import java.util.Scanner;

public class InputTicket {
	public Scanner scanner = new Scanner(System.in);
	public OrderData orderItem = new OrderData();
	
	void inputData() {
		System.out.println("������ �����ϼ���.\n1. �����̿��\n2. ��ũ�̿��");
		orderItem.setTicketType(scanner.nextInt());
		System.out.println("�ֹι�ȣ�� �Է��ϼ���");
		orderItem.setIDNumber(scanner.next());
		orderItem.setBirthInt(Integer.parseInt(orderItem.getIDNumber().substring(0, 6)));
		orderItem.setGeneInt(Integer.parseInt(orderItem.getIDNumber().substring(6, 7)));
		System.out.println("�ð��븦 �����ϼ���\n1. 1Day\n2. After4");
		orderItem.setDay(scanner.nextInt());
		System.out.println("�� ���� �ֹ��Ͻðڽ��ϱ�? (�ִ� 10��)");
		orderItem.setOrderCount(scanner.nextInt());
		System.out.println("�������� �����ϼ���.\n1. ���� (���� ���� �ڵ�ó��)\n2. �����\n3. ����������\n4. �ް��庴\n5. �ӻ��\n6. �ٵ��� �ູī��");
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
}