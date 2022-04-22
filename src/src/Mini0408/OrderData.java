package Mini0408;

public class OrderData {
	private int ticketType;
	private int day;
	private String IDNumber;
	private int orderCount;
	private int advantageType;
	private int birthInt;
	private int geneInt;
	private int coPriceResult;
	private int ageResult;
	private int priceResult;
	private int lastPriceResult;
	private int totalPrice;
	private int isExit;
	private int continueNumber;
	private String line = "";
	private String[] lineTicketType;
	private String[] lineAgeResult;
	private String[] lineDay;
	private String[] lineAdvantageType;
	private int date;
	private int indexAge;
	private int countTicketAll;


	public int getCountTicketAll() {
		return countTicketAll;
	}

	public void setCountTicketAll(int countTicketAll) {
		this.countTicketAll = countTicketAll;
	}

	public int getIndexAge() {
		return indexAge;
	}

	public void setIndexAge(int indexAge) {
		this.indexAge = indexAge;
	}

	public String[] getLineAgeResult() {
		lineAgeResult = new String[6];
		lineAgeResult[0] = "12개월 미만 베이비";
		lineAgeResult[1] = "36개월 미만 베이비";
		lineAgeResult[2] = "어린이";
		lineAgeResult[3] = "청소년";
		lineAgeResult[4] = "어른";
		lineAgeResult[5] = "65세 이상 어른";
		
		return lineAgeResult;
	}

	public void setLineAgeResult(String[] lineAgeResult) {
		this.lineAgeResult = lineAgeResult;
	}

	public String[] getLineDay() {
		lineDay = new String[2];
		lineDay[0] = "1Day";
		lineDay[1] = "After4";
		
		return lineDay;
	}

	public void setLineDay(String[] lineDay) {
		this.lineDay = lineDay;
	}

	public String[] getLineAdvantageType() {
		lineAdvantageType = new String[6];
		lineAdvantageType[0] = "없음";
		lineAdvantageType[1] = "장애인";
		lineAdvantageType[2] = "국가유공자";
		lineAdvantageType[3] = "휴가장병";
		lineAdvantageType[4] = "임산부";
		lineAdvantageType[5] = "다둥이 행복카드";
		
		return lineAdvantageType;
	}

	public void setLineAdvantageType(String[] lineAdvantageType) {
		this.lineAdvantageType = lineAdvantageType;
	}

	public String[] getLineTicketType() {
		lineTicketType = new String[2];
		lineTicketType[0] = "종합이용권";
		lineTicketType[1] = "파크이용권";
		
		return lineTicketType;
	}
	
	public void setLineTicketType(String[] lineTicketType) {
		this.lineTicketType = lineTicketType;
	}
	
	public String getLine() {
		return line;
	}
	
	public void setLine(String line) {
		this.line += line;
	}
	
	public int getContinueNumber() {
		return continueNumber;
	}
	public void setContinueNumber(int continueNumber) {
		this.continueNumber = continueNumber;
	}
	public int getTicketType() {
		return ticketType;
	}
	public void setTicketType(int ticketType) {
		this.ticketType = ticketType;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public String getIDNumber() {
		return IDNumber;
	}
	public void setIDNumber(String iDNumber) {
		IDNumber = iDNumber;
	}
	public int getOrderCount() {
		return orderCount;
	}
	public void setOrderCount(int orderCount) {
		this.orderCount = orderCount;
	}
	public int getAdvantageType() {
		return advantageType;
	}
	public void setAdvantageType(int advantageType) {
		this.advantageType = advantageType;
	}
	public int getBirthInt() {
		return birthInt;
	}
	public void setBirthInt(int birthInt) {
		this.birthInt = birthInt;
	}
	public int getGeneInt() {
		return geneInt;
	}
	public void setGeneInt(int geneInt) {
		this.geneInt = geneInt;
	}
	public int getCoPriceResult() {
		return coPriceResult;
	}
	public void setCoPriceResult(int coPriceResult) {
		this.coPriceResult = coPriceResult;
	}
	public int getAgeResult() {
		return ageResult;
	}
	public void setAgeResult(int ageResult) {
		this.ageResult = ageResult;
	}
	public int getPriceResult() {
		return priceResult;
	}
	public void setPriceResult(int priceResult) {
		this.priceResult = priceResult;
	}
	public int getLastPriceResult() {
		return lastPriceResult;
	}
	public void setLastPriceResult(int lastPriceResult) {
		this.lastPriceResult = lastPriceResult;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public int getIsExit() {
		return isExit;
	}
	public void setIsExit(int isExit) {
		this.isExit = isExit;
	}

	public int getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date = date;
	}
}