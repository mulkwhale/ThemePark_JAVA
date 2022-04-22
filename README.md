# ThemePark_JAVA
주제: 놀이공원 자유이용권 계산 프로그램
주요기능
 - 사용자의 나이, 희망 권종, 우대사항 등을 이용하여 해당 자유이용권을 계산

클래스
 - Main (메인 클래스)
    TicketSystem 클래스 연결
    TicketSystem 클래스 호출
 - StaticValue
    상수 클래스
 - OrderData (변수 클래스)
    데이터 관리 클래스
    여러 클래스에서 쓰이는 변수 모아둔 클래스
 - InputTicket (입력 클래스)
    OrderData 클래스 호출
    OrderData 클래스 연결
    Scanner 클래스를 이용한 입력 함수
    FileWriter 클래스로 csv 파일을 만드는 입력 함수
 - CalTicket (계산 클래스)
    InputTicket 클래스 호출
    InputTicket 클래스 연결
    나이 계산 함수
    동반인 금액 계산 함수
    구매자 티켓 금액 계산 함수
    구매자와 동반인 티켓 최종 금액 계산 함수
    최종 우대조건 조정 함수
 - OutputTicket (출력 클래스)
    CalTicket 클래스 호출
    CalTicket 클래스 연결
    최종 가격 출력 함수
    티켓 발권을 종료, 주문 리스트, 입장료 총액 출력 함수
    ArrayList 값 저장 함수
    한 사람의 주문을 담기 위해 변수 클래스 초기화 함수
    여러 주문을 담기 위해 ArrayList 초기화 함수
    입력 저장된 csv 파일을 읽어 출력, 권종 별 판매 현황을 출력하는 함수
    권종 별 판매현황 출력 함수
    일자별 매출 현황 출력 함수
    우대권 판매 현황 출력 함수
 - TicketSystemClass (프로그램 구동 클래스)
    OutputTicket → CalTicket → InputTicket → OrderData 연결
    프로그램 구동 함수
    나이 받아오는 함수
    동반인이 있는지 확인하는 함수
    최종 금액을 받아오는 함수
    우대조건 조정 함수
    여러 사람 주문을 받기 위한 함수
    새로 발권을 하기 위한 함수
