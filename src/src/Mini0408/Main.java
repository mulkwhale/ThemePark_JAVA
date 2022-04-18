package Mini0408;

import java.util.Calendar;
import java.util.Scanner;

public class Main {
	final static int BABY = 15000, FREE = 0;
	final static int ADULT_1DAY_ALL = 62000, TEEN_1DAY_ALL = 54000;
	static final int CHILD_1DAY_ALL = 47000;
	final static int ADULT_AFTER4_ALL = 50000, TEEN_AFTER4_ALL = 43000, CHILD_AFTER4_ALL = 36000;
	final static int ADULT_1DAY_PARK = 59000, TEEN_1DAY_PARK = 52000, CHILD_1DAY_PARK = 46000;
	final static int ADULT_AFTER4_PARK = 47000, TEEN_AFTER4_PARK = 41000, CHILD_AFTER4_PARK = 35000;
	final static int ADULT_ARMY_1DAY = 30000, TEEN_ARMY_1DAY = 26500, CHILD_ARMY_1DAY = 24000;
	final static int ADULT_ARMY_AFTER4 = 24500, TEEN_ARMY_AFTER4 = 21500, CHILD_ARMY_AFTER4 = 18500;
	final static int YOUNGER_BABY = 1, OLDER_BABY = 3;
	static final int CHILD = 13;
	final static int TEEN = 19;
	final static int ADULT = 65;
	final static int SAVE_TICKETING = 0, SAVE_BIRTH_ID = 1, SAVE_DAY = 2, SAVE_ORDER = 3, SAVE_PRICE = 4, SAVE_SPECIAL = 5;
	final static int NO_ADVENTAGE = 1, ADVENTAGE_DISABLED = 2, ADVENTAGE_NATIONAL_MERIT = 3, ADVENTAGE_ARMY = 4, ADVENTAGE_PREGNANT = 5, ADVENTAGE_CHILDREN = 6;
	final static int ONEDAY = 1;
	final static int TICKET_ALL = 1, TICKET_PARK = 2;
	final static int CONTINUE_TICKET = 1, EXIT = 2;
	
	static int[][] orderList = new int[100][6]; // �ֹ� ���� ����
	static int position = 0; // �ֹ� ���� �迭 Ž����
	static int totalPrice = 0; // �ֹ� �Ѿ�
	static int isExit = 0;
	
	public static void main(String[] args) {
		do{
			while(true){
				Scanner scanner = new Scanner(System.in);
				int ticket;
				String birth, id, gene;
				int birthInt, geneInt;
				int day;
				int order;
				int special;
				//int price;
				int continueNumber;
				
				int ageResult;
				int priceResult;
				int coPriceResult = 0;
				int lastPriceResult;
				
				System.out.println("������ �����ϼ���.\n1. �����̿��\n2. ��ũ�̿��");
				ticket = scanner.nextInt();
				System.out.println("�ֹι�ȣ�� �Է��ϼ���");
				id = scanner.nextLine();
				id = scanner.nextLine();
				birth = id.substring(0, 6);
				gene = id.substring(6, 7);
				
				birthInt = Integer.parseInt(birth);
				geneInt = Integer.parseInt(gene);
				System.out.println("�ð��븦 �����ϼ���\n1. 1Day\n2. After4");
				day = scanner.nextInt();
				System.out.println("�� ���� �ֹ��Ͻðڽ��ϱ�? (�ִ� 10��)");
				order = scanner.nextInt();
				System.out.println("�������� �����ϼ���.\n1. ���� (���� ���� �ڵ�ó��)\n2. �����\n3. ����������\n4. �ް��庴\n5. �ӻ��\n6. �ٵ��� �ູī��");
				special = scanner.nextInt();
				
				ageResult = age(birthInt, geneInt);
				System.out.println(ageResult);
				
				if (order > 1) {
					switch(special){
						case 2:
						case 3:
						case 4:
							coPriceResult = companionPrice(ticket, day, special);
							System.out.println("������ �� " + coPriceResult);
						break;	
					}
				}
				
				priceResult = ticketResult(ticket, ageResult, day, special);
				
				lastPriceResult = lastPrice(coPriceResult, priceResult, special, order, coPriceResult, day);
				
				customer(ticket, ageResult, day, order, lastPriceResult, special);
				
				specialResult(ticket, ageResult, special);
				
				System.out.println("������ " + lastPriceResult + " �� �Դϴ�.\n�����մϴ�.");
				System.out.println("��� �߱� �Ͻðڽ��ϱ�?\n1. Ƽ�� �߱�\n2. ����");
				continueNumber = scanner.nextInt();
				if (continueNumber == CONTINUE_TICKET) {
					position++;
				} else if (continueNumber == EXIT) {
					exit();
					break;
				}
			}
			lastExit();
			
			position = 0;
			totalPrice = 0;
		}while(isExit == 1);
	}
	
