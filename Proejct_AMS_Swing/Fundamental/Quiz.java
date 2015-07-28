class Quiz {

	static void Quiz1(){
		/*
		 *****
		 *****
		 *****
		 *****
		 *****
		*/

		for (int i = 0; i < 5 ; i++){
			for (int j = 0; j < 5 ; j++){
				System.out.print("*");
			}
			System.out.println();
		}

	}
	
	static void Quiz2(){
		/*
		 *
		 **
		 ***
		 ****
		 *****
		*/

		for (int i = 0; i < 5 ; i++){
			for (int j = 0; j <= i; j++){
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	static void Quiz3(){
		/*
		 *****
		 ****
		 ***
		 **
		 *
		*/

		for (int i = 0; i < 5 ; i++){
			for (int j = 5; j > i; j--){
				System.out.print("*");
			}
			System.out.println();
		}

	}
	
	static void Quiz4(){
		/*
		      *
		     **
		    ***
		   ****
		  *****
		*/

		for (int i = 0; i < 5 ; i++){
			for (int j = 3; i <= j; j--){
				System.out.print(" ");
			}
			for (int j = 0; j <= i; j++){
				System.out.print("*");
			}
			System.out.println();
		}

	}
	
	static void Quiz5(){
		/*
		*****
		 ****
		  ***
		   **
		    *
		*/
	}
	
	static void Quiz6(){
		/*
		    *
		   ***
		  *****
		 *******
		*********
		*/

	}
	




	public static void main(String[] args)	{
		//Quiz1();
		//Quiz2();
		//Quiz3();
		Quiz4();
		//Quiz5();
		//Quiz6();
	}
}
