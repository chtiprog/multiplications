package ac.multiplication;

import java.util.ArrayList;

public class MainMultiplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] chiffreUn = {9,9} ; // 275 Le premier à multiplier   475 * 32, 97 * 32
		int[] chiffreDeux = {9,9,9} ; // 332 Le chiffre qui va multiplier le premier
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
		int index = 0; // pour se promener dans result
		
		for(int i = 0 ; i < chiffreDeux.length ; ++i){
			if(retenue != 0) {
				result.set(index, retenue) ;
				retenue = 0 ;
			}
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
					while(multiplication % BASE != 0 && multiplication > 1 ){
						retenue += multiplication / BASE ;
						multiplication /= BASE ;
					} // fin while
					if(multiplication > BASE) {
						retenue += multiplication / BASE ;
					}
				}
				index++ ;
			} // fin for j 
			
		} // fin for i
		
		if(retenue != 0) {
			result.set(result.size()-1, retenue) ;
			retenue = 0 ;
		}
		
		
		
		// AFFICHAGE DU RESULTAT :
		for(int elem : result) System.out.println(elem + " ") ;
		
		

	} // fin méthode main

} // fin classe MainMultiplication
