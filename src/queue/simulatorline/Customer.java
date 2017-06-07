package queue.simulatorline;

/**
 * @author Administrator
 */
public class Customer {
	private int arrivalTime;// 顾客到达时间
	private int transactionTime;// 顾客交易时间
	private int customerNumber;// 顾客序号

	public Customer() {
	}

	public Customer(int arrivalTime, int transactionTime, int customerNumer) {
		super();
		this.arrivalTime = arrivalTime;
		this.transactionTime = transactionTime;
		this.customerNumber = customerNumer;
	}

	int getArrivalTime() {
		return arrivalTime;
	}

	void setArrivalTime(int arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	int getTransactionTime() {
		return transactionTime;
	}

	void setTransactionTime(int transactionTime) {
		this.transactionTime = transactionTime;
	}

	int getCustomerNumber() {
		return customerNumber;
	}

	void setCustomerNumber(int customerNumber) {
		this.customerNumber = customerNumber;
	}


}
