#!/bin/env python
#-*- encoding: utf-8 -*-


class User(object):
    def __int__(self,name,fullname,password):
        self.name=name
        self.fullname=fullname
        self.password=password

    def __repr__(self):
         return "<User('%s','%s','%s')>" % (self.name,self.fullname,self.password)
