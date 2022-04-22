package Mini0408;

import java.util.Calendar;

public class CalTicket {	
	public InputTicket inputTicket;
	public CalTicket(InputTicket inputTicket) {
		this.inputTicket = inputTicket;
	}
	
	int age(int birth, int id) {
		Calendar cal = Calendar.getInstance();
		
		int interAge = 0;
				
		int currYear;
		int currMonth;
		int currDay;
		
		// 만나이 계산
		currYear = cal.get(Calendar.YEAR);
		currMonth = cal.get(Calendar.MONTH) + 1;
		currDay = cal.get(Calendar.DAY_OF_MONTH);
		
		if (id < 3) {
			interAge = currYear - (1900 + birth / 10000) - 1;
		} else {
			interAge = currYear - (2000 + birth / 10000) - 1;
		}
		if (birth % 10000 <= (currMonth * 100 + currDay)) {
			interAge++;
		}
		
		// 전체 날짜
		//inputTicket.orderItem.setDate(currYear * 10000 + currMonth * 100 + currDay);
		
		return interAge;
	}
	
	int companionPrice(int ticket, int day, int special) {
		String coId;
		int coAgeResult = 0;
		int coGeneInt, coBirthInt;
		int coPrice = 0;
		
		if(!(special == StaticValue.ADVENTAGE_ARMY && ticket == StaticValue.TICKET_PARK)){
			coId = inputTicket.coInputData();
			coBirthInt = Integer.parseInt(coId.substring(0, 6));
			coGeneInt = Integer.parseInt(coId.substring(6, 7));
			
			coAgeResult = age(coBirthInt, coGeneInt);
		}
		
		if (ticket == StaticValue.TICKET_ALL) {
			if (day == StaticValue.ONEDAY) {
				if (special == StaticValue.ADVENTAGE_DISABLED || special == StaticValue.ADVENTAGE_NATIONAL_MERIT) {
					if (coAgeResult < StaticValue.CHILD) {
						coPrice = (int) (StaticValue.CHILD_1DAY_ALL * 0.5);
					} else if (coAgeResult < StaticValue.TEEN) {
						coPrice = (int) (StaticValue.TEEN_1DAY_ALL * 0.5);
					} else if (coAgeResult < StaticValue.ADULT) {
						coPrice = (int) (StaticValue.ADULT_1DAY_ALL * 0.5);
					}
				} else if (special == StaticValue.ADVENTAGE_ARMY) {
					if (coAgeResult < StaticValue.CHILD) {
						coPrice = StaticValue.CHILD_ARMY_1DAY;
					} else if (coAgeResult < StaticValue.TEEN) {
						coPrice = StaticValue.TEEN_ARMY_1DAY;
					} else if (coAgeResult < StaticValue.ADULT) {
						coPrice = StaticValue.ADULT_ARMY_1DAY;
					}
				}
			} else {
				if (special == StaticValue.ADVENTAGE_DISABLED || special == StaticValue.ADVENTAGE_NATIONAL_MERIT) {
					if (coAgeResult < StaticValue.CHILD) {
						coPrice = (int) (StaticValue.CHILD_AFTER4_ALL * 0.5);
					} else if (coAgeResult < StaticValue.TEEN) {
						coPrice = (int) (StaticValue.TEEN_AFTER4_ALL * 0.5);
					} else if (coAgeResult < StaticValue.ADULT) {
						coPrice = (int) (StaticValue.ADULT_AFTER4_ALL * 0.5);
					}
				} else if (special == StaticValue.ADVENTAGE_ARMY) {
					if (coAgeResult < StaticValue.CHILD) {
						coPrice = StaticValue.CHILD_ARMY_AFTER4;
					} else if (coAgeResult < StaticValue.TEEN) {
						coPrice = StaticValue.TEEN_ARMY_AFTER4;
					} else if (coAgeResult < StaticValue.ADULT) {
						coPrice = StaticValue.ADULT_ARMY_AFTER4;
					}
				}
			}
		} else {
			if (day == StaticValue.ONEDAY) {
				switch(special){
					case 2:
					case 3:
						if (coAgeResult < StaticValue.CHILD) {
							coPrice = (int) (StaticValue.CHILD_1DAY_PARK * 0.5);
						} else if (coAgeResult < StaticValue.TEEN) {
							coPrice = (int) (StaticValue.TEEN_1DAY_PARK * 0.5);
						} else if (coAgeResult < StaticValue.ADULT) {
							coPrice = (int) (StaticValue.ADULT_1DAY_PARK * 0.5);
						}
						break;
				}
			} else {
				switch(special){
					case 2:
					case 3:
						if (coAgeResult < StaticValue.CHILD) {
							coPrice = (int) (StaticValue.CHILD_AFTER4_PARK * 0.5);
						} else if (coAgeResult < StaticValue.TEEN) {
							coPrice = (int) (StaticValue.TEEN_AFTER4_PARK * 0.5);
						} else if (coAgeResult < StaticValue.ADULT) {
							coPrice = (int) (StaticValue.ADULT_AFTER4_PARK * 0.5);
						}
						break;
				}
			}
		}
		return coPrice;
	}
	
