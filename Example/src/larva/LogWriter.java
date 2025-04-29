package larva;

import java.util.concurrent.LinkedBlockingQueue;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.atomic.AtomicBoolean;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LogWriter implements Runnable {

public static PrintWriter pw;
public LinkedBlockingQueue<String> queue;

public static AtomicBoolean acceptingLogs = new AtomicBoolean(true);

public LogWriter(LinkedBlockingQueue<String> queue, AtomicBoolean acceptingLogs) {
this.queue = queue;
this.acceptingLogs = acceptingLogs;
}

public void start()
{
Thread t = new Thread(new LogWriter(queue, acceptingLogs));
t.setDaemon(true);
t.start();
}

public void shutdown() {
acceptingLogs.set(false);
System.out.println("No longer writing logs");

 while(!queue.isEmpty()) {
  try {
   Thread.sleep(100);
  } catch (Exception e) {}
 }

try{
 pw.flush();
 pw.close();

 ProcessBuilder pb = new ProcessBuilder("bash", "./scripts/umount.sh");
 pb.inheritIO();
 Process p = pb.start();
 BufferedReader errorReader = new BufferedReader(new InputStreamReader(p.getErrorStream()));
 String line = null;
 while ((line = errorReader.readLine()) != null) { System.err.println(line);}
  int exitCode = p.waitFor();
  System.out.println("umount.sh exited with code: " + exitCode);
 }catch(Exception ex)
  {ex.printStackTrace();}
}

public void run() {
Runtime.getRuntime().addShutdownHook(new Thread(() -> {
 this.shutdown();
}));

DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

try {
 pw = new PrintWriter(new FileWriter("./logs/output_login.txt", true));
} catch (Exception e) {
 System.out.println("Issue creating log file: " + e);}
String s = null;
while(true){
try {
s = queue.take();
pw.println(LocalDateTime.now().format(formatter)+" | "+s);
pw.flush();
} catch (Exception e) {
System.out.println("Exception in LogWriter: " + e);
}}}}