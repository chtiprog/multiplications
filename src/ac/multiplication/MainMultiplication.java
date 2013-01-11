package ac.multiplication;

import java.util.ArrayList;

public class MainMultiplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] chiffreUn = {5,7,4} ; // 275 Le premier à multiplier   475 * 32
		int[] chiffreDeux = {2,3} ; // 332 Le chiffre qui va multiplier le premier
		int retenue = 0 ;
		int multiplication ;
		int BASE = 10 ;
		// Création de l'array contenant le résultat final -------------------
		int tailleResult = chiffreUn.length + chiffreDeux.length ;
		ArrayList<Integer> result = new ArrayList<Integer>(tailleResult) ;
		for(int i = 0 ; i < tailleResult ; ++i){
			result.add(0);
		}
		//--------------------------------------------------------------------
		int addition ; // Le résultat des additions intermédiaires
		int index ; // pour se promener dans result
		
		for(int i = 0 ; i < chiffreDeux.length ; ++i){
			index = i ;
			for(int j = 0 ; j < chiffreUn.length ; ++j){
				
				multiplication = (chiffreDeux[i] * chiffreUn[j]) + retenue ;
				retenue = 0 ; // réinitialisation de la retenue
				
				if(multiplication < BASE) {
					addition = multiplication + result.get(index) ;
					if(addition >= BASE) {
						retenue = addition / BASE ;
						addition %= BASE ;
					}
					result.set(index, addition) ;
				}
				
				else if(multiplication == BASE) {
					result.set(index, (0 + result.get(index))) ;
					retenue = 1 ;
				}
				
				else{
					addition = (multiplication % BASE) + result.get(index) ;
					if(addition >= BASE) {
						retenue = addition / BASE ;
						addition %= BASE ;
					}
					result.set(index, addition ) ;
					while(multiplication % BASE != 0 && multiplication > 1){
						retenue += multiplication / BASE ;
						multiplication /= BASE ;
					} // fin while
					
				}
				index++ ;
			} // fin for j 
			
		} // fin for i
		
		// AFFICHAGE DU RESULTAT :
		for(int elem : result) System.out.println(elem + " ") ;
		
		

	} // fin méthode main

} // fin classe MainMultiplication
