package matrices;

public class Golfo {
	static final int N=5,M=4;
	//static int [][] golfistas_jornadas=new int [N][M];
	static int [][] golfistas_jornadas= {{10,12,10,14},
										 {11,9,13,14},
										 {12,11,10,14},
										 {10,13,10,10},
										 {10,15,12,12}};
	public static void main(String[] args) {
		int [] punt_golf=new int [N];
		//rellenaMatriz();
		muestraResultados();
		calculaPuntosDeJornada(punt_golf);
		calculaMejoresRegistros(punt_golf);
		imprimePodio(punt_golf);
	}
	public static void rellenaMatriz() {
		for (int i=0; i<golfistas_jornadas.length; i++) {
			System.out.println("Jugador "+(i+1)+":");
			for (int j=0; j<golfistas_jornadas[i].length; j++) {
				System.out.println("Introduzca el número de golpes para la jornada "+(j+1)+":");
				golfistas_jornadas[i][j]=Entrada.entero();
			}
		}
	}
	public static void muestraResultados () {
		for (int i=-1; i<golfistas_jornadas[0].length; i++) {
			if (i==-1)
				System.out.print("Jornadas\t");
			else
				System.out.print((i+1)+"\t");
		}
		System.out.println();
		for (int i=0; i<golfistas_jornadas.length; i++) {
			for (int j=-1; j<golfistas_jornadas[i].length; j++) {
				if (j==-1 && j!=i)
					System.out.print("Jugador "+(i+1)+"\t");
				else if (i>=0 && j>=0)
					System.out.print(golfistas_jornadas[i][j]+"\t");
			}
			System.out.println();
		}
	}
	public static void calculaPuntosDeJornada(int [] punt_golf) {
		//int [] comparar= new int [N];
		int [] min= {99,99,99};
		/*
		for (int i=0; i<comparar.length; i++) {
			comparar[i]=99;
		}
		*/
		int i=0,j=0;
		//int k=0;
		for (i=0; i<golfistas_jornadas[0].length; i++) {
			/* MI VERSIÓN SIN CORREGIR
			for (j=0; j<golfistas_jornadas.length; j++) { 
				comparar[j]=golfistas_jornadas[j][i];
			}
			for (k = 0; k < comparar.length; k++) {
				if (min[0]>comparar[k]) {
					min[2]=min[1];
					min[1]=min[0];
					min[0]=comparar[k];
				}
				else if (min[1]>comparar[k] && comparar[k]!=min[0]) {
					min[2]=min[1];
					min[1]=comparar[k];
				}
				else if (min[2]>comparar[k] && comparar[k]!=min[1] && comparar[k]!=min[0]) {
					min[2]=comparar[k];
				}
			}
			*/
			for (j = 0; j < golfistas_jornadas.length; j++) {
				if (min[0]>golfistas_jornadas[j][i]) {
					min[2]=min[1];
					min[1]=min[0];
					min[0]=golfistas_jornadas[j][i];
				}
				else if (min[1]>golfistas_jornadas[j][i] && golfistas_jornadas[j][i]!=min[0]) {
					min[2]=min[1];
					min[1]=golfistas_jornadas[j][i];
				}
				else if (min[2]>golfistas_jornadas[j][i] && golfistas_jornadas[j][i]!=min[1] && golfistas_jornadas[j][i]!=min[0]) {
					min[2]=golfistas_jornadas[j][i];
				}
			}
			for (j=0; j<golfistas_jornadas.length; j++) { 
				if (golfistas_jornadas[j][i]==min[0]) {
					punt_golf[j]+=3;
				}
				else if (golfistas_jornadas[j][i]==min[1] 
						&& golfistas_jornadas[j][i]!=min[0]) {
					punt_golf[j]+=2;
				}
				else if (golfistas_jornadas[j][i]==min[2] 
						&& golfistas_jornadas[j][i]!=min[1] 
						&& golfistas_jornadas[j][i]!=min[0]) {
					punt_golf[j]+=1;
				}
			}
			min[0]=99; min[1]=0; min[2]=0;
		}
		int min2=99;
		for (i=0; i<golfistas_jornadas.length; i++) {
			for (j=0; j<golfistas_jornadas[i].length; j++) {
				if (min2>golfistas_jornadas[i][j])
					min2=golfistas_jornadas[i][j];
			}
		}
		for (i=0; i<golfistas_jornadas.length; i++) {
			for (j=0; j<golfistas_jornadas[i].length; j++) {
				if (min2==golfistas_jornadas[i][j])
					punt_golf[i]+=2;
			}
		}
	}
	public static void calculaMejoresRegistros (int [] pts_golf) {
		int [][] golfistas_jornadas_ordenados=golfistas_jornadas.clone();
		//int [] comparar= new int [N];
		int [] min= {99,99,99};
		for (int i=0; i<golfistas_jornadas_ordenados.length; i++) {
			insercion(golfistas_jornadas_ordenados[i]);
		}
		/* MI VERSIÓN SIN CORREGIR
		for (int j=0; j<golfistas_jornadas_ordenados.length; j++) { 
			comparar[j]=golfistas_jornadas_ordenados[j][golfistas_jornadas_ordenados[j].length-1];
		}
		min[0]=comparar[0];
		for (int k = 1; k < comparar.length; k++) {
			if (min[0]>comparar[k]) {
				min[2]=min[1];
				min[1]=min[0];
				min[0]=comparar[k];
			}
			else if (min[1]>comparar[k] && comparar[k]!=min[0]) {
				min[2]=min[1];
				min[1]=comparar[k];
			}
			else if (min[2]>comparar[k] && comparar[k]!=min[1] && comparar[k]!=min[0]) {
				min[2]=comparar[k];
			}
		}
		*/
		for (int k = 1; k < golfistas_jornadas_ordenados.length; k++) {
			if (min[0]>golfistas_jornadas_ordenados[k][golfistas_jornadas_ordenados[k].length-1]) {
				min[2]=min[1];
				min[1]=min[0];
				min[0]=golfistas_jornadas_ordenados[k][golfistas_jornadas_ordenados[k].length-1];
			}
			else if (min[1]>golfistas_jornadas_ordenados[k][golfistas_jornadas_ordenados[k].length-1]
					&& golfistas_jornadas_ordenados[k][golfistas_jornadas_ordenados[k].length-1]!=min[0]) {
				min[2]=min[1];
				min[1]=golfistas_jornadas_ordenados[k][golfistas_jornadas_ordenados[k].length-1];
			}
			else if (min[2]>golfistas_jornadas_ordenados[k][golfistas_jornadas_ordenados[k].length-1]
					&& golfistas_jornadas_ordenados[k][golfistas_jornadas_ordenados[k].length-1]!=min[1]
					&& golfistas_jornadas_ordenados[k][golfistas_jornadas_ordenados[k].length-1]!=min[0]) {
				min[2]=golfistas_jornadas_ordenados[k][golfistas_jornadas_ordenados[k].length-1];
			}
		}
	}
	static void insercion(int vector[])
	{
		int i, temp, j;
		for (i = 1; i < vector.length; i++) {
			temp = vector[i];
			j = i - 1;
			while ((j >= 0) && (vector[j] < temp)) {
				vector[j + 1] = vector[j];
				j--;
			}
			vector[j + 1] = temp;
		}
	}
	public static void imprimePodio(int [] pts_golf) {
		int max1=0,max2=0,max3=0;
		for (int i=0; i<pts_golf.length; i++) {
			if (pts_golf[i]>max1) {
				max3=max2;
				max2=max1;
				max1=pts_golf[i];
			}
			else if (pts_golf[i]>max2 && max1!=pts_golf[i]) {
				max3=max2;
				max2=pts_golf[i];
			}
			else if (pts_golf[i]>max3 && max1!=pts_golf[i] && max2!=pts_golf[i])
				max3=pts_golf[i];
		}
		System.out.println();
		for (int i=0;i<pts_golf.length;i++) {
			System.out.println("Jug"+(i+1)+": "+pts_golf[i]+" puntos");
		}
		System.out.println();
		System.out.println("\nPrimer puesto:\n");
		for (int i=0; i<pts_golf.length; i++) {
			if (pts_golf[i]==max1)
				System.out.println("\tJugador "+(i+1));
		}
		System.out.println("\nSegundo puesto:\n");
		for (int i=0; i<pts_golf.length; i++) {
			if (pts_golf[i]==max2)
				System.out.println("\tJugador "+(i+1));		
		}
		System.out.println("\nTercero puesto:\n");
		for (int i=0; i<pts_golf.length; i++) {
			if (pts_golf[i]==max3)
				System.out.println("\tJugador "+(i+1));
		}
	}
}