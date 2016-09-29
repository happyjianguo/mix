# -*- coding: utf-8 -*-
from __future__ import unicode_literals

from django.db import models

# Create your models here.


class Article(models.Model):
    title = models.CharField(u'title', max_length=256)
    content = models.TextField(u'content')

    pub_date = models.DateTimeField(
        u'pub_date', auto_now_add=True, editable=True)
    update_time = models.DateTimeField(
        u'update_date', auto_now=True, null=True)
