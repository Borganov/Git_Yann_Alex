package frameGraphique;

import java.io.IOException;

public class MainStart {
	
	static FrameWalker walk[] = new FrameWalker[16]
;
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		
		
		
//		for(int i = 0;i<16;i++){
//			try { 
//				walk[i] = new FrameWalker(i);
//				walk[i].setVisible(true);
//				Thread.sleep(100);
//			} catch(InterruptedException e) { 
//				e.printStackTrace(); 
//			}
//			
//		}
//		
//		try { 
//			Thread.sleep(1000);
//		} catch(InterruptedException e) { 
//			e.printStackTrace(); 
//		}
//		
//		for(int i = 0;i<16;i++){	
//				walk[i].dispose();
//		}
//		
//		
//		
//		
//
//		FramePrincipal telephone = new FramePrincipal();
//		
//		telephone.setVisible(true);
		
		FrameGame game = new FrameGame(0);
		game.setVisible(true);


	}
		

	

}