	public static int age(int birth, int id) {
		Calendar cal = Calendar.getInstance();
		
		int interAge = 0;
				
		int curr_year;
		int curr_month;
		int curr_day;
		
		// ������ ���
		curr_year = cal.get(Calendar.YEAR);
		curr_month = cal.get(Calendar.MONTH) + 1;
		curr_day = cal.get(Calendar.DAY_OF_MONTH);
		
		if (id < 3) {
			interAge = curr_year - (1900 + birth / 10000) - 1;
		} else {
			interAge = curr_year - (2000 + birth / 10000) - 1;
		}
		if (birth % 10000 <= (curr_month * 100 + curr_day)) {
			interAge++;
		}
		
		return interAge;
	}
	
	public static int companionPrice(int ticket, int day, int special) {
		Scanner scanner = new Scanner(System.in);
		String coBirth, coId, coGene;
		int coPrice = 0;
		int restPrice;
		int coInterAge = 0;
		int coAgeResult = 0;
		int coGeneInt, coBirthInt;
		
		if(!(special == 4 && ticket == 2)){
			System.out.println("�������� �ֹι�ȣ�� �Է��ϼ���");
			coId = scanner.nextLine();
			coBirth = coId.substring(0, 6);
			System.out.println(coBirth);
			coGene = coId.substring(6, 7);
			System.out.println(coGene);
			coBirthInt = Integer.parseInt(coBirth);
			coGeneInt = Integer.parseInt(coGene);
			
			coAgeResult = age(coBirthInt, coGeneInt);
			System.out.println("������ ���� " + coAgeResult);
		}
		
		if (ticket == 1) {
			if (day == 1) {
				switch(special){
					case 2:
					case 3:
						if (coAgeResult < CHILD) {
							coPrice = (int) (CHILD_1DAY_ALL * 0.5);
						} else if (coAgeResult < TEEN) {
							coPrice = (int) (TEEN_1DAY_ALL * 0.5);
						} else if (coAgeResult < ADULT) {
							coPrice = (int) (ADULT_1DAY_ALL * 0.5);
						}
						break;
					case 4:
						if (coAgeResult < CHILD) {
							coPrice = CHILD_ARMY_1DAY;
						} else if (coAgeResult < TEEN) {
							coPrice = TEEN_ARMY_1DAY;
						} else if (coAgeResult < ADULT) {
							coPrice = ADULT_ARMY_1DAY;
						}
						break;
				}
			} else {
				switch(special){
					case 2:
					case 3:
						if (coAgeResult < CHILD) {
							coPrice = (int) (CHILD_AFTER4_ALL * 0.5);
						} else if (coAgeResult < TEEN) {
							coPrice = (int) (TEEN_AFTER4_ALL * 0.5);
						} else if (coAgeResult < ADULT) {
							coPrice = (int) (ADULT_AFTER4_ALL * 0.5);
						}
						break;
					case 4:
						if (coAgeResult < CHILD) {
							coPrice = CHILD_ARMY_AFTER4;
						} else if (coAgeResult < TEEN) {
							coPrice = TEEN_ARMY_AFTER4;
						} else if (coAgeResult < ADULT) {
							coPrice = ADULT_ARMY_AFTER4;
						}
						break;
				}
			}
		} else {
			if (day == 1) {
				switch(special){
					case 2:
					case 3:
						if (coAgeResult < CHILD) {
							coPrice = (int) (CHILD_1DAY_PARK * 0.5);
						} else if (coAgeResult < TEEN) {
							coPrice = (int) (TEEN_1DAY_PARK * 0.5);
						} else if (coAgeResult < ADULT) {
							coPrice = (int) (ADULT_1DAY_PARK * 0.5);
						}
						break;
				}
			} else {
				switch(special){
					case 2:
					case 3:
						if (coAgeResult < CHILD) {
							coPrice = (int) (CHILD_AFTER4_PARK * 0.5);
						} else if (coAgeResult < TEEN) {
							coPrice = (int) (TEEN_AFTER4_PARK * 0.5);
						} else if (coAgeResult < ADULT) {
							coPrice = (int) (ADULT_AFTER4_PARK * 0.5);
						}
						break;
				}
			}
		}
		
		return coPrice;
	}
	
