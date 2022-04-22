package Mini0408;

import java.io.IOException;

public class TicketSystemClass {
	public OrderData orderItem = new OrderData();
	public InputTicket inputTicket = new InputTicket(orderItem);
	public CalTicket calTicket = new CalTicket(inputTicket);
	public OutputTicket outputTicket = new OutputTicket(calTicket);
	
	void startSystem() throws IOException {
		//doWhile();
		outputTicket.csvResult();
		outputTicket.ticketTypeResult();
		outputTicket.dayResult();
		outputTicket.specialResult();
	}
	
	void calMyAge() {
		outputTicket.calTicket.inputTicket.orderItem.setAgeResult(outputTicket.calTicket.age(outputTicket.calTicket.inputTicket.orderItem.getBirthInt(),
				outputTicket.calTicket.inputTicket.orderItem.getGeneInt()));
	}
	
	void checkCompanion() {
		if (outputTicket.calTicket.inputTicket.orderItem.getOrderCount() > 1) {
			if (outputTicket.calTicket.inputTicket.orderItem.getAdvantageType() == StaticValue.ADVENTAGE_DISABLED || 
					outputTicket.calTicket.inputTicket.orderItem.getAdvantageType() == StaticValue.ADVENTAGE_NATIONAL_MERIT ||
							outputTicket.calTicket.inputTicket.orderItem.getAdvantageType() == StaticValue.ADVENTAGE_ARMY) {
				outputTicket.calTicket.inputTicket.orderItem.setCoPriceResult(outputTicket.calTicket.companionPrice(outputTicket.calTicket.inputTicket.orderItem.getTicketType(), 
						outputTicket.calTicket.inputTicket.orderItem.getDay(), outputTicket.calTicket.inputTicket.orderItem.getAdvantageType()));
			}
		}
	}
	
	void calTicketResult() {
		outputTicket.calTicket.inputTicket.orderItem.setPriceResult(outputTicket.calTicket.ticketResult(outputTicket.calTicket.inputTicket.orderItem.getTicketType(), 
				outputTicket.calTicket.inputTicket.orderItem.getAgeResult(), outputTicket.calTicket.inputTicket.orderItem.getDay(), 
				outputTicket.calTicket.inputTicket.orderItem.getAdvantageType()));
	}
	
	void calLastPrice() {
		outputTicket.calTicket.inputTicket.orderItem.setLastPriceResult(outputTicket.calTicket.lastPrice(outputTicket.calTicket.inputTicket.orderItem.getCoPriceResult(), 
				outputTicket.calTicket.inputTicket.orderItem.getPriceResult(), outputTicket.calTicket.inputTicket.orderItem.getAdvantageType(), 
				outputTicket.calTicket.inputTicket.orderItem.getOrderCount(), outputTicket.calTicket.inputTicket.orderItem.getCoPriceResult(),
				outputTicket.calTicket.inputTicket.orderItem.getDay()));
	}
	
	void specialResult() {
		if (outputTicket.calTicket.inputTicket.orderItem.getAgeResult() < StaticValue.OLDER_BABY || 
				outputTicket.calTicket.inputTicket.orderItem.getAgeResult() >= StaticValue.ADULT) {
			outputTicket.calTicket.customerSpecial(StaticValue.NO_ADVENTAGE);
		} else {
			if (outputTicket.calTicket.inputTicket.orderItem.getTicketType() == StaticValue.TICKET_PARK) {
				if (outputTicket.calTicket.inputTicket.orderItem.getAdvantageType() == StaticValue.ADVENTAGE_ARMY ||
						outputTicket.calTicket.inputTicket.orderItem.getAdvantageType() == StaticValue.ADVENTAGE_PREGNANT || 
								outputTicket.calTicket.inputTicket.orderItem.getAdvantageType() == StaticValue.ADVENTAGE_CHILDREN) {
					outputTicket.calTicket.customerSpecial(StaticValue.NO_ADVENTAGE);
				}
			}
		}
	}
	
	void continueProcess() throws IOException {
		
		while(true){
			int continueNumber;
			
			calMyAge();
							
			checkCompanion();
			
			calTicketResult();
			
			calLastPrice();
			
			outputTicket.customer();
			
			specialResult();
			
			System.out.println(outputTicket.calTicket.inputTicket.orderItem.getLine());
			
			continueNumber = outputTicket.price();
			
			if (continueNumber == StaticValue.CONTINUE_TICKET) {
				outputTicket.dataReset();
			} else if (continueNumber == StaticValue.EXIT) {
				outputTicket.exit();
				outputTicket.listReset();
				break;
			}
		}
	}
	
	void doWhile() throws IOException {
		do{
			continueProcess();
			
			outputTicket.calTicket.inputTicket.lastExit();
		}while(outputTicket.calTicket.inputTicket.orderItem.getIsExit() == StaticValue.CONTINUE_TICKET);
	}
}