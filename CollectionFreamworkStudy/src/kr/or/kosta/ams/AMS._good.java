//package kr.or.kosta.ams;
//
//import java.util.List;
//
//public class AMS {
//	public static void main(String[] args) {
//		
//		AccountManager accountManager = new AccountManager(50, 2);
//		System.out.println("----- AMS Start up ----");
//		
//		//#1. 계좌 개설 테스트
//		accountManager.openAccount(new Account("1111-1111", "김기정", 1234, 1000));
//		accountManager.openAccount(new Account("1111-2222", "박래빈", 1234, 100000000));
//		accountManager.openAccount(new MinusAccount("2222-1111", "김준기", 1234, 200000000, 3000000000L));
//		accountManager.openAccount(new Account("1111-3333", "송지현", 1234, 300000000));
//		accountManager.openAccount(new MinusAccount("2222-2222", "김대출", 1234, 300000000, 500000000));
//		accountManager.openAccount(new MinusAccount("2222-3333", "김기정", 1234, 300000000, 500000000));
//		System.out.println("총개설된 계좌수 : " + accountManager.getCount());
//		
//		// 전체 계좌 조회 테스트
//		System.out.println("☞전체계좌 조회");
//		List<Account> allList = accountManager.getAccounts();
//		for (Account account : allList) {
//			System.out.println(account);			
//		}
//		
//		// 계좌 조회 테스트
//		System.out.println("☞계좌번호로 계좌 조회");
//		Account getAccount = accountManager.getAccount("1111-4444");
//		if(getAccount != null){
//			System.out.println(getAccount.toString());
//		}else{
//			System.out.println("계좌가 존재하지 않습니다.");
//		}
//		
//		
//		// 예금주명으로 계좌 검색 테스트
//		System.out.println("☞예금주명으로 계좌 검색");
//		List<Account> searchList = accountManager.searchAccount("김기정");
//		if(!searchList.isEmpty()){
//			for(Account account : searchList){
//				if(account != null){
//					if(account instanceof MinusAccount){
//						MinusAccount minusAccount = (MinusAccount)account;
//						System.out.println(minusAccount + "\t "+ minusAccount.getBorrowMoney());
//					}else{
//						System.out.println(account);
//					}
//				}
//			}
//		}else{
//			System.out.println("검색된 계좌가 없습니다.");
//		}
//		
//		// 계좌번호로 계좌 삭제 테스트
//		boolean remove = accountManager.removeAccount("2222-3333");
//		System.out.println("☞계좌번호로 계좌 삭제");
//		if(remove){
//			System.out.println("계좌를 삭제하였습니다.");
//			System.out.println(accountManager.getCount());
//		}else{
//			System.out.println("삭제하고자 하는 계좌가 존재하지 않습니다.");
//		}
//		
//		System.out.println("----- AMS Shut down ---");
//	}
//}