	public static int ticketResult(int ticket, int interAge, int day, int special) {
		int price = 0;
		
		if (interAge < YOUNGER_BABY) {
			price = FREE;
		} else if (interAge < OLDER_BABY) {
			price = BABY;
		} else {
			if (ticket == TICKET_ALL) {
				if (day == ONEDAY) {
					if (interAge >= ADULT) { // ��Ÿ ��� ����Ұ�
						price = CHILD_1DAY_ALL;
					}
					switch(special){
						case NO_ADVENTAGE: 
							if (interAge < CHILD) {
								price = CHILD_1DAY_ALL;
							} else if (interAge < TEEN) {
								price = TEEN_1DAY_ALL;
							} else if (interAge < ADULT) {
								price = ADULT_1DAY_ALL;
							}
							break;
						case ADVENTAGE_DISABLED:
						case ADVENTAGE_NATIONAL_MERIT:
							if (interAge < CHILD) {
								price = (int) (CHILD_1DAY_ALL * 0.5);
							} else if (interAge < TEEN) {
								price = (int) (TEEN_1DAY_ALL * 0.5);
							} else if (interAge < ADULT) {
								price = (int) (ADULT_1DAY_ALL * 0.5);
							}
							break;
						case ADVENTAGE_ARMY:
							if (interAge < CHILD) {
								price = CHILD_ARMY_1DAY;
							} else if (interAge < TEEN) {
								price = TEEN_ARMY_1DAY;
							} else if (interAge < ADULT) {
								price = ADULT_ARMY_1DAY;
							}
							break;
						case ADVENTAGE_PREGNANT:
							price = (int) (ADULT_1DAY_ALL * 0.5);
							break;
						case ADVENTAGE_CHILDREN:
							if (interAge < CHILD) {
								price = (int) (CHILD_1DAY_ALL * 0.7);
							} else if (interAge < TEEN) {
								price = (int) (TEEN_1DAY_ALL * 0.7);
							} else if (interAge < ADULT) {
								price = (int) (ADULT_1DAY_ALL * 0.7);
							}
							break;
					}
				} else { // After4
					if (interAge >= ADULT) { // ��Ÿ ��� ����Ұ�
						price = CHILD_AFTER4_ALL;
					}
					switch(special){
						case NO_ADVENTAGE: 
							if (interAge < CHILD) {
								price = CHILD_AFTER4_ALL;
							} else if (interAge < TEEN) {
								price = TEEN_AFTER4_ALL;
							} else if (interAge < ADULT) {
								price = ADULT_AFTER4_ALL;
							}
							break;
						case ADVENTAGE_DISABLED:
						case ADVENTAGE_NATIONAL_MERIT:
							if (interAge < CHILD) {
								price = (int) (CHILD_AFTER4_ALL * 0.5);
							} else if (interAge < TEEN) {
								price = (int) (TEEN_AFTER4_ALL * 0.5);
							} else if (interAge < ADULT) {
								price = (int) (ADULT_AFTER4_ALL * 0.5);
							}
							break;
						case ADVENTAGE_ARMY:
							if (interAge < CHILD) {
								price = CHILD_ARMY_AFTER4;
							} else if (interAge < TEEN) {
								price = TEEN_ARMY_AFTER4;
							} else if (interAge < ADULT) {
								price = ADULT_ARMY_AFTER4;
							}
							break;
						case ADVENTAGE_PREGNANT:
							price = (int) (ADULT_AFTER4_ALL * 0.5);
							break;
						case ADVENTAGE_CHILDREN:
							if (interAge < CHILD) {
								price = (int) (CHILD_AFTER4_ALL * 0.7);
							} else if (interAge < TEEN) {
								price = (int) (TEEN_AFTER4_ALL * 0.7);
							} else if (interAge < ADULT) {
								price = (int) (ADULT_AFTER4_ALL * 0.7);
							}
							break;
					}
				}
			} else { // ��ũ�̿�� 
				if (day == ONEDAY) {
					if (interAge >= ADULT) { // ��Ÿ ��� ����Ұ�
						price = CHILD_1DAY_PARK;
					}
					switch(special){
						case NO_ADVENTAGE:
						case ADVENTAGE_ARMY:
						case ADVENTAGE_PREGNANT:
						case ADVENTAGE_CHILDREN:
							if (interAge < CHILD) {
								price = CHILD_1DAY_PARK;
							} else if (interAge < TEEN) {
								price = TEEN_1DAY_PARK;
							} else if (interAge < ADULT) {
								price = ADULT_1DAY_PARK;
							}
							break;
						case ADVENTAGE_DISABLED:
						case ADVENTAGE_NATIONAL_MERIT:
							if (interAge < CHILD) {
								price = (int) (CHILD_1DAY_PARK * 0.5);
							} else if (interAge < TEEN) {
								price = (int) (TEEN_1DAY_PARK * 0.5);
							} else if (interAge < ADULT) {
								price = (int) (ADULT_1DAY_PARK * 0.5);
							}
							break;
					}
				} else { // After4
					if (interAge >= ADULT) { // ��Ÿ ��� ����Ұ�
						price = CHILD_AFTER4_PARK;
					}
					switch(special){
						case NO_ADVENTAGE:
						case ADVENTAGE_ARMY:
						case ADVENTAGE_PREGNANT:
						case ADVENTAGE_CHILDREN:
							if (interAge < CHILD) {
								price = CHILD_AFTER4_PARK;
							} else if (interAge < TEEN) {
								price = TEEN_AFTER4_PARK;
							} else if (interAge < ADULT) {
								price = ADULT_AFTER4_PARK;
							}
							break;
						case ADVENTAGE_DISABLED:
						case ADVENTAGE_NATIONAL_MERIT:
							if (interAge < CHILD) {
								price = (int) (CHILD_AFTER4_PARK * 0.5);
							} else if (interAge < TEEN) {
								price = (int) (TEEN_AFTER4_PARK * 0.5);
							} else if (interAge < ADULT) {
								price = (int) (ADULT_AFTER4_PARK * 0.5);
							}
							break;
					}
				}
			}
		}
		
		return price;
	}
	
