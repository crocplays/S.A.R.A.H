from DeviceControl import *
import Server
import time,datetime,threading
from numpy import *


dev = Device(0,"Light")
serv = Server.Server()

try:
    while True:
        data = serv.Read()
        print data[2:]
        if  "on" in data:
            dev.toggleOn()
        elif "off" in data:
            dev.toggleOff()
        elif data[2:7] == "Timer":
            dev.minutesControl(int(data[8:]))
except Exception, e:
    print e
finally:
    serv.close()
