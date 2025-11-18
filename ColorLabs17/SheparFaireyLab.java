
/**
 * Write a description of class SheparFaireyLab here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.awt.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

public class SheparFaireyLab
{
    /**
     * main method, to test the picture
     *  
     */
    public static void main(String[] args)
    {
        
         //opens selfie picture 
          /**/
         
         //relative path
         //change with selfie picture
         Picture me = new Picture("images/redMotorcycle.jpg");
         Pixel[] pixels;
         pixels = me.getPixels();
         
         Color bucket1 = new Color(255, 83, 64);
         Color bucket2 = new Color(247, 244, 215);
         Color bucket3 = new Color(114, 177, 204);
         Color bucket4 = new Color(5, 19, 92);
         
         /**
          * method 1 change
          * 
          * 
          * 
          */
         me = new Picture("images/redMotorcycle.jpg");
         pixels = me.getPixels();
            for(int i = 0; i < pixels.length; i++)
            {
                int r = pixels[i].getRed();
                int g = pixels[i].getGreen();
                int b = pixels[i].getBlue();
                int avg = (int) ((r + g + b) / 3);
                
                if (avg < 64)
                {
                    pixels[i].setColor(bucket4);
                }
                else if (avg < 128)
                {
                    pixels[i].setColor(bucket3);
                }
                else if (avg < 192)
                {
                    pixels[i].setColor(bucket2);
                }
                else if (avg <= 255)
                {
                    pixels[i].setColor(bucket1);
                }
            }
            me.explore();
            me.write("images/zzMethod1.jpg");
         
         /**
          * method 2 change
          * 
          */
         
         me = new Picture("images/redMotorcycle.jpg");
         int max = 0;
         int min = 255;
         double avg = 0;
         pixels = me.getPixels();
            for(int i = 0; i < pixels.length; i++)
            {
                int r = pixels[i].getRed();
                int g = pixels[i].getGreen();
                int b = pixels[i].getBlue();
                avg = (int) ((r + g + b) / 3);
                
                if (avg < min)
                {
                    min = (int) avg;
                }
                if (avg > max)
                {
                    max = (int) avg;
                }
            }
            int range = max - min;
            for(int i = 0; i < pixels.length; i++)
            {
                int r = pixels[i].getRed();
                int g = pixels[i].getGreen();
                int b = pixels[i].getBlue();
                avg = (int) ((r + g + b) / 3);
                if (avg < (int) (range / 4))
                {
                    pixels[i].setColor(bucket4);
                }
                else if (avg < (int) (range / 2))
                {
                    pixels[i].setColor(bucket3);
                }
                else if (avg < (int) ((range * 3)/ 4))
                {
                    pixels[i].setColor(bucket2);
                }
                else if (avg <= (int) (range))
                {
                    pixels[i].setColor(bucket1);
                }
            }
            
            
            me.explore();
            me.write("images/zzMethod2.jpg");
         
         
         /**
          * custom color palette
          */
         
          bucket1 = new Color(0, 0, 0); // black
          bucket2 = new Color(0,255,64); // light green
          bucket3 = new Color(190,92,255); //light purple
          bucket4 = new Color(128,0,255); //purple
          Color bucket5 = new Color(0,0,0); //red
          
          //blood red color scheme
          //bucket1 = new Color(0, 0, 0); // black
          //bucket2 = new Color(255, 0, 0); // bright red
          //bucket3 = new Color(170, 0, 0); //red
          //bucket4 = new Color(85, 0, 0); //dark red
          //Color bucket5 = new Color(0, 0, 0); //black
     
         me = new Picture("images/me1.jpg");
         pixels = me.getPixels();
            for(int i = 0; i < pixels.length; i++)
            {
                int r = pixels[i].getRed();
                int g = pixels[i].getGreen();
                int b = pixels[i].getBlue();
                 avg = (int) ((r + g + b) / 3);
            
                if (avg < 51)
                {
                    pixels[i].setColor(bucket5);
                }
                else if (avg < 102)
                {
                    pixels[i].setColor(bucket4);
                }
                else if (avg < 153)
                {
                    pixels[i].setColor(bucket3);
                }
                else if (avg < 204)
                {
                    pixels[i].setColor(bucket2);
                }
                else if (avg <= 255)
                {
                    pixels[i].setColor(bucket1);
                }
            }
            
            me.explore();
            me.write("images/zzMethod3.jpg");
         
    }//main       
}//class
