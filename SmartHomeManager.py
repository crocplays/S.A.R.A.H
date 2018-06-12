from DeviceControl import *
import time,datetime
from numpy import *



dev = Device(0,"Light")

#dev.secondsControl(5)

#time.sleep(2)

#dev.minutesControl(1)

#x = range(168)
#x = reshape(x,(24,7))

r = 7
c = 24
x = [0] * r
for i in range(r):
    x[i] = [0] * c


print x
