/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfinal;

/**
 *
 * @author navne
 */
public class Screen {
    Screen(){
      SplashScreen nav = new SplashScreen();
        nav.setVisible(true);
        try{
            for(int i=0; i<=100; i++){
                Thread.sleep(40);
                nav.loadingnum.setText(Integer.toString(i)+"%");
                nav.loadingbar.setValue(i);
                
            
            }
            nav.setVisible(false);
            new Start().setVisible(true);
            
        }
        catch(Exception e){
        
        }  
    }
    
    public static void main(String[] args){
        SplashScreen nav = new SplashScreen();
        nav.setVisible(true);
        try{
            for(int i=0; i<=100; i++){
                Thread.sleep(40);
                nav.loadingnum.setText(Integer.toString(i)+"%");
                nav.loadingbar.setValue(i);
                
            
            }
            
        }
        catch(Exception e){
        
        }
                
    
    
    }
    
    
    
}