	public static int lastPrice(int coPriceResult, int price, int special, int order, int coPrice, int day){
		int restPrice;
		
		if (coPriceResult != 0) {
			if (special == 2 || special == 3) {
				price = (int) (price / 0.5 * (order - 2) + coPrice + price);
			} else if (special == 4) {
				if (day == 1) {
					restPrice = ADULT_1DAY_ALL;
				} else {
					restPrice = ADULT_AFTER4_ALL;
				}
				price = restPrice * (order - 2) + coPrice + price;
			}
		} else {
			price *= order;
		}
		
		return price;
	}
	
	public static void customer(int ticket, int interAge, int day, int order, int price, int special){
		orderList[position][SAVE_TICKETING] = ticket; 
		orderList[position][SAVE_BIRTH_ID] = interAge;
		orderList[position][SAVE_DAY] = day;
		orderList[position][SAVE_ORDER] = order;
		orderList[position][SAVE_PRICE] = price;
		orderList[position][SAVE_SPECIAL] = special;
	}
	
	public static void specialResult(int ticket, int interAge, int special){
		if (interAge < OLDER_BABY || interAge >= ADULT) {
			customerSpecial(NO_ADVENTAGE);
		} else {
			if (ticket == TICKET_PARK) {
				switch(special){
					case ADVENTAGE_ARMY:
					case ADVENTAGE_PREGNANT:
					case ADVENTAGE_CHILDREN:
						customerSpecial(NO_ADVENTAGE);
						break;
				}
			}
		}
	}
	
