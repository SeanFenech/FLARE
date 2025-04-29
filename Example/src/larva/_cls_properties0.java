package larva;


import java.lang.Math;
import java.time.LocalTime;

import java.util.LinkedHashMap;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public class _cls_properties0 implements _callable{

public static LinkedBlockingQueue<String> queue; 
public static _cls_properties0 root;
public static Channel d = new Channel();

public static LinkedHashMap<_cls_properties0,_cls_properties0> _cls_properties0_instances = new LinkedHashMap<_cls_properties0,_cls_properties0>();
public static AtomicBoolean acceptingLogs = new AtomicBoolean(true);
static{
try{
RunningClock.start();
try{
ProcessBuilder pb = new ProcessBuilder("bash", "./scripts/setup.sh");
pb.inheritIO();
Process p = pb.start();
BufferedReader errorReader = new BufferedReader(new InputStreamReader(p.getErrorStream()));
String line = null;
while ((line = errorReader.readLine()) != null) { System.err.println(line);}
int exitCode = p.waitFor();
System.out.println("setup.sh exited with code: " + exitCode);
}catch(Exception ex)
{ex.printStackTrace();}

queue = new LinkedBlockingQueue<>();
LogWriter lw = new LogWriter(queue, acceptingLogs);
lw.start();
root = new _cls_properties0();
_cls_properties0_instances.put(root, root);
  root.initialisation();
}catch(Exception ex)
{ex.printStackTrace();}
}

_cls_properties0 parent; //to remain null - this class does not have a parent!
public static double altTakeoff;
public static double gimbalRoll;
public static double altitude;
public static double distance;
public static double batteryTemperature;
public static double latitude;
public static double roll;
public static double rcThrottle;
public static double altSea;
public static double rcAileron;
public static double speed;
public static double ySpeed;
public static double gpsLevel;
public static double zSpeed;
public static double rcRudder;
public static double pitch;
public static String signal;
public static double gimbalHeading;
public static double longitude;
public static double satellites;
public static double dronePitch;
public static double voltageCell2;
public static double gimbalPitch;
public static double xSpeed;
public static double voltageCell1;
public static String flycState;
public static double voltage;
public static double droneRoll;
public static double droneHeading;
public static double batteryPercentage;
public static LocalTime time;
public static double rcElevator;
int no_automata = 8;
 public int badRCStates =0 ;
 public int badGPSStates =0 ;
 public int badSignalStates =0 ;
 public int badCellStates =0 ;
 public boolean look =true ;
 public boolean tooHigh =false ;
public Clock c1 = new Clock(this,"c1");
public Clock c2 = new Clock(this,"c2");
public Clock dc10 = new Clock(this,"dc10");
public Clock dc = new Clock(this,"dc");
 public int abruptChanges =0 ;
 public double lSpeed =0 ;
 public double lSpeedX =0 ;
 public double lSpeedY =0 ;
 public double lSpeedZ =0 ;
 public String signalState ="good";
 public double l_distance =0 ;
 public double l_latitude =0 ;
 public double l_longitude =0 ;
 public double l_altitude =0 ;
 public double l_batteryPercentage =0 ;
 public double l_batteryTemperature =0 ;
 public double l_rcElevator =0 ;
 public double l_rcAileron =0 ;
 public double l_rcThrottle =0 ;
 public double l_rcRudder =0 ;
 public double l_satellites =0 ;
 public double l_gpsLevel =0 ;
 public LocalTime n =LocalTime .now ();
 public LocalTime lt_distance =n ;
 public LocalTime lt_latitude =n ;
 public LocalTime lt_longitude =n ;
 public LocalTime lt_altitude =n ;
 public LocalTime lt_batteryPercentage =n ;
 public LocalTime lt_batteryTemperature =n ;
 public LocalTime lt_rcElevator =n ;
 public LocalTime lt_rcAileron =n ;
 public LocalTime lt_rcThrottle =n ;
 public LocalTime lt_rcRudder =n ;
 public LocalTime lt_satellites =n ;
 public LocalTime lt_gpsLevel =n ;
 public boolean d_location =false ;
 public boolean d_rc =false ;
 public boolean d_gps =false ;
 public boolean d_battery =false ;
 public boolean d_goodCellConsistency =true ;

public static void initialize(){}
//inheritance could not be used because of the automatic call to super()
//when the constructor is called...we need to keep the SAME parent if this exists!

public _cls_properties0() {
c1.register(5000l);
c2.register(30000l);
dc10.register(10000l);
dc.register(1000l);
}

public void initialisation() {

c1 .off ();


c2 .off ();

   c1.reset();
   c2.reset();
   dc10.reset();
   dc.reset();
}

public static _cls_properties0 _get_cls_properties0_inst() { synchronized(_cls_properties0_instances){
 return root;
}
}

public boolean equals(Object o) {
 if ((o instanceof _cls_properties0))
{return true;}
else
{return false;}
}

public int hashCode() {
return 0;
}

public void _call(String _info, int... _event){
synchronized(_cls_properties0_instances){
_performLogic_dataProperty(_info, _event);
_performLogic_cameraProperty(_info, _event);
_performLogic_positionProperty(_info, _event);
_performLogic_RCProperty(_info, _event);
_performLogic_GPSProperty(_info, _event);
_performLogic_batteryProperty(_info, _event);
_performLogic_speedProperty(_info, _event);
_performLogic_windspeedProperty(_info, _event);
}
}

public void _call_all_filtered(String _info, int... _event){
}

public static void _call_all(String _info, int... _event){

_cls_properties0[] a = new _cls_properties0[1];
synchronized(_cls_properties0_instances){
a = _cls_properties0_instances.keySet().toArray(a);}
for (_cls_properties0 _inst : a)

if (_inst != null) _inst._call(_info, _event);
}

public void _killThis(){
try{
if (--no_automata == 0){
synchronized(_cls_properties0_instances){
_cls_properties0_instances.remove(this);}
synchronized(c1){
c1.off();
c1._inst = null;
c1 = null;}
synchronized(c2){
c2.off();
c2._inst = null;
c2 = null;}
synchronized(dc10){
dc10.off();
dc10._inst = null;
dc10 = null;}
synchronized(dc){
dc.off();
dc._inst = null;
dc = null;}
}
else if (no_automata < 0)
{throw new Exception("no_automata < 0!!");}
}catch(Exception ex){ex.printStackTrace();}
}

int _state_id_dataProperty = 0;

public void _performLogic_dataProperty(String _info, int... _event) {
if (acceptingLogs.get()) {
if (! queue.offer("[dataProperty]AUTOMATON ::> dataProperty("+") STATE::>"+ _string_dataProperty(_state_id_dataProperty, 0))){
 System.out.println("SealFS Writing busy, log missed: [dataProperty]AUTOMATON ::> dataProperty("+") STATE::>"+ _string_dataProperty(_state_id_dataProperty, 0));}}

if (0==1){}
else if (_state_id_dataProperty==0){
		if (1==0){}
		else if ((_occurredEvent(_event,74/*dataClock10*/))){
		logData (true ,true ,true ,true );
dc10 .reset ();

		_state_id_dataProperty = 0;//moving to state normal
		_goto_dataProperty(_info);
		}
		else if ((_occurredEvent(_event,76/*dataClock1*/))){
		logData (d_location ,d_rc ,d_gps ,d_battery );
dc .reset ();

		_state_id_dataProperty = 0;//moving to state normal
		_goto_dataProperty(_info);
		}
		else if ((_occurredEvent(_event,0/*dataLocation*/))){
		l_distance =distance ;
lt_distance =time ;
l_latitude =latitude ;
lt_latitude =time ;
l_longitude =longitude ;
lt_longitude =time ;

		_state_id_dataProperty = 0;//moving to state normal
		_goto_dataProperty(_info);
		}
		else if ((_occurredEvent(_event,2/*dataAltitude*/))){
		l_altitude =altitude ;
lt_altitude =time ;

		_state_id_dataProperty = 0;//moving to state normal
		_goto_dataProperty(_info);
		}
		else if ((_occurredEvent(_event,4/*dataBattery*/))){
		l_batteryPercentage =batteryPercentage ;
lt_batteryPercentage =time ;
l_batteryTemperature =batteryTemperature ;
lt_batteryTemperature =time ;

		_state_id_dataProperty = 0;//moving to state normal
		_goto_dataProperty(_info);
		}
		else if ((_occurredEvent(_event,6/*dataRC*/))){
		l_rcElevator =rcElevator ;
lt_rcElevator =time ;
l_rcAileron =rcAileron ;
lt_rcAileron =time ;
l_rcThrottle =rcThrottle ;
lt_rcThrottle =time ;
l_rcRudder =rcRudder ;
lt_rcRudder =time ;

		_state_id_dataProperty = 0;//moving to state normal
		_goto_dataProperty(_info);
		}
		else if ((_occurredEvent(_event,8/*dataGPS*/))){
		l_satellites =satellites ;
lt_satellites =time ;
l_gpsLevel =gpsLevel ;
lt_gpsLevel =time ;

		_state_id_dataProperty = 0;//moving to state normal
		_goto_dataProperty(_info);
		}
		else if ((_occurredEvent(_event,10/*takeOff*/))){
		if (acceptingLogs.get()) { 
if (! queue.offer("---------Takeoff---------")) {
    System.out.println("SealFS writing busy, log missed: " + "---------Takeoff---------");
}}
logData (true ,false ,false ,false );
if (acceptingLogs.get()) { 
if (! queue.offer("Good battery cell consistency: "+d_goodCellConsistency )) {
    System.out.println("SealFS writing busy, log missed: " + "Good battery cell consistency: "+d_goodCellConsistency );
}}

		_state_id_dataProperty = 0;//moving to state normal
		_goto_dataProperty(_info);
		}
		else if ((_occurredEvent(_event,12/*landing*/))){
		if (acceptingLogs.get()) { 
if (! queue.offer("---------Landing---------")) {
    System.out.println("SealFS writing busy, log missed: " + "---------Landing---------");
}}
logData (true ,false ,false ,false );

		_state_id_dataProperty = 0;//moving to state normal
		_goto_dataProperty(_info);
		}
		else if ((_occurredEvent(_event,36/*goodCellConsistency*/))){
		d_goodCellConsistency =true ;

		_state_id_dataProperty = 0;//moving to state normal
		_goto_dataProperty(_info);
		}
		else if ((_occurredEvent(_event,38/*badCellConsistency*/))){
		d_goodCellConsistency =false ;

		_state_id_dataProperty = 0;//moving to state normal
		_goto_dataProperty(_info);
		}
		else if ((_occurredEvent(_event,40/*veryBadCellConsistency*/))){
		d_goodCellConsistency =false ;

		_state_id_dataProperty = 0;//moving to state normal
		_goto_dataProperty(_info);
		}
}
}

public void _goto_dataProperty(String _info){
 if(acceptingLogs.get()) {
if (! queue.offer( "[dataProperty]MOVED ON METHODCALL: "+ _info +" TO STATE::> " + _string_dataProperty(_state_id_dataProperty, 1))){
 System.out.println("SealFS Writing busy, log missed: " + "[dataProperty]MOVED ON METHODCALL: "+ _info +" TO STATE::> " + _string_dataProperty(_state_id_dataProperty, 1));}}
}

public String _string_dataProperty(int _state_id, int _mode){
switch(_state_id){
case 0: if (_mode == 0) return "normal"; else return "normal";
default: return "!!!SYSTEM REACHED AN UNKNOWN STATE!!!";
}
}
int _state_id_cameraProperty = 4;

public void _performLogic_cameraProperty(String _info, int... _event) {
if (acceptingLogs.get()) {
if (! queue.offer("[cameraProperty]AUTOMATON ::> cameraProperty("+") STATE::>"+ _string_cameraProperty(_state_id_cameraProperty, 0))){
 System.out.println("SealFS Writing busy, log missed: [cameraProperty]AUTOMATON ::> cameraProperty("+") STATE::>"+ _string_cameraProperty(_state_id_cameraProperty, 0));}}

if (0==1){}
else if (_state_id_cameraProperty==3){
		if (1==0){}
		else if ((_occurredEvent(_event,62/*lowAcceleration*/))){
		
		_state_id_cameraProperty = 4;//moving to state lowAcceleration
c1 .off ();

		_goto_cameraProperty(_info);
		}
		else if ((_occurredEvent(_event,66/*lookingAway*/))){
		look =false ;

		_state_id_cameraProperty = 1;//moving to state accelerating5sAndLookingAway
		_goto_cameraProperty(_info);
		}
}
else if (_state_id_cameraProperty==1){
		if (1==0){}
		else if ((_occurredEvent(_event,68/*looking*/))){
		look =true ;

		_state_id_cameraProperty = 3;//moving to state accelerating5s
		_goto_cameraProperty(_info);
		}
		else if ((_occurredEvent(_event,62/*lowAcceleration*/))){
		
		_state_id_cameraProperty = 4;//moving to state lowAcceleration
c1 .off ();

		_goto_cameraProperty(_info);
		}
}
else if (_state_id_cameraProperty==4){
		if (1==0){}
		else if ((_occurredEvent(_event,60/*highAcceleration*/))){
		c1 .reset ();

		_state_id_cameraProperty = 2;//moving to state accelerating
		_goto_cameraProperty(_info);
		}
		else if ((_occurredEvent(_event,68/*looking*/)) && (!look )){
		look =true ;

		_state_id_cameraProperty = 4;//moving to state lowAcceleration
c1 .off ();

		_goto_cameraProperty(_info);
		}
		else if ((_occurredEvent(_event,66/*lookingAway*/)) && (look )){
		look =false ;

		_state_id_cameraProperty = 4;//moving to state lowAcceleration
c1 .off ();

		_goto_cameraProperty(_info);
		}
}
else if (_state_id_cameraProperty==2){
		if (1==0){}
		else if ((_occurredEvent(_event,62/*lowAcceleration*/))){
		c1 .off ();

		_state_id_cameraProperty = 4;//moving to state lowAcceleration
c1 .off ();

		_goto_cameraProperty(_info);
		}
		else if ((_occurredEvent(_event,64/*highAccelerationFor5s*/)) && (look )){
		
		_state_id_cameraProperty = 3;//moving to state accelerating5s
		_goto_cameraProperty(_info);
		}
		else if ((_occurredEvent(_event,64/*highAccelerationFor5s*/)) && (!look )){
		
		_state_id_cameraProperty = 1;//moving to state accelerating5sAndLookingAway
		_goto_cameraProperty(_info);
		}
		else if ((_occurredEvent(_event,68/*looking*/)) && (!look )){
		look =true ;

		_state_id_cameraProperty = 2;//moving to state accelerating
		_goto_cameraProperty(_info);
		}
		else if ((_occurredEvent(_event,66/*lookingAway*/)) && (look )){
		look =false ;

		_state_id_cameraProperty = 2;//moving to state accelerating
		_goto_cameraProperty(_info);
		}
}
}

public void _goto_cameraProperty(String _info){
 if(acceptingLogs.get()) {
if (! queue.offer( "[cameraProperty]MOVED ON METHODCALL: "+ _info +" TO STATE::> " + _string_cameraProperty(_state_id_cameraProperty, 1))){
 System.out.println("SealFS Writing busy, log missed: " + "[cameraProperty]MOVED ON METHODCALL: "+ _info +" TO STATE::> " + _string_cameraProperty(_state_id_cameraProperty, 1));}}
}

public String _string_cameraProperty(int _state_id, int _mode){
switch(_state_id){
case 3: if (_mode == 0) return "accelerating5s"; else return "accelerating5s";
case 1: if (_mode == 0) return "accelerating5sAndLookingAway"; else return "!!!SYSTEM REACHED BAD STATE!!! accelerating5sAndLookingAway "+new _BadStateExceptionproperties().toString()+" ";
case 2: if (_mode == 0) return "accelerating"; else return "accelerating";
case 4: if (_mode == 0) return "lowAcceleration"; else return "lowAcceleration";
default: return "!!!SYSTEM REACHED AN UNKNOWN STATE!!!";
}
}
int _state_id_positionProperty = 9;

public void _performLogic_positionProperty(String _info, int... _event) {
if (acceptingLogs.get()) {
if (! queue.offer("[positionProperty]AUTOMATON ::> positionProperty("+") STATE::>"+ _string_positionProperty(_state_id_positionProperty, 0))){
 System.out.println("SealFS Writing busy, log missed: [positionProperty]AUTOMATON ::> positionProperty("+") STATE::>"+ _string_positionProperty(_state_id_positionProperty, 0));}}

if (0==1){}
else if (_state_id_positionProperty==6){
		if (1==0){}
		else if ((_occurredEvent(_event,16/*outRestricted*/))){
		d_location =false ;

		_state_id_positionProperty = 9;//moving to state inRange
		_goto_positionProperty(_info);
		}
		else if ((_occurredEvent(_event,22/*highAltitude*/)) && (!tooHigh )){
		tooHigh =true ;

		_state_id_positionProperty = 6;//moving to state inRestricted
		_goto_positionProperty(_info);
		}
		else if ((_occurredEvent(_event,24/*lowAltitude*/)) && (tooHigh )){
		tooHigh =false ;

		_state_id_positionProperty = 6;//moving to state inRestricted
		_goto_positionProperty(_info);
		}
		else if ((_occurredEvent(_event,18/*outDistance*/)) && (!tooHigh )){
		
		_state_id_positionProperty = 7;//moving to state tooFarAndRestricted
		_goto_positionProperty(_info);
		}
		else if ((_occurredEvent(_event,18/*outDistance*/)) && (tooHigh )){
		
		_state_id_positionProperty = 8;//moving to state outOfAllBounds
		_goto_positionProperty(_info);
		}
}
else if (_state_id_positionProperty==5){
		if (1==0){}
		else if ((_occurredEvent(_event,20/*inDistance*/))){
		d_location =false ;

		_state_id_positionProperty = 9;//moving to state inRange
		_goto_positionProperty(_info);
		}
		else if ((_occurredEvent(_event,22/*highAltitude*/)) && (!tooHigh )){
		tooHigh =true ;

		_state_id_positionProperty = 5;//moving to state tooFar
		_goto_positionProperty(_info);
		}
		else if ((_occurredEvent(_event,24/*lowAltitude*/)) && (tooHigh )){
		tooHigh =false ;

		_state_id_positionProperty = 5;//moving to state tooFar
		_goto_positionProperty(_info);
		}
		else if ((_occurredEvent(_event,14/*intoRestricted*/)) && (!tooHigh )){
		
		_state_id_positionProperty = 7;//moving to state tooFarAndRestricted
		_goto_positionProperty(_info);
		}
		else if ((_occurredEvent(_event,14/*intoRestricted*/)) && (tooHigh )){
		
		_state_id_positionProperty = 8;//moving to state outOfAllBounds
		_goto_positionProperty(_info);
		}
}
else if (_state_id_positionProperty==8){
		if (1==0){}
		else if ((_occurredEvent(_event,24/*lowAltitude*/))){
		tooHigh =false ;

		_state_id_positionProperty = 7;//moving to state tooFarAndRestricted
		_goto_positionProperty(_info);
		}
		else if ((_occurredEvent(_event,20/*inDistance*/))){
		
		_state_id_positionProperty = 6;//moving to state inRestricted
		_goto_positionProperty(_info);
		}
		else if ((_occurredEvent(_event,16/*outRestricted*/))){
		
		_state_id_positionProperty = 5;//moving to state tooFar
		_goto_positionProperty(_info);
		}
}
else if (_state_id_positionProperty==7){
		if (1==0){}
		else if ((_occurredEvent(_event,16/*outRestricted*/))){
		
		_state_id_positionProperty = 5;//moving to state tooFar
		_goto_positionProperty(_info);
		}
		else if ((_occurredEvent(_event,20/*inDistance*/))){
		
		_state_id_positionProperty = 6;//moving to state inRestricted
		_goto_positionProperty(_info);
		}
		else if ((_occurredEvent(_event,22/*highAltitude*/))){
		tooHigh =true ;

		_state_id_positionProperty = 8;//moving to state outOfAllBounds
		_goto_positionProperty(_info);
		}
}
else if (_state_id_positionProperty==9){
		if (1==0){}
		else if ((_occurredEvent(_event,22/*highAltitude*/)) && (!tooHigh )){
		tooHigh =true ;

		_state_id_positionProperty = 9;//moving to state inRange
		_goto_positionProperty(_info);
		}
		else if ((_occurredEvent(_event,24/*lowAltitude*/)) && (tooHigh )){
		tooHigh =false ;

		_state_id_positionProperty = 9;//moving to state inRange
		_goto_positionProperty(_info);
		}
		else if ((_occurredEvent(_event,18/*outDistance*/))){
		d_location =true ;

		_state_id_positionProperty = 5;//moving to state tooFar
		_goto_positionProperty(_info);
		}
		else if ((_occurredEvent(_event,14/*intoRestricted*/))){
		d_location =true ;

		_state_id_positionProperty = 6;//moving to state inRestricted
		_goto_positionProperty(_info);
		}
}
}

public void _goto_positionProperty(String _info){
 if(acceptingLogs.get()) {
if (! queue.offer( "[positionProperty]MOVED ON METHODCALL: "+ _info +" TO STATE::> " + _string_positionProperty(_state_id_positionProperty, 1))){
 System.out.println("SealFS Writing busy, log missed: " + "[positionProperty]MOVED ON METHODCALL: "+ _info +" TO STATE::> " + _string_positionProperty(_state_id_positionProperty, 1));}}
}

public String _string_positionProperty(int _state_id, int _mode){
switch(_state_id){
case 6: if (_mode == 0) return "inRestricted"; else return "!!!SYSTEM REACHED BAD STATE!!! inRestricted "+new _BadStateExceptionproperties().toString()+" ";
case 5: if (_mode == 0) return "tooFar"; else return "!!!SYSTEM REACHED BAD STATE!!! tooFar "+new _BadStateExceptionproperties().toString()+" ";
case 8: if (_mode == 0) return "outOfAllBounds"; else return "!!!SYSTEM REACHED BAD STATE!!! outOfAllBounds "+new _BadStateExceptionproperties().toString()+" ";
case 7: if (_mode == 0) return "tooFarAndRestricted"; else return "!!!SYSTEM REACHED BAD STATE!!! tooFarAndRestricted "+new _BadStateExceptionproperties().toString()+" ";
case 9: if (_mode == 0) return "inRange"; else return "inRange";
default: return "!!!SYSTEM REACHED AN UNKNOWN STATE!!!";
}
}
int _state_id_RCProperty = 11;

public void _performLogic_RCProperty(String _info, int... _event) {
if (acceptingLogs.get()) {
if (! queue.offer("[RCProperty]AUTOMATON ::> RCProperty("+") STATE::>"+ _string_RCProperty(_state_id_RCProperty, 0))){
 System.out.println("SealFS Writing busy, log missed: [RCProperty]AUTOMATON ::> RCProperty("+") STATE::>"+ _string_RCProperty(_state_id_RCProperty, 0));}}

if (0==1){}
else if (_state_id_RCProperty==10){
		if (1==0){}
		else if ((_occurredEvent(_event,42/*goodSignalRC*/)) && (badRCStates >0 )){
		badRCStates --;

		_state_id_RCProperty = 10;//moving to state badSignal
		_goto_RCProperty(_info);
		}
		else if ((_occurredEvent(_event,42/*goodSignalRC*/)) && (badRCStates ==0 )){
		d .send ("good");
d_rc =false ;

		_state_id_RCProperty = 11;//moving to state goodSignal
		_goto_RCProperty(_info);
		}
}
else if (_state_id_RCProperty==11){
		if (1==0){}
		else if ((_occurredEvent(_event,42/*goodSignalRC*/))){
		if (badRCStates >0 ){badRCStates --;
}
		_state_id_RCProperty = 11;//moving to state goodSignal
		_goto_RCProperty(_info);
		}
		else if ((_occurredEvent(_event,46/*veryBadSignalRC*/))){
		badSignalStates +=3 ;
d .send ("bad");
d_rc =true ;

		_state_id_RCProperty = 10;//moving to state badSignal
		_goto_RCProperty(_info);
		}
		else if ((_occurredEvent(_event,44/*badSignalRC*/)) && (badRCStates <5 )){
		badRCStates ++;

		_state_id_RCProperty = 11;//moving to state goodSignal
		_goto_RCProperty(_info);
		}
		else if ((_occurredEvent(_event,44/*badSignalRC*/)) && (badRCStates >=5 )){
		badRCStates ++;
d .send ("bad");
d_rc =true ;

		_state_id_RCProperty = 10;//moving to state badSignal
		_goto_RCProperty(_info);
		}
}
}

public void _goto_RCProperty(String _info){
 if(acceptingLogs.get()) {
if (! queue.offer( "[RCProperty]MOVED ON METHODCALL: "+ _info +" TO STATE::> " + _string_RCProperty(_state_id_RCProperty, 1))){
 System.out.println("SealFS Writing busy, log missed: " + "[RCProperty]MOVED ON METHODCALL: "+ _info +" TO STATE::> " + _string_RCProperty(_state_id_RCProperty, 1));}}
}

public String _string_RCProperty(int _state_id, int _mode){
switch(_state_id){
case 10: if (_mode == 0) return "badSignal"; else return "!!!SYSTEM REACHED BAD STATE!!! badSignal "+new _BadStateExceptionproperties().toString()+" ";
case 11: if (_mode == 0) return "goodSignal"; else return "goodSignal";
default: return "!!!SYSTEM REACHED AN UNKNOWN STATE!!!";
}
}
int _state_id_GPSProperty = 13;

public void _performLogic_GPSProperty(String _info, int... _event) {
if (acceptingLogs.get()) {
if (! queue.offer("[GPSProperty]AUTOMATON ::> GPSProperty("+") STATE::>"+ _string_GPSProperty(_state_id_GPSProperty, 0))){
 System.out.println("SealFS Writing busy, log missed: [GPSProperty]AUTOMATON ::> GPSProperty("+") STATE::>"+ _string_GPSProperty(_state_id_GPSProperty, 0));}}

if (0==1){}
else if (_state_id_GPSProperty==12){
		if (1==0){}
		else if ((_occurredEvent(_event,54/*goodSignalGPS*/)) && (badGPSStates >0 )){
		badGPSStates --;

		_state_id_GPSProperty = 12;//moving to state badSignal
		_goto_GPSProperty(_info);
		}
		else if ((_occurredEvent(_event,54/*goodSignalGPS*/)) && (badGPSStates ==0 )){
		d_gps =false ;

		_state_id_GPSProperty = 13;//moving to state goodSignal
		_goto_GPSProperty(_info);
		}
}
else if (_state_id_GPSProperty==13){
		if (1==0){}
		else if ((_occurredEvent(_event,54/*goodSignalGPS*/))){
		if (badGPSStates >0 ){badGPSStates --;
}
		_state_id_GPSProperty = 13;//moving to state goodSignal
		_goto_GPSProperty(_info);
		}
		else if ((_occurredEvent(_event,58/*veryBadSignalGPS*/))){
		badGPSStates +=3 ;
d_gps =true ;

		_state_id_GPSProperty = 12;//moving to state badSignal
		_goto_GPSProperty(_info);
		}
		else if ((_occurredEvent(_event,56/*badSignalGPS*/)) && (badGPSStates <5 )){
		badGPSStates ++;

		_state_id_GPSProperty = 13;//moving to state goodSignal
		_goto_GPSProperty(_info);
		}
		else if ((_occurredEvent(_event,56/*badSignalGPS*/)) && (badGPSStates >=5 )){
		badGPSStates ++;
d_gps =true ;

		_state_id_GPSProperty = 12;//moving to state badSignal
		_goto_GPSProperty(_info);
		}
}
}

public void _goto_GPSProperty(String _info){
 if(acceptingLogs.get()) {
if (! queue.offer( "[GPSProperty]MOVED ON METHODCALL: "+ _info +" TO STATE::> " + _string_GPSProperty(_state_id_GPSProperty, 1))){
 System.out.println("SealFS Writing busy, log missed: " + "[GPSProperty]MOVED ON METHODCALL: "+ _info +" TO STATE::> " + _string_GPSProperty(_state_id_GPSProperty, 1));}}
}

public String _string_GPSProperty(int _state_id, int _mode){
switch(_state_id){
case 12: if (_mode == 0) return "badSignal"; else return "!!!SYSTEM REACHED BAD STATE!!! badSignal "+new _BadStateExceptionproperties().toString()+" ";
case 13: if (_mode == 0) return "goodSignal"; else return "goodSignal";
default: return "!!!SYSTEM REACHED AN UNKNOWN STATE!!!";
}
}
int _state_id_batteryProperty = 16;

public void _performLogic_batteryProperty(String _info, int... _event) {
if (acceptingLogs.get()) {
if (! queue.offer("[batteryProperty]AUTOMATON ::> batteryProperty("+") STATE::>"+ _string_batteryProperty(_state_id_batteryProperty, 0))){
 System.out.println("SealFS Writing busy, log missed: [batteryProperty]AUTOMATON ::> batteryProperty("+") STATE::>"+ _string_batteryProperty(_state_id_batteryProperty, 0));}}

if (0==1){}
else if (_state_id_batteryProperty==15){
		if (1==0){}
		else if ((_occurredEvent(_event,30/*lowCharge*/))){
		
		_state_id_batteryProperty = 14;//moving to state lowCharge
		_goto_batteryProperty(_info);
		}
		else if ((_occurredEvent(_event,32/*highTemperature*/))){
		
		_state_id_batteryProperty = 15;//moving to state lowBatteryHealth
		_goto_batteryProperty(_info);
		}
		else if ((_occurredEvent(_event,36/*goodCellConsistency*/)) && (badCellStates >0 )){
		badCellStates --;

		_state_id_batteryProperty = 15;//moving to state lowBatteryHealth
		_goto_batteryProperty(_info);
		}
		else if ((_occurredEvent(_event,36/*goodCellConsistency*/)) && (badCellStates ==0 )){
		d_battery =false ;

		_state_id_batteryProperty = 16;//moving to state goodBattery
		_goto_batteryProperty(_info);
		}
}
else if (_state_id_batteryProperty==16){
		if (1==0){}
		else if ((_occurredEvent(_event,30/*lowCharge*/))){
		d_battery =true ;

		_state_id_batteryProperty = 14;//moving to state lowCharge
		_goto_batteryProperty(_info);
		}
		else if ((_occurredEvent(_event,32/*highTemperature*/))){
		badCellStates +=5 ;
d_battery =true ;

		_state_id_batteryProperty = 15;//moving to state lowBatteryHealth
		_goto_batteryProperty(_info);
		}
		else if ((_occurredEvent(_event,36/*goodCellConsistency*/))){
		if (badCellStates >0 ){badCellStates --;
}
		_state_id_batteryProperty = 16;//moving to state goodBattery
		_goto_batteryProperty(_info);
		}
		else if ((_occurredEvent(_event,38/*badCellConsistency*/)) && (badCellStates <5 )){
		badCellStates ++;

		_state_id_batteryProperty = 16;//moving to state goodBattery
		_goto_batteryProperty(_info);
		}
		else if ((_occurredEvent(_event,38/*badCellConsistency*/)) && (badCellStates >=5 )){
		badCellStates ++;
d_battery =true ;

		_state_id_batteryProperty = 15;//moving to state lowBatteryHealth
		_goto_batteryProperty(_info);
		}
}
}

public void _goto_batteryProperty(String _info){
 if(acceptingLogs.get()) {
if (! queue.offer( "[batteryProperty]MOVED ON METHODCALL: "+ _info +" TO STATE::> " + _string_batteryProperty(_state_id_batteryProperty, 1))){
 System.out.println("SealFS Writing busy, log missed: " + "[batteryProperty]MOVED ON METHODCALL: "+ _info +" TO STATE::> " + _string_batteryProperty(_state_id_batteryProperty, 1));}}
}

public String _string_batteryProperty(int _state_id, int _mode){
switch(_state_id){
case 15: if (_mode == 0) return "lowBatteryHealth"; else return "!!!SYSTEM REACHED BAD STATE!!! lowBatteryHealth "+new _BadStateExceptionproperties().toString()+" ";
case 16: if (_mode == 0) return "goodBattery"; else return "goodBattery";
case 14: if (_mode == 0) return "lowCharge"; else return "!!!SYSTEM REACHED BAD STATE!!! lowCharge "+new _BadStateExceptionproperties().toString()+" ";
default: return "!!!SYSTEM REACHED AN UNKNOWN STATE!!!";
}
}
int _state_id_speedProperty = 22;

public void _performLogic_speedProperty(String _info, int... _event) {
if (acceptingLogs.get()) {
if (! queue.offer("[speedProperty]AUTOMATON ::> speedProperty("+") STATE::>"+ _string_speedProperty(_state_id_speedProperty, 0))){
 System.out.println("SealFS Writing busy, log missed: [speedProperty]AUTOMATON ::> speedProperty("+") STATE::>"+ _string_speedProperty(_state_id_speedProperty, 0));}}

if (0==1){}
else if (_state_id_speedProperty==20){
		if (1==0){}
		else if ((_occurredEvent(_event,48/*channelD*/)) && (signalState .equals ("good")&&signal .equals ("bad"))){
		signalState ="bad";

		_state_id_speedProperty = 20;//moving to state normalAltitude
		_goto_speedProperty(_info);
		}
		else if ((_occurredEvent(_event,48/*channelD*/)) && (signalState .equals ("bad")&&signal .equals ("good"))){
		signalState ="good";

		_state_id_speedProperty = 20;//moving to state normalAltitude
		_goto_speedProperty(_info);
		}
		else if ((_occurredEvent(_event,28/*veryLowAltitude*/))){
		
		_state_id_speedProperty = 22;//moving to state lowAltitude
		_goto_speedProperty(_info);
		}
		else if ((_occurredEvent(_event,50/*highSpeed*/))){
		
		_state_id_speedProperty = 21;//moving to state fastNormalAltitude
		_goto_speedProperty(_info);
		}
}
else if (_state_id_speedProperty==19){
		if (1==0){}
		else if ((_occurredEvent(_event,48/*channelD*/)) && (signal .equals ("good"))){
		signalState ="good";

		_state_id_speedProperty = 17;//moving to state tooFastLowAltitude
		_goto_speedProperty(_info);
		}
		else if ((_occurredEvent(_event,26/*normalAltitude*/))){
		
		_state_id_speedProperty = 21;//moving to state fastNormalAltitude
		_goto_speedProperty(_info);
		}
		else if ((_occurredEvent(_event,52/*lowSpeed*/))){
		
		_state_id_speedProperty = 22;//moving to state lowAltitude
		_goto_speedProperty(_info);
		}
}
else if (_state_id_speedProperty==22){
		if (1==0){}
		else if ((_occurredEvent(_event,48/*channelD*/)) && (signalState .equals ("good")&&signal .equals ("bad"))){
		signalState ="bad";

		_state_id_speedProperty = 22;//moving to state lowAltitude
		_goto_speedProperty(_info);
		}
		else if ((_occurredEvent(_event,48/*channelD*/)) && (signalState .equals ("bad")&&signal .equals ("good"))){
		signalState ="good";

		_state_id_speedProperty = 22;//moving to state lowAltitude
		_goto_speedProperty(_info);
		}
		else if ((_occurredEvent(_event,26/*normalAltitude*/))){
		
		_state_id_speedProperty = 20;//moving to state normalAltitude
		_goto_speedProperty(_info);
		}
		else if ((_occurredEvent(_event,50/*highSpeed*/)) && (signalState .equals ("bad"))){
		
		_state_id_speedProperty = 19;//moving to state tooLowForSignalAndFast
		_goto_speedProperty(_info);
		}
		else if ((_occurredEvent(_event,50/*highSpeed*/))){
		
		_state_id_speedProperty = 17;//moving to state tooFastLowAltitude
		_goto_speedProperty(_info);
		}
}
else if (_state_id_speedProperty==17){
		if (1==0){}
		else if ((_occurredEvent(_event,26/*normalAltitude*/))){
		
		_state_id_speedProperty = 21;//moving to state fastNormalAltitude
		_goto_speedProperty(_info);
		}
		else if ((_occurredEvent(_event,52/*lowSpeed*/))){
		
		_state_id_speedProperty = 22;//moving to state lowAltitude
		_goto_speedProperty(_info);
		}
		else if ((_occurredEvent(_event,48/*channelD*/)) && (signal .equals ("bad"))){
		signalState ="bad";

		_state_id_speedProperty = 19;//moving to state tooLowForSignalAndFast
		_goto_speedProperty(_info);
		}
}
else if (_state_id_speedProperty==21){
		if (1==0){}
		else if ((_occurredEvent(_event,48/*channelD*/)) && (signalState .equals ("good")&&signal .equals ("bad"))){
		signalState ="bad";

		_state_id_speedProperty = 21;//moving to state fastNormalAltitude
		_goto_speedProperty(_info);
		}
		else if ((_occurredEvent(_event,48/*channelD*/)) && (signalState .equals ("bad")&&signal .equals ("good"))){
		signalState ="good";

		_state_id_speedProperty = 21;//moving to state fastNormalAltitude
		_goto_speedProperty(_info);
		}
		else if ((_occurredEvent(_event,52/*lowSpeed*/))){
		
		_state_id_speedProperty = 20;//moving to state normalAltitude
		_goto_speedProperty(_info);
		}
		else if ((_occurredEvent(_event,28/*veryLowAltitude*/)) && (signalState .equals ("bad"))){
		
		_state_id_speedProperty = 19;//moving to state tooLowForSignalAndFast
		_goto_speedProperty(_info);
		}
		else if ((_occurredEvent(_event,28/*veryLowAltitude*/))){
		
		_state_id_speedProperty = 17;//moving to state tooFastLowAltitude
		_goto_speedProperty(_info);
		}
}
}

public void _goto_speedProperty(String _info){
 if(acceptingLogs.get()) {
if (! queue.offer( "[speedProperty]MOVED ON METHODCALL: "+ _info +" TO STATE::> " + _string_speedProperty(_state_id_speedProperty, 1))){
 System.out.println("SealFS Writing busy, log missed: " + "[speedProperty]MOVED ON METHODCALL: "+ _info +" TO STATE::> " + _string_speedProperty(_state_id_speedProperty, 1));}}
}

public String _string_speedProperty(int _state_id, int _mode){
switch(_state_id){
case 20: if (_mode == 0) return "normalAltitude"; else return "normalAltitude";
case 19: if (_mode == 0) return "tooLowForSignalAndFast"; else return "!!!SYSTEM REACHED BAD STATE!!! tooLowForSignalAndFast "+new _BadStateExceptionproperties().toString()+" ";
case 22: if (_mode == 0) return "lowAltitude"; else return "lowAltitude";
case 17: if (_mode == 0) return "tooFastLowAltitude"; else return "!!!SYSTEM REACHED BAD STATE!!! tooFastLowAltitude "+new _BadStateExceptionproperties().toString()+" ";
case 21: if (_mode == 0) return "fastNormalAltitude"; else return "fastNormalAltitude";
case 18: if (_mode == 0) return "tooLowForSignal"; else return "!!!SYSTEM REACHED BAD STATE!!! tooLowForSignal "+new _BadStateExceptionproperties().toString()+" ";
default: return "!!!SYSTEM REACHED AN UNKNOWN STATE!!!";
}
}
int _state_id_windspeedProperty = 24;

public void _performLogic_windspeedProperty(String _info, int... _event) {
if (acceptingLogs.get()) {
if (! queue.offer("[windspeedProperty]AUTOMATON ::> windspeedProperty("+") STATE::>"+ _string_windspeedProperty(_state_id_windspeedProperty, 0))){
 System.out.println("SealFS Writing busy, log missed: [windspeedProperty]AUTOMATON ::> windspeedProperty("+") STATE::>"+ _string_windspeedProperty(_state_id_windspeedProperty, 0));}}

if (0==1){}
else if (_state_id_windspeedProperty==24){
		if (1==0){}
		else if ((_occurredEvent(_event,70/*speedChange*/)) && (!checkChange (xSpeed ,ySpeed ,zSpeed ,lSpeedX ,lSpeedY ,lSpeedZ ))){
		lSpeedX =xSpeed ;
lSpeedY =ySpeed ;
lSpeedZ =zSpeed ;

		_state_id_windspeedProperty = 24;//moving to state normal
c2 .off ();

		_goto_windspeedProperty(_info);
		}
		else if ((_occurredEvent(_event,70/*speedChange*/)) && (abruptChanges >=5 )){
		lSpeedX =xSpeed ;
lSpeedY =ySpeed ;
lSpeedZ =zSpeed ;
abruptChanges ++;
c2 .reset ();

		_state_id_windspeedProperty = 23;//moving to state likelyHighWindspeed
		_goto_windspeedProperty(_info);
		}
		else if ((_occurredEvent(_event,70/*speedChange*/))){
		lSpeedX =xSpeed ;
lSpeedY =ySpeed ;
lSpeedZ =zSpeed ;
abruptChanges ++;
c2 .reset ();

		_state_id_windspeedProperty = 24;//moving to state normal
c2 .off ();

		_goto_windspeedProperty(_info);
		}
		else if ((_occurredEvent(_event,72/*windTimerElapsed*/)) && (abruptChanges >0 )){
		abruptChanges --;
c2 .reset ();

		_state_id_windspeedProperty = 24;//moving to state normal
c2 .off ();

		_goto_windspeedProperty(_info);
		}
		else if ((_occurredEvent(_event,72/*windTimerElapsed*/))){
		c2 .off ();

		_state_id_windspeedProperty = 24;//moving to state normal
c2 .off ();

		_goto_windspeedProperty(_info);
		}
}
else if (_state_id_windspeedProperty==23){
		if (1==0){}
		else if ((_occurredEvent(_event,70/*speedChange*/)) && (!checkChange (xSpeed ,ySpeed ,zSpeed ,lSpeedX ,lSpeedY ,lSpeedZ ))){
		lSpeedX =xSpeed ;
lSpeedY =ySpeed ;
lSpeedZ =zSpeed ;

		_state_id_windspeedProperty = 23;//moving to state likelyHighWindspeed
		_goto_windspeedProperty(_info);
		}
		else if ((_occurredEvent(_event,70/*speedChange*/)) && (abruptChanges <10 )){
		lSpeedX =xSpeed ;
lSpeedY =ySpeed ;
lSpeedZ =zSpeed ;
abruptChanges ++;
c2 .reset ();

		_state_id_windspeedProperty = 23;//moving to state likelyHighWindspeed
		_goto_windspeedProperty(_info);
		}
		else if ((_occurredEvent(_event,72/*windTimerElapsed*/)) && (abruptChanges <=5 )){
		abruptChanges --;
c2 .reset ();

		_state_id_windspeedProperty = 24;//moving to state normal
c2 .off ();

		_goto_windspeedProperty(_info);
		}
		else if ((_occurredEvent(_event,72/*windTimerElapsed*/))){
		abruptChanges --;
c2 .reset ();

		_state_id_windspeedProperty = 23;//moving to state likelyHighWindspeed
		_goto_windspeedProperty(_info);
		}
}
}

public void _goto_windspeedProperty(String _info){
 if(acceptingLogs.get()) {
if (! queue.offer( "[windspeedProperty]MOVED ON METHODCALL: "+ _info +" TO STATE::> " + _string_windspeedProperty(_state_id_windspeedProperty, 1))){
 System.out.println("SealFS Writing busy, log missed: " + "[windspeedProperty]MOVED ON METHODCALL: "+ _info +" TO STATE::> " + _string_windspeedProperty(_state_id_windspeedProperty, 1));}}
}

public String _string_windspeedProperty(int _state_id, int _mode){
switch(_state_id){
case 24: if (_mode == 0) return "normal"; else return "normal";
case 23: if (_mode == 0) return "likelyHighWindspeed"; else return "!!!SYSTEM REACHED BAD STATE!!! likelyHighWindspeed "+new _BadStateExceptionproperties().toString()+" ";
default: return "!!!SYSTEM REACHED AN UNKNOWN STATE!!!";
}
}

public boolean _occurredEvent(int[] _events, int event){
for (int i:_events) if (i == event) return true;
return false;
}
boolean checkChange(double xSpeed, double ySpeed, double zSpeed, double lSpeedX, double lSpeedY, double lSpeedZ) {
double dotP = (lSpeedX*xSpeed + lSpeedY*ySpeed + lSpeedZ*zSpeed);
double mag = Math.sqrt(xSpeed*xSpeed + ySpeed*ySpeed + zSpeed*zSpeed);
double lmag = Math.sqrt(lSpeedX*lSpeedX + lSpeedY*lSpeedY + lSpeedZ*lSpeedZ);
if(lmag == 0 || mag == 0) {
return false;
}
double sim = dotP / (lmag * mag);

double magR = mag / lmag;
boolean magC = magR < 0.5 || magR > (1/0.5);

return (sim <= -0.5) || magC;
}
void logData(boolean location, boolean rc, boolean gps, boolean battery){
if (location) {
boolean a = queue.offer(lt_distance + " | Distance: " + l_distance);
boolean b = queue.offer(lt_latitude + " | Latitude: " + l_latitude);
boolean c = queue.offer(lt_longitude + " | Longitude: " + l_longitude);
boolean d = queue.offer(lt_altitude + " | Altitude: " + l_altitude);
if(!(a && b && c && d)) {
System.out.println("SealFS Writing busy, log missed: Periodic Location Log");
}
}
if (rc){
boolean a = queue.offer(lt_rcElevator + " | rcElevator: " + l_rcElevator);
boolean b = queue.offer(lt_rcAileron + " | rcAileron: " + l_rcAileron);
boolean c = queue.offer(lt_rcThrottle + " | rcThrottle: " + l_rcThrottle);
boolean d = queue.offer(lt_rcRudder + " | rcRudder: " + l_rcRudder);
if(!(a && b && c && d)) {
System.out.println("SealFS Writing busy, log missed: Periodic Location Log");
}
}
if (gps){
boolean a = queue.offer(lt_satellites + " | Satellite Connections: " + l_satellites);
boolean b = queue.offer(lt_gpsLevel + " | GPS-Level: " + l_gpsLevel);
if(!(a && b)) {
System.out.println("SealFS Writing busy, log missed: Periodic Location Log");
}

}
if (battery) {
boolean a = queue.offer(lt_batteryPercentage + " | Battery Percentage: " + l_batteryPercentage);
boolean b = queue.offer(lt_batteryTemperature + " | Battery Temperature: " + l_batteryTemperature);
if(!(a && b)) {
System.out.println("SealFS Writing busy, log missed: Periodic Location Log");
}
}
}
}