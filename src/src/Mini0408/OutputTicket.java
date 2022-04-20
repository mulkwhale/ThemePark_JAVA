package Mini0408;

import java.util.ArrayList;

public class OutputTicket {
	public ArrayList<OrderData> orderList = new ArrayList<OrderData>(); // �ֹ� ���� ����
	CalTicket calTicket = new CalTicket();
	
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
				System.out.print("�����̿�� ");
			} else {
				System.out.print("��ũ�̿�� ");
			}
			if (orderList.get(index).getAgeResult() < StaticValue.YOUNGER_BABY)  {
				System.out.print("12���� �̸� ���̺� ");
			} else if (orderList.get(index).getAgeResult() < StaticValue.OLDER_BABY) {
				System.out.print("36���� �̸� ���̺� ");
			} else if (orderList.get(index).getAgeResult() < StaticValue.CHILD) {
				System.out.print("��� ");
			} else if (orderList.get(index).getAgeResult() < StaticValue.TEEN) {
				System.out.print("û�ҳ� ");
			} else if (orderList.get(index).getAgeResult() < StaticValue.ADULT) {
				System.out.print("� ");
			} else {
				System.out.print("65�� �̻� � ");
			}
			if (orderList.get(index).getDay() == StaticValue.ONEDAY) {
				System.out.print("1Day ");
			} else {
				System.out.print("After4 ");
			}
			System.out.print("X     " + orderList.get(index).getOrderCount() + "     ");
			System.out.print(orderList.get(index).getLastPriceResult() + "��");
			
			temp += orderList.get(index).getLastPriceResult();
			calTicket.inputTicket.orderItem.setTotalPrice(temp);
			
			if (orderList.get(index).getAdvantageType() == StaticValue.NO_ADVENTAGE) {
				System.out.println(" * ������� ����");
			} else if (orderList.get(index).getAdvantageType() == StaticValue.ADVENTAGE_DISABLED) {
				System.out.println(" * ����� �������");
			} else if (orderList.get(index).getAdvantageType() == StaticValue.ADVENTAGE_NATIONAL_MERIT) {
				System.out.println(" * ���������� �������");
			} else if (orderList.get(index).getAdvantageType() == StaticValue.ADVENTAGE_ARMY) {
				System.out.println(" * �ް��庴 �������");
			} else if (orderList.get(index).getAdvantageType() == StaticValue.ADVENTAGE_PREGNANT) {
				System.out.println(" * �ӻ�� �������");
			} else if (orderList.get(index).getAdvantageType() == StaticValue.ADVENTAGE_CHILDREN) {
				System.out.println(" * �ٵ��� �ູī�� �������");
			} 
		}
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
}