	int ticketResult(int ticket, int interAge, int day, int special) {
		int price = 0;
		
		if (interAge < StaticValue.YOUNGER_BABY) {
			price = StaticValue.FREE;
		} else if (interAge < StaticValue.OLDER_BABY) {
			price = StaticValue.BABY;
		} else {
			if (ticket == StaticValue.TICKET_ALL) {
				if (day == StaticValue.ONEDAY) {
					if (interAge >= StaticValue.ADULT) { // 기타 우대 적용불가
						price = StaticValue.CHILD_1DAY_ALL;
					} else { 
						if (special == StaticValue.NO_ADVENTAGE) {
							if (interAge < StaticValue.CHILD) {
								price = StaticValue.CHILD_1DAY_ALL;
							} else if (interAge < StaticValue.TEEN) {
								price = StaticValue.TEEN_1DAY_ALL;
							} else if (interAge < StaticValue.ADULT) {
								price = StaticValue.ADULT_1DAY_ALL;
							}
						} else if (special == StaticValue.ADVENTAGE_DISABLED || special == StaticValue.ADVENTAGE_NATIONAL_MERIT) {
							if (interAge < StaticValue.CHILD) {
								price = (int) (StaticValue.CHILD_1DAY_ALL * 0.5);
							} else if (interAge < StaticValue.TEEN) {
								price = (int) (StaticValue.TEEN_1DAY_ALL * 0.5);
							} else if (interAge < StaticValue.ADULT) {
								price = (int) (StaticValue.ADULT_1DAY_ALL * 0.5);
							}
						} else if (special == StaticValue.ADVENTAGE_ARMY) {
							if (interAge < StaticValue.CHILD) {
								price = StaticValue.CHILD_ARMY_1DAY;
							} else if (interAge < StaticValue.TEEN) {
								price = StaticValue.TEEN_ARMY_1DAY;
							} else if (interAge < StaticValue.ADULT) {
								price = StaticValue.ADULT_ARMY_1DAY;
							}
						} else if (special == StaticValue.ADVENTAGE_PREGNANT) {
							price = (int) (StaticValue.ADULT_1DAY_ALL * 0.5);
						} else if (special == StaticValue.ADVENTAGE_CHILDREN) {
							if (interAge < StaticValue.CHILD) {
								price = (int) (StaticValue.CHILD_1DAY_ALL * 0.7);
							} else if (interAge < StaticValue.TEEN) {
								price = (int) (StaticValue.TEEN_1DAY_ALL * 0.7);
							} else if (interAge < StaticValue.ADULT) {
								price = (int) (StaticValue.ADULT_1DAY_ALL * 0.7);
							}
						}
					}
				} else { // After4
					if (interAge >= StaticValue.ADULT) { // 기타 우대 적용불가
						price = StaticValue.CHILD_AFTER4_ALL;
					} else {
						if(special == StaticValue.NO_ADVENTAGE) {
							if (interAge < StaticValue.CHILD) {
								price = StaticValue.CHILD_AFTER4_ALL;
							} else if (interAge < StaticValue.TEEN) {
								price = StaticValue.TEEN_AFTER4_ALL;
							} else if (interAge < StaticValue.ADULT) {
								price = StaticValue.ADULT_AFTER4_ALL;
							}
						} else if(special == StaticValue.ADVENTAGE_DISABLED || special == StaticValue.ADVENTAGE_NATIONAL_MERIT) {
							if (interAge < StaticValue.CHILD) {
								price = (int) (StaticValue.CHILD_AFTER4_ALL * 0.5);
							} else if (interAge < StaticValue.TEEN) {
								price = (int) (StaticValue.TEEN_AFTER4_ALL * 0.5);
							} else if (interAge < StaticValue.ADULT) {
								price = (int) (StaticValue.ADULT_AFTER4_ALL * 0.5);
							}
						} else if(special == StaticValue.ADVENTAGE_ARMY) {
							if (interAge < StaticValue.CHILD) {
								price = StaticValue.CHILD_ARMY_AFTER4;
							} else if (interAge < StaticValue.TEEN) {
								price = StaticValue.TEEN_ARMY_AFTER4;
							} else if (interAge < StaticValue.ADULT) {
								price = StaticValue.ADULT_ARMY_AFTER4;
							}
						} else if(special == StaticValue.ADVENTAGE_PREGNANT) {
							price = (int) (StaticValue.ADULT_AFTER4_ALL * 0.5);
						} else if(special == StaticValue.ADVENTAGE_CHILDREN) {
							if (interAge < StaticValue.CHILD) {
								price = (int) (StaticValue.CHILD_AFTER4_ALL * 0.7);
							} else if (interAge < StaticValue.TEEN) {
								price = (int) (StaticValue.TEEN_AFTER4_ALL * 0.7);
							} else if (interAge < StaticValue.ADULT) {
								price = (int) (StaticValue.ADULT_AFTER4_ALL * 0.7);
							}
						}	
					}
				}
			} else { // 파크이용권 
				if (day == StaticValue.ONEDAY) {
					if (interAge >= StaticValue.ADULT) { // 기타 우대 적용불가
						price = StaticValue.CHILD_1DAY_PARK;
					} else {
						if (special == StaticValue.NO_ADVENTAGE || special == StaticValue.ADVENTAGE_ARMY ||
							special == StaticValue.ADVENTAGE_PREGNANT || special == StaticValue.ADVENTAGE_CHILDREN) {
							if (interAge < StaticValue.CHILD) {
								price = StaticValue.CHILD_1DAY_PARK;
							} else if (interAge < StaticValue.TEEN) {
								price = StaticValue.TEEN_1DAY_PARK;
							} else if (interAge < StaticValue.ADULT) {
								price = StaticValue.ADULT_1DAY_PARK;
							}
						} else if (special == StaticValue.ADVENTAGE_DISABLED || special == StaticValue.ADVENTAGE_NATIONAL_MERIT) {
							if (interAge < StaticValue.CHILD) {
								price = (int) (StaticValue.CHILD_1DAY_PARK * 0.5);
							} else if (interAge < StaticValue.TEEN) {
								price = (int) (StaticValue.TEEN_1DAY_PARK * 0.5);
							} else if (interAge < StaticValue.ADULT) {
								price = (int) (StaticValue.ADULT_1DAY_PARK * 0.5);
							}
						}
					}
				} else { // After4
					if (interAge >= StaticValue.ADULT) { // 기타 우대 적용불가
						price = StaticValue.CHILD_AFTER4_PARK;
					} else {
						if (special == StaticValue.NO_ADVENTAGE || special == StaticValue.ADVENTAGE_ARMY ||
							special == StaticValue.ADVENTAGE_PREGNANT || special == StaticValue.ADVENTAGE_CHILDREN) {
							if (interAge < StaticValue.CHILD) {
								price = StaticValue.CHILD_AFTER4_PARK;
							} else if (interAge < StaticValue.TEEN) {
								price = StaticValue.TEEN_AFTER4_PARK;
							} else if (interAge < StaticValue.ADULT) {
								price = StaticValue.ADULT_AFTER4_PARK;
							}
						} else if (special == StaticValue.ADVENTAGE_DISABLED || special == StaticValue.ADVENTAGE_NATIONAL_MERIT) {
							if (interAge < StaticValue.CHILD) {
								price = (int) (StaticValue.CHILD_AFTER4_PARK * 0.5);
							} else if (interAge < StaticValue.TEEN) {
								price = (int) (StaticValue.TEEN_AFTER4_PARK * 0.5);
							} else if (interAge < StaticValue.ADULT) {
								price = (int) (StaticValue.ADULT_AFTER4_PARK * 0.5);
							}
						}
					}
				}
			}
		}
		return price;
	}
	
	int lastPrice(int coPriceResult, int price, int special, int order, int coPrice, int day) {
		int restPrice;
		int priceResult = 0;
		
		if (coPriceResult != 0) {
			if (special == StaticValue.ADVENTAGE_DISABLED || special == StaticValue.ADVENTAGE_NATIONAL_MERIT) {
				priceResult = (int) (price / 0.5 * (order - 2) + coPrice + price);
			} else if (special == StaticValue.ADVENTAGE_ARMY) {
				if (day == 1) {
					restPrice = StaticValue.ADULT_1DAY_ALL;
				} else {
					restPrice = StaticValue.ADULT_AFTER4_ALL;
				}
				priceResult = restPrice * (order - 2) + coPrice + price;
			}
		} else {
			priceResult = price * order;
		}
		
		return priceResult;
	}

	void customerSpecial(int special) {
		inputTicket.orderItem.setAdvantageType(special);
	}
}