#!/usr/bin/env python
# -*- coding: utf-8 -*-


def lazy_property(func):
    attr_name = "__lazy__" + func.__name__

    @property
    def __lazy_property(self):
        if not hasattr(self, attr_name):
            setattr(self, attr_name, func(self))
        return getattr(self, attr_name)
    return __lazy_property


class Circle(object):

    def __init__(self, radius):
        self.radius = radius

    @lazy_property
    def area(self):
        print 'evalute'
        return 3.14 * self.radius ** 2

c = Circle(4)
print 'before first visit'
print c.__dict__
c.area
print 'after first visit'
print c.__dict__
