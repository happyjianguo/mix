import sys
import traceback


def save_if_allowed(fn):
    def wrapped(*args, **kwargs):
        try:
            return fn(*args, **kwargs)
        except Exception as exc:
            raise
            return None
    return wrapped


@save_if_allowed
def stuff():
    raise Exception("stuff")


def foo():
    stuff()

foo()
