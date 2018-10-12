/* 冒泡升序 */		
		/*System.out.println("冒泡升序");
		for(int k = 0; k < 10; k++){
			for(int l = 0; l < 10; l++){
				int j = l + 1;
				for(int i = k; i < 10; i++){
					for(; j < 9; j++){
						if(randomm[k][l] > randomm[i][j]){
							int min = randomm[k][l];
							randomm[k][l] = randomm[i][j];
							randomm[i][j] = min;
						}
					}
 					j = 0;
				}
				System.out.print(randomm[k][l] + "  ");
		
			}
			System.out.println();
		}
		System.out.println();
*/
		// int tmp;
		// for(int k = 0; k < 10; k++){
		// 	for(int l = 0; l < 9; l++){
		// 		for(int i = l+1; i<10; i++){
		// 			if(randomm[k][l] > randomm[k][i]){
		// 				tmp = randomm[k][l];
		// 				randomm[k][l] = randomm[k][i];
		// 				randomm[k][i] = tmp;
		// 			}
		// 		}
					
		// 	}
		// }


		// for(int i=0; i<10; i++){
		// 	for(int j=0; j<10; j++){
		// 		for(int x=0; x<9; x++){
					
		// 			if(randomm[i][x]>randomm[i][x+1]){
		// 				int tmp = randomm[i][x];
		// 				randomm[i][x] = randomm[i][x+1];
		// 				randomm[i][x+1] = tmp;
		// 			}
		// 		}
		// 		if(j == 9 && i != 9 && randomm[i][j]> randomm[i+1][0]){
		// 			int tmp = randomm[i][j];
		// 			randomm[i][j] = randomm[i+1][0];
		// 			randomm[i+1][0] = tmp;	
		// 		}

		// 	}
		// }
