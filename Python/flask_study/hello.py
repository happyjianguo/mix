#!/usr/bin/env python
# -*- coding: utf-8 -*-

from flask import Flask, url_for, render_template, request, make_response
import logging
app = Flask(__name__)


@app.route('/')
def hello_world():
    return 'Hello, world!'


@app.route('/hello')
@app.route('/hello/<name>')
def hello(name=None):
    resp = make_response(render_template('hello.html'))
    resp.set_cookie('username', 'the username')
    username = request.cookies.get('username')
    print username
    return resp


@app.route('/user/<username>')
def show_user_profile(username):
    return 'User %s' % username


@app.route('/login', methods=['POST', 'GET'])
def login():
    error = None
    if request.method == 'GET':
        return render_template('login.html', error=error)


if __name__ == '__main__':
    app.debug = True
    if not app.debug:
        from themodule import SysLogHandler
        file_handler = SysLogHandler()
        file_handler.setLevel(logging.WARNING)
        app.logger.addHandler(file_handler)
    app.run()