	public static void customerSpecial(int special){
		orderList[position][SAVE_SPECIAL] = special;
	}
	
	public static void exit(){
		System.out.println("Ƽ�� �߱��� �����մϴ�. �����մϴ�.\n");
		System.out.println("================== �Ե����� ==================");
		for (int index = 0; index <= position; index++) {
			if (orderList[index][SAVE_TICKETING] == TICKET_ALL) {
				System.out.print("�����̿�� ");
			} else {
				System.out.print("��ũ�̿�� ");
			}
			if (orderList[index][SAVE_BIRTH_ID] < YOUNGER_BABY)  {
				System.out.print("12���� �̸� ���̺� ");
			} else if (orderList[index][SAVE_BIRTH_ID] < OLDER_BABY) {
				System.out.print("36���� �̸� ���̺� ");
			} else if (orderList[index][SAVE_BIRTH_ID] < CHILD) {
				System.out.print("��� ");
			} else if (orderList[index][SAVE_BIRTH_ID] < TEEN) {
				System.out.print("û�ҳ� ");
			} else if (orderList[index][SAVE_BIRTH_ID] < ADULT) {
				System.out.print("� ");
			} else {
				System.out.print("65�� �̻� � ");
			}
			if (orderList[index][SAVE_DAY] == ONEDAY) {
				System.out.print("1Day ");
			} else {
				System.out.print("After4 ");
			}
			System.out.print("X     " + orderList[index][SAVE_ORDER] + "     ");
			System.out.print(orderList[index][SAVE_PRICE] + "��");
			totalPrice += orderList[index][SAVE_PRICE];
			if (orderList[index][SAVE_SPECIAL] == NO_ADVENTAGE) {
				System.out.println(" * ������� ����");
			} else if (orderList[index][SAVE_SPECIAL] == ADVENTAGE_DISABLED) {
				System.out.println(" * ����� �������");
			} else if (orderList[index][SAVE_SPECIAL] == ADVENTAGE_NATIONAL_MERIT) {
				System.out.println(" * ���������� �������");
			} else if (orderList[index][SAVE_SPECIAL] == ADVENTAGE_ARMY) {
				System.out.println(" * �ް��庴 �������");
			} else if (orderList[index][SAVE_SPECIAL] == ADVENTAGE_PREGNANT) {
				System.out.println(" * �ӻ�� �������");
			} else if (orderList[index][SAVE_SPECIAL] == ADVENTAGE_CHILDREN) {
				System.out.println(" * �ٵ��� �ູī�� �������");
			} 
		}
		System.out.println("\n����� �Ѿ��� " + totalPrice + "�� �Դϴ�.");
		System.out.println("==============================================\n");
	}
	
	public static void lastExit(){
		Scanner scanner = new Scanner(System.in);
		System.out.print("��� ����(1: ���ο� �ֹ�, 2: ���α׷� ����) : ");
		isExit = scanner.nextInt();
	}

}