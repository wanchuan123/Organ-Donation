package Common.Interfaces;

import java.io.IOException;
import java.net.InetAddress;
import java.util.Vector;

public interface ITCPServer {
	
	public void startServer();
	
	public void BroadcastAllClient() throws IOException;
	
	public Vector<InetAddress> getClientIPTable();
	
}
