
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
        Picture nick1 = new Picture("images/nickDigi.jpg");
        Picture nick2 = new Picture("images/nickDigi.jpg");
        Picture nick3 = new Picture("images/nickDigi.jpg");
        Picture nick4 = new Picture("images/nickDigi.jpg");
        Picture nick5 = new Picture("images/nickDigi.jpg");
        Picture nick6 = new Picture("images/nickDigi.jpg");
        
        Picture canvas = new Picture("images/emptyPoster.jpg");
        
        
        int width = nick1.getWidth();
        int height = nick1.getHeight();
        
        // ORIGINAL ORIGINAL ORIGINAL ORIGINAL ORIGINAL
        copyToCanvas(nick1, canvas, 0, 0); 
        nick1.write("images/nickPart1.jpg");
         
        
        // REDIFY REDIFY REDIFY REDIFY REDIFY
        nick2 = darkcontrastBETTERTHANgrayscale(nick2, 2);
        nick2 = redify(nick2);
        copyToCanvas(nick2, canvas, width, 0);
        nick2.write("images/nickPart2.jpg");

        
        // NEGATE NEGATE NEGATE NEGATE NEGATE
        nick3 = negate(nick3);
        copyToCanvas(nick3, canvas, width * 2, 0);
        nick3.write("images/nickPart3.jpg");

        
        // GREYSCALE GREYSCALE GREYSCALE GREYSCALE GREYSCALE
        nick4 = darkcontrastBETTERTHANgrayscale(nick4, 3);
        copyToCanvas(nick4, canvas, 0, height);
        nick4.write("images/nickPart4.jpg");

        // CHROMATIC CHROMATIC CHROMATIC CHROMATIC CHROMATIC
        nick5 = chroma(nick5);
        copyToCanvas(nick5, canvas, width, height);
        nick5.write("images/nickPart5.jpg");

        
        // RECURSIVE RECURSIVE RECURSIVE RECURSIVE RECURSIVE
        nick6 = recursive(nick6);
        copyToCanvas(nick6, canvas, width * 2, height);
        nick6.write("images/nickPart6.jpg");
        
        canvas.write("images/finalProject.jpg");
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
    
    public static Picture negate(Picture source)
    {
        Picture newPic = new Picture(source.getWidth(), source.getHeight());
        Pixel pixel = null;
        for(int y = 0; y < source.getHeight(); y++)
        {
            for(int x = 0; x < source.getWidth(); x++)
            {   
                
                pixel = source.getPixel(x, y);
                Pixel newPixel = newPic.getPixel(x, y);
                int r = Math.abs(255 - pixel.getRed());
                int g = Math.abs(255 - pixel.getGreen());
                int b = Math.abs(255 - pixel.getBlue());
                
                newPixel.setColor(new Color(r,g,b));
            }
        }
        
        return newPic;
    }
    
    public static Picture darkcontrastBETTERTHANgrayscale(Picture source, double darkfactor)
    {       
        Picture newPic = new Picture(source.getWidth(), source.getHeight());
        Pixel pixel = null;
        
        for(int y = 0; y < source.getHeight(); y++)
        {
            // loop fromQ 0 to the middle
            for(int x = 0; x < source.getWidth(); x++)
            {
               pixel = source.getPixel(x, y);
               Pixel newPixel = newPic.getPixel(x, y);
    
               int avg = (int) ((pixel.getRed() + pixel.getGreen() + pixel.getBlue()) / 3);
               double percent = avg / 255.0;      
               double contrast = Math.pow(percent, darkfactor);
               int avg2 = (int)(contrast * 255);
               newPixel.setColor(new Color(avg2, avg2, avg2));
            }
        }
        
        return newPic;
    }
    
    
    
    public static Picture chroma(Picture source)
    {       
        Picture newPic = new Picture(source.getWidth(), source.getHeight());
        
        for(int y = 0; y < source.getHeight(); y++)
        {
            for(int x = 0; x < source.getWidth(); x++)
            {
               Pixel currentPixel = source.getPixel(x, y);
               
               int b = currentPixel.getBlue();
               
               int negativeXshift = x - 30;
               if (negativeXshift < 0) 
               {
                   negativeXshift = 0;
               }
               int r = source.getPixel(negativeXshift, y).getRed();
            
               
               int positiveXshift = x + 30;
               if (positiveXshift > source.getWidth() - 1) 
               {
                    positiveXshift = source.getWidth() - 1;
               }
               int g = source.getPixel(positiveXshift, y).getGreen();
               
               Pixel newPixel = newPic.getPixel(x, y);
               newPixel.setColor(new Color(r, g, b));
            }
        }
        return newPic;
    }
        
    public static Picture redify(Picture source)
    {       
        Picture newPic = new Picture(source.getWidth(), source.getHeight());
        Pixel pixel = null;
        
        for(int y = 0; y < source.getHeight(); y++)
        {
            for(int x = 0; x < source.getWidth(); x++)
            {
               pixel = source.getPixel(x, y);
               Pixel newPixel = newPic.getPixel(x, y);
               int avg = (int) ((pixel.getRed() + pixel.getGreen() + pixel.getBlue()) / 3);
               
               
               newPixel.setColor(new Color(avg, 0, 0));
            }
        }
        return newPic;
    }
    

    
    
    
    public static Picture recursive(Picture source)
    {    
        
        
        if (source.getWidth() < 20 || source.getHeight() < 10)
        {
            return source;
        }
    
        Picture newPic = new Picture(source.getWidth() / 2, source.getHeight() / 2);
        
        for (int y = 0; y < newPic.getHeight(); y++)
        {
            for (int x = 0; x < newPic.getWidth(); x++)
            {
                Pixel pixel = source.getPixel(x * 2, y * 2);
                Pixel newPixel = newPic.getPixel(x, y);
    
                newPixel.setColor(new Color(pixel.getRed(), pixel.getGreen(), pixel.getBlue()));
            
            }
        }
        
        Picture newRecursive = recursive(newPic);
        int bottomRightX = source.getWidth() - newRecursive.getWidth();
        int bottomRightY = source.getHeight() - newRecursive.getHeight();
        
        for (int y = 0; y < newRecursive.getHeight(); y++)
        {
            for (int x = 0; x < newRecursive.getWidth(); x++)
            {
                Pixel pixel = source.getPixel(x + bottomRightX, y + bottomRightY);
                Pixel newPixel = newRecursive.getPixel(x, y);
                pixel.setColor(new Color(newPixel.getRed(), newPixel.getGreen(), newPixel.getBlue()));
            }
        }
    
        return source;
    }
    
    
    public static void copyToCanvas(Picture source, Picture canvas, int startX, int startY)
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
