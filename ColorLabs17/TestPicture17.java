
/**
 * Kevin Hayes
 * Test Picture Classes
 *
 * @author (Kevin Hayes)
 * @version (10-19-2016)
 */
import java.awt.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List
public class TestPicture17
{
    
        /**
         * main method, to test the picture
         *
         */
      public static void main(String[] args)
      {
          
             /*
            //relative path
            Picture motorcycle = new Picture("images/nicksKitchen.jpg");
            Pixel[] pixels;

            
            //Adjust blue by a factor
            motorcycle = new Picture("images/nicksKitchen.jpg");
            pixels = motorcycle.getPixels();
            double factor = 2;
            
            for(int i = 0; i < pixels.length; i++)
            {
                int r = pixels[i].getRed();
                int g = pixels[i].getGreen();
                int b = (int) (pixels[i].getBlue() * factor);
                
                if (b > 255)
                {
                    b = 255;
                }
                
                pixels[i].setColor(new Color(r, g, b));
            }
            motorcycle.explore();
             
            //Negate
            motorcycle = new Picture("images/redMotorcycle.jpg");
            pixels = motorcycle.getPixels();
            for(int i = 0; i < pixels.length; i++)
            {
                int r = Math.abs(255 - pixels[i].getRed());
                int g = Math.abs(255 - pixels[i].getGreen());
                int b = Math.abs(255 - pixels[i].getBlue());
                pixels[i].setColor(new Color(r, g, b));
            }
            motorcycle.explore();
            
            
            //Grayscale
            pixels = motorcycle.getPixels();
            for(int i = 0; i < pixels.length; i++)
            {
                int r = pixels[i].getRed();
                int g = pixels[i].getGreen();
                int b = pixels[i].getBlue();
                int avg = (int) ((r + g + b) / 3);
            
                pixels[i].setColor(new Color(avg, avg, avg));
            }
            motorcycle.explore();
            
            
            //Lighten
            motorcycle = new Picture("images/redMotorcycle.jpg");
            pixels = motorcycle.getPixels();
            for(int i = 0; i < pixels.length; i++)
            {
                int r = (int) (1.5 * pixels[i].getRed());
                int g = (int) (1.5 * pixels[i].getGreen());
                int b = (int) (1.5 * pixels[i].getBlue());
                
                if (r > 255)
                {
                    r = 255;
                }
                if (g > 255)
                {
                    g = 255;
                }
                if (b > 255)
                {
                    b = 255;
                }
                pixels[i].setColor(new Color(r, g, b));
            }
            motorcycle.explore();
            
            
            //changecolor method
            motorcycle = new Picture("images/redMotorcycle.jpg");
            pixels = motorcycle.getPixels();
            int adjRed = 50;
            int adjGreen = 13;
            int adjBlue = 90;
            for(int i = 0; i < pixels.length; i++)
            {
                int r = pixels[i].getRed() + adjRed;
                int g = pixels[i].getGreen() + adjGreen;
                int b = pixels[i].getBlue() + adjBlue;
                
                if (r > 255)
                {
                    r = 255;
                }
                if (g > 255)
                {
                    g = 255;
                }
                if (b > 255)
                {
                    b = 255;
                }
                
                if (r < 0)
                {
                    r = 0;
                }
                if (g < 0)
                {
                    g = 0;
                }
                if (b < 0)
                {
                    b = 0;
                }
                pixels[i].setColor(new Color(r, g, b));
                
            }
            motorcycle.explore();
            
            
            //Colorify method
            motorcycle = new Picture("images/nicksKitchen.jpg");
            pixels = motorcycle.getPixels();
            for(int i = 0; i < pixels.length; i++)
            {
                int r = pixels[i].getRed();
                int g = pixels[i].getGreen();
                int b = pixels[i].getBlue();
                
                if (r > 100 && g < 60 && b < 60)
                {
                    g += 150;
                    r -= 100;
                }
            
                pixels[i].setColor(new Color(r, g, b));
            }
            */
            
            
            Picture nicksKitchen = new Picture("images/KSI.jpg");
            //mirrorVertical(nicksKitchen);
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
    
    public static void copytoCanvas(Picture source, Picture target)
    {
        Pixel sourcePix = null;
        Pixel targetPix = null;
        
        for(int sourceX = 0, targetX = 0; sourceX < source.getWidth(); sourceX++, targetX++)
        {
            for(int sourceY = 0, targetY = 0; sourceY < source.getHeight(); sourceY++, targetY++)
            {
                sourcePix = source.getPixel(sourceX, sourceY);
                targetPix = target.getPixel(targetX, targetY);
                
                targetPix.setColor(sourcePix.getColor());
            }
        }
    }
    }
    //main
  //class
  
