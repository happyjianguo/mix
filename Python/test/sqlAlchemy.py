#!/usr/bin/env python
# -*- coding: utf-8 -*-

import sys
from sqlalchemy import create_engine
from sqlalchemy.orm import sessionmaker
from sqlalchemy.exc import SQLAlchemyError
from sqlalchemy.ext.declarative import declarative_base
from sqlalchemy import (
    CHAR,
    BIGINT,
    BigInteger,
    Column,
    Date,
    DateTime,
    Float,
    Integer,
    String,
)

Engine = create_engine('mysql+pymysql://eleme:eleme@127.0.0.1/dev_vagrant_zeus?charset=utf8', echo=True)
Engine2 = create_engine('mysql+pymysql://eleme:eleme@127.0.0.1/test?charset=utf8', echo=True)

Session = sessionmaker(twophase=True)

BaseModel = declarative_base()


class User(BaseModel):
    __tablename__ = 'user'

    id = Column(String, primary_key=True)
    username = Column(String, index=True)


class Blog(BaseModel):
    __tablename__ = 'blog'

    id = Column(CHAR(32), primary_key=True)
    title = Column(String(64), server_default='', nullable=False)
    text = Column(String, server_default='', nullable=False)
    user = Column(CHAR(32), index=True, server_default='', nullable=False)


Session.configure(binds={Blog: Engine, User: Engine2})

session = Session()



##事务测试

user = User(username=u'test0801',id=11)
blog = Blog(id=11,title="test_title0801",text="test_text_100",user="joshua100")
session.add(blog)
sys.exit(1)
session.add(user)
session.commit()