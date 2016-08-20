#!/bin/env python
# -*- encoding: utf-8 -*-

from sqlalchemy import *
from sqlalchemy.orm import *
from User import User

db_config = {
    'host': '127.0.0.1',
    'user': 'root',
    'passwd': '',
    'db': 'test',
    'charset': 'utf8'
}
engine = create_engine('mysql://%s:%s@%s/%s?charset=%s' % (db_config['user'],
                                                           db_config['passwd'],
                                                           db_config['host'],
                                                           db_config['db'],
                                                           db_config['charset']), echo=True)

metadata = MetaData(engine)
users_table = Table("users", metadata, autoload=true)

mapper(User, users_table)

Session = sessionmaker(bind=engine)
session = Session
session.add_all([
    User('wendy', 'Wendy Williams', 'foobar'),
    User('mary', 'Mary Contrary', 'xxg527'),
    User('fred', 'Fred Flinstone', 'blah')
])
session.commit()



