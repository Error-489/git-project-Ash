import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Git 
{
	public static void init() throws IOException
	{
			Path git = Paths.get("git");
			Path objects = git.resolve("objects");
			Path index = git.resolve("index");
			Path HEAD = git.resolve("HEAD");
			boolean exists = Files.isDirectory(git) && Files.isRegularFile(objects) && Files.isRegularFile(index) && Files.isDirectory(HEAD);
			
			Files.createDirectories(objects);

			if(Files.notExists(index)){
			Files.createFile(index);
			}
			if(Files.notExists(HEAD)){
					Files.createFile(HEAD);
					}
			
			if(exists)
				{
			System.out.println("Git Repository Already Exists");
			}
			else
			{
				System.out.println("Git Repository Created");
			}
	}
		public static void main(String[] args) throws IOException 
		{
		init();
		}
}

