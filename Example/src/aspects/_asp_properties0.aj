package aspects;

import java.lang.Math;
import java.time.LocalTime;

import larva.*;
public aspect _asp_properties0 {

public static Object lock = new Object();

boolean initialized = false;

after():(staticinitialization(*)){
if (!initialized){
	initialized = true;
	_cls_properties0.initialize();
}
}
before ( double altTakeoff,double altSea) : (call(* *.updateAltitude(..)) && args(altTakeoff,altSea,*,*) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*)) && if (altTakeoff <10 )) {

synchronized(_asp_properties0.lock){

_cls_properties0 _cls_inst = _cls_properties0._get_cls_properties0_inst();
_cls_inst.altTakeoff = altTakeoff;
_cls_inst.altSea = altSea;
_cls_inst._call(thisJoinPoint.getSignature().toString(), 28/*veryLowAltitude*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 28/*veryLowAltitude*/);
}
}
before ( double batteryTemperature) : (call(* *.updateBattery(..)) && args(*,batteryTemperature,*,*,*,*,*,*,*,*,*) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*)) && if (batteryTemperature <=140 )) {

synchronized(_asp_properties0.lock){

_cls_properties0 _cls_inst = _cls_properties0._get_cls_properties0_inst();
_cls_inst.batteryTemperature = batteryTemperature;
_cls_inst._call(thisJoinPoint.getSignature().toString(), 34/*lowTemperature*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 34/*lowTemperature*/);
}
}
before ( double voltageCell2,double voltageCell1,double voltage) : (call(* *.updateBattery(..)) && args(*,*,*,voltage,voltageCell1,voltageCell2,*,*,*,*,*) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*)) && if ((voltage - voltageCell1 )>0.1 && (voltage - voltageCell2 )>0.1 )) {

synchronized(_asp_properties0.lock){

_cls_properties0 _cls_inst = _cls_properties0._get_cls_properties0_inst();
_cls_inst.voltageCell2 = voltageCell2;
_cls_inst.voltageCell1 = voltageCell1;
_cls_inst.voltage = voltage;
_cls_inst._call(thisJoinPoint.getSignature().toString(), 40/*veryBadCellConsistency*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 40/*veryBadCellConsistency*/);
}
}
before ( double satellites,double gpsLevel) : (call(* *.updateGPS(..)) && args(satellites,gpsLevel,*) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*)) && if (gpsLevel >3 && satellites >11 )) {

synchronized(_asp_properties0.lock){

_cls_properties0 _cls_inst = _cls_properties0._get_cls_properties0_inst();
_cls_inst.satellites = satellites;
_cls_inst.gpsLevel = gpsLevel;
_cls_inst._call(thisJoinPoint.getSignature().toString(), 54/*goodSignalGPS*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 54/*goodSignalGPS*/);
}
}
before ( double roll,double pitch) : (call(* *.updateOrientation(..)) && args(*,pitch,roll,*,*,*) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*)) && if (Math .acos (Math .cos (pitch )*Math .cos (roll ))<=15 )) {

synchronized(_asp_properties0.lock){

_cls_properties0 _cls_inst = _cls_properties0._get_cls_properties0_inst();
_cls_inst.roll = roll;
_cls_inst.pitch = pitch;
_cls_inst._call(thisJoinPoint.getSignature().toString(), 62/*lowAcceleration*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 62/*lowAcceleration*/);
}
}
before ( Clock _c, long millis) : (call(* Clock.event(long)) && args(millis) && target(_c)  && (if (_c.name.equals("c1"))) && (if (millis == 5000)) && !cflow(adviceexecution())) {

synchronized(_asp_properties0.lock){

synchronized(_c){
 if (_c != null && _c._inst != null) {
_c._inst._call(thisJoinPoint.getSignature().toString(), 64/*highAccelerationFor5s*/);
_c._inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 64/*highAccelerationFor5s*/);
}
}
}
}
before ( double batteryTemperature) : (call(* *.updateBattery(..)) && args(*,batteryTemperature,*,*,*,*,*,*,*,*,*) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*)) && if (batteryTemperature >140 )) {

synchronized(_asp_properties0.lock){

_cls_properties0 _cls_inst = _cls_properties0._get_cls_properties0_inst();
_cls_inst.batteryTemperature = batteryTemperature;
_cls_inst._call(thisJoinPoint.getSignature().toString(), 32/*highTemperature*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 32/*highTemperature*/);
}
}
before ( Clock _c, long millis) : (call(* Clock.event(long)) && args(millis) && target(_c)  && (if (_c.name.equals("dc"))) && (if (millis == 1000)) && !cflow(adviceexecution())) {

synchronized(_asp_properties0.lock){

synchronized(_c){
 if (_c != null && _c._inst != null) {
_c._inst._call(thisJoinPoint.getSignature().toString(), 76/*dataClock1*/);
_c._inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 76/*dataClock1*/);
}
}
}
}
before ( double satellites,double gpsLevel) : (call(* *.updateGPS(..)) && args(satellites,gpsLevel,*) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*)) && if (gpsLevel <3 ||satellites <9 )) {

synchronized(_asp_properties0.lock){

_cls_properties0 _cls_inst = _cls_properties0._get_cls_properties0_inst();
_cls_inst.satellites = satellites;
_cls_inst.gpsLevel = gpsLevel;
_cls_inst._call(thisJoinPoint.getSignature().toString(), 58/*veryBadSignalGPS*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 58/*veryBadSignalGPS*/);
}
}
before ( Clock _c, long millis) : (call(* Clock.event(long)) && args(millis) && target(_c)  && (if (_c.name.equals("dc10"))) && (if (millis == 10000)) && !cflow(adviceexecution())) {

synchronized(_asp_properties0.lock){

synchronized(_c){
 if (_c != null && _c._inst != null) {
_c._inst._call(thisJoinPoint.getSignature().toString(), 74/*dataClock10*/);
_c._inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 74/*dataClock10*/);
}
}
}
}
before ( double voltageCell2,double voltageCell1,double voltage) : (call(* *.updateBattery(..)) && args(*,*,*,voltage,voltageCell1,voltageCell2,*,*,*,*,*) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*)) && if ((voltage - voltageCell1 )<=0.01 && (voltage - voltageCell2 )<=0.01 )) {

synchronized(_asp_properties0.lock){

_cls_properties0 _cls_inst = _cls_properties0._get_cls_properties0_inst();
_cls_inst.voltageCell2 = voltageCell2;
_cls_inst.voltageCell1 = voltageCell1;
_cls_inst.voltage = voltage;
_cls_inst._call(thisJoinPoint.getSignature().toString(), 36/*goodCellConsistency*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 36/*goodCellConsistency*/);
}
}
before ( double rcThrottle,double rcRudder,double rcElevator,double rcAileron) : (call(* *.updateRC(..)) && args(rcElevator,rcAileron,rcThrottle,rcRudder,*,*,*,*,*) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*)) && if ((50 <=rcElevator && rcElevator <364 )||(50 <=rcAileron && rcAileron <364 )||(50 <=rcThrottle && rcThrottle <364 )||(50 <=rcRudder && rcRudder <364 ))) {

synchronized(_asp_properties0.lock){

_cls_properties0 _cls_inst = _cls_properties0._get_cls_properties0_inst();
_cls_inst.rcThrottle = rcThrottle;
_cls_inst.rcRudder = rcRudder;
_cls_inst.rcElevator = rcElevator;
_cls_inst.rcAileron = rcAileron;
_cls_inst._call(thisJoinPoint.getSignature().toString(), 44/*badSignalRC*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 44/*badSignalRC*/);
}
}
before ( double xSpeed,double zSpeed,double ySpeed) : (call(* *.updateSpeed(..)) && args(*,xSpeed,ySpeed,zSpeed) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_properties0.lock){

_cls_properties0 _cls_inst = _cls_properties0._get_cls_properties0_inst();
_cls_inst.xSpeed = xSpeed;
_cls_inst.zSpeed = zSpeed;
_cls_inst.ySpeed = ySpeed;
_cls_inst._call(thisJoinPoint.getSignature().toString(), 70/*speedChange*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 70/*speedChange*/);
}
}
before ( double gimbalRoll,double dronePitch,double gimbalPitch,double droneRoll,double droneHeading,double gimbalHeading) : (call(* *.updateOrientation(..)) && args(droneHeading,dronePitch,droneRoll,gimbalHeading,gimbalPitch,gimbalRoll) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*)) && if (Math .abs (gimbalHeading - (Math .acos (Math .cos (dronePitch )*Math .cos (droneRoll ))))>=5 ||Math .abs (gimbalPitch )>=5 )) {

synchronized(_asp_properties0.lock){

_cls_properties0 _cls_inst = _cls_properties0._get_cls_properties0_inst();
_cls_inst.gimbalRoll = gimbalRoll;
_cls_inst.dronePitch = dronePitch;
_cls_inst.gimbalPitch = gimbalPitch;
_cls_inst.droneRoll = droneRoll;
_cls_inst.droneHeading = droneHeading;
_cls_inst.gimbalHeading = gimbalHeading;
_cls_inst._call(thisJoinPoint.getSignature().toString(), 66/*lookingAway*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 66/*lookingAway*/);
}
}
before ( double gimbalRoll,double dronePitch,double gimbalPitch,double droneRoll,double droneHeading,double gimbalHeading) : (call(* *.updateOrientation(..)) && args(droneHeading,dronePitch,droneRoll,gimbalHeading,gimbalPitch,gimbalRoll) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*)) && if (Math .abs (gimbalHeading - (Math .acos (Math .cos (dronePitch )*Math .cos (droneRoll ))))<5 && Math .abs (gimbalPitch )<5 )) {

synchronized(_asp_properties0.lock){

_cls_properties0 _cls_inst = _cls_properties0._get_cls_properties0_inst();
_cls_inst.gimbalRoll = gimbalRoll;
_cls_inst.dronePitch = dronePitch;
_cls_inst.gimbalPitch = gimbalPitch;
_cls_inst.droneRoll = droneRoll;
_cls_inst.droneHeading = droneHeading;
_cls_inst.gimbalHeading = gimbalHeading;
_cls_inst._call(thisJoinPoint.getSignature().toString(), 68/*looking*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 68/*looking*/);
}
}
before ( double roll,double pitch) : (call(* *.updateOrientation(..)) && args(*,pitch,roll,*,*,*) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*)) && if (Math .acos (Math .cos (pitch )*Math .cos (roll ))>15 )) {

synchronized(_asp_properties0.lock){

_cls_properties0 _cls_inst = _cls_properties0._get_cls_properties0_inst();
_cls_inst.roll = roll;
_cls_inst.pitch = pitch;
_cls_inst._call(thisJoinPoint.getSignature().toString(), 60/*highAcceleration*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 60/*highAcceleration*/);
}
}
before ( double rcThrottle,double rcRudder,double rcElevator,double rcAileron) : (call(* *.updateRC(..)) && args(rcElevator,rcAileron,rcThrottle,rcRudder,*,*,*,*,*) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*)) && if (rcElevator <50 ||rcAileron <50 ||rcThrottle <50 ||rcRudder <50 )) {

synchronized(_asp_properties0.lock){

_cls_properties0 _cls_inst = _cls_properties0._get_cls_properties0_inst();
_cls_inst.rcThrottle = rcThrottle;
_cls_inst.rcRudder = rcRudder;
_cls_inst.rcElevator = rcElevator;
_cls_inst.rcAileron = rcAileron;
_cls_inst._call(thisJoinPoint.getSignature().toString(), 46/*veryBadSignalRC*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 46/*veryBadSignalRC*/);
}
}
before ( double batteryTemperature,double batteryPercentage,LocalTime time) : (call(* *.updateBattery(..)) && args(batteryPercentage,batteryTemperature,*,*,*,*,*,*,*,*,time) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_properties0.lock){

_cls_properties0 _cls_inst = _cls_properties0._get_cls_properties0_inst();
_cls_inst.batteryTemperature = batteryTemperature;
_cls_inst.batteryPercentage = batteryPercentage;
_cls_inst.time = time;
_cls_inst._call(thisJoinPoint.getSignature().toString(), 4/*dataBattery*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 4/*dataBattery*/);
}
}
before ( double altTakeoff,double altSea) : (call(* *.updateAltitude(..)) && args(altTakeoff,altSea,*,*) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*)) && if (altTakeoff >=10 )) {

synchronized(_asp_properties0.lock){

_cls_properties0 _cls_inst = _cls_properties0._get_cls_properties0_inst();
_cls_inst.altTakeoff = altTakeoff;
_cls_inst.altSea = altSea;
_cls_inst._call(thisJoinPoint.getSignature().toString(), 26/*normalAltitude*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 26/*normalAltitude*/);
}
}
before ( double distance,double latitude,LocalTime time,double longitude) : (call(* *.updateLocation(..)) && args(distance,longitude,latitude,time) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_properties0.lock){

_cls_properties0 _cls_inst = _cls_properties0._get_cls_properties0_inst();
_cls_inst.distance = distance;
_cls_inst.latitude = latitude;
_cls_inst.time = time;
_cls_inst.longitude = longitude;
_cls_inst._call(thisJoinPoint.getSignature().toString(), 0/*dataLocation*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 0/*dataLocation*/);
}
}
before ( double speed) : (call(* *.updateSpeed(..)) && args(speed,*,*,*) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*)) && if (speed >42.5 )) {

synchronized(_asp_properties0.lock){

_cls_properties0 _cls_inst = _cls_properties0._get_cls_properties0_inst();
_cls_inst.speed = speed;
_cls_inst._call(thisJoinPoint.getSignature().toString(), 50/*highSpeed*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 50/*highSpeed*/);
}
}
before ( double distance) : (call(* *.updateLocation(..)) && args(distance,*,*,*) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*)) && if (distance <=115 )) {

synchronized(_asp_properties0.lock){

_cls_properties0 _cls_inst = _cls_properties0._get_cls_properties0_inst();
_cls_inst.distance = distance;
_cls_inst._call(thisJoinPoint.getSignature().toString(), 20/*inDistance*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 20/*inDistance*/);
}
}
before ( Clock _c, long millis) : (call(* Clock.event(long)) && args(millis) && target(_c)  && (if (_c.name.equals("c2"))) && (if (millis == 30000)) && !cflow(adviceexecution())) {

synchronized(_asp_properties0.lock){

synchronized(_c){
 if (_c != null && _c._inst != null) {
_c._inst._call(thisJoinPoint.getSignature().toString(), 72/*windTimerElapsed*/);
_c._inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 72/*windTimerElapsed*/);
}
}
}
}
before ( String flycState) : (call(* *.updateFlightControl(..)) && args(*,flycState) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*)) && if (flycState .equals ("Confirm_Landing"))) {

synchronized(_asp_properties0.lock){

_cls_properties0 _cls_inst = _cls_properties0._get_cls_properties0_inst();
_cls_inst.flycState = flycState;
_cls_inst._call(thisJoinPoint.getSignature().toString(), 12/*landing*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 12/*landing*/);
}
}
before ( double batteryPercentage) : (call(* *.updateBattery(..)) && args(batteryPercentage,*,*,*,*,*,*,*,*,*,*) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*)) && if (batteryPercentage <20 )) {

synchronized(_asp_properties0.lock){

_cls_properties0 _cls_inst = _cls_properties0._get_cls_properties0_inst();
_cls_inst.batteryPercentage = batteryPercentage;
_cls_inst._call(thisJoinPoint.getSignature().toString(), 30/*lowCharge*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 30/*lowCharge*/);
}
}
before ( String signal,Channel _c) : (call(* Channel.receive(..)) && target(_c) && (if (_c.equals(_cls_properties0.d))) && args(signal)) {

synchronized(_asp_properties0.lock){

_cls_properties0 _cls_inst = _cls_properties0._get_cls_properties0_inst();
_cls_inst.signal = signal;
_cls_properties0._call_all(thisJoinPoint.getSignature().toString(), 48/*channelD*/);
}
}
before ( String flycState) : (call(* *.updateFlightControl(..)) && args(*,flycState) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*)) && if (flycState .equals ("Motors_Started"))) {

synchronized(_asp_properties0.lock){

_cls_properties0 _cls_inst = _cls_properties0._get_cls_properties0_inst();
_cls_inst.flycState = flycState;
_cls_inst._call(thisJoinPoint.getSignature().toString(), 10/*takeOff*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 10/*takeOff*/);
}
}
before ( double latitude,double longitude) : (call(* *.updateLocation(..)) && args(*,latitude,longitude,*) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*)) && if (((35.831 <latitude )&& (latitude <35.865 ))&& ((14.456 <longitude )&& (longitude <14.511 )))) {

synchronized(_asp_properties0.lock){

_cls_properties0 _cls_inst = _cls_properties0._get_cls_properties0_inst();
_cls_inst.latitude = latitude;
_cls_inst.longitude = longitude;
_cls_inst._call(thisJoinPoint.getSignature().toString(), 14/*intoRestricted*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 14/*intoRestricted*/);
}
}
before ( double rcThrottle,double rcRudder,LocalTime time,double rcElevator,double rcAileron) : (call(* *.updateRC(..)) && args(rcElevator,rcAileron,rcThrottle,rcRudder,*,*,*,*,time) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_properties0.lock){

_cls_properties0 _cls_inst = _cls_properties0._get_cls_properties0_inst();
_cls_inst.rcThrottle = rcThrottle;
_cls_inst.rcRudder = rcRudder;
_cls_inst.time = time;
_cls_inst.rcElevator = rcElevator;
_cls_inst.rcAileron = rcAileron;
_cls_inst._call(thisJoinPoint.getSignature().toString(), 6/*dataRC*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 6/*dataRC*/);
}
}
before ( double satellites,double gpsLevel) : (call(* *.updateGPS(..)) && args(satellites,gpsLevel,*) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*)) && if (gpsLevel ==3 ||satellites <=11 )) {

synchronized(_asp_properties0.lock){

_cls_properties0 _cls_inst = _cls_properties0._get_cls_properties0_inst();
_cls_inst.satellites = satellites;
_cls_inst.gpsLevel = gpsLevel;
_cls_inst._call(thisJoinPoint.getSignature().toString(), 56/*badSignalGPS*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 56/*badSignalGPS*/);
}
}
before ( double distance) : (call(* *.updateLocation(..)) && args(distance,*,*,*) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*)) && if (distance >115 )) {

synchronized(_asp_properties0.lock){

_cls_properties0 _cls_inst = _cls_properties0._get_cls_properties0_inst();
_cls_inst.distance = distance;
_cls_inst._call(thisJoinPoint.getSignature().toString(), 18/*outDistance*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 18/*outDistance*/);
}
}
before ( double rcThrottle,double rcRudder,double rcElevator,double rcAileron) : (call(* *.updateRC(..)) && args(rcElevator,rcAileron,rcThrottle,rcRudder,*,*,*,*,*) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*)) && if (rcElevator >=364 && rcAileron >=364 && rcThrottle >=364 && rcRudder >=364 )) {

synchronized(_asp_properties0.lock){

_cls_properties0 _cls_inst = _cls_properties0._get_cls_properties0_inst();
_cls_inst.rcThrottle = rcThrottle;
_cls_inst.rcRudder = rcRudder;
_cls_inst.rcElevator = rcElevator;
_cls_inst.rcAileron = rcAileron;
_cls_inst._call(thisJoinPoint.getSignature().toString(), 42/*goodSignalRC*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 42/*goodSignalRC*/);
}
}
before ( double satellites,double gpsLevel,LocalTime time) : (call(* *.updateGPS(..)) && args(satellites,gpsLevel,time) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_properties0.lock){

_cls_properties0 _cls_inst = _cls_properties0._get_cls_properties0_inst();
_cls_inst.satellites = satellites;
_cls_inst.gpsLevel = gpsLevel;
_cls_inst.time = time;
_cls_inst._call(thisJoinPoint.getSignature().toString(), 8/*dataGPS*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 8/*dataGPS*/);
}
}
before ( double altTakeoff,double altSea) : (call(* *.updateAltitude(..)) && args(altTakeoff,altSea,*,*) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*)) && if (altTakeoff <=60 )) {

synchronized(_asp_properties0.lock){

_cls_properties0 _cls_inst = _cls_properties0._get_cls_properties0_inst();
_cls_inst.altTakeoff = altTakeoff;
_cls_inst.altSea = altSea;
_cls_inst._call(thisJoinPoint.getSignature().toString(), 24/*lowAltitude*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 24/*lowAltitude*/);
}
}
before ( double voltageCell2,double voltageCell1,double voltage) : (call(* *.updateBattery(..)) && args(*,*,*,voltage,voltageCell1,voltageCell2,*,*,*,*,*) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*)) && if ((voltage - voltageCell1 )>0.01 && (voltage - voltageCell2 )>0.01 )) {

synchronized(_asp_properties0.lock){

_cls_properties0 _cls_inst = _cls_properties0._get_cls_properties0_inst();
_cls_inst.voltageCell2 = voltageCell2;
_cls_inst.voltageCell1 = voltageCell1;
_cls_inst.voltage = voltage;
_cls_inst._call(thisJoinPoint.getSignature().toString(), 38/*badCellConsistency*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 38/*badCellConsistency*/);
}
}
before ( double latitude,double longitude) : (call(* *.updateLocation(..)) && args(*,latitude,longitude,*) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*)) && if (((35.831 >=latitude )||(latitude >=35.865 ))||((14.456 >=longitude )||(longitude >=14.511 )))) {

synchronized(_asp_properties0.lock){

_cls_properties0 _cls_inst = _cls_properties0._get_cls_properties0_inst();
_cls_inst.latitude = latitude;
_cls_inst.longitude = longitude;
_cls_inst._call(thisJoinPoint.getSignature().toString(), 16/*outRestricted*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 16/*outRestricted*/);
}
}
before ( double altTakeoff,double altSea) : (call(* *.updateAltitude(..)) && args(altTakeoff,altSea,*,*) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*)) && if (altTakeoff >60 )) {

synchronized(_asp_properties0.lock){

_cls_properties0 _cls_inst = _cls_properties0._get_cls_properties0_inst();
_cls_inst.altTakeoff = altTakeoff;
_cls_inst.altSea = altSea;
_cls_inst._call(thisJoinPoint.getSignature().toString(), 22/*highAltitude*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 22/*highAltitude*/);
}
}
before ( double altitude,LocalTime time) : (call(* *.updateAltitude(..)) && args(altitude,*,*,time) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_properties0.lock){

_cls_properties0 _cls_inst = _cls_properties0._get_cls_properties0_inst();
_cls_inst.altitude = altitude;
_cls_inst.time = time;
_cls_inst._call(thisJoinPoint.getSignature().toString(), 2/*dataAltitude*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 2/*dataAltitude*/);
}
}
before ( double speed) : (call(* *.updateSpeed(..)) && args(speed,*,*,*) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*)) && if (speed <=42.5 )) {

synchronized(_asp_properties0.lock){

_cls_properties0 _cls_inst = _cls_properties0._get_cls_properties0_inst();
_cls_inst.speed = speed;
_cls_inst._call(thisJoinPoint.getSignature().toString(), 52/*lowSpeed*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 52/*lowSpeed*/);
}
}
}