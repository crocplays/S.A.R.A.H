from socket import *
import time ,os


class Server():

    def __init__(self):
        self.port = 4320
        self.ip = "0.0.0.0"
        self.sock = socket(AF_INET,SOCK_STREAM)
        self.sock.bind((self.ip,self.port))
        self.sock.listen(1)
        self.conn , self.addr = self.sock.accept()
        print "Connected"

    def Read(self):
        return self.conn.recv(1024)
    def close(self):
        self.conn.close()
