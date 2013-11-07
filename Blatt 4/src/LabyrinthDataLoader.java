import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public final class LabyrinthDataLoader
{
    private LabyrinthDataLoader()
    {
    };

    public static char[][] load(String filename)
    {
        char[][] result = new char[0][0];
        
        try
        {
            String s = readFile(filename, StandardCharsets.UTF_8);
            
            String[] lines = s.split("\r\n");
            result = new char[lines.length][lines[0].length()];
            
            for(int y = 0; y < lines.length; ++y)
            {
                for(int x = 0; x < lines[0].length(); ++x)
                {
                    result[y][x] = lines[y].charAt(x);
                }
            }
        }
        catch(Exception e)
        {
            System.err.println("Holy sweet Jesus! Something went terribly wrong, run!!!");
        }
        
        return result;
    }

    private static String readFile(String path, Charset encoding) throws IOException
    {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return encoding.decode(ByteBuffer.wrap(encoded)).toString();
    }
}
