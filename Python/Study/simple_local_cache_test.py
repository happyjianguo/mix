#!/usr/bin/env python
# -*- coding: utf-8 -*-

from SimpleLocalCache import SimpleCache, scache

@scache
def func():
    return 'OK'

func()
