
/**
 * Write a description of class FinalLab here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.awt.*;
import java.util.*;
import java.util.List;
public class FinalLab
{
    public static void main(String[] args)
    {
        Picture nicksKitchen = new Picture("images/nickDigi.jpg");
        //sepia(nicksKitchen);
        mirrorVertical(nicksKitchen);
        nicksKitchen.explore();
    }
    
    public static void mirrorVertical(Picture source)
    {
        int width = source.getWidth();
        int mirrorPoint = width/2;
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        
        for(int y = 0; y < source.getHeight(); y++)
        {
            // loop from 0 to the middle
            for(int x = 0; x < mirrorPoint; x++)
            {
               leftPixel = source.getPixel(x, y);
               rightPixel = source.getPixel(width - 1 - x, y);
               rightPixel.setColor(leftPixel.getColor());
            }
        }
    
    }
    
    public static void negate(Picture source)
    {
        Pixel pixel = null;
        for(int y = 0; y < source.getHeight(); y++)
        {
            for(int x = 0; x < source.getWidth(); x++)
            {   
                
                pixel = source.getPixel(x, y);
                int r = Math.abs(255 - pixel.getRed());
                int g = Math.abs(255 - pixel.getGreen());
                int b = Math.abs(255 - pixel.getBlue());
                int ogR = pixel.getRed();
                int ogG = pixel.getGreen();
                int ogB = pixel.getBlue();
                if(ogR - ogG - ogB > 80)
                {
                    Random gen = new Random();
                    int num = gen.nextInt(255);
                    int num1 = gen.nextInt(255);
                    int num2 = gen.nextInt(255);
                    //pixel.setColor(new Color(num, num1, num2));
                }
                pixel.setColor(new Color(r,g,b));
            }
        }
        
    }
    
    public static void grayscale(Picture source)
    {       
        Pixel pixel = null;
        
        for(int y = 0; y < source.getHeight(); y++)
        {
            // loop from 0 to the middle
            for(int x = 0; x < source.getWidth(); x++)
            {
               pixel = source.getPixel(x, y);
               int avg = (int) ((pixel.getRed() + pixel.getGreen() + pixel.getBlue()) / 3);
               
               
        
               pixel.setColor(new Color(avg, avg, avg));
            }
        }
    }
    
    
    
    public static void redify(Picture source)
    {       
        Pixel pixel = null;
        
        for(int y = 0; y < source.getHeight(); y++)
        {
            // loop from 0 to the middle
            for(int x = 0; x < source.getWidth(); x++)
            {
               pixel = source.getPixel(x, y);
               int avg = (int) ((pixel.getRed() + pixel.getGreen() + pixel.getBlue()) / 3);
               
               
        
               pixel.setColor(new Color(avg, 0, 0));
            }
        }
    }
    
    
    public static void redOverlay(Picture source)
    {       
        Pixel pixel = null;
        
        for(int y = 0; y < source.getHeight(); y++)
        {
            // loop from 0 to the middle
            for(int x = 0; x < source.getWidth(); x++)
            {
               pixel = source.getPixel(x, y);
               int r1 = pixel.getRed();
               int g1 = pixel.getGreen();
               int b1 = pixel.getBlue();
               
               r1 += 80;
               g1 -= 40;
               b1 -= 40;
        
               if(r1 > 255)
               {
                   r1=255;
               }
               if(g1<0)
               {
                   g1 = 0;
               }
               if(b1 < 0) {
                   b1 = 0;
               }
               pixel.setColor(new Color(r1,g1,b1));
            }
        }
    }
    
    public static void copytoCanvas(Picture source, Picture canvas, int startX, int startY)
    {
        Pixel sourcePix = null;
        Pixel canvasPix = null;
      
        for (int sourceX = 0; sourceX < source.getWidth(); sourceX++)
        {
            for (int sourceY = 0; sourceY < source.getHeight(); sourceY++)
            {
                if (sourceX + startX < canvas.getWidth() && sourceY + startY < canvas.getHeight())

                {
                    sourcePix = source.getPixel(sourceX, sourceY);
                    canvasPix = canvas.getPixel(sourceX + startX, sourceY + startY);

                    canvasPix.setColor(sourcePix.getColor());
                }
            }
        }
    }
}
