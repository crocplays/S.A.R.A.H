import serial,time,os,struct,datetime
from numpy import *

class Device():
    def __init__(self,port,device_type):
        """Initializes the device with given USB port and device type"""
        self.sStart = datetime.datetime.now()
        self.sStop = datetime.datetime.now()
        self.sTime = self.sStop-self.sStart
        self.dtype = device_type
        self.ser = serial.Serial()
        self.ser.port = "/dev/ttyUSB" + str(port)
        self.ser.baudrate = 9600
        self.ser.bytesize = serial.EIGHTBITS
        self.ser.parity = serial.PARITY_NONE
        self.ser.timeout = 1
        self.ser.xonxoff = True
        self.ser.rtscts = False        #disable hardware RTS/CTS flow control
        self.ser.dsrdtr = False        #disable hardware DSR/DTR flow control
        self.ser.writeTimeout = 2      #write timeout
        try:
            self.ser.open()            #opens communication with device
            self.ser.write("\xA0\x01\x00\xA1")

        except Exception, e:
            print "error open serial port: " + str(e)
            exit()

        if self.ser.isOpen():
            try:
                self.ser.flushInput()    #flush input buffer
                self.ser.flushOutput()   #flush output buffer
            except:
                pass


    def getDeviceType(self):
        """Returns the device type"""
        return self.dtype

    def toggleOff(self):
        """Toggles the device off"""
        self.ser.write("\xA0\x01\x00\xA1")
        self.sStop = datetime.datetime.now()
        self.sTime = self.sStop - self.sStart

    def toggleOn(self):
        """Toggles the device on"""
        self.ser.write("\xA0\x01\x01\xA2")
        self.sStart = datetime.datetime.now()

    def getSessionTime(self):
        """Returns the length of the devices last active-duty session"""
        return self.sTime

    def secondsControl(self,seconds):
        self.ser.write("\xA0\x01\x01\xA2")
        time.sleep(seconds)
        self.ser.write("\xA0\x01\x00\xA1")

    def minutesControl(self,minutes):
        self.secondsControl(minutes*60)

    def hoursControl(self,hours):
        self.minutesControl(hours*60)

    def scheduleControl(self,timeTable):
        for i in range(7):
            for j in range(24):
                if(timeTable[j][i] == 1):
                    self.toggleOn()
                    time.sleep(60*60*60)
                else:
                    self.toggleOff()
                    time.sleep(60*60*60)
