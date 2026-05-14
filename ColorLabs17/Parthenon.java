
/**
 * Write a description of class FinalLab here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Parthenon
{
    public static void main(String[] args)
    {
        Picture parthenon = new Picture("images/temple.jpg");
        mirrorVertical(parthenon);
        parthenon.explore();
    }
    
    public static void mirrorVertical(Picture source)
    {
        int width = source.getWidth();
        int mirrorPoint = width/2;
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        
        for(int y = 0; y < 105; y++)
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
